package com.sec.chaton.registration;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.sec.chaton.util.C3159aa;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.ap */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2138ap implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f8412a;

    DialogInterfaceOnClickListenerC2138ap(AuthenticatorActivity authenticatorActivity) {
        this.f8412a = authenticatorActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws PackageManager.NameNotFoundException {
        C3159aa.m10963a("PacketDataDialg", Boolean.valueOf(this.f8412a.f8156o));
        this.f8412a.m8446b((Bundle) null);
    }
}
