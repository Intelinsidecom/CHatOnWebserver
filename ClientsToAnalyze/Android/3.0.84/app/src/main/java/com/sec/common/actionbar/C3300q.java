package com.sec.common.actionbar;

import android.app.ActionBar;

/* compiled from: ActionBarWrapper.java */
/* renamed from: com.sec.common.actionbar.q */
/* loaded from: classes.dex */
class C3300q implements ActionBar.OnNavigationListener {

    /* renamed from: a */
    final /* synthetic */ InterfaceC3285b f11944a;

    /* renamed from: b */
    final /* synthetic */ C3299p f11945b;

    C3300q(C3299p c3299p, InterfaceC3285b interfaceC3285b) {
        this.f11945b = c3299p;
        this.f11944a = interfaceC3285b;
    }

    @Override // android.app.ActionBar.OnNavigationListener
    public boolean onNavigationItemSelected(int i, long j) {
        return this.f11944a.mo1154a(i, j);
    }
}
