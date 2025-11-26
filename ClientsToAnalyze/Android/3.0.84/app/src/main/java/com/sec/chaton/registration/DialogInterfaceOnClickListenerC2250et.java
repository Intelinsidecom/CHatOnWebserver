package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.et */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2250et implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2249es f8545a;

    DialogInterfaceOnClickListenerC2250et(HandlerC2249es handlerC2249es) {
        this.f8545a = handlerC2249es;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8545a.f8544a.getActivity().finish();
    }
}
