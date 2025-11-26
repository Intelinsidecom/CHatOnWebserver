package com.sec.chaton.database.helper;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.C0062R;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ParticipantDatabaseHelper {
    /* renamed from: a */
    public static ContentProviderOperation m2305a(String str, String str2) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(ChatONContract.ParticipantTable.f1741a);
        builderNewInsert.withValue("participants_buddy_no", str2);
        builderNewInsert.withValue("participants_inbox_no", str);
        builderNewInsert.withValue("participants_buddy_name", m2310b(GlobalApplication.m2387e().getContentResolver(), str2, null));
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static Cursor m2306a(ContentResolver contentResolver, String str) {
        return contentResolver.query(ChatONContract.ParticipantTable.m2199a(str), null, null, null, "buddy_name");
    }

    /* renamed from: a */
    public static ArrayList m2307a(ContentResolver contentResolver, String str, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = contentResolver.query(ChatONContract.ParticipantTable.f1741a, new String[]{"participants_buddy_no"}, "participants_inbox_no= ? and participants_buddy_no not in ( select buddy_no from buddy )", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
                ChatONLogWriter.m3506b("unknownParticipants : " + cursorQuery.getString(0), "[ParticipantDatabaseHelper]");
            }
            cursorQuery.close();
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m2308a(ContentResolver contentResolver, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_inbox_no", str);
        contentValues.put("participants_buddy_no", str2);
        contentValues.put("participants_buddy_name", m2310b(contentResolver, str2, str3));
        contentResolver.insert(ChatONContract.ParticipantTable.f1741a, contentValues);
    }

    /* renamed from: a */
    public static boolean m2309a(ContentResolver contentResolver, String str, String str2) {
        Cursor cursorQuery = contentResolver.query(ChatONContract.ParticipantTable.f1741a, null, "participants_inbox_no=? AND participants_buddy_no=?", new String[]{str2, str}, null);
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
    public static String m2310b(ContentResolver contentResolver, String str, String str2) {
        String strM2220a = BuddyDatabaseHelper.m2220a(contentResolver, str);
        return strM2220a.equals(str) ? str2 != null ? str2 : m2314c(contentResolver, str) : strM2220a;
    }

    /* renamed from: b */
    public static boolean m2311b(ContentResolver contentResolver, String str, String str2, String str3) {
        Cursor cursorQuery = contentResolver.query(ChatONContract.ParticipantTable.f1741a, null, "participants_inbox_no=? AND participants_buddy_no=? AND participants_buddy_name=?", new String[]{str2, str, str3}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() != 0) {
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

    /* renamed from: b */
    public static String[] m2312b(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(ChatONContract.ParticipantTable.f1741a, null, "participants_inbox_no=?", new String[]{str}, "participants_buddy_name");
        if (cursorQuery == null || cursorQuery.getCount() == 0) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
        int columnIndex = cursorQuery.getColumnIndex("participants_buddy_no");
        while (cursorQuery.moveToNext()) {
            if (!cursorQuery.isNull(columnIndex)) {
                arrayList.add(cursorQuery.getString(columnIndex));
            }
        }
        cursorQuery.close();
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: c */
    public static Uri m2313c(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_buddy_no", str2);
        contentValues.put("participants_inbox_no", str);
        contentValues.put("participants_buddy_name", m2310b(contentResolver, str2, null));
        return contentResolver.insert(ChatONContract.ParticipantTable.f1741a, contentValues);
    }

    /* renamed from: c */
    public static String m2314c(ContentResolver contentResolver, String str) throws Resources.NotFoundException {
        String string;
        String string2 = GlobalApplication.m2388f().getString(C0062R.string.unknown);
        Cursor cursorQuery = contentResolver.query(ChatONContract.ParticipantTable.f1741a, null, "participants_buddy_no=?", new String[]{str}, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            ChatONLogWriter.m3506b("can't find participant name", "[ParticipantDatabaseHelper-getUnknownBuddyName]");
            string = string2;
        } else {
            string = string2;
            while (cursorQuery.moveToNext()) {
                string = cursorQuery.getString(cursorQuery.getColumnIndex("participants_buddy_name"));
                if (!string.equals(string2)) {
                    break;
                }
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return string;
    }

    /* renamed from: d */
    public static String m2315d(ContentResolver contentResolver, String str) {
        String strM2220a = BuddyDatabaseHelper.m2220a(contentResolver, str);
        return strM2220a.equals(str) ? m2314c(contentResolver, str) : strM2220a;
    }

    /* renamed from: d */
    public static void m2316d(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_inbox_no", "");
        contentResolver.update(ChatONContract.ParticipantTable.f1741a, contentValues, "participants_inbox_no=? AND participants_buddy_no=?", new String[]{str, str2});
    }

    /* renamed from: e */
    public static String m2317e(ContentResolver contentResolver, String str, String str2) {
        return m2315d(contentResolver, str2);
    }

    /* renamed from: e */
    public static ArrayList m2318e(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(ChatONContract.ParticipantTable.f1741a, new String[]{"participants_inbox_no"}, "participants_buddy_no=? AND participants_inbox_no IN ( SELECT inbox_no FROM inbox WHERE inbox_chat_type = ? )", new String[]{str, String.valueOf(ChatONContract.InBoxTable.ChatType.BROADCAST.m2189a())}, null);
        if (cursorQuery == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursorQuery.moveToNext()) {
            if (!TextUtils.isEmpty(cursorQuery.getString(0))) {
                arrayList.add(cursorQuery.getString(0));
            }
        }
        cursorQuery.close();
        return arrayList;
    }
}
