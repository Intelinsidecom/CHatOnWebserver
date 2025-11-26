package com.sec.widget;

import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.util.C3250y;

/* compiled from: DropPanelMenu.java */
/* renamed from: com.sec.widget.p */
/* loaded from: classes.dex */
class C3682p implements InterfaceC3686t {

    /* renamed from: a */
    final /* synthetic */ Fragment f13592a;

    C3682p(Fragment fragment) {
        this.f13592a = fragment;
    }

    @Override // com.sec.widget.InterfaceC3686t
    /* renamed from: a */
    public boolean mo13263a(Menu menu) {
        try {
            this.f13592a.onCreateOptionsMenu(menu, this.f13592a.getActivity().getMenuInflater());
            return true;
        } catch (NullPointerException e) {
            C3250y.m11443a(e, getClass().getSimpleName());
            return false;
        }
    }

    @Override // com.sec.widget.InterfaceC3686t
    /* renamed from: b */
    public boolean mo13265b(Menu menu) {
        this.f13592a.onPrepareOptionsMenu(menu);
        return true;
    }

    @Override // com.sec.widget.InterfaceC3686t
    /* renamed from: a */
    public boolean mo13264a(MenuItem menuItem) {
        return this.f13592a.onOptionsItemSelected(menuItem);
    }

    @Override // com.sec.widget.InterfaceC3686t
    /* renamed from: a */
    public void mo13262a() {
        this.f13592a.getActivity().closeOptionsMenu();
    }
}
