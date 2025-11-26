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

    protected abstract Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, Enum r4);

    protected ReplayingDecoder() {
        this((Enum) null);
    }

    protected ReplayingDecoder(boolean z) {
        this(null, z);
    }

    protected ReplayingDecoder(Enum r2) {
        this(r2, false);
    }

    protected ReplayingDecoder(Enum r2, boolean z) {
        this.cumulation = new AtomicReference();
        this.state = r2;
        this.unfold = z;
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

    protected Enum getState() {
        return this.state;
    }

    protected Enum setState(Enum r2) {
        Enum r0 = this.state;
        this.state = r2;
        return r0;
    }

    protected int actualReadableBytes() {
        return internalBuffer().readableBytes();
    }

    protected ChannelBuffer internalBuffer() {
        ChannelBuffer channelBuffer = (ChannelBuffer) this.cumulation.get();
        if (channelBuffer == null) {
            return ChannelBuffers.EMPTY_BUFFER;
        }
        return channelBuffer;
    }

    protected Object decodeLast(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, Enum r5) {
        return decode(channelHandlerContext, channel, channelBuffer, r5);
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

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0035 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void callDecode(org.jboss.netty.channel.ChannelHandlerContext r7, org.jboss.netty.channel.Channel r8, org.jboss.netty.buffer.ChannelBuffer r9, java.net.SocketAddress r10) {
        /*
            r6 = this;
            r1 = 0
        L1:
            boolean r0 = r9.readable()
            if (r0 == 0) goto L35
            int r2 = r9.readerIndex()
            r6.checkpoint = r2
            java.lang.Enum r3 = r6.state
            org.jboss.netty.handler.codec.replay.ReplayingDecoderBuffer r0 = r6.replayable     // Catch: org.jboss.netty.handler.codec.replay.ReplayError -> L76
            java.lang.Enum r4 = r6.state     // Catch: org.jboss.netty.handler.codec.replay.ReplayError -> L76
            java.lang.Object r0 = r6.decode(r7, r8, r0, r4)     // Catch: org.jboss.netty.handler.codec.replay.ReplayError -> L76
            if (r0 != 0) goto L33
            int r4 = r9.readerIndex()     // Catch: org.jboss.netty.handler.codec.replay.ReplayError -> L2b
            if (r2 != r4) goto L1
            java.lang.Enum r4 = r6.state     // Catch: org.jboss.netty.handler.codec.replay.ReplayError -> L2b
            if (r3 != r4) goto L1
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: org.jboss.netty.handler.codec.replay.ReplayError -> L2b
            java.lang.String r5 = "null cannot be returned if no data is consumed and state didn't change."
            r4.<init>(r5)     // Catch: org.jboss.netty.handler.codec.replay.ReplayError -> L2b
            throw r4     // Catch: org.jboss.netty.handler.codec.replay.ReplayError -> L2b
        L2b:
            r4 = move-exception
        L2c:
            int r4 = r6.checkpoint
            if (r4 < 0) goto L33
            r9.readerIndex(r4)
        L33:
            if (r0 != 0) goto L36
        L35:
            return
        L36:
            int r4 = r9.readerIndex()
            if (r2 != r4) goto L63
            java.lang.Enum r2 = r6.state
            if (r3 != r2) goto L63
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "decode() method must consume at least one byte if it returned a decoded message (caused by: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.Class r2 = r6.getClass()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = ")"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L63:
            r6.unfoldAndFireMessageReceived(r7, r0, r10)
            boolean r0 = r9.readable()
            if (r0 != 0) goto L1
            java.util.concurrent.atomic.AtomicReference r0 = r6.cumulation
            r0.set(r1)
            org.jboss.netty.handler.codec.replay.ReplayingDecoderBuffer r0 = org.jboss.netty.handler.codec.replay.ReplayingDecoderBuffer.EMPTY_BUFFER
            r6.replayable = r0
            goto L1
        L76:
            r0 = move-exception
            r0 = r1
            goto L2c
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.codec.replay.ReplayingDecoder.callDecode(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.Channel, org.jboss.netty.buffer.ChannelBuffer, java.net.SocketAddress):void");
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
                unfoldAndFireMessageReceived(channelHandlerContext, objDecodeLast, null);
            }
        } catch (ReplayError e) {
        } finally {
            this.replayable = ReplayingDecoderBuffer.EMPTY_BUFFER;
            channelHandlerContext.sendUpstream(channelStateEvent);
        }
    }

    private ChannelBuffer cumulation(ChannelHandlerContext channelHandlerContext) {
        ChannelBuffer channelBuffer = (ChannelBuffer) this.cumulation.get();
        if (channelBuffer == null) {
            UnsafeDynamicChannelBuffer unsafeDynamicChannelBuffer = new UnsafeDynamicChannelBuffer(channelHandlerContext.getChannel().getConfig().getBufferFactory());
            if (this.cumulation.compareAndSet(null, unsafeDynamicChannelBuffer)) {
                this.replayable = new ReplayingDecoderBuffer(unsafeDynamicChannelBuffer);
                return unsafeDynamicChannelBuffer;
            }
            return (ChannelBuffer) this.cumulation.get();
        }
        return channelBuffer;
    }
}
