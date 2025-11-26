package com.sec.chaton.buddy;

import android.view.MenuItem;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.br */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1154br implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4373a;

    MenuItemOnMenuItemClickListenerC1154br(BuddyFragment buddyFragment) {
        this.f4373a = buddyFragment;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f4373a.getActivity().finish();
        return false;
    }
}
