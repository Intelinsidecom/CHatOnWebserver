package org.jboss.netty.channel.group;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;

/* loaded from: classes.dex */
public interface ChannelGroupFuture extends Iterable {
    void addListener(ChannelGroupFutureListener channelGroupFutureListener);

    ChannelGroupFuture await();

    boolean await(long j);

    boolean await(long j, TimeUnit timeUnit);

    ChannelGroupFuture awaitUninterruptibly();

    boolean awaitUninterruptibly(long j);

    boolean awaitUninterruptibly(long j, TimeUnit timeUnit);

    ChannelFuture find(Integer num);

    ChannelFuture find(Channel channel);

    ChannelGroup getGroup();

    boolean isCompleteFailure();

    boolean isCompleteSuccess();

    boolean isDone();

    boolean isPartialFailure();

    boolean isPartialSuccess();

    @Override // java.lang.Iterable
    Iterator iterator();

    void removeListener(ChannelGroupFutureListener channelGroupFutureListener);
}
