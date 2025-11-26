package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.cy */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3210cy implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3204cs f11974a;

    DialogInterfaceOnClickListenerC3210cy(HandlerC3204cs handlerC3204cs) {
        this.f11974a = handlerC3204cs;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.f11974a.f11968a.f11685g.length() == 4) {
            this.f11974a.f11968a.f11673J.setEnabled(true);
        }
    }
}
