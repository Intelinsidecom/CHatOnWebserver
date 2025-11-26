package com.sec.chaton.chat;

import android.view.MenuItem;
import com.sec.chaton.chat.clipboard.ClipboardManager;

/* renamed from: com.sec.chaton.chat.d */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0142d implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f952a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f953b;

    MenuItemOnMenuItemClickListenerC0142d(ChatFragment chatFragment, String str) {
        this.f953b = chatFragment;
        this.f952a = str;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        new ClipboardManager(this.f953b.getActivity(), this.f952a).m809a();
        return true;
    }
}
