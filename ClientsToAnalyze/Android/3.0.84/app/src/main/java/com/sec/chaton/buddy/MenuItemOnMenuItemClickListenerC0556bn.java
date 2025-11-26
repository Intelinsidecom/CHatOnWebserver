package com.sec.chaton.buddy;

import android.view.MenuItem;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bn */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0556bn implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2515a;

    MenuItemOnMenuItemClickListenerC0556bn(BuddyFragment buddyFragment) {
        this.f2515a = buddyFragment;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f2515a.getActivity().finish();
        return false;
    }
}
