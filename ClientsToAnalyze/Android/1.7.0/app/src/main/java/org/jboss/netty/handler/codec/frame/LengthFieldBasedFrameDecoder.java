package org.jboss.netty.handler.codec.frame;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.Channels;

/* loaded from: classes.dex */
public class LengthFieldBasedFrameDecoder extends FrameDecoder {
    private long bytesToDiscard;
    private boolean discardingTooLongFrame;
    private final int initialBytesToStrip;
    private final int lengthAdjustment;
    private final int lengthFieldEndOffset;
    private final int lengthFieldLength;
    private final int lengthFieldOffset;
    private final int maxFrameLength;
    private long tooLongFrameLength;

    public LengthFieldBasedFrameDecoder(int i, int i2, int i3) {
        this(i, i2, i3, 0, 0);
    }

    public LengthFieldBasedFrameDecoder(int i, int i2, int i3, int i4, int i5) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxFrameLength must be a positive integer: " + i);
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("lengthFieldOffset must be a non-negative integer: " + i2);
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("initialBytesToStrip must be a non-negative integer: " + i5);
        }
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4 && i3 != 8) {
            throw new IllegalArgumentException("lengthFieldLength must be either 1, 2, 3, 4, or 8: " + i3);
        }
        if (i2 > i - i3) {
            throw new IllegalArgumentException("maxFrameLength (" + i + ") must be equal to or greater than lengthFieldOffset (" + i2 + ") + lengthFieldLength (" + i3 + ").");
        }
        this.maxFrameLength = i;
        this.lengthFieldOffset = i2;
        this.lengthFieldLength = i3;
        this.lengthAdjustment = i4;
        this.lengthFieldEndOffset = i2 + i3;
        this.initialBytesToStrip = i5;
    }

    @Override // org.jboss.netty.handler.codec.frame.FrameDecoder
    protected Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer) throws CorruptedFrameException {
        long unsignedInt;
        if (this.discardingTooLongFrame) {
            long j = this.bytesToDiscard;
            int iMin = (int) Math.min(j, channelBuffer.readableBytes());
            channelBuffer.skipBytes(iMin);
            this.bytesToDiscard = j - iMin;
            failIfNecessary(channelHandlerContext);
            return null;
        }
        if (channelBuffer.readableBytes() < this.lengthFieldEndOffset) {
            return null;
        }
        int i = channelBuffer.readerIndex() + this.lengthFieldOffset;
        switch (this.lengthFieldLength) {
            case 1:
                unsignedInt = channelBuffer.getUnsignedByte(i);
                break;
            case 2:
                unsignedInt = channelBuffer.getUnsignedShort(i);
                break;
            case 3:
                unsignedInt = channelBuffer.getUnsignedMedium(i);
                break;
            case 4:
                unsignedInt = channelBuffer.getUnsignedInt(i);
                break;
            case 5:
            case 6:
            case 7:
            default:
                throw new Error("should not reach here");
            case 8:
                unsignedInt = channelBuffer.getLong(i);
                break;
        }
        if (unsignedInt < 0) {
            channelBuffer.skipBytes(this.lengthFieldEndOffset);
            throw new CorruptedFrameException("negative pre-adjustment length field: " + unsignedInt);
        }
        long j2 = unsignedInt + this.lengthAdjustment + this.lengthFieldEndOffset;
        if (j2 < this.lengthFieldEndOffset) {
            channelBuffer.skipBytes(this.lengthFieldEndOffset);
            throw new CorruptedFrameException("Adjusted frame length (" + j2 + ") is less than lengthFieldEndOffset: " + this.lengthFieldEndOffset);
        }
        if (j2 > this.maxFrameLength) {
            this.discardingTooLongFrame = true;
            this.tooLongFrameLength = j2;
            this.bytesToDiscard = j2 - channelBuffer.readableBytes();
            channelBuffer.skipBytes(channelBuffer.readableBytes());
            failIfNecessary(channelHandlerContext);
            return null;
        }
        int i2 = (int) j2;
        if (channelBuffer.readableBytes() < i2) {
            return null;
        }
        if (this.initialBytesToStrip > i2) {
            channelBuffer.skipBytes(i2);
            throw new CorruptedFrameException("Adjusted frame length (" + j2 + ") is less than initialBytesToStrip: " + this.initialBytesToStrip);
        }
        channelBuffer.skipBytes(this.initialBytesToStrip);
        int i3 = channelBuffer.readerIndex();
        int i4 = i2 - this.initialBytesToStrip;
        ChannelBuffer channelBufferExtractFrame = extractFrame(channelBuffer, i3, i4);
        channelBuffer.readerIndex(i3 + i4);
        return channelBufferExtractFrame;
    }

    private void failIfNecessary(ChannelHandlerContext channelHandlerContext) {
        if (this.bytesToDiscard == 0) {
            long j = this.tooLongFrameLength;
            this.tooLongFrameLength = 0L;
            this.discardingTooLongFrame = false;
            fail(channelHandlerContext, j);
        }
    }

    protected ChannelBuffer extractFrame(ChannelBuffer channelBuffer, int i, int i2) {
        ChannelBuffer buffer = channelBuffer.factory().getBuffer(i2);
        buffer.writeBytes(channelBuffer, i, i2);
        return buffer;
    }

    private void fail(ChannelHandlerContext channelHandlerContext, long j) {
        if (j > 0) {
            Channels.fireExceptionCaught(channelHandlerContext.getChannel(), new TooLongFrameException("Adjusted frame length exceeds " + this.maxFrameLength + ": " + j + " - discarded"));
        } else {
            Channels.fireExceptionCaught(channelHandlerContext.getChannel(), new TooLongFrameException("Adjusted frame length exceeds " + this.maxFrameLength + " - discarding"));
        }
    }
}
