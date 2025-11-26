package com.p001a.p002a;

import android.content.DialogInterface;

/* compiled from: FbDialog.java */
/* renamed from: com.a.a.h */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0033h implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ DialogC0031f f26a;

    DialogInterfaceOnCancelListenerC0033h(DialogC0031f dialogC0031f) {
        this.f26a = dialogC0031f;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f26a.f22g.stopLoading();
        this.f26a.f20e.mo19a();
        this.f26a.dismiss();
    }
}
