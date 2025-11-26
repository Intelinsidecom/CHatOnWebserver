package org.jboss.netty.handler.codec.frame;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

@ChannelHandler.Sharable
/* loaded from: classes.dex */
public class LengthFieldPrepender extends OneToOneEncoder {
    private final int lengthFieldLength;
    private final boolean lengthIncludesLengthFieldLength;

    public LengthFieldPrepender(int i) {
        this(i, false);
    }

    public LengthFieldPrepender(int i, boolean z) {
        if (i != 1 && i != 2 && i != 3 && i != 4 && i != 8) {
            throw new IllegalArgumentException("lengthFieldLength must be either 1, 2, 3, 4, or 8: " + i);
        }
        this.lengthFieldLength = i;
        this.lengthIncludesLengthFieldLength = z;
    }

    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        if (!(obj instanceof ChannelBuffer)) {
            return obj;
        }
        ChannelBuffer channelBuffer = (ChannelBuffer) obj;
        ChannelBuffer buffer = channel.getConfig().getBufferFactory().getBuffer(channelBuffer.order(), this.lengthFieldLength);
        int i = this.lengthIncludesLengthFieldLength ? channelBuffer.readableBytes() + this.lengthFieldLength : channelBuffer.readableBytes();
        switch (this.lengthFieldLength) {
            case 1:
                if (i < 256) {
                    buffer.writeByte((byte) i);
                    break;
                } else {
                    throw new IllegalArgumentException("length does not fit into a byte: " + i);
                }
            case 2:
                if (i < 65536) {
                    buffer.writeShort((short) i);
                    break;
                } else {
                    throw new IllegalArgumentException("length does not fit into a short integer: " + i);
                }
            case 3:
                if (i < 16777216) {
                    buffer.writeMedium(i);
                    break;
                } else {
                    throw new IllegalArgumentException("length does not fit into a medium integer: " + i);
                }
            case 4:
                buffer.writeInt(i);
                break;
            case 5:
            case 6:
            case 7:
            default:
                throw new Error("should not reach here");
            case 8:
                buffer.writeLong(i);
                break;
        }
        return ChannelBuffers.wrappedBuffer(buffer, channelBuffer);
    }
}
