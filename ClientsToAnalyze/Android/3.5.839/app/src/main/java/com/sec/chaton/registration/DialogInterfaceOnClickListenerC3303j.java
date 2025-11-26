package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: ActivityProvisioning.java */
/* renamed from: com.sec.chaton.registration.j */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3303j implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3293g f12080a;

    DialogInterfaceOnClickListenerC3303j(HandlerC3293g handlerC3293g) {
        this.f12080a = handlerC3293g;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12080a.f12061a.getActivity().finish();
    }
}
