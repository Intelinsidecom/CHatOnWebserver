package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2220dq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2217dn f8514a;

    DialogInterfaceOnClickListenerC2220dq(HandlerC2217dn handlerC2217dn) {
        this.f8514a = handlerC2217dn;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8514a.f8511a.getActivity().finish();
    }
}
