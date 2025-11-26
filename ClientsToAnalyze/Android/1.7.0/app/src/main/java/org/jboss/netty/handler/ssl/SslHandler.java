package org.jboss.netty.handler.ssl;

import android.hardware.motion.MREvent;
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

    static {
        $assertionsDisabled = !SslHandler.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(SslHandler.class);
        EMPTY_BUFFER = ByteBuffer.allocate(0);
        IGNORABLE_ERROR_MESSAGE = Pattern.compile("^.*(?:connection.*reset|connection.*closed|broken.*pipe).*$", 2);
    }

    public static synchronized SslBufferPool getDefaultBufferPool() {
        if (defaultBufferPool == null) {
            defaultBufferPool = new SslBufferPool();
        }
        return defaultBufferPool;
    }

    public SslHandler(SSLEngine sSLEngine) {
        this(sSLEngine, getDefaultBufferPool(), ImmediateExecutor.INSTANCE);
    }

    public SslHandler(SSLEngine sSLEngine, SslBufferPool sslBufferPool) {
        this(sSLEngine, sslBufferPool, ImmediateExecutor.INSTANCE);
    }

    public SslHandler(SSLEngine sSLEngine, boolean z) {
        this(sSLEngine, getDefaultBufferPool(), z);
    }

    public SslHandler(SSLEngine sSLEngine, SslBufferPool sslBufferPool, boolean z) {
        this(sSLEngine, sslBufferPool, z, ImmediateExecutor.INSTANCE);
    }

    public SslHandler(SSLEngine sSLEngine, Executor executor) {
        this(sSLEngine, getDefaultBufferPool(), executor);
    }

    public SslHandler(SSLEngine sSLEngine, SslBufferPool sslBufferPool, Executor executor) {
        this(sSLEngine, sslBufferPool, false, executor);
    }

    public SslHandler(SSLEngine sSLEngine, boolean z, Executor executor) {
        this(sSLEngine, getDefaultBufferPool(), z, executor);
    }

    public SslHandler(SSLEngine sSLEngine, SslBufferPool sslBufferPool, boolean z, Executor executor) {
        this.enableRenegotiation = true;
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

    public SSLEngine getEngine() {
        return this.engine;
    }

    public ChannelFuture handshake() {
        ChannelFuture channelFuture;
        Exception exc;
        if (this.handshaken && !isEnableRenegotiation()) {
            throw new IllegalStateException("renegotiation disabled");
        }
        ChannelHandlerContext channelHandlerContext = this.ctx;
        Channel channel = channelHandlerContext.getChannel();
        synchronized (this.handshakeLock) {
            if (this.handshaking) {
                channelFuture = this.handshakeFuture;
            } else {
                this.handshaking = true;
                try {
                    this.engine.beginHandshake();
                    runDelegatedTasks();
                    ChannelFuture channelFutureFuture = Channels.future(channel);
                    this.handshakeFuture = channelFutureFuture;
                    channelFuture = channelFutureFuture;
                    exc = null;
                } catch (Exception e) {
                    ChannelFuture channelFutureFailedFuture = Channels.failedFuture(channel, e);
                    this.handshakeFuture = channelFutureFailedFuture;
                    channelFuture = channelFutureFailedFuture;
                    exc = e;
                }
                if (exc == null) {
                    try {
                        wrapNonAppData(channelHandlerContext, channel);
                    } catch (SSLException e2) {
                        Channels.fireExceptionCaught(channelHandlerContext, e2);
                        channelFuture.setFailure(e2);
                    }
                } else {
                    Channels.fireExceptionCaught(channelHandlerContext, exc);
                }
            }
        }
        return channelFuture;
    }

    @Deprecated
    public ChannelFuture handshake(Channel channel) {
        return handshake();
    }

    public ChannelFuture close() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        Channel channel = channelHandlerContext.getChannel();
        try {
            this.engine.closeOutbound();
            return wrapNonAppData(channelHandlerContext, channel);
        } catch (SSLException e) {
            Channels.fireExceptionCaught(channelHandlerContext, e);
            return Channels.failedFuture(channel, e);
        }
    }

    @Deprecated
    public ChannelFuture close(Channel channel) {
        return close();
    }

    public boolean isEnableRenegotiation() {
        return this.enableRenegotiation;
    }

    public void setEnableRenegotiation(boolean z) {
        this.enableRenegotiation = z;
    }

    @Override // org.jboss.netty.channel.ChannelDownstreamHandler
    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) throws Throwable {
        PendingWrite pendingWrite;
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
        if (channelBuffer.readable()) {
            pendingWrite = new PendingWrite(channelEvent.getFuture(), channelBuffer.toByteBuffer(channelBuffer.readerIndex(), channelBuffer.readableBytes()));
        } else {
            pendingWrite = new PendingWrite(channelEvent.getFuture(), null);
        }
        synchronized (this.pendingUnencryptedWrites) {
            boolean zOffer = this.pendingUnencryptedWrites.offer(pendingWrite);
            if (!$assertionsDisabled && !zOffer) {
                throw new AssertionError();
            }
        }
        wrap(channelHandlerContext, channelEvent.getChannel());
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
            if (!this.sentCloseNotify.get() && this.handshaken) {
                try {
                    this.engine.closeInbound();
                } catch (SSLException e) {
                    logger.debug("Failed to clean up SSLEngine.", e);
                }
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

    @Override // org.jboss.netty.handler.codec.frame.FrameDecoder
    protected Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer) throws SSLException {
        boolean z;
        int i;
        boolean z2;
        if (channelBuffer.readableBytes() < 5) {
            return null;
        }
        switch (channelBuffer.getUnsignedByte(channelBuffer.readerIndex())) {
            case MREvent.TILT_LANDSCAPE_RIGHT_LEVEL_2 /* 20 */:
            case MREvent.TILT_LANDSCAPE_LEFT_RIGHT_STOP /* 21 */:
            case MREvent.TILT_FRONT /* 22 */:
            case MREvent.TILT_BACK /* 23 */:
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
                i = (getShort(channelBuffer, channelBuffer.readerIndex() + 3) & 65535) + 5;
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
                if (i2 == 2) {
                    i = (getShort(channelBuffer, channelBuffer.readerIndex()) & Short.MAX_VALUE) + 2;
                } else {
                    i = (getShort(channelBuffer, channelBuffer.readerIndex()) & 16383) + 3;
                }
                z2 = i > i2;
            }
            if (!z2) {
                SSLException sSLException = new SSLException("not an SSL/TLS record: " + ChannelBuffers.hexDump(channelBuffer));
                channelBuffer.skipBytes(channelBuffer.readableBytes());
                throw sSLException;
            }
        }
        if (!$assertionsDisabled && i <= 0) {
            throw new AssertionError();
        }
        if (channelBuffer.readableBytes() < i) {
            return null;
        }
        int i3 = channelBuffer.readerIndex();
        channelBuffer.skipBytes(i);
        return unwrap(channelHandlerContext, channel, channelBuffer, i3, i);
    }

    private static short getShort(ChannelBuffer channelBuffer, int i) {
        return (short) ((channelBuffer.getByte(i) << 8) | (channelBuffer.getByte(i + 1) & 255));
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0103, code lost:
    
        r2 = false;
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0139, code lost:
    
        r0 = true;
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x013e, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0157, code lost:
    
        r0 = r2;
        r2 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.jboss.netty.channel.ChannelFuture wrap(org.jboss.netty.channel.ChannelHandlerContext r13, org.jboss.netty.channel.Channel r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.ssl.SslHandler.wrap(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.Channel):org.jboss.netty.channel.ChannelFuture");
    }

    /* renamed from: org.jboss.netty.handler.ssl.SslHandler$3 */
    /* synthetic */ class C16883 {
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

    private void flushPendingEncryptedWrites(ChannelHandlerContext channelHandlerContext) {
        if (!this.pendingEncryptedWritesLock.tryLock()) {
            return;
        }
        while (true) {
            try {
                MessageEvent messageEvent = (MessageEvent) this.pendingEncryptedWrites.poll();
                if (messageEvent != null) {
                    channelHandlerContext.sendDownstream(messageEvent);
                } else {
                    return;
                }
            } finally {
                this.pendingEncryptedWritesLock.unlock();
            }
        }
    }

    private ChannelFuture wrapNonAppData(ChannelHandlerContext channelHandlerContext, Channel channel) {
        SSLEngineResult sSLEngineResultWrap;
        ChannelFuture channelFutureFuture = null;
        ByteBuffer byteBufferAcquire = this.bufferPool.acquire();
        do {
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
                        channelFutureFuture = Channels.future(channel);
                        channelFutureFuture.addListener(new ChannelFutureListener() { // from class: org.jboss.netty.handler.ssl.SslHandler.1
                            @Override // org.jboss.netty.channel.ChannelFutureListener
                            public void operationComplete(ChannelFuture channelFuture) {
                                if (channelFuture.getCause() instanceof ClosedChannelException) {
                                    synchronized (SslHandler.this.ignoreClosedChannelExceptionLock) {
                                        SslHandler.this.ignoreClosedChannelException++;
                                    }
                                }
                            }
                        });
                        Channels.write(channelHandlerContext, channelFutureFuture, channelBufferBuffer);
                    }
                    SSLEngineResult.HandshakeStatus handshakeStatus = sSLEngineResultWrap.getHandshakeStatus();
                    handleRenegotiation(handshakeStatus);
                    switch (C16883.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[handshakeStatus.ordinal()]) {
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
                } catch (SSLException e) {
                    setHandshakeFailure(channel, e);
                    throw e;
                }
            } finally {
                this.bufferPool.release(byteBufferAcquire);
            }
        } while (sSLEngineResultWrap.bytesProduced() != 0);
        return channelFutureFuture == null ? Channels.succeededFuture(channel) : channelFutureFuture;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c7, code lost:
    
        r0 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.jboss.netty.buffer.ChannelBuffer unwrap(org.jboss.netty.channel.ChannelHandlerContext r9, org.jboss.netty.channel.Channel r10, org.jboss.netty.buffer.ChannelBuffer r11, int r12, int r13) {
        /*
            r8 = this;
            r1 = 1
            r0 = 0
            java.nio.ByteBuffer r2 = r11.toByteBuffer(r12, r13)
            org.jboss.netty.handler.ssl.SslBufferPool r3 = r8.bufferPool
            java.nio.ByteBuffer r3 = r3.acquire()
        Lc:
            java.lang.Object r4 = r8.handshakeLock     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            monitor-enter(r4)     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            boolean r5 = r8.handshaken     // Catch: java.lang.Throwable -> L63
            if (r5 != 0) goto L32
            boolean r5 = r8.handshaking     // Catch: java.lang.Throwable -> L63
            if (r5 != 0) goto L32
            javax.net.ssl.SSLEngine r5 = r8.engine     // Catch: java.lang.Throwable -> L63
            boolean r5 = r5.getUseClientMode()     // Catch: java.lang.Throwable -> L63
            if (r5 != 0) goto L32
            javax.net.ssl.SSLEngine r5 = r8.engine     // Catch: java.lang.Throwable -> L63
            boolean r5 = r5.isInboundDone()     // Catch: java.lang.Throwable -> L63
            if (r5 != 0) goto L32
            javax.net.ssl.SSLEngine r5 = r8.engine     // Catch: java.lang.Throwable -> L63
            boolean r5 = r5.isOutboundDone()     // Catch: java.lang.Throwable -> L63
            if (r5 != 0) goto L32
            r8.handshake()     // Catch: java.lang.Throwable -> L63
        L32:
            javax.net.ssl.SSLEngine r5 = r8.engine     // Catch: java.lang.Throwable -> L63
            javax.net.ssl.SSLEngineResult r5 = r5.unwrap(r2, r3)     // Catch: java.lang.Throwable -> L63
            javax.net.ssl.SSLEngineResult$HandshakeStatus r5 = r5.getHandshakeStatus()     // Catch: java.lang.Throwable -> L63
            r8.handleRenegotiation(r5)     // Catch: java.lang.Throwable -> L63
            int[] r6 = org.jboss.netty.handler.ssl.SslHandler.C16883.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus     // Catch: java.lang.Throwable -> L63
            int r7 = r5.ordinal()     // Catch: java.lang.Throwable -> L63
            r6 = r6[r7]     // Catch: java.lang.Throwable -> L63
            switch(r6) {
                case 1: goto Lbb;
                case 2: goto L72;
                case 3: goto Lbf;
                case 4: goto Lc3;
                case 5: goto Lc9;
                default: goto L4a;
            }     // Catch: java.lang.Throwable -> L63
        L4a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L63
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L63
            r1.<init>()     // Catch: java.lang.Throwable -> L63
            java.lang.String r2 = "Unknown handshake status: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L63
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch: java.lang.Throwable -> L63
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L63
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L63
            throw r0     // Catch: java.lang.Throwable -> L63
        L63:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L63
            throw r0     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
        L66:
            r0 = move-exception
            r8.setHandshakeFailure(r10, r0)     // Catch: java.lang.Throwable -> L6b
            throw r0     // Catch: java.lang.Throwable -> L6b
        L6b:
            r0 = move-exception
            org.jboss.netty.handler.ssl.SslBufferPool r1 = r8.bufferPool
            r1.release(r3)
            throw r0
        L72:
            boolean r5 = r2.hasRemaining()     // Catch: java.lang.Throwable -> L63
            if (r5 == 0) goto L82
            javax.net.ssl.SSLEngine r5 = r8.engine     // Catch: java.lang.Throwable -> L63
            boolean r5 = r5.isInboundDone()     // Catch: java.lang.Throwable -> L63
            if (r5 != 0) goto L82
        L80:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L63
            goto Lc
        L82:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L63
        L83:
            if (r0 == 0) goto L98
            java.lang.Object r0 = r8.handshakeLock     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            boolean r0 = java.lang.Thread.holdsLock(r0)     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            if (r0 != 0) goto L98
            org.jboss.netty.util.internal.NonReentrantLock r0 = r8.pendingEncryptedWritesLock     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            boolean r0 = r0.isHeldByCurrentThread()     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            if (r0 != 0) goto L98
            r8.wrap(r9, r10)     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
        L98:
            r3.flip()     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            boolean r0 = r3.hasRemaining()     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            if (r0 == 0) goto Lcc
            int r0 = r3.remaining()     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            org.jboss.netty.buffer.ChannelBuffer r0 = org.jboss.netty.buffer.ChannelBuffers.buffer(r0)     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            byte[] r1 = r3.array()     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            r2 = 0
            int r4 = r0.capacity()     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            r0.writeBytes(r1, r2, r4)     // Catch: javax.net.ssl.SSLException -> L66 java.lang.Throwable -> L6b
            org.jboss.netty.handler.ssl.SslBufferPool r1 = r8.bufferPool
        Lb7:
            r1.release(r3)
            return r0
        Lbb:
            r8.wrapNonAppData(r9, r10)     // Catch: java.lang.Throwable -> L63
            goto L80
        Lbf:
            r8.runDelegatedTasks()     // Catch: java.lang.Throwable -> L63
            goto L80
        Lc3:
            r8.setHandshakeSuccess(r10)     // Catch: java.lang.Throwable -> L63
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L63
            r0 = r1
            goto L83
        Lc9:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L63
            r0 = r1
            goto L83
        Lcc:
            r0 = 0
            org.jboss.netty.handler.ssl.SslBufferPool r1 = r8.bufferPool
            goto Lb7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.handler.ssl.SslHandler.unwrap(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.Channel, org.jboss.netty.buffer.ChannelBuffer, int, int):org.jboss.netty.buffer.ChannelBuffer");
    }

    private void handleRenegotiation(SSLEngineResult.HandshakeStatus handshakeStatus) {
        boolean z = true;
        if (handshakeStatus != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING && handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED && this.handshaken) {
            synchronized (this.handshakeLock) {
                if (!this.handshaking) {
                    if (!this.engine.isInboundDone() && !this.engine.isOutboundDone()) {
                        if (!isEnableRenegotiation()) {
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
            }
        }
    }

    private void runDelegatedTasks() {
        final Runnable delegatedTask;
        while (true) {
            synchronized (this.handshakeLock) {
                delegatedTask = this.engine.getDelegatedTask();
            }
            if (delegatedTask != null) {
                this.delegatedTaskExecutor.execute(new Runnable() { // from class: org.jboss.netty.handler.ssl.SslHandler.2
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (SslHandler.this.handshakeLock) {
                            delegatedTask.run();
                        }
                    }
                });
            } else {
                return;
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

    private void setHandshakeFailure(Channel channel, SSLException sSLException) {
        synchronized (this.handshakeLock) {
            if (this.handshaking) {
                this.handshaking = false;
                this.handshaken = false;
                if (this.handshakeFuture == null) {
                    this.handshakeFuture = Channels.future(channel);
                }
                this.engine.closeOutbound();
                try {
                    this.engine.closeInbound();
                } catch (SSLException e) {
                    logger.debug("SSLEngine.closeInbound() raised an exception after a handshake failure.", e);
                }
                this.handshakeFuture.setFailure(sSLException);
            }
        }
    }

    private void closeOutboundAndChannel(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
        boolean z;
        if (channelStateEvent.getChannel().isConnected()) {
            try {
                try {
                    unwrap(channelHandlerContext, channelStateEvent.getChannel(), ChannelBuffers.EMPTY_BUFFER, 0, 0);
                } catch (SSLException e) {
                    logger.debug("Failed to unwrap before sending a close_notify message", e);
                }
                if (this.engine.isInboundDone()) {
                    z = true;
                } else if (this.sentCloseNotify.compareAndSet(false, true)) {
                    this.engine.closeOutbound();
                    try {
                        wrapNonAppData(channelHandlerContext, channelStateEvent.getChannel()).addListener(new ClosingChannelFutureListener(channelHandlerContext, channelStateEvent));
                        z = true;
                    } catch (SSLException e2) {
                        logger.debug("Failed to encode a close_notify message", e2);
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (!z) {
                }
            } finally {
                channelHandlerContext.sendDownstream(channelStateEvent);
            }
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

    final class ClosingChannelFutureListener implements ChannelFutureListener {
        private final ChannelHandlerContext context;

        /* renamed from: e */
        private final ChannelStateEvent f5812e;

        ClosingChannelFutureListener(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
            this.context = channelHandlerContext;
            this.f5812e = channelStateEvent;
        }

        @Override // org.jboss.netty.channel.ChannelFutureListener
        public void operationComplete(ChannelFuture channelFuture) {
            if (!(channelFuture.getCause() instanceof ClosedChannelException)) {
                Channels.close(this.context, this.f5812e.getFuture());
            } else {
                this.f5812e.getFuture().setSuccess();
            }
        }
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void beforeAdd(ChannelHandlerContext channelHandlerContext) {
        this.ctx = channelHandlerContext;
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void afterAdd(ChannelHandlerContext channelHandlerContext) {
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void beforeRemove(ChannelHandlerContext channelHandlerContext) {
    }

    @Override // org.jboss.netty.channel.LifeCycleAwareChannelHandler
    public void afterRemove(ChannelHandlerContext channelHandlerContext) {
    }
}
