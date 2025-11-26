package com.sec.chaton.push.util;

/* compiled from: AbstractLogger.java */
/* renamed from: com.sec.chaton.push.util.a */
/* loaded from: classes.dex */
public abstract class AbstractC2109a {

    /* renamed from: a */
    protected AbstractC2109a f8036a;

    /* renamed from: b */
    public boolean f8037b;

    /* renamed from: c */
    public boolean f8038c;

    /* renamed from: d */
    public boolean f8039d;

    /* renamed from: e */
    public boolean f8040e;

    /* renamed from: b */
    protected abstract void mo8335b(String str, String str2, Throwable th);

    /* renamed from: e */
    protected abstract void mo8338e(String str, String str2);

    /* renamed from: f */
    protected abstract void mo8339f(String str, String str2);

    /* renamed from: g */
    protected abstract void mo8340g(String str, String str2);

    public AbstractC2109a() {
        this(null);
    }

    public AbstractC2109a(AbstractC2109a abstractC2109a) {
        this.f8036a = abstractC2109a;
        this.f8037b = true;
        this.f8038c = true;
        this.f8039d = true;
        this.f8040e = true;
    }

    /* renamed from: a */
    public void m8333a(boolean z, boolean z2, boolean z3, boolean z4) {
        this.f8037b = z;
        this.f8038c = z2;
        this.f8039d = z3;
        this.f8040e = z4;
    }

    /* renamed from: a */
    public void m8331a(String str, String str2) {
        if (this.f8036a != null) {
            this.f8036a.m8331a(str, str2);
        }
        mo8338e(str, str2);
    }

    /* renamed from: b */
    public void m8334b(String str, String str2) {
        if (this.f8036a != null) {
            this.f8036a.m8334b(str, str2);
        }
        mo8339f(str, str2);
    }

    /* renamed from: c */
    public void m8336c(String str, String str2) {
        if (this.f8036a != null) {
            this.f8036a.m8336c(str, str2);
        }
        mo8340g(str, str2);
    }

    /* renamed from: d */
    public void m8337d(String str, String str2) {
        if (this.f8036a != null) {
            this.f8036a.m8337d(str, str2);
        }
        mo8335b(str, str2, null);
    }

    /* renamed from: a */
    public void m8332a(String str, String str2, Throwable th) {
        if (this.f8036a != null) {
            this.f8036a.m8332a(str, str2, th);
        }
        mo8335b(str, str2, th);
    }
}
