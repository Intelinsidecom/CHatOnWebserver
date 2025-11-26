package com.sec.chaton.p017e.p018a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.C0701p;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;

/* compiled from: ParticipantDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.n */
/* loaded from: classes.dex */
public class C0670n {
    /* renamed from: a */
    public static boolean m3083a(ContentResolver contentResolver, String str, String str2) {
        Cursor cursorQuery = contentResolver.query(C0701p.f2644a, null, "participants_inbox_no=? AND participants_buddy_no=?", new String[]{str2, str}, null);
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
    public static String m3084b(ContentResolver contentResolver, String str, String str2) {
        String strM2983c = C0657a.m2983c(contentResolver, str);
        if (!strM2983c.equals(str)) {
            return strM2983c;
        }
        if (str2 == null) {
            return m3088c(contentResolver, str);
        }
        return str2;
    }

    /* renamed from: a */
    public static ContentProviderOperation m3078a(String str, String str2) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C0701p.f2644a);
        builderNewInsert.withValue("participants_buddy_no", str2);
        builderNewInsert.withValue("participants_inbox_no", str);
        builderNewInsert.withValue("participants_buddy_name", m3084b(GlobalApplication.m3260b().getContentResolver(), str2, null));
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static Cursor m3080a(ContentResolver contentResolver, String str) {
        return contentResolver.query(C0701p.m3164a(str), null, null, null, "rowid DESC");
    }

    /* renamed from: c */
    public static Uri m3087c(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_buddy_no", str2);
        contentValues.put("participants_inbox_no", str);
        contentValues.put("participants_buddy_name", m3084b(contentResolver, str2, null));
        return contentResolver.insert(C0701p.f2644a, contentValues);
    }

    /* renamed from: a */
    public static void m3082a(ContentResolver contentResolver, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_inbox_no", str);
        contentValues.put("participants_buddy_no", str2);
        contentValues.put("participants_buddy_name", m3084b(contentResolver, str2, str3));
        contentResolver.insert(C0701p.f2644a, contentValues);
    }

    /* renamed from: a */
    public static ContentProviderOperation m3079a(String str, String str2, String str3) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0701p.f2644a);
        builderNewUpdate.withSelection("participants_inbox_no=? AND participants_buddy_no=?", new String[]{str, str2});
        builderNewUpdate.withValue("participants_buddy_name", str3);
        return builderNewUpdate.build();
    }

    /* renamed from: d */
    public static void m3090d(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_inbox_no", "");
        contentResolver.update(C0701p.f2644a, contentValues, "participants_inbox_no=? AND participants_buddy_no=?", new String[]{str, str2});
    }

    /* renamed from: e */
    public static String m3091e(ContentResolver contentResolver, String str, String str2) {
        return m3089d(contentResolver, str2);
    }

    /* renamed from: b */
    public static String[] m3086b(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C0701p.f2644a, null, "participants_inbox_no=?", new String[]{str}, "participants_buddy_name");
        if (cursorQuery == null) {
            return new String[0];
        }
        if (cursorQuery != null && cursorQuery.getCount() == 0) {
            cursorQuery.close();
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
    public static String m3088c(ContentResolver contentResolver, String str) throws Resources.NotFoundException {
        String string;
        String string2 = GlobalApplication.m3262c().getString(R.string.unknown);
        Cursor cursorQuery = contentResolver.query(C0701p.f2644a, null, "participants_buddy_no=?", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            string = string2;
            while (cursorQuery.moveToNext()) {
                string = cursorQuery.getString(cursorQuery.getColumnIndex("participants_buddy_name"));
                if (!string.equals(string2)) {
                    break;
                }
            }
        } else {
            C1786r.m6061b("can't find participant name", "[ParticipantDatabaseHelper-getUnknownBuddyName]");
            string = string2;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return string;
    }

    /* renamed from: a */
    public static ArrayList m3081a(ContentResolver contentResolver, String str, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = contentResolver.query(C0701p.f2644a, new String[]{"participants_buddy_no"}, "participants_inbox_no= ? and participants_buddy_no not in ( select buddy_no from buddy )", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
                C1786r.m6061b("unknownParticipants : " + cursorQuery.getString(0), "[ParticipantDatabaseHelper]");
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    /* renamed from: d */
    public static String m3089d(ContentResolver contentResolver, String str) {
        String strM2983c = C0657a.m2983c(contentResolver, str);
        if (strM2983c.equals(str)) {
            return m3088c(contentResolver, str);
        }
        return strM2983c;
    }

    /* renamed from: b */
    public static boolean m3085b(ContentResolver contentResolver, String str, String str2, String str3) {
        Cursor cursorQuery = contentResolver.query(C0701p.f2644a, null, "participants_inbox_no=? AND participants_buddy_no=? AND participants_buddy_name=?", new String[]{str2, str, str3}, null);
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

    /* renamed from: e */
    public static ArrayList m3092e(ContentResolver contentResolver, String str) {
        ArrayList arrayList = null;
        Cursor cursorQuery = contentResolver.query(C0701p.f2644a, new String[]{"participants_inbox_no"}, "participants_buddy_no=? AND participants_inbox_no IN ( SELECT inbox_no FROM inbox WHERE inbox_chat_type = ? )", new String[]{str, String.valueOf(EnumC0695j.BROADCAST.m3146a())}, null);
        if (cursorQuery != null) {
            arrayList = new ArrayList();
            while (cursorQuery.moveToNext()) {
                if (!TextUtils.isEmpty(cursorQuery.getString(0))) {
                    arrayList.add(cursorQuery.getString(0));
                }
            }
            cursorQuery.close();
        }
        return arrayList;
    }
}
