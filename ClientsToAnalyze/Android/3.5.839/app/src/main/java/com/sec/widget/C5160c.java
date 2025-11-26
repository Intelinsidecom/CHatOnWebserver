package com.sec.widget;

import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.util.C4904y;

/* compiled from: DropPanelMenu.java */
/* renamed from: com.sec.widget.c */
/* loaded from: classes.dex */
class C5160c implements InterfaceC5164g {

    /* renamed from: a */
    final /* synthetic */ Fragment f18883a;

    C5160c(Fragment fragment) {
        this.f18883a = fragment;
    }

    @Override // com.sec.widget.InterfaceC5164g
    /* renamed from: a */
    public boolean mo19748a(Menu menu) {
        try {
            this.f18883a.onCreateOptionsMenu(menu, this.f18883a.getActivity().getMenuInflater());
            return true;
        } catch (NullPointerException e) {
            C4904y.m18635a(e, getClass().getSimpleName());
            return false;
        }
    }

    @Override // com.sec.widget.InterfaceC5164g
    /* renamed from: b */
    public boolean mo19750b(Menu menu) {
        this.f18883a.onPrepareOptionsMenu(menu);
        return true;
    }

    @Override // com.sec.widget.InterfaceC5164g
    /* renamed from: a */
    public boolean mo19749a(MenuItem menuItem) {
        return this.f18883a.onOptionsItemSelected(menuItem);
    }

    @Override // com.sec.widget.InterfaceC5164g
    /* renamed from: a */
    public void mo19747a() {
        this.f18883a.getActivity().closeOptionsMenu();
    }
}
