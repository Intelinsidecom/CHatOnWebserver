package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class AlarmReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public static String f8058a = "com.android.alarmclock.ALARM_ALERT";

    /* renamed from: b */
    public static String f8059b = "com.samsung.sec.android.clockpackage.alarm.ALARM_ALERT";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C3250y.m11450b("action : " + intent.getAction(), getClass().getSimpleName());
        C3241p.m11403b(true);
    }
}
