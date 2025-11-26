package org.jboss.netty.channel.socket.nio;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.NotYetBoundException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jboss.netty.buffer.ChannelBufferFactory;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.ReceiveBufferSizePredictor;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.ThreadRenamingRunnable;
import org.jboss.netty.util.internal.LinkedTransferQueue;

/* loaded from: classes.dex */
class NioDatagramWorker implements Runnable {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final InternalLogger logger;
    private final int bossId;
    private volatile int cancelledKeys;
    private final Executor executor;

    /* renamed from: id */
    private final int f4565id;
    volatile Selector selector;
    private boolean started;
    private volatile Thread thread;
    private final AtomicBoolean wakenUp = new AtomicBoolean();
    private final ReadWriteLock selectorGuard = new ReentrantReadWriteLock();
    private final Object startStopLock = new Object();
    private final Queue registerTaskQueue = new LinkedTransferQueue();
    private final Queue writeTaskQueue = new LinkedTransferQueue();
    private final SocketSendBufferPool sendBufferPool = new SocketSendBufferPool();

    final class ChannelRegistionTask implements Runnable {
        private final NioDatagramChannel channel;
        private final ChannelFuture future;

        ChannelRegistionTask(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture) {
            this.channel = nioDatagramChannel;
            this.future = channelFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.channel.getLocalAddress() == null) {
                if (this.future != null) {
                    this.future.setFailure(new ClosedChannelException());
                }
                NioDatagramWorker.this.close(this.channel, Channels.succeededFuture(this.channel));
                return;
            }
            try {
                synchronized (this.channel.interestOpsLock) {
                    this.channel.getDatagramChannel().register(NioDatagramWorker.this.selector, this.channel.getRawInterestOps(), this.channel);
                }
                if (this.future != null) {
                    this.future.setSuccess();
                }
            } catch (ClosedChannelException e) {
                if (this.future != null) {
                    this.future.setFailure(e);
                }
                NioDatagramWorker.this.close(this.channel, Channels.succeededFuture(this.channel));
                throw new ChannelException("Failed to register a socket to the selector.", e);
            }
        }
    }

    static {
        $assertionsDisabled = !NioDatagramWorker.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(NioDatagramWorker.class);
    }

    NioDatagramWorker(int i, int i2, Executor executor) {
        this.bossId = i;
        this.f4565id = i2;
        this.executor = executor;
    }

    private boolean cleanUpCancelledKeys() throws IOException {
        if (this.cancelledKeys < 256) {
            return false;
        }
        this.cancelledKeys = 0;
        this.selector.selectNow();
        return true;
    }

    private void cleanUpWriteBuffer(NioDatagramChannel nioDatagramChannel) {
        Throwable notYetBoundException;
        boolean z = false;
        synchronized (nioDatagramChannel.writeLock) {
            MessageEvent messageEvent = nioDatagramChannel.currentWriteEvent;
            if (messageEvent != null) {
                Throwable notYetBoundException2 = nioDatagramChannel.isOpen() ? new NotYetBoundException() : new ClosedChannelException();
                ChannelFuture future = messageEvent.getFuture();
                nioDatagramChannel.currentWriteBuffer.release();
                nioDatagramChannel.currentWriteBuffer = null;
                nioDatagramChannel.currentWriteEvent = null;
                future.setFailure(notYetBoundException2);
                notYetBoundException = notYetBoundException2;
                z = true;
            } else {
                notYetBoundException = null;
            }
            Queue queue = nioDatagramChannel.writeBufferQueue;
            if (!queue.isEmpty()) {
                if (notYetBoundException == null) {
                    notYetBoundException = nioDatagramChannel.isOpen() ? new NotYetBoundException() : new ClosedChannelException();
                }
                while (true) {
                    MessageEvent messageEvent2 = (MessageEvent) queue.poll();
                    if (messageEvent2 == null) {
                        break;
                    }
                    messageEvent2.getFuture().setFailure(notYetBoundException);
                    z = true;
                }
            }
        }
        if (z) {
            Channels.fireExceptionCaught(nioDatagramChannel, notYetBoundException);
        }
    }

    private void clearOpWrite(NioDatagramChannel nioDatagramChannel) {
        SelectionKey selectionKeyKeyFor = nioDatagramChannel.getDatagramChannel().keyFor(this.selector);
        if (selectionKeyKeyFor == null) {
            return;
        }
        if (!selectionKeyKeyFor.isValid()) {
            close(selectionKeyKeyFor);
            return;
        }
        synchronized (nioDatagramChannel.interestOpsLock) {
            int rawInterestOps = nioDatagramChannel.getRawInterestOps();
            if ((rawInterestOps & 4) != 0) {
                int i = rawInterestOps & (-5);
                selectionKeyKeyFor.interestOps(i);
                nioDatagramChannel.setRawInterestOpsNow(i);
            }
        }
    }

    private void close(SelectionKey selectionKey) {
        NioDatagramChannel nioDatagramChannel = (NioDatagramChannel) selectionKey.attachment();
        close(nioDatagramChannel, Channels.succeededFuture(nioDatagramChannel));
    }

    static void disconnect(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture) {
        boolean zIsConnected = nioDatagramChannel.isConnected();
        try {
            nioDatagramChannel.getDatagramChannel().disconnect();
            channelFuture.setSuccess();
            if (zIsConnected) {
                Channels.fireChannelDisconnected(nioDatagramChannel);
            }
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(nioDatagramChannel, th);
        }
    }

    private void processRegisterTaskQueue() throws IOException {
        while (true) {
            Runnable runnable = (Runnable) this.registerTaskQueue.poll();
            if (runnable == null) {
                return;
            }
            runnable.run();
            cleanUpCancelledKeys();
        }
    }

    private void processSelectedKeys(Set set) {
        int i;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            SelectionKey selectionKey = (SelectionKey) it.next();
            it.remove();
            try {
                i = selectionKey.readyOps();
            } catch (CancelledKeyException e) {
                close(selectionKey);
            }
            if (((i & 1) == 0 && i != 0) || read(selectionKey)) {
                if ((i & 4) != 0) {
                    writeFromSelectorLoop(selectionKey);
                }
                if (cleanUpCancelledKeys()) {
                    return;
                }
            }
        }
    }

    private void processWriteTaskQueue() throws IOException {
        while (true) {
            Runnable runnable = (Runnable) this.writeTaskQueue.poll();
            if (runnable == null) {
                return;
            }
            runnable.run();
            cleanUpCancelledKeys();
        }
    }

    private boolean read(SelectionKey selectionKey) {
        SocketAddress socketAddressReceive;
        boolean z;
        NioDatagramChannel nioDatagramChannel = (NioDatagramChannel) selectionKey.attachment();
        ReceiveBufferSizePredictor receiveBufferSizePredictor = nioDatagramChannel.getConfig().getReceiveBufferSizePredictor();
        ChannelBufferFactory bufferFactory = nioDatagramChannel.getConfig().getBufferFactory();
        DatagramChannel datagramChannel = (DatagramChannel) selectionKey.channel();
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(receiveBufferSizePredictor.nextReceiveBufferSize()).order(bufferFactory.getDefaultOrder());
        try {
            socketAddressReceive = datagramChannel.receive(byteBufferOrder);
            z = false;
        } catch (ClosedChannelException e) {
            socketAddressReceive = null;
            z = true;
        } catch (Throwable th) {
            Channels.fireExceptionCaught(nioDatagramChannel, th);
            socketAddressReceive = null;
            z = true;
        }
        if (socketAddressReceive != null) {
            byteBufferOrder.flip();
            int iRemaining = byteBufferOrder.remaining();
            if (iRemaining > 0) {
                receiveBufferSizePredictor.previousReceiveBufferSize(iRemaining);
                Channels.fireMessageReceived(nioDatagramChannel, bufferFactory.getBuffer(byteBufferOrder), socketAddressReceive);
            }
        }
        if (!z) {
            return true;
        }
        close(nioDatagramChannel, Channels.succeededFuture(nioDatagramChannel));
        return false;
    }

    private boolean scheduleWriteIfNecessary(NioDatagramChannel nioDatagramChannel) {
        Thread thread = this.thread;
        if (thread != null && Thread.currentThread() == thread) {
            return false;
        }
        if (nioDatagramChannel.writeTaskInTaskQueue.compareAndSet(false, true)) {
            boolean zOffer = this.writeTaskQueue.offer(nioDatagramChannel.writeTask);
            if (!$assertionsDisabled && !zOffer) {
                throw new AssertionError();
            }
        }
        Selector selector = this.selector;
        if (selector != null && this.wakenUp.compareAndSet(false, true)) {
            selector.wakeup();
        }
        return true;
    }

    private void setOpWrite(NioDatagramChannel nioDatagramChannel) {
        SelectionKey selectionKeyKeyFor = nioDatagramChannel.getDatagramChannel().keyFor(this.selector);
        if (selectionKeyKeyFor == null) {
            return;
        }
        if (!selectionKeyKeyFor.isValid()) {
            close(selectionKeyKeyFor);
            return;
        }
        synchronized (nioDatagramChannel.interestOpsLock) {
            int rawInterestOps = nioDatagramChannel.getRawInterestOps();
            if ((rawInterestOps & 4) == 0) {
                int i = rawInterestOps | 4;
                selectionKeyKeyFor.interestOps(i);
                nioDatagramChannel.setRawInterestOpsNow(i);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0098 A[Catch: all -> 0x012f, Throwable -> 0x0139, AsynchronousCloseException -> 0x0161, TRY_LEAVE, TryCatch #1 {AsynchronousCloseException -> 0x0161, blocks: (B:30:0x0092, B:32:0x0098, B:34:0x00ad), top: B:77:0x0092 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void write0(org.jboss.netty.channel.socket.nio.NioDatagramChannel r25) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.nio.NioDatagramWorker.write0(org.jboss.netty.channel.socket.nio.NioDatagramChannel):void");
    }

    void close(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture) {
        boolean zIsConnected = nioDatagramChannel.isConnected();
        boolean zIsBound = nioDatagramChannel.isBound();
        try {
            nioDatagramChannel.getDatagramChannel().close();
            this.cancelledKeys++;
            if (!nioDatagramChannel.setClosed()) {
                channelFuture.setSuccess();
                return;
            }
            channelFuture.setSuccess();
            if (zIsConnected) {
                Channels.fireChannelDisconnected(nioDatagramChannel);
            }
            if (zIsBound) {
                Channels.fireChannelUnbound(nioDatagramChannel);
            }
            cleanUpWriteBuffer(nioDatagramChannel);
            Channels.fireChannelClosed(nioDatagramChannel);
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(nioDatagramChannel, th);
        }
    }

    void register(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture) {
        Selector selectorOpen;
        ChannelRegistionTask channelRegistionTask = new ChannelRegistionTask(nioDatagramChannel, channelFuture);
        synchronized (this.startStopLock) {
            if (this.started) {
                selectorOpen = this.selector;
            } else {
                try {
                    selectorOpen = Selector.open();
                    this.selector = selectorOpen;
                    try {
                        this.executor.execute(new ThreadRenamingRunnable(this, "New I/O datagram worker #" + this.bossId + "'-'" + this.f4565id));
                        if (1 == 0) {
                            try {
                                selectorOpen.close();
                            } catch (Throwable th) {
                                logger.warn("Failed to close a selector.", th);
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
            boolean zOffer = this.registerTaskQueue.offer(channelRegistionTask);
            if (!$assertionsDisabled && !zOffer) {
                throw new AssertionError();
            }
        }
        if (this.wakenUp.compareAndSet(false, true)) {
            selectorOpen.wakeup();
        }
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        boolean z;
        boolean z2;
        Throwable th;
        this.thread = Thread.currentThread();
        Selector selector = this.selector;
        boolean z3 = false;
        while (true) {
            this.wakenUp.set(false);
            if (NioProviderMetadata.CONSTRAINT_LEVEL != 0) {
                this.selectorGuard.writeLock().lock();
                this.selectorGuard.writeLock().unlock();
            }
            try {
                SelectorUtil.select(selector);
                if (this.wakenUp.get()) {
                    selector.wakeup();
                }
                this.cancelledKeys = 0;
                processRegisterTaskQueue();
                processWriteTaskQueue();
                processSelectedKeys(selector.selectedKeys());
                if (!selector.keys().isEmpty()) {
                    z = false;
                } else if (z3 || ((this.executor instanceof ExecutorService) && ((ExecutorService) this.executor).isShutdown())) {
                    synchronized (this.startStopLock) {
                        try {
                            if (this.registerTaskQueue.isEmpty() && selector.keys().isEmpty()) {
                                this.started = false;
                                try {
                                    try {
                                        selector.close();
                                        this.selector = null;
                                    } catch (IOException e) {
                                        logger.warn("Failed to close a selector.", e);
                                        this.selector = null;
                                    }
                                    return;
                                } catch (Throwable th2) {
                                    this.selector = null;
                                    throw th2;
                                }
                            }
                            try {
                            } catch (Throwable th3) {
                                th = th3;
                                z2 = false;
                                while (true) {
                                    try {
                                        try {
                                            throw th;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            z3 = z2;
                                            logger.warn("Unexpected exception in the selector loop.", th);
                                            try {
                                                Thread.sleep(1000L);
                                            } catch (InterruptedException e2) {
                                            }
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                    }
                                }
                            }
                        } catch (Throwable th6) {
                            z2 = z3;
                            th = th6;
                            while (true) {
                                throw th;
                            }
                        }
                    }
                    z = false;
                } else {
                    z = true;
                }
                z3 = z;
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005d A[Catch: all -> 0x002c, TryCatch #3 {, blocks: (B:5:0x0005, B:11:0x0018, B:12:0x0023, B:13:0x0026, B:14:0x002b, B:20:0x003c, B:22:0x0042, B:24:0x004d, B:26:0x0057, B:29:0x005d, B:30:0x0060, B:37:0x0072, B:39:0x0078, B:41:0x0080, B:42:0x0085, B:47:0x009e, B:49:0x00aa, B:50:0x00b3, B:8:0x0013, B:9:0x0016, B:43:0x008e, B:45:0x0098, B:46:0x009b), top: B:54:0x0005, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0066 A[Catch: CancelledKeyException -> 0x002f, Throwable -> 0x006a, TRY_LEAVE, TryCatch #4 {CancelledKeyException -> 0x002f, Throwable -> 0x006a, blocks: (B:3:0x0002, B:4:0x0004, B:31:0x0061, B:33:0x0066, B:17:0x002e), top: B:55:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void setInterestOps(org.jboss.netty.channel.socket.nio.NioDatagramChannel r9, org.jboss.netty.channel.ChannelFuture r10, int r11) {
        /*
            r8 = this;
            r5 = 0
            r7 = 1
            java.lang.Object r0 = r9.interestOpsLock     // Catch: java.nio.channels.CancelledKeyException -> L2f java.lang.Throwable -> L6a
            monitor-enter(r0)     // Catch: java.nio.channels.CancelledKeyException -> L2f java.lang.Throwable -> L6a
            java.nio.channels.Selector r1 = r8.selector     // Catch: java.lang.Throwable -> L2c
            java.nio.channels.DatagramChannel r2 = r9.getDatagramChannel()     // Catch: java.lang.Throwable -> L2c
            java.nio.channels.SelectionKey r2 = r2.keyFor(r1)     // Catch: java.lang.Throwable -> L2c
            if (r2 == 0) goto L13
            if (r1 != 0) goto L18
        L13:
            r9.setRawInterestOpsNow(r11)     // Catch: java.lang.Throwable -> L2c
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2c
        L17:
            return
        L18:
            r3 = r11 & (-5)
            int r4 = r9.getRawInterestOps()     // Catch: java.lang.Throwable -> L2c
            r4 = r4 & 4
            r3 = r3 | r4
            int r4 = org.jboss.netty.channel.socket.nio.NioProviderMetadata.CONSTRAINT_LEVEL     // Catch: java.lang.Throwable -> L2c
            switch(r4) {
                case 0: goto L3c;
                case 1: goto L72;
                case 2: goto L72;
                default: goto L26;
            }     // Catch: java.lang.Throwable -> L2c
        L26:
            java.lang.Error r1 = new java.lang.Error     // Catch: java.lang.Throwable -> L2c
            r1.<init>()     // Catch: java.lang.Throwable -> L2c
            throw r1     // Catch: java.lang.Throwable -> L2c
        L2c:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2c
            throw r1     // Catch: java.nio.channels.CancelledKeyException -> L2f java.lang.Throwable -> L6a
        L2f:
            r0 = move-exception
            java.nio.channels.ClosedChannelException r0 = new java.nio.channels.ClosedChannelException
            r0.<init>()
            r10.setFailure(r0)
            org.jboss.netty.channel.Channels.fireExceptionCaught(r9, r0)
            goto L17
        L3c:
            int r4 = r9.getRawInterestOps()     // Catch: java.lang.Throwable -> L2c
            if (r4 == r3) goto Lb4
            r2.interestOps(r3)     // Catch: java.lang.Throwable -> L2c
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2c
            java.lang.Thread r4 = r8.thread     // Catch: java.lang.Throwable -> L2c
            if (r2 == r4) goto L5a
            java.util.concurrent.atomic.AtomicBoolean r2 = r8.wakenUp     // Catch: java.lang.Throwable -> L2c
            r4 = 0
            r5 = 1
            boolean r2 = r2.compareAndSet(r4, r5)     // Catch: java.lang.Throwable -> L2c
            if (r2 == 0) goto L5a
            r1.wakeup()     // Catch: java.lang.Throwable -> L2c
        L5a:
            r1 = r7
        L5b:
            if (r1 == 0) goto L60
            r9.setRawInterestOpsNow(r3)     // Catch: java.lang.Throwable -> L2c
        L60:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2c
            r10.setSuccess()     // Catch: java.nio.channels.CancelledKeyException -> L2f java.lang.Throwable -> L6a
            if (r1 == 0) goto L17
            org.jboss.netty.channel.Channels.fireChannelInterestChanged(r9)     // Catch: java.nio.channels.CancelledKeyException -> L2f java.lang.Throwable -> L6a
            goto L17
        L6a:
            r0 = move-exception
            r10.setFailure(r0)
            org.jboss.netty.channel.Channels.fireExceptionCaught(r9, r0)
            goto L17
        L72:
            int r4 = r9.getRawInterestOps()     // Catch: java.lang.Throwable -> L2c
            if (r4 == r3) goto Lb4
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2c
            java.lang.Thread r5 = r8.thread     // Catch: java.lang.Throwable -> L2c
            if (r4 != r5) goto L85
            r2.interestOps(r3)     // Catch: java.lang.Throwable -> L2c
            r1 = r7
            goto L5b
        L85:
            java.util.concurrent.locks.ReadWriteLock r4 = r8.selectorGuard     // Catch: java.lang.Throwable -> L2c
            java.util.concurrent.locks.Lock r4 = r4.readLock()     // Catch: java.lang.Throwable -> L2c
            r4.lock()     // Catch: java.lang.Throwable -> L2c
            java.util.concurrent.atomic.AtomicBoolean r4 = r8.wakenUp     // Catch: java.lang.Throwable -> La9
            r5 = 0
            r6 = 1
            boolean r4 = r4.compareAndSet(r5, r6)     // Catch: java.lang.Throwable -> La9
            if (r4 == 0) goto L9b
            r1.wakeup()     // Catch: java.lang.Throwable -> La9
        L9b:
            r2.interestOps(r3)     // Catch: java.lang.Throwable -> La9
            java.util.concurrent.locks.ReadWriteLock r1 = r8.selectorGuard     // Catch: java.lang.Throwable -> L2c
            java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L2c
            r1.unlock()     // Catch: java.lang.Throwable -> L2c
            r1 = r7
            goto L5b
        La9:
            r1 = move-exception
            java.util.concurrent.locks.ReadWriteLock r2 = r8.selectorGuard     // Catch: java.lang.Throwable -> L2c
            java.util.concurrent.locks.Lock r2 = r2.readLock()     // Catch: java.lang.Throwable -> L2c
            r2.unlock()     // Catch: java.lang.Throwable -> L2c
            throw r1     // Catch: java.lang.Throwable -> L2c
        Lb4:
            r1 = r5
            goto L5b
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.nio.NioDatagramWorker.setInterestOps(org.jboss.netty.channel.socket.nio.NioDatagramChannel, org.jboss.netty.channel.ChannelFuture, int):void");
    }

    void writeFromSelectorLoop(SelectionKey selectionKey) {
        NioDatagramChannel nioDatagramChannel = (NioDatagramChannel) selectionKey.attachment();
        nioDatagramChannel.writeSuspended = false;
        write0(nioDatagramChannel);
    }

    void writeFromTaskLoop(NioDatagramChannel nioDatagramChannel) {
        if (nioDatagramChannel.writeSuspended) {
            return;
        }
        write0(nioDatagramChannel);
    }

    void writeFromUserCode(NioDatagramChannel nioDatagramChannel) {
        if (!nioDatagramChannel.isBound()) {
            cleanUpWriteBuffer(nioDatagramChannel);
        } else {
            if (scheduleWriteIfNecessary(nioDatagramChannel) || nioDatagramChannel.writeSuspended || nioDatagramChannel.inWriteNowLoop) {
                return;
            }
            write0(nioDatagramChannel);
        }
    }
}
