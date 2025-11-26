package com.sec.chaton.p025d.p026a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015b.C0329co;
import com.sec.chaton.p025d.C0662o;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0664q;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.EnumC0672y;
import com.sec.chaton.p033io.entry.PushEntry;
import com.sec.chaton.p033io.entry.inner.Msg;
import com.sec.chaton.provider.C0849a;
import com.sec.chaton.util.C1291an;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1325bu;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/* compiled from: MessageDatabaseHelper.java */
/* renamed from: com.sec.chaton.d.a.o */
/* loaded from: classes.dex */
public class C0635o {
    /* renamed from: a */
    public static boolean m2941a(ContentResolver contentResolver, String str, String str2, String str3) {
        Cursor cursorQuery = contentResolver.query(C0662o.f2289a, null, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{str2, str3, str}, null);
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
    public static boolean m2946b(ContentResolver contentResolver, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return true;
        }
        Cursor cursorQuery = contentResolver.query(C0662o.f2289a, null, "message_sever_id=? AND message_session_id=? AND message_sender=?", new String[]{str2, str3, str}, null);
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
    public static boolean m2940a(ContentResolver contentResolver, String str, String str2) {
        Cursor cursorQuery = contentResolver.query(C0662o.f2289a, null, "message_sever_id=? AND message_inbox_no=? AND message_content_type=?", new String[]{str, str2, String.valueOf(EnumC0651d.SYSTEM.m2978a())}, null);
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
    public static boolean m2938a(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C0662o.f2289a, null, "message_sender=? AND message_inbox_no=? AND message_content_type=?", new String[]{str, str, String.valueOf(EnumC0651d.SYSTEM.m2978a())}, null);
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
    public static boolean m2944b(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C0662o.f2289a, null, "_id=?", new String[]{str}, null);
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
    public static EnumC0651d m2931a(String str) {
        return m2932a(str, (EnumC0651d) null);
    }

    /* renamed from: a */
    public static EnumC0651d m2932a(String str, EnumC0651d enumC0651d) {
        if (enumC0651d != EnumC0651d.TEXT) {
            String[] strArrSplit = str.split("\n");
            if (strArrSplit[0].equals("image")) {
                return EnumC0651d.IMAGE;
            }
            if (strArrSplit[0].equals("video")) {
                return EnumC0651d.VIDEO;
            }
            if (strArrSplit[0].equals("geo")) {
                return EnumC0651d.GEO;
            }
            if (strArrSplit[0].equals("audio")) {
                return EnumC0651d.AUDIO;
            }
            if (strArrSplit[0].equals("contact")) {
                return EnumC0651d.CONTACT;
            }
            if (strArrSplit[0].equals("calendar")) {
                return EnumC0651d.CALENDAR;
            }
            return EnumC0651d.UNDEFINED;
        }
        return EnumC0651d.TEXT;
    }

    /* renamed from: a */
    public static boolean m2939a(ContentResolver contentResolver, String str, EnumC0651d enumC0651d, PushEntry pushEntry, EnumC0665r enumC0665r) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C1325bu.m4591a()));
        contentValues.put("message_sever_id", pushEntry.msgID);
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_content", pushEntry.message);
        contentValues.put("message_time", pushEntry.sentTime);
        contentValues.put("message_type", (Integer) 2);
        contentValues.put("message_sender", pushEntry.senderID);
        contentValues.put("message_session_id", pushEntry.sessionID);
        contentValues.put("message_content_type", Integer.valueOf(enumC0651d.m2978a()));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(pushEntry.sentTime));
        contentValues.put("message_need_update", "Y");
        contentValues.put("truncated", pushEntry.truncated);
        Uri uriInsert = contentResolver.insert(C0662o.m2999b(), contentValues);
        if (uriInsert != null) {
            return C0849a.m3432a(uriInsert) || C0662o.m2998a(uriInsert, 2) == null;
        }
        return false;
    }

    /* renamed from: a */
    public static EnumC0672y m2934a(ContentResolver contentResolver, String str, EnumC0651d enumC0651d, Msg msg, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C1325bu.m4591a()));
        contentValues.put("message_sever_id", msg.f2448id);
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_content", msg.value);
        contentValues.put("message_time", msg.time);
        contentValues.put("message_tid", msg.tid);
        contentValues.put("message_type", (Integer) 2);
        contentValues.put("message_sender", msg.sender);
        contentValues.put("message_session_id", msg.sessionid);
        contentValues.put("message_content_type", Integer.valueOf(enumC0651d.m2978a()));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(msg.time));
        contentValues.put("message_need_update", "N");
        contentValues.put("message_read_status", Integer.valueOf(msg.receiver.split(",").length));
        if (str2 != null) {
            contentValues.put("message_formatted", str2);
        }
        EnumC0672y enumC0672y = EnumC0672y.FAIL;
        Uri uriInsert = contentResolver.insert(C0662o.m2999b(), contentValues);
        if (uriInsert != null) {
            if (!C0849a.m3432a(uriInsert) && C0662o.m2998a(uriInsert, 2) != null) {
                return EnumC0672y.INSERT;
            }
            return EnumC0672y.UPDATE;
        }
        return enumC0672y;
    }

    /* renamed from: a */
    public static EnumC0672y m2933a(ContentResolver contentResolver, String str, EnumC0651d enumC0651d, C0329co c0329co, String str2, Long l, String str3, EnumC0665r enumC0665r) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C1325bu.m4591a()));
        contentValues.put("message_sever_id", Long.valueOf(c0329co.m1822h()));
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_content", c0329co.m1824j());
        contentValues.put("message_time", Long.valueOf(c0329co.m1826l()));
        contentValues.put("message_type", (Integer) 2);
        contentValues.put("message_sender", c0329co.m1818d());
        contentValues.put("message_session_id", str);
        contentValues.put("message_content_type", Integer.valueOf(enumC0651d.m2978a()));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(c0329co.m1826l())));
        contentValues.put("message_need_update", "N");
        contentValues.put("message_read_status", Integer.valueOf(c0329co.m1820f()));
        if (str3 != null) {
            contentValues.put("message_formatted", str3);
        }
        EnumC0672y enumC0672y = EnumC0672y.FAIL;
        Uri uriInsert = contentResolver.insert(C0662o.m2999b(), contentValues);
        if (uriInsert != null) {
            if (!C0849a.m3432a(uriInsert) && C0662o.m2998a(uriInsert, 2) != null) {
                return EnumC0672y.INSERT;
            }
            return EnumC0672y.UPDATE;
        }
        return enumC0672y;
    }

    /* renamed from: a */
    public static Uri m2930a(ContentResolver contentResolver, String str, String str2, EnumC0651d enumC0651d, String str3, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", str);
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_read_status", Integer.valueOf(i));
        contentValues.put("message_content_type", Integer.valueOf(enumC0651d.m2978a()));
        contentValues.put("message_content", str3);
        contentValues.put("message_sender", C1323bs.m4575a().getString("msisdn", ""));
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_type", (Integer) 0);
        contentValues.put("message_is_failed", (Integer) 1);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        return contentResolver.insert(C0662o.f2289a, contentValues);
    }

    /* renamed from: b */
    public static Uri m2943b(ContentResolver contentResolver, String str, String str2, EnumC0651d enumC0651d, String str3, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", str);
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_read_status", Integer.valueOf(i));
        contentValues.put("message_content_type", Integer.valueOf(enumC0651d.m2978a()));
        contentValues.put("message_download_uri", str3);
        contentValues.put("message_sender", C1323bs.m4575a().getString("msisdn", ""));
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_type", (Integer) 0);
        contentValues.put("message_is_failed", (Integer) 1);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        contentValues.put("message_stored_ext", Integer.valueOf(C1327bw.m4595a() ? 1 : 0));
        return contentResolver.insert(C0662o.f2289a, contentValues);
    }

    /* renamed from: c */
    public static Uri m2948c(ContentResolver contentResolver, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C1325bu.m4591a()));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC0651d.SYSTEM.m2978a()));
        contentValues.put("message_content", str2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        contentValues.put("message_sender", str3);
        return contentResolver.insert(C0662o.f2289a, contentValues);
    }

    /* renamed from: a */
    public static void m2937a(C0630j c0630j, int i, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C1325bu.m4591a()));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC0651d.SYSTEM.m2978a()));
        contentValues.put("message_content", str2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        contentValues.put("message_sender", str3);
        c0630j.startInsert(i, null, C0662o.f2289a, contentValues);
    }

    /* renamed from: a */
    public static Uri m2929a(ContentResolver contentResolver, String str, String str2, long j, String str3, String str4) {
        if (m2940a(contentResolver, str3, str)) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C1325bu.m4591a()));
        contentValues.put("message_sever_id", str3);
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC0651d.SYSTEM.m2978a()));
        contentValues.put("message_content", str2);
        contentValues.put("message_time", Long.valueOf(j));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j)));
        contentValues.put("message_sender", str4);
        return contentResolver.insert(C0662o.f2289a, contentValues);
    }

    /* renamed from: a */
    public static Uri m2928a(ContentResolver contentResolver, String str, String str2, long j, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C1325bu.m4591a()));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC0651d.SYSTEM.m2978a()));
        contentValues.put("message_content", str2);
        contentValues.put("message_time", Long.valueOf(j));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j)));
        contentValues.put("message_sender", str3);
        return contentResolver.insert(C0662o.f2289a, contentValues);
    }

    /* renamed from: b */
    public static boolean m2945b(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C1325bu.m4591a()));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC0651d.SYSTEM.m2978a()));
        contentValues.put("message_content", str2);
        contentValues.put("message_time", (Long) Long.MIN_VALUE);
        contentValues.put("message_sender", str);
        if (m2938a(contentResolver, str)) {
            if (contentResolver.update(C0662o.f2289a, contentValues, "message_sender=? AND message_inbox_no=? AND message_content_type=?", new String[]{str, str, String.valueOf(EnumC0651d.SYSTEM.m2978a())}) <= 0) {
                return false;
            }
        } else {
            Uri uriInsert = contentResolver.insert(C0662o.f2289a, contentValues);
            if (uriInsert == null || C0849a.m3432a(uriInsert)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static int m2927a(ContentResolver contentResolver, String str, String str2, Long l, String str3, EnumC0665r enumC0665r, boolean z, boolean z2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_download_uri", str3);
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_sever_id", l);
        contentValues.put("message_sender", str);
        contentValues.put("message_stored_ext", Integer.valueOf(z ? 1 : 0));
        if (z2) {
            contentValues.put("message_type", (Integer) 2);
        } else {
            contentValues.put("message_type", (Integer) 4);
        }
        if (m2941a(contentResolver, str, String.valueOf(l), str2)) {
            return contentResolver.update(C0662o.m3005d(), contentValues, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{String.valueOf(l), str2, str});
        }
        C1341p.m4658b("updateMediaURI(Insert)XXX", GlobalApplication.m3100a().getClass().getName());
        return -1;
    }

    /* renamed from: a */
    public static int m2925a(ContentResolver contentResolver, String str, String str2, Long l, EnumC0665r enumC0665r, boolean z) {
        if (!m2941a(contentResolver, str, String.valueOf(l), str2)) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("message_type", (Integer) 3);
        } else {
            contentValues.put("message_type", (Integer) 4);
        }
        return contentResolver.update(C0662o.m3005d(), contentValues, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{String.valueOf(l), str2, str});
    }

    /* renamed from: a */
    public static int m2926a(ContentResolver contentResolver, String str, String str2, Long l, String str3, EnumC0665r enumC0665r, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_content", str3);
        contentValues.put("message_stored_ext", Integer.valueOf(z ? 1 : 0));
        return contentResolver.update(C0662o.m3005d(), contentValues, "_id=?", new String[]{String.valueOf(l)});
    }

    /* renamed from: a */
    public static void m2935a(ContentResolver contentResolver, String str, Long l, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_formatted", str2);
        contentValues.put("message_inbox_no", str);
        if (m2944b(contentResolver, String.valueOf(l))) {
            contentResolver.update(C0662o.f2289a, contentValues, "_id=?", new String[]{String.valueOf(l)});
        } else {
            contentValues.put("_id", Long.valueOf(C1325bu.m4591a()));
            contentResolver.insert(C0662o.f2289a, contentValues);
        }
    }

    /* renamed from: a */
    public static int m2923a(ContentResolver contentResolver, Long l, String str, long j, Long l2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_time", l);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(l));
        contentValues.put("message_session_id", str);
        contentValues.put("message_sever_id", Long.valueOf(j));
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_is_failed", (Integer) 0);
        contentValues.put("message_read_status", Integer.valueOf(i));
        return contentResolver.update(C0662o.f2289a, contentValues, "_id=?", new String[]{String.valueOf(l2)});
    }

    /* renamed from: a */
    public static int m2920a(ContentResolver contentResolver, Long l, Long l2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) (-1));
        contentValues.put("message_is_failed", (Integer) 2);
        contentValues.put("_id", l2);
        return contentResolver.update(C0662o.f2289a, contentValues, "_id= ?", new String[]{Long.toString(l.longValue())});
    }

    /* renamed from: a */
    public static int m2919a(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) (-1));
        contentValues.put("message_is_failed", (Integer) 2);
        return contentResolver.update(C0662o.m3005d(), contentValues, "_id= ?", new String[]{Long.toString(l.longValue())});
    }

    /* renamed from: b */
    public static int m2942b(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) 5);
        int iUpdate = contentResolver.update(C0662o.m3005d(), contentValues, "message_sever_id= ?", new String[]{Long.toString(l.longValue())});
        if (C1341p.f4578b) {
            C1341p.m4658b("updatedRow: " + iUpdate + "(_id:" + l + ")", "MessageDatabaseHelper");
        }
        return iUpdate;
    }

    /* renamed from: a */
    public static int m2924a(ContentResolver contentResolver, Long l, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (!z) {
            contentValues.put("message_type", (Integer) (-1));
        }
        contentValues.put("message_is_failed", (Integer) 3);
        return contentResolver.update(C0662o.m3005d(), contentValues, "_id=?", new String[]{Long.toString(l.longValue())});
    }

    /* renamed from: a */
    public static int m2921a(ContentResolver contentResolver, Long l, Long l2, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (!z) {
            contentValues.put("message_type", (Integer) (-1));
        }
        contentValues.put("message_is_failed", (Integer) 3);
        contentValues.put("_id", l2);
        return contentResolver.update(C0662o.m3005d(), contentValues, "_id=?", new String[]{Long.toString(l.longValue())});
    }

    /* renamed from: c */
    public static int m2947c(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) 0);
        contentValues.put("message_is_failed", (Integer) 1);
        return contentResolver.update(C0662o.m3005d(), contentValues, "_id=?", new String[]{String.valueOf(l)});
    }

    /* renamed from: a */
    public static int m2922a(ContentResolver contentResolver, Long l, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) (-1));
        contentValues.put("message_is_failed", (Integer) 2);
        contentValues.put("message_formatted", str);
        return contentResolver.update(C0662o.f2289a, contentValues, "_id=?", new String[]{Long.toString(l.longValue())});
    }

    /* renamed from: a */
    public static int m2918a(ContentResolver contentResolver) {
        int iUpdate = 0;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_type", (Integer) (-1));
            contentValues.put("message_is_failed", (Integer) 2);
            iUpdate = contentResolver.update(C0662o.f2289a, contentValues, "message_type=0", null);
        } catch (IllegalArgumentException e) {
            C1341p.m4653a(e, "MessageDatabaseHelper");
        }
        C1341p.m4660c("updateAllSendingMsgToFail() - count:" + iUpdate, "MessageDatabaseHelper");
        return iUpdate;
    }

    /* renamed from: c */
    public static C0624d m2949c(ContentResolver contentResolver, String str, String str2) {
        Cursor cursorQuery = contentResolver.query(C0662o.f2289a, null, "message_sever_id=? AND message_sender=?", new String[]{str, str2}, null);
        if (cursorQuery == null || cursorQuery.getCount() == 0) {
            return null;
        }
        cursorQuery.moveToFirst();
        C0624d c0624d = new C0624d();
        c0624d.f2174a = cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
        c0624d.f2175b = cursorQuery.getLong(cursorQuery.getColumnIndex("message_sever_id"));
        c0624d.f2176c = cursorQuery.getString(cursorQuery.getColumnIndex("message_inbox_no"));
        c0624d.f2177d = cursorQuery.getString(cursorQuery.getColumnIndex("message_session_id"));
        c0624d.f2178e = cursorQuery.getInt(cursorQuery.getColumnIndex("message_read_status"));
        c0624d.f2179f = cursorQuery.getInt(cursorQuery.getColumnIndex("message_content_type"));
        c0624d.f2180g = cursorQuery.getLong(cursorQuery.getColumnIndex("message_time"));
        c0624d.f2181h = cursorQuery.getString(cursorQuery.getColumnIndex("message_content"));
        c0624d.f2182i = cursorQuery.getInt(cursorQuery.getColumnIndex("message_type"));
        c0624d.f2183j = cursorQuery.getString(cursorQuery.getColumnIndex("message_sender"));
        c0624d.f2184k = cursorQuery.getString(cursorQuery.getColumnIndex("message_download_uri"));
        c0624d.f2185l = cursorQuery.getString(cursorQuery.getColumnIndex("message_formatted"));
        c0624d.f2186m = cursorQuery.getString(cursorQuery.getColumnIndex("message_tid"));
        c0624d.f2187n = cursorQuery.getInt(cursorQuery.getColumnIndex("message_stored_ext"));
        c0624d.f2188o = cursorQuery.getString(cursorQuery.getColumnIndex("message_need_update"));
        c0624d.f2189p = cursorQuery.getInt(cursorQuery.getColumnIndex("message_is_failed"));
        cursorQuery.close();
        return c0624d;
    }

    /* renamed from: a */
    public static void m2936a(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        EnumC0664q enumC0664qM3009a;
        C1341p.m4658b("migrationInBoxBuddyRelation", "MessageDatabaseHelper");
        sQLiteDatabase.beginTransaction();
        try {
            cursorQuery = sQLiteDatabase.query("message", new String[]{"message_content", "message_inbox_no", "_id"}, "message_content_type = ?", new String[]{Integer.toString(EnumC0651d.SYSTEM.m2978a())}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        EnumC0664q enumC0664q = EnumC0664q.UNKNOWN;
                        while (cursorQuery.moveToNext()) {
                            String string = cursorQuery.getString(0);
                            String string2 = cursorQuery.getString(1);
                            String string3 = cursorQuery.getString(2);
                            C1341p.m4658b(string, "migrationInBoxBuddyRelation");
                            String[] strArrSplit = string.split(";");
                            if (strArrSplit.length > 0) {
                                StringBuilder sb = new StringBuilder();
                                for (String str : strArrSplit) {
                                    ArrayList arrayListM4490a = C1291an.m4490a(str, ',');
                                    if (arrayListM4490a.size() > 0 && (enumC0664qM3009a = EnumC0664q.m3009a((String) arrayListM4490a.get(0))) != EnumC0664q.UNKNOWN) {
                                        sb.append(String.format("%d,%s,%s", Integer.valueOf(enumC0664qM3009a.m3010a()), arrayListM4490a.get(1), arrayListM4490a.get(2))).append(";");
                                    }
                                }
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("message_content", sb.toString());
                                sQLiteDatabase.update("message", contentValues, "_id=? AND message_inbox_no=? AND message_content_type=?", new String[]{string3, string2, Integer.toString(EnumC0651d.SYSTEM.m2978a())});
                                C1341p.m4658b(sb.toString(), "migrationInBoxBuddyRelation");
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
}
