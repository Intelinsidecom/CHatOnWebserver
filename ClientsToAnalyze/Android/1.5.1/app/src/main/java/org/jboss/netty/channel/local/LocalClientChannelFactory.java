package org.jboss.netty.channel.local;

import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipeline;

/* loaded from: classes.dex */
public interface LocalClientChannelFactory extends ChannelFactory {
    @Override // org.jboss.netty.channel.ChannelFactory
    LocalChannel newChannel(ChannelPipeline channelPipeline);
}
