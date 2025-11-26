package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ey */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2255ey implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2249es f8550a;

    DialogInterfaceOnClickListenerC2255ey(HandlerC2249es handlerC2249es) {
        this.f8550a = handlerC2249es;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8550a.f8544a.getActivity().finish();
    }
}
