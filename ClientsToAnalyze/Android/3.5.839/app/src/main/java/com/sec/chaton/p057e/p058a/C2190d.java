package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgbox.C2654bs;
import com.sec.chaton.p057e.C2230ar;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.p065io.entry.inner.BuddyPreviousData;
import com.sec.chaton.p065io.entry.inner.BuddyProfile;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4828at;
import com.sec.chaton.util.C4830av;
import com.sec.chaton.util.C4883f;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* compiled from: BuddyDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.d */
/* loaded from: classes.dex */
public class C2190d {
    /* renamed from: a */
    public static BuddyPreviousData m9807a(ContentResolver contentResolver, String str) throws Throwable {
        Cursor cursorQuery;
        BuddyPreviousData buddyPreviousData = new BuddyPreviousData();
        try {
            cursorQuery = contentResolver.query(C2289i.f8196a, null, "buddy_no='" + str + "'", null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() != 0 && cursorQuery.moveToFirst()) {
                        if (cursorQuery.getString(cursorQuery.getColumnIndex("buddy_is_name_updated")).equals("Y")) {
                            buddyPreviousData.isBuddyRenamed = true;
                        } else {
                            buddyPreviousData.isBuddyRenamed = false;
                        }
                        if (cursorQuery.getString(cursorQuery.getColumnIndex("buddy_using_contact_name")).equals("Y")) {
                            buddyPreviousData.isBuddyUsingContactName = true;
                        } else {
                            buddyPreviousData.isBuddyUsingContactName = false;
                        }
                        buddyPreviousData.buddyNickName = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_push_name"));
                        buddyPreviousData.oldOrgNums = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_orginal_numbers"));
                        buddyPreviousData.oldOrgName = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_original_name"));
                        buddyPreviousData.oldStatusMsg = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_status_message"));
                        buddyPreviousData.oldMsisdns = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_msisdns"));
                        buddyPreviousData.oldShowPhoneNum = cursorQuery.getInt(cursorQuery.getColumnIndex("buddy_show_phone_number"));
                        buddyPreviousData.oldPhoneNumberForExternal = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_phonenumber_external_use"));
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
            return buddyPreviousData;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m9823b(android.content.ContentResolver r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r6 = 0
            r7 = 0
            android.net.Uri r1 = com.sec.chaton.p057e.C2289i.f8196a     // Catch: java.lang.Throwable -> L50
            r2 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50
            r0.<init>()     // Catch: java.lang.Throwable -> L50
            java.lang.String r3 = "buddy_raw_contact_id='"
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L50
            java.lang.StringBuilder r0 = r0.append(r9)     // Catch: java.lang.Throwable -> L50
            java.lang.String r3 = "'"
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L50
            java.lang.String r3 = r0.toString()     // Catch: java.lang.Throwable -> L50
            r4 = 0
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L50
            if (r1 == 0) goto L5a
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L58
            if (r0 == 0) goto L5a
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L58
            if (r0 == 0) goto L5a
            java.lang.String r0 = "buddy_is_name_updated"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L58
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L58
            java.lang.String r2 = "Y"
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Throwable -> L58
            if (r0 == 0) goto L5a
            r0 = 1
        L4a:
            if (r1 == 0) goto L4f
            r1.close()
        L4f:
            return r0
        L50:
            r0 = move-exception
            r1 = r6
        L52:
            if (r1 == 0) goto L57
            r1.close()
        L57:
            throw r0
        L58:
            r0 = move-exception
            goto L52
        L5a:
            r0 = r7
            goto L4a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2190d.m9823b(android.content.ContentResolver, java.lang.String):boolean");
    }

    /* renamed from: a */
    public static int m9799a(ContentResolver contentResolver, String str, String str2) {
        String strM9828c = m9828c(str2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_name", str2);
        contentValues.put("buddy_is_name_updated", "Y");
        contentValues.put("buddy_hanzitopinyin", strM9828c);
        try {
            return contentResolver.update(C2289i.f8196a, contentValues, "buddy_no = ? ", new String[]{str});
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: b */
    public static void m9821b(ContentResolver contentResolver, String str, String str2) {
        String strM9828c = m9828c(str);
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_hanzitopinyin", strM9828c);
        try {
            contentResolver.update(C2289i.f8196a, contentValues, "buddy_no = ? ", new String[]{str2});
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    public static String m9827c(ContentResolver contentResolver, String str) {
        Cursor cursorM9843h = null;
        try {
            cursorM9843h = m9843h(contentResolver, str);
            if (cursorM9843h != null && cursorM9843h.getCount() != 0 && cursorM9843h.moveToFirst()) {
                str = cursorM9843h.getString(cursorM9843h.getColumnIndex("buddy_name"));
            }
            return str;
        } finally {
            if (cursorM9843h != null) {
                cursorM9843h.close();
            }
        }
    }

    /* renamed from: d */
    public static String m9833d(ContentResolver contentResolver, String str) throws Throwable {
        Cursor cursorM9843h;
        String string = null;
        try {
            cursorM9843h = m9843h(contentResolver, str);
            if (cursorM9843h != null) {
                try {
                    if (cursorM9843h.getCount() != 0 && cursorM9843h.moveToFirst()) {
                        string = cursorM9843h.getString(cursorM9843h.getColumnIndex("buddy_name"));
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorM9843h != null) {
                        cursorM9843h.close();
                    }
                    throw th;
                }
            }
            if (cursorM9843h != null) {
                cursorM9843h.close();
            }
            return string;
        } catch (Throwable th2) {
            th = th2;
            cursorM9843h = null;
        }
    }

    /* renamed from: e */
    public static String m9836e(ContentResolver contentResolver, String str) {
        String string = "";
        Cursor cursorM9843h = null;
        try {
            cursorM9843h = m9843h(contentResolver, str);
            if (cursorM9843h != null && cursorM9843h.getCount() != 0 && cursorM9843h.moveToFirst()) {
                string = cursorM9843h.getString(cursorM9843h.getColumnIndex("buddy_extra_info"));
            }
            return string;
        } finally {
            if (cursorM9843h != null) {
                cursorM9843h.close();
            }
        }
    }

    /* renamed from: f */
    public static String m9839f(ContentResolver contentResolver, String str) {
        String string = "";
        Cursor cursorM9843h = null;
        try {
            cursorM9843h = m9843h(contentResolver, str);
            if (cursorM9843h != null && cursorM9843h.getCount() != 0 && cursorM9843h.moveToFirst()) {
                string = cursorM9843h.getString(cursorM9843h.getColumnIndex("buddy_sainfo"));
            }
            return string;
        } finally {
            if (cursorM9843h != null) {
                cursorM9843h.close();
            }
        }
    }

    /* renamed from: a */
    public static String m9808a(String str) throws Throwable {
        Cursor cursorQuery;
        String string = null;
        if (C4904y.f17872b) {
            C4904y.m18639b("[getBuddyNoByOrgNumEightDigits] orgNum = " + str, "BuddyDatabaseHelper");
        }
        try {
            cursorQuery = GlobalApplication.m18732r().getContentResolver().query(C2289i.f8196a, null, "buddy_contact_buddy='0' AND ( buddy_phonenumber_external_use LIKE ? OR buddy_phonenumber_external_use LIKE ? )", new String[]{"%" + str.substring(str.length() - 8) + " %", "%" + str.substring(str.length() - 8)}, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() != 0 && cursorQuery.moveToFirst()) {
                        string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no"));
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
            return string;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: g */
    public static String m9841g(ContentResolver contentResolver, String str) {
        String string = "";
        Cursor cursorM9843h = null;
        try {
            cursorM9843h = m9843h(contentResolver, str);
            if (cursorM9843h != null && cursorM9843h.getCount() != 0 && cursorM9843h.moveToFirst()) {
                string = cursorM9843h.getString(cursorM9843h.getColumnIndex("buddy_phonenumber_external_use"));
            }
            return string;
        } finally {
            if (cursorM9843h != null) {
                cursorM9843h.close();
            }
        }
    }

    /* renamed from: a */
    public static void m9813a(SQLiteDatabase sQLiteDatabase) throws Throwable {
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
    public static boolean m9816a(ContentResolver contentResolver, String[] strArr, Map<String, String> map) throws Throwable {
        Cursor cursorQuery;
        boolean z = false;
        String string = GlobalApplication.m10283b().getString(R.string.unknown);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append("'").append(strArr[i]).append("'");
            if (i < strArr.length - 1) {
                sb.append(", ");
            }
            map.put(strArr[i], string);
        }
        try {
            cursorQuery = contentResolver.query(C2289i.f8196a, new String[]{"buddy_no", "buddy_name"}, "buddy_no IN ( " + sb.toString() + " )", null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() != 0) {
                        while (cursorQuery.moveToNext()) {
                            map.put(cursorQuery.getString(0), cursorQuery.getString(1));
                        }
                        z = true;
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
            return z;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: h */
    public static Cursor m9843h(ContentResolver contentResolver, String str) {
        return contentResolver.query(C2289i.m10161a(str), null, null, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m9798a(android.content.ContentResolver r8) throws java.lang.Throwable {
        /*
            r7 = 0
            r6 = 0
            android.net.Uri r1 = com.sec.chaton.p057e.C2289i.f8196a     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3f
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3f
            r0 = 0
            java.lang.String r3 = "COUNT(*)"
            r2[r0] = r3     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3f
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3f
            if (r1 != 0) goto L1d
            if (r1 == 0) goto L1c
            r1.close()
        L1c:
            return r6
        L1d:
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r0 = 0
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
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
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L47
            com.sec.chaton.util.C4904y.m18634a(r2, r0)     // Catch: java.lang.Throwable -> L47
            if (r1 == 0) goto L3d
            r1.close()
        L3d:
            r0 = r6
            goto L2a
        L3f:
            r0 = move-exception
            r1 = r7
        L41:
            if (r1 == 0) goto L46
            r1.close()
        L46:
            throw r0
        L47:
            r0 = move-exception
            goto L41
        L49:
            r0 = move-exception
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2190d.m9798a(android.content.ContentResolver):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m9817b(android.content.ContentResolver r8) throws java.lang.Throwable {
        /*
            r7 = 0
            r6 = 0
            android.net.Uri r1 = com.sec.chaton.p057e.C2289i.f8196a     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L41
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L41
            r0 = 0
            java.lang.String r3 = "COUNT(*)"
            r2[r0] = r3     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L41
            java.lang.String r3 = "buddy_is_hide = 'Y' "
            r4 = 0
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L41
            if (r1 != 0) goto L1f
            if (r1 == 0) goto L1e
            r1.close()
        L1e:
            return r6
        L1f:
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r0 = 0
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            if (r1 == 0) goto L2c
            r1.close()
        L2c:
            r6 = r0
            goto L1e
        L2e:
            r0 = move-exception
            r1 = r7
        L30:
            java.lang.String r2 = "getHideBuddyCount"
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L48
            com.sec.chaton.util.C4904y.m18634a(r2, r0)     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L3f
            r1.close()
        L3f:
            r0 = r6
            goto L2c
        L41:
            r0 = move-exception
        L42:
            if (r7 == 0) goto L47
            r7.close()
        L47:
            throw r0
        L48:
            r0 = move-exception
            r7 = r1
            goto L42
        L4b:
            r0 = move-exception
            goto L30
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2190d.m9817b(android.content.ContentResolver):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m9825c(android.content.ContentResolver r8) throws java.lang.Throwable {
        /*
            r7 = 0
            r6 = 0
            android.net.Uri r1 = com.sec.chaton.p057e.C2289i.f8196a     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L41
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L41
            r0 = 0
            java.lang.String r3 = "COUNT(*)"
            r2[r0] = r3     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L41
            java.lang.String r3 = "buddy_contact_buddy = '1' "
            r4 = 0
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L41
            if (r1 != 0) goto L1f
            if (r1 == 0) goto L1e
            r1.close()
        L1e:
            return r6
        L1f:
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r0 = 0
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            if (r1 == 0) goto L2c
            r1.close()
        L2c:
            r6 = r0
            goto L1e
        L2e:
            r0 = move-exception
            r1 = r7
        L30:
            java.lang.String r2 = "getContactBuddyCount"
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L48
            com.sec.chaton.util.C4904y.m18634a(r2, r0)     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L3f
            r1.close()
        L3f:
            r0 = r6
            goto L2c
        L41:
            r0 = move-exception
        L42:
            if (r7 == 0) goto L47
            r7.close()
        L47:
            throw r0
        L48:
            r0 = move-exception
            r7 = r1
            goto L42
        L4b:
            r0 = move-exception
            goto L30
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2190d.m9825c(android.content.ContentResolver):int");
    }

    /* renamed from: h */
    private static String m9844h(String str) {
        String strTrim = null;
        if (!TextUtils.isEmpty(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
            while (stringTokenizer.hasMoreTokens()) {
                String strM9879c = C2192f.m9879c(stringTokenizer.nextToken());
                if (strM9879c != null) {
                    if (strTrim == null) {
                        strTrim = strM9879c.trim();
                    } else if (strM9879c.trim().compareToIgnoreCase(strTrim.trim()) < 0) {
                        strTrim = strM9879c.trim();
                    }
                }
            }
        }
        return strTrim;
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x043d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x054a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.ContentProviderOperation m9802a(com.sec.chaton.p065io.entry.inner.Buddy r10, com.sec.chaton.p065io.entry.inner.BuddyPreviousData r11) {
        /*
            Method dump skipped, instructions count: 1357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2190d.m9802a(com.sec.chaton.io.entry.inner.Buddy, com.sec.chaton.io.entry.inner.BuddyPreviousData):android.content.ContentProviderOperation");
    }

    /* renamed from: a */
    public static String m9810a(boolean z, int i, Boolean bool, String str, String str2, String str3, String str4) {
        boolean z2 = true;
        if (z) {
            return m9809a(str, str4);
        }
        if (bool != null) {
            if (!bool.booleanValue()) {
                z2 = false;
            }
        } else if (i != 1) {
            z2 = false;
        }
        if (z2) {
            if (!TextUtils.isEmpty(str3)) {
                if (str3.length() >= 19 && str3.startsWith("10")) {
                    if (C4883f.m18539a(str2)) {
                        return "+" + str2;
                    }
                } else {
                    return str3;
                }
            } else if (C4883f.m18539a(str2)) {
                return "+" + str2;
            }
        }
        return "";
    }

    /* renamed from: a */
    private static String m9809a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str2, "|");
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.length() >= 19 && strNextToken.startsWith("10")) {
                    C4904y.m18639b("getPhonNumberByMsisdnsOrgNums() chaton id : " + strNextToken, "BuddyDatabaseHelper");
                } else {
                    C4904y.m18639b("getPhonNumberByMsisdnsOrgNums() PhonNumber: " + strNextToken, "BuddyDatabaseHelper");
                    arrayList.add(strNextToken);
                    arrayList2.add(strNextToken.substring(strNextToken.length() - 8));
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(str, "|");
            while (stringTokenizer2.hasMoreTokens()) {
                new String();
                String strNextToken2 = stringTokenizer2.nextToken();
                if (strNextToken2.length() >= 19 && strNextToken2.startsWith("10")) {
                    C4904y.m18639b("getPhonNumberByMsisdnsOrgNums() chaton id : " + strNextToken2, "BuddyDatabaseHelper");
                } else if (strNextToken2.startsWith(Spam.ACTIVITY_CANCEL)) {
                    C4904y.m18639b("getPhonNumberByMsisdnsOrgNums() pin number : " + strNextToken2, "BuddyDatabaseHelper");
                } else {
                    C4904y.m18639b("getPhonNumberByMsisdnsOrgNums() PhonNumber: " + strNextToken2, "BuddyDatabaseHelper");
                    String strSubstring = strNextToken2.substring(strNextToken2.length() - 8);
                    if (!arrayList2.contains(strSubstring)) {
                        arrayList.add("+" + strNextToken2);
                        arrayList2.add(strSubstring);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append((String) arrayList.get(i));
            if (i + 1 != arrayList.size()) {
                sb.append(" ");
            }
        }
        String string = sb.toString();
        if (string.endsWith(" ")) {
            string.substring(0, string.length() - 1);
        }
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0463  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.ContentProviderOperation m9801a(com.sec.chaton.p065io.entry.inner.Buddy r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1126
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2190d.m9801a(com.sec.chaton.io.entry.inner.Buddy):android.content.ContentProviderOperation");
    }

    /* renamed from: b */
    public static ContentProviderOperation m9818b(Buddy buddy) {
        String strTrim;
        String strTrim2;
        String strM9828c;
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2289i.f8196a);
        builderNewInsert.withValue("buddy_no", buddy.value);
        builderNewInsert.withValue("buddy_profile_status", Integer.valueOf(buddy.getImagestatus().getCode()));
        if (TextUtils.isEmpty(buddy.name)) {
            strTrim = null;
        } else {
            strTrim = buddy.name.trim();
            builderNewInsert.withValue("buddy_push_name", strTrim);
        }
        if (TextUtils.isEmpty(buddy.orgname)) {
            strTrim2 = null;
        } else {
            strTrim2 = buddy.orgname.trim();
            builderNewInsert.withValue("buddy_original_name", strTrim2);
        }
        if (strTrim != null && strTrim2 == null) {
            builderNewInsert.withValue("buddy_name", strTrim);
            strM9828c = m9828c(strTrim);
        } else if (strTrim != null || strTrim2 == null) {
            strM9828c = null;
        } else {
            builderNewInsert.withValue("buddy_name", strTrim2);
            strM9828c = m9828c(strTrim2);
        }
        if (buddy.showphonenumber != null) {
            builderNewInsert.withValue("buddy_show_phone_number", Integer.valueOf(buddy.showphonenumber.booleanValue() ? 1 : 0));
        }
        if (!TextUtils.isEmpty(buddy.orgnum)) {
            builderNewInsert.withValue("buddy_orginal_number", buddy.orgnum);
        } else {
            builderNewInsert.withValue("buddy_orginal_number", null);
        }
        if (!TextUtils.isEmpty(buddy.orgnums)) {
            builderNewInsert.withValue("buddy_orginal_numbers", buddy.orgnums);
        } else {
            builderNewInsert.withValue("buddy_orginal_numbers", null);
        }
        if (!TextUtils.isEmpty(buddy.birthday)) {
            if ("0000-12-31".equals(buddy.birthday)) {
                builderNewInsert.withValue("buddy_birthday", "");
            } else {
                builderNewInsert.withValue("buddy_birthday", buddy.birthday);
            }
        }
        if (!TextUtils.isEmpty(buddy.samsungemail)) {
            builderNewInsert.withValue("buddy_samsung_email", buddy.samsungemail);
        } else {
            builderNewInsert.withValue("buddy_samsung_email", null);
        }
        if (!TextUtils.isEmpty(buddy.email)) {
            builderNewInsert.withValue("buddy_email", buddy.email);
        }
        if (!TextUtils.isEmpty(strM9828c)) {
            builderNewInsert.withValue("buddy_hanzitopinyin", strM9828c);
        }
        return builderNewInsert.build();
    }

    /* renamed from: c */
    public static ContentProviderOperation m9826c(Buddy buddy) {
        C4904y.m18639b("[deleteBuddy] Buddy.value = " + buddy.value, "BuddyDatabaseHelper");
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2289i.f8196a);
        builderNewDelete.withSelection("buddy_no = ?", new String[]{buddy.value});
        return builderNewDelete.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m9819b(String str) {
        C4904y.m18639b("[deleteBuddy] Buddy.value = " + str, "BuddyDatabaseHelper");
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2289i.f8196a);
        builderNewDelete.withSelection("buddy_no = ?", new String[]{str});
        return builderNewDelete.build();
    }

    /* renamed from: d */
    public static ContentProviderOperation m9832d(Buddy buddy) {
        C4904y.m18639b("[deleteSpecialBuddy] Specialuserid : " + buddy.value, "BuddyDatabaseHelper");
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2230ar.f7958a);
        builderNewDelete.withSelection("buddy_no = ?", new String[]{buddy.value});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9804a(String str, String str2, int i) {
        if (C4904y.f17872b) {
            C4904y.m18639b("[updateBuddyNameByOrgNum] Buddy.orgNum = " + str, "BuddyDatabaseHelper");
        }
        String str3 = "%" + str.substring(str.length() - 8) + "%";
        if (C4904y.f17872b) {
            C4904y.m18639b("[updateBuddyNameByOrgNum] modifiedOrgNum = " + str3, "BuddyDatabaseHelper");
        }
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2289i.f8196a);
        builderNewUpdate.withSelection("buddy_contact_buddy='0' AND buddy_phonenumber_external_use LIKE ?", new String[]{str3});
        builderNewUpdate.withValue("buddy_name", str2);
        builderNewUpdate.withValue("buddy_is_name_updated", "N");
        builderNewUpdate.withValue("buddy_using_contact_name", "Y");
        builderNewUpdate.withValue("buddy_raw_contact_id", Integer.valueOf(i));
        builderNewUpdate.withValue("buddy_hanzitopinyin", m9828c(str2));
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9803a(String str, BuddyProfile buddyProfile) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2289i.f8196a);
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
    public static ContentProviderOperation m9805a(String str, String str2, String str3, String str4) throws Throwable {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2289i.f8196a);
        boolean zM9823b = m9823b(GlobalApplication.m10279a().getContentResolver(), str);
        String strM9828c = null;
        builderNewUpdate.withSelection("buddy_raw_contact_id=?", new String[]{str});
        builderNewUpdate.withSelection("buddy_no=?", new String[]{str2});
        if (!zM9823b) {
            if (!TextUtils.isEmpty(str4)) {
                builderNewUpdate.withValue("buddy_name", str4);
                strM9828c = m9828c(str4);
            } else {
                builderNewUpdate.withValue("buddy_name", str3);
                strM9828c = m9828c(str3);
            }
        }
        builderNewUpdate.withValue("buddy_using_contact_name", "N");
        builderNewUpdate.withValue("buddy_raw_contact_id", 0);
        builderNewUpdate.withValue("buddy_hanzitopinyin", strM9828c);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static Cursor m9806a(ContentResolver contentResolver, C1106c c1106c) {
        try {
            return contentResolver.query(C2299s.f8209a, new String[]{"inbox_no", "inbox_session_id"}, "inbox_no = ? AND inbox_chat_type = ? ", new String[]{c1106c.m7046a(), String.valueOf(EnumC2300t.ONETOONE.m10210a())}, null);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m9846i(android.content.ContentResolver r9, java.lang.String r10) throws java.lang.Throwable {
        /*
            r8 = 0
            r6 = 1
            r7 = 0
            android.net.Uri r1 = com.sec.chaton.p057e.C2289i.f8196a     // Catch: java.lang.Throwable -> L3c
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L3c
            r0 = 0
            java.lang.String r3 = "COUNT(*)"
            r2[r0] = r3     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = "buddy_no = ?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L3c
            r0 = 0
            r4[r0] = r10     // Catch: java.lang.Throwable -> L3c
            r5 = 0
            r0 = r9
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L3c
            if (r1 != 0) goto L25
            if (r1 == 0) goto L24
            r1.close()
        L24:
            return r7
        L25:
            if (r1 == 0) goto L48
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto L48
            r0 = 0
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L46
        L32:
            if (r1 == 0) goto L37
            r1.close()
        L37:
            if (r0 <= 0) goto L44
            r0 = r6
        L3a:
            r7 = r0
            goto L24
        L3c:
            r0 = move-exception
            r1 = r8
        L3e:
            if (r1 == 0) goto L43
            r1.close()
        L43:
            throw r0
        L44:
            r0 = r7
            goto L3a
        L46:
            r0 = move-exception
            goto L3e
        L48:
            r0 = r7
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2190d.m9846i(android.content.ContentResolver, java.lang.String):boolean");
    }

    /* renamed from: b */
    public static void m9822b(SQLiteDatabase sQLiteDatabase) throws Throwable {
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
                        if (string.startsWith(Spam.ACTIVITY_CANCEL)) {
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
    public static void m9834d(ContentResolver contentResolver) throws Throwable {
        Cursor cursor;
        try {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            Cursor cursorQuery = contentResolver.query(C2289i.f8196a, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() != 0) {
                        HashMap<String, String> mapM18279a = C4828at.m18279a(cursorQuery.getCount());
                        Iterator<String> it = mapM18279a.keySet().iterator();
                        cursorQuery.moveToFirst();
                        while (cursorQuery.moveToNext() && it.hasNext()) {
                            String next = it.next();
                            String str = mapM18279a.get(next);
                            C4904y.m18641c("key : " + next + ", values : " + str, null);
                            try {
                                ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2289i.f8196a);
                                builderNewUpdate.withSelection("buddy_no=?", new String[]{cursorQuery.getString(cursorQuery.getColumnIndex("buddy_no"))});
                                builderNewUpdate.withValue("buddy_name", next);
                                builderNewUpdate.withValue("buddy_status_message", str);
                                builderNewUpdate.withValue("buddy_hanzitopinyin", str.toLowerCase());
                                arrayList.add(builderNewUpdate.build());
                            } catch (Exception e) {
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* renamed from: e */
    public static HashMap<String, String> m9837e(ContentResolver contentResolver) throws Throwable {
        Cursor cursorQuery;
        HashMap<String, String> map = new HashMap<>();
        try {
            cursorQuery = contentResolver.query(C2289i.f8196a, new String[]{"buddy_no", "buddy_extra_info", "buddy_sainfo"}, null, null, null);
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
    public static String m9828c(String str) {
        if (!C4828at.m18276a().m18291c(str)) {
            return str;
        }
        ArrayList<C4830av> arrayListM18290a = C4828at.m18276a().m18290a(str);
        String str2 = "";
        int i = 0;
        while (i < arrayListM18290a.size()) {
            String str3 = str2 + arrayListM18290a.get(i).f17634c.toLowerCase();
            i++;
            str2 = str3;
        }
        return str2;
    }

    /* renamed from: a */
    public static ArrayList<String> m9811a() throws Throwable {
        Cursor cursorQuery;
        ContentResolver contentResolver = GlobalApplication.m18732r().getContentResolver();
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            cursorQuery = contentResolver.query(C2289i.f8196a, new String[]{"buddy_no"}, "buddy_contact_buddy='0'", null, null);
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
    public static void m9815a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ArrayList arrayList3 = new ArrayList();
        C4904y.m18639b("compareBuddyNumberAndDeleteZombieBuddy() buddyNoList.size() = " + arrayList.size(), "BuddyDatabaseHelper");
        C4904y.m18639b("compareBuddyNumberAndDeleteZombieBuddy() buddyNoInMyDb.size() = " + arrayList2.size(), "BuddyDatabaseHelper");
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
            C4904y.m18639b("compareBuddyNumberAndDeleteZombieBuddy() buddyNoDelta.size() = " + arrayList3.size(), "BuddyDatabaseHelper");
            try {
                if (arrayList3.size() > 0) {
                    m9814a((ArrayList<String>) arrayList3);
                }
            } catch (OperationApplicationException e) {
                e.printStackTrace();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m9814a(ArrayList<String> arrayList) throws RemoteException, OperationApplicationException {
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                arrayList2.add(m9819b(arrayList.get(i2).toString()));
                i = i2 + 1;
            } else {
                GlobalApplication.m10279a().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList2);
                return;
            }
        }
    }

    /* renamed from: i */
    private static String m9845i(String str) {
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
            while (stringTokenizer.hasMoreTokens()) {
                new String();
                String strNextToken = stringTokenizer.nextToken();
                if (strNextToken.length() >= 19 && strNextToken.startsWith("10")) {
                    C4904y.m18639b("getPhonNumberByMsisdns() chaton id : " + strNextToken, "BuddyDatabaseHelper");
                } else if (strNextToken.startsWith(Spam.ACTIVITY_CANCEL)) {
                    C4904y.m18639b("getPhonNumberByMsisdns() pin number : " + strNextToken, "BuddyDatabaseHelper");
                } else {
                    C4904y.m18639b("getPhonNumberByMsisdns() PhonNumber: " + strNextToken, "BuddyDatabaseHelper");
                    str2 = str2 + "+" + strNextToken + " ";
                }
            }
        }
        return str2;
    }

    /* renamed from: b */
    private static boolean m9824b(String str, String str2) {
        return str.length() >= 19 && str.startsWith("10") && !TextUtils.isEmpty(str2);
    }

    /* renamed from: c */
    public static void m9831c(SQLiteDatabase sQLiteDatabase) throws Throwable {
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
                            contentValues.put("buddy_phonenumber_external_use", m9845i(string2));
                        } else if (i != 1) {
                            contentValues.put("buddy_phonenumber_external_use", "");
                        } else if (m9824b(string, string3)) {
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

    /* renamed from: j */
    public static String m9847j(ContentResolver contentResolver, String str) {
        String string = "";
        Cursor cursorM9843h = null;
        try {
            cursorM9843h = m9843h(contentResolver, str);
            if (cursorM9843h != null && cursorM9843h.getCount() != 0 && cursorM9843h.moveToFirst()) {
                string = cursorM9843h.getString(cursorM9843h.getColumnIndex("buddy_coverstory_meta_id"));
            }
            return string;
        } finally {
            if (cursorM9843h != null) {
                cursorM9843h.close();
            }
        }
    }

    /* renamed from: c */
    public static void m9830c(ContentResolver contentResolver, String str, String str2) throws Throwable {
        Cursor cursorQuery;
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        try {
            cursorQuery = contentResolver.query(C2289i.f8196a, null, null, null, null);
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
                    ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2289i.f8196a);
                    builderNewUpdate.withSelection("buddy_no=?", new String[]{str});
                    builderNewUpdate.withValue("buddy_coverstory_meta_id", str2);
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

    /* renamed from: a */
    public static void m9812a(Cursor cursor, Map<Integer, String> map, ArrayList<String> arrayList) {
        boolean z;
        new ArrayList();
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
        arrayList2 = new ArrayList<>();
        if (C4904y.f17872b) {
            C4904y.m18639b("updateContactBuddy() - start", "BuddyDatabaseHelper");
        }
        String str = null;
        for (Integer num : map.keySet()) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            ArrayList arrayList3 = new ArrayList();
            List<C2193g> listM9876a = C2192f.m9876a(cursor, num.intValue());
            if (listM9876a.size() == 0) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("updateContactBuddy() changedContactId = " + num + " not founded in Contact cursor", "BuddyDatabaseHelper");
                }
                arrayList2.add(m9800a(num.intValue()));
                try {
                    try {
                        GlobalApplication.m10279a().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList2);
                    } catch (OperationApplicationException e) {
                        e.printStackTrace();
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                    arrayList2.clear();
                } finally {
                }
            } else {
                Iterator<C2193g> it = listM9876a.iterator();
                String strM9886a = str;
                while (true) {
                    if (!it.hasNext()) {
                        str = strM9886a;
                        z = true;
                        break;
                    }
                    C2193g next = it.next();
                    if (next.m9888c()) {
                        String strM9889d = next.m9889d();
                        strM9886a = next.m9886a();
                        if (strM9889d.length() < 8) {
                            continue;
                        } else {
                            if (m9835d(strM9889d)) {
                                C4904y.m18639b("updateContactBuddy() should not write buddy db, id = " + num, "BuddyDatabaseHelper");
                                str = strM9886a;
                                z = false;
                                break;
                            }
                            String strSubstring = strM9889d.substring(strM9889d.length() - 8);
                            if (!arrayList3.contains(strSubstring)) {
                                sb.append(next.m9887b());
                                sb2.append(strM9889d);
                                arrayList3.add(strSubstring);
                                if (listM9876a.indexOf(next) != listM9876a.size() - 1) {
                                    sb.append(", ");
                                    sb2.append(" ");
                                }
                            }
                        }
                    }
                    strM9886a = strM9886a;
                }
                if (z) {
                    ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2289i.f8196a);
                    builderNewInsert.withValue("buddy_no", Integer.toString(num.intValue()));
                    if (!TextUtils.isEmpty(str)) {
                        builderNewInsert.withValue("buddy_name", str);
                    }
                    if (C4904y.f17872b) {
                        C4904y.m18639b("updateContactBuddy() write buddy db, id = " + num + " name = " + map.get(num), "BuddyDatabaseHelper");
                    }
                    if (sb.toString().endsWith(", ")) {
                        builderNewInsert.withValue("buddy_status_message", sb.toString().substring(0, sb.toString().length() - 2));
                    } else {
                        builderNewInsert.withValue("buddy_status_message", sb.toString());
                    }
                    if (sb2.toString().endsWith(" ")) {
                        builderNewInsert.withValue("buddy_phonenumber_external_use", sb2.toString().substring(0, sb2.toString().length() - 1));
                    } else {
                        builderNewInsert.withValue("buddy_phonenumber_external_use", sb2.toString());
                    }
                    builderNewInsert.withValue("buddy_profile_status", "3");
                    builderNewInsert.withValue("buddy_contact_buddy", Spam.ACTIVITY_REPORT);
                    String strM9828c = m9828c(str);
                    if (!TextUtils.isEmpty(strM9828c)) {
                        builderNewInsert.withValue("buddy_hanzitopinyin", strM9828c);
                    }
                    arrayList2.add(builderNewInsert.build());
                    if (arrayList2.size() != 0 && arrayList2.size() % 250 == 0) {
                        try {
                            try {
                                try {
                                    GlobalApplication.m10279a().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList2);
                                } catch (RemoteException e3) {
                                    e3.printStackTrace();
                                }
                            } catch (OperationApplicationException e4) {
                                e4.printStackTrace();
                            }
                        } finally {
                        }
                    }
                }
            }
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            arrayList2.addAll(C2176ab.m9677a(arrayList));
        }
        try {
            try {
                GlobalApplication.m10279a().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList2);
            } catch (OperationApplicationException e5) {
                e5.printStackTrace();
                arrayList2.clear();
            } catch (RemoteException e6) {
                e6.printStackTrace();
                arrayList2.clear();
            }
            m9820b();
        } catch (Throwable th) {
            arrayList2.clear();
            m9820b();
            throw th;
        }
    }

    /* renamed from: b */
    public static void m9820b() {
        if (C4809aa.m18104a().m18118a("sms_chatlist_sync_last_time", 0L) == 0) {
            if (C4904y.f17872b) {
                C4904y.m18639b("updateSMS()", C2190d.class.getSimpleName());
            }
            C2654bs.m11169a().m11187a(3, (Handler) null);
        }
    }

    /* renamed from: d */
    public static boolean m9835d(String str) throws Throwable {
        Cursor cursorQuery;
        if (str.length() < 8) {
            return false;
        }
        try {
            cursorQuery = GlobalApplication.m18732r().getContentResolver().query(C2289i.f8196a, null, "buddy_contact_buddy='0' AND ( buddy_phonenumber_external_use LIKE ? OR buddy_phonenumber_external_use LIKE ? )", new String[]{"%" + str.substring(str.length() - 8) + " %", "%" + str.substring(str.length() - 8)}, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() != 0) {
                        if (cursorQuery.moveToFirst()) {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return true;
                        }
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
            return false;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: a */
    public static ContentProviderOperation m9800a(int i) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2289i.f8196a);
        builderNewDelete.withSelection("buddy_no = ?", new String[]{Integer.toString(i)});
        if (C4904y.f17872b) {
            C4904y.m18639b("deleteContactBuddy() contactId = " + i, "BuddyDatabaseHelper");
        }
        return builderNewDelete.build();
    }

    /* renamed from: e */
    public static void m9838e(String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("[deleteContactBuddyByPhoneNumber] newPhoneNumberExternal = " + str, "BuddyDatabaseHelper");
        }
        ContentResolver contentResolver = GlobalApplication.m18732r().getContentResolver();
        if (str != null && str.length() >= 8) {
            if (str.contains(" ")) {
                StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
                while (stringTokenizer.hasMoreTokens()) {
                    String strNextToken = stringTokenizer.nextToken();
                    if (strNextToken != null && strNextToken.length() >= 8) {
                        contentResolver.delete(C2289i.f8196a, "buddy_contact_buddy='1' AND ( buddy_phonenumber_external_use LIKE ? OR buddy_phonenumber_external_use LIKE ? )", new String[]{"%" + strNextToken.substring(strNextToken.length() - 8) + " %", "%" + strNextToken.substring(strNextToken.length() - 8)});
                    }
                }
                return;
            }
            if (str.length() >= 8) {
                contentResolver.delete(C2289i.f8196a, "buddy_contact_buddy='1' AND ( buddy_phonenumber_external_use LIKE ? OR buddy_phonenumber_external_use LIKE ? )", new String[]{"%" + str.substring(str.length() - 8) + " %", "%" + str.substring(str.length() - 8)});
            }
        }
    }

    /* renamed from: c */
    public static void m9829c() {
        if (C4904y.f17872b) {
            C4904y.m18639b("deleteAllContactBuddy called", "BuddyDatabaseHelper");
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2289i.f8196a);
        builderNewDelete.withSelection("buddy_contact_buddy='1'", null);
        arrayList.add(builderNewDelete.build());
        try {
            try {
                GlobalApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
            } catch (OperationApplicationException e) {
                e.printStackTrace();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        } finally {
            arrayList.clear();
        }
    }

    /* renamed from: f */
    public static String m9840f(String str) throws Throwable {
        Cursor cursorQuery;
        String strReplaceAll = str.replaceAll("[^\\+\\*\\#0-9]", "");
        if (strReplaceAll.length() >= 8) {
            try {
                cursorQuery = GlobalApplication.m18732r().getContentResolver().query(C2289i.f8196a, null, "buddy_phonenumber_external_use LIKE ? OR buddy_phonenumber_external_use LIKE ?", new String[]{"%" + strReplaceAll.substring(strReplaceAll.length() - 8) + " %", "%" + strReplaceAll.substring(strReplaceAll.length() - 8)}, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.getCount() != 0 && cursorQuery.moveToFirst()) {
                            str = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"));
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
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = null;
            }
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m9842g(java.lang.String r8) throws java.lang.Throwable {
        /*
            r6 = 0
            java.lang.String r7 = ""
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m18732r()     // Catch: java.lang.Throwable -> L4f
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L4f
            android.net.Uri r1 = com.sec.chaton.p057e.C2289i.f8196a     // Catch: java.lang.Throwable -> L4f
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
            r3.<init>()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r4 = "buddy_no='"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L4f
            java.lang.StringBuilder r3 = r3.append(r8)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r4 = "'"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L4f
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L4f
            if (r1 == 0) goto L59
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L59
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L59
            java.lang.String r0 = "buddy_phonenumber_external_use"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L57
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L57
        L49:
            if (r1 == 0) goto L4e
            r1.close()
        L4e:
            return r0
        L4f:
            r0 = move-exception
            r1 = r6
        L51:
            if (r1 == 0) goto L56
            r1.close()
        L56:
            throw r0
        L57:
            r0 = move-exception
            goto L51
        L59:
            r0 = r7
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2190d.m9842g(java.lang.String):java.lang.String");
    }
}
