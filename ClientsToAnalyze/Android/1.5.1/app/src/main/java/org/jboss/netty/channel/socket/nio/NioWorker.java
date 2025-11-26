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
    private final int f4567id;
    volatile Selector selector;
    private boolean started;
    private volatile Thread thread;
    private final AtomicBoolean wakenUp = new AtomicBoolean();
    private final ReadWriteLock selectorGuard = new ReentrantReadWriteLock();
    private final Object startStopLock = new Object();
    private final Queue registerTaskQueue = new LinkedTransferQueue();
    private final Queue writeTaskQueue = new LinkedTransferQueue();
    private final SocketReceiveBufferPool recvBufferPool = new SocketReceiveBufferPool();
    private final SocketSendBufferPool sendBufferPool = new SocketSendBufferPool();

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
            if (this.server) {
                return;
            }
            if (!((NioClientSocketChannel) this.channel).boundManually) {
                Channels.fireChannelBound(this.channel, localAddress);
            }
            Channels.fireChannelConnected(this.channel, remoteAddress);
        }
    }

    static {
        $assertionsDisabled = !NioWorker.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(NioWorker.class);
        CONSTRAINT_LEVEL = NioProviderMetadata.CONSTRAINT_LEVEL;
    }

    NioWorker(int i, int i2, Executor executor) {
        this.bossId = i;
        this.f4567id = i2;
        this.executor = executor;
    }

    private boolean cleanUpCancelledKeys() throws IOException {
        if (this.cancelledKeys < CLEANUP_INTERVAL) {
            return false;
        }
        this.cancelledKeys = 0;
        this.selector.selectNow();
        return true;
    }

    private void cleanUpWriteBuffer(NioSocketChannel nioSocketChannel) {
        Throwable notYetConnectedException;
        boolean z = false;
        synchronized (nioSocketChannel.writeLock) {
            MessageEvent messageEvent = nioSocketChannel.currentWriteEvent;
            if (messageEvent != null) {
                Throwable notYetConnectedException2 = nioSocketChannel.isOpen() ? new NotYetConnectedException() : new ClosedChannelException();
                ChannelFuture future = messageEvent.getFuture();
                nioSocketChannel.currentWriteBuffer.release();
                nioSocketChannel.currentWriteBuffer = null;
                nioSocketChannel.currentWriteEvent = null;
                future.setFailure(notYetConnectedException2);
                notYetConnectedException = notYetConnectedException2;
                z = true;
            } else {
                notYetConnectedException = null;
            }
            Queue queue = nioSocketChannel.writeBuffer;
            if (!queue.isEmpty()) {
                if (notYetConnectedException == null) {
                    notYetConnectedException = nioSocketChannel.isOpen() ? new NotYetConnectedException() : new ClosedChannelException();
                }
                while (true) {
                    MessageEvent messageEvent2 = (MessageEvent) queue.poll();
                    if (messageEvent2 == null) {
                        break;
                    }
                    messageEvent2.getFuture().setFailure(notYetConnectedException);
                    z = true;
                }
            }
        }
        if (z) {
            Channels.fireExceptionCaught(nioSocketChannel, notYetConnectedException);
        }
    }

    private void clearOpWrite(NioSocketChannel nioSocketChannel) {
        SelectionKey selectionKeyKeyFor = nioSocketChannel.socket.keyFor(this.selector);
        if (selectionKeyKeyFor == null) {
            return;
        }
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

    private void close(SelectionKey selectionKey) {
        NioSocketChannel nioSocketChannel = (NioSocketChannel) selectionKey.attachment();
        close(nioSocketChannel, Channels.succeededFuture(nioSocketChannel));
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
                i2 = i2;
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
        close(nioSocketChannel, Channels.succeededFuture(nioSocketChannel));
        return false;
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
        if ((!(nioSocketChannel instanceof NioAcceptedSocketChannel) || ((NioAcceptedSocketChannel) nioSocketChannel).bossThread != threadCurrentThread) && (selector = this.selector) != null && this.wakenUp.compareAndSet(false, true)) {
            selector.wakeup();
        }
        return true;
    }

    private void setOpWrite(NioSocketChannel nioSocketChannel) {
        SelectionKey selectionKeyKeyFor = nioSocketChannel.socket.keyFor(this.selector);
        if (selectionKeyKeyFor == null) {
            return;
        }
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

    private void write0(NioSocketChannel nioSocketChannel) {
        boolean z;
        boolean z2;
        SocketSendBufferPool.SendBuffer sendBuffer;
        boolean z3;
        long j;
        long j2;
        long j3;
        boolean z4;
        long j4;
        boolean z5;
        boolean z6;
        long j5;
        SocketSendBufferPool.SendBuffer sendBuffer2;
        Throwable th;
        SocketSendBufferPool socketSendBufferPool = this.sendBufferPool;
        SocketChannel socketChannel = nioSocketChannel.socket;
        Queue queue = nioSocketChannel.writeBuffer;
        int writeSpinCount = nioSocketChannel.getConfig().getWriteSpinCount();
        synchronized (nioSocketChannel.writeLock) {
            nioSocketChannel.inWriteNowLoop = true;
            z = true;
            long j6 = 0;
            z2 = false;
            while (true) {
                MessageEvent messageEvent = nioSocketChannel.currentWriteEvent;
                if (messageEvent == null) {
                    messageEvent = (MessageEvent) queue.poll();
                    nioSocketChannel.currentWriteEvent = messageEvent;
                    if (messageEvent == null) {
                        nioSocketChannel.writeSuspended = false;
                        z3 = true;
                        j = j6;
                        break;
                    } else {
                        SocketSendBufferPool.SendBuffer sendBufferAcquire = socketSendBufferPool.acquire(messageEvent.getMessage());
                        nioSocketChannel.currentWriteBuffer = sendBufferAcquire;
                        sendBuffer = sendBufferAcquire;
                    }
                } else {
                    sendBuffer = nioSocketChannel.currentWriteBuffer;
                }
                ChannelFuture future = messageEvent.getFuture();
                long jTransferTo = 0;
                int i = writeSpinCount;
                while (true) {
                    if (i <= 0) {
                        j2 = j6;
                        j3 = jTransferTo;
                        break;
                    }
                    try {
                        jTransferTo = sendBuffer.transferTo(socketChannel);
                        if (jTransferTo != 0) {
                            j2 = j6 + jTransferTo;
                            j3 = jTransferTo;
                            break;
                        } else {
                            if (sendBuffer.finished()) {
                                j2 = j6;
                                j3 = jTransferTo;
                                break;
                            }
                            i--;
                        }
                    } catch (AsynchronousCloseException e) {
                        j4 = j6;
                        z4 = z2;
                        z5 = z;
                        z = z5;
                        z2 = z4;
                        j6 = j4;
                    } catch (Throwable th2) {
                        z6 = z2;
                        long j7 = j6;
                        sendBuffer2 = sendBuffer;
                        th = th2;
                        j5 = j7;
                    }
                }
                try {
                    try {
                    } catch (AsynchronousCloseException e2) {
                        j4 = j2;
                        z4 = z2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    sendBuffer2 = sendBuffer;
                    z6 = z2;
                    j5 = j2;
                }
                if (sendBuffer.finished()) {
                    sendBuffer.release();
                    nioSocketChannel.currentWriteEvent = null;
                    nioSocketChannel.currentWriteBuffer = null;
                    try {
                        future.setSuccess();
                        j4 = j2;
                        z4 = z2;
                        z5 = z;
                    } catch (Throwable th4) {
                        z6 = z2;
                        j5 = j2;
                        th = th4;
                        sendBuffer2 = null;
                    }
                    z = z5;
                    z2 = z4;
                    j6 = j4;
                } else {
                    try {
                        nioSocketChannel.writeSuspended = true;
                        if (j3 <= 0) {
                            break;
                        }
                        future.setProgress(j3, sendBuffer.writtenBytes(), sendBuffer.totalBytes());
                        break;
                    } catch (AsynchronousCloseException e3) {
                        j4 = j2;
                        z4 = true;
                        z5 = z;
                        z = z5;
                        z2 = z4;
                        j6 = j4;
                    } catch (Throwable th5) {
                        th = th5;
                        sendBuffer2 = sendBuffer;
                        j5 = j2;
                        z6 = true;
                    }
                }
                sendBuffer2.release();
                nioSocketChannel.currentWriteEvent = null;
                nioSocketChannel.currentWriteBuffer = null;
                future.setFailure(th);
                Channels.fireExceptionCaught(nioSocketChannel, th);
                if (th instanceof IOException) {
                    close(nioSocketChannel, Channels.succeededFuture(nioSocketChannel));
                    z4 = z6;
                    long j8 = j5;
                    z5 = false;
                    j4 = j8;
                } else {
                    j4 = j5;
                    z4 = z6;
                    z5 = z;
                }
                z = z5;
                z2 = z4;
                j6 = j4;
            }
            j = j2;
            z3 = false;
            z2 = true;
            nioSocketChannel.inWriteNowLoop = false;
        }
        Channels.fireWriteComplete(nioSocketChannel, j);
        if (z) {
            if (z2) {
                setOpWrite(nioSocketChannel);
            } else if (z3) {
                clearOpWrite(nioSocketChannel);
            }
        }
    }

    void close(NioSocketChannel nioSocketChannel, ChannelFuture channelFuture) {
        boolean zIsConnected = nioSocketChannel.isConnected();
        boolean zIsBound = nioSocketChannel.isBound();
        try {
            nioSocketChannel.socket.close();
            this.cancelledKeys++;
            if (!nioSocketChannel.setClosed()) {
                channelFuture.setSuccess();
                return;
            }
            channelFuture.setSuccess();
            if (zIsConnected) {
                Channels.fireChannelDisconnected(nioSocketChannel);
            }
            if (zIsBound) {
                Channels.fireChannelUnbound(nioSocketChannel);
            }
            cleanUpWriteBuffer(nioSocketChannel);
            Channels.fireChannelClosed(nioSocketChannel);
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(nioSocketChannel, th);
        }
    }

    void register(NioSocketChannel nioSocketChannel, ChannelFuture channelFuture) {
        Selector selector;
        boolean z = !(nioSocketChannel instanceof NioClientSocketChannel);
        RegisterTask registerTask = new RegisterTask(nioSocketChannel, channelFuture, z);
        synchronized (this.startStopLock) {
            if (this.started) {
                selector = this.selector;
            } else {
                try {
                    Selector selectorOpen = Selector.open();
                    this.selector = selectorOpen;
                    try {
                        DeadLockProofWorker.start(this.executor, new ThreadRenamingRunnable(this, (z ? "New I/O server worker #" : "New I/O client worker #") + this.bossId + '-' + this.f4567id));
                        if (1 == 0) {
                            try {
                                selectorOpen.close();
                            } catch (Throwable th) {
                                logger.warn("Failed to close a selector.", th);
                            }
                            this.selector = null;
                            selector = null;
                        } else {
                            selector = selectorOpen;
                        }
                    } finally {
                    }
                } catch (Throwable th2) {
                    throw new ChannelException("Failed to create a selector.", th2);
                }
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
        boolean z2;
        Throwable th;
        this.thread = Thread.currentThread();
        Selector selector = this.selector;
        boolean z3 = false;
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

    /* JADX WARN: Removed duplicated region for block: B:29:0x005b A[Catch: all -> 0x002a, TryCatch #2 {, blocks: (B:5:0x0005, B:11:0x0016, B:12:0x0021, B:13:0x0024, B:14:0x0029, B:20:0x003a, B:22:0x0040, B:24:0x004b, B:26:0x0055, B:29:0x005b, B:30:0x005e, B:37:0x0070, B:39:0x0076, B:41:0x007e, B:42:0x0083, B:47:0x009c, B:49:0x00a8, B:50:0x00b1, B:8:0x0011, B:9:0x0014, B:43:0x008c, B:45:0x0096, B:46:0x0099), top: B:54:0x0005, outer: #4, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0064 A[Catch: CancelledKeyException -> 0x002d, Throwable -> 0x0068, TRY_LEAVE, TryCatch #4 {CancelledKeyException -> 0x002d, Throwable -> 0x0068, blocks: (B:3:0x0002, B:4:0x0004, B:31:0x005f, B:33:0x0064, B:17:0x002c, B:5:0x0005, B:11:0x0016, B:12:0x0021, B:13:0x0024, B:14:0x0029, B:20:0x003a, B:22:0x0040, B:24:0x004b, B:26:0x0055, B:29:0x005b, B:30:0x005e, B:37:0x0070, B:39:0x0076, B:41:0x007e, B:42:0x0083, B:47:0x009c, B:49:0x00a8, B:50:0x00b1, B:8:0x0011, B:9:0x0014, B:43:0x008c, B:45:0x0096, B:46:0x0099), top: B:55:0x0002, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void setInterestOps(org.jboss.netty.channel.socket.nio.NioSocketChannel r9, org.jboss.netty.channel.ChannelFuture r10, int r11) {
        /*
            r8 = this;
            r5 = 0
            r7 = 1
            java.lang.Object r0 = r9.interestOpsLock     // Catch: java.nio.channels.CancelledKeyException -> L2d java.lang.Throwable -> L68
            monitor-enter(r0)     // Catch: java.nio.channels.CancelledKeyException -> L2d java.lang.Throwable -> L68
            java.nio.channels.Selector r1 = r8.selector     // Catch: java.lang.Throwable -> L2a
            java.nio.channels.SocketChannel r2 = r9.socket     // Catch: java.lang.Throwable -> L2a
            java.nio.channels.SelectionKey r2 = r2.keyFor(r1)     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L11
            if (r1 != 0) goto L16
        L11:
            r9.setRawInterestOpsNow(r11)     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
        L15:
            return
        L16:
            r3 = r11 & (-5)
            int r4 = r9.getRawInterestOps()     // Catch: java.lang.Throwable -> L2a
            r4 = r4 & 4
            r3 = r3 | r4
            int r4 = org.jboss.netty.channel.socket.nio.NioWorker.CONSTRAINT_LEVEL     // Catch: java.lang.Throwable -> L2a
            switch(r4) {
                case 0: goto L3a;
                case 1: goto L70;
                case 2: goto L70;
                default: goto L24;
            }     // Catch: java.lang.Throwable -> L2a
        L24:
            java.lang.Error r1 = new java.lang.Error     // Catch: java.lang.Throwable -> L2a
            r1.<init>()     // Catch: java.lang.Throwable -> L2a
            throw r1     // Catch: java.lang.Throwable -> L2a
        L2a:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            throw r1     // Catch: java.nio.channels.CancelledKeyException -> L2d java.lang.Throwable -> L68
        L2d:
            r0 = move-exception
            java.nio.channels.ClosedChannelException r0 = new java.nio.channels.ClosedChannelException
            r0.<init>()
            r10.setFailure(r0)
            org.jboss.netty.channel.Channels.fireExceptionCaught(r9, r0)
            goto L15
        L3a:
            int r4 = r9.getRawInterestOps()     // Catch: java.lang.Throwable -> L2a
            if (r4 == r3) goto Lb2
            r2.interestOps(r3)     // Catch: java.lang.Throwable -> L2a
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2a
            java.lang.Thread r4 = r8.thread     // Catch: java.lang.Throwable -> L2a
            if (r2 == r4) goto L58
            java.util.concurrent.atomic.AtomicBoolean r2 = r8.wakenUp     // Catch: java.lang.Throwable -> L2a
            r4 = 0
            r5 = 1
            boolean r2 = r2.compareAndSet(r4, r5)     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L58
            r1.wakeup()     // Catch: java.lang.Throwable -> L2a
        L58:
            r1 = r7
        L59:
            if (r1 == 0) goto L5e
            r9.setRawInterestOpsNow(r3)     // Catch: java.lang.Throwable -> L2a
        L5e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            r10.setSuccess()     // Catch: java.nio.channels.CancelledKeyException -> L2d java.lang.Throwable -> L68
            if (r1 == 0) goto L15
            org.jboss.netty.channel.Channels.fireChannelInterestChanged(r9)     // Catch: java.nio.channels.CancelledKeyException -> L2d java.lang.Throwable -> L68
            goto L15
        L68:
            r0 = move-exception
            r10.setFailure(r0)
            org.jboss.netty.channel.Channels.fireExceptionCaught(r9, r0)
            goto L15
        L70:
            int r4 = r9.getRawInterestOps()     // Catch: java.lang.Throwable -> L2a
            if (r4 == r3) goto Lb2
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2a
            java.lang.Thread r5 = r8.thread     // Catch: java.lang.Throwable -> L2a
            if (r4 != r5) goto L83
            r2.interestOps(r3)     // Catch: java.lang.Throwable -> L2a
            r1 = r7
            goto L59
        L83:
            java.util.concurrent.locks.ReadWriteLock r4 = r8.selectorGuard     // Catch: java.lang.Throwable -> L2a
            java.util.concurrent.locks.Lock r4 = r4.readLock()     // Catch: java.lang.Throwable -> L2a
            r4.lock()     // Catch: java.lang.Throwable -> L2a
            java.util.concurrent.atomic.AtomicBoolean r4 = r8.wakenUp     // Catch: java.lang.Throwable -> La7
            r5 = 0
            r6 = 1
            boolean r4 = r4.compareAndSet(r5, r6)     // Catch: java.lang.Throwable -> La7
            if (r4 == 0) goto L99
            r1.wakeup()     // Catch: java.lang.Throwable -> La7
        L99:
            r2.interestOps(r3)     // Catch: java.lang.Throwable -> La7
            java.util.concurrent.locks.ReadWriteLock r1 = r8.selectorGuard     // Catch: java.lang.Throwable -> L2a
            java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L2a
            r1.unlock()     // Catch: java.lang.Throwable -> L2a
            r1 = r7
            goto L59
        La7:
            r1 = move-exception
            java.util.concurrent.locks.ReadWriteLock r2 = r8.selectorGuard     // Catch: java.lang.Throwable -> L2a
            java.util.concurrent.locks.Lock r2 = r2.readLock()     // Catch: java.lang.Throwable -> L2a
            r2.unlock()     // Catch: java.lang.Throwable -> L2a
            throw r1     // Catch: java.lang.Throwable -> L2a
        Lb2:
            r1 = r5
            goto L59
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.nio.NioWorker.setInterestOps(org.jboss.netty.channel.socket.nio.NioSocketChannel, org.jboss.netty.channel.ChannelFuture, int):void");
    }

    void writeFromSelectorLoop(SelectionKey selectionKey) {
        NioSocketChannel nioSocketChannel = (NioSocketChannel) selectionKey.attachment();
        nioSocketChannel.writeSuspended = false;
        write0(nioSocketChannel);
    }

    void writeFromTaskLoop(NioSocketChannel nioSocketChannel) {
        if (nioSocketChannel.writeSuspended) {
            return;
        }
        write0(nioSocketChannel);
    }

    void writeFromUserCode(NioSocketChannel nioSocketChannel) {
        if (!nioSocketChannel.isConnected()) {
            cleanUpWriteBuffer(nioSocketChannel);
        } else {
            if (scheduleWriteIfNecessary(nioSocketChannel) || nioSocketChannel.writeSuspended || nioSocketChannel.inWriteNowLoop) {
                return;
            }
            write0(nioSocketChannel);
        }
    }
}
