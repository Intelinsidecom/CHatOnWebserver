package com.sec.chaton.p018c;

import android.os.SystemClock;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.p020b.C0484e;
import com.sec.chaton.p018c.p020b.C0485f;
import com.sec.chaton.util.C1341p;
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
/* renamed from: com.sec.chaton.c.ab */
/* loaded from: classes.dex */
public class C0477ab {

    /* renamed from: a */
    protected Lock f1535a = new ReentrantLock();

    /* renamed from: b */
    protected C0505l f1536b;

    /* renamed from: c */
    protected C0484e f1537c;

    /* renamed from: d */
    protected ClientBootstrap f1538d;

    /* renamed from: e */
    ChannelFuture f1539e;

    public C0477ab(C0505l c0505l) {
        this.f1536b = c0505l;
    }

    /* renamed from: a */
    public static boolean m2446a(C0505l c0505l) {
        return C0505l.m2540a(c0505l).m2461a();
    }

    /* renamed from: a */
    public boolean m2461a() {
        try {
            this.f1535a.lock();
            if (this.f1537c == null) {
                return false;
            }
            if (!this.f1537c.m2475b()) {
                return false;
            }
            this.f1535a.unlock();
            return true;
        } finally {
            this.f1535a.unlock();
        }
    }

    /* renamed from: b */
    public static boolean m2448b(C0505l c0505l) {
        return C0505l.m2540a(c0505l).m2462b();
    }

    /* renamed from: b */
    public boolean m2462b() {
        try {
            this.f1535a.lock();
            if (this.f1539e != null && !this.f1539e.isDone()) {
                C1341p.m4658b("isTryOrConnectedIMPL(): Now Connecting...", "TcpClient");
                return true;
            }
            if (this.f1537c == null) {
                C1341p.m4658b("isTryOrConnectedIMPL(): Not Connected...", "TcpClient");
                return false;
            }
            if (!this.f1537c.m2475b()) {
                C1341p.m4658b("isTryOrConnectedIMPL(): Not Connected(validateChannels() - false)...", "TcpClient");
                return false;
            }
            this.f1535a.unlock();
            C1341p.m4658b("isTryOrConnectedIMPL(): Already Connected...", "TcpClient");
            return true;
        } finally {
            this.f1535a.unlock();
        }
    }

    /* renamed from: c */
    public static void m2450c(C0505l c0505l) {
        C0505l.m2540a(c0505l).m2459a(C0463a.m2379a(), 13000L);
    }

