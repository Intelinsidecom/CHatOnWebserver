package com.sec.chaton.p022h;

import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TcpEnvelope.java */
/* renamed from: com.sec.chaton.h.ab */
/* loaded from: classes.dex */
public class C0770ab {

    /* renamed from: h */
    private static AtomicInteger f2804h = null;

    /* renamed from: a */
    protected String f2805a;

    /* renamed from: b */
    protected int f2806b;

    /* renamed from: c */
    protected GeneratedMessageLite f2807c;

    /* renamed from: d */
    protected long f2808d;

    /* renamed from: e */
    protected C0805o f2809e;

    /* renamed from: f */
    protected long f2810f;

    /* renamed from: g */
    protected long f2811g;

    protected C0770ab(C0771ac c0771ac) {
        this.f2805a = null;
        this.f2806b = -1;
        this.f2807c = null;
        this.f2808d = -1L;
        this.f2809e = null;
        this.f2805a = c0771ac.f2812a;
        if (this.f2805a == null) {
            this.f2805a = C1789u.m6075a().getString("uid", "");
        }
        this.f2806b = c0771ac.f2813b;
        this.f2807c = c0771ac.f2814c;
        this.f2808d = C0797g.m3389a(this.f2806b, this.f2807c);
        if (!C0797g.m3392a(this.f2807c)) {
            C1786r.m6054a("[LOG_MODE message] GPB Required field is not assigned in MessageMicro: uid=" + this.f2805a + ", type=" + this.f2806b + ", msgId=" + this.f2808d, "");
        }
        this.f2809e = c0771ac.f2816e;
        this.f2810f = c0771ac.f2817f;
        this.f2811g = c0771ac.f2818g;
    }

    /* renamed from: a */
    public String m3284a() {
        return this.f2805a;
    }

    /* renamed from: b */
    public int m3289b() {
        return this.f2806b;
    }

    /* renamed from: c */
    public GeneratedMessageLite m3290c() {
        return this.f2807c;
    }

    /* renamed from: d */
    public long m3291d() {
        return this.f2808d;
    }

    /* renamed from: e */
    public C0805o m3292e() {
        return this.f2809e;
    }

    /* renamed from: a */
    public void m3286a(C0805o c0805o) {
        this.f2809e = c0805o;
    }

    /* renamed from: a */
    public void m3287a(Object obj, Object obj2) {
        if (this.f2809e != null) {
            this.f2809e.m3416a(1, obj, obj2);
        }
    }

    /* renamed from: a */
    public void m3285a(int i, Object obj) {
        if (this.f2809e != null) {
            this.f2809e.m3415a(i, obj);
        }
    }

    /* renamed from: a */
    public boolean m3288a(long j) {
        return this.f2811g < j - this.f2810f;
    }

    /* renamed from: f */
    public static synchronized void m3283f() {
        if (f2804h == null) {
            f2804h = new AtomicInteger(0);
        }
        f2804h.set(0);
    }
}
