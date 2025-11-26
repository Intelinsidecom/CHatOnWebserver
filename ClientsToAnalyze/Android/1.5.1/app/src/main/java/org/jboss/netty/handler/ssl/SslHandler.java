package org.jboss.netty.handler.ssl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelDownstreamHandler;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelState;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.LifeCycleAwareChannelHandler;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.codec.frame.FrameDecoder;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.internal.LinkedTransferQueue;
import org.jboss.netty.util.internal.NonReentrantLock;

/* loaded from: classes.dex */
public class SslHandler extends FrameDecoder implements ChannelDownstreamHandler, LifeCycleAwareChannelHandler {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final ByteBuffer EMPTY_BUFFER;
    private static final Pattern IGNORABLE_ERROR_MESSAGE;
    private static SslBufferPool defaultBufferPool;
    private static final InternalLogger logger;
    private final SslBufferPool bufferPool;
    private volatile ChannelHandlerContext ctx;
    private final Executor delegatedTaskExecutor;
    private volatile boolean enableRenegotiation;
    private final SSLEngine engine;
    private volatile ChannelFuture handshakeFuture;
    final Object handshakeLock;
    private volatile boolean handshaken;
    private boolean handshaking;
    int ignoreClosedChannelException;
    final Object ignoreClosedChannelExceptionLock;
    private final Queue pendingEncryptedWrites;
    private final NonReentrantLock pendingEncryptedWritesLock;
    private final Queue pendingUnencryptedWrites;
    private final AtomicBoolean sentCloseNotify;
    private final AtomicBoolean sentFirstMessage;
    private final boolean startTls;

