package com.p001a.p002a;

import android.content.DialogInterface;

/* compiled from: FbDialog.java */
/* renamed from: com.a.a.d */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0039d implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC0045j f1a;

    DialogInterfaceOnCancelListenerC0039d(DialogC0045j dialogC0045j) {
        this.f1a = dialogC0045j;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f1a.cancel();
    }
}
