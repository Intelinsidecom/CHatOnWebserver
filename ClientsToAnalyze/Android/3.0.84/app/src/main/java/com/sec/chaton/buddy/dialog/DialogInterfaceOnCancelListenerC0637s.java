package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVRedirectDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.s */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC0637s implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ ChatONVRedirectDialog f2857a;

    DialogInterfaceOnCancelListenerC0637s(ChatONVRedirectDialog chatONVRedirectDialog) {
        this.f2857a = chatONVRedirectDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f2857a.finish();
    }
}
