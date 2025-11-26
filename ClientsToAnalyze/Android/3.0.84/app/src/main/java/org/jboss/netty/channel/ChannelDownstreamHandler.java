package org.jboss.netty.channel;

/* loaded from: classes.dex */
public interface ChannelDownstreamHandler extends ChannelHandler {
    void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent);
}
