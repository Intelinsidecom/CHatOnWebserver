package com.sec.chaton.smsplugin.provider;

import android.annotation.SuppressLint;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.BaseColumns;
import android.provider.Telephony;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2202p;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p102b.C3789h;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.chaton.smsplugin.p111h.C3896s;
import com.sec.google.android.p134a.p135a.C5082e;
import com.sec.google.android.p134a.p135a.C5097t;
import com.sec.spp.push.Config;

/* compiled from: ChatOnInbox.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.provider.e */
/* loaded from: classes.dex */
public class C3947e implements BaseColumns {

    /* renamed from: a */
    private static final String f14228a = C3947e.class.getSimpleName();

    /* renamed from: a */
    public static ContentValues m15251a(long j, long j2, String str, int i, String str2) {
        C3789h c3789hM14303a = null;
        if (!TextUtils.isEmpty(str2)) {
            c3789hM14303a = C3789h.m14303a(str2, true);
        }
        return m15249a(j, j2, str, i, c3789hM14303a);
    }

    /* renamed from: a */
    public static ContentValues m15252a(long j, long j2, String str, int i, String str2, int i2) {
        C3789h c3789hM14303a = null;
        if (!TextUtils.isEmpty(str2)) {
            c3789hM14303a = C3789h.m14303a(str2, true);
        }
        return m15250a(j, j2, str, i, c3789hM14303a, i2);
    }

    /* renamed from: a */
    public static ContentValues m15249a(long j, long j2, String str, int i, C3789h c3789h) {
        return m15250a(j, j2, str, i, c3789h, 0);
    }

    /* renamed from: a */
    public static ContentValues m15250a(long j, long j2, String str, int i, C3789h c3789h, int i2) {
        ContentValues contentValues = new ContentValues();
        if (c3789h == null || c3789h.size() == 0) {
            contentValues.put("inbox_last_msg_sender", "-1");
            contentValues.put("inbox_title", GlobalApplication.m10279a().getString(R.string.unknown_sender));
            contentValues.put("inbox_participants", (Integer) 0);
            contentValues.put("inbox_chat_type", Integer.valueOf(EnumC2300t.ONETOONE.m10210a()));
        } else {
            contentValues.put("key_recipients", c3789h.m14308a());
            contentValues.put("inbox_participants", Integer.valueOf(c3789h.size()));
            if (C3847e.m14656aG() && C3847e.m14649a(i2)) {
                m15259a(contentValues, i2);
            } else {
                contentValues.put("inbox_title", c3789h.m14310b(", "));
                if (c3789h.size() == 1) {
                    contentValues.put("inbox_last_msg_sender", c3789h.get(0).m14262d());
                }
            }
            if (c3789h.size() > 1) {
                contentValues.put("inbox_chat_type", Integer.valueOf(EnumC2300t.BROADCAST2.m10210a()));
            } else {
                contentValues.put("inbox_chat_type", Integer.valueOf(EnumC2300t.ONETOONE.m10210a()));
            }
        }
        contentValues.put("inbox_no", Long.valueOf(j2));
        contentValues.put("inbox_last_time", Long.valueOf(j));
        contentValues.put("inbox_session_id", Long.valueOf(j2));
        contentValues.put("inbox_cmas_thread_type", Integer.valueOf(i2));
        contentValues.put("inbox_last_chat_type", (Integer) 10);
        contentValues.put("inbox_last_message", m15257a(str, i));
        return contentValues;
    }

    /* renamed from: a */
    private static void m15259a(ContentValues contentValues, int i) {
        String string;
        switch (i) {
            case 100:
                string = GlobalApplication.m10279a().getString(R.string.cmas_presidential_alerts);
                break;
            case 101:
                string = GlobalApplication.m10279a().getString(R.string.cmas_extreme_alerts);
                break;
            case 102:
                string = GlobalApplication.m10279a().getString(R.string.cmas_severe_alerts);
                break;
            case 103:
                string = GlobalApplication.m10279a().getString(R.string.cmas_amber_alerts);
                break;
            case 104:
                string = GlobalApplication.m10279a().getString(R.string.cmas_test_message_alerts);
                break;
            default:
                string = GlobalApplication.m10279a().getString(R.string.cmas_all_in_one_message_thread_alerts);
                break;
        }
        contentValues.put("inbox_title", string);
        contentValues.put("inbox_last_msg_sender", string);
    }

    /* renamed from: a */
    public static String m15257a(String str, int i) {
        return m15258a(str, i, true);
    }