    /* renamed from: a */
    public void m2459a(BlockingQueue blockingQueue, long j) {
        blockingQueue.offer(new RunnableC0516w(this, SystemClock.elapsedRealtime(), j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m2454g() {
        C1341p.m4658b("TcpClient.lockReconnect() - STT", "TcpClient");
        this.f1535a.lock();
        try {
            m2457j();
            ChannelFuture channelFutureM2455h = m2455h();
            if (channelFutureM2455h == null || !channelFutureM2455h.isSuccess()) {
                C1341p.m4658b("TcpClient.lockReconnect() - END", "TcpClient");
            } else {
                C1341p.m4658b("TcpClient.lockReconnect() - END", "TcpClient");
            }
        } finally {
            this.f1535a.unlock();
        }
    }

    /* renamed from: h */
    private ChannelFuture m2455h() {
        try {
            int iM2527a = C0502i.m2527a(GlobalApplication.m3100a(), this.f1536b.m2549d());
            if (iM2527a < 0) {
                switch (iM2527a) {
                    case JZlib.Z_DATA_ERROR /* -3 */:
                        C1341p.m4658b("TcpClient.nonLockConnect(): Network isn't available.", "TcpClient");
                        break;
                    case -2:
                    default:
                        C1341p.m4658b("TcpClient.nonLockConnect(): unchecked", "TcpClient");
                        break;
                    case -1:
                        C1341p.m4658b("TcpClient.nonLockConnect(): host lookup failed.", "TcpClient");
                        break;
                }
                return null;
            }
            if (this.f1538d == null || this.f1537c == null) {
                this.f1538d = new ClientBootstrap(new NioClientSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));
                this.f1537c = new C0484e(this.f1536b, this.f1538d);
                this.f1538d.setPipeline(new C0485f(this.f1536b, this.f1537c).getPipeline());
                this.f1538d.setOption("tcpNoDelay", true);
                this.f1538d.setOption("keepAlive", true);
                this.f1538d.setOption("connectTimeoutMillis", 5000);
            }
            C1341p.m4660c("TcpClient.nonLockConnect(): Connetion Tried", "TcpClient");
            ChannelFuture channelFutureConnect = this.f1538d.connect(new InetSocketAddress(this.f1536b.m2549d(), this.f1536b.m2550e()));
            this.f1539e = channelFutureConnect;
            channelFutureConnect.awaitUninterruptibly();
            if (!channelFutureConnect.isSuccess()) {
                C1341p.m4660c("TcpClient.nonLockConnect(): Connetion Fail", "TcpClient");
                if (channelFutureConnect.getCause() != null) {
                    C1341p.m4658b("Point 1", "TcpClient");
                    C1341p.m4653a(channelFutureConnect.getCause(), "TcpClient");
                }
                C1341p.m4658b("Point 2", "TcpClient");
                m2457j();
            } else if (channelFutureConnect.isCancelled()) {
                C1341p.m4660c("TcpClient.nonLockConnect(): Connetion Cancelled", "TcpClient");
                m2457j();
            } else {
                C1341p.m4660c("TcpClient.nonLockConnect(): Connetion Success", "TcpClient");
            }
            return channelFutureConnect;
        } catch (Exception e) {
            C1341p.m4653a(e, "TcpClient");
            return null;
        }
    }

    /* renamed from: c */
    public static int m2449c() {
        return C0505l.m2539a();
    }

    /* renamed from: d */
    public static void m2451d(C0505l c0505l) {
        C0505l.m2543c(c0505l);
    }

    /* renamed from: d */
    public void m2463d() {
        m2458a(C0463a.m2379a());
    }

    /* renamed from: e */
    public static void m2453e(C0505l c0505l) {
        C0505l.m2544d(c0505l);
    }

    /* renamed from: a */
    public void m2458a(BlockingQueue blockingQueue) {
        blockingQueue.offer(new RunnableC0517x(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m2456i() {
        this.f1535a.lock();
        try {
            m2457j();
        } finally {
            this.f1535a.unlock();
        }
    }

    /* renamed from: j */
    private boolean m2457j() {
        C1341p.m4658b("TcpClient.nonLockClose() - STT", "TcpClient");
        if (this.f1537c != null) {
            this.f1537c.m2474a();
            this.f1537c = null;
        }
        if (this.f1538d != null) {
            this.f1538d.releaseExternalResources();
            this.f1538d = null;
        }
        C1341p.m4658b("TcpClient.nonLockClose() - END", "TcpClient");
        return true;
    }

    /* renamed from: a */
    public static void m2445a(C0505l c0505l, C0510q c0510q) {
        C0505l.m2540a(c0505l).m2460a(C0463a.m2379a(), c0510q, 13000L, true);
    }

    /* renamed from: a */
    public void m2460a(BlockingQueue blockingQueue, C0510q c0510q, long j, boolean z) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C1341p.m4658b("sendIMPL - offerTime : " + String.valueOf(jElapsedRealtime), getClass().getSimpleName());
        if (!blockingQueue.offer(new RunnableC0514u(this, jElapsedRealtime, j, c0510q, z))) {
            C1341p.m4658b("TcpClient.sendIMPL() : queue offer fail. try tcp error callback.", "TcpClient");
            c0510q.m2569a(33, c0510q);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f A[Catch: all -> 0x007a, TRY_ENTER, TryCatch #0 {all -> 0x007a, blocks: (B:3:0x000e, B:5:0x0012, B:17:0x004f, B:19:0x0053, B:21:0x006d, B:8:0x001c, B:11:0x002e, B:13:0x0037, B:15:0x003d), top: B:26:0x000e }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long m2443a(com.sec.chaton.p018c.C0510q r5, boolean r6) {
        /*
            r4 = this;
            r0 = -1
            java.lang.String r2 = "TcpClient.lockSend() - STT"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C1341p.m4658b(r2, r3)
            java.util.concurrent.locks.Lock r2 = r4.f1535a
            r2.lock()
            com.sec.chaton.c.b.e r2 = r4.f1537c     // Catch: java.lang.Throwable -> L7a
            if (r2 == 0) goto L1a
            com.sec.chaton.c.b.e r2 = r4.f1537c     // Catch: java.lang.Throwable -> L7a
            boolean r2 = r2.m2475b()     // Catch: java.lang.Throwable -> L7a
            if (r2 != 0) goto L4f
        L1a:
            if (r6 != 0) goto L2e
            java.lang.String r2 = "TcpClient.lockSend() - END with no auto-connect. try tcp error callback"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C1341p.m4658b(r2, r3)     // Catch: java.lang.Throwable -> L7a
            r2 = 24
            r5.m2569a(r2, r5)     // Catch: java.lang.Throwable -> L7a
            java.util.concurrent.locks.Lock r2 = r4.f1535a
            r2.unlock()
        L2d:
            return r0
        L2e:
            r4.m2457j()     // Catch: java.lang.Throwable -> L7a
            org.jboss.netty.channel.ChannelFuture r2 = r4.m2455h()     // Catch: java.lang.Throwable -> L7a
            if (r2 == 0) goto L3d
            boolean r2 = r2.isSuccess()     // Catch: java.lang.Throwable -> L7a
            if (r2 != 0) goto L4f
        L3d:
            java.lang.String r2 = "TcpClient.lockSend() - END with auto-connect fail. try tcp error callback"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C1341p.m4658b(r2, r3)     // Catch: java.lang.Throwable -> L7a
            r2 = 23
            r5.m2569a(r2, r5)     // Catch: java.lang.Throwable -> L7a
            java.util.concurrent.locks.Lock r2 = r4.f1535a
            r2.unlock()
            goto L2d
        L4f:
            com.sec.chaton.c.b.e r2 = r4.f1537c     // Catch: java.lang.Throwable -> L7a
            if (r2 == 0) goto L6d
            java.lang.String r0 = "TcpClient.lockSend(): write req"
            java.lang.String r1 = "TcpClient"
            com.sec.chaton.util.C1341p.m4660c(r0, r1)     // Catch: java.lang.Throwable -> L7a
            com.sec.chaton.c.b.e r0 = r4.f1537c     // Catch: java.lang.Throwable -> L7a
            long r0 = r0.m2473a(r5)     // Catch: java.lang.Throwable -> L7a
        L60:
            java.util.concurrent.locks.Lock r2 = r4.f1535a
            r2.unlock()
            java.lang.String r2 = "TcpClient.lockSend() - END"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C1341p.m4658b(r2, r3)
            goto L2d
        L6d:
            java.lang.String r2 = "TcpClient.lockSend(): The connection was not established."
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C1341p.m4660c(r2, r3)     // Catch: java.lang.Throwable -> L7a
            r2 = 24
            r5.m2569a(r2, r5)     // Catch: java.lang.Throwable -> L7a
            goto L60
        L7a:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r4.f1535a
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p018c.C0477ab.m2443a(com.sec.chaton.c.q, boolean):long");
    }

    /* renamed from: e */
    public static int m2452e() {
        return C0505l.m2541b();
    }

    /* renamed from: f */
    public void m2464f() {
        if (!C0463a.m2379a().offer(new RunnableC0515v(this))) {
            C1341p.m4658b("TcpClient.expiredCollectIMPL() : queue offer fail.", "TcpClient");
        }
    }
}
