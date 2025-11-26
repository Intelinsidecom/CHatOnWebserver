package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: NewDisclaimerFragment.java */
/* renamed from: com.sec.chaton.registration.gd */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2288gd implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC2289ge f8584a;

    /* renamed from: b */
    final /* synthetic */ NewDisclaimerFragment f8585b;

    DialogInterfaceOnClickListenerC2288gd(NewDisclaimerFragment newDisclaimerFragment, EnumC2289ge enumC2289ge) {
        this.f8585b = newDisclaimerFragment;
        this.f8584a = enumC2289ge;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f8584a) {
            case get_server_address:
                this.f8585b.m8658b();
                this.f8585b.f8371m.m5775a();
                break;
            case version_for_upgrade:
                this.f8585b.m8658b();
                this.f8585b.f8370l.m5694b();
                break;
            case accept_disclaimer:
                this.f8585b.m8658b();
                this.f8585b.f8370l.m5693a("FIRST");
                break;
        }
    }
}
