package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.o */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC1237o implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ ChatONVInstallDialog f4737a;

    DialogInterfaceOnCancelListenerC1237o(ChatONVInstallDialog chatONVInstallDialog) {
        this.f4737a = chatONVInstallDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f4737a.finish();
    }
}
