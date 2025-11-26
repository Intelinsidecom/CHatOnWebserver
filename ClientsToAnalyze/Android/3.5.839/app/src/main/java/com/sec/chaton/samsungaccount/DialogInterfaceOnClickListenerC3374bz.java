package com.sec.chaton.samsungaccount;

import android.content.DialogInterface;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.bz */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3374bz implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3371bw f12331a;

    DialogInterfaceOnClickListenerC3374bz(HandlerC3371bw handlerC3371bw) {
        this.f12331a = handlerC3371bw;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12331a.f12328a.dismiss();
    }
}
