package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.l */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC1234l implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ ChatONVInstallDialog f4734a;

    DialogInterfaceOnCancelListenerC1234l(ChatONVInstallDialog chatONVInstallDialog) {
        this.f4734a = chatONVInstallDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f4734a.finish();
    }
}
