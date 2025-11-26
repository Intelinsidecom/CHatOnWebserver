package com.sec.chaton.userprofile;

import android.view.MenuItem;

/* compiled from: MyPageBuddiesSay.java */
/* renamed from: com.sec.chaton.userprofile.i */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1699i implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f6208a;

    /* renamed from: b */
    final /* synthetic */ String f6209b;

    /* renamed from: c */
    final /* synthetic */ MyPageBuddiesSay f6210c;

    MenuItemOnMenuItemClickListenerC1699i(MyPageBuddiesSay myPageBuddiesSay, String str, String str2) {
        this.f6210c = myPageBuddiesSay;
        this.f6208a = str;
        this.f6209b = str2;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == 0) {
            if (this.f6208a.equals(this.f6210c.f5799f)) {
                this.f6210c.f5796c.m2899a(this.f6210c.f5799f, this.f6209b, "false");
                this.f6210c.f5804k.show();
            } else {
                this.f6210c.f5796c.m2899a(this.f6208a, this.f6209b, "true");
                this.f6210c.f5804k.show();
            }
            return true;
        }
        return false;
    }
}
