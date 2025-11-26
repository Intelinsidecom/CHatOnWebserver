package com.sec.chaton.userprofile;

import android.view.MenuItem;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bb */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1232bb implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f4312a;

    /* renamed from: b */
    final /* synthetic */ String f4313b;

    /* renamed from: c */
    final /* synthetic */ MyPageFragment f4314c;

    MenuItemOnMenuItemClickListenerC1232bb(MyPageFragment myPageFragment, String str, String str2) {
        this.f4314c = myPageFragment;
        this.f4312a = str;
        this.f4313b = str2;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == 0) {
            if (this.f4312a.equals(this.f4314c.f4110H)) {
                this.f4314c.f4120R.m866a(this.f4314c.f4110H, this.f4313b, "false");
                this.f4314c.f4132ad.show();
            } else {
                this.f4314c.f4120R.m866a(this.f4312a, this.f4313b, "true");
                this.f4314c.f4132ad.show();
            }
            return true;
        }
        return false;
    }
}
