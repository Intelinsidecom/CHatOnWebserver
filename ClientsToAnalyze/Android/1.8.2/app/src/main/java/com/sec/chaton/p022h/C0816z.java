package com.sec.chaton.p022h;

import com.sec.chaton.util.C1771c;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: TcpContext.java */
/* renamed from: com.sec.chaton.h.z */
/* loaded from: classes.dex */
public class C0816z {

    /* renamed from: a */
    static HashMap f2995a = new HashMap();

    /* renamed from: b */
    protected String f2996b;

    /* renamed from: c */
    protected String f2997c;

    /* renamed from: d */
    protected int f2998d;

    /* renamed from: e */
    protected C1771c f2999e;

    /* renamed from: f */
    protected long f3000f;

    /* renamed from: g */
    C0810t f3001g;

    /* renamed from: h */
    protected long f3002h;

    /* renamed from: i */
    public C0805o f3003i = null;

    /* renamed from: j */
    public C0805o f3004j = null;

    /* renamed from: k */
    public C0805o f3005k = null;

    /* renamed from: l */
    public C0805o f3006l = null;

    /* renamed from: m */
    public C0805o f3007m = null;

    /* renamed from: a */
    static synchronized C0810t m3446a(C0816z c0816z) {
        C0816z c0816z2 = (C0816z) f2995a.get(c0816z.m3454c());
        if (c0816z2 == null) {
            c0816z.f3001g = new C0810t(c0816z);
            f2995a.put(c0816z.m3454c(), c0816z);
        } else {
            c0816z2.f2997c = c0816z.m3455d();
            c0816z2.f2998d = c0816z.m3456e();
            c0816z2.f2999e = c0816z.m3457f();
            c0816z2.f3000f = c0816z.m3458g();
            c0816z2.f3002h = c0816z.m3460i();
            c0816z.f3001g = c0816z2.m3459h();
        }
        return c0816z.m3459h();
    }

    /* renamed from: b */
    static synchronized C0816z m3448b(C0816z c0816z) {
        C0816z c0816z2 = (C0816z) f2995a.get(c0816z.m3454c());
        if (c0816z2 == null) {
            f2995a.put(c0816z.m3454c(), c0816z);
        } else {
            c0816z2.f2997c = c0816z.m3455d();
            c0816z2.f2998d = c0816z.m3456e();
            c0816z2.f2999e = c0816z.m3457f();
            c0816z2.f3000f = c0816z.m3458g();
            c0816z2.f3002h = c0816z.m3460i();
            c0816z.f3001g = c0816z2.m3459h();
            c0816z = c0816z2;
        }
        return c0816z;
    }

    /* renamed from: c */
    static synchronized void m3449c(C0816z c0816z) {
        c0816z.m3459h().m3443d();
    }

    /* renamed from: d */
    static synchronized void m3450d(C0816z c0816z) {
        f2995a.remove(c0816z.m3454c());
        C1786r.m6061b("removeTcpContext: " + c0816z.m3454c(), "TcpContext");
    }

    /* renamed from: a */
    static synchronized int m3445a() {
        int i;
        int i2 = 0;
        Iterator it = new ArrayList(f2995a.values()).iterator();
        while (true) {
            i = i2;
            if (it.hasNext()) {
                ((C0816z) it.next()).m3459h().m3443d();
                i2 = i + 1;
            }
        }
        return i;
    }

    /* renamed from: b */
    static synchronized int m3447b() {
        int i;
        int i2 = 0;
        Iterator it = f2995a.values().iterator();
        while (true) {
            i = i2;
            if (it.hasNext()) {
                ((C0816z) it.next()).m3459h().m3444f();
                i2 = i + 1;
            }
        }
        return i;
    }

    public boolean equals(Object obj) {
        try {
            if (obj instanceof C0816z) {
                return this.f2996b.equals(((C0816z) obj).m3454c());
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    protected C0816z(C0769aa c0769aa) throws NoSuchFieldException {
        this.f2996b = null;
        this.f2997c = null;
        this.f2998d = Integer.MIN_VALUE;
        this.f2999e = null;
        this.f3000f = -2147483648L;
        this.f3001g = null;
        this.f3002h = 0L;
        if (c0769aa.f2799a == null) {
            throw new NoSuchFieldException("No Context ID");
        }
        this.f2996b = c0769aa.f2799a;
        if (c0769aa.f2800b == null) {
            throw new NoSuchFieldException("No Domain");
        }
        if (c0769aa.f2800b.length() == 0) {
            throw new NoSuchFieldException("No Domain actually. Domain length is 0");
        }
        this.f2997c = c0769aa.f2800b;
        if (c0769aa.f2801c == Integer.MIN_VALUE) {
            throw new NoSuchFieldException("No Port");
        }
        this.f2998d = c0769aa.f2801c;
        this.f2999e = c0769aa.f2802d;
        this.f3000f = c0769aa.f2803e;
        this.f3002h = Long.MAX_VALUE;
        this.f3001g = m3446a(this);
    }

    /* renamed from: c */
    public String m3454c() {
        return this.f2996b;
    }

    /* renamed from: d */
    public String m3455d() {
        return this.f2997c;
    }

    /* renamed from: e */
    public int m3456e() {
        return this.f2998d;
    }

    /* renamed from: f */
    public C1771c m3457f() {
        return this.f2999e;
    }

    /* renamed from: g */
    public long m3458g() {
        return this.f3000f;
    }

    /* renamed from: h */
    C0810t m3459h() {
        return this.f3001g;
    }

    /* renamed from: i */
    public long m3460i() {
        return this.f3002h;
    }

    /* renamed from: a */
    public synchronized void m3452a(String str, int i) {
        this.f2997c = str;
        this.f2998d = i;
    }

    /* renamed from: a */
    public void m3451a(long j) {
        C0816z c0816zM3448b = m3448b(this);
        this.f3002h = j;
        c0816zM3448b.f3002h = j;
    }

    /* renamed from: a */
    public synchronized void m3453a(byte[] bArr, byte[] bArr2) {
        this.f2999e = new C1771c(bArr, bArr2);
    }
}
