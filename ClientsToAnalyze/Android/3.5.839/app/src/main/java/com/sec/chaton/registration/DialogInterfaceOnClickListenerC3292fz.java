package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: RegisterSMSActivity.java */
/* renamed from: com.sec.chaton.registration.fz */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3292fz implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RegisterSMSActivity f12060a;

    DialogInterfaceOnClickListenerC3292fz(RegisterSMSActivity registerSMSActivity) {
        this.f12060a = registerSMSActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12060a.finish();
    }
}
