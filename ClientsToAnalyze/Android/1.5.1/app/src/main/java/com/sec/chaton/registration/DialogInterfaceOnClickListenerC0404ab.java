package com.sec.chaton.registration;

import android.content.DialogInterface;

/* renamed from: com.sec.chaton.registration.ab */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0404ab implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0442r f2912a;

    DialogInterfaceOnClickListenerC0404ab(HandlerC0442r handlerC0442r) {
        this.f2912a = handlerC0442r;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2912a.f2955a.getActivity().finish();
    }
}
