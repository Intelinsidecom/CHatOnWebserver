package org.jboss.netty.channel.socket.nio;

import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.jboss.netty.channel.AbstractChannelSink;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelState;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.ThreadRenamingRunnable;
import org.jboss.netty.util.internal.DeadLockProofWorker;

/* loaded from: classes.dex */
class NioServerSocketPipelineSink extends AbstractChannelSink {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final InternalLogger logger;
    private static final AtomicInteger nextId;

    /* renamed from: id */
    private final int f4566id = nextId.incrementAndGet();
    private final AtomicInteger workerIndex = new AtomicInteger();
    private final NioWorker[] workers;

    final class Boss implements Runnable {
        private final NioServerSocketChannel channel;
        private final Selector selector = Selector.open();

        Boss(NioServerSocketChannel nioServerSocketChannel) throws IOException {
            this.channel = nioServerSocketChannel;
            try {
                nioServerSocketChannel.socket.register(this.selector, 16);
                if (1 == 0) {
                    closeSelector();
                }
                nioServerSocketChannel.selector = this.selector;
            } catch (Throwable th) {
                if (0 == 0) {
                    closeSelector();
                }
                throw th;
            }
        }

        private void closeSelector() throws IOException {
            this.channel.selector = null;
            try {
                this.selector.close();
            } catch (Exception e) {
                NioServerSocketPipelineSink.logger.warn("Failed to close a selector.", e);
            }
        }

        private void registerAcceptedChannel(SocketChannel socketChannel, Thread thread) {
            try {
                ChannelPipeline pipeline = this.channel.getConfig().getPipelineFactory().getPipeline();
                NioWorker nioWorkerNextWorker = NioServerSocketPipelineSink.this.nextWorker();
                nioWorkerNextWorker.register(new NioAcceptedSocketChannel(this.channel.getFactory(), pipeline, this.channel, NioServerSocketPipelineSink.this, socketChannel, nioWorkerNextWorker, thread), null);
            } catch (Exception e) {
                NioServerSocketPipelineSink.logger.warn("Failed to initialize an accepted socket.", e);
                try {
                    socketChannel.close();
                } catch (IOException e2) {
                    NioServerSocketPipelineSink.logger.warn("Failed to close a partially accepted socket.", e2);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            Thread threadCurrentThread = Thread.currentThread();
            this.channel.shutdownLock.lock();
            while (true) {
                try {
                    try {
                        if (this.selector.select(1000L) > 0) {
                            this.selector.selectedKeys().clear();
                        }
                        SocketChannel socketChannelAccept = this.channel.socket.accept();
                        if (socketChannelAccept != null) {
                            registerAcceptedChannel(socketChannelAccept, threadCurrentThread);
                        }
                    } catch (SocketTimeoutException e) {
                    } catch (CancelledKeyException e2) {
                    } catch (ClosedChannelException e3) {
                        this.channel.shutdownLock.unlock();
                        closeSelector();
                        return;
                    } catch (ClosedSelectorException e4) {
                    } catch (Throwable th) {
                        NioServerSocketPipelineSink.logger.warn("Failed to accept a connection.", th);
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e5) {
                        }
                    }
                } catch (Throwable th2) {
                    this.channel.shutdownLock.unlock();
                    closeSelector();
                    throw th2;
                }
            }
        }
    }

    static {
        $assertionsDisabled = !NioServerSocketPipelineSink.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(NioServerSocketPipelineSink.class);
        nextId = new AtomicInteger();
    }

    NioServerSocketPipelineSink(Executor executor, int i) {
        this.workers = new NioWorker[i];
        for (int i2 = 0; i2 < this.workers.length; i2++) {
            this.workers[i2] = new NioWorker(this.f4566id, i2 + 1, executor);
        }
    }

