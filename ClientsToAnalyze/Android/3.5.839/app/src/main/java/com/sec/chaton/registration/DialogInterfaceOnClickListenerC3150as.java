package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.util.C4809aa;

/* compiled from: FirstLauncherDialog.java */
/* renamed from: com.sec.chaton.registration.as */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3150as implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3134ac f11902a;

    DialogInterfaceOnClickListenerC3150as(C3134ac c3134ac) {
        this.f11902a = c3134ac;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C4809aa.m18105a("DoNotShowWlanDialog", Boolean.valueOf(this.f11902a.f11881q));
        this.f11902a.f11878n.mo9076a(true, this.f11902a.f11877m, false);
    }
}
