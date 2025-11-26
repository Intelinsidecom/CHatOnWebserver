package com.sec.chaton.msgbox;

import android.view.MenuItem;
import com.sec.chaton.p057e.EnumC2301u;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.ag */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC2615ag implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC2301u f9439a;

    /* renamed from: b */
    final /* synthetic */ boolean f9440b;

    /* renamed from: c */
    final /* synthetic */ MsgboxFragment f9441c;

    MenuItemOnMenuItemClickListenerC2615ag(MsgboxFragment msgboxFragment, EnumC2301u enumC2301u, boolean z) {
        this.f9441c = msgboxFragment;
        this.f9439a = enumC2301u;
        this.f9440b = z;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f9441c.m11041a(this.f9441c.f9326E, this.f9441c.f9327F, this.f9441c.f9329H, this.f9441c.f9330I, this.f9441c.f9331J, this.f9439a, Boolean.valueOf(this.f9440b));
        return true;
    }
}
