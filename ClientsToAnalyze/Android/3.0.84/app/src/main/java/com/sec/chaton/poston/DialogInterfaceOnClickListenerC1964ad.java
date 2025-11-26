package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ad */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1964ad implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2034y f7656a;

    DialogInterfaceOnClickListenerC1964ad(HandlerC2034y handlerC2034y) {
        this.f7656a = handlerC2034y;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f7656a.f7823a.getActivity().finish();
    }
}
