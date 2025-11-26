package com.sec.chaton.p017e.p018a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.anicon.C0921d;
import com.sec.chaton.p007a.C0144bj;
import com.sec.chaton.p017e.C0698m;
import com.sec.chaton.p017e.EnumC0690e;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p017e.EnumC0705t;
import com.sec.chaton.p028io.entry.PushEntry;
import com.sec.chaton.p028io.entry.inner.Msg;
import com.sec.chaton.p028io.entry.specialbuddy.SpecialBuddyFilePlayerEntry;
import com.sec.chaton.util.C1735ar;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1768bx;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1789u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import twitter4j.Query;

/* compiled from: MessageDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.i */
/* loaded from: classes.dex */
public class C0665i {
    /* renamed from: a */
    public static boolean m3066a(ContentResolver contentResolver, String str, String str2, String str3) {
        Cursor cursorQuery = contentResolver.query(C0698m.f2626a, null, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{str2, str3, str}, null);
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
    public static boolean m3065a(ContentResolver contentResolver, String str, String str2) {
        Cursor cursorQuery = contentResolver.query(C0698m.f2626a, null, "message_sever_id=? AND message_inbox_no=? AND message_content_type=?", new String[]{str, str2, String.valueOf(EnumC0699n.SYSTEM.m3162a())}, null);
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
    public static boolean m3072b(ContentResolver contentResolver, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return true;
        }
        Cursor cursorQuery = contentResolver.query(C0698m.f2626a, null, "message_sever_id=? AND message_session_id=? AND message_sender=?", new String[]{str2, str3, str}, null);
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
    public static boolean m3063a(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C0698m.f2626a, null, "_id=?", new String[]{str}, null);
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
    public static EnumC0699n m3046a(String str) {
        return m3047a(str, (EnumC0699n) null);
    }

    /* renamed from: a */
    public static EnumC0699n m3047a(String str, EnumC0699n enumC0699n) {
        if (enumC0699n != EnumC0699n.TEXT) {
            String[] strArrSplit = str.split("\n");
            String str2 = strArrSplit[0];
            if (Query.MIXED.equals(str2)) {
                str2 = strArrSplit[1];
            }
            if ("image".equals(str2)) {
                EnumC0699n enumC0699n2 = EnumC0699n.IMAGE;
                if (C0921d.m3794b(str)) {
                    return EnumC0699n.ANICON;
                }
                return enumC0699n2;
            }
            if ("video".equals(str2)) {
                return EnumC0699n.VIDEO;
            }
            if ("geo".equals(str2)) {
                return EnumC0699n.GEO;
            }
            if (SpecialBuddyFilePlayerEntry.FILEPLAYER_AUDIO.equals(str2)) {
                return EnumC0699n.AUDIO;
            }
            if ("contact".equals(str2)) {
                return EnumC0699n.CONTACT;
            }
            if ("calendar".equals(str2)) {
                return EnumC0699n.CALENDAR;
            }
            if ("doc".equals(str2)) {
                return EnumC0699n.DOCUMENT;
            }
            return EnumC0699n.UNDEFINED;
        }
        return EnumC0699n.TEXT;
    }

    /* renamed from: a */
    public static boolean m3064a(ContentResolver contentResolver, String str, EnumC0699n enumC0699n, PushEntry pushEntry, EnumC0695j enumC0695j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C1735ar.m5918a()));
        contentValues.put("message_sever_id", pushEntry.msgID);
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_content", pushEntry.message);
        contentValues.put("message_time", pushEntry.sentTime);
        contentValues.put("message_type", (Integer) 2);
        contentValues.put("message_sender", pushEntry.senderID);
        contentValues.put("message_session_id", pushEntry.sessionID);
        contentValues.put("message_content_type", Integer.valueOf(enumC0699n.m3162a()));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(pushEntry.sentTime));
        contentValues.put("message_need_update", "Y");
        contentValues.put("truncated", pushEntry.truncated);
        Uri uriInsert = contentResolver.insert(C0698m.m3155c(), contentValues);
        return uriInsert != null && C0698m.m3151a(uriInsert, 2) == null;
    }

    /* renamed from: a */
    public static EnumC0690e m3045a(ContentResolver contentResolver, String str, EnumC0699n enumC0699n, Msg msg, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C1735ar.m5918a()));
        contentValues.put("message_sever_id", msg.f3051id);
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_content", msg.value);
        contentValues.put("message_time", msg.time);
        contentValues.put("message_tid", msg.tid);
        contentValues.put("message_type", (Integer) 2);
        contentValues.put("message_sender", msg.sender);
        contentValues.put("message_session_id", msg.sessionid);
        contentValues.put("message_content_type", Integer.valueOf(enumC0699n.m3162a()));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(msg.time));
        contentValues.put("message_need_update", "N");
        contentValues.put("message_read_status", Integer.valueOf(msg.receiver.split(",").length));
        if (str2 != null) {
            contentValues.put("message_formatted", str2);
        }
        EnumC0690e enumC0690e = EnumC0690e.FAIL;
        Uri uriInsert = contentResolver.insert(C0698m.m3155c(), contentValues);
        if (uriInsert != null) {
            if (C0698m.m3151a(uriInsert, 2) != null) {
                return EnumC0690e.INSERT;
            }
            return EnumC0690e.UPDATE;
        }
        return enumC0690e;
    }

    /* renamed from: b */
    public static boolean m3071b(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C1735ar.m5918a()));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC0699n.SYSTEM.m3162a()));
        contentValues.put("message_content", str2);
        contentValues.put("message_time", (Long) Long.MIN_VALUE);
        contentValues.put("message_sender", str);
        try {
            if (m3070b(contentResolver, str)) {
                contentResolver.update(C0698m.f2626a, contentValues, "message_sender=? AND message_inbox_no=? AND message_content_type=?", new String[]{str, str, String.valueOf(EnumC0699n.SYSTEM.m3162a())});
            } else {
                contentResolver.insert(C0698m.f2626a, contentValues);
            }
            return true;
        } catch (SQLiteDiskIOException e) {
            C1786r.m6056a(e, GlobalApplication.m3260b().getClass().getSimpleName());
            return false;
        } catch (SQLiteFullException e2) {
            C1786r.m6056a(e2, GlobalApplication.m3260b().getClass().getSimpleName());
            return false;
        } catch (SQLiteException e3) {
            C1786r.m6056a(e3, GlobalApplication.m3260b().getClass().getSimpleName());
            return false;
        } catch (Exception e4) {
            C1786r.m6056a(e4, GlobalApplication.m3260b().getClass().getSimpleName());
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m3070b(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C0698m.f2626a, null, "message_sender=? AND message_inbox_no=? AND message_content_type=?", new String[]{str, str, String.valueOf(EnumC0699n.SYSTEM.m3162a())}, null);
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
    public static EnumC0690e m3044a(ContentResolver contentResolver, String str, EnumC0699n enumC0699n, C0144bj c0144bj, String str2, Long l, String str3, EnumC0695j enumC0695j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C1735ar.m5918a()));
        contentValues.put("message_sever_id", Long.valueOf(c0144bj.m1116h()));
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_content", c0144bj.m1118j());
        contentValues.put("message_time", Long.valueOf(c0144bj.m1120l()));
        contentValues.put("message_type", (Integer) 2);
        contentValues.put("message_sender", c0144bj.m1112d());
        contentValues.put("message_session_id", str);
        contentValues.put("message_content_type", Integer.valueOf(enumC0699n.m3162a()));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(c0144bj.m1120l())));
        contentValues.put("message_need_update", "N");
        contentValues.put("message_read_status", Integer.valueOf(c0144bj.m1114f()));
        if (str3 != null) {
            contentValues.put("message_formatted", str3);
        }
        EnumC0690e enumC0690e = EnumC0690e.FAIL;
        Uri uriInsert = contentResolver.insert(C0698m.m3155c(), contentValues);
        if (uriInsert != null) {
            if (C0698m.m3151a(uriInsert, 2) != null) {
                return EnumC0690e.INSERT;
            }
            return EnumC0690e.UPDATE;
        }
        return enumC0690e;
    }

    /* renamed from: a */
    public static Uri m3042a(ContentResolver contentResolver, String str, String str2, EnumC0699n enumC0699n, String str3, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", str);
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_read_status", Integer.valueOf(i));
        contentValues.put("message_content_type", Integer.valueOf(enumC0699n.m3162a()));
        contentValues.put("message_content", str3);
        contentValues.put("message_sender", C1789u.m6075a().getString("msisdn", ""));
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_type", (Integer) 0);
        contentValues.put("message_is_failed", (Integer) 1);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        return contentResolver.insert(C0698m.f2626a, contentValues);
    }

    /* renamed from: b */
    public static Uri m3067b(ContentResolver contentResolver, String str, String str2, EnumC0699n enumC0699n, String str3, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", str);
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_read_status", Integer.valueOf(i));
        contentValues.put("message_content_type", Integer.valueOf(enumC0699n.m3162a()));
        contentValues.put("message_content", str3);
        contentValues.put("message_sender", C1789u.m6075a().getString("msisdn", ""));
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_type", (Integer) 0);
        contentValues.put("message_is_failed", (Integer) 1);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        return contentResolver.insert(C0698m.m3152b(), contentValues);
    }

    /* renamed from: a */
    public static void m3061a(C0666j c0666j, int i, String str, String str2, EnumC0699n enumC0699n, String str3, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", str);
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_read_status", Integer.valueOf(i2));
        contentValues.put("message_content_type", Integer.valueOf(enumC0699n.m3162a()));
        contentValues.put("message_content", str3);
        contentValues.put("message_sender", C1789u.m6075a().getString("msisdn", ""));
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_type", (Integer) 0);
        contentValues.put("message_is_failed", (Integer) 1);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        c0666j.startInsert(i, null, C0698m.f2626a, contentValues);
    }

    /* renamed from: a */
    public static Uri m3043a(ContentResolver contentResolver, String str, String str2, EnumC0699n enumC0699n, String str3, int i, String str4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", str);
        contentValues.put("message_inbox_no", str2);
        contentValues.put("message_read_status", Integer.valueOf(i));
        contentValues.put("message_content_type", Integer.valueOf(enumC0699n.m3162a()));
        contentValues.put("message_download_uri", str3);
        contentValues.put("message_sender", C1789u.m6075a().getString("msisdn", ""));
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_type", (Integer) 0);
        contentValues.put("message_is_failed", (Integer) 1);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        contentValues.put("message_stored_ext", Integer.valueOf(C1767bw.m6002a() ? 1 : 0));
        contentValues.put("message_content", str4);
        return contentResolver.insert(C0698m.f2626a, contentValues);
    }

    /* renamed from: c */
    public static Uri m3073c(ContentResolver contentResolver, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C1735ar.m5918a()));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC0699n.SYSTEM.m3162a()));
        contentValues.put("message_content", str2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        contentValues.put("message_sender", str3);
        return contentResolver.insert(C0698m.f2626a, contentValues);
    }

    /* renamed from: a */
    public static void m3062a(C0666j c0666j, int i, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C1735ar.m5918a()));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC0699n.SYSTEM.m3162a()));
        contentValues.put("message_content", str2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        contentValues.put("message_time", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(jCurrentTimeMillis)));
        contentValues.put("message_sender", str3);
        c0666j.startInsert(i, null, C0698m.f2626a, contentValues);
    }

    /* renamed from: a */
    public static Uri m3041a(ContentResolver contentResolver, String str, String str2, long j, String str3, String str4) {
        if (m3065a(contentResolver, str3, str)) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C1735ar.m5918a()));
        contentValues.put("message_sever_id", str3);
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC0699n.SYSTEM.m3162a()));
        contentValues.put("message_content", str2);
        contentValues.put("message_time", Long.valueOf(j));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j)));
        contentValues.put("message_sender", str4);
        return contentResolver.insert(C0698m.f2626a, contentValues);
    }

    /* renamed from: a */
    public static Uri m3040a(ContentResolver contentResolver, String str, String str2, long j, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(C1735ar.m5918a()));
        contentValues.put("message_inbox_no", str);
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_content_type", Integer.valueOf(EnumC0699n.SYSTEM.m3162a()));
        contentValues.put("message_content", str2);
        contentValues.put("message_time", Long.valueOf(j));
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j)));
        contentValues.put("message_sender", str3);
        return contentResolver.insert(C0698m.f2626a, contentValues);
    }

    /* renamed from: a */
    public static void m3059a(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        if (C1786r.f6452b) {
            C1786r.m6061b("migrationIsFileUploadField", "MessageDatabaseHelper");
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
                            if (C1786r.f6452b) {
                                C1786r.m6061b(String.format("The Type of Failed : %d", Integer.valueOf(i)), "migrationIsFileUploadField");
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
    public static void m3058a(ContentResolver contentResolver, String str, String str2, Long l, String str3, EnumC0695j enumC0695j, boolean z, boolean z2) {
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
        if (m3066a(contentResolver, str, String.valueOf(l), str2)) {
            contentResolver.update(C0698m.f2626a, contentValues, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{String.valueOf(l), str2, str});
        } else {
            C1786r.m6061b("updateMediaURI(Insert)XXX", GlobalApplication.m3260b().getClass().getName());
        }
    }

    /* renamed from: a */
    public static void m3056a(ContentResolver contentResolver, String str, String str2, Long l, EnumC0695j enumC0695j, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("message_type", (Integer) 3);
        } else {
            contentValues.put("message_type", (Integer) 4);
        }
        if (m3066a(contentResolver, str, String.valueOf(l), str2)) {
            contentResolver.update(C0698m.f2626a, contentValues, "message_sever_id=? AND message_inbox_no=? AND message_sender=?", new String[]{String.valueOf(l), str2, str});
        }
    }

    /* renamed from: a */
    public static void m3057a(ContentResolver contentResolver, String str, String str2, Long l, String str3, EnumC0695j enumC0695j, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_content", str3);
        contentValues.put("message_stored_ext", Integer.valueOf(z ? 1 : 0));
        contentResolver.update(C0698m.f2626a, contentValues, "_id=?", new String[]{String.valueOf(l)});
    }

    /* renamed from: a */
    public static void m3055a(ContentResolver contentResolver, String str, Long l, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_formatted", str2);
        contentValues.put("message_inbox_no", str);
        if (m3063a(contentResolver, String.valueOf(l))) {
            contentResolver.update(C0698m.f2626a, contentValues, "_id=?", new String[]{String.valueOf(l)});
        } else {
            contentValues.put("_id", Long.valueOf(C1735ar.m5918a()));
            contentResolver.insert(C0698m.f2626a, contentValues);
        }
    }

    /* renamed from: a */
    public static void m3053a(ContentResolver contentResolver, Long l, String str, long j, Long l2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_time", l);
        contentValues.put("message_time_text", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(l));
        contentValues.put("message_session_id", str);
        contentValues.put("message_sever_id", Long.valueOf(j));
        contentValues.put("message_type", (Integer) 1);
        contentValues.put("message_is_failed", (Integer) 0);
        contentValues.put("message_read_status", Integer.valueOf(i));
        contentResolver.update(C0698m.f2626a, contentValues, "_id=?", new String[]{String.valueOf(l2)});
    }

    /* renamed from: a */
    public static void m3050a(ContentResolver contentResolver, Long l, Long l2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) (-1));
        contentValues.put("message_is_failed", (Integer) 2);
        contentValues.put("_id", l2);
        contentResolver.update(C0698m.f2626a, contentValues, "_id=" + l, null);
    }

    /* renamed from: a */
    public static void m3049a(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) (-1));
        contentValues.put("message_is_failed", (Integer) 2);
        contentResolver.update(C0698m.f2626a, contentValues, "_id=" + l, null);
    }

    /* renamed from: b */
    public static void m3068b(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) 5);
        contentResolver.update(C0698m.f2626a, contentValues, "message_sever_id= ?", new String[]{Long.toString(l.longValue())});
    }

    /* renamed from: a */
    public static void m3054a(ContentResolver contentResolver, Long l, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (!z) {
            contentValues.put("message_type", (Integer) (-1));
        }
        contentValues.put("message_is_failed", (Integer) 3);
        contentResolver.update(C0698m.f2626a, contentValues, "_id=" + l, null);
    }

    /* renamed from: a */
    public static void m3051a(ContentResolver contentResolver, Long l, Long l2, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (!z) {
            contentValues.put("message_type", (Integer) (-1));
        }
        contentValues.put("message_is_failed", (Integer) 3);
        contentValues.put("_id", l2);
        contentResolver.update(C0698m.f2626a, contentValues, "_id=" + l, null);
    }

    /* renamed from: c */
    public static void m3074c(ContentResolver contentResolver, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) 0);
        contentValues.put("message_is_failed", (Integer) 1);
        contentResolver.update(C0698m.f2626a, contentValues, "_id=" + l, null);
    }

    /* renamed from: a */
    public static void m3060a(C0666j c0666j, int i, Long l) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) 0);
        contentValues.put("message_is_failed", (Integer) 1);
        c0666j.startUpdate(i, null, C0698m.f2626a, contentValues, "_id=?", new String[]{String.valueOf(l)});
    }

    /* renamed from: a */
    public static void m3052a(ContentResolver contentResolver, Long l, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_type", (Integer) (-1));
        contentValues.put("message_is_failed", (Integer) 2);
        contentValues.put("message_formatted", str);
        contentResolver.update(C0698m.f2626a, contentValues, "_id=" + l, null);
    }

    /* renamed from: a */
    public static void m3048a(ContentResolver contentResolver) {
        int iUpdate = 0;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_type", (Integer) (-1));
            contentValues.put("message_is_failed", (Integer) 2);
            iUpdate = contentResolver.update(C0698m.f2626a, contentValues, "message_type=0", null);
        } catch (IllegalArgumentException e) {
            C1786r.m6056a(e, "MessageDatabaseHelper");
        }
        C1786r.m6063c("updateAllSendingMsgToFail() - count:" + iUpdate, "MessageDatabaseHelper");
    }

    /* renamed from: b */
    public static void m3069b(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        EnumC0705t enumC0705tM3170a;
        C1786r.m6061b("migrationInBoxBuddyRelation", "MessageDatabaseHelper");
        sQLiteDatabase.beginTransaction();
        try {
            cursorQuery = sQLiteDatabase.query("message", new String[]{"message_content", "message_inbox_no", "_id"}, "message_content_type = ?", new String[]{Integer.toString(EnumC0699n.SYSTEM.m3162a())}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        EnumC0705t enumC0705t = EnumC0705t.UNKNOWN;
                        while (cursorQuery.moveToNext()) {
                            String string = cursorQuery.getString(0);
                            String string2 = cursorQuery.getString(1);
                            String string3 = cursorQuery.getString(2);
                            C1786r.m6061b(string, "migrationInBoxBuddyRelation");
                            String[] strArrSplit = string.split(";");
                            if (strArrSplit.length > 0) {
                                StringBuilder sb = new StringBuilder();
                                for (String str : strArrSplit) {
                                    ArrayList arrayListM6004a = C1768bx.m6004a(str, ',');
                                    if (arrayListM6004a.size() > 0 && (enumC0705tM3170a = EnumC0705t.m3170a((String) arrayListM6004a.get(0))) != EnumC0705t.UNKNOWN) {
                                        sb.append(String.format("%d,%s,%s", Integer.valueOf(enumC0705tM3170a.m3171a()), arrayListM6004a.get(1), arrayListM6004a.get(2))).append(";");
                                    }
                                }
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("message_content", sb.toString());
                                sQLiteDatabase.update("message", contentValues, "_id=? AND message_inbox_no=? AND message_content_type=?", new String[]{string3, string2, Integer.toString(EnumC0699n.SYSTEM.m3162a())});
                                C1786r.m6061b(sb.toString(), "migrationInBoxBuddyRelation");
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
