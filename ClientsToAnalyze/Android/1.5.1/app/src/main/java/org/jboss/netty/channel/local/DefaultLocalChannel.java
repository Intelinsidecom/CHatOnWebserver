package org.jboss.netty.channel.local;

import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import org.jboss.netty.channel.AbstractChannel;
import org.jboss.netty.channel.ChannelConfig;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelSink;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.DefaultChannelConfig;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.util.internal.LinkedTransferQueue;
import org.jboss.netty.util.internal.ThreadLocalBoolean;

/* loaded from: classes.dex */
final class DefaultLocalChannel extends AbstractChannel implements LocalChannel {
    private static final int ST_BOUND = 1;
    private static final int ST_CLOSED = -1;
    private static final int ST_CONNECTED = 2;
    private static final int ST_OPEN = 0;
    private final ChannelConfig config;
    private final ThreadLocalBoolean delivering;
    volatile LocalAddress localAddress;
    volatile DefaultLocalChannel pairedChannel;
    volatile LocalAddress remoteAddress;
    final AtomicInteger state;
    final Queue writeBuffer;

    DefaultLocalChannel(LocalServerChannel localServerChannel, ChannelFactory channelFactory, ChannelPipeline channelPipeline, ChannelSink channelSink, DefaultLocalChannel defaultLocalChannel) {
        super(localServerChannel, channelFactory, channelPipeline, channelSink);
        this.state = new AtomicInteger(0);
        this.delivering = new ThreadLocalBoolean();
        this.writeBuffer = new LinkedTransferQueue();
        this.pairedChannel = defaultLocalChannel;
        this.config = new DefaultChannelConfig();
        getCloseFuture().addListener(new ChannelFutureListener() { // from class: org.jboss.netty.channel.local.DefaultLocalChannel.1
            @Override // org.jboss.netty.channel.ChannelFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                DefaultLocalChannel.this.state.set(-1);
            }
        });
        Channels.fireChannelOpen(this);
    }

    void closeNow(ChannelFuture channelFuture) {
        LocalAddress localAddress = this.localAddress;
        try {
            if (setClosed()) {
                DefaultLocalChannel defaultLocalChannel = this.pairedChannel;
                if (defaultLocalChannel != null) {
                    this.pairedChannel = null;
                    Channels.fireChannelDisconnected(this);
                    Channels.fireChannelUnbound(this);
                }
                Channels.fireChannelClosed(this);
                if (defaultLocalChannel == null || !defaultLocalChannel.setClosed()) {
                    channelFuture.setSuccess();
                    if (localAddress == null || getParent() != null) {
                    }
                } else {
                    if (defaultLocalChannel.pairedChannel != null) {
                        defaultLocalChannel.pairedChannel = null;
                        Channels.fireChannelDisconnected(defaultLocalChannel);
                        Channels.fireChannelUnbound(defaultLocalChannel);
                    }
                    Channels.fireChannelClosed(defaultLocalChannel);
                    channelFuture.setSuccess();
                    if (localAddress == null || getParent() != null) {
                    }
                }
            }
        } finally {
            channelFuture.setSuccess();
            if (localAddress != null && getParent() == null) {
                LocalChannelRegistry.unregister(localAddress);
            }
        }
    }

    void flushWriteBuffer() {
        DefaultLocalChannel defaultLocalChannel = this.pairedChannel;
        if (defaultLocalChannel == null) {
            Throwable notYetConnectedException = isOpen() ? new NotYetConnectedException() : new ClosedChannelException();
            while (true) {
                MessageEvent messageEvent = (MessageEvent) this.writeBuffer.poll();
                if (messageEvent == null) {
                    return;
                }
                messageEvent.getFuture().setFailure(notYetConnectedException);
                Channels.fireExceptionCaught(this, notYetConnectedException);
            }
        } else {
            if (!defaultLocalChannel.isConnected() || ((Boolean) this.delivering.get()).booleanValue()) {
                return;
            }
            this.delivering.set(true);
            while (true) {
                try {
                    MessageEvent messageEvent2 = (MessageEvent) this.writeBuffer.poll();
                    if (messageEvent2 == null) {
                        return;
                    }
                    messageEvent2.getFuture().setSuccess();
                    Channels.fireMessageReceived(defaultLocalChannel, messageEvent2.getMessage());
                    Channels.fireWriteComplete(this, 1L);
                } finally {
                    this.delivering.set(false);
                }
            }
        }
    }

    @Override // org.jboss.netty.channel.Channel
    public ChannelConfig getConfig() {
        return this.config;
    }

    @Override // org.jboss.netty.channel.Channel
    public LocalAddress getLocalAddress() {
        return this.localAddress;
    }

    @Override // org.jboss.netty.channel.Channel
    public LocalAddress getRemoteAddress() {
        return this.remoteAddress;
    }

    @Override // org.jboss.netty.channel.Channel
    public boolean isBound() {
        return this.state.get() >= 1;
    }

    @Override // org.jboss.netty.channel.Channel
    public boolean isConnected() {
        return this.state.get() == 2;
    }

    @Override // org.jboss.netty.channel.AbstractChannel, org.jboss.netty.channel.Channel
    public boolean isOpen() {
        return this.state.get() >= 0;
    }

    final void setBound() throws ClosedChannelException {
        if (this.state.compareAndSet(0, 1)) {
            return;
        }
        switch (this.state.get()) {
            case -1:
                throw new ClosedChannelException();
            default:
                throw new ChannelException("already bound");
        }
    }

    @Override // org.jboss.netty.channel.AbstractChannel
    protected boolean setClosed() {
        return super.setClosed();
    }

    final void setConnected() {
        if (this.state.get() != -1) {
            this.state.set(2);
        }
    }
}
