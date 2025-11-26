package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.eh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2238eh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2237eg f8533a;

    DialogInterfaceOnClickListenerC2238eh(HandlerC2237eg handlerC2237eg) {
        this.f8533a = handlerC2237eg;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8533a.f8532a.getActivity().finish();
    }
}
