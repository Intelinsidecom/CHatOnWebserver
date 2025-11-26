package com.sec.common.actionbar;

import android.view.MenuItem;
import android.view.View;

/* compiled from: ActionBarHelperBase.java */
/* renamed from: com.sec.common.actionbar.g */
/* loaded from: classes.dex */
class ViewOnClickListenerC4952g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItem f18121a;

    /* renamed from: b */
    final /* synthetic */ C4951f f18122b;

    ViewOnClickListenerC4952g(C4951f c4951f, MenuItem menuItem) {
        this.f18122b = c4951f;
        this.f18121a = menuItem;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f18122b.f18113a.onMenuItemSelected(0, this.f18121a);
    }
}
