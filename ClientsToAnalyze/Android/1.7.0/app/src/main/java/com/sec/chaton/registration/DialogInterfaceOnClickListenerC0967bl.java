package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: ActivityProvisioning.java */
/* renamed from: com.sec.chaton.registration.bl */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0967bl implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0975g f3364a;

    DialogInterfaceOnClickListenerC0967bl(HandlerC0975g handlerC0975g) {
        this.f3364a = handlerC0975g;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3364a.f3372a.getActivity().finish();
    }
}
