package org.jboss.netty.channel;

import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

/* loaded from: classes.dex */
public abstract class CompleteChannelFuture implements ChannelFuture {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) CompleteChannelFuture.class);
    private final Channel channel;

    protected CompleteChannelFuture(Channel channel) {
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        this.channel = channel;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public void addListener(ChannelFutureListener channelFutureListener) {
        try {
            channelFutureListener.operationComplete(this);
        } catch (Throwable th) {
            logger.warn("An exception was thrown by " + ChannelFutureListener.class.getSimpleName() + ".", th);
        }
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public void removeListener(ChannelFutureListener channelFutureListener) {
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public ChannelFuture awaitUninterruptibly() {
        return this;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean awaitUninterruptibly(long j) {
        return true;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public Channel getChannel() {
        return this.channel;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean isDone() {
        return true;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean setProgress(long j, long j2, long j3) {
        return false;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean setFailure(Throwable th) {
        return false;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean setSuccess() {
        return false;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean isCancelled() {
        return false;
    }
}
