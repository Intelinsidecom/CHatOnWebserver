package com.sec.common.actionbar;

import android.view.View;

/* compiled from: ActionBarImpl.java */
/* renamed from: com.sec.common.actionbar.m */
/* loaded from: classes.dex */
class C3296m extends AbstractC3286c {

    /* renamed from: a */
    final /* synthetic */ C3294k f11936a;

    /* renamed from: b */
    private int f11937b;

    /* renamed from: c */
    private String f11938c;

    /* renamed from: d */
    private View f11939d;

    /* renamed from: e */
    private InterfaceC3287d f11940e;

    /* renamed from: f */
    private InterfaceC3297n f11941f;

    public C3296m(C3294k c3294k) {
        this.f11936a = c3294k;
        this.f11940e = c3294k.f11934g;
    }

    @Override // com.sec.common.actionbar.AbstractC3286c
    /* renamed from: a */
    public View mo11599a() {
        return this.f11939d;
    }

    @Override // com.sec.common.actionbar.AbstractC3286c
    /* renamed from: a */
    public AbstractC3286c mo11600a(View view) {
        this.f11939d = view;
        if (this.f11941f != null) {
            this.f11941f.mo11632a(this.f11939d);
        }
        return this;
    }

    @Override // com.sec.common.actionbar.AbstractC3286c
    /* renamed from: b */
    public int mo11602b() {
        return this.f11937b;
    }

    /* renamed from: a */
    void m11629a(int i) {
        this.f11937b = i;
    }

    @Override // com.sec.common.actionbar.AbstractC3286c
    /* renamed from: c */
    public CharSequence mo11603c() {
        return this.f11938c;
    }

    @Override // com.sec.common.actionbar.AbstractC3286c
    /* renamed from: a */
    public AbstractC3286c mo11601a(InterfaceC3287d interfaceC3287d) {
        this.f11940e = interfaceC3287d;
        return this;
    }

    /* renamed from: d */
    public InterfaceC3287d m11631d() {
        return this.f11940e;
    }

    /* renamed from: a */
    void m11630a(InterfaceC3297n interfaceC3297n) {
        this.f11941f = interfaceC3297n;
    }
}
