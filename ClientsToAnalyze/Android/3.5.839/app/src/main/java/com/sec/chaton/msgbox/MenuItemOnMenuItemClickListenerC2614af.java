package com.sec.chaton.msgbox;

import android.view.MenuItem;
import com.sec.chaton.smsplugin.p112ui.C4149cd;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.af */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC2614af implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f9437a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f9438b;

    MenuItemOnMenuItemClickListenerC2614af(MsgboxFragment msgboxFragment, String str) {
        this.f9438b = msgboxFragment;
        this.f9437a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        C4149cd.m16434e(this.f9438b.getActivity(), this.f9437a);
        return true;
    }
}
