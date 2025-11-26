package com.sec.chaton.buddy;

import android.view.MenuItem;

/* compiled from: BuddyProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.bb */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0394bb implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f1367a;

    /* renamed from: b */
    final /* synthetic */ BuddyProfileActivity f1368b;

    MenuItemOnMenuItemClickListenerC0394bb(BuddyProfileActivity buddyProfileActivity, String str) {
        this.f1368b = buddyProfileActivity;
        this.f1367a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != 2000) {
            return false;
        }
        this.f1368b.f1216R.m868b(this.f1368b.f1242m, this.f1367a);
        this.f1368b.m2270e();
        return true;
    }
}
