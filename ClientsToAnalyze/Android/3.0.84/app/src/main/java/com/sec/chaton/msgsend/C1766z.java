package com.sec.chaton.msgsend;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.sec.common.util.C3347i;

/* compiled from: MsgSendScheduleHelper.java */
/* renamed from: com.sec.chaton.msgsend.z */
/* loaded from: classes.dex */
public class C1766z {

    /* renamed from: a */
    private static final String f6512a = C1766z.class.getSimpleName();

    /* renamed from: a */
    public static void m7267a(Context context) {
        m7269b(context);
    }

    /* renamed from: a */
    public static void m7268a(Context context, EnumC1764x enumC1764x) {
        m7270b(context, enumC1764x);
    }

    /* renamed from: b */
    private static boolean m7270b(Context context, EnumC1764x enumC1764x) {
        if (!C1757q.m7251b()) {
            C1759s.m7260a(f6512a, "  (Refused SET ALARM !!)  -  AUTO RESEND OFF)", new Object[0]);
            return false;
        }
        if (!C3347i.m11788k()) {
            C1759s.m7260a(f6512a, "  (Refused SET ALARM !!)  -  requested (%s,  %d msec)", enumC1764x, Long.valueOf(enumC1764x.m7266b()));
            return false;
        }
        Intent intent = new Intent(context, (Class<?>) MsgSendEventReceiver.class);
        intent.putExtra("set_alarm_reason", enumC1764x.m7265a());
        intent.setAction("com.sec.chaton.msgsend.MsgSendScheduleHelper.ALARM_TIMER_ACTION");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 268435456);
        if (broadcast == null) {
            C1759s.m7260a(f6512a, "pending intent is NULL", new Object[0]);
            return false;
        }
        ((AlarmManager) context.getSystemService("alarm")).set(2, enumC1764x.m7266b() + SystemClock.elapsedRealtime(), broadcast);
        if (C1757q.m7257g()) {
            C1760t.m7262a(String.format("setALARM: %d, %s", Long.valueOf(enumC1764x.m7266b()), enumC1764x), C1752l.m7200a());
        }
        C1759s.m7260a(f6512a, " -------------- set ALARM (%s,  %d msec)", enumC1764x, Long.valueOf(enumC1764x.m7266b()));
        return true;
    }

    /* renamed from: b */
    private static void m7269b(Context context) {
        Intent intent = new Intent(context, (Class<?>) MsgSendEventReceiver.class);
        intent.setAction("com.sec.chaton.msgsend.MsgSendScheduleHelper.ALARM_TIMER_ACTION");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 536870912);
        if (broadcast == null) {
            C1759s.m7260a(f6512a, "stopAlarm(), pending intent is NULL", new Object[0]);
            return;
        }
        ((AlarmManager) context.getSystemService("alarm")).cancel(broadcast);
        if (C1757q.m7257g()) {
            C1760t.m7262a("canceled Alarm", C1752l.m7200a());
        }
        C1759s.m7260a(f6512a, "stopAlarm(), canceled ALARM", new Object[0]);
    }
}
