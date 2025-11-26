package com.sec.chaton.msgbox;

import android.view.MenuItem;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.ai */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC2617ai implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f9454a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f9455b;

    MenuItemOnMenuItemClickListenerC2617ai(MsgboxFragment msgboxFragment, boolean z) {
        this.f9455b = msgboxFragment;
        this.f9454a = z;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f9455b.m11048b(this.f9454a, this.f9455b.f9326E);
        return true;
    }
}
