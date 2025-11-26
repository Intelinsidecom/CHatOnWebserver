package org.jboss.netty.handler.codec.http.websocket;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

@ChannelHandler.Sharable
/* loaded from: classes.dex */
public class WebSocketFrameEncoder extends OneToOneEncoder {
    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        if (!(obj instanceof WebSocketFrame)) {
            return obj;
        }
        WebSocketFrame webSocketFrame = (WebSocketFrame) obj;
        int type = webSocketFrame.getType();
        if (webSocketFrame.isText()) {
            ChannelBuffer binaryData = webSocketFrame.getBinaryData();
            ChannelBuffer buffer = channel.getConfig().getBufferFactory().getBuffer(binaryData.order(), binaryData.readableBytes() + 2);
            buffer.writeByte((byte) type);
            buffer.writeBytes(binaryData, binaryData.readerIndex(), binaryData.readableBytes());
            buffer.writeByte(-1);
            return buffer;
        }
        ChannelBuffer binaryData2 = webSocketFrame.getBinaryData();
        int i = binaryData2.readableBytes();
        ChannelBuffer buffer2 = channel.getConfig().getBufferFactory().getBuffer(binaryData2.order(), i + 5);
        buffer2.writeByte((byte) type);
        int i2 = (i >>> 28) & 127;
        int i3 = (i >>> 14) & 127;
        int i4 = (i >>> 7) & 127;
        int i5 = i & 127;
        if (i2 != 0) {
            buffer2.writeByte(i2 | 128);
            buffer2.writeByte(i3 | 128);
            buffer2.writeByte(i4 | 128);
            buffer2.writeByte(i5);
        } else if (i3 != 0) {
            buffer2.writeByte(i3 | 128);
            buffer2.writeByte(i4 | 128);
            buffer2.writeByte(i5);
        } else if (i4 == 0) {
            buffer2.writeByte(i5);
        } else {
            buffer2.writeByte(i4 | 128);
            buffer2.writeByte(i5);
        }
        buffer2.writeBytes(binaryData2, binaryData2.readerIndex(), i);
        return buffer2;
    }
}
