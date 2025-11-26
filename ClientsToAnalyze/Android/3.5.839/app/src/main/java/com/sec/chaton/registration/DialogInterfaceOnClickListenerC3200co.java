package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.co */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3200co implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3199cn f11964a;

    DialogInterfaceOnClickListenerC3200co(HandlerC3199cn handlerC3199cn) {
        this.f11964a = handlerC3199cn;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f11964a.f11963a.getActivity().finish();
    }
}
