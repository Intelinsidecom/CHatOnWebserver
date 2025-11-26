package com.sec.chaton.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.R;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: CommonNotificationManager.java */
/* renamed from: com.sec.chaton.util.ak */
/* loaded from: classes.dex */
public class C3169ak {

    /* renamed from: a */
    public static int f11480a = 101;

    /* renamed from: b */
    public static int f11481b = 102;

    /* renamed from: c */
    public static int f11482c = 103;

    /* renamed from: d */
    public static String f11483d = "action_sso";

    /* renamed from: e */
    public static String f11484e = "action_chatonv";

    /* renamed from: f */
    public static String f11485f = "action_autobackup";

    /* renamed from: h */
    private static C3169ak f11486h;

    /* renamed from: i */
    private NotificationManager f11488i;

    /* renamed from: g */
    private final String f11487g = C3169ak.class.getSimpleName();

    /* renamed from: j */
    private Notification f11489j = null;

    /* renamed from: n */
    private String f11493n = null;

    /* renamed from: k */
    private int f11490k = R.drawable.chaton_quick_icon;

    /* renamed from: l */
    private int f11491l = R.drawable.chaton_quick_icon;

    /* renamed from: m */
    private String f11492m = "ChatON";

    private C3169ak() {
        this.f11488i = null;
        this.f11488i = (NotificationManager) GlobalApplication.m11493l().getSystemService("notification");
    }

    /* renamed from: a */
    public static synchronized C3169ak m11035a() {
        if (f11486h == null) {
            f11486h = new C3169ak();
        }
        return f11486h;
    }

    /* renamed from: a */
    public void m11037a(Context context, String str, String str2, int i) {
        if (C3250y.f11734b) {
            C3250y.m11450b("Message : " + str + " action : " + str2 + " id : " + i, this.f11487g);
        }
        Intent intent = new Intent(context, (Class<?>) HomeActivity.class);
        intent.putExtra(str2, true);
        intent.setFlags(67108864);
        if (this.f11493n != null) {
            intent.setAction(this.f11493n);
        }
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 1073741824);
        if (Build.VERSION.SDK_INT < 11) {
            this.f11489j = new Notification(this.f11491l, str, 0L);
            this.f11489j.setLatestEventInfo(context, this.f11492m, str, activity);
            this.f11489j.flags |= 24;
        } else {
            Notification.Builder builder = new Notification.Builder(context);
            builder.setContentTitle(this.f11492m).setContentText(str).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), this.f11491l)).setWhen(0L).setContentIntent(activity).setSmallIcon(this.f11490k);
            builder.setTicker(str);
            if (Build.VERSION.SDK_INT < 16) {
                this.f11489j = builder.getNotification();
            } else {
                this.f11489j = new Notification.BigTextStyle(builder).bigText(str).build();
            }
        }
        if (this.f11489j != null) {
            this.f11488i.notify(i, this.f11489j);
        } else if (C3250y.f11734b) {
            C3250y.m11450b("noti is null", this.f11487g);
        }
    }

    /* renamed from: a */
    public void m11036a(Context context, int i) {
        C1103a.m5432a(context).m5451a(i);
    }

    /* renamed from: b */
    public void m11039b() {
        this.f11490k = R.drawable.chaton_quick_icon;
        this.f11491l = R.drawable.chaton_quick_icon;
        this.f11492m = "ChatON";
    }

    /* renamed from: a */
    public void m11038a(String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("setTitle : " + str, this.f11487g);
        }
        this.f11492m = str;
    }

    /* renamed from: b */
    public void m11040b(String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("setAction : " + str, this.f11487g);
        }
        this.f11493n = str;
    }
}
