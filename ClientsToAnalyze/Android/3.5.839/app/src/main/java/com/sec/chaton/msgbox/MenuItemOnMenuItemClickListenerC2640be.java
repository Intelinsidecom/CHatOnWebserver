package com.sec.chaton.msgbox;

import android.view.MenuItem;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.be */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC2640be implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f9491a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f9492b;

    MenuItemOnMenuItemClickListenerC2640be(MsgboxFragment msgboxFragment, boolean z) {
        this.f9492b = msgboxFragment;
        this.f9491a = z;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f9492b.m11048b(this.f9491a, this.f9492b.f9326E);
        return true;
    }
}
