package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3269fc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3268fb f12037a;

    DialogInterfaceOnClickListenerC3269fc(HandlerC3268fb handlerC3268fb) {
        this.f12037a = handlerC3268fb;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12037a.f12036a.getActivity().finish();
    }
}
