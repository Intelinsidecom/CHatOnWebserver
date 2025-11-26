package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.bg */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2156bg implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8432a;

    DialogInterfaceOnCancelListenerC2156bg(AuthenticatorActivity authenticatorActivity) {
        this.f8432a = authenticatorActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f8432a.finish();
    }
}
