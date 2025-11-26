package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.aq */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC2139aq implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8413a;

    DialogInterfaceOnCancelListenerC2139aq(AuthenticatorActivity authenticatorActivity) {
        this.f8413a = authenticatorActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f8413a.finish();
    }
}
