package org.jboss.netty.channel.socket.http;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.NotYetConnectedException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.AbstractChannel;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.DefaultChannelPipeline;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.channel.socket.ClientSocketChannelFactory;
import org.jboss.netty.channel.socket.SocketChannel;
import org.jboss.netty.handler.codec.http.DefaultHttpChunk;
import org.jboss.netty.handler.codec.http.DefaultHttpRequest;
import org.jboss.netty.handler.codec.http.HttpChunk;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.jboss.netty.handler.codec.http.HttpMethod;
import org.jboss.netty.handler.codec.http.HttpRequestEncoder;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.handler.codec.http.HttpResponseDecoder;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.jboss.netty.handler.codec.http.HttpVersion;
import org.jboss.netty.handler.ssl.SslHandler;

/* loaded from: classes.dex */
class HttpTunnelingClientSocketChannel extends AbstractChannel implements SocketChannel {
    final HttpTunnelingSocketChannelConfig config;
    private final ServletChannelHandler handler;
    final Object interestOpsLock;
    final SocketChannel realChannel;
    volatile boolean requestHeaderWritten;

    final class ServletChannelHandler extends SimpleChannelUpstreamHandler {
        private volatile boolean readingChunks;
        final SocketChannel virtualChannel;

        ServletChannelHandler() {
            this.virtualChannel = HttpTunnelingClientSocketChannel.this;
        }

        @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
        public void channelBound(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
            Channels.fireChannelBound(this.virtualChannel, (SocketAddress) channelStateEvent.getValue());
        }

        @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
        public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
            Channels.fireChannelClosed(this.virtualChannel);
        }

