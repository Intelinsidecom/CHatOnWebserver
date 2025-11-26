package org.jboss.netty.channel;

/* loaded from: classes.dex */
public interface ChannelUpstreamHandler extends ChannelHandler {
    void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent);
}
