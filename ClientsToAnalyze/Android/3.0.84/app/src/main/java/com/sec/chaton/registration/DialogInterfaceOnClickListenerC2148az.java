package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.az */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2148az implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8423a;

    DialogInterfaceOnClickListenerC2148az(AuthenticatorActivity authenticatorActivity) {
        this.f8423a = authenticatorActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8423a.finish();
    }
}
