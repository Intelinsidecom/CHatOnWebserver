package com.sec.chaton.msgbox;

import android.content.res.Resources;
import android.view.MenuItem;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.h */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC1721h implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f6380a;

    /* renamed from: b */
    final /* synthetic */ String f6381b;

    /* renamed from: c */
    final /* synthetic */ String f6382c;

    /* renamed from: d */
    final /* synthetic */ String f6383d;

    /* renamed from: e */
    final /* synthetic */ String f6384e;

    /* renamed from: f */
    final /* synthetic */ String f6385f;

    /* renamed from: g */
    final /* synthetic */ String f6386g;

    /* renamed from: h */
    final /* synthetic */ MsgboxFragment f6387h;

    MenuItemOnMenuItemClickListenerC1721h(MsgboxFragment msgboxFragment, boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        this.f6387h = msgboxFragment;
        this.f6380a = z;
        this.f6381b = str;
        this.f6382c = str2;
        this.f6383d = str3;
        this.f6384e = str4;
        this.f6385f = str5;
        this.f6386g = str6;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) throws Resources.NotFoundException {
        this.f6387h.m7013a(this.f6380a, this.f6381b, this.f6382c, this.f6387h.f6278r, this.f6387h.f6281u, this.f6383d, this.f6387h.f6284x, this.f6384e, this.f6385f, this.f6386g);
        return true;
    }
}
