package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2265fh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2249es f8561a;

    DialogInterfaceOnClickListenerC2265fh(HandlerC2249es handlerC2249es) {
        this.f8561a = handlerC2249es;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8561a.f8544a.getActivity().finish();
    }
}
