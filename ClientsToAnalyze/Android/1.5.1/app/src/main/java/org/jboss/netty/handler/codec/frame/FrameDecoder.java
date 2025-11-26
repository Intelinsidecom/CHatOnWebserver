package org.jboss.netty.handler.codec.frame;

import java.net.SocketAddress;
import java.util.Iterator;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;

/* loaded from: classes.dex */
public abstract class FrameDecoder extends SimpleChannelUpstreamHandler {
    private ChannelBuffer cumulation;
    private final boolean unfold;

    protected FrameDecoder() {
        this(false);
    }

    protected FrameDecoder(boolean z) {
        this.unfold = z;
    }

    private void callDecode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, SocketAddress socketAddress) {
        while (channelBuffer.readable()) {
            int i = channelBuffer.readerIndex();
            Object objDecode = decode(channelHandlerContext, channel, channelBuffer);
            if (objDecode == null) {
                if (i == channelBuffer.readerIndex()) {
                    return;
                }
            } else {
                if (i == channelBuffer.readerIndex()) {
                    throw new IllegalStateException("decode() method must read at least one byte if it returned a frame (caused by: " + getClass() + ")");
                }
                unfoldAndFireMessageReceived(channelHandlerContext, socketAddress, objDecode);
            }
        }
    }

    private void cleanup(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        try {
            ChannelBuffer channelBuffer = this.cumulation;
            if (channelBuffer == null) {
                return;
            }
            this.cumulation = null;
            if (channelBuffer.readable()) {
                callDecode(channelHandlerContext, channelHandlerContext.getChannel(), channelBuffer, null);
            }
            Object objDecodeLast = decodeLast(channelHandlerContext, channelHandlerContext.getChannel(), channelBuffer);
            if (objDecodeLast != null) {
                unfoldAndFireMessageReceived(channelHandlerContext, null, objDecodeLast);
            }
        } finally {
            channelHandlerContext.sendUpstream(channelStateEvent);
        }
    }

    private ChannelBuffer cumulation(ChannelHandlerContext channelHandlerContext) {
        ChannelBuffer channelBuffer = this.cumulation;
        if (channelBuffer != null) {
            return channelBuffer;
        }
        ChannelBuffer channelBufferDynamicBuffer = ChannelBuffers.dynamicBuffer(channelHandlerContext.getChannel().getConfig().getBufferFactory());
        this.cumulation = channelBufferDynamicBuffer;
        return channelBufferDynamicBuffer;
    }

    private void unfoldAndFireMessageReceived(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, Object obj) {
        if (!this.unfold) {
            Channels.fireMessageReceived(channelHandlerContext, obj, socketAddress);
            return;
        }
        if (obj instanceof Object[]) {
            for (Object obj2 : (Object[]) obj) {
                Channels.fireMessageReceived(channelHandlerContext, obj2, socketAddress);
            }
            return;
        }
        if (!(obj instanceof Iterable)) {
            Channels.fireMessageReceived(channelHandlerContext, obj, socketAddress);
            return;
        }
        Iterator it = ((Iterable) obj).iterator();
        while (it.hasNext()) {
            Channels.fireMessageReceived(channelHandlerContext, it.next(), socketAddress);
        }
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        cleanup(channelHandlerContext, channelStateEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        cleanup(channelHandlerContext, channelStateEvent);
    }

    protected abstract Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer);

    protected Object decodeLast(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer) {
        return decode(channelHandlerContext, channel, channelBuffer);
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
        channelHandlerContext.sendUpstream(exceptionEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void messageReceived(ChannelHandlerContext channelHandlerContext, MessageEvent messageEvent) {
        Object message = messageEvent.getMessage();
        if (!(message instanceof ChannelBuffer)) {
            channelHandlerContext.sendUpstream(messageEvent);
            return;
        }
        ChannelBuffer channelBuffer = (ChannelBuffer) message;
        if (channelBuffer.readable()) {
            ChannelBuffer channelBufferCumulation = cumulation(channelHandlerContext);
            if (channelBufferCumulation.readable()) {
                channelBufferCumulation.discardReadBytes();
                channelBufferCumulation.writeBytes(channelBuffer);
                callDecode(channelHandlerContext, messageEvent.getChannel(), channelBufferCumulation, messageEvent.getRemoteAddress());
            } else {
                callDecode(channelHandlerContext, messageEvent.getChannel(), channelBuffer, messageEvent.getRemoteAddress());
                if (channelBuffer.readable()) {
                    channelBufferCumulation.writeBytes(channelBuffer);
                }
            }
        }
    }
}
