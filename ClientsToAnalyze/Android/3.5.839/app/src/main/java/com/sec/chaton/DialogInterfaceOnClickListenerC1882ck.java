package com.sec.chaton;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;

/* compiled from: SPPUpgradeDialog.java */
/* renamed from: com.sec.chaton.ck */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1882ck implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SPPUpgradeDialog f7099a;

    DialogInterfaceOnClickListenerC1882ck(SPPUpgradeDialog sPPUpgradeDialog) {
        this.f7099a = sPPUpgradeDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
        intent.putExtra("directcall", true);
        intent.putExtra("callerType", 1);
        intent.putExtra("GUID", "com.sec.spp.push");
        intent.addFlags(335544320);
        try {
            this.f7099a.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
        this.f7099a.finish();
    }
}
