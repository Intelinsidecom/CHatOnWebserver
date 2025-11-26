package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.cq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3202cq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3199cn f11966a;

    DialogInterfaceOnClickListenerC3202cq(HandlerC3199cn handlerC3199cn) {
        this.f11966a = handlerC3199cn;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f11966a.f11963a.getActivity().finish();
    }
}