    /* renamed from: a */
    public static String m15258a(String str, int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append(2);
        } else {
            sb.append(1);
        }
        sb.append(Config.KEYVALUE_SPLIT);
        sb.append(EnumC2214ab.TEXT.m10076a());
        sb.append(Config.KEYVALUE_SPLIT);
        if (!TextUtils.isEmpty(str)) {
            if (!C3847e.m14627K() && i == 106) {
                GlobalApplication.m10279a();
                str = GlobalApplication.m10283b().getString(R.string.multimedia_message);
            } else if (Build.VERSION.SDK_INT >= 19) {
                str = m15261b(str, i);
            }
            sb.append(C1736gi.m8632a(str));
        }
        sb.append(Config.KEYVALUE_SPLIT);
        return sb.toString();
    }

    /* renamed from: b */
    public static String m15261b(String str, int i) {
        if (i != 0) {
            return new C5082e(i, C5097t.m19436a(str)).m19308c();
        }
        return str;
    }

    /* renamed from: a */
    public static Uri m15254a(Context context, ContentResolver contentResolver, long j, boolean z, boolean z2) throws Throwable {
        Uri uriWithAppendedPath = Uri.withAppendedPath(ContentUris.withAppendedId(Telephony.Threads.CONTENT_URI, j), "subject");
        String[] strArr = new String[5];
        strArr[0] = "snippet";
        strArr[1] = "date";
        strArr[2] = "recipient_ids";
        strArr[3] = C3847e.m14628L() ? "unread_count" : "-1";
        strArr[4] = "snippet_cs";
        Cursor cursorQuery = contentResolver.query(uriWithAppendedPath, strArr, null, null, null);
        ContentResolver contentResolver2 = context.getContentResolver();
        String string = null;
        int i = 0;
        String string2 = null;
        int i2 = 0;
        long j2 = 0;
        if (cursorQuery == null) {
            C3896s.m15044b("Query on thread failed", f14228a);
            return null;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                string = cursorQuery.getString(0);
                j2 = cursorQuery.getLong(1);
                string2 = cursorQuery.getString(2);
                i = cursorQuery.getInt(3);
                if (!cursorQuery.isNull(4)) {
                    i2 = cursorQuery.getInt(4);
                }
            }
            cursorQuery.close();
            C3789h c3789hM14303a = null;
            if (!TextUtils.isEmpty(string2)) {
                c3789hM14303a = C3789h.m14303a(string2, true);
            }
            String strM15012a = C3892o.m15012a(context, contentResolver2, c3789hM14303a);
            if (strM15012a != null) {
                if (z2) {
                    C3896s.m15044b("insertOrUpdateMixedInbox do nothing draft & mixed room", f14228a);
                    return null;
                }
                C2202p.m9975a(context, contentResolver, z, strM15012a, c3789hM14303a, i, string, i2, j2, j);
                return null;
            }
            ContentValues contentValuesM15251a = m15251a(j2, j, string, i2, string2);
            if (i != -1) {
                contentValuesM15251a.put("inbox_unread_count", Integer.valueOf(i));
            }
            Uri uriInsert = contentResolver.insert(Uri.withAppendedPath(C2299s.f8209a, "sms"), contentValuesM15251a);
            contentResolver.notifyChange(C2299s.f8209a, null);
            return uriInsert;
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    /* renamed from: a */
    public static Uri m15253a(ContentResolver contentResolver, long j) {
        String string;
        int i;
        String string2;
        int i2 = 0;
        Uri uriWithAppendedPath = Uri.withAppendedPath(ContentUris.withAppendedId(Telephony.Threads.CONTENT_URI, j), "subject");
        String[] strArr = new String[5];
        strArr[0] = "snippet";
        strArr[1] = "date";
        strArr[2] = "recipient_ids";
        strArr[3] = C3847e.m14628L() ? "unread_count" : "-1";
        strArr[4] = "snippet_cs";
        Cursor cursorQuery = contentResolver.query(uriWithAppendedPath, strArr, null, null, null);
        long j2 = 0;
        if (cursorQuery == null) {
            C3896s.m15044b("Query on thread failed", f14228a);
            return null;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                string2 = cursorQuery.getString(0);
                j2 = cursorQuery.getLong(1);
                string = cursorQuery.getString(2);
                i = cursorQuery.getInt(3);
                if (!cursorQuery.isNull(4)) {
                    i2 = cursorQuery.getInt(4);
                }
            } else {
                string = null;
                i = 0;
                string2 = null;
            }
            cursorQuery.close();
            ContentValues contentValuesM15251a = m15251a(j2, j, string2, i2, string);
            if (i != -1) {
                contentValuesM15251a.put("inbox_unread_count", Integer.valueOf(i));
            }
            Uri uriInsert = contentResolver.insert(Uri.withAppendedPath(C2299s.f8209a, "sms"), contentValuesM15251a);
            contentResolver.notifyChange(C2299s.f8209a, null);
            return uriInsert;
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    /* renamed from: b */
    public static ContentProviderOperation m15260b(ContentResolver contentResolver, long j) {
        int i;
        int i2;
        String string;
        String str;
        Uri uriWithAppendedPath = Uri.withAppendedPath(ContentUris.withAppendedId(Telephony.Threads.CONTENT_URI, j), "subject");
        String[] strArr = new String[5];
        strArr[0] = "snippet";
        strArr[1] = "date";
        strArr[2] = "recipient_ids";
        strArr[3] = C3847e.m14628L() ? "unread_count" : "-1";
        strArr[4] = "snippet_cs";
        Cursor cursorQuery = contentResolver.query(uriWithAppendedPath, strArr, null, null, null);
        long j2 = 0;
        if (cursorQuery == null) {
            C3896s.m15044b("Query on thread failed", f14228a);
            return null;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                string = cursorQuery.getString(0);
                j2 = cursorQuery.getLong(1);
                String string2 = cursorQuery.getString(2);
                int i3 = cursorQuery.getInt(3);
                if (cursorQuery.isNull(4)) {
                    i = 0;
                    i2 = i3;
                    str = string2;
                } else {
                    i = cursorQuery.getInt(4);
                    str = string2;
                    i2 = i3;
                }
            } else {
                i = 0;
                i2 = 0;
                string = null;
                str = null;
            }
            cursorQuery.close();
            ContentValues contentValuesM15251a = m15251a(j2, j, string, i, str);
            if (i2 != -1) {
                contentValuesM15251a.put("inbox_unread_count", Integer.valueOf(i2));
            }
            return ContentProviderOperation.newInsert(Uri.withAppendedPath(C2299s.f8209a, "sms")).withValues(contentValuesM15251a).build();
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    /* renamed from: c */
    public static boolean m15262c(ContentResolver contentResolver, long j) {
        int i;
        Uri.Builder builderAppendId = ContentUris.appendId(Telephony.Threads.CONTENT_URI.buildUpon(), j);
        builderAppendId.appendPath("subject");
        Cursor cursorQuery = contentResolver.query(builderAppendId.build(), new String[]{"count(*)"}, null, null, null);
        if (cursorQuery != null) {
            try {
                i = cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
            } finally {
                cursorQuery.close();
            }
        } else {
            i = 0;
        }
        return i > 0;
    }

    /* renamed from: d */
    public static void m15263d(ContentResolver contentResolver, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("inbox_unread_count", (Integer) 0);
        contentResolver.update(C2299s.f8209a, contentValues, "inbox_no = ?", new String[]{Long.toString(j)});
        contentResolver.notifyChange(C2299s.f8209a, null);
    }

    /* renamed from: a */
    public static String m15255a(ContentValues contentValues, C3789h c3789h) {
        if (c3789h.size() > 1) {
            contentValues.put("inbox_chat_type", Integer.valueOf(EnumC2300t.BROADCAST2.m10210a()));
            contentValues.put("inbox_participants", Integer.valueOf(c3789h.size()));
            return c3789h.m14310b(", ");
        }
        if (c3789h.size() == 1) {
            contentValues.put("inbox_chat_type", Integer.valueOf(EnumC2300t.ONETOONE.m10210a()));
            String strM14310b = c3789h.m14310b(", ");
            contentValues.put("inbox_participants", (Integer) 1);
            return strM14310b;
        }
        contentValues.put("inbox_chat_type", Integer.valueOf(EnumC2300t.ONETOONE.m10210a()));
        String string = GlobalApplication.m10279a().getString(R.string.unknown_sender);
        contentValues.put("inbox_participants", (Integer) 1);
        return string;
    }

    /* renamed from: a */
    public static String m15256a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C3789h c3789hM14303a = C3789h.m14303a(str, true);
        if (c3789hM14303a.size() > 1) {
            return c3789hM14303a.m14310b(", ");
        }
        if (c3789hM14303a.size() == 1) {
            return c3789hM14303a.m14310b(", ");
        }
        return GlobalApplication.m10279a().getString(R.string.unknown_sender);
    }

    /* renamed from: a */
    public static long m15248a(ContentResolver contentResolver, Uri uri) {
        Cursor cursorQuery = contentResolver.query(uri, new String[]{"thread_id"}, null, null, null);
        long j = 0;
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    j = cursorQuery.getLong(0);
                }
            } finally {
                cursorQuery.close();
            }
        }
        return j;
    }

    /* renamed from: e */
    public static boolean m15264e(ContentResolver contentResolver, long j) {
        Cursor cursorQuery = contentResolver.query(C2299s.f8209a, new String[]{"inbox_enable_noti"}, "inbox_no=" + j, null, null);
        if (cursorQuery != null) {
            boolean zEquals = cursorQuery.moveToFirst() ? "Y".equals(cursorQuery.getString(0)) : false;
            cursorQuery.close();
            return zEquals;
        }
        C3896s.m15041a("Failed to get noti enabled flag from inbox. DEFAULT[false]", f14228a);
        return false;
    }

    /* renamed from: f */
    public static String m15265f(ContentResolver contentResolver, long j) {
        Cursor cursorQuery = contentResolver.query(ContentUris.withAppendedId(Telephony.Sms.CONTENT_URI, j), new String[]{"body"}, null, null, null);
        if (cursorQuery != null) {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(0) : null;
            cursorQuery.close();
        }
        return string;
    }
}
