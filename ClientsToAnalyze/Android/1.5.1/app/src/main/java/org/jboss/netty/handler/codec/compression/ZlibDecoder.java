package org.jboss.netty.handler.codec.compression;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;
import org.jboss.netty.util.internal.jzlib.JZlib;
import org.jboss.netty.util.internal.jzlib.ZStream;

/* loaded from: classes.dex */
public class ZlibDecoder extends OneToOneDecoder {
    private volatile boolean finished;

    /* renamed from: z */
    private final ZStream f4570z;

    public ZlibDecoder() {
        this(ZlibWrapper.ZLIB);
    }

    public ZlibDecoder(ZlibWrapper zlibWrapper) {
        this.f4570z = new ZStream();
        if (zlibWrapper == null) {
            throw new NullPointerException("wrapper");
        }
        synchronized (this.f4570z) {
            int iInflateInit = this.f4570z.inflateInit(ZlibUtil.convertWrapperType(zlibWrapper));
            if (iInflateInit != 0) {
                ZlibUtil.fail(this.f4570z, "initialization failure", iInflateInit);
            }
        }
    }

    public ZlibDecoder(byte[] bArr) {
        this.f4570z = new ZStream();
        if (bArr == null) {
            throw new NullPointerException("dictionary");
        }
        synchronized (this.f4570z) {
            int iInflateInit = this.f4570z.inflateInit(JZlib.W_ZLIB);
            if (iInflateInit != 0) {
                ZlibUtil.fail(this.f4570z, "initialization failure", iInflateInit);
            } else {
                int iInflateSetDictionary = this.f4570z.inflateSetDictionary(bArr, bArr.length);
                if (iInflateSetDictionary != 0) {
                    ZlibUtil.fail(this.f4570z, "failed to set the dictionary", iInflateSetDictionary);
                }
            }
        }
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneDecoder
    protected Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        if (!(obj instanceof ChannelBuffer) || this.finished) {
            return obj;
        }
        synchronized (this.f4570z) {
            try {
                ChannelBuffer channelBuffer = (ChannelBuffer) obj;
                byte[] bArr = new byte[channelBuffer.readableBytes()];
                channelBuffer.readBytes(bArr);
                this.f4570z.next_in = bArr;
                this.f4570z.next_in_index = 0;
                this.f4570z.avail_in = bArr.length;
                byte[] bArr2 = new byte[bArr.length << 1];
                ChannelBuffer channelBufferDynamicBuffer = ChannelBuffers.dynamicBuffer(channelBuffer.order(), bArr2.length, channelHandlerContext.getChannel().getConfig().getBufferFactory());
                this.f4570z.next_out = bArr2;
                this.f4570z.next_out_index = 0;
                this.f4570z.avail_out = bArr2.length;
                do {
                    int iInflate = this.f4570z.inflate(2);
                    switch (iInflate) {
                        case JZlib.Z_BUF_ERROR /* -5 */:
                        case 0:
                        case 1:
                            channelBufferDynamicBuffer.writeBytes(bArr2, 0, this.f4570z.next_out_index);
                            this.f4570z.next_out_index = 0;
                            this.f4570z.avail_out = bArr2.length;
                            if (iInflate == 1) {
                                this.finished = true;
                                this.f4570z.inflateEnd();
                                break;
                            }
                            break;
                        default:
                            ZlibUtil.fail(this.f4570z, "decompression failure", iInflate);
                            break;
                    }
                } while (this.f4570z.avail_in > 0);
                if (channelBufferDynamicBuffer.writerIndex() != 0) {
                    return channelBufferDynamicBuffer;
                }
                return null;
            } finally {
                this.f4570z.next_in = null;
                this.f4570z.next_out = null;
            }
        }
    }

    public boolean isClosed() {
        return this.finished;
    }
}
