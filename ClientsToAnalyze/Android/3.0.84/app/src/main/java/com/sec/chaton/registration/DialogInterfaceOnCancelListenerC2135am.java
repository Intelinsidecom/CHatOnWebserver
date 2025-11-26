package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.am */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2135am implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8409a;

    DialogInterfaceOnCancelListenerC2135am(AuthenticatorActivity authenticatorActivity) {
        this.f8409a = authenticatorActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f8409a.finish();
    }
}
