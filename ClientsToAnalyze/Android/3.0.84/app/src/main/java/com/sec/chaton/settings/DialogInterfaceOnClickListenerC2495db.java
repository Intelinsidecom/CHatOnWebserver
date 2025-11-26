package com.sec.chaton.settings;

import android.content.DialogInterface;
import com.sec.chaton.settings.DeleteAccountPreference;

/* compiled from: DeleteAccountPreference.java */
/* renamed from: com.sec.chaton.settings.db */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2495db implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DeleteAccountPreference.DeleteAMSAlertDialog f9385a;

    DialogInterfaceOnClickListenerC2495db(DeleteAccountPreference.DeleteAMSAlertDialog deleteAMSAlertDialog) {
        this.f9385a = deleteAMSAlertDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
