package org.jboss.netty.channel;

/* loaded from: classes.dex */
public interface ChannelSink {
    void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent);

    void exceptionCaught(ChannelPipeline channelPipeline, ChannelEvent channelEvent, ChannelPipelineException channelPipelineException);
}
