package com.sec.widget;

import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import com.sec.chaton.util.C1341p;

/* compiled from: CompatPopupMenu.java */
/* renamed from: com.sec.widget.ai */
/* loaded from: classes.dex */
class C1612ai implements InterfaceC1614b {

    /* renamed from: a */
    final /* synthetic */ Fragment f5706a;

    C1612ai(Fragment fragment) {
        this.f5706a = fragment;
    }

    @Override // com.sec.widget.InterfaceC1614b
    /* renamed from: a */
    public boolean mo5882a(Menu menu) {
        try {
            this.f5706a.onCreateOptionsMenu(menu, this.f5706a.getActivity().getMenuInflater());
            return true;
        } catch (NullPointerException e) {
            C1341p.m4653a(e, getClass().getSimpleName());
            return false;
        }
    }

    @Override // com.sec.widget.InterfaceC1614b
    /* renamed from: b */
    public boolean mo5885b(Menu menu) {
        this.f5706a.onPrepareOptionsMenu(menu);
        return true;
    }

    @Override // com.sec.widget.InterfaceC1614b
    /* renamed from: a */
    public boolean mo5883a(MenuItem menuItem) {
        return this.f5706a.onOptionsItemSelected(menuItem);
    }

    @Override // com.sec.widget.InterfaceC1614b
    /* renamed from: a */
    public void mo5881a() {
        this.f5706a.getActivity().openOptionsMenu();
    }

    @Override // com.sec.widget.InterfaceC1614b
    /* renamed from: b */
    public void mo5884b() {
        this.f5706a.getActivity().closeOptionsMenu();
    }
}
