package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.do */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2218do implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2217dn f8512a;

    DialogInterfaceOnClickListenerC2218do(HandlerC2217dn handlerC2217dn) {
        this.f8512a = handlerC2217dn;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8512a.f8511a.getActivity().finish();
    }
}
