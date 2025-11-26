package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: ActivityProvisioning.java */
/* renamed from: com.sec.chaton.registration.i */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2292i implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2291h f8597a;

    DialogInterfaceOnClickListenerC2292i(HandlerC2291h handlerC2291h) {
        this.f8597a = handlerC2291h;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8597a.f8596a.getActivity().finish();
    }
}
