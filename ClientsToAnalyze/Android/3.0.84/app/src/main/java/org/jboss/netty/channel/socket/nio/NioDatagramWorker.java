package org.jboss.netty.channel.socket.nio;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
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
import org.jboss.netty.channel.socket.nio.SocketSendBufferPool;
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
    private final int f13691id;
    volatile Selector selector;
    private boolean started;
    private volatile Thread thread;
    private final AtomicBoolean wakenUp = new AtomicBoolean();
    private final ReadWriteLock selectorGuard = new ReentrantReadWriteLock();
    private final Object startStopLock = new Object();
    private final Queue<Runnable> registerTaskQueue = new LinkedTransferQueue();
    private final Queue<Runnable> writeTaskQueue = new LinkedTransferQueue();
    private final SocketSendBufferPool sendBufferPool = new SocketSendBufferPool();

    static {
        $assertionsDisabled = !NioDatagramWorker.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance((Class<?>) NioDatagramWorker.class);
    }

    NioDatagramWorker(int i, int i2, Executor executor) {
        this.bossId = i;
        this.f13691id = i2;
        this.executor = executor;
    }

    void register(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture) {
        Selector selectorOpen;
        ChannelRegistionTask channelRegistionTask = new ChannelRegistionTask(nioDatagramChannel, channelFuture);
        synchronized (this.startStopLock) {
            if (!this.started) {
                try {
                    selectorOpen = Selector.open();
                    this.selector = selectorOpen;
                    try {
                        this.executor.execute(new ThreadRenamingRunnable(this, "New I/O datagram worker #" + this.bossId + "'-'" + this.f13691id));
                    } finally {
                    }
                } catch (Throwable th) {
                    throw new ChannelException("Failed to create a selector.", th);
                }
            } else {
                selectorOpen = this.selector;
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
        this.thread = Thread.currentThread();
        Selector selector = this.selector;
        boolean z2 = false;
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
        selectionKey.cancel();
        close(nioDatagramChannel, Channels.succeededFuture(nioDatagramChannel));
        return false;
    }

    private void close(SelectionKey selectionKey) {
        NioDatagramChannel nioDatagramChannel = (NioDatagramChannel) selectionKey.attachment();
        close(nioDatagramChannel, Channels.succeededFuture(nioDatagramChannel));
    }

    void writeFromUserCode(NioDatagramChannel nioDatagramChannel) {
        if (!nioDatagramChannel.isBound()) {
            cleanUpWriteBuffer(nioDatagramChannel);
        } else if (!scheduleWriteIfNecessary(nioDatagramChannel) && !nioDatagramChannel.writeSuspended && !nioDatagramChannel.inWriteNowLoop) {
            write0(nioDatagramChannel);
        }
    }

    void writeFromTaskLoop(NioDatagramChannel nioDatagramChannel) {
        if (!nioDatagramChannel.writeSuspended) {
            write0(nioDatagramChannel);
        }
    }

    void writeFromSelectorLoop(SelectionKey selectionKey) {
        NioDatagramChannel nioDatagramChannel = (NioDatagramChannel) selectionKey.attachment();
        nioDatagramChannel.writeSuspended = false;
        write0(nioDatagramChannel);
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

    private void write0(NioDatagramChannel nioDatagramChannel) {
        SocketSendBufferPool.SendBuffer sendBufferAcquire;
        boolean z;
        long j;
        Throwable th;
        boolean z2;
        SocketSendBufferPool.SendBuffer sendBuffer;
        MessageEvent messageEvent;
        long j2;
        boolean z3 = false;
        long j3 = 0;
        SocketSendBufferPool socketSendBufferPool = this.sendBufferPool;
        DatagramChannel datagramChannel = nioDatagramChannel.getDatagramChannel();
        Queue<MessageEvent> queue = nioDatagramChannel.writeBufferQueue;
        int writeSpinCount = nioDatagramChannel.getConfig().getWriteSpinCount();
        synchronized (nioDatagramChannel.writeLock) {
            nioDatagramChannel.inWriteNowLoop = true;
            while (true) {
                MessageEvent messageEvent2 = nioDatagramChannel.currentWriteEvent;
                if (messageEvent2 == null) {
                    MessageEvent messageEventPoll = queue.poll();
                    nioDatagramChannel.currentWriteEvent = messageEventPoll;
                    if (messageEventPoll == null) {
                        z = true;
                        nioDatagramChannel.writeSuspended = false;
                        break;
                    } else {
                        sendBufferAcquire = socketSendBufferPool.acquire(messageEventPoll.getMessage());
                        nioDatagramChannel.currentWriteBuffer = sendBufferAcquire;
                        messageEvent2 = messageEventPoll;
                    }
                } else {
                    sendBufferAcquire = nioDatagramChannel.currentWriteBuffer;
                }
                long jTransferTo = 0;
                try {
                    SocketAddress remoteAddress = messageEvent2.getRemoteAddress();
                    if (remoteAddress != null) {
                        int i = writeSpinCount;
                        while (true) {
                            if (i <= 0) {
                                long j4 = jTransferTo;
                                j = j3;
                                j2 = j4;
                                break;
                            }
                            jTransferTo = sendBufferAcquire.transferTo(datagramChannel, remoteAddress);
                            if (jTransferTo != 0) {
                                j = j3 + jTransferTo;
                                j2 = jTransferTo;
                                break;
                            } else {
                                if (sendBufferAcquire.finished()) {
                                    j = j3;
                                    j2 = jTransferTo;
                                    break;
                                }
                                i--;
                            }
                        }
                    } else {
                        int i2 = writeSpinCount;
                        while (true) {
                            if (i2 <= 0) {
                                break;
                            }
                            jTransferTo = sendBufferAcquire.transferTo(datagramChannel);
                            if (jTransferTo != 0) {
                                j3 += jTransferTo;
                                break;
                            } else if (sendBufferAcquire.finished()) {
                                break;
                            } else {
                                i2--;
                            }
                        }
                        long j5 = jTransferTo;
                        j = j3;
                        j2 = j5;
                    }
                    if (j2 <= 0) {
                        try {
                            try {
                                if (!sendBufferAcquire.finished()) {
                                    z3 = true;
                                    nioDatagramChannel.writeSuspended = true;
                                    j3 = j;
                                    z = false;
                                    break;
                                }
                                sendBufferAcquire.release();
                                ChannelFuture future = messageEvent2.getFuture();
                                nioDatagramChannel.currentWriteEvent = null;
                                nioDatagramChannel.currentWriteBuffer = null;
                                messageEvent = null;
                                try {
                                    future.setSuccess();
                                    z2 = z3;
                                } catch (Throwable th2) {
                                    z2 = z3;
                                    sendBuffer = null;
                                    th = th2;
                                    sendBuffer.release();
                                    ChannelFuture future2 = messageEvent.getFuture();
                                    nioDatagramChannel.currentWriteEvent = null;
                                    nioDatagramChannel.currentWriteBuffer = null;
                                    future2.setFailure(th);
                                    Channels.fireExceptionCaught(nioDatagramChannel, th);
                                    z3 = z2;
                                    j3 = j;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                z2 = z3;
                                sendBuffer = sendBufferAcquire;
                                messageEvent = messageEvent2;
                                sendBuffer.release();
                                ChannelFuture future22 = messageEvent.getFuture();
                                nioDatagramChannel.currentWriteEvent = null;
                                nioDatagramChannel.currentWriteBuffer = null;
                                future22.setFailure(th);
                                Channels.fireExceptionCaught(nioDatagramChannel, th);
                                z3 = z2;
                                j3 = j;
                            }
                        } catch (AsynchronousCloseException e) {
                            z2 = z3;
                        }
                    } else {
                        sendBufferAcquire.release();
                        ChannelFuture future3 = messageEvent2.getFuture();
                        nioDatagramChannel.currentWriteEvent = null;
                        nioDatagramChannel.currentWriteBuffer = null;
                        messageEvent = null;
                        future3.setSuccess();
                        z2 = z3;
                    }
                } catch (AsynchronousCloseException e2) {
                    j = j3;
                    z2 = z3;
                } catch (Throwable th4) {
                    j = j3;
                    th = th4;
                    z2 = z3;
                    sendBuffer = sendBufferAcquire;
                    messageEvent = messageEvent2;
                }
                z3 = z2;
                j3 = j;
            }
            nioDatagramChannel.inWriteNowLoop = false;
            if (z3) {
                setOpWrite(nioDatagramChannel);
            } else if (z) {
                clearOpWrite(nioDatagramChannel);
            }
        }
        Channels.fireWriteComplete(nioDatagramChannel, j3);
    }

    private void setOpWrite(NioDatagramChannel nioDatagramChannel) {
        SelectionKey selectionKeyKeyFor = nioDatagramChannel.getDatagramChannel().keyFor(this.selector);
        if (selectionKeyKeyFor != null) {
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
    }

    private void clearOpWrite(NioDatagramChannel nioDatagramChannel) {
        SelectionKey selectionKeyKeyFor = nioDatagramChannel.getDatagramChannel().keyFor(this.selector);
        if (selectionKeyKeyFor != null) {
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

    void close(NioDatagramChannel nioDatagramChannel, ChannelFuture channelFuture) {
        boolean zIsConnected = nioDatagramChannel.isConnected();
        boolean zIsBound = nioDatagramChannel.isBound();
        try {
            nioDatagramChannel.getDatagramChannel().close();
            this.cancelledKeys++;
            if (nioDatagramChannel.setClosed()) {
                channelFuture.setSuccess();
                if (zIsConnected) {
                    Channels.fireChannelDisconnected(nioDatagramChannel);
                }
                if (zIsBound) {
                    Channels.fireChannelUnbound(nioDatagramChannel);
                }
                cleanUpWriteBuffer(nioDatagramChannel);
                Channels.fireChannelClosed(nioDatagramChannel);
                return;
            }
            channelFuture.setSuccess();
        } catch (Throwable th) {
            channelFuture.setFailure(th);
            Channels.fireExceptionCaught(nioDatagramChannel, th);
        }
    }

    private void cleanUpWriteBuffer(NioDatagramChannel nioDatagramChannel) {
        Throwable closedChannelException;
        boolean z;
        Throwable closedChannelException2 = null;
        boolean z2 = false;
        synchronized (nioDatagramChannel.writeLock) {
            MessageEvent messageEvent = nioDatagramChannel.currentWriteEvent;
            if (messageEvent != null) {
                if (nioDatagramChannel.isOpen()) {
                    closedChannelException2 = new NotYetBoundException();
                } else {
                    closedChannelException2 = new ClosedChannelException();
                }
                ChannelFuture future = messageEvent.getFuture();
                nioDatagramChannel.currentWriteBuffer.release();
                nioDatagramChannel.currentWriteBuffer = null;
                nioDatagramChannel.currentWriteEvent = null;
                future.setFailure(closedChannelException2);
                z2 = true;
            }
            Queue<MessageEvent> queue = nioDatagramChannel.writeBufferQueue;
            if (!queue.isEmpty()) {
                if (closedChannelException2 != null) {
                    closedChannelException = closedChannelException2;
                    z = z2;
                } else if (nioDatagramChannel.isOpen()) {
                    closedChannelException = new NotYetBoundException();
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
            Channels.fireExceptionCaught(nioDatagramChannel, closedChannelException2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005c A[Catch: all -> 0x002c, TryCatch #2 {, blocks: (B:5:0x0005, B:11:0x0018, B:12:0x0023, B:13:0x0026, B:14:0x002b, B:20:0x003c, B:22:0x0042, B:24:0x004d, B:26:0x0057, B:28:0x005c, B:29:0x005f, B:36:0x0071, B:38:0x0077, B:40:0x007f, B:41:0x0083, B:46:0x009c, B:48:0x00a7, B:49:0x00b0, B:8:0x0013, B:9:0x0016, B:42:0x008c, B:44:0x0096, B:45:0x0099), top: B:53:0x0005, outer: #4, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065 A[Catch: CancelledKeyException -> 0x002f, Throwable -> 0x0069, TRY_LEAVE, TryCatch #4 {CancelledKeyException -> 0x002f, Throwable -> 0x0069, blocks: (B:3:0x0002, B:4:0x0004, B:30:0x0060, B:32:0x0065, B:17:0x002e, B:5:0x0005, B:11:0x0018, B:12:0x0023, B:13:0x0026, B:14:0x002b, B:20:0x003c, B:22:0x0042, B:24:0x004d, B:26:0x0057, B:28:0x005c, B:29:0x005f, B:36:0x0071, B:38:0x0077, B:40:0x007f, B:41:0x0083, B:46:0x009c, B:48:0x00a7, B:49:0x00b0, B:8:0x0013, B:9:0x0016, B:42:0x008c, B:44:0x0096, B:45:0x0099), top: B:54:0x0002, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void setInterestOps(org.jboss.netty.channel.socket.nio.NioDatagramChannel r9, org.jboss.netty.channel.ChannelFuture r10, int r11) {
        /*
            r8 = this;
            r1 = 0
            r0 = 1
            java.lang.Object r2 = r9.interestOpsLock     // Catch: java.nio.channels.CancelledKeyException -> L2f java.lang.Throwable -> L69
            monitor-enter(r2)     // Catch: java.nio.channels.CancelledKeyException -> L2f java.lang.Throwable -> L69
            java.nio.channels.Selector r3 = r8.selector     // Catch: java.lang.Throwable -> L2c
            java.nio.channels.DatagramChannel r4 = r9.getDatagramChannel()     // Catch: java.lang.Throwable -> L2c
            java.nio.channels.SelectionKey r4 = r4.keyFor(r3)     // Catch: java.lang.Throwable -> L2c
            if (r4 == 0) goto L13
            if (r3 != 0) goto L18
        L13:
            r9.setRawInterestOpsNow(r11)     // Catch: java.lang.Throwable -> L2c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2c
        L17:
            return
        L18:
            r5 = r11 & (-5)
            int r6 = r9.getRawInterestOps()     // Catch: java.lang.Throwable -> L2c
            r6 = r6 & 4
            r5 = r5 | r6
            int r6 = org.jboss.netty.channel.socket.nio.NioProviderMetadata.CONSTRAINT_LEVEL     // Catch: java.lang.Throwable -> L2c
            switch(r6) {
                case 0: goto L3c;
                case 1: goto L71;
                case 2: goto L71;
                default: goto L26;
            }     // Catch: java.lang.Throwable -> L2c
        L26:
            java.lang.Error r0 = new java.lang.Error     // Catch: java.lang.Throwable -> L2c
            r0.<init>()     // Catch: java.lang.Throwable -> L2c
            throw r0     // Catch: java.lang.Throwable -> L2c
        L2c:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2c
            throw r0     // Catch: java.nio.channels.CancelledKeyException -> L2f java.lang.Throwable -> L69
        L2f:
            r0 = move-exception
            java.nio.channels.ClosedChannelException r0 = new java.nio.channels.ClosedChannelException
            r0.<init>()
            r10.setFailure(r0)
            org.jboss.netty.channel.Channels.fireExceptionCaught(r9, r0)
            goto L17
        L3c:
            int r6 = r9.getRawInterestOps()     // Catch: java.lang.Throwable -> L2c
            if (r6 == r5) goto Lb1
            r4.interestOps(r5)     // Catch: java.lang.Throwable -> L2c
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2c
            java.lang.Thread r4 = r8.thread     // Catch: java.lang.Throwable -> L2c
            if (r1 == r4) goto L5a
            java.util.concurrent.atomic.AtomicBoolean r1 = r8.wakenUp     // Catch: java.lang.Throwable -> L2c
            r4 = 0
            r6 = 1
            boolean r1 = r1.compareAndSet(r4, r6)     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L5a
            r3.wakeup()     // Catch: java.lang.Throwable -> L2c
        L5a:
            if (r0 == 0) goto L5f
            r9.setRawInterestOpsNow(r5)     // Catch: java.lang.Throwable -> L2c
        L5f:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2c
            r10.setSuccess()     // Catch: java.nio.channels.CancelledKeyException -> L2f java.lang.Throwable -> L69
            if (r0 == 0) goto L17
            org.jboss.netty.channel.Channels.fireChannelInterestChanged(r9)     // Catch: java.nio.channels.CancelledKeyException -> L2f java.lang.Throwable -> L69
            goto L17
        L69:
            r0 = move-exception
            r10.setFailure(r0)
            org.jboss.netty.channel.Channels.fireExceptionCaught(r9, r0)
            goto L17
        L71:
            int r6 = r9.getRawInterestOps()     // Catch: java.lang.Throwable -> L2c
            if (r6 == r5) goto Lb1
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L2c
            java.lang.Thread r6 = r8.thread     // Catch: java.lang.Throwable -> L2c
            if (r1 != r6) goto L83
            r4.interestOps(r5)     // Catch: java.lang.Throwable -> L2c
            goto L5a
        L83:
            java.util.concurrent.locks.ReadWriteLock r1 = r8.selectorGuard     // Catch: java.lang.Throwable -> L2c
            java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L2c
            r1.lock()     // Catch: java.lang.Throwable -> L2c
            java.util.concurrent.atomic.AtomicBoolean r1 = r8.wakenUp     // Catch: java.lang.Throwable -> La6
            r6 = 0
            r7 = 1
            boolean r1 = r1.compareAndSet(r6, r7)     // Catch: java.lang.Throwable -> La6
            if (r1 == 0) goto L99
            r3.wakeup()     // Catch: java.lang.Throwable -> La6
        L99:
            r4.interestOps(r5)     // Catch: java.lang.Throwable -> La6
            java.util.concurrent.locks.ReadWriteLock r1 = r8.selectorGuard     // Catch: java.lang.Throwable -> L2c
            java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L2c
            r1.unlock()     // Catch: java.lang.Throwable -> L2c
            goto L5a
        La6:
            r0 = move-exception
            java.util.concurrent.locks.ReadWriteLock r1 = r8.selectorGuard     // Catch: java.lang.Throwable -> L2c
            java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L2c
            r1.unlock()     // Catch: java.lang.Throwable -> L2c
            throw r0     // Catch: java.lang.Throwable -> L2c
        Lb1:
            r0 = r1
            goto L5a
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.channel.socket.nio.NioDatagramWorker.setInterestOps(org.jboss.netty.channel.socket.nio.NioDatagramChannel, org.jboss.netty.channel.ChannelFuture, int):void");
    }

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
}
