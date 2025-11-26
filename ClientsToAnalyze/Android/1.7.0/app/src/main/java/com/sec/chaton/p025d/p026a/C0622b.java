package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.RemoteException;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C0661n;
import com.sec.chaton.p025d.C0668u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: BuddyGroupDatabaseHelper.java */
/* renamed from: com.sec.chaton.d.a.b */
/* loaded from: classes.dex */
public class C0622b {
    /* renamed from: a */
    public static void m2845a(ContentResolver contentResolver, String str) {
        try {
            contentResolver.delete(C0668u.f2311a, "group_relation_group = ? ", new String[]{str});
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public static void m2846b(ContentResolver contentResolver, String str) {
        try {
            contentResolver.delete(C0661n.f2288a, "_id = ? ", new String[]{str});
            C0634n.m2916f(GlobalApplication.m3100a().getContentResolver(), str);
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    public static Uri m2847c(ContentResolver contentResolver, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_name", str);
        try {
            return contentResolver.insert(C0661n.f2288a, contentValues);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m2848d(android.content.ContentResolver r9, java.lang.String r10) throws java.lang.Throwable {
        /*
            r8 = 1
            r7 = 0
            r6 = -1
            android.net.Uri r1 = com.sec.chaton.p025d.C0661n.f2288a     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L39
            r2 = 0
            java.lang.String r3 = "group_name = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L39
            r0 = 0
            r4[r0] = r10     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L39
            r5 = 0
            r0 = r9
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L39
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            if (r0 != r8) goto L45
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.lang.String r0 = "_id"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
        L27:
            if (r1 == 0) goto L2c
            r1.close()
        L2c:
            return r0
        L2d:
            r0 = move-exception
            r1 = r7
        L2f:
            com.sec.chaton.util.C1341p.m4652a(r0)     // Catch: java.lang.Throwable -> L41
            if (r1 == 0) goto L37
            r1.close()
        L37:
            r0 = r6
            goto L2c
        L39:
            r0 = move-exception
            r1 = r7
        L3b:
            if (r1 == 0) goto L40
            r1.close()
        L40:
            throw r0
        L41:
            r0 = move-exception
            goto L3b
        L43:
            r0 = move-exception
            goto L2f
        L45:
            r0 = r6
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p025d.p026a.C0622b.m2848d(android.content.ContentResolver, java.lang.String):int");
    }

    /* renamed from: a */
    public static void m2843a(ContentResolver contentResolver, int i, Collection collection) {
        m2844a(contentResolver, i, collection, false);
    }

    /* renamed from: a */
    public static void m2844a(ContentResolver contentResolver, int i, Collection collection, boolean z) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        if (z) {
            try {
                ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C0668u.f2311a);
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
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C0668u.f2311a);
            builderNewInsert.withValue("group_relation_group", Integer.valueOf(i));
            builderNewInsert.withValue("group_relation_buddy", str);
            arrayList.add(builderNewInsert.build());
        }
        GlobalApplication.m3100a().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
        C0634n.m2888a(GlobalApplication.m3100a().getContentResolver(), i);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001f A[PHI: r0 r1
  0x001f: PHI (r0v5 int) = (r0v3 int), (r0v13 int) binds: [B:11:0x0026, B:5:0x001d] A[DONT_GENERATE, DONT_INLINE]
  0x001f: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:11:0x0026, B:5:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m2849e(android.content.ContentResolver r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            r6 = 0
            android.net.Uri r1 = com.sec.chaton.p025d.C0661n.f2288a     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L29
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L29
            r0 = 0
            java.lang.String r3 = "group_name"
            r2[r0] = r3     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L29
            java.lang.String r3 = "group_name = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L29
            r0 = 0
            r4[r0] = r8     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L29
            r5 = 0
            r0 = r7
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L29
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            if (r1 == 0) goto L22
        L1f:
            r1.close()
        L22:
            return r0
        L23:
            r0 = move-exception
            r1 = r6
        L25:
            r0 = -1
            if (r1 == 0) goto L22
            goto L1f
        L29:
            r0 = move-exception
        L2a:
            if (r6 == 0) goto L2f
            r6.close()
        L2f:
            throw r0
        L30:
            r0 = move-exception
            r6 = r1
            goto L2a
        L33:
            r0 = move-exception
            goto L25
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p025d.p026a.C0622b.m2849e(android.content.ContentResolver, java.lang.String):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0026 A[PHI: r0 r1
  0x0026: PHI (r0v5 int) = (r0v3 int), (r0v14 int) binds: [B:11:0x002d, B:5:0x0024] A[DONT_GENERATE, DONT_INLINE]
  0x0026: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:11:0x002d, B:5:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m2840a(android.content.ContentResolver r7, int r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r6 = 0
            android.net.Uri r1 = com.sec.chaton.p025d.C0661n.f2288a     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
            r0 = 0
            java.lang.String r3 = "group_name"
            r2[r0] = r3     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
            java.lang.String r3 = "group_name = ? AND _id != ? "
            r0 = 2
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
            r0 = 0
            r4[r0] = r9     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
            r0 = 1
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
            r4[r0] = r5     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
            r5 = 0
            r0 = r7
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            if (r1 == 0) goto L29
        L26:
            r1.close()
        L29:
            return r0
        L2a:
            r0 = move-exception
            r1 = r6
        L2c:
            r0 = -1
            if (r1 == 0) goto L29
            goto L26
        L30:
            r0 = move-exception
        L31:
            if (r6 == 0) goto L36
            r6.close()
        L36:
            throw r0
        L37:
            r0 = move-exception
            r6 = r1
            goto L31
        L3a:
            r0 = move-exception
            goto L2c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p025d.p026a.C0622b.m2840a(android.content.ContentResolver, int, java.lang.String):int");
    }

    /* renamed from: a */
    public static ContentProviderOperation m2842a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C0668u.f2311a);
        builderNewDelete.withSelection("group_relation_buddy = ?", new String[]{str});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static int m2841a(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_name", str2);
        try {
            return contentResolver.update(C0661n.f2288a, contentValues, "_id = ? ", new String[]{str});
        } catch (Exception e) {
            return 0;
        }
    }
}
