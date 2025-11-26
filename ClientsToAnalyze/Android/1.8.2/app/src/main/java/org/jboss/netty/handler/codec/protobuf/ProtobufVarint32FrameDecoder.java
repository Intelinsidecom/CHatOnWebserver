package org.jboss.netty.handler.codec.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.InvalidProtocolBufferException;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.CorruptedFrameException;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

/* loaded from: classes.dex */
public class ProtobufVarint32FrameDecoder extends FrameDecoder {
    @Override // org.jboss.netty.handler.codec.frame.FrameDecoder
    protected Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer) throws InvalidProtocolBufferException, CorruptedFrameException {
        channelBuffer.markReaderIndex();
        byte[] bArr = new byte[5];
        for (int i = 0; i < bArr.length; i++) {
            if (!channelBuffer.readable()) {
                channelBuffer.resetReaderIndex();
                return null;
            }
            bArr[i] = channelBuffer.readByte();
            if (bArr[i] >= 0) {
                int rawVarint32 = CodedInputStream.newInstance(bArr, 0, i + 1).readRawVarint32();
                if (rawVarint32 < 0) {
                    throw new CorruptedFrameException("negative length: " + rawVarint32);
                }
                if (channelBuffer.readableBytes() < rawVarint32) {
                    channelBuffer.resetReaderIndex();
                    return null;
                }
                return channelBuffer.readBytes(rawVarint32);
            }
        }
        throw new CorruptedFrameException("length wider than 32-bit");
    }
}
