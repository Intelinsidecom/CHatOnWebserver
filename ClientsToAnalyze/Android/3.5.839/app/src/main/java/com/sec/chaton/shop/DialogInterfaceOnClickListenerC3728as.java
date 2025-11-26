package com.sec.chaton.shop;

import android.content.DialogInterface;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.settings.p096a.p097a.C3445l;
import com.sec.chaton.settings.p096a.p097a.C3447n;

/* compiled from: ShopSkinDownloads.java */
/* renamed from: com.sec.chaton.shop.as */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3728as implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f13406a;

    /* renamed from: b */
    final /* synthetic */ C3726aq f13407b;

    DialogInterfaceOnClickListenerC3728as(C3726aq c3726aq, String str) {
        this.f13407b = c3726aq;
        this.f13406a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C3447n c3447n = (C3447n) C3445l.m13723a().m13724a(EnumC2258bd.Skin, this.f13406a);
        if (c3447n != null) {
            c3447n.m19058a(true);
        }
    }
}
