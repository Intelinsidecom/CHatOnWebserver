package com.sec.chaton.calllog.manager.noti;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class ChatONCallNotificationBR extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f5190a = ChatONCallNotificationBR.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            C4904y.m18641c("action: " + action, f5190a);
            if ("com.sec.chaton.MISSEDCALL_CREATE_NOTIFICATION".equals(action)) {
                GlobalApplication.m18732r().startActivity(C1457a.m7650a().m7654b());
                return;
            }
            if ("com.sec.chaton.MISSEDCALL_DELETE_NOTIFICATION".equals(action)) {
                C1457a.m7650a().m7652a(1000);
            } else if ("com.sec.chaton.REJECT_MSG_CREATE_NOTIFICATION".equals(action)) {
                GlobalApplication.m18732r().startActivity(C1457a.m7650a().m7655c());
            } else if ("com.sec.chaton.REJECT_MSG_DELETE_NOTIFICATION".equals(action)) {
                C1457a.m7650a().m7652a(2000);
            }
        }
    }
}
