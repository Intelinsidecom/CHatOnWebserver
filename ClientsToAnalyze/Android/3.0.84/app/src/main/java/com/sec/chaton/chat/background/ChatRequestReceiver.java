package com.sec.chaton.chat.background;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class ChatRequestReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals("com.sec.chaton.chat.background.MESSAGE_SEND")) {
            Intent intent2 = new Intent(CommonApplication.m11493l(), (Class<?>) ChatBackgroundService.class);
            intent2.putExtra("request", intent.getExtras());
            CommonApplication.m11493l().startService(intent2);
        }
        if (intent != null && intent.getAction().equals("com.sec.chaton.chat.background.REQ_FULL_MESSAGE")) {
            Intent intent3 = new Intent(CommonApplication.m11493l(), (Class<?>) ChatBackgroundService.class);
            intent3.putExtra("request3rdapp", intent.getExtras());
            CommonApplication.m11493l().startService(intent3);
        }
    }
}
