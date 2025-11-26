package com.sec.chaton.poston;

import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.common.p063a.AbstractC3271a;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ah */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1968ah implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f7660a;

    /* renamed from: b */
    final /* synthetic */ String f7661b;

    /* renamed from: c */
    final /* synthetic */ String f7662c;

    /* renamed from: d */
    final /* synthetic */ PostONDetailFragment f7663d;

    MenuItemOnMenuItemClickListenerC1968ah(PostONDetailFragment postONDetailFragment, String str, String str2, String str3) {
        this.f7663d = postONDetailFragment;
        this.f7660a = str;
        this.f7661b = str2;
        this.f7662c = str3;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != 0) {
            return false;
        }
        this.f7663d.f7536ah = AbstractC3271a.m11494a(this.f7663d.getActivity()).mo11495a(R.string.memo_delete_context_menu).mo11506b(R.string.trunk_item_deleted).mo11511b(true).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1970aj(this)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC1969ai(this)).mo11512b();
        return true;
    }
}
