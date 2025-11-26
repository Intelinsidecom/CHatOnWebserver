package org.jboss.netty.handler.codec.protobuf;

import com.google.protobuf.MessageLite;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

@ChannelHandler.Sharable
/* loaded from: classes.dex */
public class ProtobufEncoder extends OneToOneEncoder {
    @Override // org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        return !(obj instanceof MessageLite) ? obj : ChannelBuffers.wrappedBuffer(((MessageLite) obj).toByteArray());
    }
}
