package com.sec.chaton.msgbox;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MenuItem;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.specialbuddy.C4542g;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.ah */
/* loaded from: classes.dex */
class MenuItemOnMenuItemClickListenerC2616ah implements MenuItem.OnMenuItemClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC2301u f9442a;

    /* renamed from: b */
    final /* synthetic */ String f9443b;

    /* renamed from: c */
    final /* synthetic */ String f9444c;

    /* renamed from: d */
    final /* synthetic */ String f9445d;

    /* renamed from: e */
    final /* synthetic */ String f9446e;

    /* renamed from: f */
    final /* synthetic */ boolean f9447f;

    /* renamed from: g */
    final /* synthetic */ String f9448g;

    /* renamed from: h */
    final /* synthetic */ String f9449h;

    /* renamed from: i */
    final /* synthetic */ String f9450i;

    /* renamed from: j */
    final /* synthetic */ int f9451j;

    /* renamed from: k */
    final /* synthetic */ boolean f9452k;

    /* renamed from: l */
    final /* synthetic */ MsgboxFragment f9453l;

    MenuItemOnMenuItemClickListenerC2616ah(MsgboxFragment msgboxFragment, EnumC2301u enumC2301u, String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, int i, boolean z2) {
        this.f9453l = msgboxFragment;
        this.f9442a = enumC2301u;
        this.f9443b = str;
        this.f9444c = str2;
        this.f9445d = str3;
        this.f9446e = str4;
        this.f9447f = z;
        this.f9448g = str5;
        this.f9449h = str6;
        this.f9450i = str7;
        this.f9451j = i;
        this.f9452k = z2;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) throws Resources.NotFoundException {
        if (this.f9442a != EnumC2301u.LIVE) {
            if (this.f9453l.f9329H != EnumC2300t.TOPIC) {
                this.f9453l.m11042a(this.f9443b, "", this.f9447f, this.f9453l.f9326E, this.f9448g, this.f9453l.f9329H, this.f9453l.f9327F, this.f9453l.f9330I, this.f9453l.f9331J, this.f9449h, this.f9450i, this.f9442a, this.f9451j, this.f9452k, this.f9453l.f9332K);
                return true;
            }
            if (!TextUtils.isEmpty(this.f9445d)) {
                this.f9453l.m11042a(this.f9445d, this.f9446e, this.f9447f, this.f9453l.f9326E, this.f9448g, this.f9453l.f9329H, this.f9453l.f9327F, this.f9453l.f9330I, this.f9453l.f9331J, this.f9449h, this.f9450i, this.f9442a, this.f9451j, this.f9452k, this.f9453l.f9332K);
                return true;
            }
            return true;
        }
        Intent intentM17225a = C4542g.m17225a(this.f9453l.getActivity(), String.valueOf(this.f9443b));
        intentM17225a.putExtra("key_buddy_name", this.f9444c);
        this.f9453l.startActivity(intentM17225a);
        return true;
    }
}
