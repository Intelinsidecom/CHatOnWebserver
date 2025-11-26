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
    private final ZStream f13696z;

    public ZlibDecoder() {
        this(ZlibWrapper.ZLIB);
    }

    public ZlibDecoder(ZlibWrapper zlibWrapper) {
        this.f13696z = new ZStream();
        if (zlibWrapper == null) {
            throw new NullPointerException("wrapper");
        }
        synchronized (this.f13696z) {
            int iInflateInit = this.f13696z.inflateInit(ZlibUtil.convertWrapperType(zlibWrapper));
            if (iInflateInit != 0) {
                ZlibUtil.fail(this.f13696z, "initialization failure", iInflateInit);
            }
        }
    }

    public ZlibDecoder(byte[] bArr) {
        this.f13696z = new ZStream();
        if (bArr == null) {
            throw new NullPointerException("dictionary");
        }
        synchronized (this.f13696z) {
            int iInflateInit = this.f13696z.inflateInit(JZlib.W_ZLIB);
            if (iInflateInit != 0) {
                ZlibUtil.fail(this.f13696z, "initialization failure", iInflateInit);
            } else {
                int iInflateSetDictionary = this.f13696z.inflateSetDictionary(bArr, bArr.length);
                if (iInflateSetDictionary != 0) {
                    ZlibUtil.fail(this.f13696z, "failed to set the dictionary", iInflateSetDictionary);
                }
            }
        }
    }

    public boolean isClosed() {
        return this.finished;
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneDecoder
    protected Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        if (!(obj instanceof ChannelBuffer) || this.finished) {
            return obj;
        }
        synchronized (this.f13696z) {
            try {
                ChannelBuffer channelBuffer = (ChannelBuffer) obj;
                byte[] bArr = new byte[channelBuffer.readableBytes()];
                channelBuffer.readBytes(bArr);
                this.f13696z.next_in = bArr;
                this.f13696z.next_in_index = 0;
                this.f13696z.avail_in = bArr.length;
                byte[] bArr2 = new byte[bArr.length << 1];
                ChannelBuffer channelBufferDynamicBuffer = ChannelBuffers.dynamicBuffer(channelBuffer.order(), bArr2.length, channelHandlerContext.getChannel().getConfig().getBufferFactory());
                this.f13696z.next_out = bArr2;
                this.f13696z.next_out_index = 0;
                this.f13696z.avail_out = bArr2.length;
                while (true) {
                    int iInflate = this.f13696z.inflate(2);
                    if (this.f13696z.next_out_index > 0) {
                        channelBufferDynamicBuffer.writeBytes(bArr2, 0, this.f13696z.next_out_index);
                        this.f13696z.avail_out = bArr2.length;
                    }
                    this.f13696z.next_out_index = 0;
                    switch (iInflate) {
                        case -5:
                            if (this.f13696z.avail_in <= 0) {
                                break;
                            }
                        case 0:
                        case 1:
                            this.finished = true;
                            this.f13696z.inflateEnd();
                            break;
                        default:
                            ZlibUtil.fail(this.f13696z, "decompression failure", iInflate);
                            continue;
                    }
                }
                if (channelBufferDynamicBuffer.writerIndex() != 0) {
                    this.f13696z.next_in = null;
                    this.f13696z.next_out = null;
                    return channelBufferDynamicBuffer;
                }
                this.f13696z.next_in = null;
                this.f13696z.next_out = null;
                return null;
            } catch (Throwable th) {
                this.f13696z.next_in = null;
                this.f13696z.next_out = null;
                throw th;
            }
        }
    }
}
