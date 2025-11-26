package com.sec.chaton.p017e.p018a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.chat.C0493bg;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.C0147bm;
import com.sec.chaton.p017e.C0693h;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.EnumC0700o;
import com.sec.chaton.p022h.C0816z;
import com.sec.chaton.p028io.entry.PushEntry;
import com.sec.chaton.p028io.entry.inner.Msg;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.util.ArrayList;

/* compiled from: InBoxDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.d */
/* loaded from: classes.dex */
public class C0660d {
    /* renamed from: a */
    public static String m3015a(EnumC0699n enumC0699n, String str) {
        switch (C0661e.f2532a[enumC0699n.ordinal()]) {
            case 1:
                return GlobalApplication.m3262c().getString(R.string.media_photo);
            case 2:
                return GlobalApplication.m3262c().getString(R.string.last_message_me_anicon);
            case 3:
                return GlobalApplication.m3262c().getString(R.string.media_video);
            case 4:
                return GlobalApplication.m3262c().getString(R.string.media_voice);
            case 5:
                return GlobalApplication.m3262c().getString(R.string.media_map);
            case 6:
                return GlobalApplication.m3262c().getString(R.string.media_contact);
            case 7:
                return GlobalApplication.m3262c().getString(R.string.media_calendar);
            case 8:
                return GlobalApplication.m3262c().getString(R.string.media_document);
            case 9:
                return GlobalApplication.m3262c().getString(R.string.toast_supported_format);
            default:
                return "";
        }
    }

