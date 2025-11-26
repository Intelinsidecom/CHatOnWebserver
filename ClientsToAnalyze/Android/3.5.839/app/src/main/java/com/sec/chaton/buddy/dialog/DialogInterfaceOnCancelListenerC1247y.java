package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVRedirectDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.y */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC1247y implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ ChatONVRedirectDialog f4747a;

    DialogInterfaceOnCancelListenerC1247y(ChatONVRedirectDialog chatONVRedirectDialog) {
        this.f4747a = chatONVRedirectDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f4747a.finish();
    }
}
