package com.sec.chaton.p022h;

import android.os.SystemClock;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p022h.p026d.C0791g;
import com.sec.chaton.p022h.p026d.C0793i;
import com.sec.chaton.util.C1786r;
import java.net.InetSocketAddress;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.util.internal.jzlib.JZlib;

/* compiled from: TcpClient.java */
/* renamed from: com.sec.chaton.h.t */
/* loaded from: classes.dex */
public class C0810t {

    /* renamed from: b */
    protected C0816z f2974b;

    /* renamed from: c */
    protected C0791g f2975c;

    /* renamed from: d */
    protected ClientBootstrap f2976d;

    /* renamed from: e */
    ChannelFuture f2977e;

    /* renamed from: a */
    protected Lock f2973a = new ReentrantLock();

    /* renamed from: f */
    protected Object f2978f = new Object();

    /* renamed from: g */
    protected EnumC0815y f2979g = EnumC0815y.NOT_CONNECT;

    public C0810t(C0816z c0816z) {
        this.f2974b = c0816z;
    }

    /* renamed from: a */
    public static boolean m3426a(C0816z c0816z) {
        return C0816z.m3446a(c0816z).m3441a();
    }

    /* renamed from: a */
    public boolean m3441a() {
        boolean z;
        synchronized (this.f2978f) {
            z = this.f2979g == EnumC0815y.CONNECT;
        }
        return z;
    }

    /* renamed from: b */
    public static boolean m3428b(C0816z c0816z) {
        return C0816z.m3446a(c0816z).m3442b();
    }

    /* renamed from: b */
    public boolean m3442b() {
        boolean z;
        synchronized (this.f2978f) {
            z = this.f2979g != EnumC0815y.NOT_CONNECT;
        }
        return z;
    }

    /* renamed from: c */
    public static void m3430c(C0816z c0816z) {
        C0816z.m3446a(c0816z).m3439a(C0772ad.m3300a(), 13000L);
    }

