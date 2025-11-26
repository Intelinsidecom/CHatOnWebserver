package com.sec.chaton.userprofile;

import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.common.p123a.AbstractC4932a;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.bh */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC4749bh implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f17413a;

    /* renamed from: b */
    final /* synthetic */ MyPageFragment f17414b;

    MenuItemOnMenuItemClickListenerC4749bh(MyPageFragment myPageFragment, String str) {
        this.f17414b = myPageFragment;
        this.f17413a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() != 0) {
            return false;
        }
        this.f17414b.f17220Y = AbstractC4932a.m18733a(this.f17414b.getActivity()).mo18734a(R.string.memo_delete_context_menu).mo18746b(R.string.ams_delete_single_item).mo18751b(true).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC4751bj(this)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC4750bi(this)).mo18752b();
        return true;
    }
}
