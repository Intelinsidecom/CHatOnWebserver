package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.bd */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2153bd implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8429a;

    DialogInterfaceOnClickListenerC2153bd(AuthenticatorActivity authenticatorActivity) {
        this.f8429a = authenticatorActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8429a.finish();
    }
}
