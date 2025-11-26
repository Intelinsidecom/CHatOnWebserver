package com.sec.chaton.push.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class AlarmTimer extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f4126a = AlarmTimer.class.getSimpleName();

    /* renamed from: b */
    private static Map f4127b = new HashMap();

    /* renamed from: c */
    private static AlarmTimer f4128c;

    /* renamed from: d */
    private boolean f4129d = false;

    private AlarmTimer() {
    }

    /* renamed from: a */
    public static synchronized AlarmTimer m4276a() {
        if (f4128c == null) {
            f4128c = new AlarmTimer();
        }
        return f4128c;
    }

    /* renamed from: a */
    public synchronized void m4277a(Context context) {
        if (!this.f4129d) {
            C1139g.m4308a(f4126a, "AlarmTimer.prepare()");
            this.f4129d = true;
            IntentFilter intentFilter = new IntentFilter("com.sec.chaton.push.ALARM_TIMER_ACTION");
            intentFilter.addDataScheme("chaton");
            intentFilter.addDataAuthority("com.sec.chaton.push", null);
            context.getApplicationContext().registerReceiver(f4128c, intentFilter);
        }
    }

    /* renamed from: a */
    public synchronized void m4279a(Context context, String str, long j, InterfaceC1134b interfaceC1134b) {
        C1139g.m4308a(f4126a, "AlarmTimer.schedule()");
        if (!this.f4129d) {
            C1139g.m4312c(f4126a, "AlarmTimer isn't prepared");
        } else {
            f4127b.put(str, interfaceC1134b);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent("com.sec.chaton.push.ALARM_TIMER_ACTION");
            intent.setData(Uri.parse("chaton://com.sec.chaton.push/" + str));
            alarmManager.set(2, j, PendingIntent.getBroadcast(context, 0, intent, 0));
        }
    }

    /* renamed from: a */
    public synchronized void m4278a(Context context, String str) {
        C1139g.m4308a(f4126a, "AlarmTimer.unschedule()");
        if (!this.f4129d) {
            C1139g.m4312c(f4126a, "AlarmTimer isn't prepared");
        } else {
            C1139g.m4308a(f4126a, String.format("unschedule token: %s", str));
            f4127b.remove(str);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent("com.sec.chaton.push.ALARM_TIMER_ACTION");
            intent.setData(Uri.parse("chaton://com.sec.chaton.push/" + str));
            alarmManager.cancel(PendingIntent.getBroadcast(context, 0, intent, 0));
        }
    }

    @Override // android.content.BroadcastReceiver
    public synchronized void onReceive(Context context, Intent intent) {
        String str = intent.getData().getPathSegments().get(0);
        C1139g.m4308a(f4126a, "AlarmTimer.onReceive(): " + str);
        if (!this.f4129d) {
            C1139g.m4312c(f4126a, "AlarmTimer isn't prepared");
        } else {
            InterfaceC1134b interfaceC1134b = (InterfaceC1134b) f4127b.remove(str);
            if (interfaceC1134b != null) {
                interfaceC1134b.mo4134a(context);
            } else {
                C1139g.m4312c(f4126a, "Couldn't find callback. token: " + str);
            }
        }
    }
}
