package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.util.C3159aa;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.ao */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2137ao implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8411a;

    DialogInterfaceOnClickListenerC2137ao(AuthenticatorActivity authenticatorActivity) {
        this.f8411a = authenticatorActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C3159aa.m10963a("PacketDataDialg", Boolean.valueOf(this.f8411a.f8156o));
        this.f8411a.finish();
    }
}
