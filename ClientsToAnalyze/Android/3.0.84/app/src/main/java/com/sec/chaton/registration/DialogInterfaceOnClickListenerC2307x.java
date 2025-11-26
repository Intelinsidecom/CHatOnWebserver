package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: ActivitySyncSignInPopup.java */
/* renamed from: com.sec.chaton.registration.x */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2307x implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2306w f8614a;

    DialogInterfaceOnClickListenerC2307x(HandlerC2306w handlerC2306w) {
        this.f8614a = handlerC2306w;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8614a.f8613a.finish();
    }
}
