package com.sec.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: UpgradeDialog.java */
/* renamed from: com.sec.chaton.bx */
/* loaded from: classes.dex */
class C0814bx extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ UpgradeDialog f3110a;

    C0814bx(UpgradeDialog upgradeDialog) {
        this.f3110a = upgradeDialog;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.sec.chaton.ACTION_DISMISS")) {
            this.f3110a.finish();
        }
    }
}
