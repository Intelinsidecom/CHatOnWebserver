package com.sec.chaton.poston;

import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ak */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1971ak implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f7666a;

    /* renamed from: b */
    final /* synthetic */ String f7667b;

    /* renamed from: c */
    final /* synthetic */ PostONDetailFragment f7668c;

    MenuItemOnMenuItemClickListenerC1971ak(PostONDetailFragment postONDetailFragment, String str, String str2) {
        this.f7668c = postONDetailFragment;
        this.f7666a = str;
        this.f7667b = str2;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != 0) {
            return false;
        }
        this.f7668c.f7536ah = AbstractC3271a.m11494a(this.f7668c.getActivity()).mo11495a(R.string.memo_delete_context_menu).mo11506b(R.string.trunk_item_deleted).mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1973am(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1972al(this)).mo11512b();
        return true;
    }
}
