package org.jboss.netty.channel.local;

import org.jboss.netty.channel.AbstractChannelSink;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelState;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;

/* loaded from: classes.dex */
final class LocalServerChannelSink extends AbstractChannelSink {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !LocalServerChannelSink.class.desiredAssertionStatus();
    }

    LocalServerChannelSink() {
    }

    @Override // org.jboss.netty.channel.ChannelSink
    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) {
        Channel channel = channelEvent.getChannel();
        if (channel instanceof DefaultLocalServerChannel) {
            handleServerChannel(channelEvent);
        } else if (channel instanceof DefaultLocalChannel) {
            handleAcceptedChannel(channelEvent);
        }
    }

    private void handleServerChannel(ChannelEvent channelEvent) {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            DefaultLocalServerChannel defaultLocalServerChannel = (DefaultLocalServerChannel) channelStateEvent.getChannel();
            ChannelFuture future = channelStateEvent.getFuture();
            ChannelState state = channelStateEvent.getState();
            Object value = channelStateEvent.getValue();
            switch (state) {
                case OPEN:
                    if (Boolean.FALSE.equals(value)) {
                        close(defaultLocalServerChannel, future);
                        break;
                    }
                    break;
                case BOUND:
                    if (value != null) {
                        bind(defaultLocalServerChannel, future, (LocalAddress) value);
                        break;
                    } else {
                        close(defaultLocalServerChannel, future);
                        break;
                    }
            }
        }
    }

    private void handleAcceptedChannel(ChannelEvent channelEvent) {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            DefaultLocalChannel defaultLocalChannel = (DefaultLocalChannel) channelStateEvent.getChannel();
            ChannelFuture future = channelStateEvent.getFuture();
            ChannelState state = channelStateEvent.getState();
            Object value = channelStateEvent.getValue();
            switch (state) {
                case OPEN:
                    if (Boolean.FALSE.equals(value)) {
                        defaultLocalChannel.closeNow(future);
                        return;
                    }
                    return;
                case BOUND:
                case CONNECTED:
                    if (value == null) {
                        defaultLocalChannel.closeNow(future);
                        return;
                    }
                    return;
                case INTEREST_OPS:
                    future.setSuccess();
                    return;
                default:
                    return;
            }
        }
        if (channelEvent instanceof MessageEvent) {
            MessageEvent messageEvent = (MessageEvent) channelEvent;
            DefaultLocalChannel defaultLocalChannel2 = (DefaultLocalChannel) messageEvent.getChannel();
            boolean zOffer = defaultLocalChannel2.writeBuffer.offer(messageEvent);
            if (!$assertionsDisabled && !zOffer) {
                throw new AssertionError();
            }
            defaultLocalChannel2.flushWriteBuffer();
        }
    }

    private void bind(DefaultLocalServerChannel defaultLocalServerChannel, ChannelFuture channelFuture, LocalAddress localAddress) {
        try {
            if (!LocalChannelRegistry.register(localAddress, defaultLocalServerChannel)) {
                throw new ChannelException("address already in use: " + localAddress);
            }
            if (!defaultLocalServerChannel.bound.compareAndSet(false, true)) {
                throw new ChannelException("already bound");
            }
            defaultLocalServerChannel.localAddress = localAddress;
            channelFuture.setSuccess();
            Channels.fireChannelBound(defaultLocalServerChannel, localAddress);
        } catch (Throwable th) {
            LocalChannelRegistry.unregister(localAddress);
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(defaultLocalServerChannel, th);
        }
    }

    private void close(DefaultLocalServerChannel defaultLocalServerChannel, ChannelFuture channelFuture) {
        try {
            if (defaultLocalServerChannel.setClosed()) {
                channelFuture.setSuccess();
                LocalAddress localAddress = defaultLocalServerChannel.localAddress;
                if (defaultLocalServerChannel.bound.compareAndSet(true, false)) {
                    defaultLocalServerChannel.localAddress = null;
                    LocalChannelRegistry.unregister(localAddress);
                    Channels.fireChannelUnbound(defaultLocalServerChannel);
                }
                Channels.fireChannelClosed(defaultLocalServerChannel);
                return;
            }
            channelFuture.setSuccess();
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(defaultLocalServerChannel, th);
        }
    }
}
