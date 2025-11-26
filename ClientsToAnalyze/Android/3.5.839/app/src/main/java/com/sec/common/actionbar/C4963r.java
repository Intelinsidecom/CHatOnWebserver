package com.sec.common.actionbar;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.AbstractC0024aj;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/* compiled from: ActionBarWrapper.java */
/* renamed from: com.sec.common.actionbar.r */
/* loaded from: classes.dex */
class C4963r extends AbstractC4948c implements ActionBar.TabListener {

    /* renamed from: a */
    final /* synthetic */ C4961p f18144a;

    /* renamed from: b */
    private ActionBar.Tab f18145b;

    /* renamed from: c */
    private InterfaceC4949d f18146c;

    public C4963r(C4961p c4961p, ActionBar.Tab tab) {
        this.f18144a = c4961p;
        this.f18145b = tab;
    }

    @Override // com.sec.common.actionbar.AbstractC4948c
    /* renamed from: a */
    public View mo18838a() {
        return this.f18145b.getCustomView();
    }

    @Override // com.sec.common.actionbar.AbstractC4948c
    /* renamed from: a */
    public AbstractC4948c mo18839a(View view) {
        this.f18145b.setCustomView(view);
        return this;
    }

    @Override // com.sec.common.actionbar.AbstractC4948c
    /* renamed from: b */
    public int mo18841b() {
        return this.f18145b.getPosition();
    }

    @Override // com.sec.common.actionbar.AbstractC4948c
    /* renamed from: c */
    public CharSequence mo18842c() {
        return this.f18145b.getText();
    }

    @Override // com.sec.common.actionbar.AbstractC4948c
    /* renamed from: a */
    public AbstractC4948c mo18840a(InterfaceC4949d interfaceC4949d) {
        this.f18146c = interfaceC4949d;
        this.f18145b.setTabListener(this);
        return this;
    }

    @Override // android.app.ActionBar.TabListener
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        if (this.f18146c != null && (this.f18144a.f18140a instanceof FragmentActivity)) {
            AbstractC0024aj abstractC0024ajMo94a = ((FragmentActivity) this.f18144a.f18140a).m50e().mo183a().mo94a();
            this.f18146c.mo2907a(this, abstractC0024ajMo94a);
            if (abstractC0024ajMo94a != null && !abstractC0024ajMo94a.mo107e()) {
                abstractC0024ajMo94a.mo99b();
            }
        }
    }

    @Override // android.app.ActionBar.TabListener
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        if (this.f18146c != null && (this.f18144a.f18140a instanceof FragmentActivity)) {
            AbstractC0024aj abstractC0024ajMo94a = ((FragmentActivity) this.f18144a.f18140a).m50e().mo183a().mo94a();
            this.f18146c.mo2909b(this, abstractC0024ajMo94a);
            if (abstractC0024ajMo94a != null && !abstractC0024ajMo94a.mo107e()) {
                abstractC0024ajMo94a.mo99b();
            }
        }
    }

    @Override // android.app.ActionBar.TabListener
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        if (this.f18146c != null && (this.f18144a.f18140a instanceof FragmentActivity)) {
            AbstractC0024aj abstractC0024ajMo94a = ((FragmentActivity) this.f18144a.f18140a).m50e().mo183a().mo94a();
            this.f18146c.mo2910c(this, abstractC0024ajMo94a);
            if (abstractC0024ajMo94a != null && !abstractC0024ajMo94a.mo107e()) {
                abstractC0024ajMo94a.mo99b();
            }
        }
    }
}
