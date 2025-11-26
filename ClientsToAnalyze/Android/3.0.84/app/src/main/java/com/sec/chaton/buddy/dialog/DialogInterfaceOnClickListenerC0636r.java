package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;

/* compiled from: ChatONVRedirectDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.r */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0636r implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatONVRedirectDialog f2856a;

    DialogInterfaceOnClickListenerC0636r(ChatONVRedirectDialog chatONVRedirectDialog) {
        this.f2856a = chatONVRedirectDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f2856a.m4215b()) {
            this.f2856a.m4216c();
        } else {
            this.f2856a.m4218d();
        }
        this.f2856a.finish();
    }
}
