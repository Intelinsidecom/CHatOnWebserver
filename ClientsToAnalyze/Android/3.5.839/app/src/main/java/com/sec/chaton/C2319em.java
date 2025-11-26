package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: UpgradeDialog.java */
/* renamed from: com.sec.chaton.em */
/* loaded from: classes.dex */
class C2319em extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ UpgradeDialog f8242a;

    C2319em(UpgradeDialog upgradeDialog) {
        this.f8242a = upgradeDialog;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.sec.chaton.ACTION_DISMISS")) {
            this.f8242a.finish();
        }
    }
}
