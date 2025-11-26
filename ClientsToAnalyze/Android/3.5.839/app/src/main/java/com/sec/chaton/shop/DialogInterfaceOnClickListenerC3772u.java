package com.sec.chaton.shop;

import android.content.DialogInterface;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.settings.p096a.p097a.C3438e;
import com.sec.chaton.settings.p096a.p097a.C3445l;

/* compiled from: ShopFontDownloads.java */
/* renamed from: com.sec.chaton.shop.u */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3772u implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f13521a;

    /* renamed from: b */
    final /* synthetic */ C3770s f13522b;

    DialogInterfaceOnClickListenerC3772u(C3770s c3770s, String str) {
        this.f13522b = c3770s;
        this.f13521a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C3438e c3438e = (C3438e) C3445l.m13723a().m13724a(EnumC2258bd.Font, this.f13521a);
        if (c3438e != null) {
            c3438e.m19058a(true);
        }
    }
}
