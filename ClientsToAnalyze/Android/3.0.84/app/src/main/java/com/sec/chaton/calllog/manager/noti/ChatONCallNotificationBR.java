package com.sec.chaton.calllog.manager.noti;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class ChatONCallNotificationBR extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f3220a = ChatONCallNotificationBR.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        C3250y.m11453c("action: " + action, f3220a);
        if ("com.sec.chaton.MISSEDCALL_CREATE_NOTIFICATION".equals(action)) {
            GlobalApplication.m11493l().startActivity(C0846a.m4496a().m4500b());
            return;
        }
        if ("com.sec.chaton.MISSEDCALL_DELETE_NOTIFICATION".equals(action)) {
            C0846a.m4496a().m4497a(1000);
        } else if ("com.sec.chaton.REJECT_MSG_CREATE_NOTIFICATION".equals(action)) {
            GlobalApplication.m11493l().startActivity(C0846a.m4496a().m4501c());
        } else if ("com.sec.chaton.REJECT_MSG_DELETE_NOTIFICATION".equals(action)) {
            C0846a.m4496a().m4497a(2000);
        }
    }
}
