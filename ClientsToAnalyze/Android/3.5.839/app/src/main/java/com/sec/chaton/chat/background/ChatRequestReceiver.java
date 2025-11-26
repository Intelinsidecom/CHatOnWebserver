package com.sec.chaton.chat.background;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.calllog.manager.noti.C1457a;
import com.sec.common.CommonApplication;

/* loaded from: classes.dex */
public class ChatRequestReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction().equals("com.sec.chaton.chat.background.MESSAGE_SEND")) {
            Intent intent2 = new Intent(CommonApplication.m18732r(), (Class<?>) ChatBackgroundService.class);
            intent2.putExtra("request", intent.getExtras());
            CommonApplication.m18732r().startService(intent2);
        }
        if (intent != null && intent.getAction().equals("com.sec.chaton.chat.background.REQ_FULL_MESSAGE")) {
            Intent intent3 = new Intent(CommonApplication.m18732r(), (Class<?>) ChatBackgroundService.class);
            intent3.putExtra("request3rdapp", intent.getExtras());
            CommonApplication.m18732r().startService(intent3);
        }
        if (intent != null && intent.getAction().equals("com.sec.chaton.chat.background.REMOVE_MISSED_CALL_NOTI")) {
            C1457a.m7650a().m7652a(1001);
        }
        if (intent != null && intent.getAction().equals("com.sec.chaton.chat.background.OPEN_MISSED_CALL_LOG")) {
            CommonApplication.m18732r().startActivity(C1457a.m7650a().m7654b());
        }
    }
}
