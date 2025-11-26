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
    private static final String f3104a = AlarmTimer.class.getSimpleName();

    /* renamed from: b */
    private static Map f3105b = new HashMap();

    /* renamed from: c */
    private static AlarmTimer f3106c;

    /* renamed from: d */
    private boolean f3107d = false;

    private AlarmTimer() {
    }

    /* renamed from: a */
    public static synchronized AlarmTimer m3603a() {
        if (f3106c == null) {
            f3106c = new AlarmTimer();
        }
        return f3106c;
    }

    /* renamed from: a */
    public synchronized void m3604a(Context context) {
        if (!this.f3107d) {
            C0921g.m3637a(f3104a, "AlarmTimer.prepare()");
            this.f3107d = true;
            IntentFilter intentFilter = new IntentFilter("com.sec.chaton.push.ALARM_TIMER_ACTION");
            intentFilter.addDataScheme("chaton");
            intentFilter.addDataAuthority("com.sec.chaton.push", null);
            context.getApplicationContext().registerReceiver(f3106c, intentFilter);
        }
    }

    /* renamed from: a */
    public synchronized void m3606a(Context context, String str, long j, InterfaceC0922h interfaceC0922h) {
        C0921g.m3637a(f3104a, "AlarmTimer.schedule()");
        if (!this.f3107d) {
            C0921g.m3641c(f3104a, "AlarmTimer isn't prepared");
        } else {
            f3105b.put(str, interfaceC0922h);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent("com.sec.chaton.push.ALARM_TIMER_ACTION");
            intent.setData(Uri.parse("chaton://com.sec.chaton.push/" + str));
            alarmManager.set(2, j, PendingIntent.getBroadcast(context, 0, intent, 0));
        }
    }

    /* renamed from: a */
    public synchronized void m3605a(Context context, String str) {
        C0921g.m3637a(f3104a, "AlarmTimer.unschedule()");
        if (!this.f3107d) {
            C0921g.m3641c(f3104a, "AlarmTimer isn't prepared");
        } else {
            C0921g.m3637a(f3104a, String.format("unschedule token: %s", str));
            f3105b.remove(str);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            Intent intent = new Intent("com.sec.chaton.push.ALARM_TIMER_ACTION");
            intent.setData(Uri.parse("chaton://com.sec.chaton.push/" + str));
            alarmManager.cancel(PendingIntent.getBroadcast(context, 0, intent, 0));
        }
    }

    @Override // android.content.BroadcastReceiver
    public synchronized void onReceive(Context context, Intent intent) {
        String str = intent.getData().getPathSegments().get(0);
        C0921g.m3637a(f3104a, "AlarmTimer.onReceive(): " + str);
        if (!this.f3107d) {
            C0921g.m3641c(f3104a, "AlarmTimer isn't prepared");
        } else {
            InterfaceC0922h interfaceC0922h = (InterfaceC0922h) f3105b.remove(str);
            if (interfaceC0922h != null) {
                interfaceC0922h.mo3462a(context);
            } else {
                C0921g.m3641c(f3104a, "Couldn't find callback. token: " + str);
            }
        }
    }
}
