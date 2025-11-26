package com.sec.chaton.msgsend;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: MsgSendNotification.java */
/* renamed from: com.sec.chaton.msgsend.t */
/* loaded from: classes.dex */
public class C1760t {
    /* renamed from: a */
    public static void m7262a(String str, String str2) {
        m7263a(str, str2, str);
    }

    /* renamed from: a */
    public static void m7263a(String str, String str2, String str3) {
        Notification notificationBuild;
        if (C1757q.m7257g()) {
            Context contextL = GlobalApplication.m11493l();
            PendingIntent activity = PendingIntent.getActivity(contextL, 101, new Intent(), 268435456);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT < 11) {
                Notification notification = new Notification(R.drawable.clock_network_error_nor, str3, jCurrentTimeMillis);
                notification.setLatestEventInfo(contextL, str, str2, activity);
                notification.flags |= 16;
                notificationBuild = notification;
            } else {
                Notification.Builder builder = new Notification.Builder(contextL);
                builder.setContentTitle(contextL.getString(R.string.app_name)).setContentText(str2).setContentTitle(str).setDefaults(4).setWhen(jCurrentTimeMillis).setTicker(str3).setLargeIcon(BitmapFactory.decodeResource(contextL.getResources(), R.drawable.clock_network_error_nor)).setSmallIcon(R.drawable.clock_network_error_nor).setContentIntent(activity);
                if (Build.VERSION.SDK_INT < 16) {
                    notificationBuild = builder.getNotification();
                } else {
                    builder.setUsesChronometer(true);
                    notificationBuild = builder.build();
                }
            }
            NotificationManager notificationManager = (NotificationManager) contextL.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.notify(101, notificationBuild);
            }
        }
    }

    /* renamed from: a */
    public static void m7261a() {
        NotificationManager notificationManager = (NotificationManager) GlobalApplication.m11493l().getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancel(101);
        }
    }
}
