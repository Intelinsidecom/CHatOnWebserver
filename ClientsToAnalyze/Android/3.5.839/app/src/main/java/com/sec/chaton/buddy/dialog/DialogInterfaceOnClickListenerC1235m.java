package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.m */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1235m implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatONVInstallDialog f4735a;

    DialogInterfaceOnClickListenerC1235m(ChatONVInstallDialog chatONVInstallDialog) {
        this.f4735a = chatONVInstallDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4735a.finish();
    }
}
