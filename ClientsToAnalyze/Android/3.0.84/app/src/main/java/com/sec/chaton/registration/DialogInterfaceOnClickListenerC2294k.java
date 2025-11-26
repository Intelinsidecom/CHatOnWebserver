package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: ActivityProvisioning.java */
/* renamed from: com.sec.chaton.registration.k */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2294k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2291h f8599a;

    DialogInterfaceOnClickListenerC2294k(HandlerC2291h handlerC2291h) {
        this.f8599a = handlerC2291h;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8599a.f8596a.getActivity().finish();
    }
}
