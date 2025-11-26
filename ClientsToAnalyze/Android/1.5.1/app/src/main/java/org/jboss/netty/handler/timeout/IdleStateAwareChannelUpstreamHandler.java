package org.jboss.netty.handler.timeout;

import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;

/* loaded from: classes.dex */
public class IdleStateAwareChannelUpstreamHandler extends SimpleChannelUpstreamHandler {
    public void channelIdle(ChannelHandlerContext channelHandlerContext, IdleStateEvent idleStateEvent) {
        channelHandlerContext.sendUpstream(idleStateEvent);
    }

    @Override // org.jboss.netty.channel.SimpleChannelUpstreamHandler, org.jboss.netty.channel.ChannelUpstreamHandler
    public void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        if (channelEvent instanceof IdleStateEvent) {
            channelIdle(channelHandlerContext, (IdleStateEvent) channelEvent);
        } else {
            super.handleUpstream(channelHandlerContext, channelEvent);
        }
    }
}
