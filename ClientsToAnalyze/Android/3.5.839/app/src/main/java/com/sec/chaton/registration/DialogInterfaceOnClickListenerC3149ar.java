package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.util.C4809aa;

/* compiled from: FirstLauncherDialog.java */
/* renamed from: com.sec.chaton.registration.ar */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3149ar implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3134ac f11901a;

    DialogInterfaceOnClickListenerC3149ar(C3134ac c3134ac) {
        this.f11901a = c3134ac;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C4809aa.m18105a("PacketDataDialg", Boolean.valueOf(this.f11901a.f11881q));
        this.f11901a.f11878n.mo9076a(false, this.f11901a.f11877m, false);
    }
}
