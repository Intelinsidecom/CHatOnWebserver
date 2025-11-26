package com.sec.chaton.buddy;

import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fb */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0691fb implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2913a;

    /* renamed from: b */
    final /* synthetic */ BuddyProfileFragment f2914b;

    MenuItemOnMenuItemClickListenerC0691fb(BuddyProfileFragment buddyProfileFragment, String str) {
        this.f2914b = buddyProfileFragment;
        this.f2913a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != 2000) {
            return false;
        }
        AbstractC3271a.m11494a(this.f2914b.f2058aQ).mo11495a(R.string.memo_delete_context_menu).mo11506b(R.string.trunk_item_deleted).mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0693fd(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0692fc(this)).mo11512b();
        return true;
    }
}
