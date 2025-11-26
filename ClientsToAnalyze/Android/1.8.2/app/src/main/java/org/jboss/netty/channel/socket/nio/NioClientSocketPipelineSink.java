package org.jboss.netty.channel.socket.nio;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.jboss.netty.channel.AbstractChannelSink;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelState;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.ThreadRenamingRunnable;
import org.jboss.netty.util.internal.DeadLockProofWorker;
import org.jboss.netty.util.internal.LinkedTransferQueue;

/* loaded from: classes.dex */
class NioClientSocketPipelineSink extends AbstractChannelSink {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final InternalLogger logger;
    private static final AtomicInteger nextId;
    final Executor bossExecutor;
    private final Boss[] bosses;
    private final NioWorker[] workers;

    /* renamed from: id */
    final int f7853id = nextId.incrementAndGet();
    private final AtomicInteger bossIndex = new AtomicInteger();
    private final AtomicInteger workerIndex = new AtomicInteger();

    static {
        $assertionsDisabled = !NioClientSocketPipelineSink.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(NioClientSocketPipelineSink.class);
        nextId = new AtomicInteger();
    }

    NioClientSocketPipelineSink(Executor executor, Executor executor2, int i, int i2) {
        this.bossExecutor = executor;
        this.bosses = new Boss[i];
        for (int i3 = 0; i3 < this.bosses.length; i3++) {
            this.bosses[i3] = new Boss(i3 + 1);
        }
        this.workers = new NioWorker[i2];
        for (int i4 = 0; i4 < this.workers.length; i4++) {
            this.workers[i4] = new NioWorker(this.f7853id, i4 + 1, executor2);
        }
    }

