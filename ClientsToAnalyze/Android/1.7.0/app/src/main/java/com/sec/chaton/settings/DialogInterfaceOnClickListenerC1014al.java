package com.sec.chaton.settings;

import android.content.DialogInterface;
import com.sec.chaton.settings.FragmentDeleteAccount;

/* compiled from: FragmentDeleteAccount.java */
/* renamed from: com.sec.chaton.settings.al */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1014al implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDeleteAccount.DeleteAMSAlertDialog f3616a;

    DialogInterfaceOnClickListenerC1014al(FragmentDeleteAccount.DeleteAMSAlertDialog deleteAMSAlertDialog) {
        this.f3616a = deleteAMSAlertDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3616a.getFragmentManager().beginTransaction().add(new FragmentDeleteAccount.DeleteWorkFragment(), "delete_account").commit();
    }
}
