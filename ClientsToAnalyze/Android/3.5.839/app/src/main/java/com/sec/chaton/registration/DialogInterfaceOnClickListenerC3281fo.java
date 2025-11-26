package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fo */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3281fo implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3268fb f12049a;

    DialogInterfaceOnClickListenerC3281fo(HandlerC3268fb handlerC3268fb) {
        this.f12049a = handlerC3268fb;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12049a.f12036a.getActivity().finish();
    }
}
