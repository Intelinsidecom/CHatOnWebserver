package com.sec.chaton.chat;

import android.view.MenuItem;
import com.sec.chaton.chat.translate.C1850c;
import com.sec.widget.C5179v;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ay */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1578ay implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f6006a;

    /* renamed from: b */
    final /* synthetic */ C1850c f6007b;

    /* renamed from: c */
    final /* synthetic */ C1729gb f6008c;

    /* renamed from: d */
    final /* synthetic */ ChatFragment f6009d;

    MenuItemOnMenuItemClickListenerC1578ay(ChatFragment chatFragment, boolean z, C1850c c1850c, C1729gb c1729gb) {
        this.f6009d = chatFragment;
        this.f6006a = z;
        this.f6007b = c1850c;
        this.f6008c = c1729gb;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (this.f6006a) {
            if (this.f6009d.f5699dn) {
                this.f6009d.m7931a(this.f6007b, this.f6008c, ChatFragment.f5459P, ChatFragment.f5460Q);
                return true;
            }
            this.f6009d.m7929a(this.f6008c);
            return true;
        }
        C5179v.m19811a(this.f6009d.getActivity(), "Already Translated", 0).show();
        return true;
    }
}
