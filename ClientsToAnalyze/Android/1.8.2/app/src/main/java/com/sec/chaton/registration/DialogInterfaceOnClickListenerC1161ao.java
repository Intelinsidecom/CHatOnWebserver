package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: ActivityRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ao */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1161ao implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1160an f4363a;

    DialogInterfaceOnClickListenerC1161ao(HandlerC1160an handlerC1160an) {
        this.f4363a = handlerC1160an;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4363a.f4362a.getActivity().finish();
    }
}
