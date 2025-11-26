package com.sec.common.p056b.p060d;

/* compiled from: AbstractLogger.java */
/* renamed from: com.sec.common.b.d.a */
/* loaded from: classes.dex */
public abstract class AbstractC1826a {

    /* renamed from: a */
    protected AbstractC1826a f6540a;

    /* renamed from: b */
    public boolean f6541b;

    /* renamed from: c */
    public boolean f6542c;

    /* renamed from: d */
    public boolean f6543d;

    /* renamed from: e */
    public boolean f6544e;

    /* renamed from: b */
    protected abstract void mo6203b(String str, String str2, Throwable th);

    /* renamed from: d */
    protected abstract void mo6205d(String str, String str2);

    /* renamed from: e */
    protected abstract void mo6206e(String str, String str2);

    public AbstractC1826a() {
        this(null);
    }

    public AbstractC1826a(AbstractC1826a abstractC1826a) {
        this.f6540a = abstractC1826a;
        this.f6541b = true;
        this.f6542c = true;
        this.f6543d = true;
        this.f6544e = true;
    }

    /* renamed from: a */
    public void m6200a(String str, String str2) {
        if (this.f6540a != null) {
            this.f6540a.m6200a(str, str2);
        }
        mo6205d(str, str2);
    }

    /* renamed from: b */
    public void m6202b(String str, String str2) {
        if (this.f6540a != null) {
            this.f6540a.m6202b(str, str2);
        }
        mo6206e(str, str2);
    }

    /* renamed from: c */
    public void m6204c(String str, String str2) {
        if (this.f6540a != null) {
            this.f6540a.m6204c(str, str2);
        }
        mo6203b(str, str2, null);
    }

    /* renamed from: a */
    public void m6201a(String str, String str2, Throwable th) {
        if (this.f6540a != null) {
            this.f6540a.m6201a(str, str2, th);
        }
        mo6203b(str, str2, th);
    }
}
