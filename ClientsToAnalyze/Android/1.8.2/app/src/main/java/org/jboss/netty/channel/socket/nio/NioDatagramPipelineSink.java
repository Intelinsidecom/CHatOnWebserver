package org.jboss.netty.channel.socket.nio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.jboss.netty.channel.AbstractChannelSink;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelState;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;

/* loaded from: classes.dex */
class NioDatagramPipelineSink extends AbstractChannelSink {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final AtomicInteger nextId;

    /* renamed from: id */
    private final int f7854id = nextId.incrementAndGet();
    private final AtomicInteger workerIndex = new AtomicInteger();
    private final NioDatagramWorker[] workers;

    static {
        $assertionsDisabled = !NioDatagramPipelineSink.class.desiredAssertionStatus();
        nextId = new AtomicInteger();
    }

    NioDatagramPipelineSink(Executor executor, int i) {
        this.workers = new NioDatagramWorker[i];
        for (int i2 = 0; i2 < this.workers.length; i2++) {
            this.workers[i2] = new NioDatagramWorker(this.f7854id, i2 + 1, executor);
        }
    }

    @Override // org.jboss.netty.channel.ChannelSink
    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) {
        NioDatagramChannel nioDatagramChannel = (NioDatagramChannel) channelEvent.getChannel();
        ChannelFuture future = channelEvent.getFuture();
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            ChannelState state = channelStateEvent.getState();
            Object value = channelStateEvent.getValue();
            switch (state) {
                case OPEN:
                    if (Boolean.FALSE.equals(value)) {
                        nioDatagramChannel.worker.close(nioDatagramChannel, future);
                        return;
                    }
                    return;
                case BOUND:
                    if (value != null) {
                        bind(nioDatagramChannel, future, (InetSocketAddress) value);
                        return;
                    } else {
                        nioDatagramChannel.worker.close(nioDatagramChannel, future);
                        return;
                    }
                case CONNECTED:
                    if (value != null) {
                        connect(nioDatagramChannel, future, (InetSocketAddress) value);
                        return;
                    } else {
                        NioDatagramWorker.disconnect(nioDatagramChannel, future);
                        return;
                    }
                case INTEREST_OPS:
                    nioDatagramChannel.worker.setInterestOps(nioDatagramChannel, future, ((Integer) value).intValue());
                    return;
                default:
                    return;
            }
        }
        if (channelEvent instanceof MessageEvent) {
            boolean zOffer = nioDatagramChannel.writeBufferQueue.offer((MessageEvent) channelEvent);
            if (!$assertionsDisabled && !zOffer) {
                throw new AssertionError();
            }
            nioDatagramChannel.worker.writeFromUserCode(nioDatagramChannel);
        }
    }

    private void close(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture) {
        try {
            nioDatagramChannel.getDatagramChannel().socket().close();
            if (nioDatagramChannel.setClosed()) {
                channelFuture.setSuccess();
                if (nioDatagramChannel.isBound()) {
                    Channels.fireChannelUnbound(nioDatagramChannel);
                }
                Channels.fireChannelClosed(nioDatagramChannel);
                return;
            }
            channelFuture.setSuccess();
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(nioDatagramChannel, th);
        }
    }

    private void bind(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture, InetSocketAddress inetSocketAddress) {
        boolean z = false;
        try {
            try {
                nioDatagramChannel.getDatagramChannel().socket().bind(inetSocketAddress);
                z = true;
                channelFuture.setSuccess();
                Channels.fireChannelBound(nioDatagramChannel, inetSocketAddress);
                nioDatagramChannel.worker.register(nioDatagramChannel, null);
            } catch (Throwable th) {
                channelFuture.setFailure(th);
                Channels.fireExceptionCaught(nioDatagramChannel, th);
                if (z) {
                    close(nioDatagramChannel, channelFuture);
                }
            }
        } catch (Throwable th2) {
            if (z) {
                close(nioDatagramChannel, channelFuture);
            }
            throw th2;
        }
    }

    private void connect(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture, SocketAddress socketAddress) {
        boolean zIsBound = nioDatagramChannel.isBound();
        boolean z = false;
        channelFuture.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        nioDatagramChannel.remoteAddress = null;
        try {
            try {
                nioDatagramChannel.getDatagramChannel().connect(socketAddress);
                z = true;
                channelFuture.setSuccess();
                if (!zIsBound) {
                    Channels.fireChannelBound(nioDatagramChannel, nioDatagramChannel.getLocalAddress());
                }
                Channels.fireChannelConnected(nioDatagramChannel, nioDatagramChannel.getRemoteAddress());
                if (!zIsBound) {
                    nioDatagramChannel.worker.register(nioDatagramChannel, channelFuture);
                }
            } catch (Throwable th) {
                channelFuture.setFailure(th);
                Channels.fireExceptionCaught(nioDatagramChannel, th);
                if (z) {
                    nioDatagramChannel.worker.close(nioDatagramChannel, channelFuture);
                }
            }
        } catch (Throwable th2) {
            if (z) {
                nioDatagramChannel.worker.close(nioDatagramChannel, channelFuture);
            }
            throw th2;
        }
    }

    NioDatagramWorker nextWorker() {
        return this.workers[Math.abs(this.workerIndex.getAndIncrement() % this.workers.length)];
    }
}
