package com.sec.chaton;

import android.content.DialogInterface;

/* compiled from: SPPUpgradeDialog.java */
/* renamed from: com.sec.chaton.cj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1881cj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SPPUpgradeDialog f7098a;

    DialogInterfaceOnClickListenerC1881cj(SPPUpgradeDialog sPPUpgradeDialog) {
        this.f7098a = sPPUpgradeDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7098a.finish();
    }
}
