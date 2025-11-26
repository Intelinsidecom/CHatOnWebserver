package org.jboss.netty.channel;

/* loaded from: classes.dex */
public interface ChildChannelStateEvent extends ChannelEvent {
    @Override // org.jboss.netty.channel.ChannelEvent
    Channel getChannel();

    Channel getChildChannel();
}
