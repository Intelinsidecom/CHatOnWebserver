package org.jboss.netty.handler.codec.protobuf;

import com.google.protobuf.CodedOutputStream;
import java.io.IOException;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferOutputStream;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

@ChannelHandler.Sharable
/* loaded from: classes.dex */
public class ProtobufVarint32LengthFieldPrepender extends OneToOneEncoder {
    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) throws IOException {
        if (obj instanceof ChannelBuffer) {
            ChannelBuffer channelBuffer = (ChannelBuffer) obj;
            int i = channelBuffer.readableBytes();
            ChannelBuffer buffer = channel.getConfig().getBufferFactory().getBuffer(channelBuffer.order(), CodedOutputStream.computeRawVarint32Size(i));
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(new ChannelBufferOutputStream(buffer));
            codedOutputStreamNewInstance.writeRawVarint32(i);
            codedOutputStreamNewInstance.flush();
            return ChannelBuffers.wrappedBuffer(buffer, channelBuffer);
        }
        return obj;
    }
}
