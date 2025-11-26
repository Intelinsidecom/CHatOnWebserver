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
    private static final String f8032a = AlarmTimer.class.getSimpleName();

    /* renamed from: b */
    private static Map<String, InterfaceC2110b> f8033b = new HashMap();

    /* renamed from: c */
    private static AlarmTimer f8034c;

    /* renamed from: d */
    private boolean f8035d = false;

    private AlarmTimer() {
    }

    /* renamed from: a */
    public static synchronized AlarmTimer m8327a() {
        if (f8034c == null) {
            f8034c = new AlarmTimer();
        }
        return f8034c;
    }

    /* renamed from: a */
    public synchronized void m8328a(Context context) {
        if (!this.f8035d) {
            C2115g.m8359a(f8032a, "AlarmTimer.prepare()");
            this.f8035d = true;
            IntentFilter intentFilter = new IntentFilter("com.sec.chaton.push.ALARM_TIMER_ACTION");
            intentFilter.addDataScheme("chaton");
            intentFilter.addDataAuthority("com.sec.chaton.push", null);
            context.getApplicationContext().registerReceiver(f8034c, intentFilter);
        }
    }

    /* renamed from: a */
    public synchronized void m8330a(Context context, String str, long j, InterfaceC2110b interfaceC2110b) {
        C2115g.m8359a(f8032a, "AlarmTimer.schedule()");
        if (!this.f8035d) {
            C2115g.m8363c(f8032a, "AlarmTimer isn't prepared");
        } else {
            f8033b.put(str, interfaceC2110b);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent("com.sec.chaton.push.ALARM_TIMER_ACTION");
            intent.setData(Uri.parse("chaton://com.sec.chaton.push/" + str));
            alarmManager.set(2, j, PendingIntent.getBroadcast(context, 0, intent, 0));
        }
    }

    /* renamed from: a */
    public synchronized void m8329a(Context context, String str) {
        C2115g.m8359a(f8032a, "AlarmTimer.unschedule()");
        if (!this.f8035d) {
            C2115g.m8363c(f8032a, "AlarmTimer isn't prepared");
        } else {
            C2115g.m8359a(f8032a, String.format("unschedule token: %s", str));
            f8033b.remove(str);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent("com.sec.chaton.push.ALARM_TIMER_ACTION");
            intent.setData(Uri.parse("chaton://com.sec.chaton.push/" + str));
            alarmManager.cancel(PendingIntent.getBroadcast(context, 0, intent, 0));
        }
    }

    @Override // android.content.BroadcastReceiver
    public synchronized void onReceive(Context context, Intent intent) {
        String str = intent.getData().getPathSegments().get(0);
        C2115g.m8359a(f8032a, "AlarmTimer.onReceive(): " + str);
        if (!this.f8035d) {
            C2115g.m8363c(f8032a, "AlarmTimer isn't prepared");
        } else {
            InterfaceC2110b interfaceC2110bRemove = f8033b.remove(str);
            if (interfaceC2110bRemove != null) {
                interfaceC2110bRemove.mo8178a(context);
            } else {
                C2115g.m8363c(f8032a, "Couldn't find callback. token: " + str);
            }
        }
    }
}
