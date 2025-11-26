package com.sec.chaton.util;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.R;
import com.sec.chaton.chat.notification.C1813b;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: CommonNotificationManager.java */
/* renamed from: com.sec.chaton.util.al */
/* loaded from: classes.dex */
public class C4820al {

    /* renamed from: k */
    private static C4820al f17597k;

    /* renamed from: n */
    private static int f17598n;

    /* renamed from: o */
    private static int f17599o;

    /* renamed from: p */
    private static String f17600p;

    /* renamed from: l */
    private NotificationManager f17604l;

    /* renamed from: a */
    public static int f17588a = 101;

    /* renamed from: b */
    public static int f17589b = 102;

    /* renamed from: c */
    public static int f17590c = 103;

    /* renamed from: d */
    public static int f17591d = 104;

    /* renamed from: e */
    public static int f17592e = 105;

    /* renamed from: f */
    public static String f17593f = "action_sso";

    /* renamed from: g */
    public static String f17594g = "action_chatonv";

    /* renamed from: h */
    public static String f17595h = "action_autobackup";

    /* renamed from: i */
    public static String f17596i = "action_register_noti";

    /* renamed from: q */
    private static String f17601q = null;

    /* renamed from: r */
    private static long f17602r = 0;

    /* renamed from: j */
    private final String f17603j = C4820al.class.getSimpleName();

    /* renamed from: m */
    private Notification f17605m = null;

    private C4820al() {
        this.f17604l = null;
        this.f17604l = (NotificationManager) GlobalApplication.m18732r().getSystemService("notification");
    }

    /* renamed from: a */
    public static synchronized C4820al m18181a() {
        if (f17597k == null) {
            f17597k = new C4820al();
        }
        f17597k.m18186b();
        return f17597k;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m18184a(Context context, String str, String str2, int i) {
        if (C4904y.f17872b) {
            C4904y.m18639b("Message : " + str + " action : " + str2 + " id : " + i, this.f17603j);
        }
        Intent intent = new Intent(context, (Class<?>) HomeActivity.class);
        intent.putExtra(str2, true);
        intent.setFlags(67108864);
        if (f17601q != null) {
            intent.setAction(f17601q);
        }
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 1073741824);
        if (Build.VERSION.SDK_INT < 11) {
            this.f17605m = new Notification(f17599o, str, f17602r);
            this.f17605m.setLatestEventInfo(context, f17600p, str, activity);
            this.f17605m.flags |= 24;
        } else {
            Notification.Builder builder = new Notification.Builder(context);
            builder.setContentTitle(f17600p).setContentText(str).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), f17599o)).setWhen(f17602r).setContentIntent(activity).setSmallIcon(f17598n);
            builder.setTicker(str);
            if (Build.VERSION.SDK_INT < 16) {
                this.f17605m = builder.getNotification();
            } else {
                this.f17605m = new Notification.BigTextStyle(builder).bigText(str).build();
            }
        }
        if (this.f17605m != null) {
            this.f17604l.notify(i, this.f17605m);
        } else if (C4904y.f17872b) {
            C4904y.m18639b("noti is null", this.f17603j);
        }
    }

    /* renamed from: a */
    public void m18183a(Context context, int i) {
        C1813b.m8906b().m8917a(i);
    }

    /* renamed from: b */
    public void m18186b() {
        f17598n = R.drawable.chaton_quick_icon;
        f17599o = R.drawable.chaton_quick_icon;
        f17600p = "ChatON";
        f17602r = 0L;
    }

    /* renamed from: a */
    public void m18185a(String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("setTitle : " + str, this.f17603j);
        }
        f17600p = str;
    }

    /* renamed from: a */
    public void m18182a(long j) {
        f17602r = j;
    }

    /* renamed from: b */
    public void m18187b(String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("setAction : " + str, this.f17603j);
        }
        f17601q = str;
    }
}
