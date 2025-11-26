package com.facebook.android;

import android.content.DialogInterface;

/* renamed from: com.facebook.android.a */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0048a implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ FbDialog f213a;

    DialogInterfaceOnCancelListenerC0048a(FbDialog fbDialog) {
        this.f213a = fbDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f213a.f210g.stopLoading();
        this.f213a.f208e.mo244a();
    }
}
