package com.sec.widget;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

/* compiled from: CompatPopupMenu.java */
/* renamed from: com.sec.widget.af */
/* loaded from: classes.dex */
class C1609af implements InterfaceC1614b {

    /* renamed from: a */
    final /* synthetic */ Activity f5702a;

    C1609af(Activity activity) {
        this.f5702a = activity;
    }

    @Override // com.sec.widget.InterfaceC1614b
    /* renamed from: a */
    public boolean mo5882a(Menu menu) {
        return this.f5702a.onCreateOptionsMenu(menu);
    }

    @Override // com.sec.widget.InterfaceC1614b
    /* renamed from: b */
    public boolean mo5885b(Menu menu) {
        return this.f5702a.onPrepareOptionsMenu(menu);
    }

    @Override // com.sec.widget.InterfaceC1614b
    /* renamed from: a */
    public boolean mo5883a(MenuItem menuItem) {
        return this.f5702a.onOptionsItemSelected(menuItem);
    }

    @Override // com.sec.widget.InterfaceC1614b
    /* renamed from: a */
    public void mo5881a() {
        this.f5702a.openOptionsMenu();
    }

    @Override // com.sec.widget.InterfaceC1614b
    /* renamed from: b */
    public void mo5884b() {
        this.f5702a.closeOptionsMenu();
    }
}
