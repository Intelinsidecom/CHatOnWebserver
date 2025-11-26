package com.sec.chaton.userprofile;

import android.view.MenuItem;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.n */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1704n implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f6215a;

    /* renamed from: b */
    final /* synthetic */ String f6216b;

    /* renamed from: c */
    final /* synthetic */ MyPageFragment f6217c;

    MenuItemOnMenuItemClickListenerC1704n(MyPageFragment myPageFragment, String str, String str2) {
        this.f6217c = myPageFragment;
        this.f6215a = str;
        this.f6216b = str2;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == 0) {
            if (this.f6215a.equals(this.f6217c.f5859z)) {
                this.f6217c.f5824L.m2899a(this.f6217c.f5859z, this.f6216b, "false");
                this.f6217c.f5832T.show();
            } else {
                this.f6217c.f5824L.m2899a(this.f6215a, this.f6216b, "true");
                this.f6217c.f5832T.show();
            }
            return true;
        }
        return false;
    }
}
