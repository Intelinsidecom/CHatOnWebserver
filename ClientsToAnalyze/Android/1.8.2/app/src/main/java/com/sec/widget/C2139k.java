package com.sec.widget;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

/* compiled from: DropPanelMenu.java */
/* renamed from: com.sec.widget.k */
/* loaded from: classes.dex */
class C2139k implements InterfaceC2143o {

    /* renamed from: a */
    final /* synthetic */ Activity f7787a;

    C2139k(Activity activity) {
        this.f7787a = activity;
    }

    @Override // com.sec.widget.InterfaceC2143o
    /* renamed from: a */
    public boolean mo7494a(Menu menu) {
        return this.f7787a.onCreateOptionsMenu(menu);
    }

    @Override // com.sec.widget.InterfaceC2143o
    /* renamed from: b */
    public boolean mo7496b(Menu menu) {
        return this.f7787a.onPrepareOptionsMenu(menu);
    }

    @Override // com.sec.widget.InterfaceC2143o
    /* renamed from: a */
    public boolean mo7495a(MenuItem menuItem) {
        return this.f7787a.onOptionsItemSelected(menuItem);
    }

    @Override // com.sec.widget.InterfaceC2143o
    /* renamed from: a */
    public void mo7493a() {
        this.f7787a.closeOptionsMenu();
    }
}
