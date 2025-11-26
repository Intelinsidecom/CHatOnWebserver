package com.sec.chaton.p027e.p028a;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C1740a;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.msgsend.EnumC1741aa;
import com.sec.chaton.multimedia.doc.EnumC1794a;
import com.sec.chaton.multimedia.doc.FileExplorerActivity;
import com.sec.chaton.p016a.C0333cc;
import com.sec.chaton.p016a.EnumC0354cx;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.EnumC1391ai;
import com.sec.chaton.p027e.EnumC1444l;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p035io.entry.PushEntry;
import com.sec.chaton.p035io.entry.inner.Message;
import com.sec.chaton.p035io.entry.inner.Msg;
import com.sec.chaton.provider.C2036a;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3170al;
import com.sec.chaton.util.C3193bh;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3224cl;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.Query;

/* compiled from: MessageDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.q */
/* loaded from: classes.dex */
public class C1373q {
    /* renamed from: a */
    public static boolean m6185a(ContentResolver contentResolver, String str, String str2, String str3) {
        Cursor cursorQuery = contentResolver.query(C1454v.f5393a, null, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{str2, str3, str}, null);
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

    /* renamed from: b */
    public static boolean m6192b(ContentResolver contentResolver, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return true;
        }
        Cursor cursorQuery = contentResolver.query(C1454v.f5393a, null, "message_sever_id=? AND message_session_id=? AND message_sender=?", new String[]{str2, str3, str}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() != 0) {
                    cursorQuery.moveToFirst();
                    if ("Y".equals(cursorQuery.getString(cursorQuery.getColumnIndex("message_need_update")))) {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return true;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return false;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m6184a(ContentResolver contentResolver, String str, String str2) {
        Cursor cursorQuery = contentResolver.query(C1454v.f5393a, null, "message_sever_id=? AND message_inbox_no=? AND message_content_type=?", new String[]{str, str2, String.valueOf(EnumC1455w.SYSTEM.m6364a())}, null);
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

    /* renamed from: a */
    public static boolean m6182a(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C1454v.f5393a, null, "_id=?", new String[]{str}, null);
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

    /* renamed from: a */
    public static EnumC1455w m6175a(String str, String str2) {
        EnumC1455w enumC1455w = EnumC1455w.UNDEFINED;
        if (Config.NOTIFICATION_INTENT_MSG.equals(str2)) {
            return EnumC1455w.TEXT;
        }
        if ("media".equals(str2)) {
            return m6173a(str);
        }
        if ("content".equals(str2)) {
            try {
                return m6176a(new JSONObject(str));
            } catch (JSONException e) {
                C3250y.m11443a(e, "MessageDatabaseHelper");
                return EnumC1455w.TEXT;
            }
        }
        return enumC1455w;
    }

    /* renamed from: a */
    public static EnumC0354cx m6170a(EnumC1455w enumC1455w) {
        EnumC0354cx enumC0354cx = EnumC0354cx.TEXT;
        switch (C1374r.f5143a[enumC1455w.ordinal()]) {
        }
        return EnumC0354cx.TEXT;
    }

    /* renamed from: a */
    public static EnumC1455w m6174a(String str, int i) {
        EnumC1455w enumC1455w = EnumC1455w.UNDEFINED;
        switch (i) {
            case 0:
                return EnumC1455w.TEXT;
            case 1:
                return m6173a(str);
            case 2:
            case 3:
            default:
                return EnumC1455w.UNDEFINED;
            case 4:
                try {
                    return m6176a(new JSONObject(str));
                } catch (JSONException e) {
                    C3250y.m11443a(e, "MessageDatabaseHelper");
                    return EnumC1455w.TEXT;
                }
        }
    }

    /* renamed from: a */
    public static EnumC1455w m6176a(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString(PrefFragmentChats.TYPE);
        if ("poll".equalsIgnoreCase(string)) {
            return EnumC1455w.POLL;
        }
        if ("link".equalsIgnoreCase(string)) {
            return EnumC1455w.APPLINK;
        }
        if ("specialbuddy".equalsIgnoreCase(string)) {
            return EnumC1455w.LIVECONTENTS;
        }
        if ("live_share".equalsIgnoreCase(string)) {
            return EnumC1455w.LIVESHARE;
        }
        if ("live_recommend".equalsIgnoreCase(string)) {
            return EnumC1455w.LIVERECOMMEND;
        }
        return EnumC1455w.UNDEFINED;
    }

    /* renamed from: a */
    public static EnumC1455w m6173a(String str) {
        EnumC1455w enumC1455w = EnumC1455w.UNDEFINED;
        String[] strArrSplit = str.split("\n");
        if (strArrSplit == null || strArrSplit.length < 4) {
            return EnumC1455w.UNDEFINED;
        }
        String str2 = strArrSplit[0];
        if (Query.MIXED.equals(str2)) {
            str2 = strArrSplit[1];
        }
        if (SlookAirButtonRecentMediaAdapter.IMAGE_TYPE.equals(str2)) {
            EnumC1455w enumC1455w2 = EnumC1455w.IMAGE;
            if (C2646u.m9661b(str)) {
                return EnumC1455w.ANICON;
            }
            return enumC1455w2;
        }
        if (SlookAirButtonRecentMediaAdapter.VIDEO_TYPE.equals(str2)) {
            return EnumC1455w.VIDEO;
        }
        if ("geo".equals(str2)) {
            return EnumC1455w.GEO;
        }
        if (SlookAirButtonRecentMediaAdapter.AUDIO_TYPE.equals(str2)) {
            return EnumC1455w.AUDIO;
        }
        if ("contact".equals(str2)) {
            return EnumC1455w.CONTACT;
        }
        if ("calendar".equals(str2)) {
            return EnumC1455w.CALENDAR;
        }
        if ("doc".equals(str2)) {
            if (FileExplorerActivity.m7386c(strArrSplit[3]) != EnumC1794a.UNKNOWN) {
                return EnumC1455w.DOCUMENT;
            }
        } else if ("file".equals(str2)) {
            if (FileExplorerActivity.m7386c(strArrSplit[3]) != EnumC1794a.UNKNOWN) {
                return EnumC1455w.FILE;
            }
        } else {
            if ("ams".equals(str2)) {
                return EnumC1455w.AMS;
            }
            if ("anicon".equals(str2)) {
                return EnumC1455w.ANICON;
            }
        }
        return enumC1455w;
    }

    /* renamed from: a */
    public static boolean m6183a(ContentResolver contentResolver, String str, EnumC1455w enumC1455w, PushEntry pushEntry, EnumC1450r enumC1450r) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C3193bh.m11148a()));
        contentValues.put("message_sever_id", pushEntry.msgID);
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_content", pushEntry.message);
        contentValues.put("message_time", pushEntry.sentTime);
        if (C3159aa.m10962a().m10979a("chaton_id", "").equals(pushEntry.senderID)) {
            contentValues.put("message_type", (Integer) 1);
        } else {
            contentValues.put("message_type", (Integer) 2);
        }
        if (C3159aa.m10962a().m10979a("chaton_id", "").equals(pushEntry.senderID)) {
            contentValues.put("message_read_status", pushEntry.receiverCount);
        }
        contentValues.put("message_sender", pushEntry.senderID);
        contentValues.put("message_session_id", pushEntry.sessionID);
        contentValues.put("message_content_type", Integer.valueOf(enumC1455w.m6364a()));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(pushEntry.sentTime));
        contentValues.put("message_need_update", "Y");
        contentValues.put("message_is_truncated", pushEntry.truncated.booleanValue() ? "Y" : "N");
        Uri uriInsert = contentResolver.insert(C1454v.m6352c(), contentValues);
        if (uriInsert != null) {
            return C2036a.m8118a(uriInsert) || C1454v.m6347a(uriInsert, 2) == null;
        }
        return false;
    }

