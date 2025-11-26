package org.jboss.netty.channel.socket.http;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.net.SocketAddress;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.channel.local.DefaultLocalClientChannelFactory;
import org.jboss.netty.channel.local.LocalAddress;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

/* loaded from: classes.dex */
public class HttpTunnelingServlet extends HttpServlet {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final String ENDPOINT = "endpoint";
    static final InternalLogger logger;
    private static final long serialVersionUID = 4259910275899756070L;
    private volatile ChannelFactory channelFactory;
    private volatile SocketAddress remoteAddress;

    static {
        $assertionsDisabled = !HttpTunnelingServlet.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(HttpTunnelingServlet.class);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.servlet.ServletException */
    public void init() throws ServletException {
        String initParameter = getServletConfig().getInitParameter(ENDPOINT);
        if (initParameter == null) {
            throw new ServletException("init-param 'endpoint' must be specified.");
        }
        try {
            this.remoteAddress = parseEndpoint(initParameter.trim());
            try {
                this.channelFactory = createChannelFactory(this.remoteAddress);
            } catch (Exception e) {
                throw new ServletException("Failed to create a channel factory.", e);
            } catch (ServletException e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw new ServletException("Failed to parse an endpoint.", e3);
        } catch (ServletException e4) {
            throw e4;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.servlet.ServletException */
    protected SocketAddress parseEndpoint(String str) throws ServletException {
        if (str.startsWith("local:")) {
            return new LocalAddress(str.substring(6).trim());
        }
        throw new ServletException("Invalid or unknown endpoint: " + str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.servlet.ServletException */
    protected ChannelFactory createChannelFactory(SocketAddress socketAddress) throws ServletException {
        if (socketAddress instanceof LocalAddress) {
            return new DefaultLocalClientChannelFactory();
        }
        throw new ServletException("Unsupported remote address type: " + socketAddress.getClass().getName());
    }

    public void destroy() {
        try {
            destroyChannelFactory(this.channelFactory);
        } catch (Exception e) {
            logger.warn("Failed to destroy a channel factory.", e);
        }
    }

    protected void destroyChannelFactory(ChannelFactory channelFactory) {
        channelFactory.releaseExternalResources();
    }

    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        if (!"POST".equalsIgnoreCase(httpServletRequest.getMethod())) {
            logger.warn("Unallowed method: " + httpServletRequest.getMethod());
            httpServletResponse.sendError(405);
            return;
        }
        ChannelPipeline channelPipelinePipeline = Channels.pipeline();
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        channelPipelinePipeline.addLast("handler", new OutboundConnectionHandler(outputStream));
        Channel channelNewChannel = this.channelFactory.newChannel(channelPipelinePipeline);
        ChannelFuture channelFutureAwaitUninterruptibly = channelNewChannel.connect(this.remoteAddress).awaitUninterruptibly();
        if (!channelFutureAwaitUninterruptibly.isSuccess()) {
            Throwable cause = channelFutureAwaitUninterruptibly.getCause();
            logger.warn("Endpoint unavailable: " + cause.getMessage(), cause);
            httpServletResponse.sendError(503);
            return;
        }
        ChannelFuture channelFutureWrite = null;
        try {
            httpServletResponse.setStatus(200);
            httpServletResponse.setHeader("Content-Type", "application/octet-stream");
            httpServletResponse.setHeader(HttpHeaders.Names.CONTENT_TRANSFER_ENCODING, HttpHeaders.Values.BINARY);
            outputStream.flush();
            PushbackInputStream pushbackInputStream = new PushbackInputStream(httpServletRequest.getInputStream());
            while (channelNewChannel.isConnected()) {
                try {
                    ChannelBuffer channelBuffer = read(pushbackInputStream);
                    if (channelBuffer == null) {
                        break;
                    } else {
                        channelFutureWrite = channelNewChannel.write(channelBuffer);
                    }
                } catch (EOFException e) {
                }
            }
        } finally {
            if (channelFutureWrite == null) {
                channelNewChannel.close();
            } else {
                channelFutureWrite.addListener(ChannelFutureListener.CLOSE);
            }
        }
    }

    private static ChannelBuffer read(PushbackInputStream pushbackInputStream) throws IOException {
        int i;
        byte[] bArr;
        int i2;
        int iAvailable = pushbackInputStream.available();
        if (iAvailable > 0) {
            bArr = new byte[iAvailable];
            i2 = pushbackInputStream.read(bArr);
        } else {
            if (iAvailable != 0 || (i = pushbackInputStream.read()) < 0 || pushbackInputStream.available() < 0) {
                return null;
            }
            pushbackInputStream.unread(i);
            bArr = new byte[pushbackInputStream.available()];
            i2 = pushbackInputStream.read(bArr);
        }
        if (!$assertionsDisabled && i2 <= 0) {
            throw new AssertionError();
        }
        if (i2 == bArr.length) {
            return ChannelBuffers.wrappedBuffer(bArr);
        }
        return ChannelBuffers.wrappedBuffer(bArr, 0, i2);
    }

    final class OutboundConnectionHandler extends SimpleChannelUpstreamHandler {
        private final ServletOutputStream out;

        public OutboundConnectionHandler(ServletOutputStream servletOutputStream) {
            this.out = servletOutputStream;
        }

        @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
        public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
            ChannelBuffer channelBuffer = (ChannelBuffer) messageEvent.getMessage();
            synchronized (this) {
                channelBuffer.readBytes((OutputStream) this.out, channelBuffer.readableBytes());
                this.out.flush();
            }
        }

        @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
            HttpTunnelingServlet.logger.warn("Unexpected exception while HTTP tunneling", exceptionEvent.getCause());
            exceptionEvent.getChannel().close();
        }
    }
}
