package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.RemoteException;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.C2290j;
import com.sec.chaton.p081n.C2918d;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: ContactDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.f */
/* loaded from: classes.dex */
public class C2192f {
    /* renamed from: a */
    public static ContentProviderOperation m9874a(C2918d c2918d) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2290j.f8197a);
        builderNewInsert.withValue("contacts_id", Integer.valueOf(c2918d.m12125a()));
        builderNewInsert.withValue("conatct_number", c2918d.m12126b());
        builderNewInsert.withValue("contact_raw_id", Integer.valueOf(c2918d.m12127c()));
        builderNewInsert.withValue("contacts_name", c2918d.m12128d());
        builderNewInsert.withValue("conatct_normalized_number", c2918d.m12129e());
        builderNewInsert.withValue("contacts_contact_id", Integer.valueOf(c2918d.m12130f()));
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9871a(int i) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2290j.f8197a);
        builderNewDelete.withSelection("contacts_id=?", new String[]{String.valueOf(i)});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static void m9877a() {
        if (C4904y.f17872b) {
            C4904y.m18639b("deleteAllContact contact duplicated", "ContactDatabaseHelper");
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(ContentProviderOperation.newDelete(C2290j.f8197a).build());
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

    /* renamed from: a */
    public static ContentProviderOperation m9875a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2290j.f8197a);
        builderNewDelete.withSelection("conatct_normalized_number=?", new String[]{str});
        return builderNewDelete.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m9878b(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2290j.f8197a);
        builderNewDelete.withSelection("conatct_normalized_number LIKE ?", new String[]{"%" + str.substring(str.length() - 8)});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9872a(int i, String str, String str2, String str3) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2290j.f8197a);
        builderNewUpdate.withSelection("contacts_id=?", new String[]{String.valueOf(i)});
        if (str.equals("conatct_number")) {
            builderNewUpdate.withValue("conatct_number", str2);
            builderNewUpdate.withValue("conatct_normalized_number", str3);
        }
        builderNewUpdate.withValue(str, str2);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9873a(Cursor cursor) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2290j.f8197a);
        builderNewUpdate.withSelection("contacts_id=?", new String[]{String.valueOf(cursor.getInt(0))});
        String strM9883g = m9883g(cursor.getString(cursor.getColumnIndex("data1")));
        builderNewUpdate.withValue("conatct_number", cursor.getString(1));
        builderNewUpdate.withValue("conatct_normalized_number", strM9883g);
        builderNewUpdate.withValue("contacts_name", cursor.getString(3));
        builderNewUpdate.withValue("contacts_contact_id", Integer.valueOf(cursor.getInt(4)));
        return builderNewUpdate.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m9879c(java.lang.String r8) {
        /*
            r6 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "%"
            java.lang.StringBuilder r0 = r0.append(r1)
            int r1 = r8.length()
            int r1 = r1 + (-8)
            java.lang.String r1 = r8.substring(r1)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r5 = r0.toString()
            android.content.Context r0 = com.sec.common.CommonApplication.m18732r()     // Catch: java.lang.Exception -> L54 java.lang.Throwable -> L60
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> L54 java.lang.Throwable -> L60
            android.net.Uri r1 = com.sec.chaton.p057e.C2290j.f8197a     // Catch: java.lang.Exception -> L54 java.lang.Throwable -> L60
            r2 = 0
            java.lang.String r3 = "conatct_normalized_number LIKE ?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Exception -> L54 java.lang.Throwable -> L60
            r7 = 0
            r4[r7] = r5     // Catch: java.lang.Exception -> L54 java.lang.Throwable -> L60
            java.lang.String r5 = "contacts_id DESC"
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L54 java.lang.Throwable -> L60
            if (r1 == 0) goto L6c
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            if (r0 == 0) goto L6c
            java.lang.String r0 = "contacts_name"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            java.lang.String r6 = r1.getString(r0)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            r0 = r6
        L4e:
            if (r1 == 0) goto L53
            r1.close()
        L53:
            return r0
        L54:
            r0 = move-exception
            r1 = r6
        L56:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L67
            if (r1 == 0) goto L5e
            r1.close()
        L5e:
            r0 = r6
            goto L53
        L60:
            r0 = move-exception
        L61:
            if (r6 == 0) goto L66
            r6.close()
        L66:
            throw r0
        L67:
            r0 = move-exception
            r6 = r1
            goto L61
        L6a:
            r0 = move-exception
            goto L56
        L6c:
            r0 = r6
            goto L4e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2192f.m9879c(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008f A[PHI: r0 r1
  0x008f: PHI (r0v7 android.database.Cursor) = (r0v9 android.database.Cursor), (r0v12 android.database.Cursor) binds: [B:39:0x00af, B:26:0x008d] A[DONT_GENERATE, DONT_INLINE]
  0x008f: PHI (r1v4 long) = (r1v6 long), (r1v14 long) binds: [B:39:0x00af, B:26:0x008d] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long m9880d(java.lang.String r15) throws java.lang.Throwable {
        /*
            r0 = 0
            r9 = 0
            if (r15 != 0) goto L6
        L5:
            return r9
        L6:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = m9882f(r15)
            java.util.Iterator r11 = r1.iterator()
            r6 = r0
            r7 = r9
        L15:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto Lc1
            java.lang.Object r0 = r11.next()
            r5 = r0
            java.lang.String r5 = (java.lang.String) r5
            android.content.Context r0 = com.sec.common.CommonApplication.m18732r()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc8
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc8
            android.net.Uri r1 = com.sec.chaton.p057e.C2290j.f8197a     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc8
            r2 = 0
            java.lang.String r3 = "conatct_normalized_number LIKE ?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc8
            r12 = 0
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc8
            r13.<init>()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc8
            java.lang.String r14 = "%"
            java.lang.StringBuilder r13 = r13.append(r14)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc8
            int r14 = r5.length()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc8
            int r14 = r14 + (-8)
            java.lang.String r5 = r5.substring(r14)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc8
            java.lang.StringBuilder r5 = r13.append(r5)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc8
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc8
            r4[r12] = r5     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc8
            java.lang.String r5 = "contacts_id DESC"
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lc4 java.lang.Exception -> Lc8
            if (r0 == 0) goto L95
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Exception -> La3 java.lang.Throwable -> Lb2
            if (r1 == 0) goto L83
            java.lang.String r1 = "contact_raw_id"
            int r1 = r0.getColumnIndex(r1)     // Catch: java.lang.Exception -> La3 java.lang.Throwable -> Lb2
            long r1 = r0.getLong(r1)     // Catch: java.lang.Exception -> La3 java.lang.Throwable -> Lb2
            int r3 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r3 > 0) goto L84
            r0.close()     // Catch: java.lang.Throwable -> Lb2 java.lang.Exception -> Lc6
            if (r0 == 0) goto L80
            boolean r3 = r0.isClosed()
            if (r3 != 0) goto L80
            r0.close()
        L80:
            r6 = r0
            r7 = r1
            goto L15
        L83:
            r1 = r7
        L84:
            r0.close()     // Catch: java.lang.Throwable -> Lb2 java.lang.Exception -> Lc6
            if (r0 == 0) goto L92
            boolean r3 = r0.isClosed()
            if (r3 != 0) goto L92
        L8f:
            r0.close()
        L92:
            r6 = r0
            r7 = r1
            goto L15
        L95:
            if (r0 == 0) goto La0
            boolean r1 = r0.isClosed()
            if (r1 != 0) goto La0
            r0.close()
        La0:
            r6 = r0
            goto L15
        La3:
            r1 = move-exception
            r3 = r1
            r1 = r7
        La6:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> Lb2
            if (r0 == 0) goto L92
            boolean r3 = r0.isClosed()
            if (r3 != 0) goto L92
            goto L8f
        Lb2:
            r1 = move-exception
            r6 = r0
            r0 = r1
        Lb5:
            if (r6 == 0) goto Lc0
            boolean r1 = r6.isClosed()
            if (r1 != 0) goto Lc0
            r6.close()
        Lc0:
            throw r0
        Lc1:
            r9 = r7
            goto L5
        Lc4:
            r0 = move-exception
            goto Lb5
        Lc6:
            r3 = move-exception
            goto La6
        Lc8:
            r0 = move-exception
            r3 = r0
            r1 = r7
            r0 = r6
            goto La6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2192f.m9880d(java.lang.String):long");
    }

    /* renamed from: e */
    public static String m9881e(String str) throws Throwable {
        Exception exc;
        Cursor cursor;
        String str2;
        String string;
        Cursor cursor2 = null;
        try {
            Cursor cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2290j.f8197a, null, "conatct_normalized_number=?", new String[]{str}, "contacts_id DESC");
            if (cursorQuery != null) {
                try {
                    try {
                        string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("conatct_number")) : null;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursorQuery;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
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
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        throw th;
                    }
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

    /* renamed from: f */
    public static List<String> m9882f(String str) {
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }

    /* renamed from: g */
    public static String m9883g(String str) {
        return str.replaceAll("[^\\+\\*\\#0-9]", "");
    }

    /* renamed from: a */
    public static List<C2193g> m9876a(Cursor cursor, int i) {
        ArrayList arrayList = new ArrayList();
        if (C4904y.f17872b) {
            C4904y.m18639b("getPhoneNumListByCursor() contactId = " + i, "ContactDatabaseHelper");
        }
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                if (cursor.getString(cursor.getColumnIndex("contact_id")).compareTo(Integer.toString(i)) == 0) {
                    arrayList.add(new C2193g(cursor.getString(cursor.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME)), cursor.getString(cursor.getColumnIndex("data1")), cursor.getString(cursor.getColumnIndex("raw_contact_id")), cursor.getString(cursor.getColumnIndex("_id"))));
                }
            } while (cursor.moveToNext());
        }
        return arrayList;
    }

    /* renamed from: h */
    public static String m9884h(String str) throws Throwable {
        Exception exc;
        Cursor cursor;
        String str2;
        Cursor cursor2 = null;
        try {
            Cursor cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2290j.f8197a, new String[]{"contacts_contact_id"}, "conatct_normalized_number LIKE ?", new String[]{m9885i(str)}, "contacts_contact_id DESC");
            if (cursorQuery != null) {
                try {
                    try {
                        String string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("contacts_contact_id")) : null;
                        try {
                            cursorQuery.close();
                            str2 = string;
                        } catch (Exception e) {
                            cursor = cursorQuery;
                            exc = e;
                            str2 = string;
                            try {
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("getContactIdByPhoneNumber " + exc.getMessage(), "ContactDatabaseHelper");
                                }
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
                } catch (Exception e2) {
                    cursor = cursorQuery;
                    exc = e2;
                    str2 = null;
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

    /* renamed from: i */
    public static String m9885i(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strReplace = str.replace("+", "").replace("-", "");
        try {
            return "%" + strReplace.substring(str.length() - 8);
        } catch (IndexOutOfBoundsException e) {
            return "%" + strReplace;
        }
    }
}
