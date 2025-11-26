package com.sec.chaton.network.pipeline;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelDownstreamHandler;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelUpstreamHandler;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;

/* loaded from: classes.dex */
public abstract class OneToOneBicoder implements ChannelDownstreamHandler, ChannelUpstreamHandler {
    /* renamed from: a */
    protected abstract Object mo2830a(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj);

    /* renamed from: b */
    protected abstract Object mo2831b(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj);

    @Override // org.jboss.netty.channel.ChannelDownstreamHandler
    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        if (!(channelEvent instanceof MessageEvent)) {
            channelHandlerContext.sendDownstream(channelEvent);
            return;
        }
        MessageEvent messageEvent = (MessageEvent) channelEvent;
        Object message = messageEvent.getMessage();
        Object objMo2830a = mo2830a(channelHandlerContext, messageEvent.getChannel(), message);
        if (message == objMo2830a) {
            channelHandlerContext.sendDownstream(channelEvent);
        } else if (objMo2830a != null) {
            Channels.write(channelHandlerContext, messageEvent.getFuture(), objMo2830a, messageEvent.getRemoteAddress());
        }
    }

    @Override // org.jboss.netty.channel.ChannelUpstreamHandler
    public void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        if (!(channelEvent instanceof MessageEvent)) {
            channelHandlerContext.sendUpstream(channelEvent);
            return;
        }
        MessageEvent messageEvent = (MessageEvent) channelEvent;
        Object message = messageEvent.getMessage();
        Object objMo2831b = mo2831b(channelHandlerContext, messageEvent.getChannel(), message);
        if (message == objMo2831b) {
            channelHandlerContext.sendUpstream(channelEvent);
        } else if (objMo2831b != null) {
            Channels.fireMessageReceived(channelHandlerContext, objMo2831b, messageEvent.getRemoteAddress());
        }
    }
}
