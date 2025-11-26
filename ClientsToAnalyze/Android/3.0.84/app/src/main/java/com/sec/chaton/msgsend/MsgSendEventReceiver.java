package com.sec.chaton.msgsend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public class MsgSendEventReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f6417a = MsgSendEventReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (action == null) {
                C1759s.m7260a(f6417a, "getAction == null", new Object[0]);
                return;
            }
            C1749i c1749iM7196b = C1749i.m7195a().m7196b();
            if ("com.sec.chaton.msgsend.MsgSendScheduleHelper.ALARM_TIMER_ACTION".equals(action)) {
                C1756p.m7229a(EnumC1764x.m7264a(intent.getIntExtra("set_alarm_reason", -1)));
            }
            C1759s.m7260a(f6417a, "process onReceive (%s) : %s", action, c1749iM7196b.m7197c());
        }
    }
}
