package com.sec.chaton.msgbox;

import android.view.MenuItem;
import com.sec.chaton.chat.C1736gi;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.ad */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC2612ad implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f9431a;

    /* renamed from: b */
    final /* synthetic */ String f9432b;

    /* renamed from: c */
    final /* synthetic */ String f9433c;

    /* renamed from: d */
    final /* synthetic */ MsgboxFragment f9434d;

    MenuItemOnMenuItemClickListenerC2612ad(MsgboxFragment msgboxFragment, String str, String str2, String str3) {
        this.f9434d = msgboxFragment;
        this.f9431a = str;
        this.f9432b = str2;
        this.f9433c = str3;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        C1736gi.m8639a(this.f9434d.getActivity(), this.f9431a, this.f9432b, this.f9433c);
        return true;
    }
}
