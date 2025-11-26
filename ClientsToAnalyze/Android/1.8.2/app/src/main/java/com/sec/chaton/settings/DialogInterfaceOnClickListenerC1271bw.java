package com.sec.chaton.settings;

import android.content.DialogInterface;
import com.sec.chaton.settings.FragmentDeleteAccount;

/* compiled from: FragmentDeleteAccount.java */
/* renamed from: com.sec.chaton.settings.bw */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1271bw implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentDeleteAccount.DeleteAlertDialog f4818a;

    DialogInterfaceOnClickListenerC1271bw(FragmentDeleteAccount.DeleteAlertDialog deleteAlertDialog) {
        this.f4818a = deleteAlertDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        boolean unused = FragmentDeleteAccount.f4614a = false;
        boolean unused2 = FragmentDeleteAccount.f4615b = false;
        this.f4818a.getFragmentManager().beginTransaction().add(new FragmentDeleteAccount.DeleteWorkFragment(), "delete_account").addToBackStack(ActivitySettings.f4559g).commit();
    }
}
