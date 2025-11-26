package org.jboss.netty.handler.timeout;

import org.jboss.netty.channel.ChannelEvent;

/* loaded from: classes.dex */
public interface IdleStateEvent extends ChannelEvent {
    long getLastActivityTimeMillis();

    IdleState getState();
}
