package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.ac */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2125ac implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8399a;

    DialogInterfaceOnClickListenerC2125ac(AuthenticatorActivity authenticatorActivity) {
        this.f8399a = authenticatorActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f8399a.f8166y != null && this.f8399a.f8166y.isShowing()) {
            this.f8399a.f8166y.dismiss();
        }
    }
}
