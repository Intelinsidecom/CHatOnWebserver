package com.sec.chaton.chat;

import android.content.Intent;
import android.view.MenuItem;
import com.sec.chaton.R;
import com.sec.chaton.util.C1766bv;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.n */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0508n implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2114a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f2115b;

    MenuItemOnMenuItemClickListenerC0508n(ChatFragment chatFragment, String str) {
        this.f2115b = chatFragment;
        this.f2114a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        Intent intentM5994a = C1766bv.m5994a(this.f2115b.getActivity(), this.f2115b.getString(R.string.trunk_opt_header_share), this.f2114a.substring(7), (String) null, (String) null);
        if (intentM5994a != null) {
            this.f2115b.startActivity(intentM5994a);
            return true;
        }
        return true;
    }
}
