package com.sec.chaton.buddy;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: BuddyGroupProfileFragment.java */
/* renamed from: com.sec.chaton.buddy.em */
/* loaded from: classes.dex */
class C1279em extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileFragment f4812a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C1279em(BuddyGroupProfileFragment buddyGroupProfileFragment, Handler handler) {
        super(handler);
        this.f4812a = buddyGroupProfileFragment;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    @Override // android.database.ContentObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onChange(boolean r9) throws java.lang.Throwable {
        /*
            r8 = this;
            r6 = 0
            com.sec.chaton.buddy.BuddyGroupProfileFragment r0 = r8.f4812a     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L71
            android.app.Activity r0 = com.sec.chaton.buddy.BuddyGroupProfileFragment.m6628a(r0)     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L71
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L71
            android.net.Uri r1 = com.sec.chaton.p057e.C2294n.f8205a     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L71
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L71
            r3 = 0
            java.lang.String r4 = "group_name"
            r2[r3] = r4     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L71
            java.lang.String r3 = "_id = ? "
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L71
            r5 = 0
            com.sec.chaton.buddy.BuddyGroupProfileFragment r7 = r8.f4812a     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L71
            com.sec.chaton.buddy.a.b r7 = com.sec.chaton.buddy.BuddyGroupProfileFragment.m6637f(r7)     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L71
            int r7 = r7.m7034a()     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L71
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L71
            r4[r5] = r7     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L71
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L71
            if (r1 == 0) goto L57
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            if (r0 == 0) goto L57
            java.lang.String r0 = "group_name"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            com.sec.chaton.buddy.BuddyGroupProfileFragment r2 = r8.f4812a     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            android.widget.TextView r2 = com.sec.chaton.buddy.BuddyGroupProfileFragment.m6632c(r2)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            r2.setText(r0)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            com.sec.chaton.buddy.BuddyGroupProfileFragment r2 = r8.f4812a     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            com.sec.chaton.buddy.a.b r2 = com.sec.chaton.buddy.BuddyGroupProfileFragment.m6637f(r2)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
            r2.m7035a(r0)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7b
        L57:
            if (r1 == 0) goto L5c
        L59:
            r1.close()
        L5c:
            return
        L5d:
            r0 = move-exception
            r1 = r6
        L5f:
            boolean r2 = com.sec.chaton.util.C4904y.f17875e     // Catch: java.lang.Throwable -> L78
            if (r2 == 0) goto L6e
            java.lang.Class r2 = r8.getClass()     // Catch: java.lang.Throwable -> L78
            java.lang.String r2 = r2.getSimpleName()     // Catch: java.lang.Throwable -> L78
            com.sec.chaton.util.C4904y.m18635a(r0, r2)     // Catch: java.lang.Throwable -> L78
        L6e:
            if (r1 == 0) goto L5c
            goto L59
        L71:
            r0 = move-exception
        L72:
            if (r6 == 0) goto L77
            r6.close()
        L77:
            throw r0
        L78:
            r0 = move-exception
            r6 = r1
            goto L72
        L7b:
            r0 = move-exception
            goto L5f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.buddy.C1279em.onChange(boolean):void");
    }
}
