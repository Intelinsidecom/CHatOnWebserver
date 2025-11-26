package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: ActivityProvisioning.java */
/* renamed from: com.sec.chaton.registration.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3301h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3293g f12078a;

    DialogInterfaceOnClickListenerC3301h(HandlerC3293g handlerC3293g) {
        this.f12078a = handlerC3293g;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12078a.f12061a.getActivity().finish();
    }
}
