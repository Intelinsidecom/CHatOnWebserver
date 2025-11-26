package com.facebook.android;

import android.content.DialogInterface;

/* renamed from: com.facebook.android.b */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0049b implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ FbDialog f214a;

    DialogInterfaceOnCancelListenerC0049b(FbDialog fbDialog) {
        this.f214a = fbDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f214a.f210g.stopLoading();
        this.f214a.f208e.mo244a();
        this.f214a.dismiss();
    }
}
