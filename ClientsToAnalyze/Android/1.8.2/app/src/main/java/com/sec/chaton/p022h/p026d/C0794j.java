package com.sec.chaton.p022h.p026d;

import android.os.PowerManager;
import android.os.SystemClock;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.C0229at;
import com.sec.chaton.p022h.C0770ab;
import com.sec.chaton.p022h.C0771ac;
import com.sec.chaton.p022h.C0797g;
import com.sec.chaton.p022h.C0816z;
import com.sec.chaton.util.C1771c;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;

/* compiled from: TcpEnvelopeBicoder.java */
/* renamed from: com.sec.chaton.h.d.j */
/* loaded from: classes.dex */
public class C0794j extends AbstractC0787c {

    /* renamed from: a */
    protected C0816z f2918a;

    /* renamed from: b */
    private PowerManager.WakeLock f2919b;

    /* renamed from: c */
    private Map f2920c = new Hashtable();

    /* renamed from: d */
    private C1771c f2921d;

    /* renamed from: e */
    private long f2922e;

    public C0794j(C0816z c0816z, PowerManager.WakeLock wakeLock) {
        this.f2921d = null;
        this.f2922e = Long.MAX_VALUE;
        this.f2918a = c0816z;
        this.f2919b = wakeLock;
        this.f2921d = this.f2918a.m3457f();
        this.f2922e = this.f2918a.m3458g();
    }

    @Override // com.sec.chaton.p022h.p026d.AbstractC0787c
    /* renamed from: a */
    protected Object mo3370a(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        C0785a c0785a;
        PowerManager.WakeLock wakeLock;
        if (this.f2919b != null) {
            this.f2919b.acquire();
        }
        try {
            C0770ab c0770ab = (C0770ab) obj;
            if (C0797g.m3391a(c0770ab.m3289b())) {
                m3381a(c0770ab);
            }
            if (this.f2921d == null && this.f2918a != null) {
                this.f2921d = this.f2918a.m3457f();
            }
            if (this.f2921d == null) {
                c0785a = new C0785a(c0770ab.m3284a(), 1, c0770ab.m3289b(), c0770ab.m3290c().toByteArray());
                if (this.f2919b != null) {
                    wakeLock = this.f2919b;
                    wakeLock.release();
                }
            } else {
                c0785a = new C0785a(c0770ab.m3284a(), 0, c0770ab.m3289b(), this.f2921d.m6015b(c0770ab.m3290c().toByteArray()));
                if (this.f2919b != null) {
                    wakeLock = this.f2919b;
                    wakeLock.release();
                }
            }
            return c0785a;
        } catch (Throwable th) {
            if (this.f2919b != null) {
                this.f2919b.release();
            }
            throw th;
        }
    }

    @Override // com.sec.chaton.p022h.p026d.AbstractC0787c
    /* renamed from: b */
    protected Object mo3371b(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        try {
            return m3378a((C0785a) obj);
        } catch (Exception e) {
            C1786r.m6055a((Throwable) e);
            return null;
        }
    }

