package org.jboss.netty.channel;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public interface ChannelFuture {
    void addListener(ChannelFutureListener channelFutureListener);

    ChannelFuture await();

    boolean await(long j);

    boolean await(long j, TimeUnit timeUnit);

    ChannelFuture awaitUninterruptibly();

    boolean awaitUninterruptibly(long j);

    boolean awaitUninterruptibly(long j, TimeUnit timeUnit);

    boolean cancel();

    Throwable getCause();

    Channel getChannel();

    boolean isCancelled();

    boolean isDone();

    boolean isSuccess();

    void removeListener(ChannelFutureListener channelFutureListener);

    boolean setFailure(Throwable th);

    boolean setProgress(long j, long j2, long j3);

    boolean setSuccess();
}
