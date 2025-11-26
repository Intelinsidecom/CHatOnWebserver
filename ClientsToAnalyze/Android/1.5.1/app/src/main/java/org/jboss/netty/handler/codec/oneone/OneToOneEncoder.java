package org.jboss.netty.handler.codec.oneone;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelDownstreamHandler;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;

/* loaded from: classes.dex */
public abstract class OneToOneEncoder implements ChannelDownstreamHandler {
    protected OneToOneEncoder() {
    }

    protected abstract Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj);

    @Override // org.jboss.netty.channel.ChannelDownstreamHandler
    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        if (!(channelEvent instanceof MessageEvent)) {
            channelHandlerContext.sendDownstream(channelEvent);
            return;
        }
        MessageEvent messageEvent = (MessageEvent) channelEvent;
        Object message = messageEvent.getMessage();
        Object objEncode = encode(channelHandlerContext, messageEvent.getChannel(), message);
        if (message == objEncode) {
            channelHandlerContext.sendDownstream(channelEvent);
        } else if (objEncode != null) {
            Channels.write(channelHandlerContext, messageEvent.getFuture(), objEncode, messageEvent.getRemoteAddress());
        }
    }
}
