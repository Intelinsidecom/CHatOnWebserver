package com.sec.chaton.chat;

import android.view.MenuItem;
import com.sec.chaton.chat.p013a.C0457c;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.j */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0504j implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2101a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f2102b;

    MenuItemOnMenuItemClickListenerC0504j(ChatFragment chatFragment, String str) {
        this.f2102b = chatFragment;
        this.f2101a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        new C0457c(this.f2102b.getActivity(), this.f2101a).m2616a();
        return true;
    }
}
