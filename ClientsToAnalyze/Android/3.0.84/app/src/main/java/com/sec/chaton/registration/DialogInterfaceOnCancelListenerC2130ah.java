package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.ah */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2130ah implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8404a;

    DialogInterfaceOnCancelListenerC2130ah(AuthenticatorActivity authenticatorActivity) {
        this.f8404a = authenticatorActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f8404a.finish();
    }
}
