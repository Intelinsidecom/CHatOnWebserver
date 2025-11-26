package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3283fq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3268fb f12051a;

    DialogInterfaceOnClickListenerC3283fq(HandlerC3268fb handlerC3268fb) {
        this.f12051a = handlerC3268fb;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12051a.f12036a.getActivity().finish();
    }
}
