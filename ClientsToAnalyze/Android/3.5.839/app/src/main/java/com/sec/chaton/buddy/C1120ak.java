package com.sec.chaton.buddy;

import android.net.Uri;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.ak */
/* loaded from: classes.dex */
class C1120ak implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ C1113ad f4328a;

    C1120ak(C1113ad c1113ad) {
        this.f4328a = c1113ad;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038 A[DONT_GENERATE] */
    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo7100a(int r4, java.lang.Object r5, android.database.Cursor r6) {
        /*
            r3 = this;
            r0 = 1000(0x3e8, float:1.401E-42)
            if (r4 != r0) goto L46
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.sec.chaton.buddy.C1113ad.f4284b = r0
            if (r6 == 0) goto L36
            int r0 = r6.getCount()     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L64
            if (r0 == 0) goto L36
            r6.moveToFirst()     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L64
        L16:
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = com.sec.chaton.buddy.C1113ad.f4284b     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L64
            java.lang.String r1 = "buddy_no"
            int r1 = r6.getColumnIndex(r1)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L64
            java.lang.String r1 = r6.getString(r1)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L64
            r2 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L64
            r0.put(r1, r2)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L64
            boolean r0 = r6.moveToNext()     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L64
            if (r0 != 0) goto L16
            if (r6 == 0) goto L36
            r6.close()     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L64
        L36:
            if (r6 == 0) goto L41
            boolean r0 = r6.isClosed()
            if (r0 != 0) goto L41
        L3e:
            r6.close()
        L41:
            com.sec.chaton.buddy.ad r0 = r3.f4328a
            r0.notifyDataSetChanged()
        L46:
            return
        L47:
            r0 = move-exception
            boolean r1 = com.sec.chaton.util.C4904y.f17872b     // Catch: java.lang.Throwable -> L64
            if (r1 == 0) goto L5b
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L64
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L64
            java.lang.String r1 = r1.getSimpleName()     // Catch: java.lang.Throwable -> L64
            com.sec.chaton.util.C4904y.m18639b(r0, r1)     // Catch: java.lang.Throwable -> L64
        L5b:
            if (r6 == 0) goto L41
            boolean r0 = r6.isClosed()
            if (r0 != 0) goto L41
            goto L3e
        L64:
            r0 = move-exception
            if (r6 == 0) goto L70
            boolean r1 = r6.isClosed()
            if (r1 != 0) goto L70
            r6.close()
        L70:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.C1120ak.mo7100a(int, java.lang.Object, android.database.Cursor):void");
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
