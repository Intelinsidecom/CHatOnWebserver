package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.util.C4809aa;

/* compiled from: FirstLauncherDialog.java */
/* renamed from: com.sec.chaton.registration.bc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3161bc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3134ac f11914a;

    DialogInterfaceOnClickListenerC3161bc(C3134ac c3134ac) {
        this.f11914a = c3134ac;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C4809aa.m18105a("DoNotShowRoamingNetwork", Boolean.valueOf(this.f11914a.f11881q));
        this.f11914a.f11878n.mo9076a(false, this.f11914a.f11877m, false);
    }
}
