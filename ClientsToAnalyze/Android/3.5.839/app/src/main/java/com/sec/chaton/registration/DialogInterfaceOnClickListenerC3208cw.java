package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.cw */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3208cw implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3204cs f11972a;

    DialogInterfaceOnClickListenerC3208cw(HandlerC3204cs handlerC3204cs) {
        this.f11972a = handlerC3204cs;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f11972a.f11968a.getActivity().finish();
    }
}
