package com.sec.chaton.chat;

import android.content.Intent;
import android.view.MenuItem;
import com.sec.chaton.chat.p054a.InterfaceC1543p;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.az */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1579az implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ InterfaceC1543p f6010a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f6011b;

    MenuItemOnMenuItemClickListenerC1579az(ChatFragment chatFragment, InterfaceC1543p interfaceC1543p) {
        this.f6011b = chatFragment;
        this.f6010a = interfaceC1543p;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        Intent intentMo8426f_ = this.f6010a.mo8426f_();
        if (intentMo8426f_ != null) {
            this.f6011b.startActivity(intentMo8426f_);
            return true;
        }
        return true;
    }
}
