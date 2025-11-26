package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.es */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3258es implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3257er f12025a;

    DialogInterfaceOnClickListenerC3258es(HandlerC3257er handlerC3257er) {
        this.f12025a = handlerC3257er;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12025a.f12024a.getActivity().finish();
    }
}
