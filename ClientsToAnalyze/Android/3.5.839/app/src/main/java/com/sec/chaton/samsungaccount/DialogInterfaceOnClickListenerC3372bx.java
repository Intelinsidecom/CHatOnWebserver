package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.bx */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3372bx implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3371bw f12329a;

    DialogInterfaceOnClickListenerC3372bx(HandlerC3371bw handlerC3371bw) {
        this.f12329a = handlerC3371bw;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12329a.f12328a.dismiss();
    }
}
