package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ff */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2263ff implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2249es f8559a;

    DialogInterfaceOnClickListenerC2263ff(HandlerC2249es handlerC2249es) {
        this.f8559a = handlerC2249es;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8559a.f8544a.getActivity().finish();
    }
}
