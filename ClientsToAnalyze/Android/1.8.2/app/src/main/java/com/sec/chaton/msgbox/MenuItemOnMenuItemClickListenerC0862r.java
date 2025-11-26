package com.sec.chaton.msgbox;

import android.view.MenuItem;
import com.sec.chaton.p017e.C0701p;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.r */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0862r implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f3187a;

    MenuItemOnMenuItemClickListenerC0862r(MsgboxFragment msgboxFragment) {
        this.f3187a = msgboxFragment;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f3187a.f3117k.startQuery(2, null, C0701p.m3164a(this.f3187a.f3120n), new String[]{"participants_buddy_no"}, null, null, null);
        this.f3187a.m3535a(this.f3187a.f3120n, this.f3187a.f3124r, this.f3187a.f3123q, this.f3187a.f3125s, this.f3187a.f3127u, this.f3187a.f3099C, this.f3187a.f3121o);
        return true;
    }
}
