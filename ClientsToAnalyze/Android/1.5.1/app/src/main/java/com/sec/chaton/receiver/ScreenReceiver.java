package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class ScreenReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            ChatONLogWriter.m3509d("Screen Receiver ON");
            GlobalApplication.f1897d = true;
        } else if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            ChatONLogWriter.m3509d("Screen Receiver OFF");
            GlobalApplication.f1897d = false;
        }
    }
}
