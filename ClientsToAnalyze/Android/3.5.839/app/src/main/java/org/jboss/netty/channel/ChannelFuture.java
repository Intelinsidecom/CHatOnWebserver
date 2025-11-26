package org.jboss.netty.channel;

/* loaded from: classes.dex */
public interface ChannelFuture {
    void addListener(ChannelFutureListener channelFutureListener);

    ChannelFuture awaitUninterruptibly();

    boolean awaitUninterruptibly(long j);

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
