package org.jboss.netty.channel;

/* loaded from: classes.dex */
public class FailedChannelFuture extends CompleteChannelFuture {
    private final Throwable cause;

    public FailedChannelFuture(Channel channel, Throwable th) {
        super(channel);
        if (th == null) {
            throw new NullPointerException("cause");
        }
        this.cause = th;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public Throwable getCause() {
        return this.cause;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean isSuccess() {
        return false;
    }
}
