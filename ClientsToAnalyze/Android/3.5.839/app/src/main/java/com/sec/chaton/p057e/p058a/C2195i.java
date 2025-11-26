package com.sec.chaton.p057e.p058a;

/* compiled from: CoverstoryDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.i */
/* loaded from: classes.dex */
public class C2195i {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0076 A[PHI: r1 r6
  0x0076: PHI (r1v6 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v8 android.database.Cursor) binds: [B:28:0x00b3, B:14:0x0074] A[DONT_GENERATE, DONT_INLINE]
  0x0076: PHI (r6v2 ??) = (r6v5 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), (r6v4 ??) binds: [B:28:0x00b3, B:14:0x0074] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009e A[Catch: Exception -> 0x00ac, all -> 0x00be, TRY_ENTER, TryCatch #1 {Exception -> 0x00ac, blocks: (B:5:0x0015, B:7:0x001b, B:9:0x001f, B:10:0x003d, B:12:0x0068, B:22:0x009e, B:24:0x00a2), top: B:40:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m9895a() {
        /*
            r6 = 0
            android.content.Context r0 = com.sec.common.CommonApplication.m18732r()     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lc0
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lc0
            android.net.Uri r1 = com.sec.chaton.p057e.C2291k.f8198a     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lc0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lb6 java.lang.Exception -> Lc0
            if (r1 == 0) goto L9e
            int r0 = r1.getCount()     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            if (r0 <= 0) goto L9e
            boolean r0 = com.sec.chaton.util.C4904y.f17872b     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            if (r0 == 0) goto L3d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            r0.<init>()     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            java.lang.String r2 = "getRandomCoverStory cursor.getCount() : "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            int r2 = r1.getCount()     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            java.lang.String r2 = "CoverstoryDatabaseHelper"
            com.sec.chaton.util.C4904y.m18639b(r0, r2)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
        L3d:
            double r2 = java.lang.Math.random()     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            int r0 = r1.getCount()     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            double r4 = (double) r0     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            double r2 = r2 * r4
            int r0 = (int) r2     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            r2.<init>()     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            java.lang.String r3 = "getRandomCoverStory random : "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            java.lang.String r3 = "CoverstoryDatabaseHelper"
            com.sec.chaton.util.C4904y.m18639b(r2, r3)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            boolean r0 = r1.moveToPosition(r0)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            if (r0 == 0) goto Lc3
            java.lang.String r0 = "coverstory_id"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
        L73:
            r6 = r0
        L74:
            if (r1 == 0) goto L79
        L76:
            r1.close()
        L79:
            boolean r0 = com.sec.chaton.util.C4904y.f17872b
            if (r0 == 0) goto L9d
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L9d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "randomId : "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "CoverstoryDatabaseHelper"
            com.sec.chaton.util.C4904y.m18639b(r0, r1)
        L9d:
            return r6
        L9e:
            boolean r0 = com.sec.chaton.util.C4904y.f17872b     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            if (r0 == 0) goto L74
            java.lang.String r0 = "Fail : "
            java.lang.String r2 = "CoverstoryDatabaseHelper"
            com.sec.chaton.util.C4904y.m18639b(r0, r2)     // Catch: java.lang.Exception -> Lac java.lang.Throwable -> Lbe
            goto L74
        Lac:
            r0 = move-exception
        Lad:
            java.lang.String r2 = "CoverstoryDatabaseHelper"
            com.sec.chaton.util.C4904y.m18635a(r0, r2)     // Catch: java.lang.Throwable -> Lbe
            if (r1 == 0) goto L79
            goto L76
        Lb6:
            r0 = move-exception
            r1 = r6
        Lb8:
            if (r1 == 0) goto Lbd
            r1.close()
        Lbd:
            throw r0
        Lbe:
            r0 = move-exception
            goto Lb8
        Lc0:
            r0 = move-exception
            r1 = r6
            goto Lad
        Lc3:
            r0 = r6
            goto L73
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2195i.m9895a():java.lang.String");
    }
}
