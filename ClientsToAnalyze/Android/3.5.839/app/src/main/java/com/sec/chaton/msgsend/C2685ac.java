package com.sec.chaton.msgsend;

import android.annotation.SuppressLint;
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
/* renamed from: com.sec.chaton.msgsend.ac */
/* loaded from: classes.dex */
public class C2685ac {
    /* renamed from: a */
    public static void m11292a(String str, String str2) {
        m11293a(str, str2, str);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m11293a(String str, String str2, String str3) {
        Notification notificationBuild;
        if (C2717y.m11406i()) {
            Context contextR = GlobalApplication.m18732r();
            PendingIntent activity = PendingIntent.getActivity(contextR, 101, new Intent(), 268435456);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT < 11) {
                Notification notification = new Notification(R.drawable.clock_network_error_nor, str3, jCurrentTimeMillis);
                notification.setLatestEventInfo(contextR, str, str2, activity);
                notification.flags |= 16;
                notificationBuild = notification;
            } else {
                Notification.Builder builder = new Notification.Builder(contextR);
                builder.setContentTitle(contextR.getString(R.string.app_name)).setContentText(str2).setContentTitle(str).setDefaults(4).setWhen(jCurrentTimeMillis).setTicker(str3).setLargeIcon(BitmapFactory.decodeResource(contextR.getResources(), R.drawable.clock_network_error_nor)).setSmallIcon(R.drawable.clock_network_error_nor).setContentIntent(activity);
                if (Build.VERSION.SDK_INT < 16) {
                    notificationBuild = builder.getNotification();
                } else {
                    builder.setUsesChronometer(true);
                    notificationBuild = builder.build();
                }
            }
            NotificationManager notificationManager = (NotificationManager) contextR.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.notify(101, notificationBuild);
            }
        }
    }

    /* renamed from: a */
    public static void m11291a() {
        NotificationManager notificationManager = (NotificationManager) GlobalApplication.m18732r().getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancel(101);
        }
    }
}
