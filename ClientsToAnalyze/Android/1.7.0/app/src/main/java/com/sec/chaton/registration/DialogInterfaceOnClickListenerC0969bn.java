package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: ActivityProvisioning.java */
/* renamed from: com.sec.chaton.registration.bn */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0969bn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0975g f3366a;

    DialogInterfaceOnClickListenerC0969bn(HandlerC0975g handlerC0975g) {
        this.f3366a = handlerC0975g;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3366a.f3372a.getActivity().finish();
    }
}
