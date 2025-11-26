package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.q */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1204q implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1201n f4420a;

    DialogInterfaceOnClickListenerC1204q(HandlerC1201n handlerC1201n) {
        this.f4420a = handlerC1201n;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }
}
