package com.sec.chaton.userprofile;

import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.as */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC3093as implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f11305a;

    /* renamed from: b */
    final /* synthetic */ MyPageFragment f11306b;

    MenuItemOnMenuItemClickListenerC3093as(MyPageFragment myPageFragment, String str) {
        this.f11306b = myPageFragment;
        this.f11305a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != 0) {
            return false;
        }
        this.f11306b.f11185q = AbstractC3271a.m11494a(this.f11306b.getActivity()).mo11495a(R.string.memo_delete_context_menu).mo11506b(R.string.trunk_item_deleted).mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC3095au(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3094at(this)).mo11512b();
        return true;
    }
}