    private void bind(NioServerSocketChannel nioServerSocketChannel, ChannelFuture channelFuture, SocketAddress socketAddress) throws Throwable {
        boolean z;
        try {
            nioServerSocketChannel.socket.socket().bind(socketAddress, nioServerSocketChannel.getConfig().getBacklog());
            try {
                channelFuture.setSuccess();
                Channels.fireChannelBound(nioServerSocketChannel, nioServerSocketChannel.getLocalAddress());
                DeadLockProofWorker.start(((NioServerSocketChannelFactory) nioServerSocketChannel.getFactory()).bossExecutor, new ThreadRenamingRunnable(new Boss(nioServerSocketChannel), "New I/O server boss #" + this.f4566id + " (" + nioServerSocketChannel + ')'));
                if (1 != 0 || 1 == 0) {
                    return;
                }
                close(nioServerSocketChannel, channelFuture);
            } catch (Throwable th) {
                th = th;
                z = true;
                try {
                    channelFuture.setFailure(th);
                    Channels.fireExceptionCaught(nioServerSocketChannel, th);
                    if (0 == 0 && z) {
                        close(nioServerSocketChannel, channelFuture);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (0 == 0 && z) {
                        close(nioServerSocketChannel, channelFuture);
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }

    private void close(NioServerSocketChannel nioServerSocketChannel, ChannelFuture channelFuture) {
        boolean zIsBound = nioServerSocketChannel.isBound();
        try {
            if (nioServerSocketChannel.socket.isOpen()) {
                nioServerSocketChannel.socket.close();
                Selector selector = nioServerSocketChannel.selector;
                if (selector != null) {
                    selector.wakeup();
                }
            }
            nioServerSocketChannel.shutdownLock.lock();
            try {
                if (nioServerSocketChannel.setClosed()) {
                    channelFuture.setSuccess();
                    if (zIsBound) {
                        Channels.fireChannelUnbound(nioServerSocketChannel);
                    }
                    Channels.fireChannelClosed(nioServerSocketChannel);
                } else {
                    channelFuture.setSuccess();
                }
            } finally {
                nioServerSocketChannel.shutdownLock.unlock();
            }
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(nioServerSocketChannel, th);
        }
    }

    private void handleAcceptedSocket(ChannelEvent channelEvent) {
        if (!(channelEvent instanceof ChannelStateEvent)) {
            if (channelEvent instanceof MessageEvent) {
                MessageEvent messageEvent = (MessageEvent) channelEvent;
                NioSocketChannel nioSocketChannel = (NioSocketChannel) messageEvent.getChannel();
                boolean zOffer = nioSocketChannel.writeBuffer.offer(messageEvent);
                if (!$assertionsDisabled && !zOffer) {
                    throw new AssertionError();
                }
                nioSocketChannel.worker.writeFromUserCode(nioSocketChannel);
                return;
            }
            return;
        }
        ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
        NioSocketChannel nioSocketChannel2 = (NioSocketChannel) channelStateEvent.getChannel();
        ChannelFuture future = channelStateEvent.getFuture();
        ChannelState state = channelStateEvent.getState();
        Object value = channelStateEvent.getValue();
        switch (state) {
            case OPEN:
                if (Boolean.FALSE.equals(value)) {
                    nioSocketChannel2.worker.close(nioSocketChannel2, future);
                    return;
                }
                return;
            case BOUND:
            case CONNECTED:
                if (value == null) {
                    nioSocketChannel2.worker.close(nioSocketChannel2, future);
                    return;
                }
                return;
            case INTEREST_OPS:
                nioSocketChannel2.worker.setInterestOps(nioSocketChannel2, future, ((Integer) value).intValue());
                return;
            default:
                return;
        }
    }

    private void handleServerSocket(ChannelEvent channelEvent) throws Throwable {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            NioServerSocketChannel nioServerSocketChannel = (NioServerSocketChannel) channelStateEvent.getChannel();
            ChannelFuture future = channelStateEvent.getFuture();
            ChannelState state = channelStateEvent.getState();
            Object value = channelStateEvent.getValue();
            switch (state) {
                case OPEN:
                    if (Boolean.FALSE.equals(value)) {
                        close(nioServerSocketChannel, future);
                        break;
                    }
                    break;
                case BOUND:
                    if (value == null) {
                        close(nioServerSocketChannel, future);
                        break;
                    } else {
                        bind(nioServerSocketChannel, future, (SocketAddress) value);
                        break;
                    }
            }
        }
    }

    @Override // org.jboss.netty.channel.ChannelSink
    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) throws Throwable {
        Channel channel = channelEvent.getChannel();
        if (channel instanceof NioServerSocketChannel) {
            handleServerSocket(channelEvent);
        } else if (channel instanceof NioSocketChannel) {
            handleAcceptedSocket(channelEvent);
        }
    }

    NioWorker nextWorker() {
        return this.workers[Math.abs(this.workerIndex.getAndIncrement() % this.workers.length)];
    }
}