    /* renamed from: org.jboss.netty.handler.ssl.SslHandler$3 */
    /* synthetic */ class C08053 {
        static final /* synthetic */ int[] $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus = new int[SSLEngineResult.HandshakeStatus.values().length];

        static {
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_WRAP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_UNWRAP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NEED_TASK.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $SwitchMap$org$jboss$netty$channel$ChannelState = new int[ChannelState.values().length];
            try {
                $SwitchMap$org$jboss$netty$channel$ChannelState[ChannelState.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$org$jboss$netty$channel$ChannelState[ChannelState.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$org$jboss$netty$channel$ChannelState[ChannelState.BOUND.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    final class ClosingChannelFutureListener implements ChannelFutureListener {
        private final ChannelHandlerContext context;

        /* renamed from: e */
        private final ChannelStateEvent f4583e;

        ClosingChannelFutureListener(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
            this.context = channelHandlerContext;
            this.f4583e = channelStateEvent;
        }

        @Override // org.jboss.netty.channel.ChannelFutureListener
        public void operationComplete(ChannelFuture channelFuture) {
            if (channelFuture.getCause() instanceof ClosedChannelException) {
                return;
            }
            Channels.close(this.context, this.f4583e.getFuture());
        }
    }

    final class PendingWrite {
        final ChannelFuture future;
        final ByteBuffer outAppBuf;

        PendingWrite(ChannelFuture channelFuture, ByteBuffer byteBuffer) {
            this.future = channelFuture;
            this.outAppBuf = byteBuffer;
        }
    }

    static {
        $assertionsDisabled = !SslHandler.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(SslHandler.class);
        EMPTY_BUFFER = ByteBuffer.allocate(0);
        IGNORABLE_ERROR_MESSAGE = Pattern.compile("^.*(?:connection.*reset|connection.*closed|broken.*pipe).*$", 2);
    }

    public SslHandler(SSLEngine sSLEngine) {
        this(sSLEngine, getDefaultBufferPool(), ImmediateExecutor.INSTANCE);
    }

    public SslHandler(SSLEngine sSLEngine, Executor executor) {
        this(sSLEngine, getDefaultBufferPool(), executor);
    }

    public SslHandler(SSLEngine sSLEngine, SslBufferPool sslBufferPool) {
        this(sSLEngine, sslBufferPool, ImmediateExecutor.INSTANCE);
    }

    public SslHandler(SSLEngine sSLEngine, SslBufferPool sslBufferPool, Executor executor) {
        this(sSLEngine, sslBufferPool, false, executor);
    }

    public SslHandler(SSLEngine sSLEngine, SslBufferPool sslBufferPool, boolean z) {
        this(sSLEngine, sslBufferPool, z, ImmediateExecutor.INSTANCE);
    }

    public SslHandler(SSLEngine sSLEngine, SslBufferPool sslBufferPool, boolean z, Executor executor) {
        this.handshakeLock = new Object();
        this.sentFirstMessage = new AtomicBoolean();
        this.sentCloseNotify = new AtomicBoolean();
        this.ignoreClosedChannelExceptionLock = new Object();
        this.pendingUnencryptedWrites = new LinkedList();
        this.pendingEncryptedWrites = new LinkedTransferQueue();
        this.pendingEncryptedWritesLock = new NonReentrantLock();
        if (sSLEngine == null) {
            throw new NullPointerException("engine");
        }
        if (sslBufferPool == null) {
            throw new NullPointerException("bufferPool");
        }
        if (executor == null) {
            throw new NullPointerException("delegatedTaskExecutor");
        }
        this.engine = sSLEngine;
        this.bufferPool = sslBufferPool;
        this.delegatedTaskExecutor = executor;
        this.startTls = z;
    }

    public SslHandler(SSLEngine sSLEngine, boolean z) {
        this(sSLEngine, getDefaultBufferPool(), z);
    }

    public SslHandler(SSLEngine sSLEngine, boolean z, Executor executor) {
        this(sSLEngine, getDefaultBufferPool(), z, executor);
    }

    private void closeOutboundAndChannel(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        if (!channelStateEvent.getChannel().isConnected()) {
            channelHandlerContext.sendDownstream(channelStateEvent);
            return;
        }
        unwrap(channelHandlerContext, channelStateEvent.getChannel(), ChannelBuffers.EMPTY_BUFFER, 0, 0);
        if (this.engine.isInboundDone() || !this.sentCloseNotify.compareAndSet(false, true)) {
            channelHandlerContext.sendDownstream(channelStateEvent);
        } else {
            this.engine.closeOutbound();
            wrapNonAppData(channelHandlerContext, channelStateEvent.getChannel()).addListener(new ClosingChannelFutureListener(channelHandlerContext, channelStateEvent));
        }
    }

    private void flushPendingEncryptedWrites(ChannelHandlerContext channelHandlerContext) {
        if (!this.pendingEncryptedWritesLock.tryLock()) {
            return;
        }
        while (true) {
            try {
                MessageEvent messageEvent = (MessageEvent) this.pendingEncryptedWrites.poll();
                if (messageEvent == null) {
                    return;
                } else {
                    channelHandlerContext.sendDownstream(messageEvent);
                }
            } finally {
                this.pendingEncryptedWritesLock.unlock();
            }
        }
    }

    public static synchronized SslBufferPool getDefaultBufferPool() {
        if (defaultBufferPool == null) {
            defaultBufferPool = new SslBufferPool();
        }
        return defaultBufferPool;
    }

    private void handleRenegotiation(SSLEngineResult.HandshakeStatus handshakeStatus) {
        boolean z;
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING || handshakeStatus == SSLEngineResult.HandshakeStatus.FINISHED || !this.handshaken) {
            return;
        }
        synchronized (this.handshakeLock) {
            if (this.handshaking) {
                return;
            }
            if (this.engine.isInboundDone() || this.engine.isOutboundDone()) {
                return;
            }
            if (isEnableRenegotiation()) {
                z = true;
            } else {
                z = false;
                this.handshaking = true;
            }
            if (z) {
                handshake();
            } else {
                Channels.fireExceptionCaught(this.ctx, new SSLException("renegotiation attempted by peer; closing the connection"));
                Channels.close(this.ctx, Channels.succeededFuture(this.ctx.getChannel()));
            }
        }
    }

    private void offerEncryptedWriteRequest(MessageEvent messageEvent) {
        boolean zTryLock = this.pendingEncryptedWritesLock.tryLock();
        try {
            this.pendingEncryptedWrites.offer(messageEvent);
        } finally {
            if (zTryLock) {
                this.pendingEncryptedWritesLock.unlock();
            }
        }
    }

    private void runDelegatedTasks() {
        final Runnable delegatedTask;
        while (true) {
            synchronized (this.handshakeLock) {
                delegatedTask = this.engine.getDelegatedTask();
            }
            if (delegatedTask == null) {
                return;
            } else {
                this.delegatedTaskExecutor.execute(new Runnable() { // from class: org.jboss.netty.handler.ssl.SslHandler.2
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SslHandler.this.handshakeLock) {
                            delegatedTask.run();
                        }
                    }
                });
            }
        }
    }

    private void setHandshakeFailure(Channel channel, SSLException sSLException) {
        synchronized (this.handshakeLock) {
            if (this.handshaking) {
                this.handshaking = false;
                this.handshaken = false;
                if (this.handshakeFuture == null) {
                    this.handshakeFuture = Channels.future(channel);
                }
                this.handshakeFuture.setFailure(sSLException);
            }
        }
    }

    private void setHandshakeSuccess(Channel channel) {
        synchronized (this.handshakeLock) {
            this.handshaking = false;
            this.handshaken = true;
            if (this.handshakeFuture == null) {
                this.handshakeFuture = Channels.future(channel);
            }
        }
        this.handshakeFuture.setSuccess();
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ca, code lost:
    
        r0 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.jboss.netty.buffer.ChannelBuffer unwrap(org.jboss.netty.channel.ChannelHandlerContext r9, org.jboss.netty.channel.Channel r10, org.jboss.netty.buffer.ChannelBuffer r11, int r12, int r13) {
        /*
            r8 = this;
            r7 = 1
            r6 = 0
            java.nio.ByteBuffer r0 = r11.toByteBuffer(r12, r13)
            org.jboss.netty.handler.ssl.SslBufferPool r1 = r8.bufferPool
            java.nio.ByteBuffer r1 = r1.acquire()
        Lc:
            java.lang.Object r2 = r8.handshakeLock     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            monitor-enter(r2)     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            boolean r3 = r8.handshaken     // Catch: java.lang.Throwable -> L63
            if (r3 != 0) goto L32
            boolean r3 = r8.handshaking     // Catch: java.lang.Throwable -> L63
            if (r3 != 0) goto L32
            javax.net.ssl.SSLEngine r3 = r8.engine     // Catch: java.lang.Throwable -> L63
            boolean r3 = r3.getUseClientMode()     // Catch: java.lang.Throwable -> L63
            if (r3 != 0) goto L32
            javax.net.ssl.SSLEngine r3 = r8.engine     // Catch: java.lang.Throwable -> L63
            boolean r3 = r3.isInboundDone()     // Catch: java.lang.Throwable -> L63
            if (r3 != 0) goto L32
            javax.net.ssl.SSLEngine r3 = r8.engine     // Catch: java.lang.Throwable -> L63
            boolean r3 = r3.isOutboundDone()     // Catch: java.lang.Throwable -> L63
            if (r3 != 0) goto L32
            r8.handshake()     // Catch: java.lang.Throwable -> L63
        L32:
            javax.net.ssl.SSLEngine r3 = r8.engine     // Catch: java.lang.Throwable -> L63 javax.net.ssl.SSLException -> L72
            javax.net.ssl.SSLEngineResult r3 = r3.unwrap(r0, r1)     // Catch: java.lang.Throwable -> L63 javax.net.ssl.SSLException -> L72
            javax.net.ssl.SSLEngineResult$HandshakeStatus r3 = r3.getHandshakeStatus()     // Catch: java.lang.Throwable -> L63
            r8.handleRenegotiation(r3)     // Catch: java.lang.Throwable -> L63
            int[] r4 = org.jboss.netty.handler.ssl.SslHandler.C08053.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus     // Catch: java.lang.Throwable -> L63
            int r5 = r3.ordinal()     // Catch: java.lang.Throwable -> L63
            r4 = r4[r5]     // Catch: java.lang.Throwable -> L63
            switch(r4) {
                case 1: goto Lbe;
                case 2: goto L74;
                case 3: goto Lc2;
                case 4: goto Lc6;
                case 5: goto Lcc;
                default: goto L4a;
            }     // Catch: java.lang.Throwable -> L63
        L4a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L63
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L63
            r4.<init>()     // Catch: java.lang.Throwable -> L63
            java.lang.String r5 = "Unknown handshake status: "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L63
            java.lang.StringBuilder r3 = r4.append(r3)     // Catch: java.lang.Throwable -> L63
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L63
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L63
            throw r0     // Catch: java.lang.Throwable -> L63
        L63:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L63
            throw r0     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
        L66:
            r0 = move-exception
            r8.setHandshakeFailure(r10, r0)     // Catch: java.lang.Throwable -> L6b
            throw r0     // Catch: java.lang.Throwable -> L6b
        L6b:
            r0 = move-exception
            org.jboss.netty.handler.ssl.SslBufferPool r2 = r8.bufferPool
            r2.release(r1)
            throw r0
        L72:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L63
        L74:
            boolean r3 = r0.hasRemaining()     // Catch: java.lang.Throwable -> L63
            if (r3 == 0) goto L84
            javax.net.ssl.SSLEngine r3 = r8.engine     // Catch: java.lang.Throwable -> L63
            boolean r3 = r3.isInboundDone()     // Catch: java.lang.Throwable -> L63
            if (r3 != 0) goto L84
        L82:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L63
            goto Lc
        L84:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L63
            r0 = r6
        L86:
            if (r0 == 0) goto L9b
            java.lang.Object r0 = r8.handshakeLock     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            boolean r0 = java.lang.Thread.holdsLock(r0)     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            if (r0 != 0) goto L9b
            org.jboss.netty.util.internal.NonReentrantLock r0 = r8.pendingEncryptedWritesLock     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            boolean r0 = r0.isHeldByCurrentThread()     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            if (r0 != 0) goto L9b
            r8.wrap(r9, r10)     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
        L9b:
            r1.flip()     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            boolean r0 = r1.hasRemaining()     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            if (r0 == 0) goto Lcf
            int r0 = r1.remaining()     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            org.jboss.netty.buffer.ChannelBuffer r0 = org.jboss.netty.buffer.ChannelBuffers.buffer(r0)     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            byte[] r2 = r1.array()     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            r3 = 0
            int r4 = r0.capacity()     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            r0.writeBytes(r2, r3, r4)     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            org.jboss.netty.handler.ssl.SslBufferPool r2 = r8.bufferPool
            r2.release(r1)
        Lbd:
            return r0
        Lbe:
            r8.wrapNonAppData(r9, r10)     // Catch: java.lang.Throwable -> L63
            goto L82
        Lc2:
            r8.runDelegatedTasks()     // Catch: java.lang.Throwable -> L63
            goto L82
        Lc6:
            r8.setHandshakeSuccess(r10)     // Catch: java.lang.Throwable -> L63
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L63
            r0 = r7
            goto L86
        Lcc:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L63
            r0 = r7
            goto L86
        Lcf:
            r0 = 0
            org.jboss.netty.handler.ssl.SslBufferPool r2 = r8.bufferPool
            r2.release(r1)
            goto Lbd
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.ssl.SslHandler.unwrap(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.Channel, org.jboss.netty.buffer.ChannelBuffer, int, int):org.jboss.netty.buffer.ChannelBuffer");
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0136, code lost:
    
        r3 = false;
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x013b, code lost:
    
        r3 = true;
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0157, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.jboss.netty.channel.ChannelFuture wrap(org.jboss.netty.channel.ChannelHandlerContext r13, org.jboss.netty.channel.Channel r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.ssl.SslHandler.wrap(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.Channel):org.jboss.netty.channel.ChannelFuture");
    }

    private ChannelFuture wrapNonAppData(ChannelHandlerContext channelHandlerContext, Channel channel) {
        SSLEngineResult sSLEngineResultWrap;
        ChannelFuture channelFuture;
        ChannelFuture channelFuture2 = null;
        ByteBuffer byteBufferAcquire = this.bufferPool.acquire();
        while (true) {
            try {
                try {
                    synchronized (this.handshakeLock) {
                        sSLEngineResultWrap = this.engine.wrap(EMPTY_BUFFER, byteBufferAcquire);
                    }
                    if (sSLEngineResultWrap.bytesProduced() > 0) {
                        byteBufferAcquire.flip();
                        ChannelBuffer channelBufferBuffer = ChannelBuffers.buffer(byteBufferAcquire.remaining());
                        channelBufferBuffer.writeBytes(byteBufferAcquire.array(), 0, channelBufferBuffer.capacity());
                        byteBufferAcquire.clear();
                        ChannelFuture channelFutureFuture = Channels.future(channel);
                        channelFutureFuture.addListener(new ChannelFutureListener() { // from class: org.jboss.netty.handler.ssl.SslHandler.1
                            @Override // org.jboss.netty.channel.ChannelFutureListener
                            public void operationComplete(ChannelFuture channelFuture3) {
                                if (channelFuture3.getCause() instanceof ClosedChannelException) {
                                    synchronized (SslHandler.this.ignoreClosedChannelExceptionLock) {
                                        SslHandler.this.ignoreClosedChannelException++;
                                    }
                                }
                            }
                        });
                        Channels.write(channelHandlerContext, channelFutureFuture, channelBufferBuffer);
                        channelFuture = channelFutureFuture;
                    } else {
                        channelFuture = channelFuture2;
                    }
                    SSLEngineResult.HandshakeStatus handshakeStatus = sSLEngineResultWrap.getHandshakeStatus();
                    handleRenegotiation(handshakeStatus);
                    switch (C08053.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[handshakeStatus.ordinal()]) {
                        case 1:
                        case 5:
                            break;
                        case 2:
                            if (!Thread.holdsLock(this.handshakeLock)) {
                                unwrap(channelHandlerContext, channel, ChannelBuffers.EMPTY_BUFFER, 0, 0);
                                break;
                            }
                            break;
                        case 3:
                            runDelegatedTasks();
                            break;
                        case 4:
                            setHandshakeSuccess(channel);
                            runDelegatedTasks();
                            break;
                        default:
                            throw new IllegalStateException("Unexpected handshake status: " + handshakeStatus);
                    }
                    if (sSLEngineResultWrap.bytesProduced() == 0) {
                        return channelFuture == null ? Channels.succeededFuture(channel) : channelFuture;
                    }
                    channelFuture2 = channelFuture;
                } catch (SSLException e) {
                    setHandshakeFailure(channel, e);
                    throw e;
                }
            } finally {
                this.bufferPool.release(byteBufferAcquire);
            }
        }
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void afterAdd(ChannelHandlerContext channelHandlerContext) {
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void afterRemove(ChannelHandlerContext channelHandlerContext) {
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void beforeAdd(ChannelHandlerContext channelHandlerContext) {
        this.ctx = channelHandlerContext;
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void beforeRemove(ChannelHandlerContext channelHandlerContext) {
    }

    @Override // org.jboss.netty.handler.codec.frame.FrameDecoder, org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void channelDisconnected(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) throws SSLException {
        synchronized (this.handshakeLock) {
            if (this.handshaking) {
                this.handshakeFuture.setFailure(new ClosedChannelException());
            }
        }
        try {
            super.channelDisconnected(channelHandlerContext, channelStateEvent);
            unwrap(channelHandlerContext, channelStateEvent.getChannel(), ChannelBuffers.EMPTY_BUFFER, 0, 0);
            this.engine.closeOutbound();
            if (this.sentCloseNotify.get() || !this.handshaken) {
                return;
            }
            try {
                this.engine.closeInbound();
            } catch (SSLException e) {
                logger.debug("Failed to clean up SSLEngine.", e);
            }
        } catch (Throwable th) {
            unwrap(channelHandlerContext, channelStateEvent.getChannel(), ChannelBuffers.EMPTY_BUFFER, 0, 0);
            this.engine.closeOutbound();
            if (!this.sentCloseNotify.get() && this.handshaken) {
                try {
                    this.engine.closeInbound();
                } catch (SSLException e2) {
                    logger.debug("Failed to clean up SSLEngine.", e2);
                }
            }
            throw th;
        }
    }

    public ChannelFuture close() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        Channel channel = channelHandlerContext.getChannel();
        try {
            this.engine.closeOutbound();
            return wrapNonAppData(channelHandlerContext, channel);
        } catch (SSLException e) {
            return Channels.failedFuture(channel, e);
        }
    }

    @Deprecated
    public ChannelFuture close(Channel channel) {
        return close();
    }

    @Override // org.jboss.netty.handler.codec.frame.FrameDecoder
    protected Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer) throws SSLException {
        boolean z;
        int i;
        boolean z2;
        if (channelBuffer.readableBytes() < 5) {
            return null;
        }
        switch (channelBuffer.getUnsignedByte(channelBuffer.readerIndex())) {
            case 20:
            case 21:
            case 22:
            case 23:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            short unsignedByte = channelBuffer.getUnsignedByte(channelBuffer.readerIndex() + 1);
            if (unsignedByte < 3 || unsignedByte >= 10) {
                z = false;
                i = 0;
            } else {
                i = (channelBuffer.getShort(channelBuffer.readerIndex() + 3) & 65535) + 5;
                if (i <= 5) {
                    z = false;
                }
            }
        } else {
            i = 0;
        }
        if (!z) {
            int i2 = (channelBuffer.getUnsignedByte(channelBuffer.readerIndex()) & 128) != 0 ? 2 : 3;
            short unsignedByte2 = channelBuffer.getUnsignedByte(channelBuffer.readerIndex() + i2 + 1);
            if (unsignedByte2 < 2 || unsignedByte2 >= 10) {
                z2 = false;
            } else {
                i = i2 == 2 ? (channelBuffer.getShort(channelBuffer.readerIndex()) & Short.MAX_VALUE) + 2 : (channelBuffer.getShort(channelBuffer.readerIndex()) & 16383) + 3;
                z2 = i > i2;
            }
            if (!z2) {
                SSLException sSLException = new SSLException("not an SSL/TLS record: " + ChannelBuffers.hexDump(channelBuffer));
                channelBuffer.skipBytes(channelBuffer.readableBytes());
                throw sSLException;
            }
        }
        int i3 = i;
        if (!$assertionsDisabled && i3 <= 0) {
            throw new AssertionError();
        }
        if (channelBuffer.readableBytes() < i3) {
            return null;
        }
        int i4 = channelBuffer.readerIndex();
        channelBuffer.skipBytes(i3);
        return unwrap(channelHandlerContext, channel, channelBuffer, i4, i3);
    }

    @Override // org.jboss.netty.handler.codec.frame.FrameDecoder, org.jboss.netty.channel.SimpleChannelUpstreamHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, ExceptionEvent exceptionEvent) {
        Throwable cause = exceptionEvent.getCause();
        if (cause instanceof IOException) {
            if (cause instanceof ClosedChannelException) {
                synchronized (this.ignoreClosedChannelExceptionLock) {
                    if (this.ignoreClosedChannelException > 0) {
                        this.ignoreClosedChannelException--;
                        logger.debug("Swallowing an exception raised while writing non-app data", cause);
                        return;
                    }
                }
            } else if (this.engine.isOutboundDone()) {
                if (IGNORABLE_ERROR_MESSAGE.matcher(String.valueOf(cause.getMessage()).toLowerCase()).matches()) {
                    logger.debug("Swallowing a 'connection reset by peer / broken pipe' error occurred while writing 'closure_notify'", cause);
                    Channels.close(channelHandlerContext, Channels.succeededFuture(exceptionEvent.getChannel()));
                    return;
                }
            }
        }
        channelHandlerContext.sendUpstream(exceptionEvent);
    }

    public SSLEngine getEngine() {
        return this.engine;
    }

    @Override // org.jboss.netty.channel.ChannelDownstreamHandler
    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) throws Throwable {
        if (channelEvent instanceof ChannelStateEvent) {
            ChannelStateEvent channelStateEvent = (ChannelStateEvent) channelEvent;
            switch (channelStateEvent.getState()) {
                case OPEN:
                case CONNECTED:
                case BOUND:
                    if (Boolean.FALSE.equals(channelStateEvent.getValue()) || channelStateEvent.getValue() == null) {
                        closeOutboundAndChannel(channelHandlerContext, channelStateEvent);
                        return;
                    }
                    break;
            }
        }
        if (!(channelEvent instanceof MessageEvent)) {
            channelHandlerContext.sendDownstream(channelEvent);
            return;
        }
        MessageEvent messageEvent = (MessageEvent) channelEvent;
        if (!(messageEvent.getMessage() instanceof ChannelBuffer)) {
            channelHandlerContext.sendDownstream(channelEvent);
            return;
        }
        if (this.startTls && this.sentFirstMessage.compareAndSet(false, true)) {
            channelHandlerContext.sendDownstream(channelEvent);
            return;
        }
        ChannelBuffer channelBuffer = (ChannelBuffer) messageEvent.getMessage();
        PendingWrite pendingWrite = channelBuffer.readable() ? new PendingWrite(channelEvent.getFuture(), channelBuffer.toByteBuffer(channelBuffer.readerIndex(), channelBuffer.readableBytes())) : new PendingWrite(channelEvent.getFuture(), null);
        synchronized (this.pendingUnencryptedWrites) {
            boolean zOffer = this.pendingUnencryptedWrites.offer(pendingWrite);
            if (!$assertionsDisabled && !zOffer) {
                throw new AssertionError();
            }
        }
        wrap(channelHandlerContext, channelEvent.getChannel());
    }

    public ChannelFuture handshake() {
        ChannelFuture channelFutureFailedFuture;
        if (this.handshaken && !isEnableRenegotiation()) {
            throw new IllegalStateException("renegotiation disabled");
        }
        ChannelHandlerContext channelHandlerContext = this.ctx;
        Channel channel = channelHandlerContext.getChannel();
        synchronized (this.handshakeLock) {
            if (this.handshaking) {
                return this.handshakeFuture;
            }
            this.handshaking = true;
            try {
                this.engine.beginHandshake();
                runDelegatedTasks();
                channelFutureFailedFuture = Channels.future(channel);
                this.handshakeFuture = channelFutureFailedFuture;
            } catch (SSLException e) {
                channelFutureFailedFuture = Channels.failedFuture(channel, e);
                this.handshakeFuture = channelFutureFailedFuture;
            }
            try {
                wrapNonAppData(channelHandlerContext, channel);
            } catch (SSLException e2) {
                channelFutureFailedFuture.setFailure(e2);
            }
            return channelFutureFailedFuture;
        }
    }

    @Deprecated
    public ChannelFuture handshake(Channel channel) {
        return handshake();
    }

    public boolean isEnableRenegotiation() {
        return this.enableRenegotiation;
    }

    public void setEnableRenegotiation(boolean z) {
        this.enableRenegotiation = z;
    }
}
