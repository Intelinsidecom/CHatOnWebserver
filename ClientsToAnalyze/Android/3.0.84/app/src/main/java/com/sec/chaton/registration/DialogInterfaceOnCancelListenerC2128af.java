package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.af */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2128af implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8402a;

    DialogInterfaceOnCancelListenerC2128af(AuthenticatorActivity authenticatorActivity) {
        this.f8402a = authenticatorActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f8402a.finish();
    }
}
