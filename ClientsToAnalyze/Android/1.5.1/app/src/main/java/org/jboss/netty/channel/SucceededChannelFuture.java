package org.jboss.netty.channel;

/* loaded from: classes.dex */
public class SucceededChannelFuture extends CompleteChannelFuture {
    public SucceededChannelFuture(Channel channel) {
        super(channel);
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public Throwable getCause() {
        return null;
    }

    @Override // org.jboss.netty.channel.ChannelFuture
    public boolean isSuccess() {
        return true;
    }
}
