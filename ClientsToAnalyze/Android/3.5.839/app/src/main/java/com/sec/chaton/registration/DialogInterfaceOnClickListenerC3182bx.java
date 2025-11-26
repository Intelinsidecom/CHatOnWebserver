package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FragmentDisclaimerGlobal.java */
/* renamed from: com.sec.chaton.registration.bx */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3182bx implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EnumC3184bz f11934a;

    /* renamed from: b */
    final /* synthetic */ FragmentDisclaimerGlobal f11935b;

    DialogInterfaceOnClickListenerC3182bx(FragmentDisclaimerGlobal fragmentDisclaimerGlobal, EnumC3184bz enumC3184bz) {
        this.f11935b = fragmentDisclaimerGlobal;
        this.f11934a = enumC3184bz;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f11934a) {
            case get_server_address:
                this.f11935b.m12844a();
                this.f11935b.f11628b.m9552a();
                break;
            case version_for_upgrade:
                this.f11935b.m12844a();
                this.f11935b.f11641o.m9471b();
                break;
            case accept_disclaimer:
                this.f11935b.m12844a();
                this.f11935b.f11641o.m9470a("FIRST");
                break;
        }
    }
}
