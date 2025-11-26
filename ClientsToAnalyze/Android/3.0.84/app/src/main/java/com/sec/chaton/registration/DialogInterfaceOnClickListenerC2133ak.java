package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.ak */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2133ak implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8407a;

    DialogInterfaceOnClickListenerC2133ak(AuthenticatorActivity authenticatorActivity) {
        this.f8407a = authenticatorActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8407a.finish();
    }
}
