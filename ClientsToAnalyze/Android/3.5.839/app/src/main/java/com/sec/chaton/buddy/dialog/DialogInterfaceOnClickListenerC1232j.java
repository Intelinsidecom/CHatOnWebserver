package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.j */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1232j implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatONVInstallDialog f4732a;

    DialogInterfaceOnClickListenerC1232j(ChatONVInstallDialog chatONVInstallDialog) {
        this.f4732a = chatONVInstallDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4732a.finish();
    }
}
