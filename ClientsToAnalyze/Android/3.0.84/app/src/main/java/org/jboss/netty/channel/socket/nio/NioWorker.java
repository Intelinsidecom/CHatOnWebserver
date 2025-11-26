package org.jboss.netty.channel.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.ReceiveBufferSizePredictor;
import org.jboss.netty.channel.socket.nio.SocketSendBufferPool;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.ThreadRenamingRunnable;
import org.jboss.netty.util.internal.DeadLockProofWorker;
import org.jboss.netty.util.internal.LinkedTransferQueue;

/* loaded from: classes.dex */
class NioWorker implements Runnable {
    static final /* synthetic */ boolean $assertionsDisabled;
    static final int CLEANUP_INTERVAL = 256;
    private static final int CONSTRAINT_LEVEL;
    private static final InternalLogger logger;
    private final int bossId;
    private volatile int cancelledKeys;
    private final Executor executor;

    /* renamed from: id */
    private final int f13693id;
    volatile Selector selector;
    private boolean started;
    private volatile Thread thread;
    private final AtomicBoolean wakenUp = new AtomicBoolean();
    private final ReadWriteLock selectorGuard = new ReentrantReadWriteLock();
    private final Object startStopLock = new Object();
    private final Queue<Runnable> registerTaskQueue = new LinkedTransferQueue();
    private final Queue<Runnable> writeTaskQueue = new LinkedTransferQueue();
    private final SocketReceiveBufferPool recvBufferPool = new SocketReceiveBufferPool();
    private final SocketSendBufferPool sendBufferPool = new SocketSendBufferPool();

    static {
        $assertionsDisabled = !NioWorker.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance((Class<?>) NioWorker.class);
        CONSTRAINT_LEVEL = NioProviderMetadata.CONSTRAINT_LEVEL;
    }

    NioWorker(int i, int i2, Executor executor) {
        this.bossId = i;
        this.f13693id = i2;
        this.executor = executor;
    }

    void register(NioSocketChannel nioSocketChannel, ChannelFuture channelFuture) {
        Selector selector;
        boolean z = !(nioSocketChannel instanceof NioClientSocketChannel);
        RegisterTask registerTask = new RegisterTask(nioSocketChannel, channelFuture, z);
        synchronized (this.startStopLock) {
            if (!this.started) {
                try {
                    Selector selectorOpen = Selector.open();
                    this.selector = selectorOpen;
                    try {
                        DeadLockProofWorker.start(this.executor, new ThreadRenamingRunnable(this, (z ? "New I/O server worker #" : "New I/O client worker #") + this.bossId + '-' + this.f13693id));
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
        this.thread = Thread.currentThread();
        Selector selector = this.selector;
        boolean z2 = false;
        while (true) {
            this.wakenUp.set(false);
            if (CONSTRAINT_LEVEL != 0) {
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
                } else if (z2 || ((this.executor instanceof ExecutorService) && ((ExecutorService) this.executor).isShutdown())) {
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
                                } catch (Throwable th) {
                                    this.selector = null;
                                    throw th;
                                }
                            }
                            try {
                            } catch (Throwable th2) {
                                th = th2;
                                z2 = false;
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    }
                    z = false;
                } else {
                    z = true;
                }
                z2 = z;
            } catch (Throwable th4) {
                boolean z3 = z2;
                logger.warn("Unexpected exception in the selector loop.", th4);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e2) {
                }
                z2 = z3;
            }
        }
    }

    private void processRegisterTaskQueue() throws IOException {
        while (true) {
            Runnable runnablePoll = this.registerTaskQueue.poll();
            if (runnablePoll != null) {
                runnablePoll.run();
                cleanUpCancelledKeys();
            } else {
                return;
            }
        }
    }

    private void processWriteTaskQueue() throws IOException {
        while (true) {
            Runnable runnablePoll = this.writeTaskQueue.poll();
            if (runnablePoll != null) {
                runnablePoll.run();
                cleanUpCancelledKeys();
            } else {
                return;
            }
        }
    }

    private void processSelectedKeys(Set<SelectionKey> set) {
        int i;
        Iterator<SelectionKey> it = set.iterator();
        while (it.hasNext()) {
            SelectionKey next = it.next();
            it.remove();
            try {
                i = next.readyOps();
            } catch (CancelledKeyException e) {
                close(next);
            }
            if (((i & 1) == 0 && i != 0) || read(next)) {
                if ((i & 4) != 0) {
                    writeFromSelectorLoop(next);
                }
                if (cleanUpCancelledKeys()) {
                    return;
                }
            }
        }
    }

