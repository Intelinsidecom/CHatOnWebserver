package com.sec.chaton.push.util;

/* compiled from: AbstractLogger.java */
/* renamed from: com.sec.chaton.push.util.a */
/* loaded from: classes.dex */
public abstract class AbstractC3109a {

    /* renamed from: a */
    protected AbstractC3109a f11446a;

    /* renamed from: b */
    public boolean f11447b;

    /* renamed from: c */
    public boolean f11448c;

    /* renamed from: d */
    public boolean f11449d;

    /* renamed from: e */
    public boolean f11450e;

    /* renamed from: b */
    protected abstract void mo12677b(String str, String str2, Throwable th);

    /* renamed from: e */
    protected abstract void mo12680e(String str, String str2);

    /* renamed from: f */
    protected abstract void mo12681f(String str, String str2);

    /* renamed from: g */
    protected abstract void mo12682g(String str, String str2);

    public AbstractC3109a() {
        this(null);
    }

    public AbstractC3109a(AbstractC3109a abstractC3109a) {
        this.f11446a = abstractC3109a;
        this.f11447b = true;
        this.f11448c = true;
        this.f11449d = true;
        this.f11450e = true;
    }

    /* renamed from: a */
    public void m12675a(boolean z, boolean z2, boolean z3, boolean z4) {
        this.f11447b = z;
        this.f11448c = z2;
        this.f11449d = z3;
        this.f11450e = z4;
    }

    /* renamed from: a */
    public void m12673a(String str, String str2) {
        if (this.f11446a != null) {
            this.f11446a.m12673a(str, str2);
        }
        mo12680e(str, str2);
    }

    /* renamed from: b */
    public void m12676b(String str, String str2) {
        if (this.f11446a != null) {
            this.f11446a.m12676b(str, str2);
        }
        mo12681f(str, str2);
    }

    /* renamed from: c */
    public void m12678c(String str, String str2) {
        if (this.f11446a != null) {
            this.f11446a.m12678c(str, str2);
        }
        mo12682g(str, str2);
    }

    /* renamed from: d */
    public void m12679d(String str, String str2) {
        if (this.f11446a != null) {
            this.f11446a.m12679d(str, str2);
        }
        mo12677b(str, str2, null);
    }

    /* renamed from: a */
    public void m12674a(String str, String str2, Throwable th) {
        if (this.f11446a != null) {
            this.f11446a.m12674a(str, str2, th);
        }
        mo12677b(str, str2, th);
    }
}
