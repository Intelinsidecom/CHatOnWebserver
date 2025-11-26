package com.sec.chaton.calllog.manager.noti;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import com.sec.chaton.R;
import com.sec.chaton.calllog.manager.p053b.C1452a;
import com.sec.chaton.calllog.view.CallLogActivity;
import com.sec.chaton.calllog.view.CallLogDetailActivity;
import com.sec.chaton.chat.notification.C1793a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.p058a.C2212z;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: ChatONCallNotificationManager.java */
/* renamed from: com.sec.chaton.calllog.manager.noti.a */
/* loaded from: classes.dex */
public final class C1457a {

    /* renamed from: e */
    private final NotificationManager f5195e;

    /* renamed from: f */
    private final NotificationManager f5196f;

    /* renamed from: g */
    private int f5197g;

    /* renamed from: h */
    private int f5198h;

    /* renamed from: c */
    private static final String f5193c = C1457a.class.getSimpleName();

    /* renamed from: d */
    private static C1457a f5194d = new C1457a();

    /* renamed from: a */
    public static int f5191a = 15;

    /* renamed from: b */
    public static int f5192b = 16;

    private C1457a() {
        C4904y.m18641c("[ChatONCallNotificationManager] new Instance", f5193c);
        this.f5197g = 0;
        this.f5198h = 0;
        this.f5195e = (NotificationManager) GlobalApplication.m18732r().getSystemService("notification");
        this.f5196f = (NotificationManager) GlobalApplication.m18732r().getSystemService("notification");
    }

    /* renamed from: a */
    public static C1457a m7650a() {
        return f5194d;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m7653a(String str, String str2) {
        String string;
        String string2;
        C4904y.m18641c("notifyMissedCall - sec : " + str + ", name : " + str2, f5193c);
        Notification notification = new Notification();
        notification.icon = R.drawable.chaton_quick_missed_icon;
        if (Build.VERSION.SDK_INT < 11) {
            notification.largeIcon = BitmapFactory.decodeResource(CommonApplication.m18732r().getResources(), R.drawable.chaton_indicator_missed_icon);
        }
        notification.tickerText = GlobalApplication.m18732r().getString(R.string.notification_missedCallTicker, str2);
        long time = 0;
        try {
            time = C1452a.m7608b(str, "yyyyMMddHHmmss").getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        notification.when = time;
        this.f5197g++;
        notification.number = 0;
        if (this.f5197g == 1) {
            string = GlobalApplication.m18732r().getString(R.string.notification_missedCallTitle);
            string2 = str2;
        } else {
            string = GlobalApplication.m18732r().getString(R.string.notification_missedCallsTitle);
            string2 = GlobalApplication.m18732r().getString(R.string.notification_missedCallsMsg, Integer.valueOf(this.f5197g));
        }
        notification.setLatestEventInfo(GlobalApplication.m18732r(), string, string2, PendingIntent.getBroadcast(GlobalApplication.m18732r(), 0, new Intent("com.sec.chaton.MISSEDCALL_CREATE_NOTIFICATION"), 0));
        notification.flags |= 16;
        notification.ledARGB = -368876;
        notification.ledOnMS = 500;
        notification.ledOffMS = 5000;
        notification.flags |= 1;
        notification.deleteIntent = PendingIntent.getBroadcast(GlobalApplication.m18732r(), 0, new Intent("com.sec.chaton.MISSEDCALL_DELETE_NOTIFICATION"), 0);
        this.f5195e.notify(1000, notification);
        m7651a(f5191a, str2, str);
    }

    /* renamed from: a */
    private void m7651a(int i, String str, String str2) {
        if (C4822an.m18218a()) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("[clearNoti] it is main thread. do 3rd app task", f5193c);
                }
                C2212z.m10068a(new C2212z(), 0, new C1793a(str, str2, i, null));
            } else {
                if (C4904y.f17873c) {
                    C4904y.m18641c("[clearNoti] it is not main thread. Call 3rd app directly", f5193c);
                }
                new C1793a(str, str2, i, null).mo8896a();
            }
        }
    }

    /* renamed from: a */
    public void m7652a(int i) {
        C4904y.m18641c("notifyCancel()", f5193c);
        if (i == 1000) {
            this.f5195e.cancel(i);
            if (this.f5197g > 0) {
                m7651a(f5192b, null, null);
            }
            this.f5197g = 0;
            return;
        }
        if (i == 1001) {
            this.f5195e.cancel(1000);
            this.f5197g = 0;
        } else if (i == 2000) {
            this.f5196f.cancel(i);
            this.f5198h = 0;
        }
    }

    /* renamed from: b */
    public Intent m7654b() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        if (this.f5197g > 1) {
            C4904y.m18641c("createCallLogMissedCallIntent() goto call log list", f5193c);
            intent.setClass(GlobalApplication.m18732r(), CallLogActivity.class);
            intent.setFlags(268435456);
            intent.addFlags(67108864);
            intent.addFlags(536870912);
        } else {
            C4904y.m18641c("createCallLogMissedCallIntent() goto call log detail", f5193c);
            intent.setClass(GlobalApplication.m18732r(), CallLogDetailActivity.class);
            bundle.putBoolean("rejected_call", false);
            bundle.putBoolean("missed_call", true);
            intent.addFlags(268435456);
            intent.addFlags(536870912);
            intent.putExtra("direct", true);
            intent.putExtras(bundle);
        }
        m7652a(1000);
        return intent;
    }

    /* renamed from: c */
    public Intent m7655c() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        if (this.f5198h > 1) {
            C4904y.m18641c("createCallLogRejectMsgIntent() goto call log list", f5193c);
            intent.setClass(GlobalApplication.m18732r(), CallLogActivity.class);
            intent.setFlags(268435456);
            intent.addFlags(67108864);
            intent.addFlags(536870912);
        } else {
            C4904y.m18641c("createCallLogRejectMsgIntent() goto call log detail", f5193c);
            intent.setClass(GlobalApplication.m18732r(), CallLogDetailActivity.class);
            bundle.putBoolean("rejected_call", true);
            bundle.putBoolean("missed_call", false);
            intent.putExtras(bundle);
            intent.addFlags(268435456);
            intent.addFlags(536870912);
        }
        m7652a(2000);
        return intent;
    }
}
