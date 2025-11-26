package com.sec.chaton.registration;

import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.cu */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3206cu implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3204cs f11970a;

    DialogInterfaceOnClickListenerC3206cu(HandlerC3204cs handlerC3204cs) {
        this.f11970a = handlerC3204cs;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f11970a.f11968a.getActivity() != null) {
            this.f11970a.f11968a.getActivity().setResult(2, new Intent());
            this.f11970a.f11968a.getActivity().finish();
        }
    }
}
