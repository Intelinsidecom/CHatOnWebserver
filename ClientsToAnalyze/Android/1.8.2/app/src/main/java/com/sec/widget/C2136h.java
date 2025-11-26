package com.sec.widget;

import android.view.MenuItem;
import android.widget.PopupMenu;

/* compiled from: CompatPopupMenu.java */
/* renamed from: com.sec.widget.h */
/* loaded from: classes.dex */
class C2136h implements PopupMenu.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C2134f f7784a;

    C2136h(C2134f c2134f) {
        this.f7784a = c2134f;
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.f7784a.f7782d.mo7491a(menuItem);
    }
}
