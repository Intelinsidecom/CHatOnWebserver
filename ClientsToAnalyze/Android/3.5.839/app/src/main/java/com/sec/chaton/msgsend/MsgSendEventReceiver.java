package com.sec.chaton.msgsend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public class MsgSendEventReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f9620a = MsgSendEventReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (action == null) {
                C2684ab.m11290a(f9620a, "getAction == null", new Object[0]);
                return;
            }
            C2704l c2704lM11323b = C2704l.m11322a().m11323b();
            if ("com.sec.chaton.msgsend.MsgSendScheduleHelper.ALARM_TIMER_ACTION".equals(action)) {
                C2716x.m11375a(EnumC2689ag.m11294a(intent.getIntExtra("set_alarm_reason", -1)));
            }
            C2684ab.m11290a(f9620a, "process onReceive (%s) : %s", action, c2704lM11323b.m11324c());
        }
    }
}
