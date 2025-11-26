package com.sec.chaton.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.sec.chaton.util.d */
/* loaded from: classes.dex */
final class C0606d extends BroadcastReceiver {
    C0606d() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ChatONLogWriter.m3506b("mSmsPendingIntentReceiver action=" + intent.getAction() + "extras=" + intent.getExtras() + " result=" + getResultCode() + " isOrderedBroadcast=" + isOrderedBroadcast(), "SmsMessager2");
    }
}
