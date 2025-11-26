package com.sec.chaton.p018c.p020b;

import android.os.PowerManager;
import android.os.SystemClock;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.p018c.C0499f;
import com.sec.chaton.p018c.C0505l;
import com.sec.chaton.p018c.C0507n;
import com.sec.chaton.p018c.C0510q;
import com.sec.chaton.util.C1322br;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;

/* compiled from: TcpEnvelopeBicoder.java */
/* renamed from: com.sec.chaton.c.b.g */
/* loaded from: classes.dex */
public class C0486g extends AbstractC0487h {

    /* renamed from: a */
    protected C0505l f1563a;

    /* renamed from: b */
    private PowerManager.WakeLock f1564b;

    /* renamed from: c */
    private Map f1565c = new Hashtable();

    /* renamed from: d */
    private C1322br f1566d;

    /* renamed from: e */
    private long f1567e;

    public C0486g(C0505l c0505l, PowerManager.WakeLock wakeLock) {
        this.f1566d = null;
        this.f1567e = Long.MAX_VALUE;
        this.f1563a = c0505l;
        this.f1564b = wakeLock;
        this.f1566d = this.f1563a.m2551f();
        this.f1567e = this.f1563a.m2552g();
    }

    @Override // com.sec.chaton.p018c.p020b.AbstractC0487h
    /* renamed from: a */
    protected Object mo2479a(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        C0488i c0488i;
        PowerManager.WakeLock wakeLock;
        if (this.f1564b != null) {
            this.f1564b.acquire();
        }
        try {
            C0510q c0510q = (C0510q) obj;
            if (C0499f.m2523a(c0510q.m2573b())) {
                m2481a(c0510q);
            }
            if (this.f1566d == null && this.f1563a != null) {
                this.f1566d = this.f1563a.m2551f();
            }
            if (this.f1566d == null) {
                c0488i = new C0488i(c0510q.m2568a(), 1, c0510q.m2573b(), c0510q.m2574c().toByteArray());
                if (this.f1564b != null) {
                    wakeLock = this.f1564b;
                    wakeLock.release();
                }
            } else {
                c0488i = new C0488i(c0510q.m2568a(), 0, c0510q.m2573b(), this.f1566d.m4573b(c0510q.m2574c().toByteArray()));
                if (this.f1564b != null) {
                    wakeLock = this.f1564b;
                    wakeLock.release();
                }
            }
            return c0488i;
        } catch (Throwable th) {
            if (this.f1564b != null) {
                this.f1564b.release();
            }
            throw th;
        }
    }

    @Override // com.sec.chaton.p018c.p020b.AbstractC0487h
    /* renamed from: b */
    protected Object mo2482b(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        try {
            return m2477a((C0488i) obj);
        } catch (Exception e) {
            C1341p.m4652a((Throwable) e);
            return null;
        }
    }

    /* renamed from: a */
    private C0510q m2477a(C0488i c0488i) {
        GeneratedMessageLite generatedMessageLiteM2522a;
        try {
            if ((c0488i.m2485b() & 1) == 0) {
                try {
                    generatedMessageLiteM2522a = C0499f.m2522a(c0488i.m2486c(), this.f1566d.m4574c(c0488i.m2487d()));
                } catch (Exception e) {
                    C1341p.m4652a((Throwable) e);
                    return null;
                }
            } else {
                generatedMessageLiteM2522a = C0499f.m2522a(c0488i.m2486c(), c0488i.m2487d());
            }
            long jM2521a = C0499f.m2521a(c0488i.m2486c(), generatedMessageLiteM2522a);
            C0507n c0507nM2558a = new C0507n().m2560a(c0488i.m2484a()).m2556a(c0488i.m2486c()).m2558a(generatedMessageLiteM2522a);
            if (!C0499f.m2523a(c0488i.m2486c())) {
                C1341p.m4658b("Received msgID is " + jM2521a, getClass().getSimpleName());
                if (jM2521a == -1) {
                    c0507nM2558a.m2559a(this.f1563a.f1640m);
                    C0510q c0510qM2561b = c0507nM2558a.m2561b();
                    c0510qM2561b.m2571a((Object) null, c0510qM2561b);
                    return c0510qM2561b;
                }
                C0510q c0510qM2478a = m2478a(jM2521a);
                if (c0510qM2478a == null) {
                    return null;
                }
                c0507nM2558a.m2559a(c0510qM2478a.m2576e());
                C0510q c0510qM2561b2 = c0507nM2558a.m2561b();
                c0510qM2561b2.m2571a(c0510qM2478a, c0510qM2561b2);
                return c0510qM2561b2;
            }
            try {
                switch (c0488i.m2486c()) {
                    case 6:
                        if (this.f1563a != null) {
                            c0507nM2558a.m2559a(this.f1563a.f1638k);
                            break;
                        }
                        break;
                    case 10:
                        if (this.f1563a != null) {
                            c0507nM2558a.m2559a(this.f1563a.f1637j);
                            break;
                        }
                        break;
                    case 14:
                        if (this.f1563a != null) {
                            c0507nM2558a.m2559a(this.f1563a.f1639l);
                            break;
                        }
                        break;
                    case 16:
                        if (this.f1563a != null) {
                            c0507nM2558a.m2559a(this.f1563a.f1636i);
                            break;
                        }
                        break;
                    default:
                        C1341p.m4659c("Should not reach here.");
                        break;
                }
            } catch (Exception e2) {
                C1341p.m4652a((Throwable) e2);
            }
            C0510q c0510qM2561b3 = c0507nM2558a.m2561b();
            c0510qM2561b3.m2571a((Object) null, c0510qM2561b3);
            return c0510qM2561b3;
        } catch (Exception e3) {
            C1341p.m4652a((Throwable) e3);
            return null;
        }
    }

    /* renamed from: a */
    public synchronized C0510q m2478a(long j) {
        C0510q c0510q;
        c0510q = (C0510q) this.f1565c.remove(Long.valueOf(j));
        if (c0510q == null) {
            C1341p.m4658b(getClass().getSimpleName() + ".extractReqFormHistory() -> already handled error callback", getClass().getSimpleName());
            c0510q = null;
        } else if (c0510q.m2575d() != j) {
            c0510q = null;
        } else if (c0510q.m2573b() == -1) {
            C1341p.m4659c("Should not reach here.");
            c0510q = null;
        }
        return c0510q;
    }

    /* renamed from: a */
    public synchronized void m2481a(C0510q c0510q) {
        this.f1565c.put(Long.valueOf(c0510q.m2575d()), c0510q);
    }

    /* renamed from: a */
    public synchronized void m2480a() {
        for (C0510q c0510q : this.f1565c.values()) {
            C1341p.m4658b("TcpEnvelopeBicoder.kickHistory() -> try tcp error callback", getClass().getSimpleName());
            c0510q.m2569a(22, c0510q);
        }
        this.f1565c.clear();
    }

    /* renamed from: b */
    public synchronized void m2483b() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        ArrayList arrayList = new ArrayList(this.f1565c.values());
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                C0510q c0510q = (C0510q) it.next();
                if (c0510q != null && c0510q.m2572a(jElapsedRealtime)) {
                    i++;
                    this.f1565c.remove(Long.valueOf(c0510q.m2575d()));
                    C1341p.m4658b("TcpEnvelopeBicoder.expiredCollector() -> try tcp error callback", getClass().getSimpleName());
                    c0510q.m2569a(21, c0510q);
                }
            }
        }
    }
}
