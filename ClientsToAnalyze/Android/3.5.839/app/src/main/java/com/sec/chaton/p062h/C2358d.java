package com.sec.chaton.p062h;

import android.content.Intent;

/* compiled from: InterlockedCalendar.java */
/* renamed from: com.sec.chaton.h.d */
/* loaded from: classes.dex */
public class C2358d implements InterfaceC2355a {

    /* renamed from: a */
    private Intent f8389a;

    /* renamed from: a */
    public static C2358d m10313a(Intent intent) {
        return new C2358d(intent);
    }

    private C2358d(Intent intent) {
        this.f8389a = intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0117  */
    @Override // com.sec.chaton.p062h.InterfaceC2355a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sec.chaton.chat.EnumC1761hg mo10310a() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p062h.C2358d.mo10310a():com.sec.chaton.chat.hg");
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m10314a(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r1 = 0
            r4 = 1
            r2 = 0
            if (r6 == 0) goto L96
            java.lang.String r0 = "file://"
            java.lang.String[] r0 = r6.split(r0)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L94
            int r3 = r0.length     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L94
            if (r3 != r4) goto L4a
        Lf:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L94
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L94
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L94
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L94
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L94
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L94
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L91
            r0.<init>()     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L91
        L23:
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L91
            if (r1 == 0) goto L60
            java.lang.StringBuilder r1 = r0.append(r1)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L91
            java.lang.String r3 = "\n"
            r1.append(r3)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L91
            goto L23
        L34:
            r0 = move-exception
            r1 = r2
        L36:
            java.lang.Class r2 = r5.getClass()     // Catch: java.lang.Throwable -> L80
            java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> L80
            com.sec.chaton.util.C4904y.m18635a(r0, r2)     // Catch: java.lang.Throwable -> L80
            if (r1 == 0) goto L46
            r1.close()     // Catch: java.io.IOException -> L8c
        L46:
            java.lang.String r0 = ""
        L49:
            return r0
        L4a:
            int r3 = r0.length     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L94
            r4 = 2
            if (r3 != r4) goto L52
            r2 = 1
            r6 = r0[r2]     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L94
            goto Lf
        L52:
            java.lang.String r0 = ""
            if (r1 == 0) goto L49
            r2.close()     // Catch: java.io.IOException -> L5b
            goto L49
        L5b:
            r1 = move-exception
        L5c:
            r1.printStackTrace()
            goto L49
        L60:
            com.sec.chaton.multimedia.vcalendar.b r1 = new com.sec.chaton.multimedia.vcalendar.b     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L91
            r1.<init>()     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L91
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L91
            com.sec.chaton.multimedia.vcalendar.j r0 = r1.m12050a(r0)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L91
            java.util.List<com.sec.chaton.multimedia.vcalendar.k> r0 = r0.f10669a     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L91
            r1 = 0
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L91
            com.sec.chaton.multimedia.vcalendar.k r0 = (com.sec.chaton.multimedia.vcalendar.C2895k) r0     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L91
            java.lang.String r0 = r0.f10678i     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L91
            if (r2 == 0) goto L49
            r2.close()     // Catch: java.io.IOException -> L7e
            goto L49
        L7e:
            r1 = move-exception
            goto L5c
        L80:
            r0 = move-exception
        L81:
            if (r1 == 0) goto L86
            r1.close()     // Catch: java.io.IOException -> L87
        L86:
            throw r0
        L87:
            r1 = move-exception
            r1.printStackTrace()
            goto L86
        L8c:
            r0 = move-exception
            r0.printStackTrace()
            goto L46
        L91:
            r0 = move-exception
            r1 = r2
            goto L81
        L94:
            r0 = move-exception
            goto L36
        L96:
            r6 = r1
            goto Lf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p062h.C2358d.m10314a(java.lang.String):java.lang.String");
    }
}
