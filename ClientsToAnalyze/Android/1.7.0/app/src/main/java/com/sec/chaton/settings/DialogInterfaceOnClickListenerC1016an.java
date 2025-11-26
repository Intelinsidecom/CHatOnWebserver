package com.sec.chaton.settings;

import android.content.DialogInterface;
import com.sec.chaton.settings.FragmentDeleteAccount;

/* compiled from: FragmentDeleteAccount.java */
/* renamed from: com.sec.chaton.settings.an */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1016an implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDeleteAccount.DeleteAMSAlertDialog f3618a;

    DialogInterfaceOnClickListenerC1016an(FragmentDeleteAccount.DeleteAMSAlertDialog deleteAMSAlertDialog) {
        this.f3618a = deleteAMSAlertDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