    private boolean cleanUpCancelledKeys() throws IOException {
        if (this.cancelledKeys < 256) {
            return false;
        }
        this.cancelledKeys = 0;
        this.selector.selectNow();
        return true;
    }

    private boolean read(SelectionKey selectionKey) {
        boolean z;
        int i;
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        NioSocketChannel nioSocketChannel = (NioSocketChannel) selectionKey.attachment();
        ReceiveBufferSizePredictor receiveBufferSizePredictor = nioSocketChannel.getConfig().getReceiveBufferSizePredictor();
        ByteBuffer byteBufferAcquire = this.recvBufferPool.acquire(receiveBufferSizePredictor.nextReceiveBufferSize());
        int i2 = 0;
        int i3 = 0;
        while (true) {
            try {
                i3 = socketChannel.read(byteBufferAcquire);
                if (i3 <= 0) {
                    i = i2;
                    break;
                }
                i2 += i3;
                if (!byteBufferAcquire.hasRemaining()) {
                    i = i2;
                    break;
                }
            } catch (ClosedChannelException e) {
                i3 = i3;
                z = true;
            } catch (Throwable th) {
                Channels.fireExceptionCaught(nioSocketChannel, th);
                z = true;
            }
        }
        i2 = i;
        z = false;
        if (i2 > 0) {
            byteBufferAcquire.flip();
            ChannelBuffer buffer = nioSocketChannel.getConfig().getBufferFactory().getBuffer(i2);
            buffer.setBytes(0, byteBufferAcquire);
            buffer.writerIndex(i2);
            this.recvBufferPool.release(byteBufferAcquire);
            receiveBufferSizePredictor.previousReceiveBufferSize(i2);
            Channels.fireMessageReceived(nioSocketChannel, buffer);
        } else {
            this.recvBufferPool.release(byteBufferAcquire);
        }
        if (i3 >= 0 && !z) {
            return true;
        }
        selectionKey.cancel();
        close(nioSocketChannel, Channels.succeededFuture(nioSocketChannel));
        return false;
    }

    private void close(SelectionKey selectionKey) {
        NioSocketChannel nioSocketChannel = (NioSocketChannel) selectionKey.attachment();
        close(nioSocketChannel, Channels.succeededFuture(nioSocketChannel));
    }

    void writeFromUserCode(NioSocketChannel nioSocketChannel) {
        if (!nioSocketChannel.isConnected()) {
            cleanUpWriteBuffer(nioSocketChannel);
        } else if (!scheduleWriteIfNecessary(nioSocketChannel) && !nioSocketChannel.writeSuspended && !nioSocketChannel.inWriteNowLoop) {
            write0(nioSocketChannel);
        }
    }

    void writeFromTaskLoop(NioSocketChannel nioSocketChannel) {
        if (!nioSocketChannel.writeSuspended) {
            write0(nioSocketChannel);
        }
    }

    void writeFromSelectorLoop(SelectionKey selectionKey) {
        NioSocketChannel nioSocketChannel = (NioSocketChannel) selectionKey.attachment();
        nioSocketChannel.writeSuspended = false;
        write0(nioSocketChannel);
    }

