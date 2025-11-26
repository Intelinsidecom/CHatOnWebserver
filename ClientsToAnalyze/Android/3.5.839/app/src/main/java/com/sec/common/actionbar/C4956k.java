package com.sec.common.actionbar;

import android.app.Activity;
import android.support.v4.app.AbstractC0024aj;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import com.sec.common.C4972c;

/* compiled from: ActionBarImpl.java */
/* renamed from: com.sec.common.actionbar.k */
/* loaded from: classes.dex */
class C4956k extends AbstractC4946a implements InterfaceC4968w {

    /* renamed from: a */
    private Activity f18126a;

    /* renamed from: b */
    private View f18127b;

    /* renamed from: c */
    private ActionBarView f18128c;

    /* renamed from: d */
    private int f18129d;

    /* renamed from: e */
    private TabContainerView f18130e;

    /* renamed from: f */
    private C4958m f18131f;

    /* renamed from: g */
    private InterfaceC4949d f18132g = new C4957l(this);

    public C4956k(Activity activity) {
        this.f18126a = activity;
        this.f18127b = this.f18126a.findViewById(C4972c.actionbar_layout);
        this.f18128c = (ActionBarView) this.f18126a.findViewById(C4972c.actionbar_view);
        this.f18130e = (TabContainerView) this.f18126a.findViewById(C4972c.actionbar_tab_container_view);
        this.f18130e.m18812a(this);
        this.f18131f = null;
        mo18819a(0);
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: a */
    public void mo18820a(View view) {
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        }
        this.f18128c.m18797a(view);
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: b */
    public void mo18826b(int i) {
        mo18823a(this.f18126a.getString(i));
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: a */
    public void mo18823a(CharSequence charSequence) {
        this.f18128c.m18803a(charSequence);
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: b */
    public void mo18827b(CharSequence charSequence) {
        this.f18128c.m18807b(charSequence);
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: a */
    public void mo18819a(int i) {
        this.f18129d = i;
        this.f18128c.m18806b(i);
        if (i == 1) {
            this.f18130e.setVisibility(8);
        } else if (i == 0) {
            this.f18130e.setVisibility(8);
        } else if (i == 2) {
            this.f18130e.setVisibility(0);
        }
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: a */
    public int mo18818a() {
        return this.f18129d;
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: b */
    public AbstractC4948c mo18825b() {
        return new C4958m(this);
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: a */
    public void mo18822a(AbstractC4948c abstractC4948c, boolean z) {
        this.f18130e.m18811a(abstractC4948c);
    }

    /* renamed from: a */
    public void m18866a(AbstractC4948c abstractC4948c) {
        this.f18130e.m18813b(abstractC4948c.mo18841b());
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: c */
    public AbstractC4948c mo18830c(int i) {
        return this.f18130e.m18814c(i);
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: c */
    public int mo18829c() {
        return this.f18130e.m18810a();
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: d */
    public void mo18832d(int i) {
        switch (this.f18129d) {
            case 1:
                this.f18128c.m18808c(i);
                return;
            case 2:
                m18866a(mo18830c(i));
                return;
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: d */
    public boolean mo18834d() {
        return this.f18127b.getVisibility() == 0;
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: e */
    public void mo18835e() {
        this.f18127b.setVisibility(0);
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: f */
    public void mo18837f() {
        this.f18127b.setVisibility(8);
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: e */
    public void mo18836e(int i) {
        this.f18128c.m18794a(i);
    }

    /* renamed from: a */
    public void m18865a(int i, int i2) {
        this.f18128c.m18794a((this.f18128c.m18793a() & (i2 ^ (-1))) | (i & i2));
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: a */
    public void mo18824a(boolean z) {
        m18865a(z ? 4 : 0, 4);
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: c */
    public void mo18831c(boolean z) {
        m18865a(z ? 8 : 0, 8);
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: b */
    public void mo18828b(boolean z) {
        m18865a(z ? 2 : 0, 2);
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: d */
    public void mo18833d(boolean z) {
        this.f18128c.m18804a(z);
    }

    @Override // com.sec.common.actionbar.AbstractC4946a
    /* renamed from: a */
    public void mo18821a(SpinnerAdapter spinnerAdapter, InterfaceC4947b interfaceC4947b) {
        this.f18128c.m18798a(spinnerAdapter);
        this.f18128c.m18799a(interfaceC4947b);
    }

    @Override // com.sec.common.actionbar.InterfaceC4968w
    /* renamed from: b */
    public void mo18867b(AbstractC4948c abstractC4948c) {
        if (abstractC4948c != null) {
            AbstractC0024aj abstractC0024ajMo94a = null;
            try {
                abstractC0024ajMo94a = ((FragmentActivity) this.f18126a).m50e().mo183a().mo94a();
            } catch (ClassCastException e) {
            }
            try {
                C4958m c4958m = (C4958m) abstractC4948c;
                if (this.f18131f == c4958m) {
                    c4958m.m18870d().mo2910c(c4958m, abstractC0024ajMo94a);
                } else {
                    if (this.f18131f != null) {
                        this.f18131f.m18870d().mo2909b(c4958m, abstractC0024ajMo94a);
                    }
                    c4958m.m18870d().mo2907a(c4958m, abstractC0024ajMo94a);
                }
                this.f18131f = c4958m;
            } finally {
                if (abstractC0024ajMo94a != null && !abstractC0024ajMo94a.mo107e()) {
                    abstractC0024ajMo94a.mo99b();
                }
            }
        }
    }
}
