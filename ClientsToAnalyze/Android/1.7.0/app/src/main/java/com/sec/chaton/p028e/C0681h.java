package com.sec.chaton.p028e;

import android.content.Intent;

/* compiled from: InterlockedContact.java */
/* renamed from: com.sec.chaton.e.h */
/* loaded from: classes.dex */
public class C0681h implements InterfaceC0679f {

    /* renamed from: a */
    private Intent f2327a;

    public C0681h(Intent intent) {
        this.f2327a = intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009b  */
    @Override // com.sec.chaton.p028e.InterfaceC0679f
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sec.chaton.EnumC0250am mo3045a() throws java.lang.Throwable {
        /*
            r7 = this;
            android.content.Intent r0 = r7.f2327a
            java.lang.String r1 = "content_type"
            com.sec.chaton.d.d r2 = com.sec.chaton.p025d.EnumC0651d.CONTACT
            int r2 = r2.m2978a()
            r0.putExtra(r1, r2)
            android.content.Intent r0 = r7.f2327a
            android.os.Bundle r0 = r0.getExtras()
            java.lang.String r1 = "android.intent.extra.STREAM"
            java.lang.Object r1 = r0.get(r1)
            android.net.Uri r1 = (android.net.Uri) r1
            java.lang.String r6 = ""
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m3100a()     // Catch: java.lang.SecurityException -> L82
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.SecurityException -> L82
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.SecurityException -> L82
            if (r2 == 0) goto L9b
            boolean r0 = r2.moveToNext()     // Catch: java.lang.Throwable -> L86
            if (r0 == 0) goto L9b
            java.lang.String r0 = "_display_name"
            int r0 = r2.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L86
            java.lang.String r0 = r2.getString(r0)     // Catch: java.lang.Throwable -> L86
        L3f:
            if (r2 == 0) goto L44
            r2.close()
        L44:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L98
            android.content.Intent r2 = r7.f2327a
            java.lang.String r3 = "callForward"
            r4 = 1
            r2.putExtra(r3, r4)
            android.content.Intent r2 = r7.f2327a     // Catch: java.lang.StringIndexOutOfBoundsException -> L8d
            java.lang.String r3 = "sub_content"
            r4 = 0
            java.lang.String r5 = "."
            int r5 = r0.lastIndexOf(r5)     // Catch: java.lang.StringIndexOutOfBoundsException -> L8d
            java.lang.String r0 = r0.substring(r4, r5)     // Catch: java.lang.StringIndexOutOfBoundsException -> L8d
            r2.putExtra(r3, r0)     // Catch: java.lang.StringIndexOutOfBoundsException -> L8d
        L64:
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r2 = "vcf"
            android.net.Uri r0 = com.sec.chaton.p028e.C0682i.m3047a(r1, r0, r2)
            if (r0 == 0) goto L98
            android.content.Intent r1 = r7.f2327a
            java.lang.String r2 = "download_uri"
            java.lang.String r0 = r0.toString()
            r1.putExtra(r2, r0)
            com.sec.chaton.am r0 = com.sec.chaton.EnumC0250am.FORWARD
        L81:
            return r0
        L82:
            r0 = move-exception
            com.sec.chaton.am r0 = com.sec.chaton.EnumC0250am.HOME
            goto L81
        L86:
            r0 = move-exception
            if (r2 == 0) goto L8c
            r2.close()
        L8c:
            throw r0
        L8d:
            r0 = move-exception
            android.content.Intent r0 = r7.f2327a
            java.lang.String r2 = "sub_content"
            java.lang.String r3 = ""
            r0.putExtra(r2, r3)
            goto L64
        L98:
            com.sec.chaton.am r0 = com.sec.chaton.EnumC0250am.HOME
            goto L81
        L9b:
            r0 = r6
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p028e.C0681h.mo3045a():com.sec.chaton.am");
    }
}
