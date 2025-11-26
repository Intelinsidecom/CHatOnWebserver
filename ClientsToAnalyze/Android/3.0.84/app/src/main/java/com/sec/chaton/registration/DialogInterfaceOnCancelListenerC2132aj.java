package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.aj */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2132aj implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8406a;

    DialogInterfaceOnCancelListenerC2132aj(AuthenticatorActivity authenticatorActivity) {
        this.f8406a = authenticatorActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f8406a.finish();
    }
}
