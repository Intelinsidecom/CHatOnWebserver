package com.sec.chaton.p067j;

import android.os.SystemClock;
import com.sec.chaton.p051c.C1433g;
import com.sec.chaton.p067j.p071d.C2450g;
import com.sec.chaton.p067j.p071d.C2452i;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.dlc.api.IDlcApi;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

/* compiled from: TcpClient.java */
/* renamed from: com.sec.chaton.j.af */
/* loaded from: classes.dex */
public class C2417af {

    /* renamed from: b */
    protected C2422ak f8597b;

    /* renamed from: c */
    protected C2450g f8598c;

    /* renamed from: d */
    protected ClientBootstrap f8599d;

    /* renamed from: e */
    ExecutorService f8600e;

    /* renamed from: f */
    ExecutorService f8601f;

    /* renamed from: a */
    protected Lock f8596a = new ReentrantLock();

    /* renamed from: g */
    protected Object f8602g = new Object();

    /* renamed from: h */
    protected EnumC2421aj f8603h = EnumC2421aj.NOT_CONNECT;

    public C2417af(C2422ak c2422ak) {
        this.f8597b = c2422ak;
    }

    /* renamed from: a */
    public static boolean m10450a(C2422ak c2422ak) {
        return C2422ak.m10478a(c2422ak).m10469a();
    }

    /* renamed from: a */
    public boolean m10469a() {
        boolean z;
        synchronized (this.f8602g) {
            z = this.f8603h == EnumC2421aj.CONNECT;
        }
        return z;
    }

    /* renamed from: b */
    public static boolean m10453b(C2422ak c2422ak) {
        return C2422ak.m10478a(c2422ak).m10470b();
    }

    /* renamed from: b */
    public boolean m10470b() {
        boolean z;
        synchronized (this.f8602g) {
            z = this.f8603h != EnumC2421aj.NOT_CONNECT;
        }
        return z;
    }

    /* renamed from: c */
    public static void m10455c(C2422ak c2422ak) {
        C2422ak.m10478a(c2422ak).m10467a(C2428aq.m10527b(), 33000L);
    }

