package com.sec.widget;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

/* compiled from: CompatPopupMenu.java */
/* renamed from: com.sec.widget.g */
/* loaded from: classes.dex */
class C2135g implements InterfaceC2138j {

    /* renamed from: a */
    final /* synthetic */ Activity f7783a;

    C2135g(Activity activity) {
        this.f7783a = activity;
    }

    @Override // com.sec.widget.InterfaceC2138j
    /* renamed from: a */
    public boolean mo7490a(Menu menu) {
        return this.f7783a.onCreateOptionsMenu(menu);
    }

    @Override // com.sec.widget.InterfaceC2138j
    /* renamed from: b */
    public boolean mo7492b(Menu menu) {
        return this.f7783a.onPrepareOptionsMenu(menu);
    }

    @Override // com.sec.widget.InterfaceC2138j
    /* renamed from: a */
    public boolean mo7491a(MenuItem menuItem) {
        return this.f7783a.onOptionsItemSelected(menuItem);
    }

    @Override // com.sec.widget.InterfaceC2138j
    /* renamed from: a */
    public void mo7489a() {
        this.f7783a.openOptionsMenu();
    }
}
