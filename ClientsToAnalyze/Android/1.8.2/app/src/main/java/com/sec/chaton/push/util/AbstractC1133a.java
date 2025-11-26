package com.sec.chaton.push.util;

/* compiled from: AbstractLogger.java */
/* renamed from: com.sec.chaton.push.util.a */
/* loaded from: classes.dex */
public abstract class AbstractC1133a {

    /* renamed from: a */
    protected AbstractC1133a f4130a;

    /* renamed from: b */
    public boolean f4131b;

    /* renamed from: c */
    public boolean f4132c;

    /* renamed from: d */
    public boolean f4133d;

    /* renamed from: e */
    public boolean f4134e;

    /* renamed from: b */
    protected abstract void mo4284b(String str, String str2, Throwable th);

    /* renamed from: e */
    protected abstract void mo4287e(String str, String str2);

    /* renamed from: f */
    protected abstract void mo4288f(String str, String str2);

    /* renamed from: g */
    protected abstract void mo4289g(String str, String str2);

    public AbstractC1133a() {
        this(null);
    }

    public AbstractC1133a(AbstractC1133a abstractC1133a) {
        this.f4130a = abstractC1133a;
        this.f4131b = true;
        this.f4132c = true;
        this.f4133d = true;
        this.f4134e = true;
    }

    /* renamed from: a */
    public void m4282a(boolean z, boolean z2, boolean z3, boolean z4) {
        this.f4131b = z;
        this.f4132c = z2;
        this.f4133d = z3;
        this.f4134e = z4;
    }

    /* renamed from: a */
    public void m4280a(String str, String str2) {
        if (this.f4130a != null) {
            this.f4130a.m4280a(str, str2);
        }
        mo4287e(str, str2);
    }

    /* renamed from: b */
    public void m4283b(String str, String str2) {
        if (this.f4130a != null) {
            this.f4130a.m4283b(str, str2);
        }
        mo4288f(str, str2);
    }

    /* renamed from: c */
    public void m4285c(String str, String str2) {
        if (this.f4130a != null) {
            this.f4130a.m4285c(str, str2);
        }
        mo4289g(str, str2);
    }

    /* renamed from: d */
    public void m4286d(String str, String str2) {
        if (this.f4130a != null) {
            this.f4130a.m4286d(str, str2);
        }
        mo4284b(str, str2, null);
    }

    /* renamed from: a */
    public void m4281a(String str, String str2, Throwable th) {
        if (this.f4130a != null) {
            this.f4130a.m4281a(str, str2, th);
        }
        mo4284b(str, str2, th);
    }
}
