package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.cx */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2200cx implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2194cr f8492a;

    DialogInterfaceOnClickListenerC2200cx(HandlerC2194cr handlerC2194cr) {
        this.f8492a = handlerC2194cr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8492a.f8486a.getActivity().finish();
    }
}
