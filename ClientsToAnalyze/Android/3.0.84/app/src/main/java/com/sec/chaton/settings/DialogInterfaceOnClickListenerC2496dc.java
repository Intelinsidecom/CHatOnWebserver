package com.sec.chaton.settings;

import android.content.DialogInterface;
import com.sec.chaton.settings.DeleteAccountPreference;

/* compiled from: DeleteAccountPreference.java */
/* renamed from: com.sec.chaton.settings.dc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2496dc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DeleteAccountPreference.DeleteAMSAlertDialog f9386a;

    DialogInterfaceOnClickListenerC2496dc(DeleteAccountPreference.DeleteAMSAlertDialog deleteAMSAlertDialog) {
        this.f9386a = deleteAMSAlertDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        DeleteAccountPreference.f9102a.beginTransaction().add(new DeleteAccountPreference.DeleteWorkFragment(), "delete_account").commit();
    }
}
