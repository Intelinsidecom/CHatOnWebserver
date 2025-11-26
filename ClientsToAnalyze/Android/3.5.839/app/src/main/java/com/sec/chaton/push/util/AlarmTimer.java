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
    private static final String f11442a = AlarmTimer.class.getSimpleName();

    /* renamed from: b */
    private static Map<String, InterfaceC3110b> f11443b = new HashMap();

    /* renamed from: c */
    private static AlarmTimer f11444c;

    /* renamed from: d */
    private boolean f11445d = false;

    private AlarmTimer() {
    }

    /* renamed from: a */
    public static synchronized AlarmTimer m12669a() {
        if (f11444c == null) {
            f11444c = new AlarmTimer();
        }
        return f11444c;
    }

    /* renamed from: a */
    public synchronized void m12670a(Context context) {
        if (!this.f11445d) {
            C3115g.m12701a(f11442a, "AlarmTimer.prepare()");
            this.f11445d = true;
            IntentFilter intentFilter = new IntentFilter("com.sec.chaton.push.ALARM_TIMER_ACTION");
            intentFilter.addDataScheme("chaton");
            intentFilter.addDataAuthority("com.sec.chaton.push", null);
            context.getApplicationContext().registerReceiver(f11444c, intentFilter);
        }
    }

    /* renamed from: a */
    public synchronized void m12672a(Context context, String str, long j, InterfaceC3110b interfaceC3110b) {
        C3115g.m12701a(f11442a, "AlarmTimer.schedule()");
        if (!this.f11445d) {
            C3115g.m12705c(f11442a, "AlarmTimer isn't prepared");
        } else {
            f11443b.put(str, interfaceC3110b);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent("com.sec.chaton.push.ALARM_TIMER_ACTION");
            intent.setData(Uri.parse("chaton://com.sec.chaton.push/" + str));
            alarmManager.set(2, j, PendingIntent.getBroadcast(context, 0, intent, 0));
        }
    }

    /* renamed from: a */
    public synchronized void m12671a(Context context, String str) {
        C3115g.m12701a(f11442a, "AlarmTimer.unschedule()");
        if (!this.f11445d) {
            C3115g.m12705c(f11442a, "AlarmTimer isn't prepared");
        } else {
            C3115g.m12701a(f11442a, String.format("unschedule token: %s", str));
            f11443b.remove(str);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent("com.sec.chaton.push.ALARM_TIMER_ACTION");
            intent.setData(Uri.parse("chaton://com.sec.chaton.push/" + str));
            alarmManager.cancel(PendingIntent.getBroadcast(context, 0, intent, 0));
        }
    }

    @Override // android.content.BroadcastReceiver
    public synchronized void onReceive(Context context, Intent intent) {
        String str = intent.getData().getPathSegments().get(0);
        C3115g.m12701a(f11442a, "AlarmTimer.onReceive(): " + str);
        if (!this.f11445d) {
            C3115g.m12705c(f11442a, "AlarmTimer isn't prepared");
        } else {
            InterfaceC3110b interfaceC3110bRemove = f11443b.remove(str);
            if (interfaceC3110bRemove != null) {
                interfaceC3110bRemove.mo12521a(context);
            } else {
                C3115g.m12705c(f11442a, "Couldn't find callback. token: " + str);
            }
        }
    }
}
