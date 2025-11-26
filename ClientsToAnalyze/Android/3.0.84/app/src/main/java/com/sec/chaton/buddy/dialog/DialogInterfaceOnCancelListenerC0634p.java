package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.p */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0634p implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0631m f2854a;

    DialogInterfaceOnCancelListenerC0634p(HandlerC0631m handlerC0631m) {
        this.f2854a = handlerC0631m;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f2854a.f2851a.finish();
    }
}
