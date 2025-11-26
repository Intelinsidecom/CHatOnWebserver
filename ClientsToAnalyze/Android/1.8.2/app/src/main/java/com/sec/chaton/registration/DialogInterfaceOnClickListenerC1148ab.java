package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: ActivityProvisioning.java */
/* renamed from: com.sec.chaton.registration.ab */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1148ab implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1210w f4350a;

    DialogInterfaceOnClickListenerC1148ab(HandlerC1210w handlerC1210w) {
        this.f4350a = handlerC1210w;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4350a.f4426a.getActivity().finish();
    }
}
