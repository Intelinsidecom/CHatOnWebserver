package com.sec.chaton.buddy;

import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.gd */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1324gd implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f4860a;

    /* renamed from: b */
    final /* synthetic */ BuddyProfileFragment f4861b;

    MenuItemOnMenuItemClickListenerC1324gd(BuddyProfileFragment buddyProfileFragment, String str) {
        this.f4861b = buddyProfileFragment;
        this.f4860a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != 2000) {
            return false;
        }
        AbstractC4932a.m18733a(this.f4861b.f3954aU).mo18734a(R.string.memo_delete_context_menu).mo18746b(R.string.ams_delete_single_item).mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1326gf(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1325ge(this)).mo18752b();
        return true;
    }
}
