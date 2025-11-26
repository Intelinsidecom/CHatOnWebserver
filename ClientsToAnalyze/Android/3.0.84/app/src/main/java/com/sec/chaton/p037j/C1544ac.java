package com.sec.chaton.p037j;

import com.sec.chaton.global.C1493a;
import com.sec.chaton.msgsend.C1759s;
import com.sec.chaton.util.C3158a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3347i;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: TcpContext.java */
/* renamed from: com.sec.chaton.j.ac */
/* loaded from: classes.dex */
public class C1544ac {

    /* renamed from: b */
    protected String f5673b;

    /* renamed from: c */
    protected String f5674c;

    /* renamed from: d */
    protected int f5675d;

    /* renamed from: e */
    protected C3158a f5676e;

    /* renamed from: f */
    protected long f5677f;

    /* renamed from: g */
    C1596x f5678g;

    /* renamed from: h */
    protected long f5679h;

    /* renamed from: j */
    private Map<Integer, C1589q> f5680j;

    /* renamed from: i */
    private static final String f5672i = C1544ac.class.getSimpleName();

    /* renamed from: a */
    static HashMap<String, C1544ac> f5671a = new HashMap<>();

    /* renamed from: a */
    static synchronized C1596x m6542a(C1544ac c1544ac) {
        C1544ac c1544ac2 = f5671a.get(c1544ac.m6556c());
        if (c1544ac2 == null) {
            c1544ac.f5678g = new C1596x(c1544ac);
            f5671a.put(c1544ac.m6556c(), c1544ac);
            C1759s.m7260a(f5672i, "TcpContext, getClient(), created and inserted. %s", c1544ac);
        } else {
            c1544ac2.f5674c = c1544ac.m6557d();
            c1544ac2.f5675d = c1544ac.m6558e();
            c1544ac2.f5676e = c1544ac.m6559f();
            c1544ac2.f5677f = c1544ac.m6560g();
            c1544ac2.f5679h = c1544ac.m6562i();
            c1544ac.f5678g = c1544ac2.m6561h();
        }
        return c1544ac.m6561h();
    }

    /* renamed from: b */
    static synchronized C1544ac m6547b(C1544ac c1544ac) {
        C1544ac c1544ac2 = f5671a.get(c1544ac.m6556c());
        if (c1544ac2 == null) {
            f5671a.put(c1544ac.m6556c(), c1544ac);
            C1759s.m7260a(f5672i, "TcpContext, getContext(), created and inserted. %s", c1544ac);
        } else {
            c1544ac2.f5674c = c1544ac.m6557d();
            c1544ac2.f5675d = c1544ac.m6558e();
            c1544ac2.f5676e = c1544ac.m6559f();
            c1544ac2.f5677f = c1544ac.m6560g();
            c1544ac2.f5679h = c1544ac.m6562i();
            c1544ac.f5678g = c1544ac2.m6561h();
            c1544ac = c1544ac2;
        }
        return c1544ac;
    }

    public String toString() {
        return String.format("%s : id(%s), domain(%s), port(%d), expireTime(%d), aliveTime(%d), ", getClass().getName() + '@' + Integer.toHexString(hashCode()), this.f5673b, this.f5674c, Integer.valueOf(this.f5675d), Long.valueOf(this.f5677f), Long.valueOf(this.f5679h));
    }

    /* renamed from: c */
    static synchronized void m6548c(C1544ac c1544ac) {
        c1544ac.m6561h().m6773d();
    }

    /* renamed from: d */
    static synchronized void m6549d(C1544ac c1544ac) {
        C1544ac c1544acRemove = f5671a.remove(c1544ac.m6556c());
        if (c1544acRemove != null) {
            c1544acRemove.m6550j();
            C1759s.m7260a(f5672i, "TcpContext, removeTcpContext() %s", c1544ac);
        }
        C3250y.m11450b("removeTcpContext: " + c1544ac.m6556c(), "TcpContext");
    }

    /* renamed from: a */
    static synchronized boolean m6544a(int i) {
        boolean zOffer;
        zOffer = C1550ai.m6585a().offer(new RunnableC1545ad(i));
        if (!zOffer) {
            C3250y.m11450b("TcpClient.expiredCollectIMPL() : queue offer fail.", f5672i);
        }
        return zOffer;
    }

    /* renamed from: b */
    static synchronized int m6546b(int i) {
        int i2;
        int i3 = 0;
        Iterator it = new ArrayList(f5671a.values()).iterator();
        while (true) {
            i2 = i3;
            if (it.hasNext()) {
                ((C1544ac) it.next()).m6561h().m6767a(i);
                i3 = i2 + 1;
            }
        }
        return i2;
    }

