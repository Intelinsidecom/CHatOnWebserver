package com.sec.chaton.trunk;

/* compiled from: AbstractPresenter.java */
/* renamed from: com.sec.chaton.trunk.bi */
/* loaded from: classes.dex */
public abstract class AbstractC1145bi {

    /* renamed from: a */
    protected boolean f3975a;

    /* renamed from: b */
    protected boolean f3976b;

    /* renamed from: f */
    public void m4175f() {
        if (!this.f3975a) {
            this.f3975a = true;
            this.f3976b = false;
            mo4118a();
        }
    }

    /* renamed from: g */
    public void m4176g() {
        if (m4179j()) {
            mo4119b();
        }
    }

    /* renamed from: h */
    public void m4177h() {
        if (m4179j()) {
            mo4120c();
        }
    }

    /* renamed from: i */
    public void m4178i() {
        if (!this.f3976b) {
            this.f3975a = false;
            this.f3976b = true;
            mo4121d();
        }
    }

    /* renamed from: j */
    public boolean m4179j() {
        return this.f3975a && !this.f3976b;
    }

    /* renamed from: a */
    protected void mo4118a() {
    }

    /* renamed from: b */
    protected void mo4119b() {
    }

    /* renamed from: c */
    protected void mo4120c() {
    }

    /* renamed from: d */
    protected void mo4121d() {
    }
}
