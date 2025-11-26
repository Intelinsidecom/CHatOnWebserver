package org.jboss.netty.handler.ssl;

import com.sec.chaton.C0229at;
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
            case C0229at.HorizontalSrollView_android_visibility /* 20 */:
            case C0229at.HorizontalSrollView_android_fitsSystemWindows /* 21 */:
            case C0229at.HorizontalSrollView_android_scrollbars /* 22 */:
            case C0229at.HorizontalSrollView_android_fadingEdge /* 23 */:
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
    /* synthetic */ class C22053 {
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
                    switch (C22053.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[handshakeStatus.ordinal()]) {
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

    private ChannelBuffer unwrap(ChannelHandlerContext channelHandlerContext, Channel channel, ChannelBuffer channelBuffer, int i, int i2) {
        boolean z;
        SSLEngineResult sSLEngineResultUnwrap;
        ChannelBuffer channelBufferBuffer;
        SslBufferPool sslBufferPool;
        boolean z2 = false;
        ByteBuffer byteBuffer = channelBuffer.toByteBuffer(i, i2);
        ByteBuffer byteBufferAcquire = this.bufferPool.acquire();
        while (true) {
            try {
                try {
                    synchronized (this.handshakeLock) {
                        z = (this.handshaken || this.handshaking || this.engine.getUseClientMode() || this.engine.isInboundDone() || this.engine.isOutboundDone()) ? false : true;
                    }
                    if (z) {
                        handshake();
                    }
                    synchronized (this.handshakeLock) {
                        sSLEngineResultUnwrap = this.engine.unwrap(byteBuffer, byteBufferAcquire);
                    }
                    SSLEngineResult.HandshakeStatus handshakeStatus = sSLEngineResultUnwrap.getHandshakeStatus();
                    handleRenegotiation(handshakeStatus);
                    switch (C22053.$SwitchMap$javax$net$ssl$SSLEngineResult$HandshakeStatus[handshakeStatus.ordinal()]) {
                        case 1:
                            wrapNonAppData(channelHandlerContext, channel);
                            continue;
                        case 2:
                            if (!byteBuffer.hasRemaining() || this.engine.isInboundDone()) {
                                break;
                            }
                            break;
                        case 3:
                            runDelegatedTasks();
                            continue;
                        case 4:
                            setHandshakeSuccess(channel);
                            z2 = true;
                            break;
                        case 5:
                            z2 = true;
                            break;
                        default:
                            throw new IllegalStateException("Unknown handshake status: " + handshakeStatus);
                    }
                } catch (SSLException e) {
                    setHandshakeFailure(channel, e);
                    throw e;
                }
            } catch (Throwable th) {
                this.bufferPool.release(byteBufferAcquire);
                throw th;
            }
        }
        if (z2 && !Thread.holdsLock(this.handshakeLock) && !this.pendingEncryptedWritesLock.isHeldByCurrentThread()) {
            wrap(channelHandlerContext, channel);
        }
        byteBufferAcquire.flip();
        if (byteBufferAcquire.hasRemaining()) {
            channelBufferBuffer = ChannelBuffers.buffer(byteBufferAcquire.remaining());
            channelBufferBuffer.writeBytes(byteBufferAcquire.array(), 0, channelBufferBuffer.capacity());
            sslBufferPool = this.bufferPool;
        } else {
            channelBufferBuffer = null;
            sslBufferPool = this.bufferPool;
        }
        sslBufferPool.release(byteBufferAcquire);
        return channelBufferBuffer;
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
        private final ChannelStateEvent f7873e;

        ClosingChannelFutureListener(ChannelHandlerContext channelHandlerContext, ChannelStateEvent channelStateEvent) {
            this.context = channelHandlerContext;
            this.f7873e = channelStateEvent;
        }

        @Override // org.jboss.netty.channel.ChannelFutureListener
        public void operationComplete(ChannelFuture channelFuture) {
            if (!(channelFuture.getCause() instanceof ClosedChannelException)) {
                Channels.close(this.context, this.f7873e.getFuture());
            } else {
                this.f7873e.getFuture().setSuccess();
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
