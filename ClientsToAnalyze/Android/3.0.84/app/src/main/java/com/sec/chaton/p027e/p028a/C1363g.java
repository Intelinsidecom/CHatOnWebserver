package com.sec.chaton.p027e.p028a;

import android.content.ContentProviderOperation;
import android.database.Cursor;
import com.sec.chaton.p027e.C1442j;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: ContactDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.g */
/* loaded from: classes.dex */
public class C1363g {
    /* renamed from: a */
    public static ContentProviderOperation m6077a(int i, String str, int i2, String str2, String str3) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C1442j.f5370a);
        builderNewInsert.withValue("contacts_id", Integer.valueOf(i));
        builderNewInsert.withValue("conatct_number", str);
        builderNewInsert.withValue("contact_raw_id", Integer.valueOf(i2));
        builderNewInsert.withValue("contacts_name", str2);
        builderNewInsert.withValue("conatct_normalized_number", str3);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6076a(int i) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C1442j.f5370a);
        builderNewDelete.withSelection("contacts_id=?", new String[]{String.valueOf(i)});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static void m6080a() {
        CommonApplication.m11493l().getContentResolver().delete(C1442j.f5370a, null, null);
    }

    /* renamed from: a */
    public static ContentProviderOperation m6079a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C1442j.f5370a);
        builderNewDelete.withSelection("conatct_normalized_number=?", new String[]{str});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6078a(int i, String str, String str2, String str3) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C1442j.f5370a);
        builderNewUpdate.withSelection("contacts_id=?", new String[]{String.valueOf(i)});
        if (str.equals("conatct_number")) {
            builderNewUpdate.withValue("conatct_number", str3);
        }
        builderNewUpdate.withValue(str, str2);
        return builderNewUpdate.build();
    }

    /* renamed from: b */
    public static String m6081b(String str) {
        Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1442j.f5370a, null, "conatct_normalized_number=?", new String[]{str}, "contacts_id DESC");
        if (cursorQuery != null) {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("contacts_name")) : null;
            cursorQuery.close();
        }
        return string;
    }

    /* renamed from: c */
    public static long m6082c(String str) throws Throwable {
        long j;
        Exception e;
        Cursor cursorQuery;
        if (str == null) {
            return 0L;
        }
        new ArrayList();
        Iterator<String> it = m6084e(str).iterator();
        Cursor cursor = null;
        long j2 = 0;
        while (true) {
            if (!it.hasNext()) {
                j = j2;
                break;
            }
            try {
                cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1442j.f5370a, null, "conatct_normalized_number=?", new String[]{it.next()}, "contacts_id DESC");
            } catch (Exception e2) {
                e = e2;
                j = j2;
                cursorQuery = cursor;
            } catch (Throwable th) {
                th = th;
            }
            if (cursorQuery != null) {
                try {
                    try {
                    } catch (Exception e3) {
                        e = e3;
                        j = j2;
                    }
                    if (cursorQuery.moveToFirst()) {
                        j = cursorQuery.getLong(cursorQuery.getColumnIndex("contact_raw_id"));
                        if (j <= 0) {
                            try {
                                cursorQuery.close();
                                if (cursorQuery != null && !cursorQuery.isClosed()) {
                                    cursorQuery.close();
                                }
                                cursor = cursorQuery;
                                j2 = j;
                            } catch (Exception e4) {
                                e = e4;
                                e.printStackTrace();
                                if (cursorQuery != null && !cursorQuery.isClosed()) {
                                    cursorQuery.close();
                                }
                                cursor = cursorQuery;
                                j2 = j;
                            }
                        } else if (cursorQuery != null && !cursorQuery.isClosed()) {
                            cursorQuery.close();
                        }
                    } else {
                        cursorQuery.close();
                        if (cursorQuery != null && !cursorQuery.isClosed()) {
                            cursorQuery.close();
                        }
                        j = j2;
                        cursor = cursorQuery;
                        j2 = j;
                    }
                } catch (Throwable th2) {
                    cursor = cursorQuery;
                    th = th2;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    throw th;
                }
            } else {
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
                cursor = cursorQuery;
            }
        }
        return j;
    }

    /* renamed from: d */
    public static String m6083d(String str) throws Throwable {
        Exception exc;
        Cursor cursor;
        String str2;
        String string;
        Cursor cursor2 = null;
        try {
            Cursor cursorQuery = CommonApplication.m11493l().getContentResolver().query(C1442j.f5370a, null, "conatct_normalized_number=?", new String[]{str}, "contacts_id DESC");
            if (cursorQuery != null) {
                try {
                    try {
                        string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("conatct_number")) : null;
                    } catch (Exception e) {
                        cursor = cursorQuery;
                        exc = e;
                        str2 = null;
                    }
                    try {
                        cursorQuery.close();
                        str2 = string;
                    } catch (Exception e2) {
                        cursor = cursorQuery;
                        exc = e2;
                        str2 = string;
                        try {
                            exc.printStackTrace();
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return str2;
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursorQuery;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    throw th;
                }
            } else {
                str2 = null;
            }
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
        } catch (Exception e3) {
            exc = e3;
            cursor = null;
            str2 = null;
        } catch (Throwable th3) {
            th = th3;
        }
        return str2;
    }

    /* renamed from: e */
    public static List<String> m6084e(String str) {
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }
}
