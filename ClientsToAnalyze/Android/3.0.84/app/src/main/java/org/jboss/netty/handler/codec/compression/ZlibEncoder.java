package org.jboss.netty.handler.codec.compression;

import java.util.concurrent.atomic.AtomicBoolean;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.LifeCycleAwareChannelHandler;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;
import org.jboss.netty.util.internal.jzlib.JZlib;
import org.jboss.netty.util.internal.jzlib.ZStream;

/* loaded from: classes.dex */
public class ZlibEncoder extends OneToOneEncoder implements LifeCycleAwareChannelHandler {
    private static final byte[] EMPTY_ARRAY = new byte[0];
    private volatile ChannelHandlerContext ctx;
    private final AtomicBoolean finished;

    /* renamed from: z */
    private final ZStream f13697z;

    public ZlibEncoder() {
        this(6);
    }

    public ZlibEncoder(int i) {
        this(ZlibWrapper.ZLIB, i);
    }

    public ZlibEncoder(ZlibWrapper zlibWrapper) {
        this(zlibWrapper, 6);
    }

    public ZlibEncoder(ZlibWrapper zlibWrapper, int i) {
        this.f13697z = new ZStream();
        this.finished = new AtomicBoolean();
        if (i < 0 || i > 9) {
            throw new IllegalArgumentException("compressionLevel: " + i + " (expected: 0-9)");
        }
        if (zlibWrapper == null) {
            throw new NullPointerException("wrapper");
        }
        if (zlibWrapper == ZlibWrapper.ZLIB_OR_NONE) {
            throw new IllegalArgumentException("wrapper '" + ZlibWrapper.ZLIB_OR_NONE + "' is not allowed for compression.");
        }
        synchronized (this.f13697z) {
            int iDeflateInit = this.f13697z.deflateInit(i, ZlibUtil.convertWrapperType(zlibWrapper));
            if (iDeflateInit != 0) {
                ZlibUtil.fail(this.f13697z, "initialization failure", iDeflateInit);
            }
        }
    }

    public ZlibEncoder(byte[] bArr) {
        this(6, bArr);
    }

    public ZlibEncoder(int i, byte[] bArr) {
        this.f13697z = new ZStream();
        this.finished = new AtomicBoolean();
        if (i < 0 || i > 9) {
            throw new IllegalArgumentException("compressionLevel: " + i + " (expected: 0-9)");
        }
        if (bArr == null) {
            throw new NullPointerException("dictionary");
        }
        synchronized (this.f13697z) {
            int iDeflateInit = this.f13697z.deflateInit(i, JZlib.W_ZLIB);
            if (iDeflateInit != 0) {
                ZlibUtil.fail(this.f13697z, "initialization failure", iDeflateInit);
            } else {
                int iDeflateSetDictionary = this.f13697z.deflateSetDictionary(bArr, bArr.length);
                if (iDeflateSetDictionary != 0) {
                    ZlibUtil.fail(this.f13697z, "failed to set the dictionary", iDeflateSetDictionary);
                }
            }
        }
    }

