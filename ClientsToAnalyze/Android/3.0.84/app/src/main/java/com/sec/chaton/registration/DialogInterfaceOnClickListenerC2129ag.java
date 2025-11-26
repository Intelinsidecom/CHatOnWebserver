package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.ag */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2129ag implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8403a;

    DialogInterfaceOnClickListenerC2129ag(AuthenticatorActivity authenticatorActivity) {
        this.f8403a = authenticatorActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8403a.finish();
    }
}
