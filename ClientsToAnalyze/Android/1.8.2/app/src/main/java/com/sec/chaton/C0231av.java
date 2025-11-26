package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: UpgradeDialog.java */
/* renamed from: com.sec.chaton.av */
/* loaded from: classes.dex */
class C0231av extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ UpgradeDialog f763a;

    C0231av(UpgradeDialog upgradeDialog) {
        this.f763a = upgradeDialog;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.sec.chaton.ACTION_DISMISS")) {
            this.f763a.finish();
        }
    }
}