    private boolean scheduleWriteIfNecessary(NioSocketChannel nioSocketChannel) {
        Selector selector;
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread == this.thread) {
            return false;
        }
        if (nioSocketChannel.writeTaskInTaskQueue.compareAndSet(false, true)) {
            boolean zOffer = this.writeTaskQueue.offer(nioSocketChannel.writeTask);
            if (!$assertionsDisabled && !zOffer) {
                throw new AssertionError();
            }
        }
        if (((nioSocketChannel instanceof NioAcceptedSocketChannel) && ((NioAcceptedSocketChannel) nioSocketChannel).bossThread == threadCurrentThread) || (selector = this.selector) == null || !this.wakenUp.compareAndSet(false, true)) {
            return true;
        }
        selector.wakeup();
        return true;
    }

    private void write0(NioSocketChannel nioSocketChannel) {
        SocketSendBufferPool.SendBuffer sendBufferAcquire;
        boolean z;
        boolean z2;
        long j;
        boolean z3;
        SocketSendBufferPool.SendBuffer sendBuffer;
        Throwable th;
        long j2;
        boolean z4 = true;
        boolean z5 = false;
        long j3 = 0;
        SocketSendBufferPool socketSendBufferPool = this.sendBufferPool;
        SocketChannel socketChannel = nioSocketChannel.socket;
        Queue<MessageEvent> queue = nioSocketChannel.writeBuffer;
        int writeSpinCount = nioSocketChannel.getConfig().getWriteSpinCount();
        synchronized (nioSocketChannel.writeLock) {
            nioSocketChannel.inWriteNowLoop = true;
            while (true) {
                MessageEvent messageEventPoll = nioSocketChannel.currentWriteEvent;
                if (messageEventPoll == null) {
                    messageEventPoll = queue.poll();
                    nioSocketChannel.currentWriteEvent = messageEventPoll;
                    if (messageEventPoll == null) {
                        z = true;
                        nioSocketChannel.writeSuspended = false;
                        break;
                    } else {
                        sendBufferAcquire = socketSendBufferPool.acquire(messageEventPoll.getMessage());
                        nioSocketChannel.currentWriteBuffer = sendBufferAcquire;
                    }
                } else {
                    sendBufferAcquire = nioSocketChannel.currentWriteBuffer;
                }
                ChannelFuture future = messageEventPoll.getFuture();
                long jTransferTo = 0;
                int i = writeSpinCount;
                while (true) {
                    if (i <= 0) {
                        break;
                    }
                    try {
                        try {
                            jTransferTo = sendBufferAcquire.transferTo(socketChannel);
                            if (jTransferTo != 0) {
                                j3 += jTransferTo;
                                break;
                            } else if (sendBufferAcquire.finished()) {
                                break;
                            } else {
                                i--;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            sendBuffer = sendBufferAcquire;
                            j2 = j3;
                        }
                    } catch (AsynchronousCloseException e) {
                        j = j3;
                        z2 = z5;
                        z3 = z4;
                        j3 = j;
                        z4 = z3;
                        z5 = z2;
                    }
                }
                if (sendBufferAcquire.finished()) {
                    sendBufferAcquire.release();
                    nioSocketChannel.currentWriteEvent = null;
                    nioSocketChannel.currentWriteBuffer = null;
                    try {
                        future.setSuccess();
                        j = j3;
                        z2 = z5;
                        z3 = z4;
                    } catch (Throwable th3) {
                        th = th3;
                        sendBuffer = null;
                        j2 = j3;
                    }
                    j3 = j;
                    z4 = z3;
                    z5 = z2;
                } else {
                    try {
                        nioSocketChannel.writeSuspended = true;
                        if (jTransferTo <= 0) {
                            break;
                        }
                        future.setProgress(jTransferTo, sendBufferAcquire.writtenBytes(), sendBufferAcquire.totalBytes());
                        break;
                    } catch (AsynchronousCloseException e2) {
                        j = j3;
                        z2 = true;
                        z3 = z4;
                        j3 = j;
                        z4 = z3;
                        z5 = z2;
                    } catch (Throwable th4) {
                        th = th4;
                        sendBuffer = sendBufferAcquire;
                        z5 = true;
                        j2 = j3;
                    }
                }
                sendBuffer.release();
                nioSocketChannel.currentWriteEvent = null;
                nioSocketChannel.currentWriteBuffer = null;
                future.setFailure(th);
                Channels.fireExceptionCaught(nioSocketChannel, th);
                if (th instanceof IOException) {
                    close(nioSocketChannel, Channels.succeededFuture(nioSocketChannel));
                    z2 = z5;
                    z3 = false;
                    j = j2;
                } else {
                    j = j2;
                    z2 = z5;
                    z3 = z4;
                }
                j3 = j;
                z4 = z3;
                z5 = z2;
            }
            z = false;
            z5 = true;
            nioSocketChannel.inWriteNowLoop = false;
            if (z4) {
                if (z5) {
                    setOpWrite(nioSocketChannel);
                } else if (z) {
                    clearOpWrite(nioSocketChannel);
                }
            }
        }
        Channels.fireWriteComplete(nioSocketChannel, j3);
    }

    private void setOpWrite(NioSocketChannel nioSocketChannel) {
        SelectionKey selectionKeyKeyFor = nioSocketChannel.socket.keyFor(this.selector);
        if (selectionKeyKeyFor != null) {
            if (!selectionKeyKeyFor.isValid()) {
                close(selectionKeyKeyFor);
                return;
            }
            synchronized (nioSocketChannel.interestOpsLock) {
                int rawInterestOps = nioSocketChannel.getRawInterestOps();
                if ((rawInterestOps & 4) == 0) {
                    int i = rawInterestOps | 4;
                    selectionKeyKeyFor.interestOps(i);
                    nioSocketChannel.setRawInterestOpsNow(i);
                }
            }
        }
    }

    private void clearOpWrite(NioSocketChannel nioSocketChannel) {
        SelectionKey selectionKeyKeyFor = nioSocketChannel.socket.keyFor(this.selector);
        if (selectionKeyKeyFor != null) {
            if (!selectionKeyKeyFor.isValid()) {
                close(selectionKeyKeyFor);
                return;
            }
            synchronized (nioSocketChannel.interestOpsLock) {
                int rawInterestOps = nioSocketChannel.getRawInterestOps();
                if ((rawInterestOps & 4) != 0) {
                    int i = rawInterestOps & (-5);
                    selectionKeyKeyFor.interestOps(i);
                    nioSocketChannel.setRawInterestOpsNow(i);
                }
            }
        }
    }

    void close(NioSocketChannel nioSocketChannel, ChannelFuture channelFuture) {
        boolean zIsConnected = nioSocketChannel.isConnected();
        boolean zIsBound = nioSocketChannel.isBound();
        try {
            nioSocketChannel.socket.close();
            this.cancelledKeys++;
            if (nioSocketChannel.setClosed()) {
                channelFuture.setSuccess();
                if (zIsConnected) {
                    Channels.fireChannelDisconnected(nioSocketChannel);
                }
                if (zIsBound) {
                    Channels.fireChannelUnbound(nioSocketChannel);
                }
                cleanUpWriteBuffer(nioSocketChannel);
                Channels.fireChannelClosed(nioSocketChannel);
                return;
            }
            channelFuture.setSuccess();
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(nioSocketChannel, th);
        }
    }

    private void cleanUpWriteBuffer(NioSocketChannel nioSocketChannel) {
        Throwable closedChannelException;
        boolean z;
        Throwable closedChannelException2 = null;
        boolean z2 = false;
        synchronized (nioSocketChannel.writeLock) {
            MessageEvent messageEvent = nioSocketChannel.currentWriteEvent;
            if (messageEvent != null) {
                if (nioSocketChannel.isOpen()) {
                    closedChannelException2 = new NotYetConnectedException();
                } else {
                    closedChannelException2 = new ClosedChannelException();
                }
                ChannelFuture future = messageEvent.getFuture();
                nioSocketChannel.currentWriteBuffer.release();
                nioSocketChannel.currentWriteBuffer = null;
                nioSocketChannel.currentWriteEvent = null;
                future.setFailure(closedChannelException2);
                z2 = true;
            }
            Queue<MessageEvent> queue = nioSocketChannel.writeBuffer;
            if (!queue.isEmpty()) {
                if (closedChannelException2 != null) {
                    closedChannelException = closedChannelException2;
                    z = z2;
                } else if (nioSocketChannel.isOpen()) {
                    closedChannelException = new NotYetConnectedException();
                    z = z2;
                } else {
                    closedChannelException = new ClosedChannelException();
                    z = z2;
                }
                while (true) {
                    MessageEvent messageEventPoll = queue.poll();
                    if (messageEventPoll == null) {
                        break;
                    }
                    messageEventPoll.getFuture().setFailure(closedChannelException);
                    z = true;
                }
                z2 = z;
                closedChannelException2 = closedChannelException;
            }
        }
        if (z2) {
            Channels.fireExceptionCaught(nioSocketChannel, closedChannelException2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005a A[Catch: all -> 0x002a, TryCatch #2 {, blocks: (B:5:0x0005, B:11:0x0016, B:12:0x0021, B:13:0x0024, B:14:0x0029, B:20:0x003a, B:22:0x0040, B:24:0x004b, B:26:0x0055, B:28:0x005a, B:29:0x005d, B:36:0x006f, B:38:0x0075, B:40:0x007d, B:41:0x0081, B:46:0x009a, B:48:0x00a5, B:49:0x00ae, B:8:0x0011, B:9:0x0014, B:42:0x008a, B:44:0x0094, B:45:0x0097), top: B:53:0x0005, outer: #4, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0063 A[Catch: CancelledKeyException -> 0x002d, Throwable -> 0x0067, TRY_LEAVE, TryCatch #4 {CancelledKeyException -> 0x002d, Throwable -> 0x0067, blocks: (B:3:0x0002, B:4:0x0004, B:30:0x005e, B:32:0x0063, B:17:0x002c, B:5:0x0005, B:11:0x0016, B:12:0x0021, B:13:0x0024, B:14:0x0029, B:20:0x003a, B:22:0x0040, B:24:0x004b, B:26:0x0055, B:28:0x005a, B:29:0x005d, B:36:0x006f, B:38:0x0075, B:40:0x007d, B:41:0x0081, B:46:0x009a, B:48:0x00a5, B:49:0x00ae, B:8:0x0011, B:9:0x0014, B:42:0x008a, B:44:0x0094, B:45:0x0097), top: B:54:0x0002, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void setInterestOps(org.jboss.netty.channel.socket.nio.NioSocketChannel r9, org.jboss.netty.channel.ChannelFuture r10, int r11) {
        /*
            r8 = this;
            r1 = 0
            r0 = 1
            java.lang.Object r2 = r9.interestOpsLock     // Catch: java.nio.channels.CancelledKeyException -> L2d java.lang.Throwable -> L67
            monitor-enter(r2)     // Catch: java.nio.channels.CancelledKeyException -> L2d java.lang.Throwable -> L67
            java.nio.channels.Selector r3 = r8.selector     // Catch: java.lang.Throwable -> L2a
            java.nio.channels.SocketChannel r4 = r9.socket     // Catch: java.lang.Throwable -> L2a
            java.nio.channels.SelectionKey r4 = r4.keyFor(r3)     // Catch: java.lang.Throwable -> L2a
            if (r4 == 0) goto L11
            if (r3 != 0) goto L16
        L11:
            r9.setRawInterestOpsNow(r11)     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
        L15:
            return
        L16:
            r5 = r11 & (-5)
            int r6 = r9.getRawInterestOps()     // Catch: java.lang.Throwable -> L2a
            r6 = r6 & 4
            r5 = r5 | r6
            int r6 = org.jboss.netty.channel.socket.nio.NioWorker.CONSTRAINT_LEVEL     // Catch: java.lang.Throwable -> L2a
            switch(r6) {
                case 0: goto L3a;
                case 1: goto L6f;
                case 2: goto L6f;
                default: goto L24;
            }     // Catch: java.lang.Throwable -> L2a
        L24:
            java.lang.Error r0 = new java.lang.Error     // Catch: java.lang.Throwable -> L2a
            r0.<init>()     // Catch: java.lang.Throwable -> L2a
            throw r0     // Catch: java.lang.Throwable -> L2a
        L2a:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
            throw r0     // Catch: java.nio.channels.CancelledKeyException -> L2d java.lang.Throwable -> L67
        L2d:
            r0 = move-exception
            java.nio.channels.ClosedChannelException r0 = new java.nio.channels.ClosedChannelException
            r0.<init>()
            r10.setFailure(r0)
            org.jboss.netty.channel.Channels.fireExceptionCaught(r9, r0)
            goto L15
        L3a:
            int r6 = r9.getRawInterestOps()     // Catch: java.lang.Throwable -> L2a
            if (r6 == r5) goto Laf
            r4.interestOps(r5)     // Catch: java.lang.Throwable -> L2a
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2a
            java.lang.Thread r4 = r8.thread     // Catch: java.lang.Throwable -> L2a
            if (r1 == r4) goto L58
            java.util.concurrent.atomic.AtomicBoolean r1 = r8.wakenUp     // Catch: java.lang.Throwable -> L2a
            r4 = 0
            r6 = 1
            boolean r1 = r1.compareAndSet(r4, r6)     // Catch: java.lang.Throwable -> L2a
            if (r1 == 0) goto L58
            r3.wakeup()     // Catch: java.lang.Throwable -> L2a
        L58:
            if (r0 == 0) goto L5d
            r9.setRawInterestOpsNow(r5)     // Catch: java.lang.Throwable -> L2a
        L5d:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
            r10.setSuccess()     // Catch: java.nio.channels.CancelledKeyException -> L2d java.lang.Throwable -> L67
            if (r0 == 0) goto L15
            org.jboss.netty.channel.Channels.fireChannelInterestChanged(r9)     // Catch: java.nio.channels.CancelledKeyException -> L2d java.lang.Throwable -> L67
            goto L15
        L67:
            r0 = move-exception
            r10.setFailure(r0)
            org.jboss.netty.channel.Channels.fireExceptionCaught(r9, r0)
            goto L15
        L6f:
            int r6 = r9.getRawInterestOps()     // Catch: java.lang.Throwable -> L2a
            if (r6 == r5) goto Laf
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2a
            java.lang.Thread r6 = r8.thread     // Catch: java.lang.Throwable -> L2a
            if (r1 != r6) goto L81
            r4.interestOps(r5)     // Catch: java.lang.Throwable -> L2a
            goto L58
        L81:
            java.util.concurrent.locks.ReadWriteLock r1 = r8.selectorGuard     // Catch: java.lang.Throwable -> L2a
            java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L2a
            r1.lock()     // Catch: java.lang.Throwable -> L2a
            java.util.concurrent.atomic.AtomicBoolean r1 = r8.wakenUp     // Catch: java.lang.Throwable -> La4
            r6 = 0
            r7 = 1
            boolean r1 = r1.compareAndSet(r6, r7)     // Catch: java.lang.Throwable -> La4
            if (r1 == 0) goto L97
            r3.wakeup()     // Catch: java.lang.Throwable -> La4
        L97:
            r4.interestOps(r5)     // Catch: java.lang.Throwable -> La4
            java.util.concurrent.locks.ReadWriteLock r1 = r8.selectorGuard     // Catch: java.lang.Throwable -> L2a
            java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L2a
            r1.unlock()     // Catch: java.lang.Throwable -> L2a
            goto L58
        La4:
            r0 = move-exception
            java.util.concurrent.locks.ReadWriteLock r1 = r8.selectorGuard     // Catch: java.lang.Throwable -> L2a
            java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L2a
            r1.unlock()     // Catch: java.lang.Throwable -> L2a
            throw r0     // Catch: java.lang.Throwable -> L2a
        Laf:
            r0 = r1
            goto L58
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.nio.NioWorker.setInterestOps(org.jboss.netty.channel.socket.nio.NioSocketChannel, org.jboss.netty.channel.ChannelFuture, int):void");
    }

    final class RegisterTask implements Runnable {
        private final NioSocketChannel channel;
        private final ChannelFuture future;
        private final boolean server;

        RegisterTask(NioSocketChannel nioSocketChannel, ChannelFuture channelFuture, boolean z) {
            this.channel = nioSocketChannel;
            this.future = channelFuture;
            this.server = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            InetSocketAddress localAddress = this.channel.getLocalAddress();
            InetSocketAddress remoteAddress = this.channel.getRemoteAddress();
            if (localAddress == null || remoteAddress == null) {
                if (this.future != null) {
                    this.future.setFailure(new ClosedChannelException());
                }
                NioWorker.this.close(this.channel, Channels.succeededFuture(this.channel));
                return;
            }
            try {
                if (this.server) {
                    this.channel.socket.configureBlocking(false);
                }
                synchronized (this.channel.interestOpsLock) {
                    this.channel.socket.register(NioWorker.this.selector, this.channel.getRawInterestOps(), this.channel);
                }
                if (this.future != null) {
                    this.channel.setConnected();
                    this.future.setSuccess();
                }
            } catch (IOException e) {
                if (this.future != null) {
                    this.future.setFailure(e);
                }
                NioWorker.this.close(this.channel, Channels.succeededFuture(this.channel));
                if (!(e instanceof ClosedChannelException)) {
                    throw new ChannelException("Failed to register a socket to the selector.", e);
                }
            }
            if (this.server || !((NioClientSocketChannel) this.channel).boundManually) {
                Channels.fireChannelBound(this.channel, localAddress);
            }
            Channels.fireChannelConnected(this.channel, remoteAddress);
        }
    }
}
