package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.util.C4809aa;

/* compiled from: FirstLauncherDialog.java */
/* renamed from: com.sec.chaton.registration.an */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3145an implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3134ac f11897a;

    DialogInterfaceOnClickListenerC3145an(C3134ac c3134ac) {
        this.f11897a = c3134ac;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C4809aa.m18105a("PacketDataDialg", Boolean.valueOf(this.f11897a.f11881q));
        this.f11897a.f11878n.mo9076a(false, this.f11897a.f11877m, false);
    }
}