    /* renamed from: a */
    public void m3439a(BlockingQueue blockingQueue, long j) {
        blockingQueue.offer(new RunnableC0811u(this, SystemClock.elapsedRealtime(), j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m3434g() {
        C1786r.m6061b("TcpClient.lockReconnect() - STT", "TcpClient");
        synchronized (this.f2978f) {
            this.f2979g = EnumC0815y.CONNECTING;
        }
        this.f2973a.lock();
        try {
            m3437j();
            ChannelFuture channelFutureM3435h = m3435h();
            if (channelFutureM3435h == null || !channelFutureM3435h.isSuccess()) {
                synchronized (this.f2978f) {
                    this.f2979g = EnumC0815y.NOT_CONNECT;
                }
                C1786r.m6061b("TcpClient.lockReconnect() - END", "TcpClient");
                return;
            }
            synchronized (this.f2978f) {
                this.f2979g = EnumC0815y.CONNECT;
            }
            C1786r.m6061b("TcpClient.lockReconnect() - END", "TcpClient");
        } finally {
            this.f2973a.unlock();
        }
    }

    /* renamed from: h */
    private ChannelFuture m3435h() {
        try {
            int iM3421a = C0809s.m3421a(GlobalApplication.m3260b(), this.f2974b.m3455d());
            if (iM3421a < 0) {
                switch (iM3421a) {
                    case JZlib.Z_DATA_ERROR /* -3 */:
                        C1786r.m6061b("TcpClient.nonLockConnect(): Network isn't available.", "TcpClient");
                        break;
                    case -2:
                    default:
                        C1786r.m6061b("TcpClient.nonLockConnect(): unchecked", "TcpClient");
                        break;
                    case -1:
                        C1786r.m6061b("TcpClient.nonLockConnect(): host lookup failed.", "TcpClient");
                        break;
                }
                return null;
            }
            if (this.f2976d == null || this.f2975c == null) {
                this.f2976d = new ClientBootstrap(new NioClientSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));
                this.f2975c = new C0791g(this.f2974b, this.f2976d);
                this.f2976d.setPipeline(new C0793i(this.f2974b, this.f2975c).getPipeline());
                this.f2976d.setOption("tcpNoDelay", true);
                this.f2976d.setOption("keepAlive", true);
                this.f2976d.setOption("connectTimeoutMillis", 9000);
            }
            C1786r.m6063c("TcpClient.nonLockConnect(): Connetion Tried", "TcpClient");
            ChannelFuture channelFutureConnect = this.f2976d.connect(new InetSocketAddress(this.f2974b.m3455d(), this.f2974b.m3456e()));
            this.f2977e = channelFutureConnect;
            channelFutureConnect.awaitUninterruptibly();
            if (!channelFutureConnect.isSuccess()) {
                C1786r.m6063c("TcpClient.nonLockConnect(): Connetion Fail", "TcpClient");
                if (channelFutureConnect.getCause() != null) {
                    C1786r.m6061b("Point 1", "TcpClient");
                    C1786r.m6056a(channelFutureConnect.getCause(), "TcpClient");
                }
                C1786r.m6061b("Point 2", "TcpClient");
                m3437j();
            } else if (channelFutureConnect.isCancelled()) {
                C1786r.m6063c("TcpClient.nonLockConnect(): Connetion Cancelled", "TcpClient");
                m3437j();
            } else {
                C1786r.m6063c("TcpClient.nonLockConnect(): Connetion Success", "TcpClient");
            }
            return channelFutureConnect;
        } catch (Exception e) {
            C1786r.m6056a(e, "TcpClient");
            return null;
        }
    }

    /* renamed from: c */
    public static int m3429c() {
        return C0816z.m3445a();
    }

    /* renamed from: d */
    public static void m3431d(C0816z c0816z) {
        C0816z.m3449c(c0816z);
    }

    /* renamed from: d */
    public void m3443d() {
        m3438a(C0772ad.m3300a());
    }

    /* renamed from: e */
    public static void m3433e(C0816z c0816z) {
        C0816z.m3450d(c0816z);
    }

    /* renamed from: a */
    public void m3438a(BlockingQueue blockingQueue) {
        blockingQueue.offer(new RunnableC0812v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m3436i() {
        this.f2973a.lock();
        try {
            synchronized (this.f2978f) {
                this.f2979g = EnumC0815y.NOT_CONNECT;
            }
            m3437j();
        } finally {
            this.f2973a.unlock();
        }
    }

    /* renamed from: j */
    private boolean m3437j() {
        C1786r.m6061b("TcpClient.nonLockClose() - STT", "TcpClient");
        if (this.f2975c != null) {
            this.f2975c.m3375a();
            this.f2975c = null;
        }
        if (this.f2976d != null) {
            this.f2976d.releaseExternalResources();
            this.f2976d = null;
        }
        C1786r.m6061b("TcpClient.nonLockClose() - END", "TcpClient");
        return true;
    }

    /* renamed from: a */
    public static void m3425a(C0816z c0816z, C0770ab c0770ab) {
        C0816z.m3446a(c0816z).m3440a(C0772ad.m3300a(), c0770ab, 13000L, true);
    }

    /* renamed from: a */
    public void m3440a(BlockingQueue blockingQueue, C0770ab c0770ab, long j, boolean z) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C1786r.m6061b("sendIMPL - offerTime : " + String.valueOf(jElapsedRealtime), getClass().getSimpleName());
        if (!blockingQueue.offer(new RunnableC0813w(this, jElapsedRealtime, j, c0770ab, z))) {
            C1786r.m6061b("TcpClient.sendIMPL() : queue offer fail. try tcp error callback.", "TcpClient");
            c0770ab.m3285a(33, c0770ab);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0069 A[Catch: all -> 0x005f, TryCatch #4 {all -> 0x005f, blocks: (B:3:0x000e, B:5:0x0012, B:35:0x0069, B:37:0x006d, B:38:0x006f, B:41:0x0075, B:45:0x0091, B:46:0x0092, B:47:0x0094, B:50:0x009a, B:54:0x00a9, B:8:0x001c, B:12:0x002e, B:13:0x0030, B:16:0x0036, B:18:0x003f, B:20:0x0045, B:21:0x0047, B:24:0x004d, B:34:0x0068, B:28:0x005e, B:22:0x0048, B:23:0x004c, B:48:0x0095, B:49:0x0099, B:14:0x0031, B:15:0x0035, B:39:0x0070, B:40:0x0074), top: B:63:0x000e, inners: #0, #1, #2, #3 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long m3422a(com.sec.chaton.p022h.C0770ab r5, boolean r6) {
        /*
            r4 = this;
            r0 = -1
            java.lang.String r2 = "TcpClient.lockSend() - STT"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C1786r.m6061b(r2, r3)
            java.util.concurrent.locks.Lock r2 = r4.f2973a
            r2.lock()
            com.sec.chaton.h.d.g r2 = r4.f2975c     // Catch: java.lang.Throwable -> L5f
            if (r2 == 0) goto L1a
            com.sec.chaton.h.d.g r2 = r4.f2975c     // Catch: java.lang.Throwable -> L5f
            boolean r2 = r2.m3376b()     // Catch: java.lang.Throwable -> L5f
            if (r2 != 0) goto L69
        L1a:
            if (r6 != 0) goto L2e
            java.lang.String r2 = "TcpClient.lockSend() - END with no auto-connect. try tcp error callback"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C1786r.m6061b(r2, r3)     // Catch: java.lang.Throwable -> L5f
            r2 = 24
            r5.m3285a(r2, r5)     // Catch: java.lang.Throwable -> L5f
            java.util.concurrent.locks.Lock r2 = r4.f2973a
        L2a:
            r2.unlock()
        L2d:
            return r0
        L2e:
            java.lang.Object r2 = r4.f2978f     // Catch: java.lang.Throwable -> L5f
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L5f
            com.sec.chaton.h.y r3 = com.sec.chaton.p022h.EnumC0815y.CONNECTING     // Catch: java.lang.Throwable -> L5c
            r4.f2979g = r3     // Catch: java.lang.Throwable -> L5c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L5c
            r4.m3437j()     // Catch: java.lang.Throwable -> L5f
            org.jboss.netty.channel.ChannelFuture r2 = r4.m3435h()     // Catch: java.lang.Throwable -> L5f
            if (r2 == 0) goto L45
            boolean r2 = r2.isSuccess()     // Catch: java.lang.Throwable -> L5f
            if (r2 != 0) goto L69
        L45:
            java.lang.Object r2 = r4.f2978f     // Catch: java.lang.Throwable -> L5f
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L5f
            com.sec.chaton.h.y r3 = com.sec.chaton.p022h.EnumC0815y.NOT_CONNECT     // Catch: java.lang.Throwable -> L66
            r4.f2979g = r3     // Catch: java.lang.Throwable -> L66
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L66
            java.lang.String r2 = "TcpClient.lockSend() - END with auto-connect fail. try tcp error callback"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C1786r.m6061b(r2, r3)     // Catch: java.lang.Throwable -> L5f
            r2 = 23
            r5.m3285a(r2, r5)     // Catch: java.lang.Throwable -> L5f
            java.util.concurrent.locks.Lock r2 = r4.f2973a
            goto L2a
        L5c:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L5c
            throw r0     // Catch: java.lang.Throwable -> L5f
        L5f:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r4.f2973a
            r1.unlock()
            throw r0
        L66:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L66
            throw r0     // Catch: java.lang.Throwable -> L5f
        L69:
            com.sec.chaton.h.d.g r2 = r4.f2975c     // Catch: java.lang.Throwable -> L5f
            if (r2 == 0) goto L92
            java.lang.Object r1 = r4.f2978f     // Catch: java.lang.Throwable -> L5f
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L5f
            com.sec.chaton.h.y r0 = com.sec.chaton.p022h.EnumC0815y.CONNECT     // Catch: java.lang.Throwable -> L8f
            r4.f2979g = r0     // Catch: java.lang.Throwable -> L8f
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r0 = "TcpClient.lockSend(): write req"
            java.lang.String r1 = "TcpClient"
            com.sec.chaton.util.C1786r.m6063c(r0, r1)     // Catch: java.lang.Throwable -> L5f
            com.sec.chaton.h.d.g r0 = r4.f2975c     // Catch: java.lang.Throwable -> L5f
            long r0 = r0.m3374a(r5)     // Catch: java.lang.Throwable -> L5f
        L82:
            java.util.concurrent.locks.Lock r2 = r4.f2973a
            r2.unlock()
            java.lang.String r2 = "TcpClient.lockSend() - END"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C1786r.m6061b(r2, r3)
            goto L2d
        L8f:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L8f
            throw r0     // Catch: java.lang.Throwable -> L5f
        L92:
            java.lang.Object r2 = r4.f2978f     // Catch: java.lang.Throwable -> L5f
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L5f
            com.sec.chaton.h.y r3 = com.sec.chaton.p022h.EnumC0815y.NOT_CONNECT     // Catch: java.lang.Throwable -> La7
            r4.f2979g = r3     // Catch: java.lang.Throwable -> La7
            monitor-exit(r2)     // Catch: java.lang.Throwable -> La7
            java.lang.String r2 = "TcpClient.lockSend(): The connection was not established."
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C1786r.m6063c(r2, r3)     // Catch: java.lang.Throwable -> L5f
            r2 = 24
            r5.m3285a(r2, r5)     // Catch: java.lang.Throwable -> L5f
            goto L82
        La7:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> La7
            throw r0     // Catch: java.lang.Throwable -> L5f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p022h.C0810t.m3422a(com.sec.chaton.h.ab, boolean):long");
    }

    /* renamed from: e */
    public static int m3432e() {
        return C0816z.m3447b();
    }

    /* renamed from: f */
    public void m3444f() {
        if (!C0772ad.m3300a().offer(new RunnableC0814x(this))) {
            C1786r.m6061b("TcpClient.expiredCollectIMPL() : queue offer fail.", "TcpClient");
        }
    }
}
