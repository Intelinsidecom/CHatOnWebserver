package com.sec.common.p125c;

/* compiled from: AbstractLogger.java */
/* renamed from: com.sec.common.c.a */
/* loaded from: classes.dex */
public abstract class AbstractC4973a {

    /* renamed from: a */
    protected AbstractC4973a f18169a;

    /* renamed from: b */
    public boolean f18170b;

    /* renamed from: c */
    public boolean f18171c;

    /* renamed from: d */
    public boolean f18172d;

    /* renamed from: e */
    public boolean f18173e;

    /* renamed from: f */
    public boolean f18174f;

    /* renamed from: a */
    protected abstract void mo18648a(String str, String str2);

    /* renamed from: b */
    protected abstract void mo18651b(String str, String str2);

    /* renamed from: b */
    protected abstract void mo18652b(String str, String str2, Throwable th);

    /* renamed from: c */
    protected abstract void mo18653c(String str, String str2);

    /* renamed from: d */
    protected abstract void mo18654d(String str, String str2);

    public AbstractC4973a() {
        this(null);
    }

    public AbstractC4973a(AbstractC4973a abstractC4973a) {
        this.f18169a = abstractC4973a;
        this.f18170b = true;
        this.f18171c = true;
        this.f18172d = true;
        this.f18173e = true;
        this.f18174f = true;
    }

    /* renamed from: a */
    public void mo18650a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f18170b = z;
        this.f18171c = z2;
        this.f18172d = z3;
        this.f18173e = z4;
        this.f18174f = z5;
    }

    /* renamed from: e */
    public void m18891e(String str, String str2) {
        if (this.f18169a != null) {
            this.f18169a.m18891e(str, str2);
        }
        mo18648a(str, str2);
    }

    /* renamed from: f */
    public void m18892f(String str, String str2) {
        if (this.f18169a != null) {
            this.f18169a.m18892f(str, str2);
        }
        mo18651b(str, str2);
    }

    /* renamed from: g */
    public void m18893g(String str, String str2) {
        if (this.f18169a != null) {
            this.f18169a.m18893g(str, str2);
        }
        mo18653c(str, str2);
    }

    /* renamed from: h */
    public void m18894h(String str, String str2) {
        if (this.f18169a != null) {
            this.f18169a.m18894h(str, str2);
        }
        mo18654d(str, str2);
    }

    /* renamed from: i */
    public void m18895i(String str, String str2) {
        if (this.f18169a != null) {
            this.f18169a.m18895i(str, str2);
        }
        mo18652b(str, str2, null);
    }

    /* renamed from: a */
    public void mo18649a(String str, String str2, Throwable th) {
        if (this.f18169a != null) {
            this.f18169a.mo18649a(str, str2, th);
        }
        mo18652b(str, str2, th);
    }
}