    /* renamed from: a */
    static synchronized boolean m6543a() {
        boolean zOffer;
        zOffer = C1550ai.m6585a().offer(new RunnableC1546ae());
        if (!zOffer) {
            C3250y.m11450b("TcpClient.expiredCollectIMPL() : queue offer fail.", f5672i);
        }
        return zOffer;
    }

    /* renamed from: b */
    static synchronized int m6545b() {
        int i;
        int i2 = 0;
        Iterator<C1544ac> it = f5671a.values().iterator();
        while (true) {
            i = i2;
            if (it.hasNext()) {
                it.next().m6561h().m6774f();
                i2 = i + 1;
            }
        }
        return i;
    }

    public boolean equals(Object obj) {
        try {
            if (obj instanceof C1544ac) {
                return this.f5673b.equals(((C1544ac) obj).m6556c());
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    protected C1544ac(C1547af c1547af) throws NoSuchFieldException {
        this.f5673b = null;
        this.f5674c = null;
        this.f5675d = Integer.MIN_VALUE;
        this.f5676e = null;
        this.f5677f = -2147483648L;
        this.f5678g = null;
        this.f5679h = 0L;
        if (c1547af.f5682a == null) {
            throw new NoSuchFieldException("No Context ID");
        }
        this.f5673b = c1547af.f5682a;
        if (c1547af.f5683b == null) {
            throw new NoSuchFieldException("No Domain");
        }
        if (c1547af.f5683b.length() == 0) {
            throw new NoSuchFieldException("No Domain actually. Domain length is 0");
        }
        this.f5674c = c1547af.f5683b;
        if (c1547af.f5684c == Integer.MIN_VALUE) {
            throw new NoSuchFieldException("No Port");
        }
        this.f5675d = c1547af.f5684c;
        this.f5676e = c1547af.f5685d;
        this.f5677f = c1547af.f5686e;
        this.f5679h = Long.MAX_VALUE;
        this.f5680j = new HashMap();
        this.f5678g = m6542a(this);
    }

    /* renamed from: c */
    public String m6556c() {
        return this.f5673b;
    }

    /* renamed from: d */
    public String m6557d() {
        return this.f5674c;
    }

    /* renamed from: e */
    public int m6558e() {
        if (C1493a.m6463a("wifi_80_port") && C3347i.m11787j()) {
            int iIntValue = C3159aa.m10962a().m10978a(Config.PROVIDER_PATH_WIFI_PORT, Integer.valueOf(this.f5675d)).intValue();
            if (iIntValue == C3194bi.f11541a) {
                iIntValue = this.f5675d;
            } else if (iIntValue == C3194bi.f11542b) {
                iIntValue = C3194bi.m11150d();
                C3159aa.m10962a().m10984b(Config.PROVIDER_PATH_WIFI_PORT, Integer.valueOf(iIntValue));
                if (iIntValue == C3194bi.f11542b) {
                    iIntValue = C3159aa.m10962a().m10978a("primary_message_wifi_port", (Integer) 80).intValue();
                }
            }
            C3250y.m11450b("[WIFI 80] WiFi " + iIntValue, "TcpContext");
            return iIntValue;
        }
        C3250y.m11450b("[WIFI 80] dataNetwork getPort::" + this.f5675d, "TcpContext");
        return this.f5675d;
    }

    /* renamed from: f */
    public C3158a m6559f() {
        return this.f5676e;
    }

    /* renamed from: g */
    public long m6560g() {
        return this.f5677f;
    }

    /* renamed from: h */
    C1596x m6561h() {
        return this.f5678g;
    }

    /* renamed from: i */
    public long m6562i() {
        return this.f5679h;
    }

    /* renamed from: a */
    public synchronized void m6553a(String str, int i) {
        this.f5674c = str;
        this.f5675d = i;
    }

    /* renamed from: a */
    public void m6552a(long j) {
        C1544ac c1544acM6547b = m6547b(this);
        this.f5679h = j;
        c1544acM6547b.f5679h = j;
    }

    /* renamed from: a */
    public synchronized void m6554a(byte[] bArr, byte[] bArr2) {
        this.f5676e = new C3158a(bArr, bArr2);
    }

    /* renamed from: a */
    public void m6551a(int i, C1589q c1589q) {
        this.f5680j.put(Integer.valueOf(i), c1589q);
    }

    /* renamed from: c */
    public C1589q m6555c(int i) {
        return this.f5680j.get(Integer.valueOf(i));
    }

    /* renamed from: j */
    private void m6550j() {
        if (this.f5680j != null && !this.f5680j.isEmpty()) {
            this.f5680j.clear();
        }
    }
}
