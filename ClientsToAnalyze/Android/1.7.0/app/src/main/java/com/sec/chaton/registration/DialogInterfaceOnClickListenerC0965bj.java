package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: ActivityProvisioning.java */
/* renamed from: com.sec.chaton.registration.bj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0965bj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0975g f3362a;

    DialogInterfaceOnClickListenerC0965bj(HandlerC0975g handlerC0975g) {
        this.f3362a = handlerC0975g;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3362a.f3372a.getActivity().finish();
    }
}
