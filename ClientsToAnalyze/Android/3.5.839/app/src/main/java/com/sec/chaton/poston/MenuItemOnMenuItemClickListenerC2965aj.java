package com.sec.chaton.poston;

import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.aj */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC2965aj implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f11057a;

    /* renamed from: b */
    final /* synthetic */ String f11058b;

    /* renamed from: c */
    final /* synthetic */ String f11059c;

    /* renamed from: d */
    final /* synthetic */ PostONDetailFragment f11060d;

    MenuItemOnMenuItemClickListenerC2965aj(PostONDetailFragment postONDetailFragment, String str, String str2, String str3) {
        this.f11060d = postONDetailFragment;
        this.f11057a = str;
        this.f11058b = str2;
        this.f11059c = str3;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != 0) {
            return false;
        }
        this.f11060d.f10926ah = AbstractC4932a.m18733a(this.f11060d.getActivity()).mo18734a(R.string.memo_delete_context_menu).mo18746b(R.string.ams_delete_single_item).mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2967al(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2966ak(this)).mo18752b();
        return true;
    }
}
