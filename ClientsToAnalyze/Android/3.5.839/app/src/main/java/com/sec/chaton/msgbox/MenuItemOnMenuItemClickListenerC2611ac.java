package com.sec.chaton.msgbox;

import android.view.MenuItem;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.ac */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC2611ac implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f9429a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f9430b;

    MenuItemOnMenuItemClickListenerC2611ac(MsgboxFragment msgboxFragment, boolean z) {
        this.f9430b = msgboxFragment;
        this.f9429a = z;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f9430b.m11048b(this.f9429a, this.f9430b.f9326E);
        return true;
    }
}
