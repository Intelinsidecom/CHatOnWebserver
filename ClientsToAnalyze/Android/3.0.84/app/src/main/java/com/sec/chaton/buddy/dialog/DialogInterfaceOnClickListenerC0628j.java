package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVInstallDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.j */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0628j implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatONVInstallDialog f2848a;

    DialogInterfaceOnClickListenerC0628j(ChatONVInstallDialog chatONVInstallDialog) {
        this.f2848a = chatONVInstallDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2848a.finish();
    }
}
