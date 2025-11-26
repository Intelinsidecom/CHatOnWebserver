package com.p001a.p002a;

import android.content.DialogInterface;

/* compiled from: FbDialog.java */
/* renamed from: com.a.a.c */
/* loaded from: classes.dex */
class DialogInterfaceOnDismissListenerC0038c implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ DialogC0045j f0a;

    DialogInterfaceOnDismissListenerC0038c(DialogC0045j dialogC0045j) {
        this.f0a = dialogC0045j;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f0a.f22g.stopLoading();
        this.f0a.f20e.mo15a();
    }
}
