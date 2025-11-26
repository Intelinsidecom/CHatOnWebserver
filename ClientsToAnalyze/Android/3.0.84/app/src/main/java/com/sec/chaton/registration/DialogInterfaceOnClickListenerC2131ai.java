package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.ai */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2131ai implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8405a;

    DialogInterfaceOnClickListenerC2131ai(AuthenticatorActivity authenticatorActivity) {
        this.f8405a = authenticatorActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8405a.finish();
    }
}
