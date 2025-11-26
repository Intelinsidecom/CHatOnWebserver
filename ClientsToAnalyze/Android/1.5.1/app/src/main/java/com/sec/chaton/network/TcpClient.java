package com.sec.chaton.network;

import android.os.SystemClock;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.pipeline.TcpClientChannelHandler;
import com.sec.chaton.network.pipeline.TcpClientPipelineFactory;
import com.sec.chaton.util.ChatONLogWriter;
import java.net.InetSocketAddress;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.util.internal.jzlib.JZlib;

/* loaded from: classes.dex */
public class TcpClient {

    /* renamed from: a */
    protected Lock f2461a = new ReentrantLock();

    /* renamed from: b */
    protected TcpContext f2462b;

    /* renamed from: c */
    protected TcpClientChannelHandler f2463c;

    /* renamed from: d */
    protected ClientBootstrap f2464d;

    /* renamed from: e */
    ChannelFuture f2465e;

    public TcpClient(TcpContext tcpContext) {
        this.f2462b = tcpContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004c A[Catch: all -> 0x0071, TRY_LEAVE, TryCatch #0 {all -> 0x0071, blocks: (B:3:0x000e, B:5:0x0012, B:18:0x0048, B:20:0x004c, B:22:0x0066, B:8:0x001c, B:12:0x002c, B:14:0x0035, B:16:0x003b), top: B:27:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0066 A[Catch: all -> 0x0071, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0071, blocks: (B:3:0x000e, B:5:0x0012, B:18:0x0048, B:20:0x004c, B:22:0x0066, B:8:0x001c, B:12:0x002c, B:14:0x0035, B:16:0x003b), top: B:27:0x000e }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long m2756a(com.sec.chaton.network.TcpEnvelope r5, boolean r6) {
        /*
            r4 = this;
            r0 = -1
            java.lang.String r2 = "TcpClient.lockSend() - STT"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.ChatONLogWriter.m3506b(r2, r3)
            java.util.concurrent.locks.Lock r2 = r4.f2461a
            r2.lock()
            com.sec.chaton.network.pipeline.TcpClientChannelHandler r2 = r4.f2463c     // Catch: java.lang.Throwable -> L71
            if (r2 == 0) goto L1a
            com.sec.chaton.network.pipeline.TcpClientChannelHandler r2 = r4.f2463c     // Catch: java.lang.Throwable -> L71
            boolean r2 = r2.m2836b()     // Catch: java.lang.Throwable -> L71
            if (r2 != 0) goto L48
        L1a:
            if (r6 != 0) goto L2c
            java.lang.String r2 = "TcpClient.lockSend() - END with no auto-connect. try tcp error callback"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.ChatONLogWriter.m3506b(r2, r3)     // Catch: java.lang.Throwable -> L71
            r5.m2802a(r5)     // Catch: java.lang.Throwable -> L71
            java.util.concurrent.locks.Lock r2 = r4.f2461a
        L28:
            r2.unlock()
        L2b:
            return r0
        L2c:
            r4.m2770j()     // Catch: java.lang.Throwable -> L71
            org.jboss.netty.channel.ChannelFuture r2 = r4.m2768h()     // Catch: java.lang.Throwable -> L71
            if (r2 == 0) goto L3b
            boolean r2 = r2.isSuccess()     // Catch: java.lang.Throwable -> L71
            if (r2 != 0) goto L48
        L3b:
            java.lang.String r2 = "TcpClient.lockSend() - END with auto-connect fail. try tcp error callback"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.ChatONLogWriter.m3506b(r2, r3)     // Catch: java.lang.Throwable -> L71
            r5.m2802a(r5)     // Catch: java.lang.Throwable -> L71
            java.util.concurrent.locks.Lock r2 = r4.f2461a
            goto L28
        L48:
            com.sec.chaton.network.pipeline.TcpClientChannelHandler r2 = r4.f2463c     // Catch: java.lang.Throwable -> L71
            if (r2 == 0) goto L66
            java.lang.String r0 = "TcpClient.lockSend(): write req"
            java.lang.String r1 = "TcpClient"
            com.sec.chaton.util.ChatONLogWriter.m3508c(r0, r1)     // Catch: java.lang.Throwable -> L71
            com.sec.chaton.network.pipeline.TcpClientChannelHandler r0 = r4.f2463c     // Catch: java.lang.Throwable -> L71
            long r0 = r0.m2834a(r5)     // Catch: java.lang.Throwable -> L71
        L59:
            java.util.concurrent.locks.Lock r2 = r4.f2461a
            r2.unlock()
            java.lang.String r2 = "TcpClient.lockSend() - END"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.ChatONLogWriter.m3506b(r2, r3)
            goto L2b
        L66:
            java.lang.String r2 = "TcpClient.lockSend(): The connection was not established."
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.ChatONLogWriter.m3508c(r2, r3)     // Catch: java.lang.Throwable -> L71
            r5.m2802a(r5)     // Catch: java.lang.Throwable -> L71
            goto L59
        L71:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r4.f2461a
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.network.TcpClient.m2756a(com.sec.chaton.network.TcpEnvelope, boolean):long");
    }

    /* renamed from: a */
    public static void m2758a(TcpContext tcpContext, TcpEnvelope tcpEnvelope) {
        TcpContext.m2779a(tcpContext).m2773a(TcpNetworkQueue.m2817a(), tcpEnvelope, 13000L, true);
    }

    /* renamed from: a */
    public static boolean m2759a(TcpContext tcpContext) {
        return TcpContext.m2779a(tcpContext).m2774a();
    }

    /* renamed from: b */
    public static boolean m2761b(TcpContext tcpContext) {
        return TcpContext.m2779a(tcpContext).m2775b();
    }

    /* renamed from: c */
    public static int m2762c() {
        return TcpContext.m2778a();
    }

    /* renamed from: c */
    public static void m2763c(TcpContext tcpContext) {
        TcpContext.m2779a(tcpContext).m2772a(TcpNetworkQueue.m2817a(), 13000L);
    }

    /* renamed from: d */
    public static void m2764d(TcpContext tcpContext) {
        TcpContext.m2782c(tcpContext);
    }

    /* renamed from: e */
    public static int m2765e() {
        return TcpContext.m2780b();
    }

    /* renamed from: e */
    public static void m2766e(TcpContext tcpContext) {
        TcpContext.m2783d(tcpContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m2767g() {
        ChatONLogWriter.m3506b("TcpClient.lockReconnect() - STT", "TcpClient");
        this.f2461a.lock();
        try {
            m2770j();
            ChannelFuture channelFutureM2768h = m2768h();
            if (channelFutureM2768h == null || !channelFutureM2768h.isSuccess()) {
                ChatONLogWriter.m3506b("TcpClient.lockReconnect() - END", "TcpClient");
            } else {
                ChatONLogWriter.m3506b("TcpClient.lockReconnect() - END", "TcpClient");
            }
        } finally {
            this.f2461a.unlock();
        }
    }

    /* renamed from: h */
    private ChannelFuture m2768h() {
        try {
            int iM2754a = NetState.m2754a(GlobalApplication.m2387e(), this.f2462b.m2788d());
            if (iM2754a < 0) {
                switch (iM2754a) {
                    case JZlib.Z_DATA_ERROR /* -3 */:
                        ChatONLogWriter.m3506b("TcpClient.nonLockConnect(): Network isn't available.", "TcpClient");
                        break;
                    case JZlib.Z_STREAM_ERROR /* -2 */:
                    default:
                        ChatONLogWriter.m3506b("TcpClient.nonLockConnect(): unchecked", "TcpClient");
                        break;
                    case -1:
                        ChatONLogWriter.m3506b("TcpClient.nonLockConnect(): host lookup failed.", "TcpClient");
                        break;
                }
                return null;
            }
            if (this.f2464d == null || this.f2463c == null) {
                this.f2464d = new ClientBootstrap(new NioClientSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));
                this.f2463c = new TcpClientChannelHandler(this.f2462b, this.f2464d);
                this.f2464d.setPipeline(new TcpClientPipelineFactory(this.f2462b, this.f2463c).getPipeline());
                this.f2464d.setOption("tcpNoDelay", true);
                this.f2464d.setOption("keepAlive", true);
                this.f2464d.setOption("connectTimeoutMillis", 9000);
            }
            ChatONLogWriter.m3508c("TcpClient.nonLockConnect(): Connetion Tried", "TcpClient");
            ChannelFuture channelFutureConnect = this.f2464d.connect(new InetSocketAddress(this.f2462b.m2788d(), this.f2462b.m2789e()));
            this.f2465e = channelFutureConnect;
            channelFutureConnect.awaitUninterruptibly(9000L);
            if (channelFutureConnect.isSuccess()) {
                ChatONLogWriter.m3508c("TcpClient.nonLockConnect(): Connetion Success", "TcpClient");
                return channelFutureConnect;
            }
            ChatONLogWriter.m3508c("TcpClient.nonLockConnect(): Connetion Fail", "TcpClient");
            if (channelFutureConnect.getCause() != null) {
                ChatONLogWriter.m3506b("Point 1", "TcpClient");
                channelFutureConnect.getCause().printStackTrace();
            }
            ChatONLogWriter.m3506b("Point 2", "TcpClient");
            m2770j();
            return channelFutureConnect;
        } catch (Exception e) {
            ChatONLogWriter.m3501a(e, "TcpClient");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m2769i() {
        this.f2461a.lock();
        try {
            m2770j();
        } finally {
            this.f2461a.unlock();
        }
    }

    /* renamed from: j */
    private boolean m2770j() {
        ChatONLogWriter.m3506b("TcpClient.nonLockClose() - STT", "TcpClient");
        if (this.f2463c != null) {
            this.f2463c.m2835a();
            this.f2463c = null;
        }
        if (this.f2464d != null) {
            this.f2464d.releaseExternalResources();
            this.f2464d = null;
        }
        ChatONLogWriter.m3506b("TcpClient.nonLockClose() - END", "TcpClient");
        return true;
    }

    /* renamed from: a */
    public void m2771a(BlockingQueue blockingQueue) {
        blockingQueue.offer(new RunnableC0347i(this));
    }

    /* renamed from: a */
    public void m2772a(BlockingQueue blockingQueue, long j) {
        blockingQueue.offer(new RunnableC0346h(this, SystemClock.elapsedRealtime(), j));
    }

    /* renamed from: a */
    public void m2773a(BlockingQueue blockingQueue, TcpEnvelope tcpEnvelope, long j, boolean z) {
        if (blockingQueue.offer(new RunnableC0344f(this, SystemClock.elapsedRealtime(), j, tcpEnvelope, z))) {
            return;
        }
        ChatONLogWriter.m3506b("TcpClient.sendIMPL() : queue offer fail. try tcp error callback.", "TcpClient");
        tcpEnvelope.m2802a(tcpEnvelope);
    }

    /* renamed from: a */
    public boolean m2774a() {
        return this.f2463c != null && this.f2463c.m2836b();
    }

    /* renamed from: b */
    public boolean m2775b() {
        if (this.f2465e != null && !this.f2465e.isDone()) {
            ChatONLogWriter.m3506b("isTryOrConnectedIMPL(): Now Connecting...", "TcpClient");
            return true;
        }
        if (this.f2463c == null) {
            ChatONLogWriter.m3506b("isTryOrConnectedIMPL(): Not Connected...", "TcpClient");
            return false;
        }
        if (this.f2463c.m2836b()) {
            ChatONLogWriter.m3506b("isTryOrConnectedIMPL(): Already Connected...", "TcpClient");
            return true;
        }
        ChatONLogWriter.m3506b("isTryOrConnectedIMPL(): Not Connected(validateChannels() - false)...", "TcpClient");
        return false;
    }

    /* renamed from: d */
    public void m2776d() {
        m2771a(TcpNetworkQueue.m2817a());
    }

    /* renamed from: f */
    public void m2777f() {
        if (TcpNetworkQueue.m2817a().offer(new RunnableC0345g(this))) {
            return;
        }
        ChatONLogWriter.m3506b("TcpClient.expiredCollectIMPL() : queue offer fail.", "TcpClient");
    }
}
