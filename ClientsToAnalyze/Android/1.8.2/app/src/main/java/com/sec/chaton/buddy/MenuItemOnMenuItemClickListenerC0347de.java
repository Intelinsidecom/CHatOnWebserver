package com.sec.chaton.buddy;

import android.view.MenuItem;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.de */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0347de implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f1490a;

    /* renamed from: b */
    final /* synthetic */ BuddyProfileFragment f1491b;

    MenuItemOnMenuItemClickListenerC0347de(BuddyProfileFragment buddyProfileFragment, String str) {
        this.f1491b = buddyProfileFragment;
        this.f1490a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != 2000) {
            return false;
        }
        this.f1491b.f1118aa.m2902b(this.f1491b.f1159u, this.f1490a);
        return true;
    }
}
