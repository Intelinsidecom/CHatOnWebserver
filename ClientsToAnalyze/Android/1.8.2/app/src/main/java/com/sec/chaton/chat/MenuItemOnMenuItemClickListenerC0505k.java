package com.sec.chaton.chat;

import android.view.MenuItem;
import com.sec.chaton.p017e.C0698m;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.k */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0505k implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2103a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f2104b;

    MenuItemOnMenuItemClickListenerC0505k(ChatFragment chatFragment, String str) {
        this.f2104b = chatFragment;
        this.f2103a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f2104b.f1783X.startDelete(3, null, C0698m.f2626a, "_id='" + this.f2103a + "'", null);
        return true;
    }
}