    @Override // org.jboss.netty.channel.ChannelSink
    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            NioClientSocketChannel nioClientSocketChannel = (NioClientSocketChannel) channelStateEvent.getChannel();
            ChannelFuture future = channelStateEvent.getFuture();
            ChannelState state = channelStateEvent.getState();
            Object value = channelStateEvent.getValue();
            switch (state) {
                case OPEN:
                    if (Boolean.FALSE.equals(value)) {
                        nioClientSocketChannel.worker.close(nioClientSocketChannel, future);
                        return;
                    }
                    return;
                case BOUND:
                    if (value != null) {
                        bind(nioClientSocketChannel, future, (SocketAddress) value);
                        return;
                    } else {
                        nioClientSocketChannel.worker.close(nioClientSocketChannel, future);
                        return;
                    }
                case CONNECTED:
                    if (value != null) {
                        connect(nioClientSocketChannel, future, (SocketAddress) value);
                        return;
                    } else {
                        nioClientSocketChannel.worker.close(nioClientSocketChannel, future);
                        return;
                    }
                case INTEREST_OPS:
                    nioClientSocketChannel.worker.setInterestOps(nioClientSocketChannel, future, ((Integer) value).intValue());
                    return;
                default:
                    return;
            }
        }
        if (channelEvent instanceof MessageEvent) {
            MessageEvent messageEvent = (MessageEvent) channelEvent;
            NioSocketChannel nioSocketChannel = (NioSocketChannel) messageEvent.getChannel();
            boolean zOffer = nioSocketChannel.writeBuffer.offer(messageEvent);
            if (!$assertionsDisabled && !zOffer) {
                throw new AssertionError();
            }
            nioSocketChannel.worker.writeFromUserCode(nioSocketChannel);
        }
    }

    private void bind(NioClientSocketChannel nioClientSocketChannel, ChannelFuture channelFuture, SocketAddress socketAddress) {
        try {
            nioClientSocketChannel.socket.socket().bind(socketAddress);
            nioClientSocketChannel.boundManually = true;
            nioClientSocketChannel.setBound();
            channelFuture.setSuccess();
            Channels.fireChannelBound(nioClientSocketChannel, nioClientSocketChannel.getLocalAddress());
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(nioClientSocketChannel, th);
        }
    }

    private void connect(NioClientSocketChannel nioClientSocketChannel, final ChannelFuture channelFuture, SocketAddress socketAddress) {
        try {
            if (nioClientSocketChannel.socket.connect(socketAddress)) {
                nioClientSocketChannel.worker.register(nioClientSocketChannel, channelFuture);
            } else {
                nioClientSocketChannel.getCloseFuture().addListener(new ChannelFutureListener() { // from class: org.jboss.netty.channel.socket.nio.NioClientSocketPipelineSink.1
                    @Override // org.jboss.netty.channel.ChannelFutureListener
                    public void operationComplete(ChannelFuture channelFuture2) {
                        if (!channelFuture.isDone()) {
                            channelFuture.setFailure(new ClosedChannelException());
                        }
                    }
                });
                channelFuture.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
                nioClientSocketChannel.connectFuture = channelFuture;
                nextBoss().register(nioClientSocketChannel);
            }
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(nioClientSocketChannel, th);
            nioClientSocketChannel.worker.close(nioClientSocketChannel, Channels.succeededFuture(nioClientSocketChannel));
        }
    }

    Boss nextBoss() {
        return this.bosses[Math.abs(this.bossIndex.getAndIncrement() % this.bosses.length)];
    }

    NioWorker nextWorker() {
        return this.workers[Math.abs(this.workerIndex.getAndIncrement() % this.workers.length)];
    }

    final class Boss implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled;
        volatile Selector selector;
        private boolean started;
        private final int subId;
        private final AtomicBoolean wakenUp = new AtomicBoolean();
        private final Object startStopLock = new Object();
        private final Queue registerTaskQueue = new LinkedTransferQueue();

        static {
            $assertionsDisabled = !NioClientSocketPipelineSink.class.desiredAssertionStatus();
        }

        Boss(int i) {
            this.subId = i;
        }

        void register(NioClientSocketChannel nioClientSocketChannel) {
            Selector selector;
            RegisterTask registerTask = new RegisterTask(this, nioClientSocketChannel);
            synchronized (this.startStopLock) {
                if (!this.started) {
                    try {
                        Selector selectorOpen = Selector.open();
                        this.selector = selectorOpen;
                        try {
                            DeadLockProofWorker.start(NioClientSocketPipelineSink.this.bossExecutor, new ThreadRenamingRunnable(this, "New I/O client boss #" + NioClientSocketPipelineSink.this.f7853id + '-' + this.subId));
                            selector = selectorOpen;
                        } finally {
                        }
                    } catch (Throwable th) {
                        throw new ChannelException("Failed to create a selector.", th);
                    }
                } else {
                    selector = this.selector;
                }
                if (!$assertionsDisabled && (selector == null || !selector.isOpen())) {
                    throw new AssertionError();
                }
                this.started = true;
                boolean zOffer = this.registerTaskQueue.offer(registerTask);
                if (!$assertionsDisabled && !zOffer) {
                    throw new AssertionError();
                }
            }
            if (this.wakenUp.compareAndSet(false, true)) {
                selector.wakeup();
            }
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            boolean z;
            Throwable th;
            long j;
            boolean z2;
            Selector selector = this.selector;
            long jNanoTime = System.nanoTime();
            boolean z3 = false;
            while (true) {
                this.wakenUp.set(false);
                try {
                    int iSelect = selector.select(500L);
                    if (this.wakenUp.get()) {
                        selector.wakeup();
                    }
                    processRegisterTaskQueue();
                    if (iSelect > 0) {
                        processSelectedKeys(selector.selectedKeys());
                    }
                    long jNanoTime2 = System.nanoTime();
                    if (jNanoTime2 - jNanoTime >= 500000000) {
                        try {
                            processConnectTimeout(selector.keys(), jNanoTime2);
                            j = jNanoTime2;
                        } catch (Throwable th2) {
                            z = z3;
                            th = th2;
                            jNanoTime = jNanoTime2;
                            NioClientSocketPipelineSink.logger.warn("Unexpected exception in the selector loop.", th);
                            try {
                                Thread.sleep(1000L);
                            } catch (InterruptedException e) {
                            }
                            z3 = z;
                        }
                    } else {
                        j = jNanoTime;
                    }
                } catch (Throwable th3) {
                    z = z3;
                    th = th3;
                }
                try {
                    if (!selector.keys().isEmpty()) {
                        z2 = false;
                    } else if (z3 || ((NioClientSocketPipelineSink.this.bossExecutor instanceof ExecutorService) && ((ExecutorService) NioClientSocketPipelineSink.this.bossExecutor).isShutdown())) {
                        synchronized (this.startStopLock) {
                            try {
                                if (this.registerTaskQueue.isEmpty() && selector.keys().isEmpty()) {
                                    this.started = false;
                                    try {
                                        try {
                                            selector.close();
                                            this.selector = null;
                                        } catch (IOException e2) {
                                            NioClientSocketPipelineSink.logger.warn("Failed to close a selector.", e2);
                                            this.selector = null;
                                        }
                                        return;
                                    } catch (Throwable th4) {
                                        this.selector = null;
                                        throw th4;
                                    }
                                }
                                try {
                                } catch (Throwable th5) {
                                    th = th5;
                                    z3 = false;
                                    throw th;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                throw th;
                            }
                        }
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    z3 = z2;
                    jNanoTime = j;
                } catch (Throwable th7) {
                    jNanoTime = j;
                    z = z3;
                    th = th7;
                    NioClientSocketPipelineSink.logger.warn("Unexpected exception in the selector loop.", th);
                    Thread.sleep(1000L);
                    z3 = z;
                }
            }
        }

        private void processRegisterTaskQueue() {
            while (true) {
                Runnable runnable = (Runnable) this.registerTaskQueue.poll();
                if (runnable != null) {
                    runnable.run();
                } else {
                    return;
                }
            }
        }

        private void processSelectedKeys(Set set) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) it.next();
                it.remove();
                if (!selectionKey.isValid()) {
                    close(selectionKey);
                } else if (selectionKey.isConnectable()) {
                    connect(selectionKey);
                }
            }
        }

        private void processConnectTimeout(Set set, long j) {
            ConnectException connectException = null;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) it.next();
                if (!selectionKey.isValid()) {
                    close(selectionKey);
                } else {
                    NioClientSocketChannel nioClientSocketChannel = (NioClientSocketChannel) selectionKey.attachment();
                    if (nioClientSocketChannel.connectDeadlineNanos > 0 && j >= nioClientSocketChannel.connectDeadlineNanos) {
                        if (connectException == null) {
                            connectException = new ConnectException("connection timed out");
                        }
                        nioClientSocketChannel.connectFuture.setFailure(connectException);
                        Channels.fireExceptionCaught(nioClientSocketChannel, connectException);
                        nioClientSocketChannel.worker.close(nioClientSocketChannel, Channels.succeededFuture(nioClientSocketChannel));
                    }
                }
            }
        }

        private void connect(SelectionKey selectionKey) {
            NioClientSocketChannel nioClientSocketChannel = (NioClientSocketChannel) selectionKey.attachment();
            try {
                if (nioClientSocketChannel.socket.finishConnect()) {
                    selectionKey.cancel();
                    nioClientSocketChannel.worker.register(nioClientSocketChannel, nioClientSocketChannel.connectFuture);
                }
            } catch (Throwable th) {
                nioClientSocketChannel.connectFuture.setFailure(th);
                Channels.fireExceptionCaught(nioClientSocketChannel, th);
                selectionKey.cancel();
                nioClientSocketChannel.worker.close(nioClientSocketChannel, Channels.succeededFuture(nioClientSocketChannel));
            }
        }

        private void close(SelectionKey selectionKey) {
            NioClientSocketChannel nioClientSocketChannel = (NioClientSocketChannel) selectionKey.attachment();
            nioClientSocketChannel.worker.close(nioClientSocketChannel, Channels.succeededFuture(nioClientSocketChannel));
        }
    }

    final class RegisterTask implements Runnable {
        private final Boss boss;
        private final NioClientSocketChannel channel;

        RegisterTask(Boss boss, NioClientSocketChannel nioClientSocketChannel) {
            this.boss = boss;
            this.channel = nioClientSocketChannel;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.channel.socket.register(this.boss.selector, 8, this.channel);
            } catch (ClosedChannelException e) {
                this.channel.worker.close(this.channel, Channels.succeededFuture(this.channel));
            }
            int connectTimeoutMillis = this.channel.getConfig().getConnectTimeoutMillis();
            if (connectTimeoutMillis > 0) {
                this.channel.connectDeadlineNanos = System.nanoTime() + (connectTimeoutMillis * 1000000);
            }
        }
    }
}
