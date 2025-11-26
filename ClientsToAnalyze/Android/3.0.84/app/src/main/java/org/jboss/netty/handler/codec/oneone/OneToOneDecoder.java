package org.jboss.netty.handler.codec.oneone;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelUpstreamHandler;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;

/* loaded from: classes.dex */
public abstract class OneToOneDecoder implements ChannelUpstreamHandler {
    protected abstract Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj);

    protected OneToOneDecoder() {
    }

    @Override // org.jboss.netty.channel.ChannelUpstreamHandler
    public void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        if (!(channelEvent instanceof MessageEvent)) {
            channelHandlerContext.sendUpstream(channelEvent);
            return;
        }
        MessageEvent messageEvent = (MessageEvent) channelEvent;
        Object message = messageEvent.getMessage();
        Object objDecode = decode(channelHandlerContext, messageEvent.getChannel(), message);
        if (message == objDecode) {
            channelHandlerContext.sendUpstream(channelEvent);
        } else if (objDecode != null) {
            Channels.fireMessageReceived(channelHandlerContext, objDecode, messageEvent.getRemoteAddress());
        }
    }
}
