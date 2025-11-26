package com.sec.chaton.localbackup.noti;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.msgsend.C1759s;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3250y;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: AutoBackupNoti.java */
/* renamed from: com.sec.chaton.localbackup.noti.a */
/* loaded from: classes.dex */
public class C1653a {

    /* renamed from: a */
    private static final String f6124a = C1653a.class.getSimpleName();

    /* renamed from: a */
    public static void m6926a(Context context, boolean z) {
        m6928b(context, z);
    }

    /* renamed from: a */
    public static void m6925a(Context context) {
        m6927b(context);
    }

    /* renamed from: b */
    private static void m6928b(Context context, boolean z) {
        long timeInMillis;
        Intent intent = new Intent(context, (Class<?>) AutoBackupReceiver.class);
        intent.setAction("auto_alaram_backup");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 268435456);
        if (broadcast == null) {
            C1759s.m7260a(f6124a, "pending intent is NULL", new Object[0]);
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        C3160ab c3160abM10962a = C3159aa.m10962a();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        calendar.set(i, i2, i3, 1, 0);
        long timeInMillis2 = calendar.getTimeInMillis();
        if (c3160abM10962a.m10976a("auto_backup_start", 0L) == 0 && !z) {
            alarmManager.set(0, timeInMillis2, broadcast);
            c3160abM10962a.m10983b("auto_backup_on", (Boolean) true);
        } else {
            long jM10976a = c3160abM10962a.m10976a("auto_backup_start", 0L);
            if (System.currentTimeMillis() - jM10976a > 86400000) {
                timeInMillis = System.currentTimeMillis();
            } else if (jM10976a >= timeInMillis2) {
                calendar.set(i, i2, i3 + 1, 1, 0);
                timeInMillis = calendar.getTimeInMillis();
            } else {
                timeInMillis = timeInMillis2;
            }
            alarmManager.set(0, timeInMillis, broadcast);
            timeInMillis2 = timeInMillis;
        }
        C3250y.m11450b("Start Auto BackUp from : " + m6924a(Long.valueOf(timeInMillis2)), f6124a);
    }

    /* renamed from: b */
    private static void m6927b(Context context) {
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) AutoBackupReceiver.class), 0);
        if (broadcast == null) {
            C1759s.m7260a(f6124a, "stopAlarm(), pending intent is NULL", new Object[0]);
            return;
        }
        ((AlarmManager) context.getSystemService("alarm")).cancel(broadcast);
        C3159aa.m10962a().m10982a("auto_backup_start", (Long) 0L);
        C3250y.m11450b("Cancel auto backUp!", f6124a);
    }

    /* renamed from: a */
    private static String m6924a(Long l) {
        Date date = new Date();
        date.setTime(l.longValue());
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a").format(date);
    }
}
