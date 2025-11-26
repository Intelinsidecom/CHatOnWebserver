package com.sec.chaton.chat;

import android.view.MenuItem;
import com.sec.chaton.chat.p023a.C0910n;
import com.sec.chaton.chat.p023a.InterfaceC0909m;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ac */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC0925ac implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ InterfaceC0909m f3862a;

    /* renamed from: b */
    final /* synthetic */ ChatFragment f3863b;

    MenuItemOnMenuItemClickListenerC0925ac(ChatFragment chatFragment, InterfaceC0909m interfaceC0909m) {
        this.f3863b = chatFragment;
        this.f3862a = interfaceC0909m;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f3863b.mo5019t();
        C0910n c0910nMo5097h = this.f3862a.mo5097h();
        this.f3863b.startActivity(this.f3863b.m4863b(c0910nMo5097h.f3842c, c0910nMo5097h.f3840a, c0910nMo5097h.f3841b));
        return true;
    }
}
