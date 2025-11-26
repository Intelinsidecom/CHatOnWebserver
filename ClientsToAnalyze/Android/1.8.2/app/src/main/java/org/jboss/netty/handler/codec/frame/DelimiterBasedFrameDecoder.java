package org.jboss.netty.handler.codec.frame;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.Channels;

/* loaded from: classes.dex */
public class DelimiterBasedFrameDecoder extends FrameDecoder {
    private final ChannelBuffer[] delimiters;
    private boolean discardingTooLongFrame;
    private final boolean failFast;
    private final int maxFrameLength;
    private final boolean stripDelimiter;
    private int tooLongFrameLength;

    public DelimiterBasedFrameDecoder(int i, ChannelBuffer channelBuffer) {
        this(i, true, channelBuffer);
    }

    public DelimiterBasedFrameDecoder(int i, boolean z, ChannelBuffer channelBuffer) {
        this(i, z, false, channelBuffer);
    }

    public DelimiterBasedFrameDecoder(int i, boolean z, boolean z2, ChannelBuffer channelBuffer) {
        validateMaxFrameLength(i);
        validateDelimiter(channelBuffer);
        this.delimiters = new ChannelBuffer[]{channelBuffer.slice(channelBuffer.readerIndex(), channelBuffer.readableBytes())};
        this.maxFrameLength = i;
        this.stripDelimiter = z;
        this.failFast = z2;
    }

    public DelimiterBasedFrameDecoder(int i, ChannelBuffer... channelBufferArr) {
        this(i, true, channelBufferArr);
    }

    public DelimiterBasedFrameDecoder(int i, boolean z, ChannelBuffer... channelBufferArr) {
        this(i, z, false, channelBufferArr);
    }

    public DelimiterBasedFrameDecoder(int i, boolean z, boolean z2, ChannelBuffer... channelBufferArr) {
        validateMaxFrameLength(i);
        if (channelBufferArr == null) {
            throw new NullPointerException("delimiters");
        }
        if (channelBufferArr.length == 0) {
            throw new IllegalArgumentException("empty delimiters");
        }
        this.delimiters = new ChannelBuffer[channelBufferArr.length];
        for (int i2 = 0; i2 < channelBufferArr.length; i2++) {
            ChannelBuffer channelBuffer = channelBufferArr[i2];
            validateDelimiter(channelBuffer);
            this.delimiters[i2] = channelBuffer.slice(channelBuffer.readerIndex(), channelBuffer.readableBytes());
        }
        this.maxFrameLength = i;
        this.stripDelimiter = z;
        this.failFast = z2;
    }

    @Override // org.jboss.netty.handler.codec.frame.FrameDecoder
    protected Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer) {
        int i;
        int i2 = Integer.MAX_VALUE;
        ChannelBuffer[] channelBufferArr = this.delimiters;
        int length = channelBufferArr.length;
        int i3 = 0;
        ChannelBuffer channelBuffer2 = null;
        while (i3 < length) {
            ChannelBuffer channelBuffer3 = channelBufferArr[i3];
            int iIndexOf = indexOf(channelBuffer, channelBuffer3);
            if (iIndexOf < 0 || iIndexOf >= i2) {
                channelBuffer3 = channelBuffer2;
                i = i2;
            } else {
                i = iIndexOf;
            }
            i3++;
            i2 = i;
            channelBuffer2 = channelBuffer3;
        }
        if (channelBuffer2 != null) {
            int iCapacity = channelBuffer2.capacity();
            if (this.discardingTooLongFrame) {
                this.discardingTooLongFrame = false;
                channelBuffer.skipBytes(i2 + iCapacity);
                int i4 = this.tooLongFrameLength;
                this.tooLongFrameLength = 0;
                if (!this.failFast) {
                    fail(channelHandlerContext, i4);
                }
                return null;
            }
            if (i2 > this.maxFrameLength) {
                channelBuffer.skipBytes(i2 + iCapacity);
                fail(channelHandlerContext, i2);
                return null;
            }
            if (this.stripDelimiter) {
                ChannelBuffer bytes = channelBuffer.readBytes(i2);
                channelBuffer.skipBytes(iCapacity);
                return bytes;
            }
            return channelBuffer.readBytes(i2 + iCapacity);
        }
        if (!this.discardingTooLongFrame) {
            if (channelBuffer.readableBytes() > this.maxFrameLength) {
                this.tooLongFrameLength = channelBuffer.readableBytes();
                channelBuffer.skipBytes(channelBuffer.readableBytes());
                this.discardingTooLongFrame = true;
                if (this.failFast) {
                    fail(channelHandlerContext, this.tooLongFrameLength);
                }
            }
        } else {
            this.tooLongFrameLength += channelBuffer.readableBytes();
            channelBuffer.skipBytes(channelBuffer.readableBytes());
        }
        return null;
    }

    private void fail(ChannelHandlerContext channelHandlerContext, long j) {
        if (j > 0) {
            Channels.fireExceptionCaught(channelHandlerContext.getChannel(), new TooLongFrameException("frame length exceeds " + this.maxFrameLength + ": " + j + " - discarded"));
        } else {
            Channels.fireExceptionCaught(channelHandlerContext.getChannel(), new TooLongFrameException("frame length exceeds " + this.maxFrameLength + " - discarding"));
        }
    }

    private static int indexOf(ChannelBuffer channelBuffer, ChannelBuffer channelBuffer2) {
        for (int i = channelBuffer.readerIndex(); i < channelBuffer.writerIndex(); i++) {
            int i2 = 0;
            int i3 = i;
            while (i2 < channelBuffer2.capacity() && channelBuffer.getByte(i3) == channelBuffer2.getByte(i2)) {
                i3++;
                if (i3 == channelBuffer.writerIndex() && i2 != channelBuffer2.capacity() - 1) {
                    return -1;
                }
                i2++;
            }
            if (i2 == channelBuffer2.capacity()) {
                return i - channelBuffer.readerIndex();
            }
        }
        return -1;
    }

    private static void validateDelimiter(ChannelBuffer channelBuffer) {
        if (channelBuffer == null) {
            throw new NullPointerException("delimiter");
        }
        if (!channelBuffer.readable()) {
            throw new IllegalArgumentException("empty delimiter");
        }
    }

    private static void validateMaxFrameLength(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxFrameLength must be a positive integer: " + i);
        }
    }
}
