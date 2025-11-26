package com.sec.chaton.settings;

import android.content.DialogInterface;
import com.sec.chaton.settings.FragmentDeleteAccount;

/* compiled from: FragmentDeleteAccount.java */
/* renamed from: com.sec.chaton.settings.bv */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1270bv implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDeleteAccount.DeleteAlertDialog f4817a;

    DialogInterfaceOnClickListenerC1270bv(FragmentDeleteAccount.DeleteAlertDialog deleteAlertDialog) {
        this.f4817a = deleteAlertDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
