package org.jboss.netty.channel;

/* loaded from: classes.dex */
public interface LifeCycleAwareChannelHandler extends ChannelHandler {
    void afterAdd(ChannelHandlerContext channelHandlerContext);

    void afterRemove(ChannelHandlerContext channelHandlerContext);

    void beforeAdd(ChannelHandlerContext channelHandlerContext);

    void beforeRemove(ChannelHandlerContext channelHandlerContext);
}
