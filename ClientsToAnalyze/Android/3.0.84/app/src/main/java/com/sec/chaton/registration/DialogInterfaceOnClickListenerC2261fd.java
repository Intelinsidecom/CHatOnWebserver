package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fd */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2261fd implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2249es f8557a;

    DialogInterfaceOnClickListenerC2261fd(HandlerC2249es handlerC2249es) {
        this.f8557a = handlerC2249es;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8557a.f8544a.getActivity().finish();
    }
}
