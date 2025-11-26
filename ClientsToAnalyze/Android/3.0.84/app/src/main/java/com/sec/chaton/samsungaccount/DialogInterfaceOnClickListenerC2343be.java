package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.be */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2343be implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2342bd f8796a;

    DialogInterfaceOnClickListenerC2343be(HandlerC2342bd handlerC2342bd) {
        this.f8796a = handlerC2342bd;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8796a.f8795a.dismiss();
    }
}
