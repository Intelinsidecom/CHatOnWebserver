package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import com.sec.chaton.p057e.C2232at;

/* compiled from: UnknownBuddyDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.am */
/* loaded from: classes.dex */
public class C2187am {
    /* renamed from: a */
    public static ContentProviderOperation m9780a(String str, String str2) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2232at.f7977a);
        builderNewInsert.withValue("buddy_no", str);
        builderNewInsert.withValue("buddy_original_name", str2);
        builderNewInsert.withValue("blocked", 1);
        builderNewInsert.withValue("hided", 0);
        return builderNewInsert.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m9782b(String str, String str2) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2232at.f7977a);
        builderNewInsert.withValue("buddy_no", str);
        builderNewInsert.withValue("buddy_original_name", str2);
        builderNewInsert.withValue("blocked", 0);
        builderNewInsert.withValue("hided", 1);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9779a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2232at.f7977a);
        builderNewDelete.withSelection("buddy_no=?", new String[]{str});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9778a() {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2232at.f7977a);
        builderNewDelete.withSelection("blocked=?", new String[]{Integer.toString(1)});
        return builderNewDelete.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m9781b() {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2232at.f7977a);
        builderNewDelete.withSelection("hided=?", new String[]{Integer.toString(1)});
        return builderNewDelete.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m9783b(java.lang.String r9) throws java.lang.Throwable {
        /*
            r7 = 1
            r8 = 0
            r6 = 0
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m18732r()     // Catch: java.lang.Throwable -> L2d
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L2d
            android.net.Uri r1 = com.sec.chaton.p057e.C2232at.f7977a     // Catch: java.lang.Throwable -> L2d
            r2 = 0
            java.lang.String r3 = "buddy_no=? AND hided=1"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L2d
            r5 = 0
            r4[r5] = r9     // Catch: java.lang.Throwable -> L2d
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L2d
            if (r1 == 0) goto L2b
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L35
            if (r0 == 0) goto L2b
            r0 = r7
        L25:
            if (r1 == 0) goto L2a
            r1.close()
        L2a:
            return r0
        L2b:
            r0 = r8
            goto L25
        L2d:
            r0 = move-exception
            r1 = r6
        L2f:
            if (r1 == 0) goto L34
            r1.close()
        L34:
            throw r0
        L35:
            r0 = move-exception
            goto L2f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2187am.m9783b(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m9784c(java.lang.String r8) throws java.lang.Throwable {
        /*
            r6 = 0
            java.lang.String r7 = ""
            android.content.Context r0 = com.sec.chaton.global.GlobalApplication.m18732r()     // Catch: java.lang.Throwable -> L3c
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L3c
            android.net.Uri r1 = com.sec.chaton.p057e.C2232at.f7977a     // Catch: java.lang.Throwable -> L3c
            r2 = 0
            java.lang.String r3 = "buddy_no = ? "
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L3c
            r5 = 0
            r4[r5] = r8     // Catch: java.lang.Throwable -> L3c
            r5 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L3c
            if (r1 == 0) goto L46
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto L46
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto L46
            java.lang.String r0 = "buddy_original_name"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L44
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L44
        L36:
            if (r1 == 0) goto L3b
            r1.close()
        L3b:
            return r0
        L3c:
            r0 = move-exception
            r1 = r6
        L3e:
            if (r1 == 0) goto L43
            r1.close()
        L43:
            throw r0
        L44:
            r0 = move-exception
            goto L3e
        L46:
            r0 = r7
            goto L36
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2187am.m9784c(java.lang.String):java.lang.String");
    }
}
