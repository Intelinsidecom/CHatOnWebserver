package org.jboss.netty.channel;

/* loaded from: classes.dex */
public abstract class AbstractChannelSink implements ChannelSink {
    protected AbstractChannelSink() {
    }

    @Override // org.jboss.netty.channel.ChannelSink
    public void exceptionCaught(ChannelPipeline channelPipeline, ChannelEvent channelEvent, ChannelPipelineException channelPipelineException) {
        Throwable cause = channelPipelineException.getCause();
        if (cause != null) {
            channelPipelineException = cause;
        }
        Channels.fireExceptionCaught(channelEvent.getChannel(), channelPipelineException);
    }
}
