package org.jboss.netty.handler.codec.replay;

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
public abstract class ReplayingDecoder extends SimpleChannelUpstreamHandler {
    private int checkpoint;
    private final AtomicReference cumulation;
    private ReplayingDecoderBuffer replayable;
    private Enum state;
    private final boolean unfold;

    protected ReplayingDecoder() {
        this((Enum) null);
    }

    protected ReplayingDecoder(Enum r2) {
        this(r2, false);
    }

    protected ReplayingDecoder(Enum r2, boolean z) {
        this.cumulation = new AtomicReference();
        this.state = r2;
        this.unfold = z;
    }

    protected ReplayingDecoder(boolean z) {
        this(null, z);
    }

    private void callDecode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, SocketAddress socketAddress) {
        while (channelBuffer.readable()) {
            int i = channelBuffer.readerIndex();
            this.checkpoint = i;
            Object objDecode = null;
            Enum r2 = this.state;
            try {
                objDecode = decode(channelHandlerContext, channel, this.replayable, this.state);
            } catch (ReplayError e) {
                int i2 = this.checkpoint;
                if (i2 >= 0) {
                    channelBuffer.readerIndex(i2);
                }
            }
            if (objDecode == null) {
                if (i == channelBuffer.readerIndex() && r2 == this.state) {
                    throw new IllegalStateException("null cannot be returned if no data is consumed and state didn't change.");
                }
            } else {
                if (objDecode == null) {
                    return;
                }
                if (i == channelBuffer.readerIndex() && r2 == this.state) {
                    throw new IllegalStateException("decode() method must consume at least one byte if it returned a decoded message (caused by: " + getClass() + ")");
                }
                unfoldAndfireMessageReceived(channelHandlerContext, objDecode, socketAddress);
            }
        }
    }

    private void cleanup(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        try {
            ChannelBuffer channelBuffer = (ChannelBuffer) this.cumulation.getAndSet(null);
            if (channelBuffer == null) {
                return;
            }
            this.replayable.terminate();
            if (channelBuffer.readable()) {
                callDecode(channelHandlerContext, channelStateEvent.getChannel(), channelBuffer, null);
            }
            Object objDecodeLast = decodeLast(channelHandlerContext, channelStateEvent.getChannel(), this.replayable, this.state);
            if (objDecodeLast != null) {
                unfoldAndfireMessageReceived(channelHandlerContext, objDecodeLast, null);
            }
        } catch (ReplayError e) {
        } finally {
            channelHandlerContext.sendUpstream(channelStateEvent);
        }
    }

    private ChannelBuffer cumulation(ChannelHandlerContext channelHandlerContext) {
        ChannelBuffer channelBuffer = (ChannelBuffer) this.cumulation.get();
        if (channelBuffer != null) {
            return channelBuffer;
        }
        UnsafeDynamicChannelBuffer unsafeDynamicChannelBuffer = new UnsafeDynamicChannelBuffer(channelHandlerContext.getChannel().getConfig().getBufferFactory());
        if (!this.cumulation.compareAndSet(null, unsafeDynamicChannelBuffer)) {
            return (ChannelBuffer) this.cumulation.get();
        }
        this.replayable = new ReplayingDecoderBuffer(unsafeDynamicChannelBuffer);
        return unsafeDynamicChannelBuffer;
    }

    private void unfoldAndfireMessageReceived(ChannelHandlerContext channelHandlerContext, Object obj, SocketAddress socketAddress) {
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

    protected int actualReadableBytes() {
        return internalBuffer().readableBytes();
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void channelClosed(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        cleanup(channelHandlerContext, channelStateEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        cleanup(channelHandlerContext, channelStateEvent);
    }

    protected void checkpoint() {
        ChannelBuffer channelBuffer = (ChannelBuffer) this.cumulation.get();
        if (channelBuffer != null) {
            this.checkpoint = channelBuffer.readerIndex();
        } else {
            this.checkpoint = -1;
        }
    }

    protected void checkpoint(Enum r1) {
        checkpoint();
        setState(r1);
    }

    protected abstract Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, Enum r4);

    protected Object decodeLast(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, Enum r5) {
        return decode(channelHandlerContext, channel, channelBuffer, r5);
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
        channelHandlerContext.sendUpstream(exceptionEvent);
    }

    protected Enum getState() {
        return this.state;
    }

    protected ChannelBuffer internalBuffer() {
        ChannelBuffer channelBuffer = (ChannelBuffer) this.cumulation.get();
        return channelBuffer == null ? ChannelBuffers.EMPTY_BUFFER : channelBuffer;
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

    protected Enum setState(Enum r2) {
        Enum r0 = this.state;
        this.state = r2;
        return r0;
    }
}
