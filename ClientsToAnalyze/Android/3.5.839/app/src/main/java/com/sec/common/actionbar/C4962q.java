package com.sec.common.actionbar;

import android.app.ActionBar;

/* compiled from: ActionBarWrapper.java */
/* renamed from: com.sec.common.actionbar.q */
/* loaded from: classes.dex */
class C4962q implements ActionBar.OnNavigationListener {

    /* renamed from: a */
    final /* synthetic */ InterfaceC4947b f18142a;

    /* renamed from: b */
    final /* synthetic */ C4961p f18143b;

    C4962q(C4961p c4961p, InterfaceC4947b interfaceC4947b) {
        this.f18143b = c4961p;
        this.f18142a = interfaceC4947b;
    }

    @Override // android.app.ActionBar.OnNavigationListener
    public boolean onNavigationItemSelected(int i, long j) {
        return this.f18142a.mo2908a(i, j);
    }
}