    public ChannelFuture close() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext == null) {
            throw new IllegalStateException("not added to a pipeline");
        }
        return finishEncode(channelHandlerContext, null);
    }

    public boolean isClosed() {
        return this.finished.get();
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        if ((obj instanceof ChannelBuffer) && !this.finished.get()) {
            synchronized (this.f13697z) {
                try {
                    ChannelBuffer channelBuffer = (ChannelBuffer) obj;
                    byte[] bArr = new byte[channelBuffer.readableBytes()];
                    channelBuffer.readBytes(bArr);
                    this.f13697z.next_in = bArr;
                    this.f13697z.next_in_index = 0;
                    this.f13697z.avail_in = bArr.length;
                    byte[] bArr2 = new byte[((int) Math.ceil(bArr.length * 1.001d)) + 12];
                    this.f13697z.next_out = bArr2;
                    this.f13697z.next_out_index = 0;
                    this.f13697z.avail_out = bArr2.length;
                    int iDeflate = this.f13697z.deflate(2);
                    if (iDeflate != 0) {
                        ZlibUtil.fail(this.f13697z, "compression failure", iDeflate);
                    }
                    if (this.f13697z.next_out_index != 0) {
                        obj = channelHandlerContext.getChannel().getConfig().getBufferFactory().getBuffer(channelBuffer.order(), bArr2, 0, this.f13697z.next_out_index);
                    } else {
                        obj = ChannelBuffers.EMPTY_BUFFER;
                    }
                } finally {
                    this.f13697z.next_in = null;
                    this.f13697z.next_out = null;
                }
            }
        }
        return obj;
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder, org.jboss.netty.channel.ChannelDownstreamHandler
    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            switch (channelStateEvent.getState()) {
                case OPEN:
                case CONNECTED:
                case BOUND:
                    if (Boolean.FALSE.equals(channelStateEvent.getValue()) || channelStateEvent.getValue() == null) {
                        finishEncode(channelHandlerContext, channelEvent);
                        return;
                    }
                    break;
            }
        }
        super.handleDownstream(channelHandlerContext, channelEvent);
    }

    private ChannelFuture finishEncode(final ChannelHandlerContext channelHandlerContext, final ChannelEvent channelEvent) {
        ChannelFuture channelFutureFuture;
        ChannelBuffer buffer = null;
        if (!this.finished.compareAndSet(false, true)) {
            if (channelEvent != null) {
                channelHandlerContext.sendDownstream(channelEvent);
            }
            return Channels.succeededFuture(channelHandlerContext.getChannel());
        }
        synchronized (this.f13697z) {
            try {
                this.f13697z.next_in = EMPTY_ARRAY;
                this.f13697z.next_in_index = 0;
                this.f13697z.avail_in = 0;
                byte[] bArr = new byte[32];
                this.f13697z.next_out = bArr;
                this.f13697z.next_out_index = 0;
                this.f13697z.avail_out = bArr.length;
                int iDeflate = this.f13697z.deflate(4);
                if (iDeflate != 0 && iDeflate != 1) {
                    channelFutureFuture = Channels.failedFuture(channelHandlerContext.getChannel(), ZlibUtil.exception(this.f13697z, "compression failure", iDeflate));
                } else if (this.f13697z.next_out_index != 0) {
                    channelFutureFuture = Channels.future(channelHandlerContext.getChannel());
                    buffer = channelHandlerContext.getChannel().getConfig().getBufferFactory().getBuffer(bArr, 0, this.f13697z.next_out_index);
                } else {
                    channelFutureFuture = Channels.future(channelHandlerContext.getChannel());
                    buffer = ChannelBuffers.EMPTY_BUFFER;
                }
            } finally {
                this.f13697z.deflateEnd();
                this.f13697z.next_in = null;
                this.f13697z.next_out = null;
            }
        }
        if (buffer != null) {
            Channels.write(channelHandlerContext, channelFutureFuture, buffer);
        }
        if (channelEvent != null) {
            channelFutureFuture.addListener(new ChannelFutureListener() { // from class: org.jboss.netty.handler.codec.compression.ZlibEncoder.1
                @Override // org.jboss.netty.channel.ChannelFutureListener
                public void operationComplete(ChannelFuture channelFuture) {
                    channelHandlerContext.sendDownstream(channelEvent);
                }
            });
            return channelFutureFuture;
        }
        return channelFutureFuture;
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void beforeAdd(ChannelHandlerContext channelHandlerContext) {
        this.ctx = channelHandlerContext;
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void afterAdd(ChannelHandlerContext channelHandlerContext) {
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void beforeRemove(ChannelHandlerContext channelHandlerContext) {
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void afterRemove(ChannelHandlerContext channelHandlerContext) {
    }
}
