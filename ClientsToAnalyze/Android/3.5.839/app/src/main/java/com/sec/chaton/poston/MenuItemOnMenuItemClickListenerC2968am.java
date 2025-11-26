package com.sec.chaton.poston;

import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.am */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC2968am implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f11063a;

    /* renamed from: b */
    final /* synthetic */ String f11064b;

    /* renamed from: c */
    final /* synthetic */ PostONDetailFragment f11065c;

    MenuItemOnMenuItemClickListenerC2968am(PostONDetailFragment postONDetailFragment, String str, String str2) {
        this.f11065c = postONDetailFragment;
        this.f11063a = str;
        this.f11064b = str2;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != 0) {
            return false;
        }
        this.f11065c.f10926ah = AbstractC4932a.m18733a(this.f11065c.getActivity()).mo18734a(R.string.memo_delete_context_menu).mo18746b(R.string.ams_delete_single_item).mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2970ao(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2969an(this)).mo18752b();
        return true;
    }
}
