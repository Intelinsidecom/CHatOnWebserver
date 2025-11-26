package com.sec.chaton.smsplugin.transaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.smsplugin.C3847e;

/* compiled from: RetryScheduler.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.aa */
/* loaded from: classes.dex */
class C4050aa extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C4090z f14606a;

    C4050aa(C4090z c4090z) {
        this.f14606a = c4090z;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C3847e.m14657aH()) {
            this.f14606a.f14727c = intent.getBooleanExtra("IMS_REG_STATUS", false);
            if (this.f14606a.f14727c) {
                Intent intent2 = new Intent("com.sec.chaton.smsplugin.transaction.MESSAGE_SENT");
                intent2.setClassName("com.sec.chaton.smsplugin", "com.sec.chaton.smsplugin.transaction.SmsReceiverService");
                intent2.putExtra("result", -1);
                intent2.putExtra("LastSentMsg", true);
                this.f14606a.f14725a.startService(intent2);
            }
        }
    }
}
