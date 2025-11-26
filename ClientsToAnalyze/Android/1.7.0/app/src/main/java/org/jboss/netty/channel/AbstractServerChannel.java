package org.jboss.netty.channel;

import java.net.SocketAddress;

/* loaded from: classes.dex */
public abstract class AbstractServerChannel extends AbstractChannel implements ServerChannel {
    protected AbstractServerChannel(ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink) {
        super(null, channelFactory, channelPipeline, channelSink);
    }

    @Override // org.jboss.netty.channel.AbstractChannel, org.jboss.netty.channel.Channel
    public ChannelFuture connect(SocketAddress socketAddress) {
        return getUnsupportedOperationFuture();
    }

    @Override // org.jboss.netty.channel.AbstractChannel, org.jboss.netty.channel.Channel
    public ChannelFuture disconnect() {
        return getUnsupportedOperationFuture();
    }

    @Override // org.jboss.netty.channel.AbstractChannel, org.jboss.netty.channel.Channel
    public int getInterestOps() {
        return 0;
    }

    @Override // org.jboss.netty.channel.AbstractChannel, org.jboss.netty.channel.Channel
    public ChannelFuture setInterestOps(int i) {
        return getUnsupportedOperationFuture();
    }

    @Override // org.jboss.netty.channel.AbstractChannel
    protected void setInterestOpsNow(int i) {
    }

    @Override // org.jboss.netty.channel.AbstractChannel, org.jboss.netty.channel.Channel
    public ChannelFuture write(Object obj) {
        return getUnsupportedOperationFuture();
    }

    @Override // org.jboss.netty.channel.AbstractChannel, org.jboss.netty.channel.Channel
    public ChannelFuture write(Object obj, SocketAddress socketAddress) {
        return getUnsupportedOperationFuture();
    }

    @Override // org.jboss.netty.channel.Channel
    public boolean isConnected() {
        return false;
    }
}
