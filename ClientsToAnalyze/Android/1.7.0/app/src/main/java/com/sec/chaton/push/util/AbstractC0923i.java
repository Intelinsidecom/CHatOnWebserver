package com.sec.chaton.push.util;

/* compiled from: AbstractLogger.java */
/* renamed from: com.sec.chaton.push.util.i */
/* loaded from: classes.dex */
public abstract class AbstractC0923i {

    /* renamed from: a */
    protected AbstractC0923i f3122a;

    /* renamed from: b */
    public boolean f3123b;

    /* renamed from: c */
    public boolean f3124c;

    /* renamed from: d */
    public boolean f3125d;

    /* renamed from: e */
    public boolean f3126e;

    /* renamed from: a */
    protected abstract void mo3615a(String str, String str2);

    /* renamed from: a */
    protected abstract void mo3616a(String str, String str2, Throwable th);

    /* renamed from: b */
    protected abstract void mo3617b(String str, String str2);

    /* renamed from: c */
    protected abstract void mo3618c(String str, String str2);

    public AbstractC0923i() {
        this(null);
    }

    public AbstractC0923i(AbstractC0923i abstractC0923i) {
        this.f3122a = abstractC0923i;
        this.f3123b = true;
        this.f3124c = true;
        this.f3125d = true;
        this.f3126e = true;
    }

    /* renamed from: a */
    public void m3643a(boolean z, boolean z2, boolean z3, boolean z4) {
        this.f3123b = z;
        this.f3124c = z2;
        this.f3125d = z3;
        this.f3126e = z4;
    }

    /* renamed from: d */
    public void m3645d(String str, String str2) {
        if (this.f3122a != null) {
            this.f3122a.m3645d(str, str2);
        }
        mo3615a(str, str2);
    }

    /* renamed from: e */
    public void m3646e(String str, String str2) {
        if (this.f3122a != null) {
            this.f3122a.m3646e(str, str2);
        }
        mo3617b(str, str2);
    }

    /* renamed from: f */
    public void m3647f(String str, String str2) {
        if (this.f3122a != null) {
            this.f3122a.m3647f(str, str2);
        }
        mo3618c(str, str2);
    }

    /* renamed from: g */
    public void m3648g(String str, String str2) {
        if (this.f3122a != null) {
            this.f3122a.m3648g(str, str2);
        }
        mo3616a(str, str2, null);
    }

    /* renamed from: b */
    public void m3644b(String str, String str2, Throwable th) {
        if (this.f3122a != null) {
            this.f3122a.m3644b(str, str2, th);
        }
        mo3616a(str, str2, th);
    }
}
