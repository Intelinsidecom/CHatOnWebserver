package com.sec.chaton.calllog.manager.noti;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.R;
import com.sec.chaton.calllog.view.CallLogActivity;
import com.sec.chaton.calllog.view.CallLogDetailActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3250y;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: ChatONCallNotificationManager.java */
/* renamed from: com.sec.chaton.calllog.manager.noti.a */
/* loaded from: classes.dex */
public final class C0846a {

    /* renamed from: a */
    private static final String f3221a = C0846a.class.getSimpleName();

    /* renamed from: b */
    private static C0846a f3222b = new C0846a();

    /* renamed from: c */
    private final NotificationManager f3223c;

    /* renamed from: d */
    private final NotificationManager f3224d;

    /* renamed from: e */
    private int f3225e;

    /* renamed from: f */
    private int f3226f;

    private C0846a() {
        C3250y.m11453c("[ChatONCallNotificationManager] new Instance", f3221a);
        this.f3225e = 0;
        this.f3226f = 0;
        this.f3223c = (NotificationManager) GlobalApplication.m11493l().getSystemService("notification");
        this.f3224d = (NotificationManager) GlobalApplication.m11493l().getSystemService("notification");
    }

    /* renamed from: a */
    public static C0846a m4496a() {
        return f3222b;
    }

    /* renamed from: a */
    public void m4498a(long j, String str) {
        String string;
        C3250y.m11453c("notifyMissedCall - sec : " + j + ", name : " + str, f3221a);
        Notification notification = new Notification();
        notification.icon = R.drawable.chaton_quick_missed_icon;
        notification.tickerText = GlobalApplication.m11493l().getString(R.string.notification_missedCallTicker, str);
        notification.when = j;
        this.f3225e++;
        notification.number = 0;
        if (this.f3225e == 1) {
            string = GlobalApplication.m11493l().getString(R.string.notification_missedCallTitle);
        } else {
            string = GlobalApplication.m11493l().getString(R.string.notification_missedCallsTitle);
            str = GlobalApplication.m11493l().getString(R.string.notification_missedCallsMsg, Integer.valueOf(this.f3225e));
        }
        notification.setLatestEventInfo(GlobalApplication.m11493l(), string, str, PendingIntent.getBroadcast(GlobalApplication.m11493l(), 0, new Intent("com.sec.chaton.MISSEDCALL_CREATE_NOTIFICATION"), 0));
        notification.flags |= 16;
        notification.ledARGB = -368876;
        notification.ledOnMS = HttpResponseCode.INTERNAL_SERVER_ERROR;
        notification.ledOffMS = 5000;
        notification.flags |= 1;
        notification.deleteIntent = PendingIntent.getBroadcast(GlobalApplication.m11493l(), 0, new Intent("com.sec.chaton.MISSEDCALL_DELETE_NOTIFICATION"), 0);
        this.f3223c.notify(1000, notification);
    }

    /* renamed from: a */
    public void m4499a(long j, String str, String str2) {
        String string;
        String str3;
        C3250y.m11453c("notifyRejectMsg - sec : " + j + ", name : " + str + ", msg : " + str2, f3221a);
        Notification notification = new Notification();
        notification.icon = R.drawable.chaton_quick_icon;
        notification.when = j;
        this.f3226f++;
        notification.number = 0;
        if (this.f3226f == 1) {
            string = GlobalApplication.m11493l().getString(R.string.new_1_message_dont_preview);
            str3 = str + " : " + str2;
            notification.tickerText = str3;
        } else {
            string = GlobalApplication.m11493l().getString(R.string.new_chaton_messages, Integer.valueOf(this.f3226f));
            str3 = str + " : " + str2;
            notification.tickerText = str3;
        }
        notification.setLatestEventInfo(GlobalApplication.m11493l(), string, str3, PendingIntent.getBroadcast(GlobalApplication.m11493l(), 0, new Intent("com.sec.chaton.REJECT_MSG_CREATE_NOTIFICATION"), 0));
        notification.flags |= 16;
        notification.deleteIntent = PendingIntent.getBroadcast(GlobalApplication.m11493l(), 0, new Intent("com.sec.chaton.REJECT_MSG_DELETE_NOTIFICATION"), 0);
        this.f3224d.notify(2000, notification);
    }

    /* renamed from: a */
    public void m4497a(int i) {
        C3250y.m11453c("notifyCancel()", f3221a);
        if (i == 1000) {
            this.f3223c.cancel(i);
            this.f3225e = 0;
        } else if (i == 2000) {
            this.f3224d.cancel(i);
            this.f3226f = 0;
        }
    }

    /* renamed from: b */
    public Intent m4500b() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        if (this.f3225e > 1) {
            C3250y.m11453c("createCallLogMissedCallIntent() goto call log list", f3221a);
            intent.setClass(GlobalApplication.m11493l(), CallLogActivity.class);
            intent.setFlags(268435456);
            intent.addFlags(67108864);
            intent.addFlags(536870912);
        } else {
            C3250y.m11453c("createCallLogMissedCallIntent() goto call log detail", f3221a);
            intent.setClass(GlobalApplication.m11493l(), CallLogDetailActivity.class);
            bundle.putBoolean("rejected_call", false);
            bundle.putBoolean("missed_call", true);
            intent.addFlags(268435456);
            intent.addFlags(536870912);
            intent.putExtra("direct", true);
            intent.putExtras(bundle);
        }
        m4497a(1000);
        return intent;
    }

    /* renamed from: c */
    public Intent m4501c() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        if (this.f3226f > 1) {
            C3250y.m11453c("createCallLogRejectMsgIntent() goto call log list", f3221a);
            intent.setClass(GlobalApplication.m11493l(), CallLogActivity.class);
            intent.setFlags(268435456);
            intent.addFlags(67108864);
            intent.addFlags(536870912);
        } else {
            C3250y.m11453c("createCallLogRejectMsgIntent() goto call log detail", f3221a);
            intent.setClass(GlobalApplication.m11493l(), CallLogDetailActivity.class);
            bundle.putBoolean("rejected_call", true);
            bundle.putBoolean("missed_call", false);
            intent.putExtras(bundle);
            intent.addFlags(268435456);
            intent.addFlags(536870912);
        }
        m4497a(2000);
        return intent;
    }
}
