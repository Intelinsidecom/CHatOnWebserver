package com.sec.chaton.p037j;

import android.os.SystemClock;
import com.sec.chaton.p020c.C0822g;
import com.sec.chaton.p037j.p041d.C1573g;
import com.sec.chaton.p037j.p041d.C1575i;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.net.InetSocketAddress;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

/* compiled from: TcpClient.java */
/* renamed from: com.sec.chaton.j.x */
/* loaded from: classes.dex */
public class C1596x {

    /* renamed from: b */
    protected C1544ac f5926b;

    /* renamed from: c */
    protected C1573g f5927c;

    /* renamed from: d */
    protected ClientBootstrap f5928d;

    /* renamed from: e */
    ChannelFuture f5929e;

    /* renamed from: a */
    protected Lock f5925a = new ReentrantLock();

    /* renamed from: f */
    protected Object f5930f = new Object();

    /* renamed from: g */
    protected EnumC1543ab f5931g = EnumC1543ab.NOT_CONNECT;

    public C1596x(C1544ac c1544ac) {
        this.f5926b = c1544ac;
    }

    /* renamed from: a */
    public static boolean m6753a(C1544ac c1544ac) {
        return C1544ac.m6542a(c1544ac).m6771a();
    }

    /* renamed from: a */
    public boolean m6771a() {
        boolean z;
        synchronized (this.f5930f) {
            z = this.f5931g == EnumC1543ab.CONNECT;
        }
        return z;
    }

    /* renamed from: b */
    public static boolean m6756b(C1544ac c1544ac) {
        return C1544ac.m6542a(c1544ac).m6772b();
    }

    /* renamed from: b */
    public boolean m6772b() {
        boolean z;
        synchronized (this.f5930f) {
            z = this.f5931g != EnumC1543ab.NOT_CONNECT;
        }
        return z;
    }

    /* renamed from: c */
    public static void m6757c(C1544ac c1544ac) {
        C1544ac.m6542a(c1544ac).m6769a(C1550ai.m6585a(), 33000L);
    }

