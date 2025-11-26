package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.g */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0625g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatONVInstallDialog f2845a;

    DialogInterfaceOnClickListenerC0625g(ChatONVInstallDialog chatONVInstallDialog) {
        this.f2845a = chatONVInstallDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2845a.finish();
    }
}
