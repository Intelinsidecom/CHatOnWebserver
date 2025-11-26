package com.sec.chaton.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;

/* loaded from: classes.dex */
public class AlarmReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public static String f11510a = "com.android.alarmclock.ALARM_ALERT";

    /* renamed from: b */
    public static String f11511b = "com.samsung.sec.android.clockpackage.alarm.ALARM_ALERT";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C4904y.m18639b("action : " + intent.getAction(), getClass().getSimpleName());
    }
}
