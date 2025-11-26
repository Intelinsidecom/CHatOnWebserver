package org.jboss.netty.channel;

import org.jboss.netty.util.ExternalResourceReleasable;

/* loaded from: classes.dex */
public interface ChannelFactory extends ExternalResourceReleasable {
    Channel newChannel(ChannelPipeline channelPipeline);

    @Override // org.jboss.netty.util.ExternalResourceReleasable
    void releaseExternalResources();
}
