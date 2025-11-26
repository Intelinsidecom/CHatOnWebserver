package com.sec.chaton.buddy;

import android.view.MenuItem;

/* renamed from: com.sec.chaton.buddy.ab */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0078ab implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f611a;

    /* renamed from: b */
    final /* synthetic */ BuddyProfileActivity f612b;

    MenuItemOnMenuItemClickListenerC0078ab(BuddyProfileActivity buddyProfileActivity, String str) {
        this.f612b = buddyProfileActivity;
        this.f611a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != 2000) {
            return false;
        }
        this.f612b.f565L.m2010b(this.f612b.f586k, this.f611a);
        this.f612b.f561H.show();
        return true;
    }
}
