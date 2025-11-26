package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fm */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3279fm implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3268fb f12047a;

    DialogInterfaceOnClickListenerC3279fm(HandlerC3268fb handlerC3268fb) {
        this.f12047a = handlerC3268fb;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12047a.f12036a.getActivity().finish();
    }
}
