package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3274fh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3268fb f12042a;

    DialogInterfaceOnClickListenerC3274fh(HandlerC3268fb handlerC3268fb) {
        this.f12042a = handlerC3268fb;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12042a.f12036a.getActivity().finish();
    }
}
