package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.be */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2154be implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8430a;

    DialogInterfaceOnCancelListenerC2154be(AuthenticatorActivity authenticatorActivity) {
        this.f8430a = authenticatorActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f8430a.finish();
    }
}
