package com.sec.common.actionbar;

import android.view.MenuItem;
import android.view.View;

/* compiled from: ActionBarHelperBase.java */
/* renamed from: com.sec.common.actionbar.g */
/* loaded from: classes.dex */
class ViewOnClickListenerC3290g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItem f11923a;

    /* renamed from: b */
    final /* synthetic */ C3289f f11924b;

    ViewOnClickListenerC3290g(C3289f c3289f, MenuItem menuItem) {
        this.f11924b = c3289f;
        this.f11923a = menuItem;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f11924b.f11915a.onMenuItemSelected(0, this.f11923a);
    }
}
