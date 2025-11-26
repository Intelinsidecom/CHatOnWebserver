package com.sec.widget;

import android.view.MenuItem;
import android.widget.PopupMenu;

/* compiled from: CompatPopupMenu.java */
/* renamed from: com.sec.widget.ah */
/* loaded from: classes.dex */
class C1611ah implements PopupMenu.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C1632t f5705a;

    C1611ah(C1632t c1632t) {
        this.f5705a = c1632t;
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.f5705a.f5756e.mo5883a(menuItem);
    }
}
