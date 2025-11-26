package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentGlobalDisclaimer.java */
/* renamed from: com.sec.chaton.registration.cg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2183cg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC2187ck f8469a;

    /* renamed from: b */
    final /* synthetic */ FragmentGlobalDisclaimer f8470b;

    DialogInterfaceOnClickListenerC2183cg(FragmentGlobalDisclaimer fragmentGlobalDisclaimer, EnumC2187ck enumC2187ck) {
        this.f8470b = fragmentGlobalDisclaimer;
        this.f8469a = enumC2187ck;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f8469a) {
            case get_server_address:
                this.f8470b.m8523b();
                this.f8470b.f8216d.m5775a();
                break;
            case version_for_upgrade:
                this.f8470b.m8523b();
                this.f8470b.f8217e.m5694b();
                break;
            case accept_disclaimer:
                this.f8470b.m8523b();
                this.f8470b.f8217e.m5693a("FIRST");
                break;
        }
    }
}
