package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.cz */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2202cz implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2194cr f8494a;

    DialogInterfaceOnClickListenerC2202cz(HandlerC2194cr handlerC2194cr) {
        this.f8494a = handlerC2194cr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.f8494a.f8486a.f8239g.length() == 4) {
            this.f8494a.f8486a.f8228I.setEnabled(true);
        }
    }
}
