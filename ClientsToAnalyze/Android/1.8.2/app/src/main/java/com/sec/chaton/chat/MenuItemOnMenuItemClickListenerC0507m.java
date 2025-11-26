package com.sec.chaton.chat;

import android.view.MenuItem;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.p018a.C0670n;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.m */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0507m implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f2109a;

    /* renamed from: b */
    final /* synthetic */ EnumC0699n f2110b;

    /* renamed from: c */
    final /* synthetic */ String f2111c;

    /* renamed from: d */
    final /* synthetic */ String f2112d;

    /* renamed from: e */
    final /* synthetic */ ChatFragment f2113e;

    MenuItemOnMenuItemClickListenerC0507m(ChatFragment chatFragment, String str, EnumC0699n enumC0699n, String str2, String str3) {
        this.f2113e = chatFragment;
        this.f2109a = str;
        this.f2110b = enumC0699n;
        this.f2111c = str2;
        this.f2112d = str3;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f2113e.m2596a(this.f2110b, this.f2111c, this.f2112d, C0670n.m3084b(this.f2113e.getActivity().getContentResolver(), this.f2109a, null));
        return true;
    }
}
