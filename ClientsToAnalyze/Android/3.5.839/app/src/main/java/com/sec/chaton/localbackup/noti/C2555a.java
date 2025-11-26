package com.sec.chaton.localbackup.noti;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.msgsend.C2684ab;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4904y;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: AutoBackupNoti.java */
/* renamed from: com.sec.chaton.localbackup.noti.a */
/* loaded from: classes.dex */
public class C2555a {

    /* renamed from: a */
    private static final String f9163a = C2555a.class.getSimpleName();

    /* renamed from: a */
    public static void m10957a(Context context, boolean z) {
        m10959b(context, z);
    }

    /* renamed from: a */
    public static void m10956a(Context context) {
        m10958b(context);
    }

    /* renamed from: b */
    private static void m10959b(Context context, boolean z) {
        long timeInMillis;
        Intent intent = new Intent(context, (Class<?>) AutoBackupReceiver.class);
        intent.setAction("auto_alaram_backup");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 268435456);
        if (broadcast == null) {
            C2684ab.m11290a(f9163a, "pending intent is NULL", new Object[0]);
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        C4810ab c4810abM18104a = C4809aa.m18104a();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        calendar.set(i, i2, i3, 1, 0);
        long timeInMillis2 = calendar.getTimeInMillis();
        if (c4810abM18104a.m18118a("auto_backup_start", 0L) == 0 && !z) {
            alarmManager.set(0, timeInMillis2, broadcast);
            c4810abM18104a.m18125b("auto_backup_on", (Boolean) true);
        } else {
            long jM18118a = c4810abM18104a.m18118a("auto_backup_start", 0L);
            if (System.currentTimeMillis() - jM18118a > 86400000) {
                timeInMillis = System.currentTimeMillis();
            } else if (jM18118a >= timeInMillis2) {
                calendar.set(i, i2, i3 + 1, 1, 0);
                timeInMillis = calendar.getTimeInMillis();
            } else {
                timeInMillis = timeInMillis2;
            }
            alarmManager.set(0, timeInMillis, broadcast);
            timeInMillis2 = timeInMillis;
        }
        C4904y.m18639b("Start Auto BackUp from : " + m10955a(Long.valueOf(timeInMillis2)), f9163a);
    }

    /* renamed from: b */
    private static void m10958b(Context context) {
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) AutoBackupReceiver.class), 0);
        if (broadcast == null) {
            C2684ab.m11290a(f9163a, "stopAlarm(), pending intent is NULL", new Object[0]);
            return;
        }
        ((AlarmManager) context.getSystemService("alarm")).cancel(broadcast);
        C4809aa.m18104a().m18124a("auto_backup_start", (Long) 0L);
        C4904y.m18639b("Cancel auto backUp!", f9163a);
    }

    /* renamed from: a */
    private static String m10955a(Long l) {
        Date date = new Date();
        date.setTime(l.longValue());
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a").format(date);
    }
}
