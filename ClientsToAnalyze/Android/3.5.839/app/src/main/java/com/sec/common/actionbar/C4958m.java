package com.sec.common.actionbar;

import android.view.View;

/* compiled from: ActionBarImpl.java */
/* renamed from: com.sec.common.actionbar.m */
/* loaded from: classes.dex */
class C4958m extends AbstractC4948c {

    /* renamed from: a */
    final /* synthetic */ C4956k f18134a;

    /* renamed from: b */
    private int f18135b;

    /* renamed from: c */
    private String f18136c;

    /* renamed from: d */
    private View f18137d;

    /* renamed from: e */
    private InterfaceC4949d f18138e;

    /* renamed from: f */
    private InterfaceC4959n f18139f;

    public C4958m(C4956k c4956k) {
        this.f18134a = c4956k;
        this.f18138e = c4956k.f18132g;
    }

    @Override // com.sec.common.actionbar.AbstractC4948c
    /* renamed from: a */
    public View mo18838a() {
        return this.f18137d;
    }

    @Override // com.sec.common.actionbar.AbstractC4948c
    /* renamed from: a */
    public AbstractC4948c mo18839a(View view) {
        this.f18137d = view;
        if (this.f18139f != null) {
            this.f18139f.mo18871a(this.f18137d);
        }
        return this;
    }

    @Override // com.sec.common.actionbar.AbstractC4948c
    /* renamed from: b */
    public int mo18841b() {
        return this.f18135b;
    }

    /* renamed from: a */
    void m18868a(int i) {
        this.f18135b = i;
    }

    @Override // com.sec.common.actionbar.AbstractC4948c
    /* renamed from: c */
    public CharSequence mo18842c() {
        return this.f18136c;
    }

    @Override // com.sec.common.actionbar.AbstractC4948c
    /* renamed from: a */
    public AbstractC4948c mo18840a(InterfaceC4949d interfaceC4949d) {
        this.f18138e = interfaceC4949d;
        return this;
    }

    /* renamed from: d */
    public InterfaceC4949d m18870d() {
        return this.f18138e;
    }

    /* renamed from: a */
    void m18869a(InterfaceC4959n interfaceC4959n) {
        this.f18139f = interfaceC4959n;
    }
}
