package org.jboss.netty.channel;

/* loaded from: classes.dex */
public interface ChannelHandlerContext {
    Object getAttachment();

    Channel getChannel();

    ChannelHandler getHandler();

    String getName();

    ChannelPipeline getPipeline();

    void sendDownstream(ChannelEvent channelEvent);

    void sendUpstream(ChannelEvent channelEvent);

    void setAttachment(Object obj);
}
