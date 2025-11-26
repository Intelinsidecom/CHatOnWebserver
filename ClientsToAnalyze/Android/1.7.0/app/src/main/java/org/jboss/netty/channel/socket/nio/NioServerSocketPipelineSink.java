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
    private final int f5795id = nextId.incrementAndGet();
    private final AtomicInteger workerIndex = new AtomicInteger();
    private final NioWorker[] workers;

    static {
        $assertionsDisabled = !NioServerSocketPipelineSink.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(NioServerSocketPipelineSink.class);
        nextId = new AtomicInteger();
    }

    NioServerSocketPipelineSink(Executor executor, int i) {
        this.workers = new NioWorker[i];
        for (int i2 = 0; i2 < this.workers.length; i2++) {
            this.workers[i2] = new NioWorker(this.f5795id, i2 + 1, executor);
        }
    }

    @Override // org.jboss.netty.channel.ChannelSink
    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) {
        Channel channel = channelEvent.getChannel();
        if (channel instanceof NioServerSocketChannel) {
            handleServerSocket(channelEvent);
        } else if (channel instanceof NioSocketChannel) {
            handleAcceptedSocket(channelEvent);
        }
    }

    private void handleServerSocket(ChannelEvent channelEvent) {
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
                    if (value != null) {
                        bind(nioServerSocketChannel, future, (SocketAddress) value);
                        break;
                    } else {
                        close(nioServerSocketChannel, future);
                        break;
                    }
            }
        }
    }

    private void handleAcceptedSocket(ChannelEvent channelEvent) {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            NioSocketChannel nioSocketChannel = (NioSocketChannel) channelStateEvent.getChannel();
            ChannelFuture future = channelStateEvent.getFuture();
            ChannelState state = channelStateEvent.getState();
            Object value = channelStateEvent.getValue();
            switch (state) {
                case OPEN:
                    if (Boolean.FALSE.equals(value)) {
                        nioSocketChannel.worker.close(nioSocketChannel, future);
                        return;
                    }
                    return;
                case BOUND:
                case CONNECTED:
                    if (value == null) {
                        nioSocketChannel.worker.close(nioSocketChannel, future);
                        return;
                    }
                    return;
                case INTEREST_OPS:
                    nioSocketChannel.worker.setInterestOps(nioSocketChannel, future, ((Integer) value).intValue());
                    return;
                default:
                    return;
            }
        }
        if (channelEvent instanceof MessageEvent) {
            MessageEvent messageEvent = (MessageEvent) channelEvent;
            NioSocketChannel nioSocketChannel2 = (NioSocketChannel) messageEvent.getChannel();
            boolean zOffer = nioSocketChannel2.writeBuffer.offer(messageEvent);
            if (!$assertionsDisabled && !zOffer) {
                throw new AssertionError();
            }
            nioSocketChannel2.worker.writeFromUserCode(nioSocketChannel2);
        }
    }

    private void bind(NioServerSocketChannel nioServerSocketChannel, ChannelFuture channelFuture, SocketAddress socketAddress) {
        boolean z = false;
        try {
            try {
                nioServerSocketChannel.socket.socket().bind(socketAddress, nioServerSocketChannel.getConfig().getBacklog());
                z = true;
                channelFuture.setSuccess();
                Channels.fireChannelBound(nioServerSocketChannel, nioServerSocketChannel.getLocalAddress());
                DeadLockProofWorker.start(((NioServerSocketChannelFactory) nioServerSocketChannel.getFactory()).bossExecutor, new ThreadRenamingRunnable(new Boss(nioServerSocketChannel), "New I/O server boss #" + this.f5795id + " (" + nioServerSocketChannel + ')'));
            } catch (Throwable th) {
                channelFuture.setFailure(th);
                Channels.fireExceptionCaught(nioServerSocketChannel, th);
                if (z) {
                    close(nioServerSocketChannel, channelFuture);
                }
            }
        } catch (Throwable th2) {
            if (z) {
                close(nioServerSocketChannel, channelFuture);
            }
            throw th2;
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

    NioWorker nextWorker() {
        return this.workers[Math.abs(this.workerIndex.getAndIncrement() % this.workers.length)];
    }

    final class Boss implements Runnable {
        private final NioServerSocketChannel channel;
        private final Selector selector = Selector.open();

        Boss(NioServerSocketChannel nioServerSocketChannel) throws IOException {
            this.channel = nioServerSocketChannel;
            try {
                nioServerSocketChannel.socket.register(this.selector, 16);
                nioServerSocketChannel.selector = this.selector;
            } catch (Throwable th) {
                closeSelector();
                throw th;
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

        private void closeSelector() throws IOException {
            this.channel.selector = null;
            try {
                this.selector.close();
            } catch (Exception e) {
                NioServerSocketPipelineSink.logger.warn("Failed to close a selector.", e);
            }
        }
    }
}
