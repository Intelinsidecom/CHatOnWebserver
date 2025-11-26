package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.chat.C0520a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.C0277aq;
import com.sec.chaton.p018c.C0505l;
import com.sec.chaton.p025d.C0620a;
import com.sec.chaton.p025d.C0671x;
import com.sec.chaton.p025d.EnumC0650c;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p033io.entry.PushEntry;
import com.sec.chaton.p033io.entry.inner.Msg;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;

/* compiled from: InBoxDatabaseHelper.java */
/* renamed from: com.sec.chaton.d.a.n */
/* loaded from: classes.dex */
public class C0634n {
    /* renamed from: a */
    public static String m2902a(EnumC0651d enumC0651d, String str) throws Resources.NotFoundException {
        switch (C0629i.f2193a[enumC0651d.ordinal()]) {
            case 1:
                return GlobalApplication.m3106g().getString(R.string.media_photo);
            case 2:
                return GlobalApplication.m3106g().getString(R.string.media_video);
            case 3:
                return GlobalApplication.m3106g().getString(R.string.media_voice);
            case 4:
                return GlobalApplication.m3106g().getString(R.string.media_map);
            case 5:
                return GlobalApplication.m3106g().getString(R.string.media_contact);
            case 6:
                return GlobalApplication.m3106g().getString(R.string.media_calendar);
            case 7:
                return GlobalApplication.m3106g().getString(R.string.toast_supported_format);
            default:
                return "";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public static String m2901a(ContentResolver contentResolver, EnumC0665r enumC0665r, String str, String str2) {
        Cursor cursorQuery;
        String string = null;
        switch (C0629i.f2194b[enumC0665r.ordinal()]) {
            case 1:
                cursorQuery = contentResolver.query(C0620a.f2171a, null, "buddy_no=?", new String[]{str}, null);
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
                cursorQuery = contentResolver.query(C0671x.m3043d(), null, "buddy_no=?", new String[]{str, str2, String.valueOf(enumC0665r.m3012a())}, null);
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
                    Cursor cursorQuery2 = contentResolver.query(C0671x.f2315a, null, "inbox_session_id=?", new String[]{str2}, null);
                    if (cursorQuery2 != null) {
                        try {
                            if (cursorQuery2.getCount() > 0 && cursorQuery2.moveToFirst()) {
                                string = cursorQuery2.getString(cursorQuery2.getColumnIndex("inbox_no"));
                            }
                        } finally {
                            if (cursorQuery2 != null) {
                                cursorQuery2.close();
                            }
                        }
                    }
                    if (cursorQuery2 != null) {
                        cursorQuery2.close();
                    }
                }
                return string;
            default:
                return string;
        }
    }

    /* renamed from: a */
    public static Uri m2898a(ContentResolver contentResolver, String str, C0277aq c0277aq, String str2, EnumC0665r enumC0665r, String[] strArr, EnumC0651d enumC0651d) {
        String strM2917g;
        boolean z;
        boolean zEqualsIgnoreCase;
        if (enumC0665r == EnumC0665r.BROADCAST) {
            Cursor cursorQuery = contentResolver.query(C0671x.f2315a, null, "inbox_no=?", new String[]{str}, null);
            if (cursorQuery == null || cursorQuery.getCount() == 0) {
                SharedPreferences sharedPreferencesM4575a = C1323bs.m4575a();
                int i = (sharedPreferencesM4575a.contains("broadcast_count") ? sharedPreferencesM4575a.getInt("broadcast_count", 0) : 0) + 1;
                String string = Integer.toString(i);
                sharedPreferencesM4575a.edit().putInt("broadcast_count", i).commit();
                zEqualsIgnoreCase = false;
                strM2917g = string;
                z = true;
            } else {
                cursorQuery.moveToFirst();
                strM2917g = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title"));
                zEqualsIgnoreCase = "Y".equalsIgnoreCase(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title_fixed")));
                z = false;
            }
        } else {
            strM2917g = m2917g(contentResolver, str);
            z = true;
            zEqualsIgnoreCase = false;
        }
        String str3 = String.format("%d;%d;%s;%s", 1, Integer.valueOf(enumC0651d.m2978a()), C0520a.m2713a(str2), "");
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_no", str);
        contentValues.put("inbox_chat_type", Integer.valueOf(enumC0665r.m3012a()));
        contentValues.put("inbox_participants", Integer.valueOf(strArr.length));
        contentValues.put("inbox_last_message", str3);
        if (c0277aq.m1207j() == null) {
            contentValues.put("inbox_server_ip", GlobalApplication.m3107h().m4488b().m4513a());
            contentValues.put("inbox_server_port", Integer.valueOf(GlobalApplication.m3107h().m4488b().m4516b()));
        } else {
            contentValues.put("inbox_server_ip", c0277aq.m1207j().m1559d());
            contentValues.put("inbox_server_port", Integer.valueOf(c0277aq.m1207j().m1561f()));
        }
        contentValues.put("inbox_last_msg_sender", C1323bs.m4575a().getString("msisdn", ""));
        contentValues.put("inbox_last_msg_no", Long.valueOf(c0277aq.m1201d()));
        contentValues.put("inbox_session_id", c0277aq.m1203f());
        contentValues.put("inbox_last_time", Long.valueOf(c0277aq.m1205h()));
        contentValues.put("inbox_title", strM2917g);
        if (enumC0665r == EnumC0665r.BROADCAST && zEqualsIgnoreCase) {
            contentValues.put("inbox_title_fixed", "Y");
        }
        contentValues.put("inbox_last_chat_type", (Integer) 11);
        if (!z) {
            contentValues.put("inbox_is_new", "N");
        } else {
            contentValues.put("inbox_is_new", "Y");
        }
        if (enumC0665r == EnumC0665r.ONETOONE) {
            contentValues.put("buddy_no", strArr[0]);
        }
        return contentResolver.insert(C0671x.f2315a, contentValues);
    }

    /* renamed from: a */
    public static Uri m2900a(ContentResolver contentResolver, String str, EnumC0665r enumC0665r, Msg msg, EnumC0650c enumC0650c) {
        StringBuilder sb = new StringBuilder();
        sb.append(2).append(";");
        if (enumC0650c == EnumC0650c.MSG) {
            sb.append(EnumC0650c.MSG.m2975a()).append(";").append(C0520a.m2713a(msg.value)).append(";");
        } else {
            sb.append(C0635o.m2931a(msg.value).m2978a()).append(";").append(";");
        }
        if (enumC0665r == EnumC0665r.GROUPCHAT) {
            sb.append(C0520a.m2713a(C0631k.m2866b(contentResolver, msg.sender, (String) null)));
        }
        String string = sb.toString();
        ContentValues contentValues = new ContentValues();
        Cursor cursorM2862a = C0631k.m2862a(contentResolver, str);
        if (cursorM2862a != null) {
            contentValues.put("inbox_participants", Integer.valueOf(cursorM2862a.getCount()));
            contentValues.put("inbox_title", C0520a.m2711a(cursorM2862a));
            cursorM2862a.close();
        }
        contentValues.put("inbox_no", str);
        contentValues.put("inbox_chat_type", Integer.valueOf(enumC0665r.m3012a()));
        contentValues.put("inbox_last_message", string);
        contentValues.put("inbox_last_msg_sender", msg.sender);
        contentValues.put("inbox_last_time", msg.time);
        contentValues.put("inbox_last_msg_no", msg.f2448id);
        contentValues.put("inbox_session_id", msg.sessionid);
        contentValues.put("inbox_server_ip", msg.address);
        contentValues.put("inbox_server_port", msg.port);
        contentValues.put("inbox_last_chat_type", (Integer) 10);
        if (enumC0665r == EnumC0665r.ONETOONE) {
            contentValues.put("buddy_no", msg.sender);
        }
        contentValues.put("inbox_is_new", "Y");
        return contentResolver.insert(C0671x.f2315a, contentValues);
    }

    /* renamed from: a */
    public static Uri m2899a(ContentResolver contentResolver, String str, EnumC0665r enumC0665r, PushEntry pushEntry) {
        StringBuilder sb = new StringBuilder();
        sb.append(2).append(";");
        if (pushEntry.msgType.intValue() == EnumC0650c.MSG.m2975a()) {
            sb.append(EnumC0650c.MSG.m2975a()).append(";").append(C0520a.m2713a(pushEntry.message)).append(";");
        } else {
            sb.append(C0635o.m2932a(pushEntry.message, EnumC0651d.m2976a(pushEntry.msgType.intValue())).m2978a()).append(";").append(";");
        }
        if (enumC0665r == EnumC0665r.GROUPCHAT) {
            sb.append(C0520a.m2713a(C0631k.m2872e(contentResolver, str, pushEntry.senderID)));
        }
        String string = sb.toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_message", string);
        contentValues.put("inbox_last_time", pushEntry.sentTime);
        contentValues.put("inbox_unread_count", (Integer) 1);
        contentValues.put("inbox_server_ip", pushEntry.f2447IP);
        contentValues.put("inbox_server_port", pushEntry.PORT);
        if (TextUtils.isEmpty(pushEntry.sessionID) || pushEntry.sessionID.equalsIgnoreCase("null")) {
            contentValues.putNull("inbox_session_id");
        } else {
            contentValues.put("inbox_session_id", pushEntry.sessionID);
        }
        contentValues.put("inbox_last_msg_no", pushEntry.msgID);
        contentValues.put("inbox_last_msg_sender", pushEntry.senderID);
        contentValues.put("inbox_no", str);
        contentValues.put("inbox_participants", pushEntry.receiverCount);
        switch (C0629i.f2194b[enumC0665r.ordinal()]) {
            case 1:
            case 2:
                contentValues.put("inbox_chat_type", Integer.valueOf(EnumC0665r.ONETOONE.m3012a()));
                contentValues.put("inbox_title", C0631k.m2872e(contentResolver, str, pushEntry.senderID));
                contentValues.put("buddy_no", pushEntry.senderID);
                break;
            case 3:
                contentValues.put("inbox_chat_type", Integer.valueOf(EnumC0665r.GROUPCHAT.m3012a()));
                contentValues.put("inbox_title", C0631k.m2872e(contentResolver, str, pushEntry.senderID));
                break;
        }
        contentValues.put("inbox_last_chat_type", (Integer) 10);
        contentValues.put("inbox_is_new", "Y");
        return contentResolver.insert(C0671x.f2315a, contentValues);
    }

    /* renamed from: a */
    public static void m2904a(ContentResolver contentResolver, C0636p c0636p, EnumC0665r enumC0665r, PushEntry pushEntry) {
        if (pushEntry.sentTime.longValue() >= c0636p.f2204g) {
            StringBuilder sb = new StringBuilder();
            sb.append(2).append(";");
            if (pushEntry.msgType.intValue() == 0) {
                sb.append(EnumC0650c.MSG.m2975a()).append(";").append(C0520a.m2713a(pushEntry.message)).append(";");
            } else {
                sb.append(C0635o.m2932a(pushEntry.message, EnumC0651d.m2976a(pushEntry.msgType.intValue())).m2978a()).append(";").append(";");
            }
            if (enumC0665r == EnumC0665r.GROUPCHAT) {
                sb.append(C0520a.m2713a(C0631k.m2872e(contentResolver, c0636p.f2199b, pushEntry.senderID)));
            }
            c0636p.f2202e = sb.toString();
            if (!TextUtils.isEmpty(pushEntry.sessionID) && !pushEntry.sessionID.equalsIgnoreCase("null")) {
                c0636p.f2206i = pushEntry.sessionID;
                c0636p.f2212o = pushEntry.f2447IP;
                c0636p.f2213p = pushEntry.PORT.intValue();
            }
            if (GlobalApplication.f2408b == null || !GlobalApplication.f2408b.equals(c0636p.f2199b)) {
                c0636p.f2201d++;
            }
            c0636p.f2204g = pushEntry.sentTime.longValue();
            c0636p.f2207j = pushEntry.msgID.longValue();
            c0636p.f2208k = pushEntry.senderID;
            c0636p.f2205h = pushEntry.receiverCount.intValue();
            if (c0636p.f2210m != 11) {
                c0636p.f2210m = 10;
            }
            if (TextUtils.isEmpty(c0636p.f2203f)) {
                switch (C0629i.f2194b[enumC0665r.ordinal()]) {
                    case 1:
                    case 2:
                        c0636p.f2200c = EnumC0665r.ONETOONE.m3012a();
                        c0636p.f2203f = C0631k.m2872e(contentResolver, c0636p.f2199b, pushEntry.senderID);
                        break;
                    case 3:
                        c0636p.f2200c = EnumC0665r.GROUPCHAT.m3012a();
                        c0636p.f2203f = C0631k.m2872e(contentResolver, c0636p.f2199b, pushEntry.senderID);
                        break;
                }
            }
            m2892a(contentResolver, c0636p.f2199b, c0636p, false);
        }
    }

    /* renamed from: a */
    public static int m2895a(ContentResolver contentResolver, String str, String str2, String str3, long j, String str4, String str5, Integer num, Long l, int i, EnumC0651d enumC0651d) {
        String str6 = String.format("%d;%d;%s;%s", 1, Integer.valueOf(enumC0651d.m2978a()), C0520a.m2713a(str3), "");
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_msg_sender", str);
        contentValues.put("inbox_last_message", str6);
        contentValues.put("inbox_last_time", Long.valueOf(j));
        contentValues.put("inbox_session_id", str4);
        contentValues.put("inbox_last_msg_no", l);
        if (str5 != null) {
            contentValues.put("inbox_server_ip", str5);
        }
        if (num != null) {
            contentValues.put("inbox_server_port", num);
        }
        return contentResolver.update(C0671x.f2315a, contentValues, "inbox_no=?", new String[]{str2});
    }

    /* renamed from: a */
    public static int m2889a(ContentResolver contentResolver, String str) {
        C0636p c0636pM2913c = m2913c(contentResolver, str);
        if (c0636pM2913c != null) {
            return m2891a(contentResolver, str, c0636pM2913c);
        }
        return -1;
    }

    /* renamed from: b */
    public static int m2909b(ContentResolver contentResolver, String str) {
        C0636p c0636pM2913c = m2913c(contentResolver, str);
        if (c0636pM2913c != null) {
            return m2911b(contentResolver, str, c0636pM2913c);
        }
        return -1;
    }

    /* renamed from: a */
    public static void m2908a(C0630j c0630j, int i, String str, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_participants", Integer.valueOf(i2));
        c0630j.startUpdate(i, null, C0671x.f2315a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static int m2890a(ContentResolver contentResolver, String str, int i) {
        ContentValues contentValues = new ContentValues();
        String[] strArr = {str};
        contentValues.put("inbox_trunk_unread_count", Integer.valueOf(i));
        if (contentResolver.update(C0671x.f2315a, contentValues, "inbox_session_id=?", strArr) <= 0) {
            return -1;
        }
        return i;
    }

    /* renamed from: b */
    public static int m2910b(ContentResolver contentResolver, String str, int i) {
        int i2;
        ContentValues contentValues = new ContentValues();
        String[] strArr = {str};
        Cursor cursorQuery = contentResolver.query(C0671x.f2315a, null, "inbox_session_id=?", strArr, null);
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
        if (contentResolver.update(C0671x.f2315a, contentValues, "inbox_session_id=?", strArr) <= 0) {
            return -1;
        }
        return i3;
    }

    /* renamed from: g */
    private static String m2917g(ContentResolver contentResolver, String str) {
        String strM2711a = "";
        Cursor cursorM2862a = C0631k.m2862a(contentResolver, str);
        if (cursorM2862a != null && cursorM2862a.getCount() > 0) {
            strM2711a = C0520a.m2711a(cursorM2862a);
        }
        if (cursorM2862a != null) {
            cursorM2862a.close();
        }
        return strM2711a;
    }

    /* renamed from: c */
    public static C0636p m2913c(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C0671x.f2315a, null, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery == null || cursorQuery.getCount() == 0) {
            return null;
        }
        C0636p c0636p = new C0636p();
        cursorQuery.moveToFirst();
        c0636p.f2198a = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
        c0636p.f2199b = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
        c0636p.f2200c = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_chat_type"));
        c0636p.f2203f = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title"));
        c0636p.f2209l = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title_fixed"));
        c0636p.f2202e = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_last_message"));
        c0636p.f2210m = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_last_chat_type"));
        c0636p.f2207j = cursorQuery.getLong(cursorQuery.getColumnIndex("inbox_last_msg_no"));
        c0636p.f2208k = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_last_msg_sender"));
        c0636p.f2204g = cursorQuery.getLong(cursorQuery.getColumnIndex("inbox_last_time"));
        c0636p.f2211n = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_last_temp_msg"));
        c0636p.f2205h = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_participants"));
        c0636p.f2206i = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_session_id"));
        c0636p.f2201d = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_unread_count"));
        c0636p.f2212o = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_server_ip"));
        c0636p.f2213p = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_server_port"));
        c0636p.f2214q = cursorQuery.getLong(cursorQuery.getColumnIndex("inbox_last_timestamp"));
        c0636p.f2215r = "Y".equals(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_enable_noti")));
        cursorQuery.close();
        return c0636p;
    }

    /* renamed from: a */
    public static int m2891a(ContentResolver contentResolver, String str, C0636p c0636p) {
        return m2892a(contentResolver, str, c0636p, true);
    }

    /* renamed from: a */
    private static int m2892a(ContentResolver contentResolver, String str, C0636p c0636p, boolean z) {
        ContentValues contentValues = new ContentValues();
        Cursor cursorM2862a = C0631k.m2862a(contentResolver, str);
        if (cursorM2862a != null) {
            if (z) {
                c0636p.f2205h = cursorM2862a.getCount();
            }
            if (c0636p.f2209l.equalsIgnoreCase("n")) {
                c0636p.f2203f = C0520a.m2711a(cursorM2862a);
                contentValues.put("inbox_title", c0636p.f2203f);
            }
            cursorM2862a.close();
        }
        contentValues.put("inbox_participants", Integer.valueOf(c0636p.f2205h));
        contentValues.put("inbox_last_message", c0636p.f2202e);
        if (c0636p.f2212o != null) {
            contentValues.put("inbox_server_ip", c0636p.f2212o);
            contentValues.put("inbox_server_port", Integer.valueOf(c0636p.f2213p));
        }
        contentValues.put("inbox_last_msg_sender", c0636p.f2208k);
        contentValues.put("inbox_last_msg_no", Long.valueOf(c0636p.f2207j));
        contentValues.put("inbox_session_id", c0636p.f2206i);
        contentValues.put("inbox_last_time", Long.valueOf(c0636p.f2204g));
        contentValues.put("inbox_unread_count", Integer.valueOf(c0636p.f2201d));
        contentValues.put("inbox_last_chat_type", Integer.valueOf(c0636p.f2210m));
        contentValues.put("inbox_last_timestamp", Long.valueOf(c0636p.f2214q));
        return contentResolver.update(C0671x.f2315a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: b */
    public static int m2911b(ContentResolver contentResolver, String str, C0636p c0636p) {
        ContentValues contentValues = new ContentValues();
        Cursor cursorM2862a = C0631k.m2862a(contentResolver, str);
        if (cursorM2862a != null) {
            c0636p.f2205h = cursorM2862a.getCount();
            cursorM2862a.close();
        }
        contentValues.put("inbox_participants", Integer.valueOf(c0636p.f2205h));
        contentValues.put("inbox_last_message", c0636p.f2202e);
        if (c0636p.f2212o != null) {
            contentValues.put("inbox_server_ip", c0636p.f2212o);
            contentValues.put("inbox_server_port", Integer.valueOf(c0636p.f2213p));
        }
        contentValues.put("inbox_last_msg_sender", c0636p.f2208k);
        contentValues.put("inbox_last_msg_no", Long.valueOf(c0636p.f2207j));
        contentValues.put("inbox_session_id", c0636p.f2206i);
        contentValues.put("inbox_last_time", Long.valueOf(c0636p.f2204g));
        contentValues.put("inbox_unread_count", Integer.valueOf(c0636p.f2201d));
        contentValues.put("inbox_last_chat_type", Integer.valueOf(c0636p.f2210m));
        return contentResolver.update(C0671x.f2315a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static void m2906a(Context context) throws RemoteException, OperationApplicationException {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = contentResolver.query(C0671x.m3040b(), null, null, null, null);
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        while (cursorQuery.moveToNext()) {
            arrayList.add(ContentProviderOperation.newUpdate(C0671x.f2315a).withSelection("inbox_no=?", new String[]{cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"))}).withValue("inbox_title", cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title")).replace("\n", " ")).build());
        }
        cursorQuery.close();
        try {
            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
        } catch (Exception e) {
            C1341p.m4653a(e, "");
        }
    }

    /* renamed from: a */
    public static int m2893a(ContentResolver contentResolver, String str, String str2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_server_ip", str2);
        contentValues.put("inbox_server_port", Integer.valueOf(i));
        return contentResolver.update(C0671x.f2315a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static void m2905a(ContentResolver contentResolver, String str, C0505l c0505l) {
        Cursor cursorQuery = contentResolver.query(C0671x.f2315a, new String[]{"inbox_server_ip", "inbox_server_port"}, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            c0505l.m2546a(cursorQuery.getString(0), cursorQuery.getInt(1));
            cursorQuery.close();
        }
    }

    /* renamed from: d */
    public static int m2914d(ContentResolver contentResolver, String str) {
        C0636p c0636pM2913c = m2913c(contentResolver, str);
        if (c0636pM2913c == null || TextUtils.isEmpty(c0636pM2913c.f2212o)) {
            GlobalApplication.m3107h().m4487a(GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
            return -1;
        }
        GlobalApplication.m3107h().m4487a(c0636pM2913c.f2212o, c0636pM2913c.f2213p);
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_server_ip", GlobalApplication.m3107h().m4488b().m4513a());
        contentValues.put("inbox_server_port", Integer.valueOf(GlobalApplication.m3107h().m4488b().m4516b()));
        return contentResolver.update(C0671x.f2315a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: c */
    public static int m2912c(ContentResolver contentResolver, String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_chat_type", Integer.valueOf(i));
        return contentResolver.update(C0671x.f2315a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: e */
    public static boolean m2915e(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C0671x.f2315a, null, "inbox_no=?", new String[]{str}, null);
        int i = 10;
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_last_chat_type"));
        } else {
            C1341p.m4651a("isInboxParticipantInserted() - can't find inbox", "[InboxDatabaseHelper]");
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return i == 11;
    }

    /* renamed from: a */
    public static ArrayList m2903a(ContentResolver contentResolver) {
        Cursor cursorQuery = contentResolver.query(C0671x.f2315a, new String[]{"inbox_session_id"}, "inbox_session_id!=''", null, null);
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
    public static ContentProviderOperation m2897a(String str, String str2, long j) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0671x.m3042c());
        builderNewUpdate.withValue("buddy_no", str);
        builderNewUpdate.withValue("buddy_name", str2);
        builderNewUpdate.withValue("message_time", Long.valueOf(j));
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static int m2894a(ContentResolver contentResolver, String str, String str2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_no", str);
        contentValues.put("buddy_name", str2);
        contentValues.put("message_time", Long.valueOf(j));
        return contentResolver.update(C0671x.m3042c(), contentValues, null, null);
    }

    /* renamed from: a */
    public static void m2907a(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        C1341p.m4658b("migrationInBoxBuddyRelation", "InBoxDatabaseHelper");
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS inbox_buddy_relation");
            sQLiteDatabase.execSQL("CREATE TABLE inbox_buddy_relation (inbox_no TEXT,buddy_no TEXT,UNIQUE (inbox_no,buddy_no) ON CONFLICT REPLACE);");
            sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS trigger_inbox_before_delete");
            sQLiteDatabase.execSQL("CREATE TRIGGER trigger_inbox_before_delete BEFORE DELETE ON inbox BEGIN DELETE FROM inbox_buddy_relation WHERE inbox_no = old.inbox_no; END;");
            cursorQuery = sQLiteDatabase.query("inbox", null, "inbox_chat_type = ? AND inbox_valid = ?", new String[]{Integer.toString(EnumC0665r.ONETOONE.m3012a()), "Y"}, null, null, null);
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
    public static int m2888a(ContentResolver contentResolver, long j) {
        return contentResolver.delete(C0620a.f2171a, "buddy_no =?", new String[]{String.valueOf(j)});
    }

    /* renamed from: f */
    public static int m2916f(ContentResolver contentResolver, String str) {
        return contentResolver.delete(C0620a.f2171a, "chat_type = '" + Integer.toString(EnumC0665r.GROUPCHAT.m3012a()) + "' AND inbox_no =?", new String[]{str});
    }

    /* renamed from: a */
    public static ContentProviderOperation m2896a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C0620a.f2171a);
        builderNewDelete.withSelection("buddy_no IN ( SELECT group_relation_group FROM grouprelation WHERE group_relation_buddy = ? )", new String[]{str});
        return builderNewDelete.build();
    }
}
