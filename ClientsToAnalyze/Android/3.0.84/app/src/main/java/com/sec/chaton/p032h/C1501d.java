package com.sec.chaton.p032h;

import android.content.Intent;

/* compiled from: InterlockedCalendar.java */
/* renamed from: com.sec.chaton.h.d */
/* loaded from: classes.dex */
public class C1501d implements InterfaceC1498a {

    /* renamed from: a */
    private Intent f5536a;

    public C1501d(Intent intent) {
        this.f5536a = intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0107  */
    @Override // com.sec.chaton.p032h.InterfaceC1498a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sec.chaton.EnumC2947t mo6465a() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p032h.C1501d.mo6465a():com.sec.chaton.t");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m6466a(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r1 = 0
            r4 = 1
            r2 = 0
            if (r6 == 0) goto L92
            java.lang.String r0 = "file://"
            java.lang.String[] r0 = r6.split(r0)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L90
            int r3 = r0.length     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L90
            if (r3 != r4) goto L47
        Le:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L90
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L90
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L90
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L90
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L90
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L90
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L32 java.lang.Throwable -> L8d
            r0.<init>()     // Catch: java.lang.Exception -> L32 java.lang.Throwable -> L8d
        L22:
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Exception -> L32 java.lang.Throwable -> L8d
            if (r1 == 0) goto L5c
            java.lang.StringBuilder r1 = r0.append(r1)     // Catch: java.lang.Exception -> L32 java.lang.Throwable -> L8d
            java.lang.String r3 = "\n"
            r1.append(r3)     // Catch: java.lang.Exception -> L32 java.lang.Throwable -> L8d
            goto L22
        L32:
            r0 = move-exception
            r1 = r2
        L34:
            java.lang.Class r2 = r5.getClass()     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> L7c
            com.sec.chaton.util.C3250y.m11443a(r0, r2)     // Catch: java.lang.Throwable -> L7c
            if (r1 == 0) goto L44
            r1.close()     // Catch: java.io.IOException -> L88
        L44:
            java.lang.String r0 = ""
        L46:
            return r0
        L47:
            int r3 = r0.length     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L90
            r4 = 2
            if (r3 != r4) goto L4f
            r2 = 1
            r6 = r0[r2]     // Catch: java.lang.Throwable -> L7c java.lang.Exception -> L90
            goto Le
        L4f:
            java.lang.String r0 = ""
            if (r1 == 0) goto L46
            r2.close()     // Catch: java.io.IOException -> L57
            goto L46
        L57:
            r1 = move-exception
        L58:
            r1.printStackTrace()
            goto L46
        L5c:
            com.sec.chaton.multimedia.vcalendar.b r1 = new com.sec.chaton.multimedia.vcalendar.b     // Catch: java.lang.Exception -> L32 java.lang.Throwable -> L8d
            r1.<init>()     // Catch: java.lang.Exception -> L32 java.lang.Throwable -> L8d
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L32 java.lang.Throwable -> L8d
            com.sec.chaton.multimedia.vcalendar.j r0 = r1.m7820a(r0)     // Catch: java.lang.Exception -> L32 java.lang.Throwable -> L8d
            java.util.List<com.sec.chaton.multimedia.vcalendar.k> r0 = r0.f7348a     // Catch: java.lang.Exception -> L32 java.lang.Throwable -> L8d
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> L32 java.lang.Throwable -> L8d
            com.sec.chaton.multimedia.vcalendar.k r0 = (com.sec.chaton.multimedia.vcalendar.C1926k) r0     // Catch: java.lang.Exception -> L32 java.lang.Throwable -> L8d
            java.lang.String r0 = r0.f7357i     // Catch: java.lang.Exception -> L32 java.lang.Throwable -> L8d
            if (r2 == 0) goto L46
            r2.close()     // Catch: java.io.IOException -> L7a
            goto L46
        L7a:
            r1 = move-exception
            goto L58
        L7c:
            r0 = move-exception
        L7d:
            if (r1 == 0) goto L82
            r1.close()     // Catch: java.io.IOException -> L83
        L82:
            throw r0
        L83:
            r1 = move-exception
            r1.printStackTrace()
            goto L82
        L88:
            r0 = move-exception
            r0.printStackTrace()
            goto L44
        L8d:
            r0 = move-exception
            r1 = r2
            goto L7d
        L90:
            r0 = move-exception
            goto L34
        L92:
            r6 = r1
            goto Le
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p032h.C1501d.m6466a(java.lang.String):java.lang.String");
    }
}
