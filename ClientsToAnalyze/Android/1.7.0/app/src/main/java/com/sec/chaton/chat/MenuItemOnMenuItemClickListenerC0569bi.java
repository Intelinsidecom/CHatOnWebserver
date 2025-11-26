package com.sec.chaton.chat;

import android.view.MenuItem;
import com.sec.chaton.chat.p023a.C0523c;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bi */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0569bi implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f1981a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f1982b;

    MenuItemOnMenuItemClickListenerC0569bi(ChatFragment chatFragment, String str) {
        this.f1982b = chatFragment;
        this.f1981a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        new C0523c(this.f1982b.getActivity(), this.f1981a).m2722a();
        return true;
    }
}
