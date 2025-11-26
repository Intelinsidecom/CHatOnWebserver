package com.sec.chaton.p018c;

import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TcpEnvelope.java */
/* renamed from: com.sec.chaton.c.q */
/* loaded from: classes.dex */
public class C0510q {

    /* renamed from: h */
    private static AtomicInteger f1657h = null;

    /* renamed from: a */
    protected String f1658a;

    /* renamed from: b */
    protected int f1659b;

    /* renamed from: c */
    protected GeneratedMessageLite f1660c;

    /* renamed from: d */
    protected long f1661d;

    /* renamed from: e */
    protected C0490c f1662e;

    /* renamed from: f */
    protected long f1663f;

    /* renamed from: g */
    protected long f1664g;

    protected C0510q(C0507n c0507n) {
        this.f1658a = null;
        this.f1659b = -1;
        this.f1660c = null;
        this.f1661d = -1L;
        this.f1662e = null;
        this.f1658a = c0507n.f1643a;
        if (this.f1658a == null) {
            this.f1658a = C1323bs.m4575a().getString("uid", "");
        }
        this.f1659b = c0507n.f1644b;
        this.f1660c = c0507n.f1645c;
        this.f1661d = C0499f.m2521a(this.f1659b, this.f1660c);
        if (!C0499f.m2524a(this.f1660c)) {
            C1341p.m4651a("[LOG_MODE message] GPB Required field is not assigned in MessageMicro: uid=" + this.f1658a + ", type=" + this.f1659b + ", msgId=" + this.f1661d, "");
        }
        this.f1662e = c0507n.f1647e;
        this.f1663f = c0507n.f1648f;
        this.f1664g = c0507n.f1649g;
    }

    /* renamed from: a */
    public String m2568a() {
        return this.f1658a;
    }

    /* renamed from: b */
    public int m2573b() {
        return this.f1659b;
    }

    /* renamed from: c */
    public GeneratedMessageLite m2574c() {
        return this.f1660c;
    }

    /* renamed from: d */
    public long m2575d() {
        return this.f1661d;
    }

    /* renamed from: e */
    public C0490c m2576e() {
        return this.f1662e;
    }

    /* renamed from: a */
    public void m2570a(C0490c c0490c) {
        this.f1662e = c0490c;
    }

    /* renamed from: a */
    public void m2571a(Object obj, Object obj2) {
        if (this.f1662e != null) {
            this.f1662e.m2489a(1, obj, obj2);
        }
    }

    /* renamed from: a */
    public void m2569a(int i, Object obj) {
        if (this.f1662e != null) {
            this.f1662e.m2488a(i, obj);
        }
    }

    /* renamed from: a */
    public boolean m2572a(long j) {
        return this.f1664g < j - this.f1663f;
    }

    /* renamed from: f */
    public static synchronized void m2567f() {
        if (f1657h == null) {
            f1657h = new AtomicInteger(0);
        }
        f1657h.set(0);
    }
}
