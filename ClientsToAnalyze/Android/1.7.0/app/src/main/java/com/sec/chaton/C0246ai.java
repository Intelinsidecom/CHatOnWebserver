package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: UpgradeDialog.java */
/* renamed from: com.sec.chaton.ai */
/* loaded from: classes.dex */
class C0246ai extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ UpgradeDialog f593a;

    C0246ai(UpgradeDialog upgradeDialog) {
        this.f593a = upgradeDialog;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.sec.chaton.ACTION_DISMISS")) {
            this.f593a.finish();
        }
    }
}
