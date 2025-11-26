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
        if (!(obj instanceof ChannelBuffer)) {
            return obj;
        }
        ChannelBuffer channelBuffer = (ChannelBuffer) obj;
        int i = channelBuffer.readableBytes();
        ChannelBuffer buffer = channel.getConfig().getBufferFactory().getBuffer(channelBuffer.order(), CodedOutputStream.m316i(i));
        CodedOutputStream codedOutputStreamM297a = CodedOutputStream.m297a(new ChannelBufferOutputStream(buffer));
        codedOutputStreamM297a.m338h(i);
        codedOutputStreamM297a.m317a();
        return ChannelBuffers.wrappedBuffer(buffer, channelBuffer);
    }
}
