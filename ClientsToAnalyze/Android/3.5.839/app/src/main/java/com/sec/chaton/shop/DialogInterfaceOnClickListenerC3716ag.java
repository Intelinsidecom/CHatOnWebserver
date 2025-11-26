package com.sec.chaton.shop;

import android.content.DialogInterface;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.settings.p096a.p097a.C3445l;
import com.sec.chaton.settings.p096a.p097a.C3447n;

/* compiled from: ShopMultiDownloadSkin.java */
/* renamed from: com.sec.chaton.shop.ag */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3716ag implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC2258bd f13367a;

    /* renamed from: b */
    final /* synthetic */ String f13368b;

    /* renamed from: c */
    final /* synthetic */ C3711ab f13369c;

    DialogInterfaceOnClickListenerC3716ag(C3711ab c3711ab, EnumC2258bd enumC2258bd, String str) {
        this.f13369c = c3711ab;
        this.f13367a = enumC2258bd;
        this.f13368b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C3447n c3447n = (C3447n) C3445l.m13723a().m13724a(this.f13367a, this.f13368b);
        if (c3447n != null) {
            c3447n.m19058a(true);
        }
        if (this.f13369c.f13357j != null) {
            this.f13369c.f13357j.cancel(true);
        }
    }
}
