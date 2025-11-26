package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fb */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2259fb implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2249es f8555a;

    DialogInterfaceOnClickListenerC2259fb(HandlerC2249es handlerC2249es) {
        this.f8555a = handlerC2249es;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8555a.f8544a.getActivity().finish();
    }
}
