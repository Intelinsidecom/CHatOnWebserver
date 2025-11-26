package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVRedirectDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.q */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0635q implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatONVRedirectDialog f2855a;

    DialogInterfaceOnClickListenerC0635q(ChatONVRedirectDialog chatONVRedirectDialog) {
        this.f2855a = chatONVRedirectDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2855a.finish();
    }
}
