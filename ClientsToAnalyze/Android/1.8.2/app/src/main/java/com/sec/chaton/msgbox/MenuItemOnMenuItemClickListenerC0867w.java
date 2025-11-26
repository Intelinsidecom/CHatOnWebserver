package com.sec.chaton.msgbox;

import android.content.Intent;
import android.view.MenuItem;
import com.sec.chaton.buddy.SpecialBuddyActivity;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.w */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0867w implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f3198a;

    /* renamed from: b */
    final /* synthetic */ MsgboxFragment f3199b;

    MenuItemOnMenuItemClickListenerC0867w(MsgboxFragment msgboxFragment, String str) {
        this.f3199b = msgboxFragment;
        this.f3198a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent(this.f3199b.getActivity(), (Class<?>) SpecialBuddyActivity.class);
        intent.putExtra("specialuserid", this.f3198a);
        intent.putExtra("specialBuddyAdded", true);
        this.f3199b.startActivity(intent);
        return true;
    }
}
