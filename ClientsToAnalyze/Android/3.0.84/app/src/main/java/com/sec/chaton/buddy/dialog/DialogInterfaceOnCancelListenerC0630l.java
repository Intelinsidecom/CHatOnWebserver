package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.l */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0630l implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ ChatONVInstallDialog f2850a;

    DialogInterfaceOnCancelListenerC0630l(ChatONVInstallDialog chatONVInstallDialog) {
        this.f2850a = chatONVInstallDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f2850a.finish();
    }
}
