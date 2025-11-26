package com.sec.chaton.shop;

import android.content.DialogInterface;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.settings.p096a.p097a.C3445l;
import com.sec.chaton.settings.p096a.p097a.C3451r;

/* compiled from: ShopMultiDownloadRingTone.java */
/* renamed from: com.sec.chaton.shop.y */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3776y implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC2258bd f13540a;

    /* renamed from: b */
    final /* synthetic */ String f13541b;

    /* renamed from: c */
    final /* synthetic */ C3773v f13542c;

    DialogInterfaceOnClickListenerC3776y(C3773v c3773v, EnumC2258bd enumC2258bd, String str) {
        this.f13542c = c3773v;
        this.f13540a = enumC2258bd;
        this.f13541b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C3451r c3451r = (C3451r) C3445l.m13723a().m13724a(this.f13540a, this.f13541b);
        if (c3451r != null) {
            c3451r.m19058a(true);
        }
        if (this.f13542c.f13532j != null) {
            this.f13542c.f13532j.cancel(true);
        }
    }
}
