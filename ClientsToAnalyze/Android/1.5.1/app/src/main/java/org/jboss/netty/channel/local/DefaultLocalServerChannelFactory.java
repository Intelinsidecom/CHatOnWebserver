package org.jboss.netty.channel.local;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;

/* loaded from: classes.dex */
public class DefaultLocalServerChannelFactory implements LocalServerChannelFactory {
    private final ChannelSink sink = new LocalServerChannelSink();

    @Override // org.jboss.netty.channel.ServerChannelFactory, org.jboss.netty.channel.ChannelFactory
    public LocalServerChannel newChannel(ChannelPipeline channelPipeline) {
        return new DefaultLocalServerChannel(this, channelPipeline, this.sink);
    }

    @Override // org.jboss.netty.channel.ChannelFactory, org.jboss.netty.util.ExternalResourceReleasable
    public void releaseExternalResources() {
    }
}
