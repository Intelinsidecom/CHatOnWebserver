package com.sec.chaton.p027e.p028a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.C1456x;
import com.sec.chaton.p027e.C1457y;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: ParticipantDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.y */
/* loaded from: classes.dex */
public class C1381y {
    /* renamed from: a */
    public static boolean m6211a(ContentResolver contentResolver, String str, String str2) {
        Cursor cursorQuery = contentResolver.query(C1457y.f5415a, null, "participants_inbox_no=? AND participants_buddy_no=?", new String[]{str2, str}, null);
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
    public static String m6215b(ContentResolver contentResolver, String str, String str2) {
        return m6223f(contentResolver, str, str2);
    }

    /* renamed from: a */
    public static ContentProviderOperation m6206a(String str, String str2) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C1457y.f5415a);
        builderNewInsert.withValue("participants_buddy_no", str2);
        builderNewInsert.withValue("participants_inbox_no", str);
        builderNewInsert.withValue("participants_buddy_name", GlobalApplication.m6451b().getString(R.string.unknown));
        return builderNewInsert.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m6213b(String str, String str2) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C1457y.f5415a);
        builderNewDelete.withSelection("participants_inbox_no=? AND participants_buddy_no=?", new String[]{str, str2});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6204a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C1457y.f5415a);
        builderNewDelete.withSelection("participants_inbox_no=?", new String[]{str});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6207a(String str, String str2, String str3) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C1457y.f5415a);
        builderNewInsert.withValue("participants_buddy_no", str2);
        builderNewInsert.withValue("participants_inbox_no", str);
        builderNewInsert.withValue("participants_buddy_name", str3);
        return builderNewInsert.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m6214b(String str, String str2, String str3) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C1457y.f5415a);
        builderNewUpdate.withSelection("participants_inbox_no=? AND participants_buddy_no=?", new String[]{str, str2});
        builderNewUpdate.withValue("participants_buddy_no", str3);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6208a(String str, String str2, String str3, boolean z, int i) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C1457y.f5415a);
        builderNewUpdate.withSelection("participants_buddy_no=?", new String[]{str});
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_buddy_name", str2);
        contentValues.put("participants_country_code", str3);
        contentValues.put("participants_is_auth", z ? "Y" : "N");
        contentValues.put("participants_status", Integer.valueOf(i));
        builderNewUpdate.withValues(contentValues);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6205a(String str, int i) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C1457y.f5415a);
        builderNewUpdate.withSelection("participants_buddy_no = ? ", new String[]{str});
        ContentValues contentValues = new ContentValues();
        if (i == 0) {
            contentValues.put("participants_country_code", "");
            contentValues.put("participants_is_auth", "");
        }
        contentValues.put("participants_status", Integer.valueOf(i));
        builderNewUpdate.withValues(contentValues);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static Cursor m6209a(ContentResolver contentResolver, String str) {
        return contentResolver.query(C1457y.m6367a(str), null, null, null, null);
    }

    /* renamed from: c */
    public static Uri m6216c(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_buddy_no", str2);
        contentValues.put("participants_inbox_no", str);
        contentValues.put("participants_buddy_name", m6215b(contentResolver, str2, (String) null));
        return contentResolver.insert(C1457y.f5415a, contentValues);
    }

    /* renamed from: a */
    public static Uri m6210a(ContentResolver contentResolver, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_inbox_no", str);
        contentValues.put("participants_buddy_no", str2);
        contentValues.put("participants_buddy_name", str3);
        return contentResolver.insert(C1457y.f5415a, contentValues);
    }

    /* renamed from: d */
    public static void m6219d(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_inbox_no", "");
        contentResolver.update(C1457y.f5415a, contentValues, "participants_inbox_no=? AND participants_buddy_no=?", new String[]{str, str2});
    }

    /* renamed from: e */
    public static String m6220e(ContentResolver contentResolver, String str, String str2) {
        return m6222f(contentResolver, str2);
    }

    /* renamed from: b */
    public static int m6212b(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C1457y.f5415a, new String[]{"COUNT (*) AS cnt"}, "participants_inbox_no=?", new String[]{str}, null);
        if (cursorQuery == null) {
            return 0;
        }
        int columnIndex = cursorQuery.getColumnIndex("cnt");
        int i = 0;
        while (cursorQuery.moveToNext()) {
            if (!cursorQuery.isNull(columnIndex)) {
                i = cursorQuery.getInt(columnIndex);
            }
        }
        cursorQuery.close();
        return i;
    }

    /* renamed from: c */
    public static String[] m6217c(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C1457y.f5415a, null, "participants_inbox_no=?", new String[]{str}, "buddy_name");
        if (cursorQuery == null || cursorQuery.getCount() == 0) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
        int columnIndex = cursorQuery.getColumnIndex("participants_buddy_no");
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                if (!cursorQuery.isNull(columnIndex)) {
                    arrayList.add(cursorQuery.getString(columnIndex));
                }
            }
            cursorQuery.close();
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b A[DONT_GENERATE, PHI: r0
  0x002b: PHI (r0v6 java.util.ArrayList<java.lang.String>) = (r0v3 java.util.ArrayList<java.lang.String>), (r0v7 java.util.ArrayList<java.lang.String>) binds: [B:23:0x0050, B:9:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001f  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<java.lang.String> m6218d(android.content.ContentResolver r6, java.lang.String r7) {
        /*
            android.net.Uri r1 = com.sec.chaton.p027e.C1457y.f5415a
            r2 = 0
            java.lang.String r3 = "participants_inbox_no=?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]
            r0 = 0
            r4[r0] = r7
            java.lang.String r5 = "buddy_name"
            r0 = r6
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r1 == 0) goto L1f
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> L49
            if (r2 != 0) goto L2f
        L1f:
            if (r1 == 0) goto L24
            r1.close()     // Catch: java.lang.Throwable -> L49
        L24:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L49
            r0.<init>()     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L2e
        L2b:
            r1.close()
        L2e:
            return r0
        L2f:
            java.lang.String r2 = "participants_buddy_no"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L49
        L35:
            boolean r3 = r1.moveToNext()     // Catch: java.lang.Throwable -> L49
            if (r3 == 0) goto L50
            boolean r3 = r1.isNull(r2)     // Catch: java.lang.Throwable -> L49
            if (r3 != 0) goto L35
            java.lang.String r3 = r1.getString(r2)     // Catch: java.lang.Throwable -> L49
            r0.add(r3)     // Catch: java.lang.Throwable -> L49
            goto L35
        L49:
            r0 = move-exception
            if (r1 == 0) goto L4f
            r1.close()
        L4f:
            throw r0
        L50:
            if (r1 == 0) goto L2e
            goto L2b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p027e.p028a.C1381y.m6218d(android.content.ContentResolver, java.lang.String):java.util.ArrayList");
    }

    /* renamed from: f */
    public static String m6223f(ContentResolver contentResolver, String str, String str2) throws Resources.NotFoundException {
        String string;
        String string2 = GlobalApplication.m6451b().getString(R.string.unknown);
        Cursor cursorQuery = contentResolver.query(C1457y.m6366a(), null, "buddy_no=?", new String[]{str}, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            string = string2;
        } else {
            string = string2;
            while (cursorQuery.moveToNext()) {
                string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"));
                if (TextUtils.isEmpty(string)) {
                    string = string2;
                }
                if (!string2.equals(string)) {
                    break;
                }
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return (!string.equals(string2) || TextUtils.isEmpty(str2)) ? string : str2;
    }

    /* renamed from: g */
    public static String m6224g(ContentResolver contentResolver, String str, String str2) {
        boolean z;
        String string;
        Cursor cursorQuery = contentResolver.query(C1457y.m6366a(), null, "buddy_no=?", new String[]{str2}, null);
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
            C3250y.m11450b("can't find participant name", "[ParticipantDatabaseHelper-getUnknownBuddyName]");
            z = false;
            string = "";
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return z ? string : "";
    }

    /* renamed from: e */
    public static ArrayList<String> m6221e(ContentResolver contentResolver, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor cursorQuery = contentResolver.query(C1457y.f5415a, new String[]{"participants_buddy_no"}, "participants_inbox_no= ? and participants_buddy_no not in ( select buddy_no from buddy )", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
                C3250y.m11450b("unknownParticipants : " + cursorQuery.getString(0), "[ParticipantDatabaseHelper]");
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    /* renamed from: f */
    public static String m6222f(ContentResolver contentResolver, String str) {
        return m6223f(contentResolver, str, null);
    }

    /* renamed from: g */
    public static ArrayList<String> m6225g(ContentResolver contentResolver, String str) {
        ArrayList<String> arrayList = null;
        Cursor cursorQuery = contentResolver.query(C1457y.f5415a, new String[]{"participants_inbox_no"}, "participants_buddy_no=? AND participants_inbox_no IN ( SELECT inbox_no FROM inbox WHERE inbox_chat_type = ? OR inbox_chat_type = ?)", new String[]{str, String.valueOf(EnumC1450r.BROADCAST.m6342a()), String.valueOf(EnumC1450r.BROADCAST2.m6342a())}, null);
        if (cursorQuery != null) {
            arrayList = new ArrayList<>();
            while (cursorQuery.moveToNext()) {
                if (!TextUtils.isEmpty(cursorQuery.getString(0))) {
                    arrayList.add(cursorQuery.getString(0));
                }
            }
            cursorQuery.close();
        }
        return arrayList;
    }

    /* renamed from: h */
    public static ContentProviderOperation m6226h(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        Uri uri = C1456x.f5414a;
        contentValues.put("participants_buddy_no", str2);
        contentValues.put("participants_old_buddy_no", str);
        return ContentProviderOperation.newInsert(uri).withValues(contentValues).build();
    }

    /* renamed from: h */
    public static String m6227h(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C1456x.f5414a, new String[]{"participants_buddy_no"}, "participants_old_buddy_no=?", new String[]{str}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    String string = cursorQuery.getString(0);
                    if (C3250y.f11735c) {
                        C3250y.m11453c("old :" + str + ",current:" + string, "[ParticipantDatabaseHelper-getCurrentParticipantNo]");
                    }
                    str = string;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return str;
    }
}
