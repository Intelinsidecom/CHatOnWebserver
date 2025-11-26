package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ae */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1965ae implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2034y f7657a;

    DialogInterfaceOnClickListenerC1965ae(HandlerC2034y handlerC2034y) {
        this.f7657a = handlerC2034y;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f7657a.f7823a.getActivity().finish();
    }
}
