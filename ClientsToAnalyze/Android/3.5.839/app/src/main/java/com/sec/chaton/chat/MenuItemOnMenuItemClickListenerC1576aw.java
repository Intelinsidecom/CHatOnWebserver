package com.sec.chaton.chat;

import android.view.MenuItem;
import com.sec.chaton.chat.p054a.C1546s;
import com.sec.chaton.chat.p054a.InterfaceC1547t;
import com.sec.chaton.multimedia.p079b.AsyncTaskC2751a;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.aw */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1576aw implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ InterfaceC1547t f6003a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f6004b;

    MenuItemOnMenuItemClickListenerC1576aw(ChatFragment chatFragment, InterfaceC1547t interfaceC1547t) {
        this.f6004b = chatFragment;
        this.f6003a = interfaceC1547t;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f6004b.mo8272q();
        C1546s c1546sMo8414c_ = this.f6003a.mo8414c_();
        AsyncTaskC2751a.m11541a(c1546sMo8414c_.f5949a, c1546sMo8414c_.f5950b, null, true).execute(new String[0]);
        return true;
    }
}
