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
    private static final String f2785a = AlarmTimer.class.getSimpleName();

    /* renamed from: b */
    private static Map f2786b = new HashMap();

    /* renamed from: c */
    private static AlarmTimer f2787c;

    /* renamed from: d */
    private boolean f2788d = false;

    public interface ICallback {
        /* renamed from: a */
        void mo2965a(Context context);
    }

    private AlarmTimer() {
    }

    /* renamed from: a */
    public static AlarmTimer m3016a() {
        if (f2787c == null) {
            f2787c = new AlarmTimer();
        }
        return f2787c;
    }

    /* renamed from: a */
    public synchronized void m3017a(Context context) {
        if (!this.f2788d) {
            PushLog.m3025a(f2785a, "AlarmTimer.prepare()");
            this.f2788d = true;
            IntentFilter intentFilter = new IntentFilter("com.sec.chaton.push.ALARM_TIMER_ACTION");
            intentFilter.addDataScheme("chaton");
            intentFilter.addDataAuthority("com.sec.chaton.push", null);
            context.getApplicationContext().registerReceiver(f2787c, intentFilter);
        }
    }

    /* renamed from: a */
    public void m3018a(Context context, String str) {
        PushLog.m3025a(f2785a, "AlarmTimer.unschedule()");
        if (!this.f2788d) {
            PushLog.m3030c(f2785a, "AlarmTimer isn't prepared");
            return;
        }
        f2786b.remove(str);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent("com.sec.chaton.push.ALARM_TIMER_ACTION");
        intent.setData(Uri.parse("chaton://com.sec.chaton.push/" + str));
        alarmManager.cancel(PendingIntent.getBroadcast(context, 0, intent, 0));
    }

    /* renamed from: a */
    public void m3019a(Context context, String str, long j, ICallback iCallback) {
        PushLog.m3025a(f2785a, "AlarmTimer.schedule()");
        if (!this.f2788d) {
            PushLog.m3030c(f2785a, "AlarmTimer isn't prepared");
            return;
        }
        f2786b.put(str, iCallback);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent = new Intent("com.sec.chaton.push.ALARM_TIMER_ACTION");
        intent.setData(Uri.parse("chaton://com.sec.chaton.push/" + str));
        alarmManager.set(2, j, PendingIntent.getBroadcast(context, 0, intent, 0));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str = intent.getData().getPathSegments().get(0);
        PushLog.m3025a(f2785a, "AlarmTimer.onReceive(): " + str);
        if (!this.f2788d) {
            PushLog.m3030c(f2785a, "AlarmTimer isn't prepared");
            return;
        }
        ICallback iCallback = (ICallback) f2786b.remove(str);
        if (iCallback != null) {
            iCallback.mo2965a(context);
        } else {
            PushLog.m3030c(f2785a, "Couldn't find callback. token: " + str);
        }
    }
}
