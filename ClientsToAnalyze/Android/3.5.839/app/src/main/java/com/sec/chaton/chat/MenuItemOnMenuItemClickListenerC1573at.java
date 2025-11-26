package com.sec.chaton.chat;

import android.view.MenuItem;
import com.sec.chaton.chat.p054a.C1546s;
import com.sec.chaton.chat.p054a.InterfaceC1544q;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.at */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1573at implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ InterfaceC1544q f5997a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f5998b;

    MenuItemOnMenuItemClickListenerC1573at(ChatFragment chatFragment, InterfaceC1544q interfaceC1544q) {
        this.f5998b = chatFragment;
        this.f5997a = interfaceC1544q;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f5998b.mo8272q();
        C1546s c1546sMo8374j = this.f5997a.mo8374j();
        this.f5998b.startActivity(this.f5998b.m7884a(c1546sMo8374j.f5951c, c1546sMo8374j.f5949a, c1546sMo8374j.f5950b));
        return true;
    }
}
