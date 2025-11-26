package org.jboss.netty.handler.codec.frame;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;

/* loaded from: classes.dex */
public class FixedLengthFrameDecoder extends FrameDecoder {
    private final int frameLength;

    public FixedLengthFrameDecoder(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("frameLength must be a positive integer: " + i);
        }
        this.frameLength = i;
    }

    @Override // org.jboss.netty.handler.codec.frame.FrameDecoder
    protected Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer) {
        if (channelBuffer.readableBytes() < this.frameLength) {
            return null;
        }
        return channelBuffer.readBytes(this.frameLength);
    }
}
