package com.sec.chaton.msgbox;

import android.content.res.Resources;
import android.view.MenuItem;
import com.sec.chaton.p057e.EnumC2301u;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.ak */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC2619ak implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ boolean f9458a;

    /* renamed from: b */
    final /* synthetic */ String f9459b;

    /* renamed from: c */
    final /* synthetic */ String f9460c;

    /* renamed from: d */
    final /* synthetic */ String f9461d;

    /* renamed from: e */
    final /* synthetic */ String f9462e;

    /* renamed from: f */
    final /* synthetic */ String f9463f;

    /* renamed from: g */
    final /* synthetic */ String f9464g;

    /* renamed from: h */
    final /* synthetic */ EnumC2301u f9465h;

    /* renamed from: i */
    final /* synthetic */ MsgboxFragment f9466i;

    MenuItemOnMenuItemClickListenerC2619ak(MsgboxFragment msgboxFragment, boolean z, String str, String str2, String str3, String str4, String str5, String str6, EnumC2301u enumC2301u) {
        this.f9466i = msgboxFragment;
        this.f9458a = z;
        this.f9459b = str;
        this.f9460c = str2;
        this.f9461d = str3;
        this.f9462e = str4;
        this.f9463f = str5;
        this.f9464g = str6;
        this.f9465h = enumC2301u;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) throws Resources.NotFoundException {
        this.f9466i.m11043a(this.f9458a, this.f9459b, this.f9460c, this.f9466i.f9326E, this.f9466i.f9329H, this.f9461d, this.f9466i.f9332K, this.f9462e, this.f9463f, this.f9464g, this.f9465h);
        return true;
    }
}
