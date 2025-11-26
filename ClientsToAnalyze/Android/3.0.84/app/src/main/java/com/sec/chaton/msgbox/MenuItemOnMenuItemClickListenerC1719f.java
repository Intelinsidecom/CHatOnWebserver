package com.sec.chaton.msgbox;

import android.view.MenuItem;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.f */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1719f implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f6376a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f6377b;

    MenuItemOnMenuItemClickListenerC1719f(MsgboxFragment msgboxFragment, boolean z) {
        this.f6377b = msgboxFragment;
        this.f6376a = z;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f6377b.m7012a(this.f6376a, this.f6377b.f6278r);
        return true;
    }
}
