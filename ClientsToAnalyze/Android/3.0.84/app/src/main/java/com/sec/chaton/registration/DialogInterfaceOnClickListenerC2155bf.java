package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.bf */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2155bf implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8431a;

    DialogInterfaceOnClickListenerC2155bf(AuthenticatorActivity authenticatorActivity) {
        this.f8431a = authenticatorActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8431a.finish();
    }
}
