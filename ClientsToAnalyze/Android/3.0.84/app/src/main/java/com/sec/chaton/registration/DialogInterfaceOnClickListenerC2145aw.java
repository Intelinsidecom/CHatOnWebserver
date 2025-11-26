package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.aw */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2145aw implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC2157bh f8419a;

    /* renamed from: b */
    final /* synthetic */ AuthenticatorActivity f8420b;

    DialogInterfaceOnClickListenerC2145aw(AuthenticatorActivity authenticatorActivity, EnumC2157bh enumC2157bh) {
        this.f8420b = authenticatorActivity;
        this.f8419a = enumC2157bh;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f8419a) {
            case get_server_address:
                this.f8420b.m8462h();
                this.f8420b.f8152k.m5775a();
                break;
            case version_for_upgrade:
                this.f8420b.m8462h();
                this.f8420b.f8153l.m5694b();
                break;
            case accept_disclaimer:
                this.f8420b.m8462h();
                this.f8420b.f8151j.m5693a("FIRST");
                break;
        }
    }
}
