package com.sec.chaton.chat.notification;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.api.p048a.C1040v;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4810ab;
import com.sec.chaton.util.C4820al;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: FeedNotificationManager.java */
/* renamed from: com.sec.chaton.chat.notification.i */
/* loaded from: classes.dex */
public class C1820i {

    /* renamed from: b */
    private static C1820i f6887b;

    /* renamed from: d */
    private static NotificationManager f6888d;

    /* renamed from: a */
    private final String f6889a = getClass().getSimpleName();

    /* renamed from: c */
    private C4810ab f6890c = C4809aa.m18104a();

    private C1820i() {
        f6888d = (NotificationManager) CommonApplication.m18732r().getSystemService("notification");
    }

    /* renamed from: a */
    public static synchronized C1820i m8948a() {
        if (f6887b == null) {
            f6887b = new C1820i();
        }
        return f6887b;
    }

    /* renamed from: c */
    private boolean m8950c() {
        return this.f6890c.m18119a("Setting Notification", (Boolean) true).booleanValue() && this.f6890c.m18119a("pref_setting_update_notification_on", (Boolean) true).booleanValue();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m8951a(String str, String str2, ArrayList<C1821j> arrayList, String str3, String str4, String str5, String str6) throws NumberFormatException {
        Bitmap bitmapDecodeResource;
        Notification notificationBuild;
        if (!m8950c()) {
            if (C4904y.f17873c) {
                C4904y.m18641c("Do not alert update notification", this.f6889a);
                return;
            }
            return;
        }
        String str7 = arrayList.get(0).f6892b;
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.DEFAULT");
        EnumC1822k enumC1822kM8953a = EnumC1822k.m8953a(str2);
        StringBuilder sb = new StringBuilder(str4);
        if (enumC1822kM8953a == EnumC1822k.INVITE || enumC1822kM8953a == EnumC1822k.JOIN) {
            sb.append("&").append("updatePushName").append("=").append(arrayList.get(0).f6892b);
            sb.append("&").append("fromUpdatePush").append("=").append("true");
            intent.setAction("android.intent.action.SEND");
        } else {
            intent.setAction("android.intent.action.VIEW");
        }
        intent.putExtra(C1040v.f3332c, true);
        intent.setData(Uri.parse(sb.toString()));
        PendingIntent activity = PendingIntent.getActivity(CommonApplication.m18732r(), 0, intent, 1073741824);
        if (TextUtils.isEmpty(str6)) {
            str6 = Spam.ACTIVITY_CANCEL;
        }
        String strM8949a = m8949a(str, enumC1822kM8953a, arrayList, Integer.parseInt(str6), str5);
        long j = Long.parseLong(str3);
        int iIntValue = C4809aa.m18104a().m18120a("updates_notification_count", (Integer) 0).intValue();
        if (C4904y.f17873c) {
            C4904y.m18641c("[newNotificationReceived] update noti count:" + (iIntValue + 1), this.f6889a);
        }
        C4809aa.m18104a().m18126b("updates_notification_count", Integer.valueOf(iIntValue + 1));
        C4809aa.m18104a().m18125b("updates_show_new_badge", (Boolean) true);
        if (Build.VERSION.SDK_INT < 11) {
            notificationBuild = new Notification(R.drawable.chaton_quick_icon, str7, j);
            notificationBuild.number = C4809aa.m18104a().m18120a("updates_notification_count", (Integer) 1).intValue();
            notificationBuild.setLatestEventInfo(CommonApplication.m18732r(), str7, strM8949a, activity);
        } else {
            try {
                if (enumC1822kM8953a == EnumC1822k.UPDATE) {
                    try {
                        if (C2496n.m10767a(C2496n.m10757a(CommonApplication.m18732r(), arrayList.get(0).f6891a))) {
                            if (C4904y.f17873c) {
                                C4904y.m18641c("There is valid profile image. Try to read it", this.f6889a);
                            }
                            bitmapDecodeResource = C2496n.m10785d(CommonApplication.m18732r(), arrayList.get(0).f6891a);
                        } else {
                            bitmapDecodeResource = null;
                        }
                        if (bitmapDecodeResource == null) {
                            if (C4904y.f17873c) {
                                C4904y.m18641c("Bitmap for profile image is null. Set chaton icon", this.f6889a);
                            }
                            bitmapDecodeResource = BitmapFactory.decodeResource(CommonApplication.m18732r().getResources(), R.drawable.chaton_indicator_icon);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        if (0 == 0) {
                            if (C4904y.f17873c) {
                                C4904y.m18641c("Bitmap for profile image is null. Set chaton icon", this.f6889a);
                            }
                            bitmapDecodeResource = BitmapFactory.decodeResource(CommonApplication.m18732r().getResources(), R.drawable.chaton_indicator_icon);
                        } else {
                            bitmapDecodeResource = null;
                        }
                    }
                } else {
                    bitmapDecodeResource = BitmapFactory.decodeResource(CommonApplication.m18732r().getResources(), R.drawable.chaton_indicator_icon);
                }
                Notification.Builder builder = new Notification.Builder(CommonApplication.m18732r());
                builder.setContentTitle(str7).setContentText(strM8949a).setWhen(j).setLargeIcon(bitmapDecodeResource).setContentIntent(activity).setNumber(C4809aa.m18104a().m18120a("updates_notification_count", (Integer) 1).intValue()).setTicker(str7).setSmallIcon(R.drawable.chaton_quick_icon);
                if (Build.VERSION.SDK_INT < 16) {
                    notificationBuild = builder.getNotification();
                } else {
                    Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle(builder);
                    bigTextStyle.bigText(strM8949a);
                    notificationBuild = bigTextStyle.build();
                }
                EnumC1816e enumC1816eM8944i = C1813b.m8906b().m8944i();
                if (enumC1816eM8944i == EnumC1816e.MUTE_EXPIRED) {
                    C1813b.m8906b().m8942g();
                }
                if (C1813b.m8906b().m8941f() || enumC1816eM8944i == EnumC1816e.MUTE_ON) {
                    notificationBuild.sound = null;
                    notificationBuild.vibrate = null;
                } else {
                    C1813b.m8906b().m8921a(notificationBuild);
                }
                notificationBuild.flags |= 16;
            } catch (Throwable th) {
                if (0 == 0) {
                    if (C4904y.f17873c) {
                        C4904y.m18641c("Bitmap for profile image is null. Set chaton icon", this.f6889a);
                    }
                    BitmapFactory.decodeResource(CommonApplication.m18732r().getResources(), R.drawable.chaton_indicator_icon);
                }
                throw th;
            }
        }
        f6888d.notify(C4820al.f17592e, notificationBuild);
    }

    /* renamed from: a */
    private String m8949a(String str, EnumC1822k enumC1822k, ArrayList<C1821j> arrayList, int i, String str2) {
        if (EnumC1822k.UNDEFINED != enumC1822k && arrayList.size() > 0) {
            return EnumC1822k.REACTION == enumC1822k ? EnumC1823l.m8954a(str) == EnumC1823l.TRUNK ? CommonApplication.m18732r().getResources().getString(R.string.update_notification_reaction_album, arrayList.get(0).f6892b) : arrayList.size() == 1 ? CommonApplication.m18732r().getResources().getString(R.string.update_notification_reaction_post_1_buddy, arrayList.get(0).f6892b) : CommonApplication.m18732r().getResources().getString(R.string.update_notification_reaction_post_2_buddy, arrayList.get(0).f6892b, arrayList.get(1).f6892b) : EnumC1822k.RECOMMEND == enumC1822k ? i < 0 ? str2 : i == 0 ? CommonApplication.m18732r().getResources().getString(R.string.update_notification_recommend_1_buddy, arrayList.get(0).f6892b) : CommonApplication.m18732r().getResources().getString(R.string.update_notification_recommend_n_buddy, arrayList.get(0).f6892b, Integer.valueOf(i)) : EnumC1822k.UPDATE == enumC1822k ? CommonApplication.m18732r().getResources().getString(R.string.update_notification_update_profile, arrayList.get(0).f6892b) : EnumC1822k.INVITE == enumC1822k ? CommonApplication.m18732r().getResources().getString(R.string.update_notification_invite, arrayList.get(0).f6892b) : EnumC1822k.JOIN == enumC1822k ? CommonApplication.m18732r().getResources().getString(R.string.update_notification_join, arrayList.get(0).f6892b) : CommonApplication.m18732r().getResources().getString(R.string.update_notification_post, arrayList.get(0).f6892b);
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("[getNotificationContextText] show default test", this.f6889a);
        }
        return str2;
    }

    /* renamed from: b */
    public void m8952b() {
        f6888d.cancel(C4820al.f17592e);
    }
}
