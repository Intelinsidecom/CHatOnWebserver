package com.sec.chaton.userprofile;

import android.content.DialogInterface;
import com.sec.chaton.p046a.p047a.C0792p;

/* compiled from: EditStatusFragment.java */
/* renamed from: com.sec.chaton.userprofile.u */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC4802u implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC4801t f17534a;

    DialogInterfaceOnClickListenerC4802u(HandlerC4801t handlerC4801t) {
        this.f17534a = handlerC4801t;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C0792p c0792p = new C0792p();
        c0792p.m3158b(this.f17534a.f17533a.f17133c.getText().toString());
        this.f17534a.f17533a.f17134d.m9304a(c0792p, "");
        this.f17534a.f17533a.f17135e.show();
    }
}
