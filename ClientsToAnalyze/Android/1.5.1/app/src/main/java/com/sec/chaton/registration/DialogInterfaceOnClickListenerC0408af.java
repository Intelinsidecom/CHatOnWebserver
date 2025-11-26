package com.sec.chaton.registration;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.registration.af */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0408af implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0442r f2916a;

    DialogInterfaceOnClickListenerC0408af(HandlerC0442r handlerC0442r) {
        this.f2916a = handlerC0442r;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2916a.f2955a.getActivity().finish();
    }
}
