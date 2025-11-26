package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: ActivityRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ax */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0952ax implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0935ag f3343a;

    DialogInterfaceOnClickListenerC0952ax(HandlerC0935ag handlerC0935ag) {
        this.f3343a = handlerC0935ag;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3343a.f3322a.getActivity().finish();
    }
}
