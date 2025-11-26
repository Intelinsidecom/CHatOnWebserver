package com.sec.chaton.buddy.dialog;

import android.content.DialogInterface;
import com.sec.chaton.util.C4859bx;

/* compiled from: ChatONVRedirectDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.x */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1246x implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatONVRedirectDialog f4746a;

    DialogInterfaceOnClickListenerC1246x(ChatONVRedirectDialog chatONVRedirectDialog) {
        this.f4746a = chatONVRedirectDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f4746a.m7281b()) {
            C4859bx.m18378a(1);
        } else {
            C4859bx.m18395c(1);
        }
        this.f4746a.finish();
    }
}
