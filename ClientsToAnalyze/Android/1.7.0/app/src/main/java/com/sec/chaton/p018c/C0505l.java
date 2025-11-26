package com.sec.chaton.p018c;

import com.sec.chaton.util.C1322br;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: TcpContext.java */
/* renamed from: com.sec.chaton.c.l */
/* loaded from: classes.dex */
public class C0505l {

    /* renamed from: a */
    static HashMap f1628a = new HashMap();

    /* renamed from: b */
    protected String f1629b;

    /* renamed from: c */
    protected String f1630c;

    /* renamed from: d */
    protected int f1631d;

    /* renamed from: e */
    protected C1322br f1632e;

    /* renamed from: f */
    protected long f1633f;

    /* renamed from: g */
    C0477ab f1634g;

    /* renamed from: h */
    protected long f1635h;

    /* renamed from: i */
    public C0490c f1636i = null;

    /* renamed from: j */
    public C0490c f1637j = null;

    /* renamed from: k */
    public C0490c f1638k = null;

    /* renamed from: l */
    public C0490c f1639l = null;

    /* renamed from: m */
    public C0490c f1640m = null;

    /* renamed from: a */
    static synchronized C0477ab m2540a(C0505l c0505l) {
        C0505l c0505l2 = (C0505l) f1628a.get(c0505l.m2548c());
        if (c0505l2 == null) {
            c0505l.f1634g = new C0477ab(c0505l);
            f1628a.put(c0505l.m2548c(), c0505l);
        } else {
            c0505l2.f1630c = c0505l.m2549d();
            c0505l2.f1631d = c0505l.m2550e();
            c0505l2.f1632e = c0505l.m2551f();
            c0505l2.f1633f = c0505l.m2552g();
            c0505l2.f1635h = c0505l.m2554i();
            c0505l.f1634g = c0505l2.m2553h();
        }
        return c0505l.m2553h();
    }

    /* renamed from: b */
    static synchronized C0505l m2542b(C0505l c0505l) {
        C0505l c0505l2 = (C0505l) f1628a.get(c0505l.m2548c());
        if (c0505l2 == null) {
            f1628a.put(c0505l.m2548c(), c0505l);
        } else {
            c0505l2.f1630c = c0505l.m2549d();
            c0505l2.f1631d = c0505l.m2550e();
            c0505l2.f1632e = c0505l.m2551f();
            c0505l2.f1633f = c0505l.m2552g();
            c0505l2.f1635h = c0505l.m2554i();
            c0505l.f1634g = c0505l2.m2553h();
            c0505l = c0505l2;
        }
        return c0505l;
    }

    /* renamed from: c */
    static synchronized void m2543c(C0505l c0505l) {
        c0505l.m2553h().m2463d();
    }

    /* renamed from: d */
    static synchronized void m2544d(C0505l c0505l) {
        f1628a.remove(c0505l.m2548c());
        C1341p.m4658b("removeTcpContext: " + c0505l.m2548c(), "TcpContext");
    }

    /* renamed from: a */
    static synchronized int m2539a() {
        int i;
        int i2 = 0;
        Iterator it = new ArrayList(f1628a.values()).iterator();
        while (true) {
            i = i2;
            if (it.hasNext()) {
                ((C0505l) it.next()).m2553h().m2463d();
                i2 = i + 1;
            }
        }
        return i;
    }

    /* renamed from: b */
    static synchronized int m2541b() {
        int i;
        int i2 = 0;
        Iterator it = f1628a.values().iterator();
        while (true) {
            i = i2;
            if (it.hasNext()) {
                ((C0505l) it.next()).m2553h().m2464f();
                i2 = i + 1;
            }
        }
        return i;
    }

    public boolean equals(Object obj) {
        try {
            if (obj instanceof C0505l) {
                return this.f1629b.equals(((C0505l) obj).m2548c());
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    protected C0505l(C0509p c0509p) throws NoSuchFieldException {
        this.f1629b = null;
        this.f1630c = null;
        this.f1631d = Integer.MIN_VALUE;
        this.f1632e = null;
        this.f1633f = -2147483648L;
        this.f1634g = null;
        this.f1635h = 0L;
        if (c0509p.f1652a == null) {
            throw new NoSuchFieldException("No Context ID");
        }
        this.f1629b = c0509p.f1652a;
        if (c0509p.f1653b == null) {
            throw new NoSuchFieldException("No Domain");
        }
        if (c0509p.f1653b.length() == 0) {
            throw new NoSuchFieldException("No Domain actually. Domain length is 0");
        }
        this.f1630c = c0509p.f1653b;
        if (c0509p.f1654c == Integer.MIN_VALUE) {
            throw new NoSuchFieldException("No Port");
        }
        this.f1631d = c0509p.f1654c;
        this.f1632e = c0509p.f1655d;
        this.f1633f = c0509p.f1656e;
        this.f1635h = Long.MAX_VALUE;
        this.f1634g = m2540a(this);
    }

    /* renamed from: c */
    public String m2548c() {
        return this.f1629b;
    }

    /* renamed from: d */
    public String m2549d() {
        return this.f1630c;
    }

    /* renamed from: e */
    public int m2550e() {
        return this.f1631d;
    }

    /* renamed from: f */
    public C1322br m2551f() {
        return this.f1632e;
    }

    /* renamed from: g */
    public long m2552g() {
        return this.f1633f;
    }

    /* renamed from: h */
    C0477ab m2553h() {
        return this.f1634g;
    }

    /* renamed from: i */
    public long m2554i() {
        return this.f1635h;
    }

    /* renamed from: a */
    public synchronized void m2546a(String str, int i) {
        this.f1630c = str;
        this.f1631d = i;
    }

    /* renamed from: a */
    public void m2545a(long j) {
        C0505l c0505lM2542b = m2542b(this);
        this.f1635h = j;
        c0505lM2542b.f1635h = j;
    }

    /* renamed from: a */
    public synchronized void m2547a(byte[] bArr, byte[] bArr2) {
        this.f1632e = new C1322br(bArr, bArr2);
    }
}
