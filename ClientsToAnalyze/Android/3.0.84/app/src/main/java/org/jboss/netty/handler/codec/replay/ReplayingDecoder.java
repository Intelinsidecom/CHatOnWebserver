package org.jboss.netty.handler.codec.replay;

import java.lang.Enum;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
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
public abstract class ReplayingDecoder<T extends Enum<T>> extends SimpleChannelUpstreamHandler {
    private int checkpoint;
    private final AtomicReference<ChannelBuffer> cumulation;
    private ReplayingDecoderBuffer replayable;
    private T state;
    private final boolean unfold;

    protected abstract Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, T t);

    protected ReplayingDecoder() {
        this((Enum) null);
    }

    protected ReplayingDecoder(boolean z) {
        this(null, z);
    }

    protected ReplayingDecoder(T t) {
        this(t, false);
    }

    protected ReplayingDecoder(T t, boolean z) {
        this.cumulation = new AtomicReference<>();
        this.state = t;
        this.unfold = z;
    }

    protected void checkpoint() {
        ChannelBuffer channelBuffer = this.cumulation.get();
        if (channelBuffer != null) {
            this.checkpoint = channelBuffer.readerIndex();
        } else {
            this.checkpoint = -1;
        }
    }

    protected void checkpoint(T t) {
        checkpoint();
        setState(t);
    }

    protected T getState() {
        return this.state;
    }

    protected T setState(T t) {
        T t2 = this.state;
        this.state = t;
        return t2;
    }

    protected int actualReadableBytes() {
        return internalBuffer().readableBytes();
    }

    protected ChannelBuffer internalBuffer() {
        ChannelBuffer channelBuffer = this.cumulation.get();
        if (channelBuffer == null) {
            return ChannelBuffers.EMPTY_BUFFER;
        }
        return channelBuffer;
    }

    protected Object decodeLast(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, T t) {
        return decode(channelHandlerContext, channel, channelBuffer, t);
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
            channelBufferCumulation.discardReadBytes();
            channelBufferCumulation.writeBytes(channelBuffer);
            callDecode(channelHandlerContext, messageEvent.getChannel(), channelBufferCumulation, messageEvent.getRemoteAddress());
        }
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        cleanup(channelHandlerContext, channelStateEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        cleanup(channelHandlerContext, channelStateEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
        channelHandlerContext.sendUpstream(exceptionEvent);
    }

    private void callDecode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, SocketAddress socketAddress) {
        while (channelBuffer.readable()) {
            int i = channelBuffer.readerIndex();
            this.checkpoint = i;
            Object objDecode = null;
            T t = this.state;
            try {
                objDecode = decode(channelHandlerContext, channel, this.replayable, this.state);
            } catch (ReplayError e) {
                int i2 = this.checkpoint;
                if (i2 >= 0) {
                    channelBuffer.readerIndex(i2);
                }
            }
            if (objDecode == null) {
                if (i == channelBuffer.readerIndex() && t == this.state) {
                    throw new IllegalStateException("null cannot be returned if no data is consumed and state didn't change.");
                }
            } else if (objDecode != null) {
                if (i == channelBuffer.readerIndex() && t == this.state) {
                    throw new IllegalStateException("decode() method must consume at least one byte if it returned a decoded message (caused by: " + getClass() + ")");
                }
                unfoldAndFireMessageReceived(channelHandlerContext, objDecode, socketAddress);
            } else {
                return;
            }
        }
    }

    private void unfoldAndFireMessageReceived(ChannelHandlerContext channelHandlerContext, Object obj, SocketAddress socketAddress) {
        if (this.unfold) {
            if (obj instanceof Object[]) {
                for (Object obj2 : (Object[]) obj) {
                    Channels.fireMessageReceived(channelHandlerContext, obj2, socketAddress);
                }
                return;
            }
            if (obj instanceof Iterable) {
                Iterator it = ((Iterable) obj).iterator();
                while (it.hasNext()) {
                    Channels.fireMessageReceived(channelHandlerContext, it.next(), socketAddress);
                }
                return;
            }
            Channels.fireMessageReceived(channelHandlerContext, obj, socketAddress);
            return;
        }
        Channels.fireMessageReceived(channelHandlerContext, obj, socketAddress);
    }

    private void cleanup(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        try {
            ChannelBuffer andSet = this.cumulation.getAndSet(null);
            if (andSet != null) {
                this.replayable.terminate();
                if (andSet.readable()) {
                    callDecode(channelHandlerContext, channelStateEvent.getChannel(), andSet, null);
                }
                Object objDecodeLast = decodeLast(channelHandlerContext, channelStateEvent.getChannel(), this.replayable, this.state);
                if (objDecodeLast != null) {
                    unfoldAndFireMessageReceived(channelHandlerContext, objDecodeLast, null);
                }
            }
        } catch (ReplayError e) {
        } finally {
            channelHandlerContext.sendUpstream(channelStateEvent);
        }
    }

    private ChannelBuffer cumulation(ChannelHandlerContext channelHandlerContext) {
        ChannelBuffer channelBuffer = this.cumulation.get();
        if (channelBuffer == null) {
            UnsafeDynamicChannelBuffer unsafeDynamicChannelBuffer = new UnsafeDynamicChannelBuffer(channelHandlerContext.getChannel().getConfig().getBufferFactory());
            if (this.cumulation.compareAndSet(null, unsafeDynamicChannelBuffer)) {
                this.replayable = new ReplayingDecoderBuffer(unsafeDynamicChannelBuffer);
                return unsafeDynamicChannelBuffer;
            }
            return this.cumulation.get();
        }
        return channelBuffer;
    }
}
