package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.cp */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2192cp implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2189cm f8484a;

    DialogInterfaceOnClickListenerC2192cp(HandlerC2189cm handlerC2189cm) {
        this.f8484a = handlerC2189cm;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8484a.f8481a.getActivity().finish();
    }
}
