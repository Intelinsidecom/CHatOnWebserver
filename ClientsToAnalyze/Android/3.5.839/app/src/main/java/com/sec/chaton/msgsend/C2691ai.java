package com.sec.chaton.msgsend;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.sec.common.util.C5034k;

/* compiled from: MsgSendScheduleHelper.java */
/* renamed from: com.sec.chaton.msgsend.ai */
/* loaded from: classes.dex */
public class C2691ai {

    /* renamed from: a */
    private static final String f9662a = C2691ai.class.getSimpleName();

    /* renamed from: a */
    public static void m11297a(Context context) {
        m11299b(context);
    }

    /* renamed from: a */
    public static void m11298a(Context context, EnumC2689ag enumC2689ag) {
        m11300b(context, enumC2689ag);
    }

    /* renamed from: b */
    private static boolean m11300b(Context context, EnumC2689ag enumC2689ag) {
        if (!C2717y.m11398b()) {
            C2684ab.m11290a(f9662a, "  (Refused SET ALARM !!)  -  AUTO RESEND OFF)", new Object[0]);
            return false;
        }
        if (!C5034k.m19106k()) {
            C2684ab.m11290a(f9662a, "  (Refused SET ALARM !!)  -  requested (%s,  %d msec)", enumC2689ag, Long.valueOf(enumC2689ag.m11296b()));
            return false;
        }
        Intent intent = new Intent(context, (Class<?>) MsgSendEventReceiver.class);
        intent.putExtra("set_alarm_reason", enumC2689ag.m11295a());
        intent.setAction("com.sec.chaton.msgsend.MsgSendScheduleHelper.ALARM_TIMER_ACTION");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 268435456);
        if (broadcast == null) {
            C2684ab.m11290a(f9662a, "pending intent is NULL", new Object[0]);
            return false;
        }
        ((AlarmManager) context.getSystemService("alarm")).set(2, enumC2689ag.m11296b() + SystemClock.elapsedRealtime(), broadcast);
        if (C2717y.m11406i()) {
            C2685ac.m11292a(String.format("setALARM: %d, %s", Long.valueOf(enumC2689ag.m11296b()), enumC2689ag), C2707o.m11328a());
        }
        C2684ab.m11290a(f9662a, " -------------- set ALARM (%s,  %d msec)", enumC2689ag, Long.valueOf(enumC2689ag.m11296b()));
        return true;
    }

    /* renamed from: b */
    private static void m11299b(Context context) {
        Intent intent = new Intent(context, (Class<?>) MsgSendEventReceiver.class);
        intent.setAction("com.sec.chaton.msgsend.MsgSendScheduleHelper.ALARM_TIMER_ACTION");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 536870912);
        if (broadcast == null) {
            C2684ab.m11290a(f9662a, "stopAlarm(), pending intent is NULL", new Object[0]);
            return;
        }
        ((AlarmManager) context.getSystemService("alarm")).cancel(broadcast);
        if (C2717y.m11406i()) {
            C2685ac.m11292a("canceled Alarm", C2707o.m11328a());
        }
        C2684ab.m11290a(f9662a, "stopAlarm(), canceled ALARM", new Object[0]);
    }
}
