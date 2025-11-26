package org.jboss.netty.handler.codec.embedder;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;

/* loaded from: classes.dex */
class EmbeddedChannelFactory implements ChannelFactory {
    static final ChannelFactory INSTANCE = new EmbeddedChannelFactory();

    private EmbeddedChannelFactory() {
    }

    @Override // org.jboss.netty.channel.ChannelFactory
    public Channel newChannel(ChannelPipeline channelPipeline) {
        throw new UnsupportedOperationException();
    }

    @Override // org.jboss.netty.channel.ChannelFactory, org.jboss.netty.util.ExternalResourceReleasable
    public void releaseExternalResources() {
    }
}
