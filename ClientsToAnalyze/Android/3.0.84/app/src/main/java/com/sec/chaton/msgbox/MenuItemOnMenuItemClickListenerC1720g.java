package com.sec.chaton.msgbox;

import android.view.MenuItem;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.g */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1720g implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f6378a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f6379b;

    MenuItemOnMenuItemClickListenerC1720g(MsgboxFragment msgboxFragment, boolean z) {
        this.f6379b = msgboxFragment;
        this.f6378a = z;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f6379b.m7012a(this.f6378a, this.f6379b.f6278r);
        return true;
    }
}
