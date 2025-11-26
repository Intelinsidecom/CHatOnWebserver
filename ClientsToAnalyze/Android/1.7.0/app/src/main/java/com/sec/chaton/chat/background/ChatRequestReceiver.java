package com.sec.chaton.chat.background;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class ChatRequestReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals("com.sec.chaton.chat.background.MESSAGE_SEND")) {
            Intent intent2 = new Intent(GlobalApplication.m3100a(), (Class<?>) ChatBackgroundService.class);
            intent2.putExtra("request", intent.getExtras());
            GlobalApplication.m3100a().startService(intent2);
        }
    }
}