    /* renamed from: a */
    public static int m3003a(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C0694i.f2616a, new String[]{"_id"}, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery == null) {
            return 0;
        }
        int i = cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        cursorQuery.close();
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public static String m3014a(ContentResolver contentResolver, EnumC0695j enumC0695j, String str, String str2) {
        Cursor cursorQuery;
        String string = null;
        switch (C0661e.f2533b[enumC0695j.ordinal()]) {
            case 1:
                cursorQuery = contentResolver.query(C0693h.f2615a, null, "buddy_no=?", new String[]{str}, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0 && cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return string;
            case 2:
                cursorQuery = contentResolver.query(C0694i.m3144d(), null, "buddy_no=?", new String[]{str, str2}, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() > 0) {
                            cursorQuery.moveToFirst();
                            string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
                        }
                    } finally {
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return string;
            case 3:
                if (!TextUtils.isEmpty(str2)) {
                    cursorQuery = contentResolver.query(C0694i.f2616a, null, "inbox_session_id=?", new String[]{str2}, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.getCount() > 0 && cursorQuery.moveToFirst()) {
                                string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
                            }
                        } finally {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
                return string;
            default:
                return string;
        }
    }

    /* renamed from: a */
    public static Uri m3011a(ContentResolver contentResolver, String str, C0147bm c0147bm, String str2, EnumC0695j enumC0695j, String[] strArr, EnumC0699n enumC0699n) {
        String strM3033g;
        boolean z;
        boolean zEqualsIgnoreCase;
        if (enumC0695j == EnumC0695j.BROADCAST) {
            Cursor cursorQuery = contentResolver.query(C0694i.f2616a, null, "inbox_no=?", new String[]{str}, null);
            if (cursorQuery == null || cursorQuery.getCount() == 0) {
                SharedPreferences sharedPreferencesM6075a = C1789u.m6075a();
                int i = 0;
                if (sharedPreferencesM6075a.contains("broadcast_count")) {
                    i = sharedPreferencesM6075a.getInt("broadcast_count", 0);
                }
                int i2 = i + 1;
                String strM3033g2 = m3033g(contentResolver, str);
                sharedPreferencesM6075a.edit().putInt("broadcast_count", i2).commit();
                zEqualsIgnoreCase = false;
                strM3033g = strM3033g2;
                z = true;
            } else {
                z = false;
                cursorQuery.moveToFirst();
                strM3033g = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title"));
                zEqualsIgnoreCase = "Y".equalsIgnoreCase(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title_fixed")));
            }
        } else {
            strM3033g = m3033g(contentResolver, str);
            z = true;
            zEqualsIgnoreCase = false;
        }
        String str3 = String.format("%d;%d;%s;%s", 1, Integer.valueOf(enumC0699n.m3162a()), C0493bg.m2684a(str2), "");
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_no", str);
        contentValues.put("inbox_chat_type", Integer.valueOf(enumC0695j.m3146a()));
        contentValues.put("inbox_participants", Integer.valueOf(strArr.length));
        contentValues.put("inbox_last_message", str3);
        if (c0147bm.m1163j() == null) {
            contentValues.put("inbox_server_ip", GlobalApplication.m3263d().m5922b().m5923a());
            contentValues.put("inbox_server_port", Integer.valueOf(GlobalApplication.m3263d().m5922b().m5926b()));
        } else {
            contentValues.put("inbox_server_ip", c0147bm.m1163j().m1493d());
            contentValues.put("inbox_server_port", Integer.valueOf(c0147bm.m1163j().m1495f()));
        }
        contentValues.put("inbox_last_msg_sender", C1789u.m6075a().getString("msisdn", ""));
        contentValues.put("inbox_last_msg_no", Long.valueOf(c0147bm.m1157d()));
        contentValues.put("inbox_session_id", c0147bm.m1159f());
        contentValues.put("inbox_last_time", Long.valueOf(c0147bm.m1161h()));
        contentValues.put("inbox_title", strM3033g);
        if (enumC0695j == EnumC0695j.BROADCAST && zEqualsIgnoreCase) {
            contentValues.put("inbox_title_fixed", "Y");
        }
        contentValues.put("inbox_last_chat_type", (Integer) 11);
        if (!z) {
            contentValues.put("inbox_is_new", "N");
        } else {
            contentValues.put("inbox_is_new", "Y");
        }
        if (enumC0695j == EnumC0695j.ONETOONE) {
            contentValues.put("buddy_no", strArr[0]);
        }
        if (enumC0695j == EnumC0695j.GROUPCHAT) {
            contentValues.put("inbox_enable_noti", C1789u.m6075a().getBoolean("Setting alert_new_groupchat", true) ? "Y" : "N");
        } else {
            contentValues.put("inbox_enable_noti", "Y");
        }
        try {
            return contentResolver.insert(C0694i.f2616a, contentValues);
        } catch (Exception e) {
            C1786r.m6056a(e, "InBoxDatabaseHelper");
            return null;
        }
    }

    /* renamed from: a */
    public static Uri m3013a(ContentResolver contentResolver, String str, EnumC0695j enumC0695j, Msg msg, EnumC0700o enumC0700o) {
        StringBuilder sb = new StringBuilder();
        sb.append(2).append(";");
        if (enumC0700o == EnumC0700o.MSG) {
            sb.append(EnumC0700o.MSG.m3163a()).append(";").append(C0493bg.m2684a(msg.value)).append(";");
        } else {
            sb.append(C0665i.m3046a(msg.value).m3162a()).append(";").append(";");
        }
        if (enumC0695j == EnumC0695j.GROUPCHAT) {
            sb.append(C0493bg.m2684a(C0670n.m3084b(contentResolver, msg.sender, null)));
        }
        String string = sb.toString();
        ContentValues contentValues = new ContentValues();
        Cursor cursorM3080a = C0670n.m3080a(contentResolver, str);
        if (cursorM3080a != null) {
            contentValues.put("inbox_participants", Integer.valueOf(cursorM3080a.getCount()));
            contentValues.put("inbox_title", C0493bg.m2682a(cursorM3080a));
            cursorM3080a.close();
        }
        contentValues.put("inbox_no", str);
        contentValues.put("inbox_chat_type", Integer.valueOf(enumC0695j.m3146a()));
        contentValues.put("inbox_last_message", string);
        contentValues.put("inbox_last_msg_sender", msg.sender);
        contentValues.put("inbox_last_time", msg.time);
        contentValues.put("inbox_last_msg_no", msg.f3051id);
        contentValues.put("inbox_session_id", msg.sessionid);
        if (TextUtils.isEmpty(msg.address)) {
            contentValues.put("inbox_server_ip", GlobalApplication.m3263d().m5922b().m5923a());
            contentValues.put("inbox_server_port", Integer.valueOf(GlobalApplication.m3263d().m5922b().m5926b()));
        } else {
            contentValues.put("inbox_server_ip", msg.address);
            contentValues.put("inbox_server_port", msg.port);
        }
        contentValues.put("inbox_last_chat_type", (Integer) 10);
        if (enumC0695j == EnumC0695j.ONETOONE) {
            contentValues.put("buddy_no", msg.sender);
        }
        contentValues.put("inbox_is_new", "Y");
        if (enumC0695j == EnumC0695j.GROUPCHAT) {
            contentValues.put("inbox_enable_noti", C1789u.m6075a().getBoolean("Setting alert_new_groupchat", true) ? "Y" : "N");
        } else {
            contentValues.put("inbox_enable_noti", "Y");
        }
        String str2 = msg.sender;
        String strM3095b = (TextUtils.isEmpty(str2) || !str2.startsWith("0999")) ? null : C0672p.m3095b(GlobalApplication.m3260b(), str2);
        if (!TextUtils.isEmpty(strM3095b)) {
            contentValues.put("inbox_web_url", strM3095b);
        }
        try {
            return contentResolver.insert(C0694i.f2616a, contentValues);
        } catch (Exception e) {
            C1786r.m6056a(e, "InBoxDatabaseHelper");
            return null;
        }
    }

    /* renamed from: a */
    public static Uri m3012a(ContentResolver contentResolver, String str, EnumC0695j enumC0695j, PushEntry pushEntry) {
        StringBuilder sb = new StringBuilder();
        sb.append(2).append(";");
        if (pushEntry.msgType.intValue() == EnumC0700o.MSG.m3163a()) {
            sb.append(EnumC0700o.MSG.m3163a()).append(";").append(C0493bg.m2684a(pushEntry.message)).append(";");
        } else {
            sb.append(C0665i.m3047a(pushEntry.message, EnumC0699n.m3160a(pushEntry.msgType.intValue())).m3162a()).append(";").append(";");
        }
        if (enumC0695j == EnumC0695j.GROUPCHAT) {
            sb.append(C0493bg.m2684a(C0670n.m3091e(contentResolver, str, pushEntry.senderID)));
        }
        String string = sb.toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_message", string);
        contentValues.put("inbox_last_time", pushEntry.sentTime);
        contentValues.put("inbox_unread_count", (Integer) 1);
        if (TextUtils.isEmpty(pushEntry.f3049IP)) {
            contentValues.put("inbox_server_ip", GlobalApplication.m3263d().m5922b().m5923a());
            contentValues.put("inbox_server_port", Integer.valueOf(GlobalApplication.m3263d().m5922b().m5926b()));
        } else {
            contentValues.put("inbox_server_ip", pushEntry.f3049IP);
            contentValues.put("inbox_server_port", pushEntry.PORT);
        }
        if (TextUtils.isEmpty(pushEntry.sessionID) || pushEntry.sessionID.equalsIgnoreCase("null")) {
            contentValues.putNull("inbox_session_id");
        } else {
            contentValues.put("inbox_session_id", pushEntry.sessionID);
        }
        contentValues.put("inbox_last_msg_no", pushEntry.msgID);
        contentValues.put("inbox_last_msg_sender", pushEntry.senderID);
        contentValues.put("inbox_no", str);
        contentValues.put("inbox_participants", pushEntry.receiverCount);
        switch (C0661e.f2533b[enumC0695j.ordinal()]) {
            case 1:
            case 2:
                contentValues.put("inbox_chat_type", Integer.valueOf(EnumC0695j.ONETOONE.m3146a()));
                contentValues.put("inbox_title", C0670n.m3091e(contentResolver, str, pushEntry.senderID));
                contentValues.put("buddy_no", pushEntry.senderID);
                break;
            case 3:
                contentValues.put("inbox_chat_type", Integer.valueOf(EnumC0695j.GROUPCHAT.m3146a()));
                contentValues.put("inbox_title", C0670n.m3091e(contentResolver, str, pushEntry.senderID));
                break;
        }
        contentValues.put("inbox_last_chat_type", (Integer) 10);
        contentValues.put("inbox_is_new", "Y");
        if (enumC0695j == EnumC0695j.GROUPCHAT) {
            contentValues.put("inbox_enable_noti", C1789u.m6075a().getBoolean("Setting alert_new_groupchat", true) ? "Y" : "N");
        } else {
            contentValues.put("inbox_enable_noti", "Y");
        }
        String str2 = pushEntry.senderID;
        String strM3095b = (TextUtils.isEmpty(str2) || !str2.startsWith("0999")) ? null : C0672p.m3095b(GlobalApplication.m3260b(), str2);
        if (!TextUtils.isEmpty(strM3095b)) {
            contentValues.put("inbox_web_url", strM3095b);
        }
        try {
            return contentResolver.insert(C0694i.f2616a, contentValues);
        } catch (Exception e) {
            C1786r.m6056a(e, "InBoxDatabaseHelper");
            return null;
        }
    }

    /* renamed from: a */
    public static void m3019a(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_web_url", str2);
        contentResolver.update(C0694i.f2616a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static void m3017a(ContentResolver contentResolver, EnumC0695j enumC0695j, PushEntry pushEntry, String str) {
        C0662f c0662fM3030d = m3030d(contentResolver, str);
        if (c0662fM3030d != null && pushEntry.sentTime.longValue() >= c0662fM3030d.f2539f) {
            StringBuilder sb = new StringBuilder();
            sb.append(2).append(";");
            if (pushEntry.msgType.intValue() == 0) {
                sb.append(EnumC0700o.MSG.m3163a()).append(";").append(C0493bg.m2684a(pushEntry.message)).append(";");
            } else {
                sb.append(C0665i.m3047a(pushEntry.message, EnumC0699n.m3160a(pushEntry.msgType.intValue())).m3162a()).append(";").append(";");
            }
            if (enumC0695j == EnumC0695j.GROUPCHAT) {
                sb.append(C0493bg.m2684a(C0670n.m3091e(contentResolver, str, pushEntry.senderID)));
            }
            c0662fM3030d.f2537d = sb.toString();
            if (!TextUtils.isEmpty(pushEntry.sessionID) && !pushEntry.sessionID.equalsIgnoreCase("null")) {
                c0662fM3030d.f2541h = pushEntry.sessionID;
                c0662fM3030d.f2547n = pushEntry.f3049IP;
                c0662fM3030d.f2548o = pushEntry.PORT.intValue();
            }
            if (GlobalApplication.f2776b == null || !GlobalApplication.f2776b.equals(str)) {
                c0662fM3030d.f2536c++;
            }
            c0662fM3030d.f2539f = pushEntry.sentTime.longValue();
            c0662fM3030d.f2542i = pushEntry.msgID.longValue();
            c0662fM3030d.f2543j = pushEntry.senderID;
            c0662fM3030d.f2540g = pushEntry.receiverCount.intValue();
            if (c0662fM3030d.f2545l != 11) {
                c0662fM3030d.f2545l = 10;
            }
            if (TextUtils.isEmpty(c0662fM3030d.f2538e)) {
                switch (C0661e.f2533b[enumC0695j.ordinal()]) {
                    case 1:
                    case 2:
                        c0662fM3030d.f2535b = EnumC0695j.ONETOONE.m3146a();
                        c0662fM3030d.f2538e = C0670n.m3091e(contentResolver, str, pushEntry.senderID);
                        break;
                    case 3:
                        c0662fM3030d.f2535b = EnumC0695j.GROUPCHAT.m3146a();
                        c0662fM3030d.f2538e = C0670n.m3091e(contentResolver, str, pushEntry.senderID);
                        break;
                }
            }
            m3005a(contentResolver, str, c0662fM3030d);
        }
    }

    /* renamed from: a */
    public static void m3020a(ContentResolver contentResolver, String str, String str2, String str3, long j, String str4, String str5, Integer num, Long l, int i, EnumC0699n enumC0699n) {
        String str6 = String.format("%d;%d;%s;%s", 1, Integer.valueOf(enumC0699n.m3162a()), C0493bg.m2684a(str3), "");
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_msg_sender", str);
        contentValues.put("inbox_last_message", str6);
        contentValues.put("inbox_last_time", Long.valueOf(j));
        contentValues.put("inbox_session_id", str4);
        contentValues.put("inbox_last_msg_no", l);
        contentValues.put("inbox_participants", Integer.valueOf(i));
        if (str5 != null) {
            contentValues.put("inbox_server_ip", str5);
        }
        if (num != null) {
            contentValues.put("inbox_server_port", num);
        }
        contentResolver.update(C0694i.f2616a, contentValues, "inbox_no=?", new String[]{str2});
    }

    /* renamed from: b */
    public static void m3027b(ContentResolver contentResolver, String str) {
        C0662f c0662fM3030d = m3030d(contentResolver, str);
        if (c0662fM3030d != null) {
            m3005a(contentResolver, str, c0662fM3030d);
        }
    }

    /* renamed from: c */
    public static void m3028c(ContentResolver contentResolver, String str) {
        C0662f c0662fM3030d = m3030d(contentResolver, str);
        if (c0662fM3030d != null) {
            m3026b(contentResolver, str, c0662fM3030d);
        }
    }

    /* renamed from: a */
    public static void m3023a(C0666j c0666j, int i, String str, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_participants", Integer.valueOf(i2));
        c0666j.startUpdate(i, null, C0694i.f2616a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static int m3004a(ContentResolver contentResolver, String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_trunk_unread_count", Integer.valueOf(i));
        contentResolver.update(C0694i.f2616a, contentValues, "inbox_session_id=?", new String[]{str});
        return i;
    }

    /* renamed from: b */
    public static int m3025b(ContentResolver contentResolver, String str, int i) {
        int i2;
        ContentValues contentValues = new ContentValues();
        String[] strArr = {str};
        Cursor cursorQuery = contentResolver.query(C0694i.f2616a, null, "inbox_session_id=?", strArr, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            i2 = 0;
        } else {
            cursorQuery.moveToFirst();
            i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_trunk_unread_count"));
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            i3 = 0;
        }
        contentValues.put("inbox_trunk_unread_count", Integer.valueOf(i3));
        contentResolver.update(C0694i.f2616a, contentValues, "inbox_session_id=?", strArr);
        return i3;
    }

    /* renamed from: g */
    private static String m3033g(ContentResolver contentResolver, String str) {
        Cursor cursorM3080a = C0670n.m3080a(contentResolver, str);
        String strM2682a = C0493bg.m2682a(cursorM3080a);
        cursorM3080a.close();
        return strM2682a;
    }

    /* renamed from: d */
    public static C0662f m3030d(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C0694i.f2616a, null, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery == null || cursorQuery.getCount() == 0) {
            return null;
        }
        C0662f c0662f = new C0662f();
        cursorQuery.moveToFirst();
        c0662f.f2534a = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
        c0662f.f2535b = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_chat_type"));
        c0662f.f2538e = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title"));
        c0662f.f2544k = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title_fixed"));
        c0662f.f2537d = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_last_message"));
        c0662f.f2545l = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_last_chat_type"));
        c0662f.f2542i = cursorQuery.getLong(cursorQuery.getColumnIndex("inbox_last_msg_no"));
        c0662f.f2543j = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_last_msg_sender"));
        c0662f.f2539f = cursorQuery.getLong(cursorQuery.getColumnIndex("inbox_last_time"));
        c0662f.f2546m = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_last_temp_msg"));
        c0662f.f2540g = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_participants"));
        c0662f.f2541h = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_session_id"));
        c0662f.f2536c = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_unread_count"));
        c0662f.f2547n = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_server_ip"));
        c0662f.f2548o = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_server_port"));
        c0662f.f2549p = cursorQuery.getLong(cursorQuery.getColumnIndex("inbox_last_timestamp"));
        c0662f.f2550q = "Y".equals(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_enable_noti")));
        cursorQuery.close();
        return c0662f;
    }

    /* renamed from: a */
    public static int m3005a(ContentResolver contentResolver, String str, C0662f c0662f) {
        ContentValues contentValues = new ContentValues();
        Cursor cursorM3080a = C0670n.m3080a(contentResolver, str);
        if (cursorM3080a != null) {
            c0662f.f2540g = cursorM3080a.getCount();
            if (c0662f.f2544k.equalsIgnoreCase("n")) {
                c0662f.f2538e = C0493bg.m2682a(cursorM3080a);
                contentValues.put("inbox_title", c0662f.f2538e);
            }
            cursorM3080a.close();
        }
        contentValues.put("inbox_participants", Integer.valueOf(c0662f.f2540g));
        contentValues.put("inbox_last_message", c0662f.f2537d);
        if (c0662f.f2547n != null) {
            contentValues.put("inbox_server_ip", c0662f.f2547n);
            contentValues.put("inbox_server_port", Integer.valueOf(c0662f.f2548o));
        }
        contentValues.put("inbox_last_msg_sender", c0662f.f2543j);
        contentValues.put("inbox_last_msg_no", Long.valueOf(c0662f.f2542i));
        contentValues.put("inbox_session_id", c0662f.f2541h);
        contentValues.put("inbox_last_time", Long.valueOf(c0662f.f2539f));
        contentValues.put("inbox_unread_count", Integer.valueOf(c0662f.f2536c));
        contentValues.put("inbox_last_chat_type", Integer.valueOf(c0662f.f2545l));
        contentValues.put("inbox_last_timestamp", Long.valueOf(c0662f.f2549p));
        return contentResolver.update(C0694i.f2616a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: b */
    public static int m3026b(ContentResolver contentResolver, String str, C0662f c0662f) {
        ContentValues contentValues = new ContentValues();
        Cursor cursorM3080a = C0670n.m3080a(contentResolver, str);
        if (cursorM3080a != null) {
            c0662f.f2540g = cursorM3080a.getCount();
            cursorM3080a.close();
        }
        contentValues.put("inbox_participants", Integer.valueOf(c0662f.f2540g));
        contentValues.put("inbox_last_message", c0662f.f2537d);
        if (c0662f.f2547n != null) {
            contentValues.put("inbox_server_ip", c0662f.f2547n);
            contentValues.put("inbox_server_port", Integer.valueOf(c0662f.f2548o));
        }
        contentValues.put("inbox_last_msg_sender", c0662f.f2543j);
        contentValues.put("inbox_last_msg_no", Long.valueOf(c0662f.f2542i));
        contentValues.put("inbox_session_id", c0662f.f2541h);
        contentValues.put("inbox_last_time", Long.valueOf(c0662f.f2539f));
        contentValues.put("inbox_unread_count", Integer.valueOf(c0662f.f2536c));
        contentValues.put("inbox_last_chat_type", Integer.valueOf(c0662f.f2545l));
        return contentResolver.update(C0694i.f2616a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static void m3021a(Context context) throws RemoteException, OperationApplicationException {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = contentResolver.query(C0694i.m3141b(), null, null, null, null);
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        while (cursorQuery.moveToNext()) {
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title"));
            String strReplace = "";
            if (string != null) {
                strReplace = string.replace("\n", " ");
            }
            arrayList.add(ContentProviderOperation.newUpdate(C0694i.f2616a).withSelection("inbox_no=? AND inbox_valid='Y'", new String[]{cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"))}).withValue("inbox_title", strReplace).build());
        }
        cursorQuery.close();
        try {
            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
        } catch (Exception e) {
            C1786r.m6056a(e, "");
        }
    }

    /* renamed from: a */
    public static boolean m3024a(Context context, String str) {
        Cursor cursorQuery = context.getContentResolver().query(C0694i.f2616a, new String[]{"inbox_valid"}, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery != null) {
            String string = "N";
            if (cursorQuery.moveToFirst()) {
                string = cursorQuery.getString(0);
            }
            cursorQuery.close();
            if (string.equalsIgnoreCase("Y")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static int m3006a(ContentResolver contentResolver, String str, String str2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_server_ip", str2);
        contentValues.put("inbox_server_port", Integer.valueOf(i));
        return contentResolver.update(C0694i.f2616a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static void m3018a(ContentResolver contentResolver, String str, C0816z c0816z) {
        Cursor cursorQuery = contentResolver.query(C0694i.f2616a, new String[]{"inbox_server_ip", "inbox_server_port"}, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            c0816z.m3452a(cursorQuery.getString(0), cursorQuery.getInt(1));
            cursorQuery.close();
        }
    }

    /* renamed from: e */
    public static int m3031e(ContentResolver contentResolver, String str) {
        C0662f c0662fM3030d = m3030d(contentResolver, str);
        if (c0662fM3030d == null || TextUtils.isEmpty(c0662fM3030d.f2547n)) {
            GlobalApplication.m3263d().m5921a(GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
            return -1;
        }
        GlobalApplication.m3263d().m5921a(c0662fM3030d.f2547n, c0662fM3030d.f2548o);
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_server_ip", GlobalApplication.m3263d().m5922b().m5923a());
        contentValues.put("inbox_server_port", Integer.valueOf(GlobalApplication.m3263d().m5922b().m5926b()));
        return contentResolver.update(C0694i.f2616a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: c */
    public static void m3029c(ContentResolver contentResolver, String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_chat_type", Integer.valueOf(i));
        contentResolver.update(C0694i.f2616a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: f */
    public static boolean m3032f(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C0694i.f2616a, null, "inbox_no=?", new String[]{str}, null);
        int i = 10;
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_last_chat_type"));
        } else {
            C1786r.m6054a("isInboxParticipantInserted() - can't find inbox", "[InboxDatabaseHelper]");
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return i == 11;
    }

    /* renamed from: a */
    public static ArrayList m3016a(ContentResolver contentResolver) {
        Cursor cursorQuery = contentResolver.query(C0694i.f2616a, new String[]{"inbox_session_id"}, "inbox_session_id!=''", null, null);
        ArrayList arrayList = new ArrayList();
        while (cursorQuery != null && cursorQuery.moveToNext()) {
            arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_session_id")));
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    /* renamed from: a */
    public static ContentProviderOperation m3010a(String str, String str2, long j) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0694i.m3143c());
        builderNewUpdate.withValue("buddy_no", str);
        builderNewUpdate.withValue("buddy_name", str2);
        builderNewUpdate.withValue("message_time", Long.valueOf(j));
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static int m3007a(ContentResolver contentResolver, String str, String str2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_no", str);
        contentValues.put("buddy_name", str2);
        contentValues.put("message_time", Long.valueOf(j));
        return contentResolver.update(C0694i.m3143c(), contentValues, null, null);
    }

    /* renamed from: a */
    public static int m3008a(ContentResolver contentResolver, String str, boolean z) {
        String str2 = z ? "Y" : "N";
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_enable_noti", str2);
        return contentResolver.update(C0694i.f2616a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static void m3022a(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        C1786r.m6061b("migrationInBoxBuddyRelation", "InBoxDatabaseHelper");
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS inbox_buddy_relation");
            sQLiteDatabase.execSQL("CREATE TABLE inbox_buddy_relation (inbox_no TEXT,buddy_no TEXT,UNIQUE (inbox_no,buddy_no) ON CONFLICT REPLACE);");
            sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS trigger_inbox_before_delete");
            sQLiteDatabase.execSQL("CREATE TRIGGER trigger_inbox_before_delete BEFORE DELETE ON inbox BEGIN DELETE FROM inbox_buddy_relation WHERE inbox_no = old.inbox_no; END;");
            cursorQuery = sQLiteDatabase.query("inbox", null, "inbox_chat_type = ? AND inbox_valid = ?", new String[]{Integer.toString(EnumC0695j.ONETOONE.m3146a()), "Y"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        while (cursorQuery.moveToNext()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("buddy_no", string);
                            contentValues.put("inbox_no", string);
                            sQLiteDatabase.insert("inbox_buddy_relation", null, contentValues);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase.endTransaction();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: a */
    public static ContentProviderOperation m3009a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C0693h.f2615a);
        builderNewDelete.withSelection("buddy_no IN ( SELECT group_relation_group FROM grouprelation WHERE group_relation_buddy = ? )", new String[]{str});
        return builderNewDelete.build();
    }
}