    /* renamed from: a */
    public static EnumC1444l m6172a(ContentResolver contentResolver, String str, EnumC1455w enumC1455w, Msg msg, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C3193bh.m11148a()));
        contentValues.put("message_sever_id", msg.f5652id);
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_content", msg.value);
        contentValues.put("message_time", msg.time);
        contentValues.put("message_tid", msg.tid);
        if (msg.msgTranslated != null) {
            contentValues.put("message_content_translated", msg.msgTranslated);
        }
        if (msg.msgFromLang != null) {
            contentValues.put("message_from_lang", msg.msgFromLang);
        }
        if (msg.msgToLang != null) {
            contentValues.put("message_to_lang", msg.msgToLang);
        }
        if (C3159aa.m10962a().m10979a("chaton_id", "").equals(msg.sender)) {
            contentValues.put("message_type", (Integer) 1);
        } else {
            contentValues.put("message_type", (Integer) 2);
        }
        contentValues.put("message_sender", msg.sender);
        contentValues.put("message_session_id", msg.sessionid);
        contentValues.put("message_content_type", Integer.valueOf(enumC1455w.m6364a()));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(msg.time));
        contentValues.put("message_need_update", "N");
        contentValues.put("message_read_status", Integer.valueOf(msg.receiver.split(",").length));
        contentValues.put("message_is_truncated", "N");
        if (str2 != null) {
            contentValues.put("message_formatted", str2);
        }
        EnumC1444l enumC1444l = EnumC1444l.FAIL;
        Uri uriInsert = contentResolver.insert(C1454v.m6352c(), contentValues);
        if (uriInsert != null) {
            if (!C2036a.m8118a(uriInsert) && C1454v.m6347a(uriInsert, 2) != null) {
                return EnumC1444l.INSERT;
            }
            return EnumC1444l.UPDATE;
        }
        return enumC1444l;
    }

    /* renamed from: a */
    public static ContentProviderOperation m6164a(ContentResolver contentResolver, String str, EnumC1455w enumC1455w, Message message, String str2, String str3) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C1454v.m6352c());
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C3193bh.m11148a()));
        contentValues.put("message_sever_id", message.f5649id);
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_content", message.msg);
        contentValues.put("message_time", message.time);
        contentValues.put("message_tid", message.tid);
        if (C3159aa.m10962a().m10979a("chaton_id", "").equals(message.sender)) {
            contentValues.put("message_type", (Integer) 1);
        } else {
            contentValues.put("message_type", (Integer) 2);
        }
        contentValues.put("message_sender", message.sender);
        contentValues.put("message_session_id", str2);
        contentValues.put("message_content_type", Integer.valueOf(enumC1455w.m6364a()));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message.time));
        contentValues.put("message_need_update", "N");
        contentValues.put("message_read_status", (Integer) 0);
        contentValues.put("message_is_truncated", "N");
        if (str3 != null) {
            contentValues.put("message_formatted", str3);
        }
        builderNewInsert.withValues(contentValues);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static EnumC1444l m6171a(ContentResolver contentResolver, String str, EnumC1455w enumC1455w, C0333cc c0333cc, String str2, String str3, String str4, EnumC1450r enumC1450r, String str5, String str6, String str7) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C3193bh.m11148a()));
        contentValues.put("message_sever_id", Long.valueOf(c0333cc.m2047h()));
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_content", c0333cc.m2049j());
        contentValues.put("message_time", Long.valueOf(c0333cc.m2051l()));
        if (str7 != null) {
            contentValues.put("message_content_translated", str7);
        }
        if (str5 != null) {
            contentValues.put("message_from_lang", str5);
        }
        if (str6 != null) {
            contentValues.put("message_to_lang", str6);
        }
        if (C3159aa.m10962a().m10979a("chaton_id", "").equals(str3)) {
            contentValues.put("message_type", (Integer) 1);
        } else {
            contentValues.put("message_type", (Integer) 2);
        }
        contentValues.put("message_sender", str3);
        contentValues.put("message_session_id", str);
        contentValues.put("message_content_type", Integer.valueOf(enumC1455w.m6364a()));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(c0333cc.m2051l())));
        contentValues.put("message_need_update", "N");
        contentValues.put("message_read_status", Integer.valueOf(c0333cc.m2045f()));
        contentValues.put("message_is_truncated", "N");
        if (!TextUtils.isEmpty(str4)) {
            contentValues.put("message_formatted", str4);
        }
        EnumC1444l enumC1444l = EnumC1444l.FAIL;
        Uri uriInsert = contentResolver.insert(C1454v.m6352c(), contentValues);
        if (uriInsert != null) {
            if (!C2036a.m8118a(uriInsert) && C1454v.m6347a(uriInsert, 2) != null) {
                return EnumC1444l.INSERT;
            }
            return EnumC1444l.UPDATE;
        }
        return enumC1444l;
    }

    /* renamed from: a */
    public static Uri m6169a(ContentResolver contentResolver, String str, String str2, EnumC1455w enumC1455w, String str3, String str4, int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", str);
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_read_status", Integer.valueOf(i));
        contentValues.put("message_content_type", Integer.valueOf(enumC1455w.m6364a()));
        contentValues.put("message_content", str3);
        if (str4 != null) {
            contentValues.put("message_content_translated", str4);
        }
        contentValues.put("message_sender", C3159aa.m10962a().m10979a("chaton_id", ""));
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_type", Integer.valueOf(i2));
        contentValues.put("message_is_failed", (Integer) 1);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        return contentResolver.insert(C1454v.f5393a, contentValues);
    }

    /* renamed from: a */
    public static Uri m6168a(ContentResolver contentResolver, String str, String str2, EnumC1455w enumC1455w, String str3, int i, String str4, int i2, String str5) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", str);
        contentValues.put("message_sever_id", str);
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_read_status", Integer.valueOf(i));
        contentValues.put("message_content_type", Integer.valueOf(enumC1455w.m6364a()));
        contentValues.put("message_download_uri", str3);
        contentValues.put("message_sender", C3159aa.m10962a().m10979a("chaton_id", ""));
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_type", Integer.valueOf(i2));
        contentValues.put("message_is_failed", (Integer) 1);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        contentValues.put("message_stored_ext", Integer.valueOf(C3223ck.m11327a() ? 1 : 0));
        contentValues.put("message_content", str4);
        if (!TextUtils.isEmpty(str5)) {
            contentValues.put("message_content_translated", str5);
        }
        return contentResolver.insert(C1454v.f5393a, contentValues);
    }

    /* renamed from: c */
    public static Uri m6194c(ContentResolver contentResolver, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C3193bh.m11148a()));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC1455w.SYSTEM.m6364a()));
        contentValues.put("message_content", str2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        contentValues.put("message_sender", str3);
        return contentResolver.insert(C1454v.f5393a, contentValues);
    }

    /* renamed from: a */
    public static void m6181a(C1377u c1377u, int i, String str, String str2, String str3) {
        long jCurrentTimeMillis;
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C3193bh.m11148a()));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC1455w.SYSTEM.m6364a()));
        contentValues.put("message_content", str2);
        long jM6110a = C1370n.m6110a(GlobalApplication.m11493l().getContentResolver(), str);
        if (jM6110a == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
        } else {
            jCurrentTimeMillis = jM6110a + 1;
        }
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        contentValues.put("message_sender", str3);
        c1377u.startInsert(i, null, C1454v.f5393a, contentValues);
    }

    /* renamed from: a */
    public static long m6163a(C1377u c1377u, int i, String str, String str2, long j) {
        ContentValues contentValues = new ContentValues();
        long jM11148a = C3193bh.m11148a();
        contentValues.put("_id", Long.valueOf(jM11148a));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC1455w.SYSTEM.m6364a()));
        contentValues.put("message_content", str2);
        contentValues.put("message_time", Long.valueOf(j));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j)));
        contentValues.put("message_sender", str);
        c1377u.startInsert(i, null, C1454v.f5393a, contentValues);
        return jM11148a;
    }

    /* renamed from: a */
    public static Uri m6167a(ContentResolver contentResolver, String str, String str2, long j, String str3, String str4) {
        if (m6184a(contentResolver, str3, str)) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C3193bh.m11148a()));
        contentValues.put("message_sever_id", str3);
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC1455w.SYSTEM.m6364a()));
        contentValues.put("message_content", str2);
        contentValues.put("message_time", Long.valueOf(j));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j)));
        contentValues.put("message_sender", str4);
        return contentResolver.insert(C1454v.f5393a, contentValues);
    }

    /* renamed from: a */
    public static Uri m6166a(ContentResolver contentResolver, String str, String str2, long j, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C3193bh.m11148a()));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC1455w.SYSTEM.m6364a()));
        contentValues.put("message_content", str2);
        contentValues.put("message_time", Long.valueOf(j));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j)));
        contentValues.put("message_sender", str3);
        return contentResolver.insert(C1454v.f5393a, contentValues);
    }

    /* renamed from: a */
    public static int m6161a(ContentResolver contentResolver, String str, String str2, Long l, String str3, EnumC1450r enumC1450r, boolean z, boolean z2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_download_uri", str3);
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_sever_id", l);
        contentValues.put("message_sender", str);
        contentValues.put("message_stored_ext", Integer.valueOf(z ? 1 : 0));
        if (z2) {
            if (C3159aa.m10962a().m10979a("chaton_id", "").equals(str)) {
                contentValues.put("message_type", (Integer) 1);
            } else {
                contentValues.put("message_type", (Integer) 2);
            }
        } else {
            contentValues.put("message_type", (Integer) 4);
        }
        if (m6185a(contentResolver, str, String.valueOf(l), str2)) {
            return contentResolver.update(C1454v.m6356e(), contentValues, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{String.valueOf(l), str2, str});
        }
        C3250y.m11450b("updateMediaURI(Insert)XXX", CommonApplication.m11493l().getClass().getName());
        return -1;
    }

    /* renamed from: a */
    public static int m6160a(ContentResolver contentResolver, String str, String str2, Long l, EnumC1450r enumC1450r, boolean z) {
        if (!m6185a(contentResolver, str, String.valueOf(l), str2)) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("message_type", (Integer) 3);
        } else {
            contentValues.put("message_type", (Integer) 4);
        }
        return contentResolver.update(C1454v.m6356e(), contentValues, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{String.valueOf(l), str2, str});
    }

    /* renamed from: a */
    public static int m6162a(ContentResolver contentResolver, String str, String str2, Long l, String str3, String str4, EnumC1450r enumC1450r, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_content", str3);
        if (!TextUtils.isEmpty(str4)) {
            contentValues.put("message_content_translated", str4);
        }
        contentValues.put("message_stored_ext", Integer.valueOf(z ? 1 : 0));
        return contentResolver.update(C1454v.m6356e(), contentValues, "_id=?", new String[]{String.valueOf(l)});
    }

    /* renamed from: a */
    public static void m6178a(ContentResolver contentResolver, String str, Long l, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_formatted", str2);
        contentValues.put("message_inbox_no", str);
        if (m6182a(contentResolver, String.valueOf(l))) {
            contentResolver.update(C1454v.f5393a, contentValues, "_id=?", new String[]{String.valueOf(l)});
        } else {
            contentValues.put("_id", Long.valueOf(C3193bh.m11148a()));
            contentResolver.insert(C1454v.f5393a, contentValues);
        }
    }

    /* renamed from: a */
    public static void m6179a(ContentResolver contentResolver, String str, Long l, String str2, String str3) {
        if (m6185a(contentResolver, str3, String.valueOf(l), str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_formatted", str2);
            contentResolver.update(C1454v.m6356e(), contentValues, "message_sever_id= ?", new String[]{String.valueOf(l)});
        }
    }

    /* renamed from: a */
    public static int m6158a(ContentResolver contentResolver, Long l, String str, long j, Long l2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_time", l);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(l));
        contentValues.put("message_session_id", str);
        contentValues.put("message_sever_id", Long.valueOf(j));
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_is_failed", (Integer) 0);
        return contentResolver.update(C1454v.f5393a, contentValues, "_id=?", new String[]{String.valueOf(l2)});
    }

    /* renamed from: a */
    public static int m6156a(ContentResolver contentResolver, Long l, Long l2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) (-1));
        contentValues.put("message_is_failed", (Integer) 2);
        if (l2.longValue() != -1) {
            contentValues.put("_id", l2);
        }
        return contentResolver.update(C1454v.f5393a, contentValues, "_id= ?", new String[]{Long.toString(l.longValue())});
    }

    /* renamed from: a */
    public static int m6155a(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) 6);
        return contentResolver.update(C1454v.f5393a, contentValues, "_id= ?", new String[]{Long.toString(l.longValue())});
    }

    /* renamed from: b */
    public static int m6187b(ContentResolver contentResolver, Long l) {
        return m6156a(contentResolver, l, (Long) (-1L));
    }

    /* renamed from: c */
    public static int m6193c(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) 5);
        int iUpdate = contentResolver.update(C1454v.m6356e(), contentValues, "message_sever_id= ?", new String[]{Long.toString(l.longValue())});
        if (C3250y.f11734b) {
            C3250y.m11450b("updatedRow: " + iUpdate + "(_id:" + l + ")", "MessageDatabaseHelper");
        }
        return iUpdate;
    }

    /* renamed from: d */
    public static int m6195d(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_is_failed", (Integer) 1);
        contentValues.put("message_is_file_upload", (Integer) 1);
        return contentResolver.update(C1454v.m6356e(), contentValues, "_id=?", new String[]{Long.toString(l.longValue())});
    }

    /* renamed from: e */
    public static int m6196e(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) 0);
        contentValues.put("message_is_failed", (Integer) 1);
        return contentResolver.update(C1454v.m6356e(), contentValues, "_id=?", new String[]{String.valueOf(l)});
    }

    /* renamed from: a */
    public static int m6154a(ContentResolver contentResolver, C1740a c1740a, EnumC1741aa enumC1741aa) {
        ContentProviderResult[] contentProviderResultArrM11043a;
        ArrayList arrayList = new ArrayList();
        String[] strArrM7155c = c1740a.m7155c();
        ContentValues contentValues = new ContentValues();
        switch (C1374r.f5144b[enumC1741aa.ordinal()]) {
            case 1:
                contentValues.put("message_type", (Integer) (-1));
                contentValues.put("message_is_failed", (Integer) 2);
                break;
            case 2:
                contentValues.put("message_type", (Integer) 1);
                contentValues.put("message_is_failed", (Integer) 0);
                break;
            case 3:
                contentValues.put("message_type", (Integer) 6);
                break;
            case 4:
                contentValues.put("message_type", (Integer) 0);
                contentValues.put("message_is_failed", (Integer) 1);
                break;
            default:
                return -1;
        }
        for (String str : strArrM7155c) {
            arrayList.add(m6165a("_id=?", new String[]{str}, contentValues));
        }
        try {
            contentProviderResultArrM11043a = C3170al.m11043a(GlobalApplication.m11493l(), "com.sec.chaton.provider", (ArrayList<ContentProviderOperation>) arrayList);
        } catch (Exception e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, C1373q.class.getSimpleName());
            }
            contentProviderResultArrM11043a = null;
        }
        if (contentProviderResultArrM11043a == null) {
            return 0;
        }
        return contentProviderResultArrM11043a.length;
    }

    /* renamed from: a */
    public static int m6157a(ContentResolver contentResolver, Long l, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) 6);
        contentValues.put("message_formatted", str);
        return contentResolver.update(C1454v.f5393a, contentValues, "_id=?", new String[]{Long.toString(l.longValue())});
    }

    /* renamed from: b */
    public static int m6188b(ContentResolver contentResolver, Long l, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) (-1));
        contentValues.put("message_is_failed", (Integer) 2);
        contentValues.put("message_formatted", str);
        return contentResolver.update(C1454v.f5393a, contentValues, "_id=?", new String[]{Long.toString(l.longValue())});
    }

    /* renamed from: a */
    public static int m6153a(ContentResolver contentResolver) {
        int iUpdate = 0;
        try {
            ContentValues contentValues = new ContentValues();
            if (C1757q.m7251b()) {
                contentValues.put("message_type", (Integer) 6);
                contentValues.put("message_is_failed", (Integer) 1);
            } else {
                contentValues.put("message_type", (Integer) (-1));
                contentValues.put("message_is_failed", (Integer) 2);
            }
            iUpdate = contentResolver.update(C1454v.f5393a, contentValues, "message_type=0", null);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        Log.i("ChatON", "[MessageDatabaseHelper]updateAllSendingMsgToFail() - count:" + iUpdate);
        return iUpdate;
    }

    /* renamed from: b */
    public static int m6186b(ContentResolver contentResolver) {
        int iUpdate = 0;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_type", (Integer) (-1));
            contentValues.put("message_is_failed", (Integer) 2);
            iUpdate = contentResolver.update(C1454v.f5393a, contentValues, "message_type=6", null);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        Log.i("ChatON", "[MessageDatabaseHelper]updateAllPendingMsgToFail() - count:" + iUpdate);
        return iUpdate;
    }

    /* renamed from: b */
    public static C1375s m6189b(ContentResolver contentResolver, String str, String str2) {
        Cursor cursorQuery = contentResolver.query(C1454v.f5393a, null, "message_sever_id=? AND message_sender=?", new String[]{str, str2}, null);
        if (cursorQuery == null || cursorQuery.getCount() == 0) {
            return null;
        }
        cursorQuery.moveToFirst();
        C1375s c1375s = new C1375s();
        c1375s.f5145a = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
        c1375s.f5146b = cursorQuery.getLong(cursorQuery.getColumnIndex("message_sever_id"));
        c1375s.f5147c = cursorQuery.getString(cursorQuery.getColumnIndex("message_inbox_no"));
        c1375s.f5148d = cursorQuery.getString(cursorQuery.getColumnIndex("message_session_id"));
        c1375s.f5149e = cursorQuery.getInt(cursorQuery.getColumnIndex("message_read_status"));
        c1375s.f5150f = cursorQuery.getInt(cursorQuery.getColumnIndex("message_content_type"));
        c1375s.f5151g = cursorQuery.getLong(cursorQuery.getColumnIndex("message_time"));
        c1375s.f5152h = cursorQuery.getString(cursorQuery.getColumnIndex("message_content"));
        c1375s.f5153i = cursorQuery.getInt(cursorQuery.getColumnIndex("message_type"));
        c1375s.f5154j = cursorQuery.getString(cursorQuery.getColumnIndex("message_sender"));
        c1375s.f5155k = cursorQuery.getString(cursorQuery.getColumnIndex("message_download_uri"));
        c1375s.f5156l = cursorQuery.getString(cursorQuery.getColumnIndex("message_formatted"));
        c1375s.f5157m = cursorQuery.getString(cursorQuery.getColumnIndex("message_tid"));
        c1375s.f5158n = cursorQuery.getInt(cursorQuery.getColumnIndex("message_stored_ext"));
        c1375s.f5159o = cursorQuery.getString(cursorQuery.getColumnIndex("message_need_update"));
        c1375s.f5160p = cursorQuery.getInt(cursorQuery.getColumnIndex("message_is_failed"));
        c1375s.f5161q = cursorQuery.getInt(cursorQuery.getColumnIndex("message_is_file_upload"));
        cursorQuery.close();
        return c1375s;
    }

    /* renamed from: a */
    public static void m6180a(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        EnumC1391ai enumC1391aiM6247a;
        if (C3250y.f11734b) {
            C3250y.m11450b("migrationAnnounceChangeMessage", "MessageDatabaseHelper");
        }
        sQLiteDatabase.beginTransaction();
        try {
            cursorQuery = sQLiteDatabase.query("message", new String[]{"message_content", "message_inbox_no", "_id"}, "message_content_type = ?", new String[]{Integer.toString(EnumC1455w.SYSTEM.m6364a())}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        EnumC1391ai enumC1391ai = EnumC1391ai.UNKNOWN;
                        while (cursorQuery.moveToNext()) {
                            String string = cursorQuery.getString(0);
                            String string2 = cursorQuery.getString(1);
                            String string3 = cursorQuery.getString(2);
                            if (C3250y.f11734b) {
                                C3250y.m11450b(string, "migrationAnnounceChangeMessage");
                            }
                            String[] strArrSplit = string.split(Config.KEYVALUE_SPLIT);
                            if (strArrSplit.length > 0) {
                                StringBuilder sb = new StringBuilder();
                                for (String str : strArrSplit) {
                                    ArrayList<String> arrayListM11335a = C3224cl.m11335a(str, ',');
                                    if (arrayListM11335a.size() > 0 && (enumC1391aiM6247a = EnumC1391ai.m6247a(arrayListM11335a.get(0))) != EnumC1391ai.UNKNOWN) {
                                        sb.append(String.format("%d,%s,%s", Integer.valueOf(enumC1391aiM6247a.m6248a()), arrayListM11335a.get(1), arrayListM11335a.get(2))).append(Config.KEYVALUE_SPLIT);
                                    }
                                }
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("message_content", sb.toString());
                                sQLiteDatabase.update("message", contentValues, "_id=? AND message_inbox_no=? AND message_content_type=?", new String[]{string3, string2, Integer.toString(EnumC1455w.SYSTEM.m6364a())});
                                if (C3250y.f11734b) {
                                    C3250y.m11450b(sb.toString(), "migrationInBoxBuddyRelation");
                                }
                            }
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

    /* renamed from: b */
    public static void m6191b(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        if (C3250y.f11734b) {
            C3250y.m11450b("migrationIsFileUploadField", "MessageDatabaseHelper");
        }
        sQLiteDatabase.beginTransaction();
        try {
            cursorQuery = sQLiteDatabase.query("message", new String[]{"message_is_failed", "message_inbox_no", "_id"}, "message_is_failed = ?", new String[]{Integer.toString(3)}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        while (cursorQuery.moveToNext()) {
                            int i = cursorQuery.getInt(0);
                            String string = cursorQuery.getString(1);
                            String string2 = cursorQuery.getString(2);
                            if (C3250y.f11734b) {
                                C3250y.m11450b(String.format("The Type of Failed : %d", Integer.valueOf(i)), "migrationIsFileUploadField");
                            }
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("message_is_failed", (Integer) 2);
                            contentValues.put("message_is_file_upload", (Integer) 1);
                            sQLiteDatabase.update("message", contentValues, "_id=? AND message_inbox_no=?", new String[]{string2, string});
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
    public static ContentProviderOperation m6165a(String str, String[] strArr, ContentValues contentValues) {
        return ContentProviderOperation.newUpdate(C1454v.f5393a).withValues(contentValues).withSelection(str, strArr).build();
    }

    /* renamed from: b */
    public static void m6190b(ContentResolver contentResolver, String str) {
        StringBuilder sb = new StringBuilder();
        String strM10979a = C3159aa.m10962a().m10979a("chaton_id", "");
        sb.append("message_inbox_no").append(" = ? ");
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_read_status", (Integer) 0);
        contentValues.put("message_sender", strM10979a);
        contentResolver.update(C1454v.f5393a, contentValues, sb.toString(), new String[]{str});
    }

    /* renamed from: a */
    public static String m6177a(ContentResolver contentResolver, Long l, boolean z) {
        String str;
        String string = null;
        if (z) {
            str = "message_sever_id=?";
        } else {
            str = "_id=?";
        }
        Cursor cursorQuery = contentResolver.query(C1454v.f5393a, new String[]{"message_content_translated"}, str, new String[]{String.valueOf(l)}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    string = cursorQuery.getString(0);
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return string;
    }

    /* renamed from: a */
    public static int m6159a(ContentResolver contentResolver, String str, Long l, String str2, String str3, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (str != null) {
            contentValues.put("message_content_translated", str);
        }
        if (str2 != null) {
            contentValues.put("message_from_lang", str2);
        }
        if (str3 != null) {
            contentValues.put("message_to_lang", str3);
        }
        return z ? contentResolver.update(C1454v.m6356e(), contentValues, "message_sever_id=?", new String[]{String.valueOf(l)}) : contentResolver.update(C1454v.m6356e(), contentValues, "_id=?", new String[]{String.valueOf(l)});
    }

    /* renamed from: f */
    public static int m6197f(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_is_spoken", "Y");
        return contentResolver.update(C1454v.m6356e(), contentValues, "_id=?", new String[]{String.valueOf(l)});
    }
}
