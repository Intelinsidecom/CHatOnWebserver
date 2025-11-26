package com.sec.chaton.trunk;

/* compiled from: AbstractPresenter.java */
/* renamed from: com.sec.chaton.trunk.a */
/* loaded from: classes.dex */
public abstract class AbstractC4564a {

    /* renamed from: a */
    protected boolean f16655a;

    /* renamed from: b */
    protected boolean f16656b;

    /* renamed from: a */
    public void m17508a() {
        if (!this.f16655a) {
            this.f16655a = true;
            this.f16656b = false;
            mo17513f();
        }
    }

    /* renamed from: b */
    public void m17509b() {
        if (m17512e()) {
            mo17514g();
        }
    }

    /* renamed from: c */
    public void m17510c() {
        if (m17512e()) {
            mo17515h();
        }
    }

    /* renamed from: d */
    public void m17511d() {
        if (!this.f16656b) {
            this.f16655a = false;
            this.f16656b = true;
            mo17516i();
        }
    }

    /* renamed from: e */
    public boolean m17512e() {
        return this.f16655a && !this.f16656b;
    }

    /* renamed from: f */
    protected void mo17513f() {
    }

    /* renamed from: g */
    protected void mo17514g() {
    }

    /* renamed from: h */
    protected void mo17515h() {
    }

    /* renamed from: i */
    protected void mo17516i() {
    }
}