        @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
        public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
            Channels.fireChannelDisconnected(this.virtualChannel);
        }

        @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
        public void channelInterestChanged(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
            Channels.fireChannelInterestChanged(this.virtualChannel);
        }

        @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
        public void channelUnbound(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
            Channels.fireChannelUnbound(this.virtualChannel);
        }

        @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
            Channels.fireExceptionCaught(this.virtualChannel, exceptionEvent.getCause());
            HttpTunnelingClientSocketChannel.this.realChannel.close();
        }

        @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
        public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
            if (this.readingChunks) {
                HttpChunk httpChunk = (HttpChunk) messageEvent.getMessage();
                if (!httpChunk.isLast()) {
                    Channels.fireMessageReceived(HttpTunnelingClientSocketChannel.this, httpChunk.getContent());
                    return;
                } else {
                    this.readingChunks = false;
                    HttpTunnelingClientSocketChannel.this.closeReal(Channels.succeededFuture(this.virtualChannel));
                    return;
                }
            }
            HttpResponse httpResponse = (HttpResponse) messageEvent.getMessage();
            if (httpResponse.getStatus().getCode() != HttpResponseStatus.f4578OK.getCode()) {
                throw new ChannelException("Unexpected HTTP response status: " + httpResponse.getStatus());
            }
            if (httpResponse.isChunked()) {
                this.readingChunks = true;
                return;
            }
            ChannelBuffer content = httpResponse.getContent();
            if (content.readable()) {
                Channels.fireMessageReceived(HttpTunnelingClientSocketChannel.this, content);
            }
            HttpTunnelingClientSocketChannel.this.closeReal(Channels.succeededFuture(this.virtualChannel));
        }
    }

    HttpTunnelingClientSocketChannel(ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink, ClientSocketChannelFactory clientSocketChannelFactory) {
        super(null, channelFactory, channelPipeline, channelSink);
        this.interestOpsLock = new Object();
        this.handler = new ServletChannelHandler();
        this.config = new HttpTunnelingSocketChannelConfig(this);
        DefaultChannelPipeline defaultChannelPipeline = new DefaultChannelPipeline();
        defaultChannelPipeline.addLast("decoder", new HttpResponseDecoder());
        defaultChannelPipeline.addLast("encoder", new HttpRequestEncoder());
        defaultChannelPipeline.addLast("handler", this.handler);
        this.realChannel = clientSocketChannelFactory.newChannel((ChannelPipeline) defaultChannelPipeline);
        Channels.fireChannelOpen(this);
    }

    private ChannelFuture writeLastChunk() {
        if (this.requestHeaderWritten) {
            return this.realChannel.write(HttpChunk.LAST_CHUNK);
        }
        throw new NotYetConnectedException();
    }

    void bindReal(SocketAddress socketAddress, final ChannelFuture channelFuture) {
        this.realChannel.bind(socketAddress).addListener(new ChannelFutureListener() { // from class: org.jboss.netty.channel.socket.http.HttpTunnelingClientSocketChannel.1
            @Override // org.jboss.netty.channel.ChannelFutureListener
            public void operationComplete(ChannelFuture channelFuture2) {
                if (channelFuture2.isSuccess()) {
                    channelFuture.setSuccess();
                } else {
                    channelFuture.setFailure(channelFuture2.getCause());
                }
            }
        });
    }

    void closeReal(final ChannelFuture channelFuture) {
        writeLastChunk().addListener(new ChannelFutureListener() { // from class: org.jboss.netty.channel.socket.http.HttpTunnelingClientSocketChannel.7
            @Override // org.jboss.netty.channel.ChannelFutureListener
            public void operationComplete(ChannelFuture channelFuture2) {
                HttpTunnelingClientSocketChannel.this.realChannel.close().addListener(new ChannelFutureListener() { // from class: org.jboss.netty.channel.socket.http.HttpTunnelingClientSocketChannel.7.1
                    @Override // org.jboss.netty.channel.ChannelFutureListener
                    public void operationComplete(ChannelFuture channelFuture3) {
                        if (channelFuture3.isSuccess()) {
                            channelFuture.setSuccess();
                        } else {
                            channelFuture.setFailure(channelFuture3.getCause());
                        }
                        HttpTunnelingClientSocketChannel.this.setClosed();
                    }
                });
            }
        });
    }

    void connectReal(final SocketAddress socketAddress, final ChannelFuture channelFuture) {
        this.realChannel.connect(socketAddress).addListener(new ChannelFutureListener() { // from class: org.jboss.netty.channel.socket.http.HttpTunnelingClientSocketChannel.2
            @Override // org.jboss.netty.channel.ChannelFutureListener
            public void operationComplete(ChannelFuture channelFuture2) {
                ChannelFuture channelFutureHandshake;
                String serverName = HttpTunnelingClientSocketChannel.this.config.getServerName();
                int port = ((InetSocketAddress) socketAddress).getPort();
                String serverPath = HttpTunnelingClientSocketChannel.this.config.getServerPath();
                if (!channelFuture2.isSuccess()) {
                    channelFuture.setFailure(channelFuture2.getCause());
                    Channels.fireExceptionCaught(this, channelFuture2.getCause());
                    return;
                }
                SSLContext sslContext = HttpTunnelingClientSocketChannel.this.config.getSslContext();
                if (sslContext != null) {
                    SSLEngine sSLEngineCreateSSLEngine = serverName != null ? sslContext.createSSLEngine(serverName, port) : sslContext.createSSLEngine();
                    sSLEngineCreateSSLEngine.setUseClientMode(true);
                    sSLEngineCreateSSLEngine.setEnableSessionCreation(HttpTunnelingClientSocketChannel.this.config.isEnableSslSessionCreation());
                    String[] enabledSslCipherSuites = HttpTunnelingClientSocketChannel.this.config.getEnabledSslCipherSuites();
                    if (enabledSslCipherSuites != null) {
                        sSLEngineCreateSSLEngine.setEnabledCipherSuites(enabledSslCipherSuites);
                    }
                    String[] enabledSslProtocols = HttpTunnelingClientSocketChannel.this.config.getEnabledSslProtocols();
                    if (enabledSslProtocols != null) {
                        sSLEngineCreateSSLEngine.setEnabledProtocols(enabledSslProtocols);
                    }
                    SslHandler sslHandler = new SslHandler(sSLEngineCreateSSLEngine);
                    HttpTunnelingClientSocketChannel.this.realChannel.getPipeline().addFirst("ssl", sslHandler);
                    channelFutureHandshake = sslHandler.handshake();
                } else {
                    channelFutureHandshake = null;
                }
                final DefaultHttpRequest defaultHttpRequest = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.POST, serverPath);
                if (serverName != null) {
                    defaultHttpRequest.setHeader("Host", serverName);
                }
                defaultHttpRequest.setHeader("Content-Type", "application/octet-stream");
                defaultHttpRequest.setHeader(HttpHeaders.Names.TRANSFER_ENCODING, HttpHeaders.Values.CHUNKED);
                defaultHttpRequest.setHeader(HttpHeaders.Names.CONTENT_TRANSFER_ENCODING, HttpHeaders.Values.BINARY);
                defaultHttpRequest.setHeader("User-Agent", HttpTunnelingClientSocketChannel.class.getName());
                if (channelFutureHandshake != null) {
                    channelFutureHandshake.addListener(new ChannelFutureListener() { // from class: org.jboss.netty.channel.socket.http.HttpTunnelingClientSocketChannel.2.1
                        @Override // org.jboss.netty.channel.ChannelFutureListener
                        public void operationComplete(ChannelFuture channelFuture3) {
                            if (!channelFuture3.isSuccess()) {
                                channelFuture.setFailure(channelFuture3.getCause());
                                Channels.fireExceptionCaught(this, channelFuture3.getCause());
                            } else {
                                HttpTunnelingClientSocketChannel.this.realChannel.write(defaultHttpRequest);
                                HttpTunnelingClientSocketChannel.this.requestHeaderWritten = true;
                                channelFuture.setSuccess();
                                Channels.fireChannelConnected(this, socketAddress);
                            }
                        }
                    });
                    return;
                }
                HttpTunnelingClientSocketChannel.this.realChannel.write(defaultHttpRequest);
                HttpTunnelingClientSocketChannel.this.requestHeaderWritten = true;
                channelFuture.setSuccess();
                Channels.fireChannelConnected(this, socketAddress);
            }
        });
    }

    void disconnectReal(final ChannelFuture channelFuture) {
        writeLastChunk().addListener(new ChannelFutureListener() { // from class: org.jboss.netty.channel.socket.http.HttpTunnelingClientSocketChannel.5
            @Override // org.jboss.netty.channel.ChannelFutureListener
            public void operationComplete(ChannelFuture channelFuture2) {
                HttpTunnelingClientSocketChannel.this.realChannel.disconnect().addListener(new ChannelFutureListener() { // from class: org.jboss.netty.channel.socket.http.HttpTunnelingClientSocketChannel.5.1
                    @Override // org.jboss.netty.channel.ChannelFutureListener
                    public void operationComplete(ChannelFuture channelFuture3) {
                        if (channelFuture3.isSuccess()) {
                            channelFuture.setSuccess();
                        } else {
                            channelFuture.setFailure(channelFuture3.getCause());
                        }
                    }
                });
            }
        });
    }

    @Override // org.jboss.netty.channel.Channel
    public HttpTunnelingSocketChannelConfig getConfig() {
        return this.config;
    }

    @Override // org.jboss.netty.channel.AbstractChannel, org.jboss.netty.channel.Channel
    public int getInterestOps() {
        return this.realChannel.getInterestOps();
    }

    @Override // org.jboss.netty.channel.Channel
    public InetSocketAddress getLocalAddress() {
        return this.realChannel.getLocalAddress();
    }

    @Override // org.jboss.netty.channel.Channel
    public InetSocketAddress getRemoteAddress() {
        return this.realChannel.getRemoteAddress();
    }

    @Override // org.jboss.netty.channel.Channel
    public boolean isBound() {
        return this.realChannel.isBound();
    }

    @Override // org.jboss.netty.channel.Channel
    public boolean isConnected() {
        return this.realChannel.isConnected();
    }

    @Override // org.jboss.netty.channel.AbstractChannel, org.jboss.netty.channel.Channel
    public boolean isWritable() {
        return this.realChannel.isWritable();
    }

    @Override // org.jboss.netty.channel.AbstractChannel
    protected boolean setClosed() {
        return super.setClosed();
    }

    void setInterestOpsReal(int i, final ChannelFuture channelFuture) {
        this.realChannel.setInterestOps(i).addListener(new ChannelFutureListener() { // from class: org.jboss.netty.channel.socket.http.HttpTunnelingClientSocketChannel.4
            @Override // org.jboss.netty.channel.ChannelFutureListener
            public void operationComplete(ChannelFuture channelFuture2) {
                if (channelFuture2.isSuccess()) {
                    channelFuture.setSuccess();
                } else {
                    channelFuture.setFailure(channelFuture2.getCause());
                }
            }
        });
    }

    void unbindReal(final ChannelFuture channelFuture) {
        writeLastChunk().addListener(new ChannelFutureListener() { // from class: org.jboss.netty.channel.socket.http.HttpTunnelingClientSocketChannel.6
            @Override // org.jboss.netty.channel.ChannelFutureListener
            public void operationComplete(ChannelFuture channelFuture2) {
                HttpTunnelingClientSocketChannel.this.realChannel.unbind().addListener(new ChannelFutureListener() { // from class: org.jboss.netty.channel.socket.http.HttpTunnelingClientSocketChannel.6.1
                    @Override // org.jboss.netty.channel.ChannelFutureListener
                    public void operationComplete(ChannelFuture channelFuture3) {
                        if (channelFuture3.isSuccess()) {
                            channelFuture.setSuccess();
                        } else {
                            channelFuture.setFailure(channelFuture3.getCause());
                        }
                    }
                });
            }
        });
    }

    @Override // org.jboss.netty.channel.AbstractChannel, org.jboss.netty.channel.Channel
    public ChannelFuture write(Object obj, SocketAddress socketAddress) {
        return (socketAddress == null || socketAddress.equals(getRemoteAddress())) ? super.write(obj, null) : getUnsupportedOperationFuture();
    }

    void writeReal(ChannelBuffer channelBuffer, final ChannelFuture channelFuture) {
        if (!this.requestHeaderWritten) {
            throw new NotYetConnectedException();
        }
        final int i = channelBuffer.readableBytes();
        (i == 0 ? this.realChannel.write(ChannelBuffers.EMPTY_BUFFER) : this.realChannel.write(new DefaultHttpChunk(channelBuffer))).addListener(new ChannelFutureListener() { // from class: org.jboss.netty.channel.socket.http.HttpTunnelingClientSocketChannel.3
            @Override // org.jboss.netty.channel.ChannelFutureListener
            public void operationComplete(ChannelFuture channelFuture2) {
                if (!channelFuture2.isSuccess()) {
                    channelFuture.setFailure(channelFuture2.getCause());
                    return;
                }
                channelFuture.setSuccess();
                if (i != 0) {
                    Channels.fireWriteComplete(HttpTunnelingClientSocketChannel.this, i);
                }
            }
        });
    }
}
