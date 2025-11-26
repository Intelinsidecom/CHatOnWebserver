package com.sec.chaton.p027e.p028a;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.chat.notification.C1103a;
import com.sec.chaton.chat.p024b.C0952c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p016a.C0336cf;
import com.sec.chaton.p027e.C1404av;
import com.sec.chaton.p027e.C1447o;
import com.sec.chaton.p027e.C1448p;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.C1457y;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.InterfaceC1430bf;
import com.sec.chaton.p027e.InterfaceC1432bh;
import com.sec.chaton.p035io.entry.PushEntry;
import com.sec.chaton.p035io.entry.inner.Msg;
import com.sec.chaton.p037j.C1544ac;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3160ab;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: InBoxDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.n */
/* loaded from: classes.dex */
public class C1370n {
    /* renamed from: a */
    public static long m6110a(ContentResolver contentResolver, String str) {
        long j;
        Cursor cursorQuery = contentResolver.query(C1449q.f5381a, new String[]{"inbox_last_time"}, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery == null) {
            return 0L;
        }
        if (!cursorQuery.moveToFirst()) {
            j = 0;
        } else {
            j = cursorQuery.getLong(0);
        }
        cursorQuery.close();
        return j;
    }

    /* renamed from: b */
    public static String m6135b(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C1449q.f5381a, new String[]{"inbox_no"}, "inbox_session_id=?", new String[]{str}, null);
        if (cursorQuery != null) {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(0) : null;
            cursorQuery.close();
        }
        return string;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public static String m6122a(ContentResolver contentResolver, EnumC1450r enumC1450r, String str, String str2) {
        Cursor cursorQuery;
        String string = null;
        switch (C1371o.f5121a[enumC1450r.ordinal()]) {
            case 1:
                cursorQuery = contentResolver.query(C1447o.f5379a, null, "buddy_no=?", new String[]{str}, null);
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
                cursorQuery = contentResolver.query(C1449q.m6337g(), null, "buddy_no=?", new String[]{str, str2, String.valueOf(enumC1450r.m6342a())}, null);
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
            case 4:
                if (!TextUtils.isEmpty(str2)) {
                    Cursor cursorQuery2 = contentResolver.query(C1449q.f5381a, null, "inbox_session_id=?", new String[]{str2}, null);
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
    public static Uri m6119a(ContentResolver contentResolver, String str, C0336cf c0336cf, String str2, EnumC1450r enumC1450r, String[] strArr, EnumC1455w enumC1455w) {
        boolean zEqualsIgnoreCase;
        String strM6152p;
        boolean z;
        if (enumC1450r != EnumC1450r.BROADCAST) {
            zEqualsIgnoreCase = false;
            strM6152p = m6152p(contentResolver, str);
            z = true;
        } else {
            Cursor cursorQuery = contentResolver.query(C1449q.f5381a, null, "inbox_no=?", new String[]{str}, null);
            if (cursorQuery == null || cursorQuery.getCount() == 0) {
                C3160ab c3160abM10962a = C3159aa.m10962a();
                int iIntValue = 0;
                if (c3160abM10962a.m10987b("broadcast_count")) {
                    iIntValue = c3160abM10962a.m10978a("broadcast_count", (Integer) 0).intValue();
                }
                strM6152p = m6152p(contentResolver, str);
                c3160abM10962a.m10984b("broadcast_count", Integer.valueOf(iIntValue + 1));
                z = true;
                zEqualsIgnoreCase = false;
            } else {
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title"));
                if (TextUtils.isEmpty(string)) {
                    string = m6152p(contentResolver, str);
                }
                zEqualsIgnoreCase = "Y".equalsIgnoreCase(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title_fixed")));
                strM6152p = string;
                z = false;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        String str3 = String.format("%d;%d;%s;%s", 1, Integer.valueOf(enumC1455w.m6364a()), C1075eq.m5318a(str2), "");
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_no", str);
        contentValues.put("inbox_chat_type", Integer.valueOf(enumC1450r.m6342a()));
        contentValues.put("inbox_participants", Integer.valueOf(strArr.length));
        contentValues.put("inbox_last_message", str3);
        if (c0336cf.m2094j() == null) {
            contentValues.put("inbox_server_ip", C3194bi.m11149a().m11154c().m11155a());
        } else {
            contentValues.put("inbox_server_ip", c0336cf.m2094j().m2698d());
        }
        contentValues.put("inbox_server_port", Integer.valueOf(C3194bi.m11149a().m11154c().m11158b()));
        contentValues.put("inbox_last_msg_sender", C3159aa.m10962a().m10979a("chaton_id", ""));
        contentValues.put("inbox_last_msg_no", Long.valueOf(c0336cf.m2088d()));
        contentValues.put("inbox_session_id", c0336cf.m2090f());
        contentValues.put("inbox_last_time", Long.valueOf(c0336cf.m2092h()));
        contentValues.put("inbox_title", strM6152p);
        if (enumC1450r == EnumC1450r.BROADCAST && zEqualsIgnoreCase) {
            contentValues.put("inbox_title_fixed", "Y");
        }
        contentValues.put("inbox_last_chat_type", (Integer) 11);
        if (!z) {
            contentValues.put("inbox_is_new", "N");
        } else {
            contentValues.put("inbox_is_new", "Y");
        }
        if (enumC1450r == EnumC1450r.ONETOONE) {
            contentValues.put("buddy_no", strArr[0]);
        }
        if (enumC1450r == EnumC1450r.GROUPCHAT) {
            contentValues.put("inbox_enable_noti", C3159aa.m10962a().m10977a("Setting alert_new_groupchat", (Boolean) true).booleanValue() ? "Y" : "N");
        } else {
            contentValues.put("inbox_enable_noti", "Y");
        }
        if (enumC1450r != EnumC1450r.ONETOONE) {
            contentValues.put("inbox_last_tid", "-1");
        }
        return contentResolver.insert(C1449q.f5381a, contentValues);
    }

    /* renamed from: a */
    public static Uri m6121a(ContentResolver contentResolver, String str, EnumC1450r enumC1450r, Msg msg, EnumC1455w enumC1455w) {
        StringBuilder sb = new StringBuilder();
        sb.append(2).append(Config.KEYVALUE_SPLIT).append(enumC1455w.m6364a()).append(Config.KEYVALUE_SPLIT);
        if (enumC1455w == EnumC1455w.TEXT || enumC1455w == EnumC1455w.POLL || enumC1455w == EnumC1455w.APPLINK || enumC1455w == EnumC1455w.LIVESHARE || enumC1455w == EnumC1455w.LIVERECOMMEND || enumC1455w == EnumC1455w.LIVECONTENTS) {
            sb.append(C1075eq.m5318a(msg.value));
        }
        sb.append(Config.KEYVALUE_SPLIT);
        if (enumC1450r == EnumC1450r.GROUPCHAT) {
            sb.append(C1075eq.m5318a(C1381y.m6215b(contentResolver, msg.sender, (String) null)));
        }
        String string = sb.toString();
        ContentValues contentValues = new ContentValues();
        Cursor cursorM6209a = C1381y.m6209a(contentResolver, str);
        if (cursorM6209a != null) {
            contentValues.put("inbox_participants", Integer.valueOf(cursorM6209a.getCount()));
            contentValues.put("inbox_title", C1075eq.m5315a(cursorM6209a));
            cursorM6209a.close();
        }
        contentValues.put("inbox_no", str);
        contentValues.put("inbox_chat_type", Integer.valueOf(enumC1450r.m6342a()));
        contentValues.put("inbox_last_message", string);
        contentValues.put("inbox_last_msg_sender", msg.sender);
        contentValues.put("inbox_last_time", msg.time);
        contentValues.put("inbox_last_msg_no", msg.f5652id);
        contentValues.put("inbox_session_id", msg.sessionid);
        if (TextUtils.isEmpty(msg.address)) {
            contentValues.put("inbox_server_ip", C3194bi.m11149a().m11154c().m11155a());
            contentValues.put("inbox_server_port", Integer.valueOf(C3194bi.m11149a().m11154c().m11158b()));
        } else {
            contentValues.put("inbox_server_ip", msg.address);
            contentValues.put("inbox_server_port", msg.port);
        }
        contentValues.put("inbox_last_chat_type", (Integer) 10);
        if (enumC1450r == EnumC1450r.ONETOONE) {
            contentValues.put("buddy_no", msg.sender);
        }
        contentValues.put("inbox_is_new", "Y");
        if (enumC1450r == EnumC1450r.GROUPCHAT) {
            contentValues.put("inbox_enable_noti", C3159aa.m10962a().m10977a("Setting alert_new_groupchat", (Boolean) true).booleanValue() ? "Y" : "N");
        } else {
            contentValues.put("inbox_enable_noti", "Y");
        }
        String str2 = msg.sender;
        String strM5993b = (TextUtils.isEmpty(str2) || !str2.startsWith("0999")) ? null : C1357af.m5993b(CommonApplication.m11493l(), str2);
        if (!TextUtils.isEmpty(strM5993b)) {
            contentValues.put("inbox_web_url", strM5993b);
        }
        return contentResolver.insert(C1449q.f5381a, contentValues);
    }

    /* renamed from: a */
    public static Uri m6120a(ContentResolver contentResolver, String str, EnumC1450r enumC1450r, PushEntry pushEntry) {
        String strM6220e;
        EnumC1455w enumC1455wM6174a = C1373q.m6174a(pushEntry.message, pushEntry.msgType.intValue());
        StringBuilder sb = new StringBuilder();
        sb.append(2).append(Config.KEYVALUE_SPLIT).append(enumC1455wM6174a.m6364a()).append(Config.KEYVALUE_SPLIT);
        sb.append(C1075eq.m5318a(pushEntry.message));
        sb.append(Config.KEYVALUE_SPLIT);
        if (enumC1450r == EnumC1450r.GROUPCHAT || enumC1450r == EnumC1450r.BROADCAST2) {
            if (pushEntry.isMirror) {
                strM6220e = CommonApplication.m11493l().getString(R.string.buddy_profile_interaction_me);
            } else {
                strM6220e = C1381y.m6220e(contentResolver, str, pushEntry.senderID);
            }
            sb.append(C1075eq.m5318a(strM6220e));
        }
        String string = sb.toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_message", string);
        contentValues.put("inbox_last_time", pushEntry.sentTime);
        if (pushEntry.isMirror) {
            contentValues.put("inbox_unread_count", (Integer) 0);
        } else {
            contentValues.put("inbox_unread_count", (Integer) 1);
        }
        if (TextUtils.isEmpty(pushEntry.f5633IP)) {
            contentValues.put("inbox_server_ip", C3194bi.m11149a().m11154c().m11155a());
            contentValues.put("inbox_server_port", Integer.valueOf(C3194bi.m11149a().m11154c().m11158b()));
        } else {
            contentValues.put("inbox_server_ip", pushEntry.f5633IP);
            contentValues.put("inbox_server_port", pushEntry.PORT);
        }
        if (TextUtils.isEmpty(pushEntry.sessionID) || pushEntry.sessionID.equalsIgnoreCase("null")) {
            contentValues.putNull("inbox_session_id");
        } else {
            contentValues.put("inbox_session_id", pushEntry.sessionID);
        }
        contentValues.put("inbox_last_msg_no", pushEntry.msgID);
        if (pushEntry.isMirror) {
            contentValues.put("inbox_last_msg_sender", pushEntry.receiver);
        } else {
            contentValues.put("inbox_last_msg_sender", pushEntry.senderID);
        }
        contentValues.put("inbox_no", str);
        contentValues.put("inbox_participants", pushEntry.receiverCount);
        switch (C1371o.f5121a[enumC1450r.ordinal()]) {
            case 1:
            case 2:
                contentValues.put("inbox_chat_type", Integer.valueOf(EnumC1450r.ONETOONE.m6342a()));
                contentValues.put("inbox_title", C1381y.m6220e(contentResolver, str, pushEntry.senderID));
                contentValues.put("buddy_no", pushEntry.senderID);
                break;
            case 3:
                contentValues.put("inbox_chat_type", Integer.valueOf(EnumC1450r.GROUPCHAT.m6342a()));
                contentValues.put("inbox_title", C1381y.m6220e(contentResolver, str, pushEntry.senderID));
                break;
            case 4:
                contentValues.put("inbox_chat_type", Integer.valueOf(EnumC1450r.BROADCAST2.m6342a()));
                contentValues.put("inbox_title", C1381y.m6220e(contentResolver, str, pushEntry.senderID));
                break;
        }
        contentValues.put("inbox_last_chat_type", (Integer) 10);
        contentValues.put("inbox_is_new", "Y");
        if (enumC1450r == EnumC1450r.GROUPCHAT) {
            contentValues.put("inbox_enable_noti", C3159aa.m10962a().m10977a("Setting alert_new_groupchat", (Boolean) true).booleanValue() ? "Y" : "N");
        } else {
            contentValues.put("inbox_enable_noti", "Y");
        }
        String strM5993b = null;
        String str2 = pushEntry.senderID;
        if (!TextUtils.isEmpty(str2) && str2.startsWith("0999")) {
            strM5993b = C1357af.m5993b(CommonApplication.m11493l(), str2);
        }
        if (!TextUtils.isEmpty(strM5993b)) {
            contentValues.put("inbox_web_url", strM5993b);
        }
        return contentResolver.insert(C1449q.f5381a, contentValues);
    }

    /* renamed from: a */
    public static void m6129a(C1377u c1377u, int i, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_web_url", str2);
        c1377u.startUpdate(i, null, C1449q.f5381a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static void m6125a(ContentResolver contentResolver, C1372p c1372p, EnumC1450r enumC1450r, PushEntry pushEntry) {
        ContentValues contentValues = new ContentValues();
        EnumC1455w enumC1455wM6174a = C1373q.m6174a(pushEntry.message, pushEntry.msgType.intValue());
        StringBuilder sb = new StringBuilder();
        sb.append(2).append(Config.KEYVALUE_SPLIT).append(enumC1455wM6174a.m6364a()).append(Config.KEYVALUE_SPLIT);
        sb.append(C1075eq.m5318a(pushEntry.message));
        sb.append(Config.KEYVALUE_SPLIT);
        if (pushEntry.isMirror) {
            sb.append(C1075eq.m5318a(CommonApplication.m11493l().getString(R.string.buddy_profile_interaction_me)));
        } else if (enumC1450r == EnumC1450r.GROUPCHAT) {
            sb.append(C1075eq.m5318a(C1381y.m6220e(contentResolver, c1372p.f5123b, pushEntry.senderID)));
        }
        contentValues.put("inbox_last_message", sb.toString());
        if (!TextUtils.isEmpty(pushEntry.sessionID) && !pushEntry.sessionID.equalsIgnoreCase("null")) {
            contentValues.put("inbox_session_id", c1372p.f5130i);
            contentValues.put("inbox_server_ip", pushEntry.f5633IP);
            contentValues.put("inbox_server_port", pushEntry.PORT);
        }
        int i = (C1103a.m5432a(GlobalApplication.m11493l()).m5458a(c1372p.f5123b) || pushEntry.isMirror) ? 0 : 1;
        contentValues.put("inbox_unread_count", Integer.valueOf(i));
        contentValues.put("inbox_participants", pushEntry.receiverCount);
        if (pushEntry.isMirror) {
            contentValues.put("inbox_last_msg_sender", pushEntry.receiver);
        } else {
            contentValues.put("inbox_last_msg_sender", pushEntry.senderID);
        }
        contentValues.put("inbox_last_msg_no", pushEntry.msgID);
        contentValues.put("inbox_last_time", pushEntry.sentTime);
        if (c1372p.f5134m != 11) {
            contentValues.put("inbox_last_chat_type", (Integer) 10);
        }
        if (TextUtils.isEmpty(c1372p.f5127f)) {
            switch (C1371o.f5121a[enumC1450r.ordinal()]) {
                case 1:
                case 2:
                    contentValues.put("inbox_chat_type", Integer.valueOf(EnumC1450r.ONETOONE.m6342a()));
                    contentValues.put("inbox_title", C1381y.m6220e(contentResolver, c1372p.f5123b, pushEntry.senderID));
                    break;
                case 3:
                    contentValues.put("inbox_chat_type", Integer.valueOf(EnumC1450r.GROUPCHAT.m6342a()));
                    contentValues.put("inbox_title", C1381y.m6220e(contentResolver, c1372p.f5123b, pushEntry.senderID));
                    break;
            }
        }
        contentResolver.update(C1449q.m6338h(), contentValues, "inbox_no=?", new String[]{c1372p.f5123b});
    }

    /* renamed from: a */
    public static ContentProviderOperation m6116a(String str, String[] strArr, ContentValues contentValues) {
        return ContentProviderOperation.newUpdate(C1449q.f5381a).withValues(contentValues).withSelection(str, strArr).build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m6134b(String str, String[] strArr, ContentValues contentValues) {
        return ContentProviderOperation.newUpdate(C1447o.f5379a).withValues(contentValues).withSelection(str, strArr).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6114a(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("lasst_session_merge_time", Long.valueOf(j));
        return ContentProviderOperation.newUpdate(C1449q.f5381a).withValues(contentValues).withSelection("inbox_no=?", new String[]{str}).build();
    }

    /* renamed from: a */
    public static int m6108a(ContentResolver contentResolver, String str, String str2, String str3, long j, String str4, String str5, Integer num, Long l, int i, EnumC1455w enumC1455w) {
        String str6 = String.format("%d;%d;%s;%s", 1, Integer.valueOf(enumC1455w.m6364a()), C1075eq.m5318a(str3), "");
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_msg_sender", str);
        contentValues.put("inbox_last_message", str6);
        contentValues.put("inbox_last_time", Long.valueOf(j));
        contentValues.put("inbox_session_id", str4);
        contentValues.put("inbox_last_msg_no", l);
        if (!TextUtils.isEmpty(str5) && num != null && num.intValue() > 0) {
            contentValues.put("inbox_server_ip", str5);
            contentValues.put("inbox_server_port", num);
        }
        return contentResolver.update(C1449q.f5381a, contentValues, "inbox_no=?", new String[]{str2});
    }

    /* renamed from: c */
    public static int m6136c(ContentResolver contentResolver, String str) {
        C1372p c1372pM6140d = m6140d(contentResolver, str);
        if (c1372pM6140d != null) {
            return m6132b(contentResolver, str, c1372pM6140d);
        }
        return -1;
    }

    /* renamed from: a */
    public static ContentProviderOperation m6111a(ContentResolver contentResolver, String str, int i) {
        ContentValues contentValues = new ContentValues();
        String[] strArr = {str};
        contentValues.put("inbox_trunk_unread_count", Integer.valueOf(i));
        return ContentProviderOperation.newUpdate(C1449q.f5381a).withValues(contentValues).withSelection("inbox_session_id=?", strArr).build();
    }

    /* renamed from: a */
    public static ContentProviderResult[] m6130a(Context context, ArrayList<ContentProviderOperation> arrayList) {
        return context.getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
    }

    /* renamed from: b */
    public static int m6131b(ContentResolver contentResolver, String str, int i) {
        int i2;
        ContentValues contentValues = new ContentValues();
        String[] strArr = {str};
        Cursor cursorQuery = contentResolver.query(C1449q.f5381a, null, "inbox_session_id=?", strArr, null);
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
        if (contentResolver.update(C1449q.f5381a, contentValues, "inbox_session_id=?", strArr) <= 0) {
            return -1;
        }
        return i3;
    }

    /* renamed from: p */
    private static String m6152p(ContentResolver contentResolver, String str) {
        String strM5315a = "";
        Cursor cursorM6209a = C1381y.m6209a(contentResolver, str);
        if (cursorM6209a != null && cursorM6209a.getCount() > 0) {
            strM5315a = C1075eq.m5315a(cursorM6209a);
        }
        if (cursorM6209a != null) {
            cursorM6209a.close();
        }
        return strM5315a;
    }

    /* renamed from: d */
    public static C1372p m6140d(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C1449q.f5381a, null, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery == null || cursorQuery.getCount() == 0) {
            return null;
        }
        C1372p c1372p = new C1372p();
        cursorQuery.moveToFirst();
        c1372p.f5122a = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
        c1372p.f5123b = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
        c1372p.f5124c = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_chat_type"));
        c1372p.f5127f = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title"));
        c1372p.f5133l = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_title_fixed"));
        c1372p.f5126e = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_last_message"));
        c1372p.f5134m = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_last_chat_type"));
        c1372p.f5131j = cursorQuery.getLong(cursorQuery.getColumnIndex("inbox_last_msg_no"));
        c1372p.f5132k = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_last_msg_sender"));
        c1372p.f5128g = cursorQuery.getLong(cursorQuery.getColumnIndex("inbox_last_time"));
        c1372p.f5135n = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_last_temp_msg"));
        c1372p.f5129h = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_participants"));
        c1372p.f5130i = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_session_id"));
        c1372p.f5125d = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_unread_count"));
        c1372p.f5136o = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_server_ip"));
        c1372p.f5137p = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_server_port"));
        c1372p.f5138q = cursorQuery.getLong(cursorQuery.getColumnIndex("inbox_last_timestamp"));
        c1372p.f5139r = "Y".equals(cursorQuery.getString(cursorQuery.getColumnIndex("inbox_enable_noti")));
        c1372p.f5140s = cursorQuery.getLong(cursorQuery.getColumnIndex("lasst_session_merge_time"));
        c1372p.f5141t = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_old_no"));
        c1372p.f5142u = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_trunk_unread_count"));
        cursorQuery.close();
        return c1372p;
    }

    /* renamed from: a */
    public static ContentValues m6117a(ContentResolver contentResolver, String str, C1372p c1372p) {
        ContentValues contentValues = new ContentValues();
        Cursor cursorM6209a = C1381y.m6209a(contentResolver, str);
        if (cursorM6209a != null) {
            c1372p.f5129h = cursorM6209a.getCount();
            if (c1372p.f5133l.equalsIgnoreCase("n")) {
                c1372p.f5127f = C1075eq.m5315a(cursorM6209a);
                contentValues.put("inbox_title", c1372p.f5127f);
            }
            cursorM6209a.close();
        }
        contentValues.put("inbox_participants", Integer.valueOf(c1372p.f5129h));
        contentValues.put("inbox_last_message", c1372p.f5126e);
        if (c1372p.f5136o != null) {
            contentValues.put("inbox_server_ip", c1372p.f5136o);
            contentValues.put("inbox_server_port", Integer.valueOf(c1372p.f5137p));
        }
        contentValues.put("inbox_last_msg_sender", c1372p.f5132k);
        contentValues.put("inbox_last_msg_no", Long.valueOf(c1372p.f5131j));
        contentValues.put("inbox_session_id", c1372p.f5130i);
        contentValues.put("inbox_last_time", Long.valueOf(c1372p.f5128g));
        contentValues.put("inbox_unread_count", Integer.valueOf(c1372p.f5125d));
        contentValues.put("inbox_last_chat_type", Integer.valueOf(c1372p.f5134m));
        contentValues.put("inbox_last_timestamp", Long.valueOf(c1372p.f5138q));
        return contentValues;
    }

    /* renamed from: b */
    public static int m6132b(ContentResolver contentResolver, String str, C1372p c1372p) {
        return contentResolver.update(C1449q.f5381a, m6117a(contentResolver, str, c1372p), "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static int m6105a(ContentResolver contentResolver, String str, C1372p c1372p, int i) {
        ContentValues contentValuesM6117a = m6117a(contentResolver, str, c1372p);
        contentValuesM6117a.put("inbox_unread_count", Integer.valueOf(i));
        return contentResolver.update(C1449q.m6335e(), contentValuesM6117a, "inbox_no=?", new String[]{str});
    }

    /* renamed from: c */
    public static ContentProviderOperation m6139c(ContentResolver contentResolver, String str, C1372p c1372p) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_title", c1372p.f5127f);
        contentValues.put("inbox_no", c1372p.f5123b);
        contentValues.put("inbox_participants", Integer.valueOf(c1372p.f5129h));
        contentValues.put("inbox_last_message", c1372p.f5126e);
        if (c1372p.f5136o != null) {
            contentValues.put("inbox_server_ip", c1372p.f5136o);
            contentValues.put("inbox_server_port", Integer.valueOf(c1372p.f5137p));
        }
        contentValues.put("inbox_last_msg_sender", c1372p.f5132k);
        contentValues.put("inbox_last_msg_no", Long.valueOf(c1372p.f5131j));
        contentValues.put("inbox_session_id", c1372p.f5130i);
        contentValues.put("inbox_last_time", Long.valueOf(c1372p.f5128g));
        contentValues.put("inbox_unread_count", Integer.valueOf(c1372p.f5125d));
        contentValues.put("inbox_last_chat_type", Integer.valueOf(c1372p.f5134m));
        contentValues.put("inbox_last_timestamp", Long.valueOf(c1372p.f5138q));
        return ContentProviderOperation.newUpdate(C1449q.f5381a).withValues(contentValues).withSelection("inbox_no=?", new String[]{str}).build();
    }

    /* renamed from: a */
    public static int m6106a(ContentResolver contentResolver, String str, String str2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_server_ip", str2);
        contentValues.put("inbox_server_port", Integer.valueOf(i));
        return contentResolver.update(C1449q.f5381a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static void m6126a(ContentResolver contentResolver, String str, C1544ac c1544ac) {
        Cursor cursorQuery = contentResolver.query(C1449q.f5381a, new String[]{"inbox_server_ip", "inbox_server_port"}, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            c1544ac.m6553a(cursorQuery.getString(0), cursorQuery.getInt(1));
            cursorQuery.close();
        }
    }

    /* renamed from: e */
    public static int m6141e(ContentResolver contentResolver, String str) {
        C1372p c1372pM6140d = m6140d(contentResolver, str);
        if (c1372pM6140d == null || TextUtils.isEmpty(c1372pM6140d.f5136o)) {
            C3194bi.m11149a().m11152a(C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
            return -1;
        }
        C3194bi.m11149a().m11152a(c1372pM6140d.f5136o, c1372pM6140d.f5137p);
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_server_ip", C3194bi.m11149a().m11154c().m11155a());
        contentValues.put("inbox_server_port", Integer.valueOf(C3194bi.m11149a().m11154c().m11158b()));
        return contentResolver.update(C1449q.f5381a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: c */
    public static int m6137c(ContentResolver contentResolver, String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_chat_type", Integer.valueOf(i));
        return contentResolver.update(C1449q.f5381a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: f */
    public static boolean m6142f(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C1449q.f5381a, null, "inbox_no=?", new String[]{str}, null);
        int i = 10;
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_last_chat_type"));
        } else {
            C3250y.m11442a("isInboxParticipantInserted() - can't find inbox", "[InboxDatabaseHelper]");
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return i == 11;
    }

    /* renamed from: a */
    public static ContentProviderOperation m6115a(String str, String str2) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C1449q.f5381a);
        builderNewUpdate.withSelection("inbox_no=?", new String[]{str});
        builderNewUpdate.withValue("inbox_last_tid", str2);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static int m6107a(ContentResolver contentResolver, String str, String str2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_no", str);
        contentValues.put("buddy_name", str2);
        contentValues.put("message_time", Long.valueOf(j));
        contentValues.put("KEY_DEACTIVATED", (Boolean) false);
        return contentResolver.update(C1449q.m6336f(), contentValues, null, null);
    }

    /* renamed from: a */
    public static int m6104a(ContentResolver contentResolver, String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_no", str);
        contentValues.put("message_time", Long.valueOf(j));
        contentValues.put("KEY_DEACTIVATED", (Boolean) true);
        return contentResolver.update(C1449q.m6336f(), contentValues, null, null);
    }

    /* renamed from: a */
    public static int m6109a(ContentResolver contentResolver, String str, boolean z) {
        String str2 = z ? "Y" : "N";
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_enable_noti", str2);
        return contentResolver.update(C1449q.f5381a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static void m6128a(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        C3250y.m11450b("migrationInBoxBuddyRelation", "InBoxDatabaseHelper");
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS inbox_buddy_relation");
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5328g);
            sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS trigger_inbox_before_delete");
            sQLiteDatabase.execSQL(InterfaceC1432bh.f5355a);
            cursorQuery = sQLiteDatabase.query("inbox", null, "inbox_chat_type = ? AND inbox_valid = ?", new String[]{Integer.toString(EnumC1450r.ONETOONE.m6342a()), "Y"}, null, null, null);
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
    public static int m6103a(ContentResolver contentResolver, long j) {
        return contentResolver.delete(C1447o.f5379a, "buddy_no =?", new String[]{String.valueOf(j)});
    }

    /* renamed from: g */
    public static int m6143g(ContentResolver contentResolver, String str) {
        return contentResolver.delete(C1447o.f5379a, "chat_type = '" + Integer.toString(EnumC1450r.GROUPCHAT.m6342a()) + "' AND inbox_no =?", new String[]{str});
    }

    /* renamed from: a */
    public static ContentProviderOperation m6113a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C1447o.f5379a);
        builderNewDelete.withSelection("buddy_no IN ( SELECT group_relation_group FROM grouprelation WHERE group_relation_buddy = ? )", new String[]{str});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static int m6102a(ContentResolver contentResolver) {
        Cursor cursorQuery = contentResolver.query(C1449q.f5381a, null, "inbox_unread_count > 0", null, null);
        int i = 0;
        while (cursorQuery.moveToNext()) {
            i += cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_unread_count"));
        }
        cursorQuery.close();
        return i;
    }

    /* renamed from: h */
    public static int m6144h(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C1449q.f5381a, null, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery == null) {
            return 0;
        }
        if (cursorQuery.getCount() == 0) {
            cursorQuery.close();
            return 0;
        }
        cursorQuery.moveToFirst();
        int i = cursorQuery.getInt(cursorQuery.getColumnIndex("inbox_unread_count"));
        cursorQuery.close();
        return i;
    }

    /* renamed from: a */
    public static Uri m6118a(ContentResolver contentResolver, String str, int i, EnumC1450r enumC1450r) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_no", str);
        contentValues.put("buddy_no", Integer.valueOf(i));
        contentValues.put("chat_type", Integer.valueOf(enumC1450r.m6342a()));
        return contentResolver.insert(C1447o.f5379a, contentValues);
    }

    /* renamed from: i */
    public static boolean m6145i(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C1447o.f5379a, null, "inbox_no=?", new String[]{str}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() != 0) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return true;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028 A[DONT_GENERATE, PHI: r2
  0x0028: PHI (r2v2 java.lang.String) = (r2v1 java.lang.String), (r2v0 java.lang.String) binds: [B:7:0x0026, B:14:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m6146j(android.content.ContentResolver r6, java.lang.String r7) {
        /*
            r2 = 0
            android.net.Uri r1 = com.sec.chaton.p027e.C1447o.f5379a
            java.lang.String r3 = "buddy_no=?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]
            r0 = 0
            r4[r0] = r7
            r0 = r6
            r5 = r2
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L33
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L2c
            if (r0 <= 0) goto L33
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r0 = "inbox_no"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r2 = r1.getString(r0)     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L2b
        L28:
            r1.close()
        L2b:
            return r2
        L2c:
            r0 = move-exception
            if (r1 == 0) goto L32
            r1.close()
        L32:
            throw r0
        L33:
            if (r1 == 0) goto L2b
            goto L28
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p027e.p028a.C1370n.m6146j(android.content.ContentResolver, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static ContentProviderOperation m6112a(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_session_id", str2);
        contentValues.put("inbox_old_session_id", str);
        return ContentProviderOperation.newInsert(C1448p.f5380a).withValues(contentValues).build();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002b A[PHI: r0 r8
  0x002b: PHI (r0v7 android.database.Cursor) = (r0v6 android.database.Cursor), (r0v11 android.database.Cursor) binds: [B:17:0x0038, B:8:0x0029] A[DONT_GENERATE, DONT_INLINE]
  0x002b: PHI (r8v3 java.lang.String) = (r8v0 java.lang.String), (r8v6 java.lang.String) binds: [B:17:0x0038, B:8:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m6147k(android.content.ContentResolver r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            r6 = 0
            r0 = 1
            r1 = 0
            java.lang.String[] r2 = new java.lang.String[r0]
            java.lang.String r0 = "inbox_session_id"
            r2[r1] = r0
            android.net.Uri r1 = com.sec.chaton.p027e.C1448p.f5380a     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L36
            java.lang.String r3 = "inbox_old_session_id = ?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L36
            r0 = 0
            r4[r0] = r8     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L36
            r5 = 0
            r0 = r7
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L36
            if (r0 == 0) goto L29
            int r1 = r0.getCount()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
            if (r1 <= 0) goto L29
            r0.moveToFirst()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
            r1 = 0
            java.lang.String r8 = r0.getString(r1)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
        L29:
            if (r0 == 0) goto L2e
        L2b:
            r0.close()
        L2e:
            return r8
        L2f:
            r0 = move-exception
        L30:
            if (r6 == 0) goto L35
            r6.close()
        L35:
            throw r0
        L36:
            r0 = move-exception
            r0 = r6
        L38:
            if (r0 == 0) goto L2e
            goto L2b
        L3b:
            r1 = move-exception
            r6 = r0
            r0 = r1
            goto L30
        L3f:
            r1 = move-exception
            goto L38
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p027e.p028a.C1370n.m6147k(android.content.ContentResolver, java.lang.String):java.lang.String");
    }

    /* renamed from: l */
    public static Cursor m6148l(ContentResolver contentResolver, String str) {
        Cursor cursorRawQuery = C1404av.m6253a(GlobalApplication.m11493l()).getReadableDatabase().rawQuery("SELECT inbox_server_ip, COUNT ('inbox_server_ip') AS 'count' FROM inbox WHERE inbox_no IN (" + str + ") AND inbox_server_ip NOT NULL group by inbox_server_ip order by count DESC", null);
        if (cursorRawQuery == null || cursorRawQuery.getCount() <= 0) {
            return null;
        }
        cursorRawQuery.moveToFirst();
        String string = cursorRawQuery.getString(0);
        cursorRawQuery.close();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return contentResolver.query(C1449q.f5381a, new String[]{"inbox_no", "inbox_session_id", "inbox_chat_type", "inbox_server_ip", "inbox_server_port"}, "inbox_no IN (" + str + ") AND inbox_server_ip = '" + string + "'", null, null);
    }

    /* renamed from: a */
    public static String m6123a(EnumC1450r enumC1450r, String[] strArr) {
        String str;
        boolean z;
        HashSet hashSet = new HashSet(strArr.length);
        for (String str2 : strArr) {
            hashSet.add(str2);
        }
        Cursor cursorQuery = GlobalApplication.m6447a().getContentResolver().query(C1449q.f5381a, null, "inbox_chat_type=? AND inbox_participants=?", new String[]{String.valueOf(enumC1450r.m6342a()), String.valueOf(hashSet.size())}, "inbox_last_time DESC");
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            str = null;
        } else {
            Cursor cursorQuery2 = null;
            str = null;
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_no"));
                cursorQuery2 = GlobalApplication.m6447a().getContentResolver().query(C1457y.f5415a, new String[]{"participants_buddy_no"}, "participants_inbox_no = ?", new String[]{string}, null);
                while (true) {
                    if (!cursorQuery2.moveToNext()) {
                        z = true;
                        break;
                    }
                    if (!hashSet.contains(cursorQuery2.getString(0))) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    str = string;
                }
            }
            if (cursorQuery2 != null) {
                cursorQuery2.close();
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return str;
    }

    /* renamed from: b */
    public static int m6133b(ContentResolver contentResolver, String str, boolean z) {
        String str2 = z ? "Y" : "N";
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_enable_translate", str2);
        return contentResolver.update(C1449q.f5381a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: c */
    public static int m6138c(ContentResolver contentResolver, String str, boolean z) {
        String str2 = z ? "Y" : "N";
        ContentValues contentValues = new ContentValues();
        contentValues.put("translate_outgoing_message", str2);
        return contentResolver.update(C1449q.f5381a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: a */
    public static void m6127a(ContentResolver contentResolver, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_translate_my_language", str2);
        contentValues.put("inbox_translate_buddy_language", str3);
        contentResolver.update(C1449q.f5381a, contentValues, "inbox_no=?", new String[]{str});
    }

    /* renamed from: m */
    public static boolean m6149m(ContentResolver contentResolver, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorQuery = contentResolver.query(C1449q.f5381a, null, "inbox_no=?", new String[]{str}, null);
        String string = "N";
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            cursorQuery.moveToFirst();
            string = cursorQuery.getString(cursorQuery.getColumnIndex("inbox_enable_translate"));
            if (string == null) {
                string = "N";
            }
        } else {
            C3250y.m11450b("isEnableTranslate() - can't find inbox", "[InboxDatabaseHelper]");
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return string.equals("Y");
    }

    /* renamed from: n */
    public static String m6150n(ContentResolver contentResolver, String str) {
        String strM5136d;
        C0952c c0952cM5143c = C0952c.m5143c();
        String str2 = c0952cM5143c.m5156d().f3910m;
        if (!TextUtils.isEmpty(str)) {
            Cursor cursorQuery = contentResolver.query(C1449q.f5381a, new String[]{"inbox_translate_my_language"}, "inbox_no=?", new String[]{str}, null);
            if (cursorQuery != null) {
                strM5136d = cursorQuery.moveToFirst() ? c0952cM5143c.m5156d().m5136d(cursorQuery.getString(0)) : str2;
                cursorQuery.close();
            } else {
                strM5136d = str2;
            }
            return strM5136d;
        }
        return str2;
    }

    /* renamed from: o */
    public static String m6151o(ContentResolver contentResolver, String str) {
        String strM5137e;
        C0952c c0952cM5143c = C0952c.m5143c();
        String str2 = c0952cM5143c.m5156d().f3910m;
        if (!TextUtils.isEmpty(str)) {
            Cursor cursorQuery = contentResolver.query(C1449q.f5381a, new String[]{"inbox_translate_buddy_language"}, "inbox_no=?", new String[]{str}, null);
            if (cursorQuery != null) {
                strM5137e = cursorQuery.moveToFirst() ? c0952cM5143c.m5156d().m5137e(cursorQuery.getString(0)) : str2;
                cursorQuery.close();
            } else {
                strM5137e = str2;
            }
            return strM5137e;
        }
        return str2;
    }

    /* renamed from: a */
    public static void m6124a() {
        C3250y.m11450b("updateInboxAfterSamsungAccountMapping() change oldID[" + C3159aa.m10962a().m10979a("old_chaton_id", "") + "] to newID[" + C3159aa.m10962a().m10979a("chaton_id", "") + "]", "[InboxDatabaseHelper]");
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_last_msg_sender", C3159aa.m10962a().m10979a("chaton_id", ""));
        GlobalApplication.m11493l().getContentResolver().update(C1449q.f5381a, contentValues, "inbox_last_msg_sender=?", new String[]{C3159aa.m10962a().m10979a("old_chaton_id", "")});
    }
}
