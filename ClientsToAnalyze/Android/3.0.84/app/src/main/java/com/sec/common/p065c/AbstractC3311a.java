package com.sec.common.p065c;

/* compiled from: AbstractLogger.java */
/* renamed from: com.sec.common.c.a */
/* loaded from: classes.dex */
public abstract class AbstractC3311a {

    /* renamed from: a */
    protected AbstractC3311a f11971a;

    /* renamed from: b */
    public boolean f11972b;

    /* renamed from: c */
    public boolean f11973c;

    /* renamed from: d */
    public boolean f11974d;

    /* renamed from: e */
    public boolean f11975e;

    /* renamed from: b */
    protected abstract void mo11655b(String str, String str2, Throwable th);

    /* renamed from: d */
    protected abstract void mo11657d(String str, String str2);

    /* renamed from: e */
    protected abstract void mo11658e(String str, String str2);

    /* renamed from: f */
    protected abstract void mo11659f(String str, String str2);

    public AbstractC3311a() {
        this(null);
    }

    public AbstractC3311a(AbstractC3311a abstractC3311a) {
        this.f11971a = abstractC3311a;
        this.f11972b = true;
        this.f11973c = true;
        this.f11974d = true;
        this.f11975e = true;
    }

    /* renamed from: a */
    public void m11653a(boolean z, boolean z2, boolean z3, boolean z4) {
        this.f11972b = z;
        this.f11973c = z2;
        this.f11974d = z3;
        this.f11975e = z4;
    }

    /* renamed from: a */
    public void m11651a(String str, String str2) {
        if (this.f11971a != null) {
            this.f11971a.m11651a(str, str2);
        }
        mo11657d(str, str2);
    }

    /* renamed from: b */
    public void m11654b(String str, String str2) {
        if (this.f11971a != null) {
            this.f11971a.m11654b(str, str2);
        }
        mo11658e(str, str2);
    }

    /* renamed from: c */
    public void m11656c(String str, String str2) {
        if (this.f11971a != null) {
            this.f11971a.m11656c(str, str2);
        }
        mo11659f(str, str2);
    }

    /* renamed from: a */
    public void m11652a(String str, String str2, Throwable th) {
        if (this.f11971a != null) {
            this.f11971a.m11652a(str, str2, th);
        }
        mo11655b(str, str2, th);
    }
}
