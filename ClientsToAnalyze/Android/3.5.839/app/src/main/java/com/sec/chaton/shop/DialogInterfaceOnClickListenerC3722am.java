package com.sec.chaton.shop;

import android.content.DialogInterface;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.settings.p096a.p097a.C3434a;
import com.sec.chaton.settings.p096a.p097a.C3445l;

/* compiled from: ShopMultiDownloadSticker.java */
/* renamed from: com.sec.chaton.shop.am */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3722am implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC2258bd f13389a;

    /* renamed from: b */
    final /* synthetic */ String f13390b;

    /* renamed from: c */
    final /* synthetic */ C3717ah f13391c;

    DialogInterfaceOnClickListenerC3722am(C3717ah c3717ah, EnumC2258bd enumC2258bd, String str) {
        this.f13391c = c3717ah;
        this.f13389a = enumC2258bd;
        this.f13390b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C3434a c3434a = (C3434a) C3445l.m13723a().m13724a(this.f13389a, this.f13390b);
        if (c3434a != null) {
            c3434a.m19058a(true);
        }
        if (this.f13391c.f13379j != null) {
            this.f13391c.f13379j.cancel(true);
        }
    }
}
