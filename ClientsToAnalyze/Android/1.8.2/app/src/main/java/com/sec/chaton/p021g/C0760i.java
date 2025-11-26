package com.sec.chaton.p021g;

import android.content.Intent;

/* compiled from: InterlockedVideo.java */
/* renamed from: com.sec.chaton.g.i */
/* loaded from: classes.dex */
public class C0760i implements InterfaceC0752a {

    /* renamed from: a */
    private Intent f2774a;

    public C0760i(Intent intent) {
        this.f2774a = intent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072 A[DONT_GENERATE, PHI: r0
  0x0072: PHI (r0v23 com.sec.chaton.m) = (r0v22 com.sec.chaton.m), (r0v27 com.sec.chaton.m) binds: [B:19:0x007c, B:13:0x0070] A[DONT_GENERATE, DONT_INLINE]] */
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
    @Override // com.sec.chaton.p021g.InterfaceC0752a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sec.chaton.EnumC0836m mo3250a() {
        /*
            r6 = this;
            android.content.Intent r0 = r6.f2774a
            java.lang.String r1 = "callForward"
            r2 = 1
            r0.putExtra(r1, r2)
            android.content.Intent r0 = r6.f2774a
            java.lang.String r1 = "content_type"
            com.sec.chaton.e.n r2 = com.sec.chaton.p017e.EnumC0699n.VIDEO
            int r2 = r2.m3162a()
            r0.putExtra(r1, r2)
            android.content.Intent r0 = r6.f2774a
            android.os.Bundle r0 = r0.getExtras()
            java.lang.String r1 = "android.intent.extra.STREAM"
            java.lang.Object r1 = r0.get(r1)
            android.net.Uri r1 = (android.net.Uri) r1
            java.lang.String r0 = r1.getScheme()
            if (r0 == 0) goto L86
            java.lang.String r0 = r1.getScheme()
            java.lang.String r2 = "content"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L86
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m3260b()     // Catch: java.lang.SecurityException -> L76
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.SecurityException -> L76
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.SecurityException -> L76
            if (r1 == 0) goto La6
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L7f
            if (r0 == 0) goto La6
            java.lang.String r0 = "_data"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7f
            r2 = -1
            if (r0 == r2) goto L7a
            android.content.Intent r2 = r6.f2774a     // Catch: java.lang.Throwable -> L7f
            java.lang.String r3 = "download_uri"
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L7f
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L7f
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L7f
            android.net.Uri r0 = android.net.Uri.fromFile(r4)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L7f
            r2.putExtra(r3, r0)     // Catch: java.lang.Throwable -> L7f
            com.sec.chaton.m r0 = com.sec.chaton.EnumC0836m.FORWARD     // Catch: java.lang.Throwable -> L7f
            if (r1 == 0) goto L75
        L72:
            r1.close()
        L75:
            return r0
        L76:
            r0 = move-exception
            com.sec.chaton.m r0 = com.sec.chaton.EnumC0836m.HOME
            goto L75
        L7a:
            com.sec.chaton.m r0 = com.sec.chaton.EnumC0836m.HOME     // Catch: java.lang.Throwable -> L7f
            if (r1 == 0) goto L75
            goto L72
        L7f:
            r0 = move-exception
            if (r1 == 0) goto L85
            r1.close()
        L85:
            throw r0
        L86:
            java.lang.String r0 = r1.getScheme()
            if (r0 == 0) goto Lab
            java.lang.String r0 = r1.getScheme()
            java.lang.String r2 = "file"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto Lab
            android.content.Intent r0 = r6.f2774a
            java.lang.String r2 = "download_uri"
            java.lang.String r1 = r1.toString()
            r0.putExtra(r2, r1)
            com.sec.chaton.m r0 = com.sec.chaton.EnumC0836m.FORWARD
            goto L75
        La6:
            if (r1 == 0) goto Lab
            r1.close()
        Lab:
            com.sec.chaton.m r0 = com.sec.chaton.EnumC0836m.HOME
            goto L75
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p021g.C0760i.mo3250a():com.sec.chaton.m");
    }
}
