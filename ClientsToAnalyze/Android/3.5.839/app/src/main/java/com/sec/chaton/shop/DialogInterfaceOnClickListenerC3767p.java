package com.sec.chaton.shop;

import android.content.DialogInterface;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.settings.p096a.p097a.C3434a;
import com.sec.chaton.settings.p096a.p097a.C3445l;

/* compiled from: ShopAniconDownloads.java */
/* renamed from: com.sec.chaton.shop.p */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3767p implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC2258bd f13511a;

    /* renamed from: b */
    final /* synthetic */ String f13512b;

    /* renamed from: c */
    final /* synthetic */ C3765n f13513c;

    DialogInterfaceOnClickListenerC3767p(C3765n c3765n, EnumC2258bd enumC2258bd, String str) {
        this.f13513c = c3765n;
        this.f13511a = enumC2258bd;
        this.f13512b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C3434a c3434a = (C3434a) C3445l.m13723a().m13724a(this.f13511a, this.f13512b);
        if (c3434a != null) {
            c3434a.m19058a(true);
        }
    }
}
