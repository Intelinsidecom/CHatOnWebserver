package com.sec.chaton.p027e.p028a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p019a.C0513c;
import com.sec.chaton.buddy.p019a.C0514d;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.C1390ah;
import com.sec.chaton.p027e.C1441i;
import com.sec.chaton.p027e.C1445m;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.p035io.entry.inner.BuddyProfile;
import com.sec.chaton.util.C3178at;
import com.sec.chaton.util.C3180av;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/* compiled from: BuddyDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.d */
/* loaded from: classes.dex */
public class C1360d {
    /* renamed from: i */
    private static C1361e m6055i(ContentResolver contentResolver, String str) {
        C1361e c1361e = new C1361e();
        Cursor cursorQuery = contentResolver.query(C1441i.f5369a, null, "buddy_no='" + str + "'", null, null);
        if (cursorQuery != null && cursorQuery.getCount() != 0 && cursorQuery.moveToFirst()) {
            if (cursorQuery.getString(cursorQuery.getColumnIndex("buddy_is_name_updated")).equals("Y")) {
                c1361e.f5106a = true;
            } else {
                c1361e.f5106a = false;
            }
            if (cursorQuery.getString(cursorQuery.getColumnIndex("buddy_using_contact_name")).equals("Y")) {
                c1361e.f5107b = true;
            } else {
                c1361e.f5107b = false;
            }
            c1361e.f5108c = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_push_name"));
            c1361e.f5109d = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_orginal_numbers"));
            c1361e.f5110e = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_original_name"));
            c1361e.f5111f = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_status_message"));
            c1361e.f5112g = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_msisdns"));
            c1361e.f5113h = cursorQuery.getInt(cursorQuery.getColumnIndex("buddy_show_phone_number"));
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return c1361e;
    }

    /* renamed from: a */
    public static boolean m6032a(ContentResolver contentResolver, String str) {
        boolean z;
        Cursor cursorQuery = contentResolver.query(C1441i.f5369a, null, "buddy_raw_contact_id='" + str + "'", null, null);
        if (cursorQuery == null || cursorQuery.getCount() == 0 || !cursorQuery.moveToFirst() || !cursorQuery.getString(cursorQuery.getColumnIndex("buddy_is_name_updated")).equals("Y")) {
            z = false;
        } else {
            z = true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return z;
    }

    /* renamed from: a */
    public static int m6017a(ContentResolver contentResolver, String str, String str2) {
        String strM6044c = m6044c(str2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_name", str2);
        contentValues.put("buddy_is_name_updated", "Y");
        contentValues.put("buddy_hanzitopinyin", strM6044c);
        try {
            return contentResolver.update(C1441i.f5369a, contentValues, "buddy_no = ? ", new String[]{str});
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: a */
    public static void m6027a(ContentResolver contentResolver) {
        Cursor cursorQuery;
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        try {
            cursorQuery = contentResolver.query(C1441i.f5369a, null, null, null, null);
            if (cursorQuery == null) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                    return;
                }
                return;
            }
            try {
                cursorQuery.moveToPosition(-1);
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no"));
                    String strM6044c = m6044c(string);
                    ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C1441i.f5369a);
                    builderNewUpdate.withSelection("buddy_no=?", new String[]{string2});
                    builderNewUpdate.withValue("buddy_hanzitopinyin", strM6044c);
                    arrayList.add(builderNewUpdate.build());
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
            } catch (Throwable th) {
                th = th;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: b */
    public static void m6038b(ContentResolver contentResolver, String str, String str2) {
        String strM6044c = m6044c(str);
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_hanzitopinyin", strM6044c);
        try {
            contentResolver.update(C1441i.f5369a, contentValues, "buddy_no = ? ", new String[]{str2});
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public static String m6037b(ContentResolver contentResolver, String str) {
        Cursor cursorM6049e = null;
        try {
            cursorM6049e = m6049e(contentResolver, str);
            if (cursorM6049e != null && cursorM6049e.getCount() != 0 && cursorM6049e.moveToFirst()) {
                str = cursorM6049e.getString(cursorM6049e.getColumnIndex("buddy_name"));
            }
            return str;
        } finally {
            if (cursorM6049e != null) {
                cursorM6049e.close();
            }
        }
    }

    /* renamed from: c */
    public static String m6043c(ContentResolver contentResolver, String str) {
        String string = "";
        Cursor cursorM6049e = null;
        try {
            cursorM6049e = m6049e(contentResolver, str);
            if (cursorM6049e != null && cursorM6049e.getCount() != 0 && cursorM6049e.moveToFirst()) {
                string = cursorM6049e.getString(cursorM6049e.getColumnIndex("buddy_extra_info"));
            }
            return string;
        } finally {
            if (cursorM6049e != null) {
                cursorM6049e.close();
            }
        }
    }

    /* renamed from: d */
    public static String m6046d(ContentResolver contentResolver, String str) {
        String string = "";
        Cursor cursorM6049e = null;
        try {
            cursorM6049e = m6049e(contentResolver, str);
            if (cursorM6049e != null && cursorM6049e.getCount() != 0 && cursorM6049e.moveToFirst()) {
                string = cursorM6049e.getString(cursorM6049e.getColumnIndex("buddy_sainfo"));
            }
            return string;
        } finally {
            if (cursorM6049e != null) {
                cursorM6049e.close();
            }
        }
    }

    /* renamed from: a */
    public static String m6025a(String str) {
        String string = null;
        Cursor cursorQuery = GlobalApplication.m11493l().getContentResolver().query(C1441i.f5369a, null, "buddy_orginal_number LIKE ? OR buddy_orginal_numbers LIKE ? OR buddy_orginal_numbers LIKE ? OR buddy_orginal_numbers LIKE ? OR buddy_orginal_numbers LIKE ?", new String[]{str, str, str + "|%", "%|" + str + "|%", "%|" + str}, null);
        if (cursorQuery != null && cursorQuery.getCount() != 0 && cursorQuery.moveToFirst()) {
            string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no"));
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return string;
    }

    /* renamed from: a */
    public static void m6029a(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        try {
            cursorQuery = sQLiteDatabase.query("buddy", null, null, null, null, null, null);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("buddy_birthday", "");
                if (cursorQuery != null && cursorQuery.getCount() != 0) {
                    cursorQuery.moveToFirst();
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no"));
                        if ("0000-12-31".equals(cursorQuery.getString(cursorQuery.getColumnIndex("buddy_birthday")))) {
                            sQLiteDatabase.update("buddy", contentValues, "buddy_no=?", new String[]{string});
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                th = th;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: a */
    public static boolean m6033a(ContentResolver contentResolver, String[] strArr, Map<String, String> map) throws Resources.NotFoundException {
        boolean z = false;
        String string = GlobalApplication.m6451b().getString(R.string.unknown);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append("'").append(strArr[i]).append("'");
            if (i < strArr.length - 1) {
                sb.append(", ");
            }
            map.put(strArr[i], string);
        }
        Cursor cursorQuery = contentResolver.query(C1441i.f5369a, new String[]{"buddy_no", "buddy_name"}, "buddy_no IN ( " + sb.toString() + " )", null, null);
        if (cursorQuery != null && cursorQuery.getCount() != 0) {
            while (cursorQuery.moveToNext()) {
                map.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            z = true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return z;
    }

    /* renamed from: e */
    public static Cursor m6049e(ContentResolver contentResolver, String str) {
        return contentResolver.query(C1441i.m6306a(str), null, null, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m6034b(android.content.ContentResolver r8) {
        /*
            r7 = 0
            r6 = 0
            android.net.Uri r1 = com.sec.chaton.p027e.C1441i.f5369a     // Catch: java.lang.Exception -> L2b java.lang.Throwable -> L3d
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L2b java.lang.Throwable -> L3d
            r0 = 0
            java.lang.String r3 = "COUNT(*)"
            r2[r0] = r3     // Catch: java.lang.Exception -> L2b java.lang.Throwable -> L3d
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L2b java.lang.Throwable -> L3d
            if (r1 != 0) goto L1c
            if (r1 == 0) goto L1b
            r1.close()
        L1b:
            return r6
        L1c:
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            r0 = 0
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            if (r1 == 0) goto L29
            r1.close()
        L29:
            r6 = r0
            goto L1b
        L2b:
            r0 = move-exception
            r1 = r7
        L2d:
            java.lang.String r2 = "getBuddyCount"
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L45
            com.sec.chaton.util.C3250y.m11442a(r2, r0)     // Catch: java.lang.Throwable -> L45
            if (r1 == 0) goto L3b
            r1.close()
        L3b:
            r0 = r6
            goto L29
        L3d:
            r0 = move-exception
            r1 = r7
        L3f:
            if (r1 == 0) goto L44
            r1.close()
        L44:
            throw r0
        L45:
            r0 = move-exception
            goto L3f
        L47:
            r0 = move-exception
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p027e.p028a.C1360d.m6034b(android.content.ContentResolver):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m6041c(android.content.ContentResolver r8) {
        /*
            r7 = 0
            r6 = 0
            android.net.Uri r1 = com.sec.chaton.p027e.C1441i.f5369a     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3e
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3e
            r0 = 0
            java.lang.String r3 = "COUNT(*)"
            r2[r0] = r3     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3e
            java.lang.String r3 = "buddy_is_hide = 'Y' "
            r4 = 0
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3e
            if (r1 != 0) goto L1d
            if (r1 == 0) goto L1c
            r1.close()
        L1c:
            return r6
        L1d:
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L48
            r0 = 0
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L48
            if (r1 == 0) goto L2a
            r1.close()
        L2a:
            r6 = r0
            goto L1c
        L2c:
            r0 = move-exception
            r1 = r7
        L2e:
            java.lang.String r2 = "getBuddyCount"
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L45
            com.sec.chaton.util.C3250y.m11442a(r2, r0)     // Catch: java.lang.Throwable -> L45
            if (r1 == 0) goto L3c
            r1.close()
        L3c:
            r0 = r6
            goto L2a
        L3e:
            r0 = move-exception
        L3f:
            if (r7 == 0) goto L44
            r7.close()
        L44:
            throw r0
        L45:
            r0 = move-exception
            r7 = r1
            goto L3f
        L48:
            r0 = move-exception
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p027e.p028a.C1360d.m6041c(android.content.ContentResolver):int");
    }

    /* renamed from: a */
    public static ContentProviderOperation m6018a(ContentResolver contentResolver, C0514d c0514d) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C1390ah.f5188a);
        builderNewUpdate.withSelection("buddy_no='" + c0514d.m4000a() + "'", null);
        builderNewUpdate.withValue("msgstatus", c0514d.m4005f());
        builderNewUpdate.withValue("description", c0514d.m4002c());
        builderNewUpdate.withValue("followcount", c0514d.m4003d());
        builderNewUpdate.withValue("likecount", c0514d.m4004e());
        builderNewUpdate.withValue("status", c0514d.m4007h());
        builderNewUpdate.withValue("url", c0514d.m4008i());
        builderNewUpdate.withValue("weburl", c0514d.m4009j());
        builderNewUpdate.withValue("photoloaded", c0514d.m4006g().equals(Buddy.BuddyImageStatus.NONE_PROFILE) ? "N" : "Y");
        return builderNewUpdate.build();
    }

    /* renamed from: d */
    private static String m6047d(String str) {
        String strTrim = null;
        if (!TextUtils.isEmpty(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
            while (stringTokenizer.hasMoreTokens()) {
                String strM6081b = C1363g.m6081b(stringTokenizer.nextToken());
                if (strM6081b != null) {
                    if (strTrim == null) {
                        strTrim = strM6081b.trim();
                    } else if (strM6081b.trim().compareToIgnoreCase(strTrim.trim()) < 0) {
                        strTrim = strM6081b.trim();
                    }
                }
            }
        }
        return strTrim;
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x03c6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x04f1  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.ContentProviderOperation m6019a(com.sec.chaton.p035io.entry.inner.Buddy r10) {
        /*
            Method dump skipped, instructions count: 1274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p027e.p028a.C1360d.m6019a(com.sec.chaton.io.entry.inner.Buddy):android.content.ContentProviderOperation");
    }

    /* renamed from: b */
    public static ContentProviderOperation m6035b(Buddy buddy) {
        C3250y.m11458g("[deleteBuddy] Buddy.value = " + buddy.value, "BuddyDatabaseHelper");
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C1441i.f5369a);
        builderNewDelete.withSelection("buddy_no = ?", new String[]{buddy.value});
        return builderNewDelete.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m6036b(String str) {
        C3250y.m11458g("[deleteBuddy] Buddy.value = " + str, "BuddyDatabaseHelper");
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C1441i.f5369a);
        builderNewDelete.withSelection("buddy_no = ?", new String[]{str});
        return builderNewDelete.build();
    }

    /* renamed from: c */
    public static ContentProviderOperation m6042c(Buddy buddy) {
        C3250y.m11458g("[deleteSpecialBuddy] Specialuserid : " + buddy.value, "BuddyDatabaseHelper");
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C1390ah.f5188a);
        builderNewDelete.withSelection("buddy_no = ?", new String[]{buddy.value});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6022a(String str, String str2) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C1441i.f5369a);
        builderNewUpdate.withSelection("buddy_orginal_number LIKE ? OR buddy_orginal_numbers LIKE ? OR buddy_orginal_numbers LIKE ? OR buddy_orginal_numbers LIKE ? OR buddy_orginal_numbers LIKE ?", new String[]{str, str, str + "|%", "%|" + str + "|%", "%|" + str});
        builderNewUpdate.withValue("buddy_name", str2);
        builderNewUpdate.withValue("buddy_using_contact_name", "Y");
        builderNewUpdate.withValue("buddy_hanzitopinyin", m6044c(str2));
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6021a(String str, BuddyProfile buddyProfile) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C1441i.f5369a);
        builderNewUpdate.withSelection("buddy_no=?", new String[]{str});
        builderNewUpdate.withValue("buddy_profile_status", Integer.valueOf(buddyProfile.getImagestatus().getCode()));
        if (!TextUtils.isEmpty(buddyProfile.birthday)) {
            if ("0000-12-31".equals(buddyProfile.birthday)) {
                builderNewUpdate.withValue("buddy_birthday", "");
            } else {
                builderNewUpdate.withValue("buddy_birthday", buddyProfile.birthday);
            }
        }
        if (!TextUtils.isEmpty(buddyProfile.timestamp)) {
            builderNewUpdate.withValue("buddy_updated_timestamp", buddyProfile.timestamp);
        }
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6020a(String str, Buddy buddy, long j) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C1441i.f5369a);
        builderNewUpdate.withSelection("buddy_no=?", new String[]{str});
        builderNewUpdate.withValue("buddy_profile_status", Integer.valueOf(buddy.getImagestatus().getCode()));
        if (!TextUtils.isEmpty(buddy.birthday)) {
            if ("0000-12-31".equals(buddy.birthday)) {
                builderNewUpdate.withValue("buddy_birthday", "");
            } else {
                builderNewUpdate.withValue("buddy_birthday", buddy.birthday);
            }
        }
        if (!TextUtils.isEmpty(Long.toString(j))) {
            builderNewUpdate.withValue("buddy_updated_timestamp", Long.toString(j));
        }
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6023a(String str, String str2, String str3, String str4) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C1441i.f5369a);
        boolean zM6032a = m6032a(GlobalApplication.m6447a().getContentResolver(), str);
        String strM6044c = null;
        builderNewUpdate.withSelection("buddy_raw_contact_id=?", new String[]{str});
        builderNewUpdate.withSelection("buddy_no=?", new String[]{str2});
        if (!zM6032a) {
            if (!TextUtils.isEmpty(str4)) {
                builderNewUpdate.withValue("buddy_name", str4);
                strM6044c = m6044c(str4);
            } else {
                builderNewUpdate.withValue("buddy_name", str3);
                strM6044c = m6044c(str3);
            }
        }
        builderNewUpdate.withValue("buddy_using_contact_name", "N");
        builderNewUpdate.withValue("buddy_raw_contact_id", 0);
        builderNewUpdate.withValue("buddy_hanzitopinyin", strM6044c);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static void m6028a(ContentResolver contentResolver, C0513c c0513c, boolean z) {
        try {
            contentResolver.delete(C1445m.f5377a, "group_relation_buddy = ? ", new String[]{c0513c.m3975b()});
            contentResolver.delete(C1441i.f5369a, "buddy_no = ? ", new String[]{c0513c.m3975b()});
            contentResolver.delete(C1390ah.f5188a, "buddy_no = ? ", new String[]{c0513c.m3975b()});
            C3250y.m11450b(c0513c.m3975b() + ":" + z, "BuddyDatabaseHelper");
        } catch (Exception e) {
        }
    }

    /* renamed from: f */
    public static ContentProviderOperation m6052f(ContentResolver contentResolver, String str) {
        ContentProviderOperation.Builder builderNewUpdate;
        if (str.startsWith("0999")) {
            builderNewUpdate = ContentProviderOperation.newUpdate(C1390ah.f5188a);
            builderNewUpdate.withSelection("buddy_no=?", new String[]{str});
            builderNewUpdate.withValue("is_hide", "N");
            C3250y.m11450b("unHide BuddyNo : " + str, "BuddyDatabaseHelper");
        } else {
            builderNewUpdate = ContentProviderOperation.newUpdate(C1441i.f5369a);
            builderNewUpdate.withSelection("buddy_no=?", new String[]{str});
            builderNewUpdate.withValue("buddy_is_hide", "N");
            C3250y.m11450b("unHide BuddyNo : " + str, "BuddyDatabaseHelper");
        }
        return builderNewUpdate.build();
    }

    /* renamed from: g */
    public static ContentProviderOperation m6053g(ContentResolver contentResolver, String str) {
        ContentProviderOperation.Builder builderNewUpdate;
        if (str.startsWith("0999")) {
            builderNewUpdate = ContentProviderOperation.newUpdate(C1390ah.f5188a);
            builderNewUpdate.withSelection("buddy_no=?", new String[]{str});
            builderNewUpdate.withValue("is_hide", "Y");
            C3250y.m11450b("hide BuddyNo : " + str, "BuddyDatabaseHelper");
        } else {
            builderNewUpdate = ContentProviderOperation.newUpdate(C1441i.f5369a);
            builderNewUpdate.withSelection("buddy_no=?", new String[]{str});
            builderNewUpdate.withValue("buddy_is_hide", "Y");
            C3250y.m11450b("hide BuddyNo : " + str, "BuddyDatabaseHelper");
        }
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static Cursor m6024a(ContentResolver contentResolver, C0513c c0513c) {
        try {
            return contentResolver.query(C1449q.f5381a, new String[]{"inbox_no", "inbox_session_id"}, "inbox_no = ? AND inbox_chat_type = ? ", new String[]{c0513c.m3975b(), String.valueOf(EnumC1450r.ONETOONE.m6342a())}, null);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: h */
    public static boolean m6054h(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C1441i.f5369a, new String[]{"COUNT(*)"}, "buddy_no = ?", new String[]{str}, null);
        if (cursorQuery == null) {
            return false;
        }
        cursorQuery.moveToFirst();
        int i = cursorQuery.getInt(0);
        if (!cursorQuery.isClosed()) {
            cursorQuery.close();
        }
        return i > 0;
    }

    /* renamed from: b */
    public static void m6039b(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        try {
            cursorQuery = sQLiteDatabase.query("buddy", null, null, null, null, null, null);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("buddy_show_phone_number", (Integer) 0);
                if (cursorQuery != null && cursorQuery.getCount() != 0) {
                    cursorQuery.moveToFirst();
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no"));
                        if (string.startsWith("0")) {
                            sQLiteDatabase.update("buddy", contentValues, "buddy_no=?", new String[]{string});
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                th = th;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: d */
    public static void m6048d(ContentResolver contentResolver) throws Throwable {
        Cursor cursor;
        ArrayList<ContentProviderOperation> arrayList;
        Cursor cursorQuery;
        try {
            arrayList = new ArrayList<>();
            cursorQuery = contentResolver.query(C1441i.f5369a, null, null, null, null);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        try {
            HashMap<String, String> mapM11106a = C3178at.m11106a(cursorQuery.getCount());
            Iterator<String> it = mapM11106a.keySet().iterator();
            if (cursorQuery != null && cursorQuery.getCount() != 0) {
                cursorQuery.moveToFirst();
                while (cursorQuery.moveToNext() && it.hasNext()) {
                    String next = it.next();
                    String str = mapM11106a.get(next);
                    C3250y.m11453c("key : " + next + ", values : " + str, null);
                    try {
                        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C1441i.f5369a);
                        builderNewUpdate.withSelection("buddy_no=?", new String[]{cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no"))});
                        builderNewUpdate.withValue("buddy_name", next);
                        builderNewUpdate.withValue("buddy_status_message", str);
                        builderNewUpdate.withValue("buddy_hanzitopinyin", str.toLowerCase());
                        arrayList.add(builderNewUpdate.build());
                    } catch (Exception e) {
                    }
                }
            }
            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: e */
    public static HashMap<String, String> m6051e(ContentResolver contentResolver) throws Throwable {
        Cursor cursorQuery;
        HashMap<String, String> map = new HashMap<>();
        try {
            cursorQuery = contentResolver.query(C1441i.f5369a, new String[]{"buddy_no", "buddy_extra_info", "buddy_sainfo"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_extra_info"));
                        if (!TextUtils.isEmpty(cursorQuery.getString(cursorQuery.getColumnIndex("buddy_sainfo"))) && !TextUtils.isEmpty(string) && string.contains("voip=1")) {
                            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no"));
                            map.put(string2, string2);
                        }
                    }
                    cursorQuery.close();
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return map;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: c */
    public static String m6044c(String str) {
        if (!C3178at.m11103a().m11118c(str)) {
            return str;
        }
        ArrayList<C3180av> arrayListM11117a = C3178at.m11103a().m11117a(str);
        String str2 = "";
        int i = 0;
        while (i < arrayListM11117a.size()) {
            String str3 = str2 + arrayListM11117a.get(i).f11519c.toLowerCase();
            i++;
            str2 = str3;
        }
        return str2;
    }

    /* renamed from: a */
    public static ArrayList<String> m6026a() throws Throwable {
        Cursor cursorQuery;
        ContentResolver contentResolver = GlobalApplication.m11493l().getContentResolver();
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            cursorQuery = contentResolver.query(C1441i.f5369a, new String[]{"buddy_no"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() != 0) {
                        cursorQuery.moveToFirst();
                        do {
                            arrayList.add(cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no")));
                        } while (cursorQuery.moveToNext());
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: a */
    public static void m6031a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ArrayList arrayList3 = new ArrayList();
        C3250y.m11450b("compareBuddyNumberAndDeleteZombieBuddy() buddyNoList.size() = " + arrayList.size(), "BuddyDatabaseHelper");
        C3250y.m11450b("compareBuddyNumberAndDeleteZombieBuddy() buddyNoInMyDb.size() = " + arrayList2.size(), "BuddyDatabaseHelper");
        if (arrayList.size() >= 1) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                if (!arrayList2.contains(arrayList.get(i2).toString())) {
                    arrayList3.add(arrayList.get(i2).toString());
                } else {
                    arrayList2.remove(arrayList.get(i2).toString());
                }
                i = i2 + 1;
            }
            C3250y.m11450b("compareBuddyNumberAndDeleteZombieBuddy() buddyNoDelta.size() = " + arrayList3.size(), "BuddyDatabaseHelper");
            try {
                if (arrayList3.size() > 0) {
                    m6030a((ArrayList<String>) arrayList3);
                }
            } catch (OperationApplicationException e) {
                e.printStackTrace();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m6030a(ArrayList<String> arrayList) throws RemoteException, OperationApplicationException {
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                arrayList2.add(m6036b(arrayList.get(i2).toString()));
                i = i2 + 1;
            } else {
                GlobalApplication.m6447a().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList2);
                return;
            }
        }
    }

    /* renamed from: e */
    private static String m6050e(String str) {
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.length() >= 19 && strNextToken.startsWith("10")) {
                    C3250y.m11450b("getPhonNumberByMsisdns() chaton id : " + strNextToken, "BuddyDatabaseHelper");
                } else if (strNextToken.startsWith("0")) {
                    C3250y.m11450b("getPhonNumberByMsisdns() pin number : " + strNextToken, "BuddyDatabaseHelper");
                } else {
                    C3250y.m11450b("getPhonNumberByMsisdns() PhonNumber: " + strNextToken, "BuddyDatabaseHelper");
                    str2 = str2 + "+" + strNextToken + " ";
                }
            }
        }
        return str2;
    }

    /* renamed from: b */
    private static boolean m6040b(String str, String str2) {
        return str.length() >= 19 && str.startsWith("10") && !TextUtils.isEmpty(str2);
    }

    /* renamed from: c */
    public static void m6045c(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        try {
            cursorQuery = sQLiteDatabase.query("buddy", null, null, null, null, null, null);
            try {
                ContentValues contentValues = new ContentValues();
                if (cursorQuery != null && cursorQuery.getCount() != 0) {
                    cursorQuery.moveToFirst();
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_msisdns"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_orginal_number"));
                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_multidevice"));
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndex("buddy_show_phone_number"));
                        if (string4.equals("Y")) {
                            contentValues.put("buddy_phonenumber_external_use", m6050e(string2));
                        } else if (i != 1) {
                            contentValues.put("buddy_phonenumber_external_use", "");
                        } else if (m6040b(string, string3)) {
                            contentValues.put("buddy_phonenumber_external_use", string3);
                        } else {
                            contentValues.put("buddy_phonenumber_external_use", "+" + string);
                        }
                        sQLiteDatabase.update("buddy", contentValues, "buddy_no=?", new String[]{string});
                    } while (cursorQuery.moveToNext());
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                th = th;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }
}
