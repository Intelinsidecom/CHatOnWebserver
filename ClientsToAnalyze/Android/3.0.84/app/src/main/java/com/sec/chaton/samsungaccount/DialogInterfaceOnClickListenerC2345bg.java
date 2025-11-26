package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.bg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2345bg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2342bd f8798a;

    DialogInterfaceOnClickListenerC2345bg(HandlerC2342bd handlerC2342bd) {
        this.f8798a = handlerC2342bd;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8798a.f8795a.dismiss();
    }
}