    /* renamed from: a */
    private C0770ab m3378a(C0785a c0785a) {
        GeneratedMessageLite generatedMessageLiteM3390a;
        try {
            if ((c0785a.m3367b() & 1) == 0) {
                try {
                    generatedMessageLiteM3390a = C0797g.m3390a(c0785a.m3368c(), this.f2921d.m6016c(c0785a.m3369d()));
                } catch (Exception e) {
                    C1786r.m6055a((Throwable) e);
                    return null;
                }
            } else {
                generatedMessageLiteM3390a = C0797g.m3390a(c0785a.m3368c(), c0785a.m3369d());
            }
            long jM3389a = C0797g.m3389a(c0785a.m3368c(), generatedMessageLiteM3390a);
            C0771ac c0771acM3296a = new C0771ac().m3298a(c0785a.m3366a()).m3294a(c0785a.m3368c()).m3296a(generatedMessageLiteM3390a);
            if (!C0797g.m3391a(c0785a.m3368c())) {
                C1786r.m6061b("Received msgID is " + jM3389a, getClass().getSimpleName());
                if (jM3389a == -1) {
                    c0771acM3296a.m3297a(this.f2918a.f3007m);
                    C0770ab c0770abM3299b = c0771acM3296a.m3299b();
                    c0770abM3299b.m3287a((Object) null, c0770abM3299b);
                    return c0770abM3299b;
                }
                C0770ab c0770abM3379a = m3379a(jM3389a);
                if (c0770abM3379a == null) {
                    return null;
                }
                c0771acM3296a.m3297a(c0770abM3379a.m3292e());
                C0770ab c0770abM3299b2 = c0771acM3296a.m3299b();
                c0770abM3299b2.m3287a(c0770abM3379a, c0770abM3299b2);
                return c0770abM3299b2;
            }
            try {
                switch (c0785a.m3368c()) {
                    case 6:
                        if (this.f2918a != null) {
                            c0771acM3296a.m3297a(this.f2918a.f3005k);
                            break;
                        }
                        break;
                    case 10:
                        if (this.f2918a != null) {
                            c0771acM3296a.m3297a(this.f2918a.f3004j);
                            break;
                        }
                        break;
                    case C0229at.HorizontalSrollView_android_paddingLeft /* 14 */:
                        if (this.f2918a != null) {
                            c0771acM3296a.m3297a(this.f2918a.f3006l);
                            break;
                        }
                        break;
                    case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                        if (this.f2918a != null) {
                            c0771acM3296a.m3297a(this.f2918a.f3003i);
                            break;
                        }
                        break;
                    default:
                        C1786r.m6064d("Should not reach here.");
                        break;
                }
            } catch (Exception e2) {
                C1786r.m6055a((Throwable) e2);
            }
            C0770ab c0770abM3299b3 = c0771acM3296a.m3299b();
            c0770abM3299b3.m3287a((Object) null, c0770abM3299b3);
            return c0770abM3299b3;
        } catch (Exception e3) {
            C1786r.m6055a((Throwable) e3);
            return null;
        }
    }

    /* renamed from: a */
    public synchronized C0770ab m3379a(long j) {
        C0770ab c0770ab;
        c0770ab = (C0770ab) this.f2920c.remove(Long.valueOf(j));
        if (c0770ab == null) {
            C1786r.m6061b(getClass().getSimpleName() + ".extractReqFormHistory() -> already handled error callback", getClass().getSimpleName());
            c0770ab = null;
        } else if (c0770ab.m3291d() != j) {
            c0770ab = null;
        } else if (c0770ab.m3289b() == -1) {
            C1786r.m6064d("Should not reach here.");
            c0770ab = null;
        }
        return c0770ab;
    }

    /* renamed from: a */
    public synchronized void m3381a(C0770ab c0770ab) {
        this.f2920c.put(Long.valueOf(c0770ab.m3291d()), c0770ab);
    }

    /* renamed from: a */
    public synchronized void m3380a() {
        for (C0770ab c0770ab : this.f2920c.values()) {
            C1786r.m6061b("TcpEnvelopeBicoder.kickHistory() -> try tcp error callback", getClass().getSimpleName());
            c0770ab.m3285a(22, c0770ab);
        }
        this.f2920c.clear();
    }

    /* renamed from: b */
    public synchronized void m3382b() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        ArrayList arrayList = new ArrayList(this.f2920c.values());
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                C0770ab c0770ab = (C0770ab) it.next();
                if (c0770ab != null && c0770ab.m3288a(jElapsedRealtime)) {
                    i++;
                    this.f2920c.remove(Long.valueOf(c0770ab.m3291d()));
                    C1786r.m6061b("TcpEnvelopeBicoder.expiredCollector() -> try tcp error callback", getClass().getSimpleName());
                    c0770ab.m3285a(21, c0770ab);
                }
            }
        }
    }
}
