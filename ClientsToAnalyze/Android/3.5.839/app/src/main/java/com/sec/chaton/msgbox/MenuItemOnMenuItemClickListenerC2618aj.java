package com.sec.chaton.msgbox;

import android.view.MenuItem;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.aj */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC2618aj implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f9456a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f9457b;

    MenuItemOnMenuItemClickListenerC2618aj(MsgboxFragment msgboxFragment, boolean z) {
        this.f9457b = msgboxFragment;
        this.f9456a = z;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f9457b.m11048b(this.f9456a, this.f9457b.f9326E);
        return true;
    }
}
