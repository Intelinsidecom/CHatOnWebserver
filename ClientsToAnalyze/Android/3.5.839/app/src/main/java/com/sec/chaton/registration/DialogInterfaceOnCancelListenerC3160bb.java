package com.sec.chaton.registration;

import android.content.DialogInterface;

/* compiled from: FirstLauncherDialog.java */
/* renamed from: com.sec.chaton.registration.bb */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC3160bb implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ C3134ac f11913a;

    DialogInterfaceOnCancelListenerC3160bb(C3134ac c3134ac) {
        this.f11913a = c3134ac;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f11913a.f11878n.mo9076a(false, this.f11913a.f11877m, false);
    }
}
