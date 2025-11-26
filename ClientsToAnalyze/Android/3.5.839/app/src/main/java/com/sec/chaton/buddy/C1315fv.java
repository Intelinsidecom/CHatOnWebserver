package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: BuddyProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.fv */
/* loaded from: classes.dex */
class C1315fv extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileFragment f4851a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1315fv(BuddyProfileFragment buddyProfileFragment, Handler handler) {
        super(handler);
        this.f4851a = buddyProfileFragment;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
    @Override // android.database.ContentObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onChange(boolean r9) throws java.lang.Throwable {
        /*
            r8 = this;
            r6 = 0
            com.sec.chaton.buddy.BuddyProfileFragment r0 = r8.f4851a     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L86
            android.app.Activity r0 = com.sec.chaton.buddy.BuddyProfileFragment.m6798b(r0)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L86
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L86
            android.net.Uri r1 = com.sec.chaton.p057e.C2289i.f8196a     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L86
            r2 = 0
            java.lang.String r3 = "buddy_no = ? "
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L86
            r5 = 0
            com.sec.chaton.buddy.BuddyProfileFragment r7 = r8.f4851a     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L86
            java.lang.String r7 = com.sec.chaton.buddy.BuddyProfileFragment.m6781a(r7)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L86
            r4[r5] = r7     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L86
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L79 java.lang.Exception -> L86
        L22:
            if (r1 == 0) goto L81
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> L84
            if (r0 == 0) goto L81
            java.lang.String r0 = "buddy_name"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> L84
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> L84
            java.lang.String r2 = "buddy_status_message"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> L84
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> L84
            com.sec.chaton.buddy.BuddyProfileFragment r3 = r8.f4851a     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> L84
            android.widget.TextView r3 = com.sec.chaton.buddy.BuddyProfileFragment.m6822g(r3)     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> L84
            if (r3 == 0) goto L51
            com.sec.chaton.buddy.BuddyProfileFragment r3 = r8.f4851a     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> L84
            android.widget.TextView r3 = com.sec.chaton.buddy.BuddyProfileFragment.m6822g(r3)     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> L84
            r3.setText(r0)     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> L84
        L51:
            com.sec.chaton.buddy.BuddyProfileFragment r0 = r8.f4851a     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> L84
            android.widget.TextView r0 = com.sec.chaton.buddy.BuddyProfileFragment.m6796ai(r0)     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> L84
            if (r0 == 0) goto L22
            com.sec.chaton.buddy.BuddyProfileFragment r0 = r8.f4851a     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> L84
            android.widget.TextView r0 = com.sec.chaton.buddy.BuddyProfileFragment.m6796ai(r0)     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> L84
            r0.setText(r2)     // Catch: java.lang.Exception -> L63 java.lang.Throwable -> L84
            goto L22
        L63:
            r0 = move-exception
        L64:
            boolean r2 = com.sec.chaton.util.C4904y.f17875e     // Catch: java.lang.Throwable -> L84
            if (r2 == 0) goto L73
            java.lang.Class r2 = r8.getClass()     // Catch: java.lang.Throwable -> L84
            java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> L84
            com.sec.chaton.util.C4904y.m18635a(r0, r2)     // Catch: java.lang.Throwable -> L84
        L73:
            if (r1 == 0) goto L78
        L75:
            r1.close()
        L78:
            return
        L79:
            r0 = move-exception
            r1 = r6
        L7b:
            if (r1 == 0) goto L80
            r1.close()
        L80:
            throw r0
        L81:
            if (r1 == 0) goto L78
            goto L75
        L84:
            r0 = move-exception
            goto L7b
        L86:
            r0 = move-exception
            r1 = r6
            goto L64
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.C1315fv.onChange(boolean):void");
    }
}
