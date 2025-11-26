package org.jboss.netty.handler.codec.rtsp;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.http.HttpMessage;
import org.jboss.netty.handler.codec.http.HttpMessageEncoder;

@ChannelHandler.Sharable
/* loaded from: classes.dex */
public abstract class RtspMessageEncoder extends HttpMessageEncoder {
    protected RtspMessageEncoder() {
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessageEncoder, org.jboss.netty.handler.codec.oneone.OneToOneEncoder
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        return !(obj instanceof HttpMessage) ? obj : super.encode(channelHandlerContext, channel, obj);
    }
}
