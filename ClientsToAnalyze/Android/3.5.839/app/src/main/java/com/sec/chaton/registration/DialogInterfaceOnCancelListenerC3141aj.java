package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FirstLauncherDialog.java */
/* renamed from: com.sec.chaton.registration.aj */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC3141aj implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ C3134ac f11893a;

    DialogInterfaceOnCancelListenerC3141aj(C3134ac c3134ac) {
        this.f11893a = c3134ac;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f11893a.f11878n.mo9076a(false, this.f11893a.f11877m, false);
    }
}
