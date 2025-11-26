package com.sec.chaton.p028e;

import android.content.Intent;

/* compiled from: InterlockedVideo.java */
/* renamed from: com.sec.chaton.e.b */
/* loaded from: classes.dex */
public class C0675b implements InterfaceC0679f {

    /* renamed from: a */
    private Intent f2323a;

    public C0675b(Intent intent) {
        this.f2323a = intent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0077 A[DONT_GENERATE, PHI: r0
  0x0077: PHI (r0v23 com.sec.chaton.am) = (r0v22 com.sec.chaton.am), (r0v27 com.sec.chaton.am) binds: [B:22:0x0081, B:17:0x0075] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r0v18, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [android.database.Cursor] */
    @Override // com.sec.chaton.p028e.InterfaceC0679f
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sec.chaton.EnumC0250am mo3045a() {
        /*
            r6 = this;
            android.content.Intent r0 = r6.f2323a
            java.lang.String r1 = "callForward"
            r2 = 1
            r0.putExtra(r1, r2)
            android.content.Intent r0 = r6.f2323a
            java.lang.String r1 = "content_type"
            com.sec.chaton.d.d r2 = com.sec.chaton.p025d.EnumC0651d.VIDEO
            int r2 = r2.m2978a()
            r0.putExtra(r1, r2)
            android.content.Intent r0 = r6.f2323a
            android.os.Bundle r0 = r0.getExtras()
            java.lang.String r1 = "android.intent.extra.STREAM"
            java.lang.Object r1 = r0.get(r1)
            android.net.Uri r1 = (android.net.Uri) r1
            if (r1 != 0) goto L28
            com.sec.chaton.am r0 = com.sec.chaton.EnumC0250am.HOME
        L27:
            return r0
        L28:
            java.lang.String r0 = r1.getScheme()
            if (r0 == 0) goto L8b
            java.lang.String r0 = r1.getScheme()
            java.lang.String r2 = "content"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L8b
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m3100a()     // Catch: java.lang.SecurityException -> L7b
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.SecurityException -> L7b
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.SecurityException -> L7b
            if (r1 == 0) goto Lac
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L84
            if (r0 == 0) goto Lac
            java.lang.String r0 = "_data"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L84
            r2 = -1
            if (r0 == r2) goto L7f
            android.content.Intent r2 = r6.f2323a     // Catch: java.lang.Throwable -> L84
            java.lang.String r3 = "download_uri"
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L84
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L84
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L84
            android.net.Uri r0 = android.net.Uri.fromFile(r4)     // Catch: java.lang.Throwable -> L84
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L84
            r2.putExtra(r3, r0)     // Catch: java.lang.Throwable -> L84
            com.sec.chaton.am r0 = com.sec.chaton.EnumC0250am.FORWARD     // Catch: java.lang.Throwable -> L84
            if (r1 == 0) goto L27
        L77:
            r1.close()
            goto L27
        L7b:
            r0 = move-exception
            com.sec.chaton.am r0 = com.sec.chaton.EnumC0250am.HOME
            goto L27
        L7f:
            com.sec.chaton.am r0 = com.sec.chaton.EnumC0250am.HOME     // Catch: java.lang.Throwable -> L84
            if (r1 == 0) goto L27
            goto L77
        L84:
            r0 = move-exception
            if (r1 == 0) goto L8a
            r1.close()
        L8a:
            throw r0
        L8b:
            java.lang.String r0 = r1.getScheme()
            if (r0 == 0) goto Lb1
            java.lang.String r0 = r1.getScheme()
            java.lang.String r2 = "file"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto Lb1
            android.content.Intent r0 = r6.f2323a
            java.lang.String r2 = "download_uri"
            java.lang.String r1 = r1.toString()
            r0.putExtra(r2, r1)
            com.sec.chaton.am r0 = com.sec.chaton.EnumC0250am.FORWARD
            goto L27
        Lac:
            if (r1 == 0) goto Lb1
            r1.close()
        Lb1:
            com.sec.chaton.am r0 = com.sec.chaton.EnumC0250am.HOME
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p028e.C0675b.mo3045a():com.sec.chaton.am");
    }
}