    /* renamed from: a */
    public void m10467a(ExecutorService executorService, long j) {
        if (!C2428aq.m10526a(new C2418ag(this, executorService, "reconnectIMPL", SystemClock.elapsedRealtime(), j)) && C4904y.f17872b) {
            C4904y.m18639b("tcp_queue, TcpClient.reconnectIMPL() : queue offer fail.", "TcpClient");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m10461g() {
        C4904y.m18639b("TcpClient.lockReconnect() - STT", "TcpClient");
        synchronized (this.f8602g) {
            this.f8603h = EnumC2421aj.CONNECTING;
        }
        this.f8596a.lock();
        try {
            m10464j();
            ChannelFuture channelFutureM10462h = m10462h();
            if (channelFutureM10462h == null || !channelFutureM10462h.isSuccess()) {
                synchronized (this.f8602g) {
                    this.f8603h = EnumC2421aj.NOT_CONNECT;
                }
                C4904y.m18639b("TcpClient.lockReconnect() - END", "TcpClient");
                return;
            }
            synchronized (this.f8602g) {
                this.f8603h = EnumC2421aj.CONNECT;
            }
            C4904y.m18639b("TcpClient.lockReconnect() - END", "TcpClient");
        } finally {
            this.f8596a.unlock();
        }
    }

    /* renamed from: h */
    private ChannelFuture m10462h() {
        try {
            int iM10678a = C2471v.m10678a(CommonApplication.m18732r(), this.f8597b.m10493d());
            if (iM10678a < 0) {
                switch (iM10678a) {
                    case IDlcApi.RC_APPLICATION_BLOCKED /* -3 */:
                        C4904y.m18639b("TcpClient.nonLockConnect(): Network isn't available.", "TcpClient");
                        break;
                    case IDlcApi.RC_SVC_UNAVAILABLE /* -2 */:
                    default:
                        C4904y.m18639b("TcpClient.nonLockConnect(): unchecked", "TcpClient");
                        break;
                    case -1:
                        C4904y.m18639b("TcpClient.nonLockConnect(): host lookup failed.", "TcpClient");
                        break;
                }
                return null;
            }
            if (this.f8599d == null || this.f8598c == null) {
                C4904y.m18639b("tcp_channel_worker, creating ThreadPool (pre), " + this.f8597b, "TcpClient");
                this.f8600e = Executors.newCachedThreadPool();
                this.f8601f = Executors.newCachedThreadPool();
                C4904y.m18639b("tcp_channel_worker, creating ThreadPool (post), " + this.f8597b, "TcpClient");
                this.f8599d = new ClientBootstrap(new NioClientSocketChannelFactory(this.f8600e, this.f8601f));
                this.f8598c = new C2450g(this.f8597b, this.f8599d);
                this.f8599d.setPipeline(new C2452i(this.f8597b, this.f8598c).getPipeline());
                this.f8599d.setOption("tcpNoDelay", true);
                this.f8599d.setOption("keepAlive", true);
                this.f8599d.setOption("connectTimeoutMillis", Integer.valueOf(C1433g.m7528b()));
            }
            C4904y.m18641c("TcpClient.nonLockConnect(): Connetion Tried", "TcpClient");
            ChannelFuture channelFutureConnect = this.f8599d.connect(new InetSocketAddress(this.f8597b.m10493d(), this.f8597b.m10494e()));
            channelFutureConnect.awaitUninterruptibly();
            if (!channelFutureConnect.isSuccess()) {
                C4904y.m18641c("TcpClient.nonLockConnect(): Connetion Fail", "TcpClient");
                if (channelFutureConnect.getCause() != null) {
                    C4904y.m18639b("Point 1", "TcpClient");
                    C4904y.m18635a(channelFutureConnect.getCause(), "TcpClient");
                }
                C4904y.m18639b("Point 2", "TcpClient");
                m10464j();
            } else if (channelFutureConnect.isCancelled()) {
                C4904y.m18641c("TcpClient.nonLockConnect(): Connetion Cancelled", "TcpClient");
                m10464j();
            } else {
                C4904y.m18641c("TcpClient.nonLockConnect(): Connetion Success", "TcpClient");
            }
            return channelFutureConnect;
        } catch (Exception e) {
            C4904y.m18635a(e, "TcpClient");
            return null;
        }
    }

    /* renamed from: c */
    public static boolean m10456c() {
        return C2422ak.m10480a(34);
    }

    /* renamed from: d */
    public static void m10458d(C2422ak c2422ak) {
        C2422ak.m10484c(c2422ak);
    }

    /* renamed from: d */
    public void m10471d() {
        m10466a(C2428aq.m10527b());
    }

    /* renamed from: e */
    public static void m10459e(C2422ak c2422ak) {
        C2422ak.m10485d(c2422ak);
    }

    /* renamed from: a */
    public void m10466a(ExecutorService executorService) {
        if (!C2428aq.m10526a(new C2419ah(this, executorService, "closeIMPL")) && C4904y.f17872b) {
            C4904y.m18639b("tcp_queue, TcpClient.closeIMPL() : queue offer fail.", "TcpClient");
        }
    }

    /* renamed from: a */
    public void m10465a(int i) {
        m10451b(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m10463i() {
        m10451b(34);
    }

    /* renamed from: b */
    private void m10451b(int i) {
        this.f8596a.lock();
        try {
            synchronized (this.f8602g) {
                this.f8603h = EnumC2421aj.NOT_CONNECT;
            }
            m10457c(i);
        } finally {
            this.f8596a.unlock();
        }
    }

    /* renamed from: j */
    private boolean m10464j() {
        return m10457c(34);
    }

    /* renamed from: c */
    private boolean m10457c(int i) {
        C4904y.m18639b("TcpClient.nonLockClose() - STT", "TcpClient");
        if (this.f8598c != null) {
            C4904y.m18639b("TcpClient.nonLockClose() - mChannelHandler", "TcpClient");
            this.f8598c.m10620a(i);
            this.f8598c = null;
        }
        if (this.f8599d != null) {
            C4904y.m18639b("TcpClient.nonLockClose() - mBootstrap", "TcpClient");
            if (this.f8600e != null) {
                boolean zM10454b = m10454b(this.f8600e);
                this.f8600e = null;
                C4904y.m18639b("tcp_channel_worker, release ThreadPool boss, result: " + zM10454b + ", " + this.f8597b, "TcpClient");
            }
            if (this.f8601f != null) {
                boolean zM10454b2 = m10454b(this.f8601f);
                this.f8601f = null;
                C4904y.m18639b("tcp_channel_worker, release ThreadPool worker, result: " + zM10454b2 + ", " + this.f8597b, "TcpClient");
            }
            this.f8599d = null;
        }
        C4904y.m18639b("TcpClient.nonLockClose() - END", "TcpClient");
        return true;
    }

    /* renamed from: b */
    private boolean m10454b(ExecutorService executorService) {
        boolean z = true;
        if (executorService == null) {
            return false;
        }
        int i = 0;
        boolean z2 = false;
        while (true) {
            if (i >= 30) {
                z = false;
                break;
            }
            try {
                C4904y.m18639b("tcp_channel_worker, releaseThreadPool(), try shutdownNow() : " + i + ", " + this.f8597b, "TcpClient");
                executorService.shutdownNow();
            } catch (NullPointerException e) {
                C4904y.m18639b("tcp_channel_worker, releaseThreadPool(), error NullPointerException #1: ", "TcpClient");
            } catch (SecurityException e2) {
                C4904y.m18639b("tcp_channel_worker, releaseThreadPool(), error SecurityException #1: ", "TcpClient");
                try {
                    C4904y.m18639b("tcp_channel_worker, releaseThreadPool(), try shutdown() : " + i + ", " + this.f8597b, "TcpClient");
                    executorService.shutdown();
                } catch (NullPointerException e3) {
                    C4904y.m18639b("tcp_channel_worker, releaseThreadPool(), error NullPointerException #2: ", "TcpClient");
                } catch (SecurityException e4) {
                    C4904y.m18639b("tcp_channel_worker, releaseThreadPool(), error SecurityException #2: ", "TcpClient");
                    z = false;
                }
            }
            try {
            } catch (InterruptedException e5) {
                C4904y.m18639b("tcp_channel_worker, releaseThreadPool(), InterruptedException. ", "TcpClient");
                z2 = true;
            }
            if (!executorService.awaitTermination(100L, TimeUnit.MILLISECONDS)) {
                continue;
                i++;
            } else {
                C4904y.m18639b("tcp_channel_worker, releaseThreadPool(), terminated (OK). ", "TcpClient");
                break;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return z;
    }

    /* renamed from: a */
    public static void m10449a(C2422ak c2422ak, C2426ao c2426ao) {
        C2422ak.m10478a(c2422ak).m10468a(C2428aq.m10527b(), c2426ao, 33000L, true);
    }

    /* renamed from: a */
    public void m10468a(ExecutorService executorService, C2426ao c2426ao, long j, boolean z) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C4904y.m18639b("tcp_queue, sendIMPL - offerTime : " + String.valueOf(jElapsedRealtime), getClass().getSimpleName());
        String simpleName = null;
        if (c2426ao.m10513c() != null) {
            simpleName = c2426ao.m10513c().getClass().getSimpleName();
        }
        if (!C2428aq.m10526a(new C2420ai(this, executorService, simpleName, c2426ao, jElapsedRealtime, j, z))) {
            if (C4904y.f17872b) {
                C4904y.m18639b("tcp_queue, TcpClient.sendIMPL() : queue offer fail. try tcp error callback.", "TcpClient");
            }
            c2426ao.m10508a(33, c2426ao);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006f A[Catch: all -> 0x0065, TryCatch #2 {all -> 0x0065, blocks: (B:3:0x0010, B:5:0x0014, B:35:0x006f, B:37:0x0073, B:38:0x0075, B:41:0x007b, B:45:0x009b, B:46:0x009c, B:47:0x009e, B:50:0x00a4, B:54:0x00b5, B:8:0x001e, B:12:0x0032, B:13:0x0034, B:16:0x003a, B:18:0x0043, B:20:0x0049, B:21:0x004b, B:24:0x0051, B:34:0x006e, B:28:0x0064, B:14:0x0035, B:15:0x0039, B:48:0x009f, B:49:0x00a3, B:39:0x0076, B:40:0x007a, B:22:0x004c, B:23:0x0050), top: B:59:0x0010, inners: #0, #1, #3, #4 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long m10447a(com.sec.chaton.p067j.C2426ao r5, boolean r6) {
        /*
            r4 = this;
            r0 = -1
            java.lang.String r2 = "TcpClient.lockSend() - STT"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C4904y.m18639b(r2, r3)
            java.util.concurrent.locks.Lock r2 = r4.f8596a
            r2.lock()
            com.sec.chaton.j.d.g r2 = r4.f8598c     // Catch: java.lang.Throwable -> L65
            if (r2 == 0) goto L1c
            com.sec.chaton.j.d.g r2 = r4.f8598c     // Catch: java.lang.Throwable -> L65
            boolean r2 = r2.m10621b()     // Catch: java.lang.Throwable -> L65
            if (r2 != 0) goto L6f
        L1c:
            if (r6 != 0) goto L32
            java.lang.String r2 = "TcpClient.lockSend() - END with no auto-connect. try tcp error callback"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C4904y.m18639b(r2, r3)     // Catch: java.lang.Throwable -> L65
            r2 = 24
            r5.m10508a(r2, r5)     // Catch: java.lang.Throwable -> L65
            java.util.concurrent.locks.Lock r2 = r4.f8596a
        L2e:
            r2.unlock()
        L31:
            return r0
        L32:
            java.lang.Object r2 = r4.f8602g     // Catch: java.lang.Throwable -> L65
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L65
            com.sec.chaton.j.aj r3 = com.sec.chaton.p067j.EnumC2421aj.CONNECTING     // Catch: java.lang.Throwable -> L62
            r4.f8603h = r3     // Catch: java.lang.Throwable -> L62
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L62
            r4.m10464j()     // Catch: java.lang.Throwable -> L65
            org.jboss.netty.channel.ChannelFuture r2 = r4.m10462h()     // Catch: java.lang.Throwable -> L65
            if (r2 == 0) goto L49
            boolean r2 = r2.isSuccess()     // Catch: java.lang.Throwable -> L65
            if (r2 != 0) goto L6f
        L49:
            java.lang.Object r2 = r4.f8602g     // Catch: java.lang.Throwable -> L65
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L65
            com.sec.chaton.j.aj r3 = com.sec.chaton.p067j.EnumC2421aj.NOT_CONNECT     // Catch: java.lang.Throwable -> L6c
            r4.f8603h = r3     // Catch: java.lang.Throwable -> L6c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L6c
            java.lang.String r2 = "TcpClient.lockSend() - END with auto-connect fail. try tcp error callback"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C4904y.m18639b(r2, r3)     // Catch: java.lang.Throwable -> L65
            r2 = 23
            r5.m10508a(r2, r5)     // Catch: java.lang.Throwable -> L65
            java.util.concurrent.locks.Lock r2 = r4.f8596a
            goto L2e
        L62:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L62
            throw r0     // Catch: java.lang.Throwable -> L65
        L65:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r4.f8596a
            r1.unlock()
            throw r0
        L6c:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L6c
            throw r0     // Catch: java.lang.Throwable -> L65
        L6f:
            com.sec.chaton.j.d.g r2 = r4.f8598c     // Catch: java.lang.Throwable -> L65
            if (r2 == 0) goto L9c
            java.lang.Object r1 = r4.f8602g     // Catch: java.lang.Throwable -> L65
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L65
            com.sec.chaton.j.aj r0 = com.sec.chaton.p067j.EnumC2421aj.CONNECT     // Catch: java.lang.Throwable -> L99
            r4.f8603h = r0     // Catch: java.lang.Throwable -> L99
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L99
            java.lang.String r0 = "TcpClient.lockSend(): write req"
            java.lang.String r1 = "TcpClient"
            com.sec.chaton.util.C4904y.m18641c(r0, r1)     // Catch: java.lang.Throwable -> L65
            com.sec.chaton.j.d.g r0 = r4.f8598c     // Catch: java.lang.Throwable -> L65
            long r0 = r0.m10618a(r5)     // Catch: java.lang.Throwable -> L65
        L8a:
            java.util.concurrent.locks.Lock r2 = r4.f8596a
            r2.unlock()
            java.lang.String r2 = "TcpClient.lockSend() - END"
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C4904y.m18639b(r2, r3)
            goto L31
        L99:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L99
            throw r0     // Catch: java.lang.Throwable -> L65
        L9c:
            java.lang.Object r2 = r4.f8602g     // Catch: java.lang.Throwable -> L65
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L65
            com.sec.chaton.j.aj r3 = com.sec.chaton.p067j.EnumC2421aj.NOT_CONNECT     // Catch: java.lang.Throwable -> Lb3
            r4.f8603h = r3     // Catch: java.lang.Throwable -> Lb3
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r2 = "TcpClient.lockSend(): The connection was not established."
            java.lang.String r3 = "TcpClient"
            com.sec.chaton.util.C4904y.m18641c(r2, r3)     // Catch: java.lang.Throwable -> L65
            r2 = 24
            r5.m10508a(r2, r5)     // Catch: java.lang.Throwable -> L65
            goto L8a
        Lb3:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb3
            throw r0     // Catch: java.lang.Throwable -> L65
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p067j.C2417af.m10447a(com.sec.chaton.j.ao, boolean):long");
    }

    /* renamed from: e */
    public static boolean m10460e() {
        return C2422ak.m10479a();
    }

    /* renamed from: f */
    public void m10472f() {
        this.f8596a.lock();
        try {
            if (this.f8598c != null) {
                this.f8598c.m10622c();
            }
        } finally {
            this.f8596a.unlock();
        }
    }
}
