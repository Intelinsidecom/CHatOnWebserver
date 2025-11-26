package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.i */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0627i implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ ChatONVInstallDialog f2847a;

    DialogInterfaceOnCancelListenerC0627i(ChatONVInstallDialog chatONVInstallDialog) {
        this.f2847a = chatONVInstallDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f2847a.finish();
    }
}
