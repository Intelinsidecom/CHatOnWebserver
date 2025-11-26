package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: BuddyGroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.el */
/* loaded from: classes.dex */
class C1278el extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileFragment f4811a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1278el(BuddyGroupProfileFragment buddyGroupProfileFragment, Handler handler) {
        super(handler);
        this.f4811a = buddyGroupProfileFragment;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008f  */
    @Override // android.database.ContentObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onChange(boolean r9) throws java.lang.Throwable {
        /*
            r8 = this;
            r6 = 0
            com.sec.chaton.buddy.BuddyGroupProfileFragment r0 = r8.f4811a     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L8b
            android.app.Activity r0 = com.sec.chaton.buddy.BuddyGroupProfileFragment.m6628a(r0)     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L8b
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L8b
            android.net.Uri r1 = com.sec.chaton.p057e.C2293m.f8204a     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L8b
            r2 = 0
            java.lang.String r3 = "group_relation_group = ? "
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L8b
            r5 = 0
            com.sec.chaton.buddy.BuddyGroupProfileFragment r7 = r8.f4811a     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L8b
            com.sec.chaton.buddy.a.b r7 = com.sec.chaton.buddy.BuddyGroupProfileFragment.m6637f(r7)     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L8b
            int r7 = r7.m7034a()     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L8b
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L8b
            r4[r5] = r7     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L8b
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L8b
            if (r1 == 0) goto L71
            com.sec.chaton.buddy.BuddyGroupProfileFragment r0 = r8.f4811a     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            r0.f3805b = r2     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            r0.<init>()     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            java.lang.String r2 = "mObserverGroupMember Group member Count: "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            com.sec.chaton.buddy.BuddyGroupProfileFragment r2 = r8.f4811a     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            int r2 = r2.f3805b     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            java.lang.String r2 = com.sec.chaton.buddy.BuddyGroupProfileFragment.f3785a     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            com.sec.chaton.util.C4904y.m18639b(r0, r2)     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            com.sec.chaton.buddy.BuddyGroupProfileFragment r0 = r8.f4811a     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            android.widget.TextView r0 = com.sec.chaton.buddy.BuddyGroupProfileFragment.m6658u(r0)     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            com.sec.chaton.buddy.BuddyGroupProfileFragment r2 = r8.f4811a     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            r3 = 2131429023(0x7f0b069f, float:1.8479707E38)
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            r5 = 0
            com.sec.chaton.buddy.BuddyGroupProfileFragment r6 = r8.f4811a     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            int r6 = r6.f3805b     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            r4[r5] = r6     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            java.lang.String r2 = r2.getString(r3, r4)     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
            r0.setText(r2)     // Catch: java.lang.Throwable -> L93 java.lang.Exception -> L95
        L71:
            if (r1 == 0) goto L76
        L73:
            r1.close()
        L76:
            return
        L77:
            r0 = move-exception
            r1 = r6
        L79:
            boolean r2 = com.sec.chaton.util.C4904y.f17875e     // Catch: java.lang.Throwable -> L93
            if (r2 == 0) goto L88
            java.lang.Class r2 = r8.getClass()     // Catch: java.lang.Throwable -> L93
            java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> L93
            com.sec.chaton.util.C4904y.m18635a(r0, r2)     // Catch: java.lang.Throwable -> L93
        L88:
            if (r1 == 0) goto L76
            goto L73
        L8b:
            r0 = move-exception
            r1 = r6
        L8d:
            if (r1 == 0) goto L92
            r1.close()
        L92:
            throw r0
        L93:
            r0 = move-exception
            goto L8d
        L95:
            r0 = move-exception
            goto L79
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.C1278el.onChange(boolean):void");
    }
}
