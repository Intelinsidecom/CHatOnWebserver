package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.util.C4809aa;

/* compiled from: FirstLauncherDialog.java */
/* renamed from: com.sec.chaton.registration.ap */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3147ap implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3134ac f11899a;

    DialogInterfaceOnClickListenerC3147ap(C3134ac c3134ac) {
        this.f11899a = c3134ac;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C4809aa.m18105a("PacketDataDialg", Boolean.valueOf(this.f11899a.f11881q));
        this.f11899a.f11878n.mo9076a(true, this.f11899a.f11877m, false);
    }
}
