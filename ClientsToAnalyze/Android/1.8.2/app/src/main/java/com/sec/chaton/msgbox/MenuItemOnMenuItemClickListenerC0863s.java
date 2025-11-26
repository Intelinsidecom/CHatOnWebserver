package com.sec.chaton.msgbox;

import android.view.MenuItem;
import com.sec.chaton.p017e.C0701p;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.s */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0863s implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f3188a;

    MenuItemOnMenuItemClickListenerC0863s(MsgboxFragment msgboxFragment) {
        this.f3188a = msgboxFragment;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f3188a.f3117k.startQuery(2, null, C0701p.m3164a(this.f3188a.f3120n), new String[]{"participants_buddy_no"}, null, null, null);
        this.f3188a.m3535a(this.f3188a.f3120n, this.f3188a.f3124r, this.f3188a.f3123q, this.f3188a.f3125s, this.f3188a.f3127u, this.f3188a.f3099C, this.f3188a.f3121o);
        return true;
    }
}
