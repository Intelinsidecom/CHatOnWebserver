package com.sec.p007b.p008a.p010b;

/* compiled from: AbstractLogger.java */
/* renamed from: com.sec.b.a.b.b */
/* loaded from: classes.dex */
public abstract class AbstractC0113b {

    /* renamed from: a */
    protected AbstractC0113b f209a;

    /* renamed from: b */
    public boolean f210b;

    /* renamed from: c */
    public boolean f211c;

    /* renamed from: d */
    public boolean f212d;

    /* renamed from: e */
    public boolean f213e;

    /* renamed from: a */
    protected abstract void mo582a(String str, String str2);

    /* renamed from: b */
    protected abstract void mo583b(String str, String str2);

    public AbstractC0113b() {
        this(null);
    }

    public AbstractC0113b(AbstractC0113b abstractC0113b) {
        this.f209a = abstractC0113b;
        this.f210b = true;
        this.f211c = true;
        this.f212d = true;
        this.f213e = true;
    }

    /* renamed from: a */
    public void m584a(boolean z, boolean z2, boolean z3, boolean z4) {
        this.f210b = z;
        this.f211c = z2;
        this.f212d = z3;
        this.f213e = z4;
    }

    /* renamed from: c */
    public void m585c(String str, String str2) {
        if (this.f209a != null) {
            this.f209a.m585c(str, str2);
        }
        mo582a(str, str2);
    }

    /* renamed from: d */
    public void m586d(String str, String str2) {
        if (this.f209a != null) {
            this.f209a.m586d(str, str2);
        }
        mo583b(str, str2);
    }
}
