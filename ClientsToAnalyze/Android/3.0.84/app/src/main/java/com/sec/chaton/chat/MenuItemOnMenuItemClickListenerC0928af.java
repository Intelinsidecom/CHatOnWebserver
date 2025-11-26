package com.sec.chaton.chat;

import android.view.MenuItem;
import com.sec.chaton.chat.p023a.C0910n;
import com.sec.chaton.chat.p023a.InterfaceC0911o;
import com.sec.chaton.multimedia.p048a.AsyncTaskC1767a;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.af */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0928af implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ InterfaceC0911o f3868a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f3869b;

    MenuItemOnMenuItemClickListenerC0928af(ChatFragment chatFragment, InterfaceC0911o interfaceC0911o) {
        this.f3869b = chatFragment;
        this.f3868a = interfaceC0911o;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f3869b.mo5019t();
        C0910n c0910nMo5101e_ = this.f3868a.mo5101e_();
        new AsyncTaskC1767a(c0910nMo5101e_.f3840a, c0910nMo5101e_.f3841b, true).execute(new String[0]);
        return true;
    }
}
