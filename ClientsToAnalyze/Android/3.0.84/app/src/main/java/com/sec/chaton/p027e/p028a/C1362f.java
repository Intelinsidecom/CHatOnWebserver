package com.sec.chaton.p027e.p028a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.RemoteException;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p025d.C1335m;
import com.sec.chaton.p027e.C1445m;
import com.sec.chaton.p027e.C1446n;
import com.sec.chaton.p035io.entry.inner.Buddy;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.provider.ChatONProvider;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3224cl;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: BuddyGroupDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.f */
/* loaded from: classes.dex */
public class C1362f {

    /* renamed from: a */
    static ChatONProvider f5114a = new ChatONProvider();

    /* renamed from: a */
    public static void m6063a(ContentResolver contentResolver, String str) {
        try {
            contentResolver.delete(C1445m.f5377a, "group_relation_group = ? ", new String[]{str});
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public static void m6069b(ContentResolver contentResolver, String str) {
        try {
            contentResolver.delete(C1446n.f5378a, "_id = ? ", new String[]{str});
            C1370n.m6143g(CommonApplication.m11493l().getContentResolver(), str);
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    public static Uri m6071c(ContentResolver contentResolver, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_name", str);
        try {
            return contentResolver.insert(C1446n.f5378a, contentValues);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m6072d(android.content.ContentResolver r9, java.lang.String r10) {
        /*
            r8 = 1
            r7 = 0
            r6 = -1
            android.net.Uri r1 = com.sec.chaton.p027e.C1446n.f5378a     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L39
            r2 = 0
            java.lang.String r3 = "group_name = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L39
            r0 = 0
            r4[r0] = r10     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L39
            r5 = 0
            r0 = r9
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L39
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            if (r0 != r8) goto L45
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.lang.String r0 = "_id"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
        L27:
            if (r1 == 0) goto L2c
            r1.close()
        L2c:
            return r0
        L2d:
            r0 = move-exception
            r1 = r7
        L2f:
            com.sec.chaton.util.C3250y.m11451b(r0)     // Catch: java.lang.Throwable -> L41
            if (r1 == 0) goto L37
            r1.close()
        L37:
            r0 = r6
            goto L2c
        L39:
            r0 = move-exception
            r1 = r7
        L3b:
            if (r1 == 0) goto L40
            r1.close()
        L40:
            throw r0
        L41:
            r0 = move-exception
            goto L3b
        L43:
            r0 = move-exception
            goto L2f
        L45:
            r0 = r6
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p027e.p028a.C1362f.m6072d(android.content.ContentResolver, java.lang.String):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m6073e(android.content.ContentResolver r9, java.lang.String r10) {
        /*
            r8 = 1
            r7 = 0
            java.lang.String r6 = ""
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 == 0) goto Lb
        La:
            return r6
        Lb:
            android.net.Uri r1 = com.sec.chaton.p027e.C1446n.f5378a     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L42
            r2 = 0
            java.lang.String r3 = "_id = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L42
            r0 = 0
            r4[r0] = r10     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L42
            r5 = 0
            r0 = r9
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L42
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r0 != r8) goto L4e
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.String r0 = "group_name"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
        L2f:
            if (r1 == 0) goto L34
            r1.close()
        L34:
            r6 = r0
            goto La
        L36:
            r0 = move-exception
            r1 = r7
        L38:
            com.sec.chaton.util.C3250y.m11451b(r0)     // Catch: java.lang.Throwable -> L4a
            if (r1 == 0) goto L40
            r1.close()
        L40:
            r0 = r6
            goto L34
        L42:
            r0 = move-exception
            r1 = r7
        L44:
            if (r1 == 0) goto L49
            r1.close()
        L49:
            throw r0
        L4a:
            r0 = move-exception
            goto L44
        L4c:
            r0 = move-exception
            goto L38
        L4e:
            r0 = r6
            goto L2f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p027e.p028a.C1362f.m6073e(android.content.ContentResolver, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0039 A[PHI: r1
  0x0039: PHI (r1v5 android.database.Cursor) = (r1v4 android.database.Cursor), (r1v7 android.database.Cursor) binds: [B:14:0x0042, B:8:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<java.lang.String> m6060a(android.content.ContentResolver r8, int r9) {
        /*
            r6 = 0
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            android.net.Uri r1 = com.sec.chaton.p027e.C1445m.f5377a     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L45
            r2 = 0
            java.lang.String r3 = "group_relation_group = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L45
            r0 = 0
            java.lang.String r5 = java.lang.Integer.toString(r9)     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L45
            r4[r0] = r5     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L45
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L45
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            if (r0 == 0) goto L37
        L24:
            java.lang.String r0 = "group_relation_buddy"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r7.add(r0)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            if (r0 != 0) goto L24
        L37:
            if (r1 == 0) goto L3c
        L39:
            r1.close()
        L3c:
            return r7
        L3d:
            r0 = move-exception
            r1 = r6
        L3f:
            com.sec.chaton.util.C3250y.m11451b(r0)     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L3c
            goto L39
        L45:
            r0 = move-exception
            r1 = r6
        L47:
            if (r1 == 0) goto L4c
            r1.close()
        L4c:
            throw r0
        L4d:
            r0 = move-exception
            goto L47
        L4f:
            r0 = move-exception
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p027e.p028a.C1362f.m6060a(android.content.ContentResolver, int):java.util.ArrayList");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033 A[PHI: r1
  0x0033: PHI (r1v5 android.database.Cursor) = (r1v4 android.database.Cursor), (r1v7 android.database.Cursor) binds: [B:14:0x003c, B:8:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<java.lang.Integer> m6059a(android.content.ContentResolver r8) {
        /*
            r6 = 0
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            android.net.Uri r1 = com.sec.chaton.p027e.C1446n.f5378a     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L3f
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L3f
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            if (r0 == 0) goto L31
        L1a:
            java.lang.String r0 = "_id"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r7.add(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            if (r0 != 0) goto L1a
        L31:
            if (r1 == 0) goto L36
        L33:
            r1.close()
        L36:
            return r7
        L37:
            r0 = move-exception
            r1 = r6
        L39:
            com.sec.chaton.util.C3250y.m11451b(r0)     // Catch: java.lang.Throwable -> L47
            if (r1 == 0) goto L36
            goto L33
        L3f:
            r0 = move-exception
            r1 = r6
        L41:
            if (r1 == 0) goto L46
            r1.close()
        L46:
            throw r0
        L47:
            r0 = move-exception
            goto L41
        L49:
            r0 = move-exception
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p027e.p028a.C1362f.m6059a(android.content.ContentResolver):java.util.ArrayList");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x005d: MOVE (r8 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:29:0x005d */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0052  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m6065a(android.content.ContentResolver r9, int r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            r6 = 1
            r7 = 0
            r8 = 0
            android.net.Uri r1 = com.sec.chaton.p027e.C1445m.f5377a     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4f
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r9
            android.database.Cursor r8 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4f
            r8.moveToFirst()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L5f
            boolean r0 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L5f
            if (r0 == 0) goto L56
            android.net.Uri r1 = com.sec.chaton.p027e.C1445m.f5377a     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L5f
            r2 = 0
            java.lang.String r3 = "group_relation_group = ? AND group_relation_buddy = ? "
            r0 = 2
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L5f
            r0 = 0
            java.lang.String r5 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L5f
            r4[r0] = r5     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L5f
            r0 = 1
            r4[r0] = r11     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L5f
            r5 = 0
            r0 = r9
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L5f
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L62
            if (r0 != r6) goto L3c
            if (r1 == 0) goto L3a
            r1.close()
        L3a:
            r0 = r6
        L3b:
            return r0
        L3c:
            if (r1 == 0) goto L41
            r1.close()
        L41:
            r0 = r7
            goto L3b
        L43:
            r0 = move-exception
            r1 = r8
        L45:
            com.sec.chaton.util.C3250y.m11451b(r0)     // Catch: java.lang.Throwable -> L5c
            if (r1 == 0) goto L4d
            r1.close()
        L4d:
            r0 = r7
            goto L3b
        L4f:
            r0 = move-exception
        L50:
            if (r8 == 0) goto L55
            r8.close()
        L55:
            throw r0
        L56:
            if (r8 == 0) goto L4d
            r8.close()
            goto L4d
        L5c:
            r0 = move-exception
            r8 = r1
            goto L50
        L5f:
            r0 = move-exception
            r1 = r8
            goto L45
        L62:
            r0 = move-exception
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p027e.p028a.C1362f.m6065a(android.content.ContentResolver, int, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002f A[PHI: r1
  0x002f: PHI (r1v4 android.database.Cursor) = (r1v3 android.database.Cursor), (r1v6 android.database.Cursor) binds: [B:14:0x0038, B:8:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<java.lang.String> m6068b(android.content.ContentResolver r8) {
        /*
            r6 = 0
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            android.net.Uri r1 = com.sec.chaton.p027e.C1446n.f5378a     // Catch: java.lang.Exception -> L33 java.lang.Throwable -> L3b
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L33 java.lang.Throwable -> L3b
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            if (r0 == 0) goto L2d
        L1a:
            java.lang.String r0 = "group_name"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r7.add(r0)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            if (r0 != 0) goto L1a
        L2d:
            if (r1 == 0) goto L32
        L2f:
            r1.close()
        L32:
            return r7
        L33:
            r0 = move-exception
            r1 = r6
        L35:
            com.sec.chaton.util.C3250y.m11451b(r0)     // Catch: java.lang.Throwable -> L43
            if (r1 == 0) goto L32
            goto L2f
        L3b:
            r0 = move-exception
            r1 = r6
        L3d:
            if (r1 == 0) goto L42
            r1.close()
        L42:
            throw r0
        L43:
            r0 = move-exception
            goto L3d
        L45:
            r0 = move-exception
            goto L35
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p027e.p028a.C1362f.m6068b(android.content.ContentResolver):java.util.ArrayList");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034 A[PHI: r1
  0x0034: PHI (r1v5 android.database.Cursor) = (r1v4 android.database.Cursor), (r1v7 android.database.Cursor) binds: [B:20:0x003e, B:14:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m6074f(android.content.ContentResolver r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            r6 = 0
            android.net.Uri r1 = com.sec.chaton.p027e.C1446n.f5378a     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L41
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r7
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L41
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            if (r0 == 0) goto L32
        L15:
            java.lang.String r0 = "group_name"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            boolean r0 = r0.equals(r8)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            if (r0 == 0) goto L2c
            r0 = 1
            if (r1 == 0) goto L2b
            r1.close()
        L2b:
            return r0
        L2c:
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            if (r0 != 0) goto L15
        L32:
            if (r1 == 0) goto L37
        L34:
            r1.close()
        L37:
            r0 = 0
            goto L2b
        L39:
            r0 = move-exception
            r1 = r6
        L3b:
            com.sec.chaton.util.C3250y.m11451b(r0)     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L37
            goto L34
        L41:
            r0 = move-exception
            r1 = r6
        L43:
            if (r1 == 0) goto L48
            r1.close()
        L48:
            throw r0
        L49:
            r0 = move-exception
            goto L43
        L4b:
            r0 = move-exception
            goto L3b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p027e.p028a.C1362f.m6074f(android.content.ContentResolver, java.lang.String):boolean");
    }

    /* renamed from: a */
    public static void m6061a(ContentResolver contentResolver, int i, Collection<String> collection) {
        m6062a(contentResolver, i, collection, false);
    }

    /* renamed from: a */
    public static void m6062a(ContentResolver contentResolver, int i, Collection<String> collection, boolean z) throws RemoteException, OperationApplicationException {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        if (z) {
            try {
                ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C1445m.f5377a);
                builderNewDelete.withSelection("group_relation_group = ?", new String[]{String.valueOf(i)});
                arrayList.add(builderNewDelete.build());
            } catch (OperationApplicationException e) {
                e.printStackTrace();
                return;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return;
            }
        }
        for (String str : collection) {
            ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C1445m.f5377a);
            builderNewInsert.withValue("group_relation_group", Integer.valueOf(i));
            builderNewInsert.withValue("group_relation_buddy", str);
            arrayList.add(builderNewInsert.build());
        }
        CommonApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
        C1370n.m6103a(CommonApplication.m11493l().getContentResolver(), i);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001f A[PHI: r0 r1
  0x001f: PHI (r0v5 int) = (r0v3 int), (r0v13 int) binds: [B:11:0x0026, B:5:0x001d] A[DONT_GENERATE, DONT_INLINE]
  0x001f: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:11:0x0026, B:5:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m6075g(android.content.ContentResolver r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            r6 = 0
            android.net.Uri r1 = com.sec.chaton.p027e.C1446n.f5378a     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L29
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L29
            r0 = 0
            java.lang.String r3 = "group_name"
            r2[r0] = r3     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L29
            java.lang.String r3 = "group_name = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L29
            r0 = 0
            r4[r0] = r8     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L29
            r5 = 0
            r0 = r7
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L23 java.lang.Throwable -> L29
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L33
            if (r1 == 0) goto L22
        L1f:
            r1.close()
        L22:
            return r0
        L23:
            r0 = move-exception
            r1 = r6
        L25:
            r0 = -1
            if (r1 == 0) goto L22
            goto L1f
        L29:
            r0 = move-exception
        L2a:
            if (r6 == 0) goto L2f
            r6.close()
        L2f:
            throw r0
        L30:
            r0 = move-exception
            r6 = r1
            goto L2a
        L33:
            r0 = move-exception
            goto L25
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p027e.p028a.C1362f.m6075g(android.content.ContentResolver, java.lang.String):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0026 A[PHI: r0 r1
  0x0026: PHI (r0v5 int) = (r0v3 int), (r0v14 int) binds: [B:11:0x002d, B:5:0x0024] A[DONT_GENERATE, DONT_INLINE]
  0x0026: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:11:0x002d, B:5:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m6067b(android.content.ContentResolver r7, int r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r6 = 0
            android.net.Uri r1 = com.sec.chaton.p027e.C1446n.f5378a     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
            r0 = 0
            java.lang.String r3 = "group_name"
            r2[r0] = r3     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
            java.lang.String r3 = "group_name = ? AND _id != ? "
            r0 = 2
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
            r0 = 0
            r4[r0] = r9     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
            r0 = 1
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
            r4[r0] = r5     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
            r5 = 0
            r0 = r7
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L2a java.lang.Throwable -> L30
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3a
            if (r1 == 0) goto L29
        L26:
            r1.close()
        L29:
            return r0
        L2a:
            r0 = move-exception
            r1 = r6
        L2c:
            r0 = -1
            if (r1 == 0) goto L29
            goto L26
        L30:
            r0 = move-exception
        L31:
            if (r6 == 0) goto L36
            r6.close()
        L36:
            throw r0
        L37:
            r0 = move-exception
            r6 = r1
            goto L31
        L3a:
            r0 = move-exception
            goto L2c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p027e.p028a.C1362f.m6067b(android.content.ContentResolver, int, java.lang.String):int");
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0041: MOVE (r7 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:23:0x0041 */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002b A[PHI: r0 r2
  0x002b: PHI (r0v7 int) = (r0v5 int), (r0v15 int) binds: [B:16:0x0036, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE]
  0x002b: PHI (r2v3 android.database.Cursor) = (r2v2 android.database.Cursor), (r2v5 android.database.Cursor) binds: [B:16:0x0036, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m6066b(android.content.ContentResolver r9, int r10) throws java.lang.Throwable {
        /*
            r6 = 0
            r7 = 0
            android.net.Uri r1 = com.sec.chaton.p027e.C1445m.f5377a     // Catch: java.lang.Exception -> L2f java.lang.Throwable -> L39
            r2 = 0
            java.lang.String r3 = "group_relation_group = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Exception -> L2f java.lang.Throwable -> L39
            r0 = 0
            java.lang.String r5 = java.lang.Integer.toString(r10)     // Catch: java.lang.Exception -> L2f java.lang.Throwable -> L39
            r4[r0] = r5     // Catch: java.lang.Exception -> L2f java.lang.Throwable -> L39
            r5 = 0
            r0 = r9
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L2f java.lang.Throwable -> L39
            r2.moveToFirst()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            boolean r0 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            if (r0 == 0) goto L4e
        L20:
            int r1 = r6 + 1
            boolean r0 = r2.moveToNext()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L47
            if (r0 != 0) goto L4c
            r0 = r1
        L29:
            if (r2 == 0) goto L2e
        L2b:
            r2.close()
        L2e:
            return r0
        L2f:
            r0 = move-exception
            r1 = r0
            r2 = r7
            r0 = r6
        L33:
            com.sec.chaton.util.C3250y.m11451b(r1)     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L2e
            goto L2b
        L39:
            r0 = move-exception
        L3a:
            if (r7 == 0) goto L3f
            r7.close()
        L3f:
            throw r0
        L40:
            r0 = move-exception
            r7 = r2
            goto L3a
        L43:
            r0 = move-exception
            r1 = r0
            r0 = r6
            goto L33
        L47:
            r0 = move-exception
            r8 = r0
            r0 = r1
            r1 = r8
            goto L33
        L4c:
            r6 = r1
            goto L20
        L4e:
            r0 = r6
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p027e.p028a.C1362f.m6066b(android.content.ContentResolver, int):int");
    }

    /* renamed from: a */
    public static ContentProviderOperation m6058a(String str, String str2) throws UnsupportedEncodingException {
        ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
        Iterator<String> it = C3224cl.m11335a(str, ',').iterator();
        while (it.hasNext()) {
            String next = it.next();
            int iM6072d = m6072d(contentResolver, next);
            if (m6074f(contentResolver, next) && m6066b(contentResolver, iM6072d) == 1 && m6065a(contentResolver, iM6072d, str2)) {
                m6070b(next, str2);
            }
        }
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C1445m.f5377a);
        builderNewDelete.withSelection("group_relation_buddy = ?", new String[]{str2});
        return builderNewDelete.build();
    }

    /* renamed from: b */
    private static void m6070b(String str, String str2) throws UnsupportedEncodingException {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 != iM6733a && -2 != iM6733a) {
            new C1330h(null).m5716a("group", false, str, (String) null, new String[]{str2}, 327);
            C1335m.m5782a(null, str);
            C3205bt.m11182a(CommonApplication.m11493l()).m11219a(str, true);
            C3250y.m11449b("The group " + str + " will be removed from server because only has deleted account.");
        }
    }

    /* renamed from: a */
    public static ContentProviderOperation m6057a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C1445m.f5377a);
        builderNewDelete.withSelection("group_relation_buddy = ?", new String[]{str});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static int m6056a(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_name", str2);
        try {
            return contentResolver.update(C1446n.f5378a, contentValues, "_id = ? ", new String[]{str});
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: a */
    public static void m6064a(ArrayList<ContentProviderOperation> arrayList, Buddy buddy) {
        ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
        HashMap map = new HashMap();
        try {
            if (buddy.group != null && buddy.group.length() > 0) {
                ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
                Iterator<String> it = C3224cl.m11335a(buddy.group, ',').iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!next.toLowerCase().equals("Favorites".toLowerCase())) {
                        if (m6075g(contentResolver, next) == 0) {
                            ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C1446n.f5378a);
                            builderNewInsert.withValue("group_name", next);
                            arrayList2.add(builderNewInsert.build());
                            map.put(next, buddy.value);
                        } else {
                            map.put(next, buddy.value);
                        }
                    }
                }
                if (!arrayList2.isEmpty()) {
                    f5114a.m8071a(arrayList2, false);
                }
                if (map != null && !map.isEmpty()) {
                    ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C1445m.f5377a);
                    builderNewDelete.withSelection("group_relation_buddy = ? AND group_relation_group != ? ", new String[]{buddy.value, String.valueOf(1)});
                    arrayList.add(builderNewDelete.build());
                    for (Map.Entry entry : map.entrySet()) {
                        ContentProviderOperation.Builder builderNewInsert2 = ContentProviderOperation.newInsert(C1445m.f5377a);
                        builderNewInsert2.withValue("group_relation_group", Integer.valueOf(m6072d(contentResolver, (String) entry.getKey())));
                        builderNewInsert2.withValue("group_relation_buddy", entry.getValue());
                        arrayList.add(builderNewInsert2.build());
                    }
                    return;
                }
                return;
            }
            ContentProviderOperation.Builder builderNewDelete2 = ContentProviderOperation.newDelete(C1445m.f5377a);
            builderNewDelete2.withSelection("group_relation_buddy = ? AND group_relation_group != ? ", new String[]{buddy.value, String.valueOf(1)});
            arrayList.add(builderNewDelete2.build());
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        }
    }
}
