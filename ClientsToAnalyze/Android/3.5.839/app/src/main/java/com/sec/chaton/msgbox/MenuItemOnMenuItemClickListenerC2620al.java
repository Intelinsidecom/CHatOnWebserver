package com.sec.chaton.msgbox;

import android.view.MenuItem;
import com.sec.chaton.p057e.EnumC2301u;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.al */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC2620al implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC2301u f9467a;

    /* renamed from: b */
    final /* synthetic */ boolean f9468b;

    /* renamed from: c */
    final /* synthetic */ MsgboxFragment f9469c;

    MenuItemOnMenuItemClickListenerC2620al(MsgboxFragment msgboxFragment, EnumC2301u enumC2301u, boolean z) {
        this.f9469c = msgboxFragment;
        this.f9467a = enumC2301u;
        this.f9468b = z;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f9469c.m11041a(this.f9469c.f9326E, this.f9469c.f9327F, this.f9469c.f9329H, this.f9469c.f9330I, this.f9469c.f9331J, this.f9467a, Boolean.valueOf(this.f9468b));
        return true;
    }
}
