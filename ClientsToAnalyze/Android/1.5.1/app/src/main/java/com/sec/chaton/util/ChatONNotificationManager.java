package com.sec.chaton.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.C0062R;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.database.helper.ParticipantDatabaseHelper;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class ChatONNotificationManager {

    /* renamed from: b */
    private static ChatONNotificationManager f3629b;

    /* renamed from: a */
    private Context f3630a;

    /* renamed from: c */
    private NotificationManager f3631c;

    /* renamed from: d */
    private SharedPreferences f3632d = ChatONPref.m3519a();

    private ChatONNotificationManager(Context context) {
        this.f3630a = context;
        this.f3631c = (NotificationManager) this.f3630a.getSystemService("notification");
    }

    /* renamed from: a */
    public static ChatONNotificationManager m3515a(Context context) {
        if (f3629b == null) {
            f3629b = new ChatONNotificationManager(context);
        }
        return f3629b;
    }

    /* renamed from: a */
    public void m3516a() {
        this.f3631c.cancelAll();
    }

    /* renamed from: a */
    public void m3517a(int i) {
        this.f3631c.cancel(i);
    }

    /* renamed from: a */
    public void m3518a(String str, String str2, String str3, PendingIntent pendingIntent, long j, ChatONContract.MessageTable.MsgContentType msgContentType, int i, int i2) {
        String string;
        ChatONLogWriter.m3508c("[NOTI] composeAndShowNoti, sender: " + str + ", message: " + str2 + ", inboxNO: " + str3 + ", msgID: " + j + ", contentType: " + msgContentType + ", unreadCount: " + i + ", Memory Address:" + this, getClass().getSimpleName());
        String strM2317e = ChatONContract.InBoxTable.ChatType.m2188a(i2) == ChatONContract.InBoxTable.ChatType.WEB_AUTH ? "ChatON" : ParticipantDatabaseHelper.m2317e(GlobalApplication.m2387e().getContentResolver(), str3, str);
        if (!this.f3632d.getBoolean("Setting show receive message", true)) {
            string = i + " " + this.f3630a.getString(C0062R.string.message_dont_preview);
        } else if (msgContentType != ChatONContract.MessageTable.MsgContentType.TEXT) {
            String strM2196a = ChatONContract.MessageTable.MsgContentType.m2196a(msgContentType);
            if (TextUtils.isEmpty(strM2196a)) {
                StringBuilder sb = new StringBuilder();
                sb.append(strM2317e).append(" ").append(str2);
                string = sb.toString();
            } else {
                string = String.format(strM2196a, strM2317e);
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strM2317e).append(" ").append(str2);
            string = sb2.toString();
        }
        if (string.length() > 100) {
            string = string.substring(0, 100);
        }
        Notification notification = new Notification(C0062R.drawable.indi_chaton, string, 0L);
        notification.setLatestEventInfo(this.f3630a, strM2317e, string, pendingIntent);
        ChatONLogWriter.m3508c("[NOTI] composeAndShowNoti, buddyName: " + strM2317e + ", message: " + string + ", Intent Sender: " + pendingIntent.getIntentSender().toString() + "Memory Address:" + this, getClass().getSimpleName());
        String string2 = this.f3632d.getString("Set Type", "ALL");
        if (string2.equalsIgnoreCase("ALL")) {
            String string3 = this.f3632d.getString("Ringtone", null);
            notification.sound = string3 != null ? !string3.equals("Silent") ? Uri.parse(string3) : null : RingtoneManager.getActualDefaultRingtoneUri(this.f3630a, 2);
            notification.vibrate = new long[]{1000, 1000, 1000};
        } else if (string2.equalsIgnoreCase("MELODY")) {
            String string4 = this.f3632d.getString("Ringtone", null);
            notification.sound = string4 != null ? !string4.equals("Silent") ? Uri.parse(string4) : null : RingtoneManager.getActualDefaultRingtoneUri(this.f3630a, 2);
            notification.vibrate = null;
        } else if (string2.equalsIgnoreCase("VIBRATION")) {
            notification.vibrate = new long[]{1000, 1000, 1000};
            notification.sound = null;
        } else if (string2.equalsIgnoreCase("OFF")) {
            notification.sound = null;
            notification.vibrate = null;
        }
        if (this.f3632d.getBoolean("Setting Notification", true)) {
            if (GlobalApplication.f1896c == null || !GlobalApplication.f1896c.equals(str3)) {
                this.f3631c.cancelAll();
                this.f3631c.notify(InBoxDatabaseHelper.m2238a(this.f3630a.getContentResolver(), str3), notification);
                if (!GlobalApplication.f1897d || BlackScreenNotification.f3611a) {
                    ChatONLogWriter.m3509d("!!!!!!!!Start Activity");
                    Intent intent = new Intent(this.f3630a, (Class<?>) BlackScreenNotification.class);
                    intent.putExtra("Sender", strM2317e);
                    intent.putExtra("Content", str2);
                    intent.putExtra("MediaType", msgContentType.m2197a());
                    intent.putExtra("InboxNO", str3);
                    intent.putExtra("Chattype", i2);
                    intent.addFlags(268435456);
                    intent.addFlags(67108864);
                    this.f3630a.startActivity(intent);
                }
            }
        }
    }
}
