package org.jboss.netty.channel;

/* loaded from: classes.dex */
public interface ChannelStateEvent extends ChannelEvent {
    ChannelState getState();

    Object getValue();
}
