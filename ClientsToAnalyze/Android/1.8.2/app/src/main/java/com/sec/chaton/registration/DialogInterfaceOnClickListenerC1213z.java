package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: ActivityProvisioning.java */
/* renamed from: com.sec.chaton.registration.z */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1213z implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1210w f4429a;

    DialogInterfaceOnClickListenerC1213z(HandlerC1210w handlerC1210w) {
        this.f4429a = handlerC1210w;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4429a.f4426a.getActivity().finish();
    }
}
