package com.sec.chaton.p027e.p028a;

/* compiled from: CoverstoryDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.i */
/* loaded from: classes.dex */
public class C1365i {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0077 A[PHI: r1 r6
  0x0077: PHI (r1v6 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v8 android.database.Cursor) binds: [B:32:0x00b5, B:16:0x0075] A[DONT_GENERATE, DONT_INLINE]
  0x0077: PHI (r6v2 ??) = (r6v6 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), (r6v9 ??) binds: [B:32:0x00b5, B:16:0x0075] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009d A[Catch: Exception -> 0x00a9, all -> 0x00c6, TRY_ENTER, TryCatch #0 {all -> 0x00c6, blocks: (B:5:0x0015, B:7:0x001b, B:9:0x001f, B:10:0x003b, B:12:0x0064, B:24:0x009d, B:26:0x00a1, B:29:0x00aa), top: B:46:0x0001 }] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m6090a() {
        /*
            r6 = 0
            android.content.Context r0 = com.sec.common.CommonApplication.m11493l()     // Catch: java.lang.Throwable -> Lb8 java.lang.Exception -> Lc8
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> Lb8 java.lang.Exception -> Lc8
            android.net.Uri r1 = com.sec.chaton.p027e.C1443k.f5371a     // Catch: java.lang.Throwable -> Lb8 java.lang.Exception -> Lc8
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lb8 java.lang.Exception -> Lc8
            if (r1 == 0) goto L9d
            int r0 = r1.getCount()     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            if (r0 <= 0) goto L9d
            boolean r0 = com.sec.chaton.util.C3250y.f11734b     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            if (r0 == 0) goto L3b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            r0.<init>()     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            java.lang.String r2 = " Kmission getRandomCoverStory cursor.getCount() : "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            int r2 = r1.getCount()     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            java.lang.String r2 = "CoverstoryDatabaseHelper"
            com.sec.chaton.util.C3250y.m11450b(r0, r2)     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
        L3b:
            double r2 = java.lang.Math.random()     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            int r0 = r1.getCount()     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            double r4 = (double) r0     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            double r2 = r2 * r4
            int r0 = (int) r2     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            r2.<init>()     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            java.lang.String r3 = " Kmission getRandomCoverStory random : "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            java.lang.String r3 = "CoverstoryDatabaseHelper"
            com.sec.chaton.util.C3250y.m11450b(r2, r3)     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            boolean r0 = r1.moveToPosition(r0)     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            if (r0 == 0) goto Lcb
            java.lang.String r0 = "coverstory_id"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
        L6e:
            r6 = r0
        L6f:
            if (r1 == 0) goto L7a
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto L7a
        L77:
            r1.close()
        L7a:
            boolean r0 = com.sec.chaton.util.C3250y.f11734b
            if (r0 == 0) goto L9c
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L9c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = " Kmission randomId : "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "CoverstoryDatabaseHelper"
            com.sec.chaton.util.C3250y.m11450b(r0, r1)
        L9c:
            return r6
        L9d:
            boolean r0 = com.sec.chaton.util.C3250y.f11734b     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            if (r0 == 0) goto L6f
            java.lang.String r0 = " Kmission Fail : "
            java.lang.String r2 = "CoverstoryDatabaseHelper"
            com.sec.chaton.util.C3250y.m11450b(r0, r2)     // Catch: java.lang.Exception -> La9 java.lang.Throwable -> Lc6
            goto L6f
        La9:
            r0 = move-exception
        Laa:
            java.lang.String r2 = "CoverstoryDatabaseHelper"
            com.sec.chaton.util.C3250y.m11443a(r0, r2)     // Catch: java.lang.Throwable -> Lc6
            if (r1 == 0) goto L7a
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto L7a
            goto L77
        Lb8:
            r0 = move-exception
            r1 = r6
        Lba:
            if (r1 == 0) goto Lc5
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto Lc5
            r1.close()
        Lc5:
            throw r0
        Lc6:
            r0 = move-exception
            goto Lba
        Lc8:
            r0 = move-exception
            r1 = r6
            goto Laa
        Lcb:
            r0 = r6
            goto L6e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p027e.p028a.C1365i.m6090a():java.lang.String");
    }
}
