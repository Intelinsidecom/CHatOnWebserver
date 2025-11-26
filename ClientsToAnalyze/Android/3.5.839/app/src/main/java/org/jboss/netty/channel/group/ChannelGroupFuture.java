package org.jboss.netty.channel.group;

import org.jboss.netty.channel.ChannelFuture;

/* loaded from: classes.dex */
public interface ChannelGroupFuture extends Iterable<ChannelFuture> {
    void addListener(ChannelGroupFutureListener channelGroupFutureListener);

    ChannelGroupFuture awaitUninterruptibly();

    boolean isCompleteFailure();

    boolean isCompleteSuccess();
}
