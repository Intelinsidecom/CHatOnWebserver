package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1341p;

/* loaded from: classes.dex */
public class ScreenReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            C1341p.m4659c("Screen Receiver ON");
            GlobalApplication.f2409c = true;
        } else if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            C1341p.m4659c("Screen Receiver OFF");
            GlobalApplication.f2409c = false;
        }
    }
}
