package com.sec.chaton.util;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sec.chaton.ExitAppDialogActivity;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0670n;

/* compiled from: ChatONNotificationManager.java */
/* renamed from: com.sec.chaton.util.t */
/* loaded from: classes.dex */
public class C1788t {

    /* renamed from: c */
    private static C1788t f6457c;

    /* renamed from: a */
    ActivityManager f6458a;

    /* renamed from: b */
    private Context f6459b;

    /* renamed from: d */
    private NotificationManager f6460d;

    /* renamed from: e */
    private SharedPreferences f6461e = C1789u.m6075a();

    private C1788t(Context context) {
        this.f6459b = context;
        this.f6460d = (NotificationManager) this.f6459b.getSystemService("notification");
        this.f6458a = (ActivityManager) this.f6459b.getSystemService("activity");
    }

    /* renamed from: a */
    public static C1788t m6070a(Context context) {
        if (f6457c == null) {
            f6457c = new C1788t(context);
        }
        return f6457c;
    }

    /* renamed from: a */
    public void m6074a(String str, String str2, String str3, PendingIntent pendingIntent, long j, EnumC0699n enumC0699n, int i, int i2, boolean z, String str4) {
        String strM3091e;
        String string;
        String strSubstring;
        Uri actualDefaultRingtoneUri;
        Uri actualDefaultRingtoneUri2;
        String string2;
        C1786r.m6063c("[NOTI] composeAndShowNoti, sender: " + str + ", message: " + str2 + ", inboxNO: " + str3 + ", msgID: " + j + ", contentType: " + enumC0699n + ", unreadCount: " + i + ", Memory Address:" + this, getClass().getSimpleName());
        if (!ExitAppDialogActivity.m580a()) {
            if (EnumC0695j.m3145a(i2) == EnumC0695j.WEB_AUTH) {
                strM3091e = "ChatON";
            } else {
                strM3091e = C0670n.m3091e(GlobalApplication.m3260b().getContentResolver(), str3, str);
            }
            String string3 = this.f6461e.getString("lock_state", "OFF");
            C1786r.m6061b("LOCK_STATE : " + string3, getClass().getSimpleName());
            if (!this.f6461e.getBoolean("Setting show receive message", true) || string3.equals("ON")) {
                string = this.f6459b.getResources().getString(R.string.app_name);
                strSubstring = i + " " + this.f6459b.getString(R.string.message_dont_preview);
            } else {
                String str5 = i + " " + this.f6459b.getString(R.string.message_dont_preview);
                if (enumC0699n != EnumC0699n.TEXT) {
                    String strM3161a = EnumC0699n.m3161a(enumC0699n);
                    if (!TextUtils.isEmpty(strM3161a)) {
                        if (enumC0699n != EnumC0699n.DOCUMENT) {
                            string2 = String.format(strM3161a, strM3091e);
                        } else {
                            String[] strArrSplit = str2.split("\n");
                            if (strArrSplit != null && strArrSplit.length > 3) {
                                string2 = String.format(strM3161a, strM3091e, strArrSplit[3].substring(strArrSplit[3].lastIndexOf(".") + 1).toUpperCase());
                            } else {
                                string2 = String.format(strM3161a, strM3091e, "");
                            }
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(strM3091e).append(" : ").append(str2);
                        string2 = sb.toString();
                    }
                    strSubstring = string2;
                    string = str5;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(strM3091e).append(" : ").append(str2);
                    strSubstring = sb2.toString();
                    string = str5;
                }
            }
            if (strSubstring.length() > 100) {
                strSubstring = strSubstring.substring(0, 100);
            }
            Notification notification = new Notification(R.drawable.indi_chaton, strSubstring, System.currentTimeMillis());
            notification.setLatestEventInfo(this.f6459b, string, strSubstring, pendingIntent);
            C1786r.m6063c("[NOTI] composeAndShowNoti, buddyName: " + strM3091e + ", message: " + strSubstring + ", Intent Sender: " + pendingIntent.getIntentSender().toString() + "Memory Address:" + this, getClass().getSimpleName());
            String string4 = this.f6461e.getString("Set Type", "ALL");
            if (string4.equalsIgnoreCase("ALL")) {
                String string5 = this.f6461e.getString("Ringtone", null);
                if (string5 != null) {
                    if (!"Silent".equals(string5)) {
                        actualDefaultRingtoneUri2 = Uri.parse(string5);
                    } else {
                        actualDefaultRingtoneUri2 = null;
                    }
                } else {
                    actualDefaultRingtoneUri2 = RingtoneManager.getActualDefaultRingtoneUri(this.f6459b, 2);
                }
                notification.sound = actualDefaultRingtoneUri2;
                notification.vibrate = new long[]{1000, 1000, 1000};
            } else if (string4.equalsIgnoreCase("MELODY")) {
                String string6 = this.f6461e.getString("Ringtone", null);
                if (string6 != null) {
                    if (!"Silent".equals(string6)) {
                        actualDefaultRingtoneUri = Uri.parse(string6);
                    } else {
                        actualDefaultRingtoneUri = null;
                    }
                } else {
                    actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(this.f6459b, 2);
                }
                notification.sound = actualDefaultRingtoneUri;
                notification.vibrate = null;
            } else if (string4.equalsIgnoreCase("VIBRATION")) {
                notification.vibrate = new long[]{100, 1000, 1000};
                notification.sound = null;
            } else if (string4.equalsIgnoreCase("OFF")) {
                notification.sound = null;
                notification.vibrate = null;
            }
            if (!z) {
                notification.sound = null;
                notification.vibrate = null;
            }
            if (this.f6461e.getBoolean("Setting Notification", true)) {
                if (GlobalApplication.f2776b == null || !GlobalApplication.f2776b.equals(str3)) {
                    this.f6460d.cancelAll();
                    this.f6460d.notify(C0660d.m3003a(this.f6459b.getContentResolver(), str3), notification);
                    if (this.f6461e.getBoolean("Setting show blackscreen popup", true) && z) {
                        if (GlobalApplication.f2777c) {
                            if (BlackScreenNotification.f6234a) {
                                Bundle bundle = new Bundle();
                                bundle.putString("Sender", strM3091e);
                                bundle.putString("SenderID", str);
                                bundle.putString("SessionID", str4);
                                bundle.putString("TempMessage", strSubstring);
                                if (this.f6461e.getBoolean("Setting show receive message", true)) {
                                    if (str2.length() > 100) {
                                        StringBuilder sb3 = new StringBuilder(str2);
                                        sb3.setLength(97);
                                        sb3.append("...");
                                        bundle.putString("Content", sb3.toString());
                                    } else {
                                        bundle.putString("Content", str2);
                                    }
                                } else {
                                    bundle.putString("Content", i + " " + this.f6459b.getString(R.string.message_dont_preview));
                                }
                                bundle.putInt("MediaType", enumC0699n.m3162a());
                                bundle.putString("InboxNO", str3);
                                bundle.putInt("Chattype", i2);
                                if (GlobalApplication.f2778d != null) {
                                    GlobalApplication.f2778d.m5830a(bundle);
                                    return;
                                } else {
                                    C1786r.m6054a("composeAndShowNoti - blackScrrenNotification is null", getClass().getSimpleName());
                                    return;
                                }
                            }
                            if (ScreenOnNotification.f6289a) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("Sender", strM3091e);
                                bundle2.putString("SenderID", str);
                                bundle2.putString("SessionID", str4);
                                bundle2.putString("TempMessage", strSubstring);
                                if (this.f6461e.getBoolean("Setting show receive message", true)) {
                                    if (str2.length() > 100) {
                                        StringBuilder sb4 = new StringBuilder(str2);
                                        sb4.setLength(97);
                                        sb4.append("...");
                                        bundle2.putString("Content", sb4.toString());
                                    } else {
                                        bundle2.putString("Content", str2);
                                    }
                                } else {
                                    bundle2.putString("Content", i + " " + this.f6459b.getString(R.string.message_dont_preview));
                                }
                                bundle2.putInt("MediaType", enumC0699n.m3162a());
                                bundle2.putString("InboxNO", str3);
                                bundle2.putInt("Chattype", i2);
                                if (GlobalApplication.f2779e != null) {
                                    GlobalApplication.f2779e.m5864a(bundle2);
                                    return;
                                } else {
                                    C1786r.m6054a("composeAndShowNoti - scrrenOnNotification is null", getClass().getSimpleName());
                                    return;
                                }
                            }
                            if (!m6071b()) {
                                Intent intent = new Intent(this.f6459b, (Class<?>) ScreenOnNotification.class);
                                intent.putExtra("Sender", strM3091e);
                                intent.putExtra("SenderID", str);
                                intent.putExtra("SessionID", str4);
                                intent.putExtra("TempMessage", strSubstring);
                                if (this.f6461e.getBoolean("Setting show receive message", true)) {
                                    if (str2.length() > 100) {
                                        StringBuilder sb5 = new StringBuilder(str2);
                                        sb5.setLength(97);
                                        sb5.append("...");
                                        intent.putExtra("Content", sb5.toString());
                                    } else {
                                        intent.putExtra("Content", str2);
                                    }
                                } else {
                                    intent.putExtra("Content", i + " " + this.f6459b.getString(R.string.message_dont_preview));
                                }
                                intent.putExtra("MediaType", enumC0699n.m3162a());
                                intent.putExtra("InboxNO", str3);
                                intent.putExtra("Chattype", i2);
                                intent.addFlags(268435456);
                                intent.addFlags(67108864);
                                this.f6459b.startActivity(intent);
                                return;
                            }
                            return;
                        }
                        Intent intent2 = new Intent(this.f6459b, (Class<?>) BlackScreenNotification.class);
                        intent2.putExtra("Sender", strM3091e);
                        intent2.putExtra("SenderID", str);
                        intent2.putExtra("SessionID", str4);
                        if (this.f6461e.getBoolean("Setting show receive message", true)) {
                            if (str2.length() > 100) {
                                StringBuilder sb6 = new StringBuilder(str2);
                                sb6.setLength(97);
                                sb6.append("...");
                                intent2.putExtra("Content", sb6.toString());
                            } else {
                                intent2.putExtra("Content", str2);
                            }
                        } else {
                            intent2.putExtra("Content", i + " " + this.f6459b.getString(R.string.message_dont_preview));
                        }
                        intent2.putExtra("MediaType", enumC0699n.m3162a());
                        intent2.putExtra("InboxNO", str3);
                        intent2.putExtra("Chattype", i2);
                        intent2.putExtra("TempMessage", strSubstring);
                        intent2.addFlags(268435456);
                        intent2.addFlags(67108864);
                        this.f6459b.startActivity(intent2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m6073a(int i) {
        this.f6460d.cancel(i);
    }

    /* renamed from: a */
    public void m6072a() {
        this.f6460d.cancelAll();
    }

    /* renamed from: b */
    private boolean m6071b() {
        if (this.f6458a == null) {
            this.f6458a = (ActivityManager) this.f6459b.getSystemService("activity");
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : this.f6458a.getRunningAppProcesses()) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(this.f6459b.getPackageName())) {
                return true;
            }
        }
        return false;
    }
}
