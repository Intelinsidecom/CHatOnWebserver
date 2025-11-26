package com.sec.chaton.poston;

import android.content.DialogInterface;

/* compiled from: PostONDetailFragment.java */
/* renamed from: com.sec.chaton.poston.ab */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1962ab implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2034y f7654a;

    DialogInterfaceOnClickListenerC1962ab(HandlerC2034y handlerC2034y) {
        this.f7654a = handlerC2034y;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f7654a.f7823a.getActivity().finish();
    }
}
