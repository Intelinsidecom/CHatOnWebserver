package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p057e.C2293m;
import com.sec.chaton.p057e.C2294n;
import com.sec.chaton.p065io.entry.inner.Buddy;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.provider.ChatONProvider;
import com.sec.chaton.util.C4874cl;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: BuddyGroupDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.e */
/* loaded from: classes.dex */
public class C2191e {

    /* renamed from: a */
    static ChatONProvider f7829a = new ChatONProvider();

    /* renamed from: a */
    public static void m9856a(ContentResolver contentResolver, String str) {
        try {
            contentResolver.delete(C2293m.f8204a, "group_relation_group = ? ", new String[]{str});
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public static void m9862b(ContentResolver contentResolver, String str) {
        try {
            contentResolver.delete(C2294n.f8205a, "_id = ? ", new String[]{str});
            C2198l.m9906a(CommonApplication.m18732r().getContentResolver(), Long.parseLong(str));
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    public static Uri m9866c(ContentResolver contentResolver, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_name", str);
        try {
            return contentResolver.insert(C2294n.f8205a, contentValues);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m9867d(android.content.ContentResolver r9, java.lang.String r10) throws java.lang.Throwable {
        /*
            r8 = 1
            r7 = 0
            r6 = -1
            android.net.Uri r1 = com.sec.chaton.p057e.C2294n.f8205a     // Catch: java.lang.Exception -> L2f java.lang.Throwable -> L3e
            r2 = 0
            java.lang.String r3 = "group_name = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L2f java.lang.Throwable -> L3e
            r0 = 0
            r4[r0] = r10     // Catch: java.lang.Exception -> L2f java.lang.Throwable -> L3e
            r5 = 0
            r0 = r9
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L2f java.lang.Throwable -> L3e
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            if (r0 != r8) goto L4a
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            java.lang.String r0 = "_id"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
        L29:
            if (r1 == 0) goto L2e
            r1.close()
        L2e:
            return r0
        L2f:
            r0 = move-exception
            r1 = r7
        L31:
            java.lang.String r2 = "BuddyGroupDatabaseHelper"
            com.sec.chaton.util.C4904y.m18635a(r0, r2)     // Catch: java.lang.Throwable -> L46
            if (r1 == 0) goto L3c
            r1.close()
        L3c:
            r0 = r6
            goto L2e
        L3e:
            r0 = move-exception
            r1 = r7
        L40:
            if (r1 == 0) goto L45
            r1.close()
        L45:
            throw r0
        L46:
            r0 = move-exception
            goto L40
        L48:
            r0 = move-exception
            goto L31
        L4a:
            r0 = r6
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2191e.m9867d(android.content.ContentResolver, java.lang.String):int");
    }

    /* renamed from: e */
    public static String m9868e(ContentResolver contentResolver, String str) {
        Cursor cursorQuery;
        String string;
        Cursor cursor = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                cursorQuery = contentResolver.query(C2294n.f8205a, null, "_id = ? ", new String[]{str}, null);
            } catch (Exception e) {
                e = e;
                cursorQuery = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
            try {
                if (cursorQuery.getCount() == 1) {
                    cursorQuery.moveToFirst();
                    string = cursorQuery.getString(cursorQuery.getColumnIndex("group_name"));
                } else {
                    string = "";
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e2) {
                e = e2;
                C4904y.m18635a(e, "BuddyGroupDatabaseHelper");
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                string = "";
                return string;
            }
            return string;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003b A[PHI: r1
  0x003b: PHI (r1v4 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v6 android.database.Cursor) binds: [B:14:0x0047, B:8:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<java.lang.String> m9852a(android.content.ContentResolver r8, int r9) {
        /*
            r6 = 0
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            android.net.Uri r1 = com.sec.chaton.p057e.C2293m.f8204a     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L4a
            r2 = 0
            java.lang.String r3 = "group_relation_group = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L4a
            r0 = 0
            java.lang.String r5 = java.lang.Integer.toString(r9)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L4a
            r4[r0] = r5     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L4a
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L4a
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            if (r0 == 0) goto L39
        L25:
            java.lang.String r0 = "group_relation_buddy"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r7.add(r0)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            if (r0 != 0) goto L25
        L39:
            if (r1 == 0) goto L3e
        L3b:
            r1.close()
        L3e:
            return r7
        L3f:
            r0 = move-exception
            r1 = r6
        L41:
            java.lang.String r2 = "BuddyGroupDatabaseHelper"
            com.sec.chaton.util.C4904y.m18635a(r0, r2)     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L3e
            goto L3b
        L4a:
            r0 = move-exception
            r1 = r6
        L4c:
            if (r1 == 0) goto L51
            r1.close()
        L51:
            throw r0
        L52:
            r0 = move-exception
            goto L4c
        L54:
            r0 = move-exception
            goto L41
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2191e.m9852a(android.content.ContentResolver, int):java.util.ArrayList");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034 A[PHI: r1
  0x0034: PHI (r1v5 android.database.Cursor) = (r1v4 android.database.Cursor), (r1v7 android.database.Cursor) binds: [B:14:0x0040, B:8:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<java.lang.Integer> m9851a(android.content.ContentResolver r8) {
        /*
            r6 = 0
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            android.net.Uri r1 = com.sec.chaton.p057e.C2294n.f8205a     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L43
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L43
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            if (r0 == 0) goto L32
        L1a:
            java.lang.String r0 = "_id"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            r7.add(r0)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L4d
            if (r0 != 0) goto L1a
        L32:
            if (r1 == 0) goto L37
        L34:
            r1.close()
        L37:
            return r7
        L38:
            r0 = move-exception
            r1 = r6
        L3a:
            java.lang.String r2 = "BuddyGroupDatabaseHelper"
            com.sec.chaton.util.C4904y.m18635a(r0, r2)     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L37
            goto L34
        L43:
            r0 = move-exception
            r1 = r6
        L45:
            if (r1 == 0) goto L4a
            r1.close()
        L4a:
            throw r0
        L4b:
            r0 = move-exception
            goto L45
        L4d:
            r0 = move-exception
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2191e.m9851a(android.content.ContentResolver):java.util.ArrayList");
    }

    /* renamed from: a */
    public static boolean m9858a(ContentResolver contentResolver, int i, String str) throws Throwable {
        Cursor cursorQuery;
        try {
            Cursor cursorQuery2 = contentResolver.query(C2293m.f8204a, null, null, null, null);
            if (cursorQuery2 != null) {
                try {
                    if (cursorQuery2.moveToFirst()) {
                        cursorQuery = contentResolver.query(C2293m.f8204a, null, "group_relation_group = ? AND group_relation_buddy = ? ", new String[]{String.valueOf(i), str}, null);
                        try {
                            if (cursorQuery.getCount() == 1) {
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                return true;
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursorQuery = cursorQuery2;
                }
            }
            if (cursorQuery2 != null) {
                cursorQuery2.close();
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030 A[PHI: r1
  0x0030: PHI (r1v5 android.database.Cursor) = (r1v4 android.database.Cursor), (r1v7 android.database.Cursor) binds: [B:14:0x003c, B:8:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<java.lang.String> m9861b(android.content.ContentResolver r8) {
        /*
            r6 = 0
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            android.net.Uri r1 = com.sec.chaton.p057e.C2294n.f8205a     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L3f
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L3f
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            if (r0 == 0) goto L2e
        L1a:
            java.lang.String r0 = "group_name"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r7.add(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            if (r0 != 0) goto L1a
        L2e:
            if (r1 == 0) goto L33
        L30:
            r1.close()
        L33:
            return r7
        L34:
            r0 = move-exception
            r1 = r6
        L36:
            java.lang.String r2 = "BuddyGroupDatabaseHelper"
            com.sec.chaton.util.C4904y.m18635a(r0, r2)     // Catch: java.lang.Throwable -> L47
            if (r1 == 0) goto L33
            goto L30
        L3f:
            r0 = move-exception
            r1 = r6
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
            goto L36
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2191e.m9861b(android.content.ContentResolver):java.util.ArrayList");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035 A[PHI: r1
  0x0035: PHI (r1v5 android.database.Cursor) = (r1v4 android.database.Cursor), (r1v7 android.database.Cursor) binds: [B:20:0x0042, B:14:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0049  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m9869f(android.content.ContentResolver r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            r6 = 0
            android.net.Uri r1 = com.sec.chaton.p057e.C2294n.f8205a     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L45
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r7
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L45
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            if (r0 == 0) goto L33
        L15:
            java.lang.String r0 = "group_name"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            boolean r0 = r0.equals(r8)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            if (r0 == 0) goto L2d
            r0 = 1
            if (r1 == 0) goto L2c
            r1.close()
        L2c:
            return r0
        L2d:
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            if (r0 != 0) goto L15
        L33:
            if (r1 == 0) goto L38
        L35:
            r1.close()
        L38:
            r0 = 0
            goto L2c
        L3a:
            r0 = move-exception
            r1 = r6
        L3c:
            java.lang.String r2 = "BuddyGroupDatabaseHelper"
            com.sec.chaton.util.C4904y.m18635a(r0, r2)     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L38
            goto L35
        L45:
            r0 = move-exception
            r1 = r6
        L47:
            if (r1 == 0) goto L4c
            r1.close()
        L4c:
            throw r0
        L4d:
            r0 = move-exception
            goto L47
        L4f:
            r0 = move-exception
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2191e.m9869f(android.content.ContentResolver, java.lang.String):boolean");
    }

    /* renamed from: a */
    public static void m9854a(ContentResolver contentResolver, int i, Collection<String> collection) throws RemoteException, OperationApplicationException {
        m9855a(contentResolver, i, collection, false);
    }

    /* renamed from: a */
    public static void m9855a(ContentResolver contentResolver, int i, Collection<String> collection, boolean z) throws RemoteException, OperationApplicationException {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        if (z) {
            try {
                ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2293m.f8204a);
                builderNewDelete.withSelection("group_relation_group = ?", new String[]{String.valueOf(i)});
                arrayList.add(builderNewDelete.build());
            } catch (OperationApplicationException e) {
                e.printStackTrace();
                return;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return;
            }
        }
        for (String str : collection) {
            ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2293m.f8204a);
            builderNewInsert.withValue("group_relation_group", Integer.valueOf(i));
            builderNewInsert.withValue("group_relation_buddy", str);
            arrayList.add(builderNewInsert.build());
        }
        CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
        C2198l.m9906a(CommonApplication.m18732r().getContentResolver(), i);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0021 A[PHI: r0 r1
  0x0021: PHI (r0v5 int) = (r0v3 int), (r0v13 int) binds: [B:11:0x0028, B:5:0x001f] A[DONT_GENERATE, DONT_INLINE]
  0x0021: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:11:0x0028, B:5:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m9870g(android.content.ContentResolver r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            r6 = 0
            android.net.Uri r1 = com.sec.chaton.p057e.C2294n.f8205a     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L2b
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L2b
            r0 = 0
            java.lang.String r3 = "group_name"
            r2[r0] = r3     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L2b
            java.lang.String r3 = "group_name = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L2b
            r0 = 0
            r4[r0] = r8     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L2b
            r5 = 0
            r0 = r7
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L25 java.lang.Throwable -> L2b
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L35
            if (r1 == 0) goto L24
        L21:
            r1.close()
        L24:
            return r0
        L25:
            r0 = move-exception
            r1 = r6
        L27:
            r0 = -1
            if (r1 == 0) goto L24
            goto L21
        L2b:
            r0 = move-exception
        L2c:
            if (r6 == 0) goto L31
            r6.close()
        L31:
            throw r0
        L32:
            r0 = move-exception
            r6 = r1
            goto L2c
        L35:
            r0 = move-exception
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2191e.m9870g(android.content.ContentResolver, java.lang.String):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0025 A[PHI: r0 r1
  0x0025: PHI (r0v5 int) = (r0v3 int), (r0v13 int) binds: [B:11:0x002c, B:5:0x0023] A[DONT_GENERATE, DONT_INLINE]
  0x0025: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:11:0x002c, B:5:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m9859b(android.content.ContentResolver r7, int r8) throws java.lang.Throwable {
        /*
            r6 = 0
            android.net.Uri r1 = com.sec.chaton.p057e.C2294n.f8205a     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L2f
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L2f
            r0 = 0
            java.lang.String r3 = "_id"
            r2[r0] = r3     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L2f
            java.lang.String r3 = "_id = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L2f
            r0 = 0
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L2f
            r4[r0] = r5     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L2f
            r5 = 0
            r0 = r7
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L29 java.lang.Throwable -> L2f
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            if (r1 == 0) goto L28
        L25:
            r1.close()
        L28:
            return r0
        L29:
            r0 = move-exception
            r1 = r6
        L2b:
            r0 = -1
            if (r1 == 0) goto L28
            goto L25
        L2f:
            r0 = move-exception
        L30:
            if (r6 == 0) goto L35
            r6.close()
        L35:
            throw r0
        L36:
            r0 = move-exception
            r6 = r1
            goto L30
        L39:
            r0 = move-exception
            goto L2b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2191e.m9859b(android.content.ContentResolver, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0028 A[PHI: r0 r1
  0x0028: PHI (r0v5 int) = (r0v3 int), (r0v14 int) binds: [B:11:0x002f, B:5:0x0026] A[DONT_GENERATE, DONT_INLINE]
  0x0028: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:11:0x002f, B:5:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m9860b(android.content.ContentResolver r7, int r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r6 = 0
            android.net.Uri r1 = com.sec.chaton.p057e.C2294n.f8205a     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L32
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L32
            r0 = 0
            java.lang.String r3 = "group_name"
            r2[r0] = r3     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L32
            java.lang.String r3 = "group_name = ? AND _id != ? "
            r0 = 2
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L32
            r0 = 0
            r4[r0] = r9     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L32
            r0 = 1
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L32
            r4[r0] = r5     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L32
            r5 = 0
            r0 = r7
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L32
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3c
            if (r1 == 0) goto L2b
        L28:
            r1.close()
        L2b:
            return r0
        L2c:
            r0 = move-exception
            r1 = r6
        L2e:
            r0 = -1
            if (r1 == 0) goto L2b
            goto L28
        L32:
            r0 = move-exception
        L33:
            if (r6 == 0) goto L38
            r6.close()
        L38:
            throw r0
        L39:
            r0 = move-exception
            r6 = r1
            goto L33
        L3c:
            r0 = move-exception
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2191e.m9860b(android.content.ContentResolver, int, java.lang.String):int");
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0045: MOVE (r7 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:23:0x0045 */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002c A[PHI: r0 r2
  0x002c: PHI (r0v7 int) = (r0v5 int), (r0v15 int) binds: [B:16:0x003a, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE]
  0x002c: PHI (r2v3 android.database.Cursor) = (r2v2 android.database.Cursor), (r2v5 android.database.Cursor) binds: [B:16:0x003a, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m9865c(android.content.ContentResolver r9, int r10) throws java.lang.Throwable {
        /*
            r6 = 0
            r7 = 0
            android.net.Uri r1 = com.sec.chaton.p057e.C2293m.f8204a     // Catch: java.lang.Exception -> L30 java.lang.Throwable -> L3d
            r2 = 0
            java.lang.String r3 = "group_relation_group = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L30 java.lang.Throwable -> L3d
            r0 = 0
            java.lang.String r5 = java.lang.Integer.toString(r10)     // Catch: java.lang.Exception -> L30 java.lang.Throwable -> L3d
            r4[r0] = r5     // Catch: java.lang.Exception -> L30 java.lang.Throwable -> L3d
            r5 = 0
            r0 = r9
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L30 java.lang.Throwable -> L3d
            r2.moveToFirst()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L47
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L47
            if (r0 == 0) goto L52
        L21:
            int r1 = r6 + 1
            boolean r0 = r2.moveToNext()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            if (r0 != 0) goto L50
            r0 = r1
        L2a:
            if (r2 == 0) goto L2f
        L2c:
            r2.close()
        L2f:
            return r0
        L30:
            r0 = move-exception
            r1 = r0
            r2 = r7
            r0 = r6
        L34:
            java.lang.String r3 = "BuddyGroupDatabaseHelper"
            com.sec.chaton.util.C4904y.m18635a(r1, r3)     // Catch: java.lang.Throwable -> L44
            if (r2 == 0) goto L2f
            goto L2c
        L3d:
            r0 = move-exception
        L3e:
            if (r7 == 0) goto L43
            r7.close()
        L43:
            throw r0
        L44:
            r0 = move-exception
            r7 = r2
            goto L3e
        L47:
            r0 = move-exception
            r1 = r0
            r0 = r6
            goto L34
        L4b:
            r0 = move-exception
            r8 = r0
            r0 = r1
            r1 = r8
            goto L34
        L50:
            r6 = r1
            goto L21
        L52:
            r0 = r6
            goto L2a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2191e.m9865c(android.content.ContentResolver, int):int");
    }

    /* renamed from: a */
    public static ContentProviderOperation m9850a(String str, String str2) throws Throwable {
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        Iterator<String> it = C4874cl.m18508a(str, ',').iterator();
        while (it.hasNext()) {
            String next = it.next();
            int iM9867d = m9867d(contentResolver, next);
            if (m9869f(contentResolver, next) && m9865c(contentResolver, iM9867d) == 1 && m9858a(contentResolver, iM9867d, str2)) {
                m9863b(next, str2);
            }
        }
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2293m.f8204a);
        builderNewDelete.withSelection("group_relation_buddy = ?", new String[]{str2});
        return builderNewDelete.build();
    }

    /* renamed from: b */
    private static void m9863b(String str, String str2) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 != iM10677a && -2 != iM10677a) {
            new C2128i(null).m9489a("group", false, str, (String) null, new String[]{str2}, 327);
            C2134o.m9568a((Handler) null, str);
            C2496n.m10794g(CommonApplication.m18732r(), str);
            C4904y.m18641c("The group " + str + " will be removed from server because only has deleted account.", "BuddyGroupDatabaseHelper");
        }
    }

    /* renamed from: a */
    public static ContentProviderOperation m9849a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2293m.f8204a);
        builderNewDelete.withSelection("group_relation_buddy = ?", new String[]{str});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static int m9848a(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_name", str2);
        try {
            return contentResolver.update(C2294n.f8205a, contentValues, "_id = ? ", new String[]{str});
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: a */
    public static void m9857a(ArrayList<ContentProviderOperation> arrayList, Buddy buddy) throws Throwable {
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        HashMap map = new HashMap();
        try {
            if (buddy.group != null && buddy.group.length() > 0) {
                ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                Iterator<String> it = C4874cl.m18508a(buddy.group, ',').iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    C4904y.m18639b("group list : " + next, "BuddyGroupDatabaseHelper");
                    if (next.toLowerCase().equals("Favorites".toLowerCase())) {
                        m9864b(arrayList, buddy);
                    } else {
                        int iM9870g = m9870g(contentResolver, next);
                        C4904y.m18639b(next + " group count : " + iM9870g, "BuddyGroupDatabaseHelper");
                        if (iM9870g == 0) {
                            ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2294n.f8205a);
                            builderNewInsert.withValue("group_name", next);
                            arrayList2.add(builderNewInsert.build());
                            map.put(next, buddy.value);
                        } else {
                            map.put(next, buddy.value);
                        }
                    }
                }
                if (!arrayList2.isEmpty()) {
                    C4904y.m18639b("updateBuddyGroup applyBatch start", "BuddyGroupDatabaseHelper");
                    f7829a.m12392a(arrayList2, false);
                }
                if (map != null && !map.isEmpty()) {
                    ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2293m.f8204a);
                    builderNewDelete.withSelection("group_relation_buddy = ? AND group_relation_group != ? ", new String[]{buddy.value, String.valueOf(1)});
                    C4904y.m18639b("delete group member : " + buddy.value, "BuddyGroupDatabaseHelper");
                    arrayList.add(builderNewDelete.build());
                    for (Map.Entry entry : map.entrySet()) {
                        ContentProviderOperation.Builder builderNewInsert2 = ContentProviderOperation.newInsert(C2293m.f8204a);
                        int iM9867d = m9867d(contentResolver, (String) entry.getKey());
                        builderNewInsert2.withValue("group_relation_group", Integer.valueOf(iM9867d));
                        builderNewInsert2.withValue("group_relation_buddy", entry.getValue());
                        C4904y.m18639b("add group id : " + iM9867d + ", " + ((String) entry.getValue()), "BuddyGroupDatabaseHelper");
                        arrayList.add(builderNewInsert2.build());
                    }
                    return;
                }
                return;
            }
            m9864b(arrayList, buddy);
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public static void m9864b(ArrayList<ContentProviderOperation> arrayList, Buddy buddy) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2293m.f8204a);
        builderNewDelete.withSelection("group_relation_buddy = ? AND group_relation_group != ? ", new String[]{buddy.value, String.valueOf(1)});
        arrayList.add(builderNewDelete.build());
    }

    /* renamed from: a */
    public static void m9853a() throws RemoteException, OperationApplicationException {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        Iterator<Integer> it = m9851a(contentResolver).iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (m9865c(contentResolver, iIntValue) == 0) {
                C4904y.m18639b("try remove dummy group : " + m9868e(contentResolver, Integer.toString(iIntValue)), "BuddyGroupDatabaseHelper");
                ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2294n.f8205a);
                builderNewDelete.withSelection("_id = ?", new String[]{String.valueOf(iIntValue)});
                arrayList.add(builderNewDelete.build());
            }
        }
        try {
            CommonApplication.m18732r().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
