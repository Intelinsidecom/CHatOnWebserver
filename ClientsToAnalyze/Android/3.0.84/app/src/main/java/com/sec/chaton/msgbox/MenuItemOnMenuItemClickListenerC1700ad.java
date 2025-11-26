package com.sec.chaton.msgbox;

import android.view.MenuItem;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.ad */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1700ad implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ String f6342a;

    /* renamed from: b */
    final /* synthetic */ boolean f6343b;

    /* renamed from: c */
    final /* synthetic */ String f6344c;

    /* renamed from: d */
    final /* synthetic */ String f6345d;

    /* renamed from: e */
    final /* synthetic */ String f6346e;

    /* renamed from: f */
    final /* synthetic */ MsgboxFragment f6347f;

    MenuItemOnMenuItemClickListenerC1700ad(MsgboxFragment msgboxFragment, String str, boolean z, String str2, String str3, String str4) {
        this.f6347f = msgboxFragment;
        this.f6342a = str;
        this.f6343b = z;
        this.f6344c = str2;
        this.f6345d = str3;
        this.f6346e = str4;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f6347f.m7010a(this.f6342a, this.f6343b, this.f6347f.f6278r, this.f6344c, this.f6347f.f6281u, this.f6347f.f6279s, this.f6347f.f6282v, this.f6347f.f6283w, this.f6345d, this.f6346e);
        return true;
    }
}