    /* renamed from: a */
    public void m6769a(BlockingQueue<Runnable> blockingQueue, long j) {
        blockingQueue.offer(new RunnableC1597y(this, SystemClock.elapsedRealtime(), j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m6763g() {
        C3250y.m11450b("TcpClient.lockReconnect() - STT", "TcpClient");
        synchronized (this.f5930f) {
            this.f5931g = EnumC1543ab.CONNECTING;
        }
        this.f5925a.lock();
        try {
            m6766j();
            ChannelFuture channelFutureM6764h = m6764h();
            if (channelFutureM6764h == null || !channelFutureM6764h.isSuccess()) {
                synchronized (this.f5930f) {
                    this.f5931g = EnumC1543ab.NOT_CONNECT;
                }
                C3250y.m11450b("TcpClient.lockReconnect() - END", "TcpClient");
                return;
            }
            synchronized (this.f5930f) {
                this.f5931g = EnumC1543ab.CONNECT;
            }
            C3250y.m11450b("TcpClient.lockReconnect() - END", "TcpClient");
        } finally {
            this.f5925a.unlock();
        }
    }

    /* renamed from: h */
    private ChannelFuture m6764h() {
        try {
            int iM6734a = C1594v.m6734a(CommonApplication.m11493l(), this.f5926b.m6557d());
            if (iM6734a < 0) {
                switch (iM6734a) {
                    case -3:
                        C3250y.m11450b("TcpClient.nonLockConnect(): Network isn't available.", "TcpClient");
                        break;
                    case -2:
                    default:
                        C3250y.m11450b("TcpClient.nonLockConnect(): unchecked", "TcpClient");
                        break;
                    case -1:
                        C3250y.m11450b("TcpClient.nonLockConnect(): host lookup failed.", "TcpClient");
                        break;
                }
                return null;
            }
            if (this.f5928d == null || this.f5927c == null) {
                this.f5928d = new ClientBootstrap(new NioClientSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));
                this.f5927c = new C1573g(this.f5926b, this.f5928d);
                this.f5928d.setPipeline(new C1575i(this.f5926b, this.f5927c).getPipeline());
                this.f5928d.setOption("tcpNoDelay", true);
                this.f5928d.setOption("keepAlive", true);
                this.f5928d.setOption("connectTimeoutMillis", Integer.valueOf(C0822g.m4373b()));
            }
            C3250y.m11453c("TcpClient.nonLockConnect(): Connetion Tried", "TcpClient");
            ChannelFuture channelFutureConnect = this.f5928d.connect(new InetSocketAddress(this.f5926b.m6557d(), this.f5926b.m6558e()));
            this.f5929e = channelFutureConnect;
            channelFutureConnect.awaitUninterruptibly();
            if (!channelFutureConnect.isSuccess()) {
                C3250y.m11453c("TcpClient.nonLockConnect(): Connetion Fail", "TcpClient");
                if (channelFutureConnect.getCause() != null) {
                    C3250y.m11450b("Point 1", "TcpClient");
                    C3250y.m11443a(channelFutureConnect.getCause(), "TcpClient");
                }
                C3250y.m11450b("Point 2", "TcpClient");
                m6766j();
            } else if (channelFutureConnect.isCancelled()) {
                C3250y.m11453c("TcpClient.nonLockConnect(): Connetion Cancelled", "TcpClient");
                m6766j();
            } else {
                C3250y.m11453c("TcpClient.nonLockConnect(): Connetion Success", "TcpClient");
            }
            return channelFutureConnect;
        } catch (Exception e) {
            C3250y.m11443a(e, "TcpClient");
            return null;
        }
    }

    /* renamed from: c */
    public static boolean m6758c() {
        return C1544ac.m6544a(34);
    }

    /* renamed from: d */
    public static void m6760d(C1544ac c1544ac) {
        C1544ac.m6548c(c1544ac);
    }

    /* renamed from: d */
    public void m6773d() {
        m6768a(C1550ai.m6585a());
    }

    /* renamed from: e */
    public static void m6761e(C1544ac c1544ac) {
        C1544ac.m6549d(c1544ac);
    }

    /* renamed from: a */
    public void m6768a(BlockingQueue<Runnable> blockingQueue) {
        blockingQueue.offer(new RunnableC1598z(this));
    }

    /* renamed from: a */
    public void m6767a(int i) {
        m6754b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m6765i() {
        m6754b(34);
    }

    /* renamed from: b */
    private void m6754b(int i) {
        this.f5925a.lock();
        try {
            synchronized (this.f5930f) {
                this.f5931g = EnumC1543ab.NOT_CONNECT;
            }
            m6759c(i);
        } finally {
            this.f5925a.unlock();
        }
    }

    /* renamed from: j */
    private boolean m6766j() {
        return m6759c(34);
    }

    /* renamed from: c */
    private boolean m6759c(int i) {
        C3250y.m11450b("TcpClient.nonLockClose() - STT", "TcpClient");
        if (this.f5927c != null) {
            C3250y.m11450b("TcpClient.nonLockClose() - mChannelHandler", "TcpClient");
            this.f5927c.m6676a(i);
            this.f5927c = null;
        }
        if (this.f5928d != null) {
            C3250y.m11450b("TcpClient.nonLockClose() - mBootstrap", "TcpClient");
            this.f5928d.releaseExternalResources();
            this.f5928d = null;
        }
        C3250y.m11450b("TcpClient.nonLockClose() - END", "TcpClient");
        return true;
    }

    /* renamed from: a */
    public static void m6751a(C1544ac c1544ac, C1548ag c1548ag) {
        C1544ac.m6542a(c1544ac).m6770a(C1550ai.m6585a(), c1548ag, 33000L, true);
    }

    /* renamed from: a */
    public void m6770a(BlockingQueue<Runnable> blockingQueue, C1548ag c1548ag, long j, boolean z) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C3250y.m11450b("sendIMPL - offerTime : " + String.valueOf(jElapsedRealtime), getClass().getSimpleName());
        if (!blockingQueue.offer(new RunnableC1542aa(this, jElapsedRealtime, j, c1548ag, z))) {
            C3250y.m11450b("TcpClient.sendIMPL() : queue offer fail. try tcp error callback.", "TcpClient");
            c1548ag.m6570a(33, c1548ag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006c A[Catch: all -> 0x0062, TryCatch #1 {all -> 0x0062, blocks: (B:3:0x000e, B:5:0x0012, B:34:0x006c, B:36:0x0070, B:37:0x0072, B:40:0x0078, B:44:0x0094, B:45:0x0095, B:46:0x0097, B:49:0x009d, B:53:0x00ac, B:8:0x001c, B:11:0x002e, B:12:0x0030, B:15:0x0036, B:17:0x003f, B:19:0x0045, B:20:0x0047, B:23:0x004d, B:33:0x006b, B:27:0x0061, B:38:0x0073, B:39:0x0077, B:21:0x0048, B:22:0x004c, B:47:0x0098, B:48:0x009c, B:13:0x0031, B:14:0x0035), top: B:56:0x000e, inners: #0, #2, #3, #4 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long m6749a(com.sec.chaton.p037j.C1548ag r5, boolean r6) {
        /*
            r4 = this;
            r0 = -1
            java.lang.String r2 = "TcpClient.lockSend() - STT"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C3250y.m11450b(r2, r3)
            java.util.concurrent.locks.Lock r2 = r4.f5925a
            r2.lock()
            com.sec.chaton.j.d.g r2 = r4.f5927c     // Catch: java.lang.Throwable -> L62
            if (r2 == 0) goto L1a
            com.sec.chaton.j.d.g r2 = r4.f5927c     // Catch: java.lang.Throwable -> L62
            boolean r2 = r2.m6677b()     // Catch: java.lang.Throwable -> L62
            if (r2 != 0) goto L6c
        L1a:
            if (r6 != 0) goto L2e
            java.lang.String r2 = "TcpClient.lockSend() - END with no auto-connect. try tcp error callback"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C3250y.m11450b(r2, r3)     // Catch: java.lang.Throwable -> L62
            r2 = 24
            r5.m6570a(r2, r5)     // Catch: java.lang.Throwable -> L62
            java.util.concurrent.locks.Lock r2 = r4.f5925a
            r2.unlock()
        L2d:
            return r0
        L2e:
            java.lang.Object r2 = r4.f5930f     // Catch: java.lang.Throwable -> L62
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L62
            com.sec.chaton.j.ab r3 = com.sec.chaton.p037j.EnumC1543ab.CONNECTING     // Catch: java.lang.Throwable -> L5f
            r4.f5931g = r3     // Catch: java.lang.Throwable -> L5f
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L5f
            r4.m6766j()     // Catch: java.lang.Throwable -> L62
            org.jboss.netty.channel.ChannelFuture r2 = r4.m6764h()     // Catch: java.lang.Throwable -> L62
            if (r2 == 0) goto L45
            boolean r2 = r2.isSuccess()     // Catch: java.lang.Throwable -> L62
            if (r2 != 0) goto L6c
        L45:
            java.lang.Object r2 = r4.f5930f     // Catch: java.lang.Throwable -> L62
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L62
            com.sec.chaton.j.ab r3 = com.sec.chaton.p037j.EnumC1543ab.NOT_CONNECT     // Catch: java.lang.Throwable -> L69
            r4.f5931g = r3     // Catch: java.lang.Throwable -> L69
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = "TcpClient.lockSend() - END with auto-connect fail. try tcp error callback"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C3250y.m11450b(r2, r3)     // Catch: java.lang.Throwable -> L62
            r2 = 23
            r5.m6570a(r2, r5)     // Catch: java.lang.Throwable -> L62
            java.util.concurrent.locks.Lock r2 = r4.f5925a
            r2.unlock()
            goto L2d
        L5f:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L5f
            throw r0     // Catch: java.lang.Throwable -> L62
        L62:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r4.f5925a
            r1.unlock()
            throw r0
        L69:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L69
            throw r0     // Catch: java.lang.Throwable -> L62
        L6c:
            com.sec.chaton.j.d.g r2 = r4.f5927c     // Catch: java.lang.Throwable -> L62
            if (r2 == 0) goto L95
            java.lang.Object r1 = r4.f5930f     // Catch: java.lang.Throwable -> L62
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L62
            com.sec.chaton.j.ab r0 = com.sec.chaton.p037j.EnumC1543ab.CONNECT     // Catch: java.lang.Throwable -> L92
            r4.f5931g = r0     // Catch: java.lang.Throwable -> L92
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L92
            java.lang.String r0 = "TcpClient.lockSend(): write req"
            java.lang.String r1 = "TcpClient"
            com.sec.chaton.util.C3250y.m11453c(r0, r1)     // Catch: java.lang.Throwable -> L62
            com.sec.chaton.j.d.g r0 = r4.f5927c     // Catch: java.lang.Throwable -> L62
            long r0 = r0.m6674a(r5)     // Catch: java.lang.Throwable -> L62
        L85:
            java.util.concurrent.locks.Lock r2 = r4.f5925a
            r2.unlock()
            java.lang.String r2 = "TcpClient.lockSend() - END"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C3250y.m11450b(r2, r3)
            goto L2d
        L92:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L92
            throw r0     // Catch: java.lang.Throwable -> L62
        L95:
            java.lang.Object r2 = r4.f5930f     // Catch: java.lang.Throwable -> L62
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L62
            com.sec.chaton.j.ab r3 = com.sec.chaton.p037j.EnumC1543ab.NOT_CONNECT     // Catch: java.lang.Throwable -> Laa
            r4.f5931g = r3     // Catch: java.lang.Throwable -> Laa
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Laa
            java.lang.String r2 = "TcpClient.lockSend(): The connection was not established."
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C3250y.m11453c(r2, r3)     // Catch: java.lang.Throwable -> L62
            r2 = 24
            r5.m6570a(r2, r5)     // Catch: java.lang.Throwable -> L62
            goto L85
        Laa:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Laa
            throw r0     // Catch: java.lang.Throwable -> L62
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p037j.C1596x.m6749a(com.sec.chaton.j.ag, boolean):long");
    }

    /* renamed from: e */
    public static boolean m6762e() {
        return C1544ac.m6543a();
    }

    /* renamed from: f */
    public void m6774f() {
        this.f5925a.lock();
        try {
            if (this.f5927c != null) {
                this.f5927c.m6678c();
            }
        } finally {
            this.f5925a.unlock();
        }
    }
}
