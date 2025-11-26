package com.sec.chaton.userprofile;

import android.view.MenuItem;

/* renamed from: com.sec.chaton.userprofile.j */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0586j implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f3581a;

    /* renamed from: b */
    final /* synthetic */ String f3582b;

    /* renamed from: c */
    final /* synthetic */ UserProfileFragment f3583c;

    MenuItemOnMenuItemClickListenerC0586j(UserProfileFragment userProfileFragment, String str, String str2) {
        this.f3583c = userProfileFragment;
        this.f3581a = str;
        this.f3582b = str2;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != 0) {
            return false;
        }
        if (this.f3581a.equals(this.f3583c.f3443J)) {
            this.f3583c.f3459Z.m2008a(this.f3583c.f3443J, this.f3582b, "false");
            this.f3583c.f3471al.show();
        } else {
            this.f3583c.f3459Z.m2008a(this.f3581a, this.f3582b, "true");
            this.f3583c.f3471al.show();
        }
        return true;
    }
}
