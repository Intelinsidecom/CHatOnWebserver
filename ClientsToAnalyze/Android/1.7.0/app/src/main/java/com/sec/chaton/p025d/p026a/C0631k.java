package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C0654g;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;

/* compiled from: ParticipantDatabaseHelper.java */
/* renamed from: com.sec.chaton.d.a.k */
/* loaded from: classes.dex */
public class C0631k {
    /* renamed from: a */
    public static boolean m2864a(ContentResolver contentResolver, String str, String str2) {
        Cursor cursorQuery = contentResolver.query(C0654g.f2279a, null, "participants_inbox_no=? AND participants_buddy_no=?", new String[]{str2, str}, null);
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
    public static String m2866b(ContentResolver contentResolver, String str, String str2) {
        return m2874f(contentResolver, str, str2);
    }

    /* renamed from: a */
    public static ContentProviderOperation m2860a(String str, String str2) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C0654g.f2279a);
        builderNewInsert.withValue("participants_buddy_no", str2);
        builderNewInsert.withValue("participants_inbox_no", str);
        builderNewInsert.withValue("participants_buddy_name", GlobalApplication.m3106g().getString(R.string.unknown));
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m2861a(String str, String str2, String str3) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C0654g.f2279a);
        builderNewInsert.withValue("participants_buddy_no", str2);
        builderNewInsert.withValue("participants_inbox_no", str);
        builderNewInsert.withValue("participants_buddy_name", str3);
        return builderNewInsert.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m2865b(String str, String str2, String str3) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0654g.f2279a);
        builderNewUpdate.withSelection("participants_inbox_no=? AND participants_buddy_no=?", new String[]{str, str2});
        builderNewUpdate.withValue("participants_buddy_name", str3);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static Cursor m2862a(ContentResolver contentResolver, String str) {
        return contentResolver.query(C0654g.m2980a(str), null, null, null, "rowid DESC");
    }

    /* renamed from: c */
    public static Uri m2868c(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_buddy_no", str2);
        contentValues.put("participants_inbox_no", str);
        contentValues.put("participants_buddy_name", m2866b(contentResolver, str2, (String) null));
        return contentResolver.insert(C0654g.f2279a, contentValues);
    }

    /* renamed from: a */
    public static Uri m2863a(ContentResolver contentResolver, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_inbox_no", str);
        contentValues.put("participants_buddy_no", str2);
        contentValues.put("participants_buddy_name", str3);
        return contentResolver.insert(C0654g.f2279a, contentValues);
    }

    /* renamed from: d */
    public static void m2871d(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_inbox_no", "");
        contentResolver.update(C0654g.f2279a, contentValues, "participants_inbox_no=? AND participants_buddy_no=?", new String[]{str, str2});
    }

    /* renamed from: e */
    public static String m2872e(ContentResolver contentResolver, String str, String str2) {
        return m2870d(contentResolver, str2);
    }

    /* renamed from: b */
    public static String[] m2867b(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C0654g.f2279a, null, "participants_inbox_no=?", new String[]{str}, "buddy_name");
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

    /* renamed from: f */
    public static String m2874f(ContentResolver contentResolver, String str, String str2) throws Resources.NotFoundException {
        String string;
        String string2 = GlobalApplication.m3106g().getString(R.string.unknown);
        Cursor cursorQuery = contentResolver.query(C0654g.m2979a(), null, "buddy_no=?", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            string = string2;
            while (cursorQuery.moveToNext()) {
                string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"));
                if (!TextUtils.isEmpty(cursorQuery.getString(cursorQuery.getColumnIndex("participants_inbox_no"))) && !string.equals(string2)) {
                    break;
                }
            }
        } else {
            string = string2;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return (!string.equals(string2) || TextUtils.isEmpty(str2)) ? string : str2;
    }

    /* renamed from: g */
    public static String m2875g(ContentResolver contentResolver, String str, String str2) {
        boolean z;
        String string;
        Cursor cursorQuery = contentResolver.query(C0654g.m2979a(), null, "buddy_no=?", new String[]{str2}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            string = "";
            while (true) {
                if (!cursorQuery.moveToNext()) {
                    z = false;
                    break;
                }
                string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"));
                if (str.equals(cursorQuery.getString(cursorQuery.getColumnIndex("participants_inbox_no")))) {
                    z = true;
                    break;
                }
            }
        } else {
            C1341p.m4658b("can't find participant name", "[ParticipantDatabaseHelper-getUnknownBuddyName]");
            z = false;
            string = "";
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return z ? string : "";
    }

    /* renamed from: c */
    public static ArrayList m2869c(ContentResolver contentResolver, String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = contentResolver.query(C0654g.f2279a, new String[]{"participants_buddy_no"}, "participants_inbox_no= ? and participants_buddy_no not in ( select buddy_no from buddy )", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
                C1341p.m4658b("unknownParticipants : " + cursorQuery.getString(0), "[ParticipantDatabaseHelper]");
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    /* renamed from: d */
    public static String m2870d(ContentResolver contentResolver, String str) {
        return m2874f(contentResolver, str, null);
    }

    /* renamed from: e */
    public static ArrayList m2873e(ContentResolver contentResolver, String str) {
        ArrayList arrayList = null;
        Cursor cursorQuery = contentResolver.query(C0654g.f2279a, new String[]{"participants_inbox_no"}, "participants_buddy_no=? AND participants_inbox_no IN ( SELECT inbox_no FROM inbox WHERE inbox_chat_type = ? )", new String[]{str, String.valueOf(EnumC0665r.BROADCAST.m3012a())}, null);
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
