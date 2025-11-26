package com.sec.chaton.shop;

import android.content.DialogInterface;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.settings.p096a.p097a.C3445l;
import com.sec.chaton.settings.p096a.p097a.C3451r;

/* compiled from: ShopRingToneDownloads.java */
/* renamed from: com.sec.chaton.shop.ap */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3725ap implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ String f13398a;

    /* renamed from: b */
    final /* synthetic */ C3723an f13399b;

    DialogInterfaceOnClickListenerC3725ap(C3723an c3723an, String str) {
        this.f13399b = c3723an;
        this.f13398a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C3451r c3451r = (C3451r) C3445l.m13723a().m13724a(EnumC2258bd.Sound, this.f13398a);
        if (c3451r != null) {
            c3451r.m19058a(true);
        }
    }
}
