package com.p001a.p002a;

import android.content.DialogInterface;

/* compiled from: FbDialog.java */
/* renamed from: com.a.a.g */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0032g implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC0031f f25a;

    DialogInterfaceOnCancelListenerC0032g(DialogC0031f dialogC0031f) {
        this.f25a = dialogC0031f;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f25a.f22g.stopLoading();
        this.f25a.f20e.mo19a();
    }
}
