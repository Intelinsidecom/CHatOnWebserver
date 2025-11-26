package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.u */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3314u implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC3316w f12091a;

    /* renamed from: b */
    final /* synthetic */ AuthenticatorActivity f12092b;

    DialogInterfaceOnClickListenerC3314u(AuthenticatorActivity authenticatorActivity, EnumC3316w enumC3316w) {
        this.f12092b = authenticatorActivity;
        this.f12091a = enumC3316w;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f12091a) {
            case get_server_address:
                this.f12092b.m12803d();
                this.f12092b.f11578j.m9552a();
                break;
            case version_for_upgrade:
                this.f12092b.m12803d();
                this.f12092b.f11579k.m9471b();
                break;
            case accept_disclaimer:
                this.f12092b.m12803d();
                this.f12092b.f11577i.m9470a("FIRST");
                break;
        }
    }
}
