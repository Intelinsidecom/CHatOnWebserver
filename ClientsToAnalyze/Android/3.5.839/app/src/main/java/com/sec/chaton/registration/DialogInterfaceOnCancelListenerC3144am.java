package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FirstLauncherDialog.java */
/* renamed from: com.sec.chaton.registration.am */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC3144am implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ C3134ac f11896a;

    DialogInterfaceOnCancelListenerC3144am(C3134ac c3134ac) {
        this.f11896a = c3134ac;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f11896a.f11878n.mo9076a(false, this.f11896a.f11877m, false);
    }
}
