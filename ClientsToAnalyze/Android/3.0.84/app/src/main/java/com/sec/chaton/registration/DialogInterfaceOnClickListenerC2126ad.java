package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.ad */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2126ad implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8400a;

    DialogInterfaceOnClickListenerC2126ad(AuthenticatorActivity authenticatorActivity) {
        this.f8400a = authenticatorActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8400a.finish();
    }
}
