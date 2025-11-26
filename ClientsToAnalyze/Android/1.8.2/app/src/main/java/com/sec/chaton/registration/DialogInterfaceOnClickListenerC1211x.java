package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: ActivityProvisioning.java */
/* renamed from: com.sec.chaton.registration.x */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1211x implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1210w f4427a;

    DialogInterfaceOnClickListenerC1211x(HandlerC1210w handlerC1210w) {
        this.f4427a = handlerC1210w;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4427a.f4426a.getActivity().finish();
    }
}
