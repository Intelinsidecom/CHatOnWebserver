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
    private final int f4564id = nextId.incrementAndGet();
    private final AtomicInteger workerIndex = new AtomicInteger();
    private final NioDatagramWorker[] workers;

    static {
        $assertionsDisabled = !NioDatagramPipelineSink.class.desiredAssertionStatus();
        nextId = new AtomicInteger();
    }

    NioDatagramPipelineSink(Executor executor, int i) {
        this.workers = new NioDatagramWorker[i];
        for (int i2 = 0; i2 < this.workers.length; i2++) {
            this.workers[i2] = new NioDatagramWorker(this.f4564id, i2 + 1, executor);
        }
    }

    private void bind(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture, InetSocketAddress inetSocketAddress) throws Throwable {
        boolean z;
        try {
            nioDatagramChannel.getDatagramChannel().socket().bind(inetSocketAddress);
        } catch (Throwable th) {
            th = th;
            z = false;
        }
        try {
            channelFuture.setSuccess();
            Channels.fireChannelBound(nioDatagramChannel, inetSocketAddress);
            nioDatagramChannel.worker.register(nioDatagramChannel, null);
            if (1 != 0 || 1 == 0) {
                return;
            }
        } catch (Throwable th2) {
            th = th2;
            z = true;
            try {
                channelFuture.setFailure(th);
                Channels.fireExceptionCaught(nioDatagramChannel, th);
                if (0 != 0 || !z) {
                    return;
                }
                close(nioDatagramChannel, channelFuture);
            } catch (Throwable th3) {
                th = th3;
                if (0 == 0 && z) {
                    close(nioDatagramChannel, channelFuture);
                }
                throw th;
            }
        }
        close(nioDatagramChannel, channelFuture);
    }

    private void close(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture) {
        try {
            nioDatagramChannel.getDatagramChannel().socket().close();
            if (!nioDatagramChannel.setClosed()) {
                channelFuture.setSuccess();
                return;
            }
            channelFuture.setSuccess();
            if (nioDatagramChannel.isBound()) {
                Channels.fireChannelUnbound(nioDatagramChannel);
            }
            Channels.fireChannelClosed(nioDatagramChannel);
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(nioDatagramChannel, th);
        }
    }

    private void connect(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture, SocketAddress socketAddress) throws Throwable {
        boolean z;
        NioDatagramWorker nioDatagramWorker;
        boolean zIsBound = nioDatagramChannel.isBound();
        channelFuture.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        nioDatagramChannel.remoteAddress = null;
        try {
            nioDatagramChannel.getDatagramChannel().connect(socketAddress);
        } catch (Throwable th) {
            th = th;
            z = false;
        }
        try {
            channelFuture.setSuccess();
            if (!zIsBound) {
                Channels.fireChannelBound(nioDatagramChannel, nioDatagramChannel.getLocalAddress());
            }
            Channels.fireChannelConnected(nioDatagramChannel, nioDatagramChannel.getRemoteAddress());
            if (!zIsBound) {
                nioDatagramChannel.worker.register(nioDatagramChannel, channelFuture);
            }
        } catch (Throwable th2) {
            th = th2;
            z = true;
            if (z) {
                nioDatagramChannel.worker.close(nioDatagramChannel, channelFuture);
            }
            throw th;
        }
        if (1 == 0 || 1 != 0) {
            return;
        }
        nioDatagramWorker = nioDatagramChannel.worker;
        nioDatagramWorker.close(nioDatagramChannel, channelFuture);
    }

    @Override // org.jboss.netty.channel.ChannelSink
    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) throws Throwable {
        NioDatagramChannel nioDatagramChannel = (NioDatagramChannel) channelEvent.getChannel();
        ChannelFuture future = channelEvent.getFuture();
        if (!(channelEvent instanceof ChannelStateEvent)) {
            if (channelEvent instanceof MessageEvent) {
                boolean zOffer = nioDatagramChannel.writeBufferQueue.offer((MessageEvent) channelEvent);
                if (!$assertionsDisabled && !zOffer) {
                    throw new AssertionError();
                }
                nioDatagramChannel.worker.writeFromUserCode(nioDatagramChannel);
                return;
            }
            return;
        }
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

    NioDatagramWorker nextWorker() {
        return this.workers[Math.abs(this.workerIndex.getAndIncrement() % this.workers.length)];
    }
}
