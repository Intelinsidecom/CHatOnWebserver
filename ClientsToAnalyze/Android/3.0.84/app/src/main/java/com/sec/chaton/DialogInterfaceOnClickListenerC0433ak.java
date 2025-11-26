package com.sec.chaton;

import android.content.DialogInterface;

/* compiled from: SPPUpgradeDialog.java */
/* renamed from: com.sec.chaton.ak */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0433ak implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SPPUpgradeDialog f1495a;

    DialogInterfaceOnClickListenerC0433ak(SPPUpgradeDialog sPPUpgradeDialog) {
        this.f1495a = sPPUpgradeDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1495a.finish();
    }
}
