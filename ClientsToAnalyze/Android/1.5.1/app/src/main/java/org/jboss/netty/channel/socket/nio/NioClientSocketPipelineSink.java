package org.jboss.netty.channel.socket.nio;

import java.net.ConnectException;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
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
    private final NioWorker[] workers;

    /* renamed from: id */
    final int f4563id = nextId.incrementAndGet();
    private final Boss boss = new Boss();
    private final AtomicInteger workerIndex = new AtomicInteger();

    final class Boss implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled;
        volatile Selector selector;
        private boolean started;
        private final AtomicBoolean wakenUp = new AtomicBoolean();
        private final Object startStopLock = new Object();
        private final Queue registerTaskQueue = new LinkedTransferQueue();

        static {
            $assertionsDisabled = !NioClientSocketPipelineSink.class.desiredAssertionStatus();
        }

        Boss() {
        }

        private void close(SelectionKey selectionKey) {
            NioClientSocketChannel nioClientSocketChannel = (NioClientSocketChannel) selectionKey.attachment();
            nioClientSocketChannel.worker.close(nioClientSocketChannel, Channels.succeededFuture(nioClientSocketChannel));
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
                nioClientSocketChannel.worker.close(nioClientSocketChannel, Channels.succeededFuture(nioClientSocketChannel));
            }
        }

        private void processConnectTimeout(Set set, long j) {
            ConnectException connectException = null;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) it.next();
                if (selectionKey.isValid()) {
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

        private void processRegisterTaskQueue() {
            while (true) {
                Runnable runnable = (Runnable) this.registerTaskQueue.poll();
                if (runnable == null) {
                    return;
                } else {
                    runnable.run();
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

        void register(NioClientSocketChannel nioClientSocketChannel) {
            Selector selectorOpen;
            RegisterTask registerTask = new RegisterTask(this, nioClientSocketChannel);
            synchronized (this.startStopLock) {
                if (this.started) {
                    selectorOpen = this.selector;
                } else {
                    try {
                        selectorOpen = Selector.open();
                        this.selector = selectorOpen;
                        try {
                            DeadLockProofWorker.start(NioClientSocketPipelineSink.this.bossExecutor, new ThreadRenamingRunnable(this, "New I/O client boss #" + NioClientSocketPipelineSink.this.f4563id));
                            if (1 == 0) {
                                try {
                                    selectorOpen.close();
                                } catch (Throwable th) {
                                    NioClientSocketPipelineSink.logger.warn("Failed to close a selector.", th);
                                }
                                this.selector = null;
                                selectorOpen = null;
                            }
                        } finally {
                        }
                    } catch (Throwable th2) {
                        throw new ChannelException("Failed to create a selector.", th2);
                    }
                }
                if (!$assertionsDisabled && (selectorOpen == null || !selectorOpen.isOpen())) {
                    throw new AssertionError();
                }
                this.started = true;
                boolean zOffer = this.registerTaskQueue.offer(registerTask);
                if (!$assertionsDisabled && !zOffer) {
                    throw new AssertionError();
                }
            }
            if (this.wakenUp.compareAndSet(false, true)) {
                selectorOpen.wakeup();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x00b0 A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws java.lang.InterruptedException {
            /*
                r13 = this;
                r11 = 0
                java.nio.channels.Selector r1 = r13.selector
                long r2 = java.lang.System.nanoTime()
                r4 = r11
            L8:
                java.util.concurrent.atomic.AtomicBoolean r0 = r13.wakenUp
                r0.set(r11)
                r5 = 500(0x1f4, double:2.47E-321)
                int r0 = r1.select(r5)     // Catch: java.lang.Throwable -> Lb2
                java.util.concurrent.atomic.AtomicBoolean r5 = r13.wakenUp     // Catch: java.lang.Throwable -> Lb2
                boolean r5 = r5.get()     // Catch: java.lang.Throwable -> Lb2
                if (r5 == 0) goto L1e
                r1.wakeup()     // Catch: java.lang.Throwable -> Lb2
            L1e:
                r13.processRegisterTaskQueue()     // Catch: java.lang.Throwable -> Lb2
                if (r0 <= 0) goto L2a
                java.util.Set r0 = r1.selectedKeys()     // Catch: java.lang.Throwable -> Lb2
                r13.processSelectedKeys(r0)     // Catch: java.lang.Throwable -> Lb2
            L2a:
                long r5 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> Lb2
                long r7 = r5 - r2
                r9 = 500000000(0x1dcd6500, double:2.47032823E-315)
                int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r0 < 0) goto L3f
                java.util.Set r0 = r1.keys()     // Catch: java.lang.Throwable -> Lb4
                r13.processConnectTimeout(r0, r5)     // Catch: java.lang.Throwable -> Lb4
                r2 = r5
            L3f:
                java.util.Set r0 = r1.keys()     // Catch: java.lang.Throwable -> Lb2
                boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> Lb2
                if (r0 == 0) goto Lb0
                if (r4 != 0) goto L5f
                org.jboss.netty.channel.socket.nio.NioClientSocketPipelineSink r0 = org.jboss.netty.channel.socket.nio.NioClientSocketPipelineSink.this     // Catch: java.lang.Throwable -> Lb2
                java.util.concurrent.Executor r0 = r0.bossExecutor     // Catch: java.lang.Throwable -> Lb2
                boolean r0 = r0 instanceof java.util.concurrent.ExecutorService     // Catch: java.lang.Throwable -> Lb2
                if (r0 == 0) goto Lae
                org.jboss.netty.channel.socket.nio.NioClientSocketPipelineSink r0 = org.jboss.netty.channel.socket.nio.NioClientSocketPipelineSink.this     // Catch: java.lang.Throwable -> Lb2
                java.util.concurrent.Executor r0 = r0.bossExecutor     // Catch: java.lang.Throwable -> Lb2
                java.util.concurrent.ExecutorService r0 = (java.util.concurrent.ExecutorService) r0     // Catch: java.lang.Throwable -> Lb2
                boolean r0 = r0.isShutdown()     // Catch: java.lang.Throwable -> Lb2
                if (r0 == 0) goto Lae
            L5f:
                java.lang.Object r0 = r13.startStopLock     // Catch: java.lang.Throwable -> Lb2
                monitor-enter(r0)     // Catch: java.lang.Throwable -> Lb2
                java.util.Queue r5 = r13.registerTaskQueue     // Catch: java.lang.Throwable -> L8b
                boolean r5 = r5.isEmpty()     // Catch: java.lang.Throwable -> L8b
                if (r5 == 0) goto La9
                java.util.Set r5 = r1.keys()     // Catch: java.lang.Throwable -> L8b
                boolean r5 = r5.isEmpty()     // Catch: java.lang.Throwable -> L8b
                if (r5 == 0) goto La9
                r5 = 0
                r13.started = r5     // Catch: java.lang.Throwable -> L8b
                r1.close()     // Catch: java.io.IOException -> L7f java.lang.Throwable -> La4
                r5 = 0
                r13.selector = r5     // Catch: java.lang.Throwable -> L8b
            L7d:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L8b
                return
            L7f:
                r5 = move-exception
                org.jboss.netty.logging.InternalLogger r6 = org.jboss.netty.channel.socket.nio.NioClientSocketPipelineSink.logger     // Catch: java.lang.Throwable -> La4
                java.lang.String r7 = "Failed to close a selector."
                r6.warn(r7, r5)     // Catch: java.lang.Throwable -> La4
                r5 = 0
                r13.selector = r5     // Catch: java.lang.Throwable -> L8b
                goto L7d
            L8b:
                r5 = move-exception
                r12 = r5
                r5 = r4
                r4 = r12
            L8f:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lba
                throw r4     // Catch: java.lang.Throwable -> L91
            L91:
                r0 = move-exception
                r4 = r5
            L93:
                org.jboss.netty.logging.InternalLogger r5 = org.jboss.netty.channel.socket.nio.NioClientSocketPipelineSink.logger
                java.lang.String r6 = "Unexpected exception in the selector loop."
                r5.warn(r6, r0)
                r5 = 1000(0x3e8, double:4.94E-321)
                java.lang.Thread.sleep(r5)     // Catch: java.lang.InterruptedException -> La1
                goto L8
            La1:
                r0 = move-exception
                goto L8
            La4:
                r5 = move-exception
                r6 = 0
                r13.selector = r6     // Catch: java.lang.Throwable -> L8b
                throw r5     // Catch: java.lang.Throwable -> L8b
            La9:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb7
                r0 = r11
            Lab:
                r4 = r0
                goto L8
            Lae:
                r0 = 1
                goto Lab
            Lb0:
                r0 = r11
                goto Lab
            Lb2:
                r0 = move-exception
                goto L93
            Lb4:
                r0 = move-exception
                r2 = r5
                goto L93
            Lb7:
                r4 = move-exception
                r5 = r11
                goto L8f
            Lba:
                r4 = move-exception
                goto L8f
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.nio.NioClientSocketPipelineSink.Boss.run():void");
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

    static {
        $assertionsDisabled = !NioClientSocketPipelineSink.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(NioClientSocketPipelineSink.class);
        nextId = new AtomicInteger();
    }

    NioClientSocketPipelineSink(Executor executor, Executor executor2, int i) {
        this.bossExecutor = executor;
        this.workers = new NioWorker[i];
        for (int i2 = 0; i2 < this.workers.length; i2++) {
            this.workers[i2] = new NioWorker(this.f4563id, i2 + 1, executor2);
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
                        if (channelFuture.isDone()) {
                            return;
                        }
                        channelFuture.setFailure(new ClosedChannelException());
                    }
                });
                channelFuture.addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
                nioClientSocketChannel.connectFuture = channelFuture;
                this.boss.register(nioClientSocketChannel);
            }
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(nioClientSocketChannel, th);
            nioClientSocketChannel.worker.close(nioClientSocketChannel, Channels.succeededFuture(nioClientSocketChannel));
        }
    }

    @Override // org.jboss.netty.channel.ChannelSink
    public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) {
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

    NioWorker nextWorker() {
        return this.workers[Math.abs(this.workerIndex.getAndIncrement() % this.workers.length)];
    }
}
