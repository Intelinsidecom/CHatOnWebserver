package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVRedirectDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.w */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1245w implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatONVRedirectDialog f4745a;

    DialogInterfaceOnClickListenerC1245w(ChatONVRedirectDialog chatONVRedirectDialog) {
        this.f4745a = chatONVRedirectDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4745a.finish();
    }
}
