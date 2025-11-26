package com.sec.chaton.p057e.p058a;

import android.annotation.SuppressLint;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1066bf;
import com.sec.chaton.R;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.msgbox.C2645bj;
import com.sec.chaton.p057e.C2299s;
import com.sec.chaton.p057e.C2302v;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.smsplugin.p102b.C3789h;
import com.sec.chaton.smsplugin.provider.C3947e;
import com.sec.chaton.smsplugin.provider.C3965w;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: InboxSMSMappingDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.p */
/* loaded from: classes.dex */
public class C2202p {

    /* renamed from: a */
    private static final String f7864a = C2202p.class.getSimpleName();

    /* renamed from: a */
    public static ArrayList<C2645bj> m9976a(ContentResolver contentResolver) throws Throwable {
        Cursor cursor;
        ArrayList<C2645bj> arrayList = new ArrayList<>();
        try {
            Cursor cursorQuery = contentResolver.query(C2299s.m10204q(), new String[]{"inbox_no", "buddy_no", "inbox_unread_count", "inbox_last_message", "inbox_title", "inbox_last_time", "inbox_last_msg_sender", "buddy_contact_buddy"}, "inbox_chat_type = " + Integer.toString(EnumC2300t.ONETOONE.m10210a()) + " AND inbox_room_type = " + EnumC2301u.SMS.m10212a(), null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() != 0) {
                        int columnIndex = cursorQuery.getColumnIndex("inbox_no");
                        int columnIndex2 = cursorQuery.getColumnIndex("buddy_no");
                        int columnIndex3 = cursorQuery.getColumnIndex("inbox_unread_count");
                        int columnIndex4 = cursorQuery.getColumnIndex("inbox_last_message");
                        int columnIndex5 = cursorQuery.getColumnIndex("inbox_title");
                        int columnIndex6 = cursorQuery.getColumnIndex("inbox_last_time");
                        int columnIndex7 = cursorQuery.getColumnIndex("inbox_last_msg_sender");
                        int columnIndex8 = cursorQuery.getColumnIndex("buddy_contact_buddy");
                        cursorQuery.moveToFirst();
                        do {
                            arrayList.add(new C2645bj(cursorQuery.getString(columnIndex), cursorQuery.getString(columnIndex2), cursorQuery.getInt(columnIndex3), cursorQuery.getString(columnIndex4), cursorQuery.getString(columnIndex5), cursorQuery.getString(columnIndex6), cursorQuery.getString(columnIndex7), cursorQuery.getInt(columnIndex8)));
                        } while (cursorQuery.moveToNext());
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m9974a(android.content.ContentResolver r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r6 = 0
            java.lang.String r7 = ""
            android.net.Uri r1 = com.sec.chaton.p057e.C2299s.m10201n()     // Catch: java.lang.Throwable -> L45
            r2 = 0
            java.lang.String r3 = "buddy_no=?"
            r0 = 3
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L45
            r0 = 0
            r4[r0] = r9     // Catch: java.lang.Throwable -> L45
            r0 = 1
            r5 = 0
            r4[r0] = r5     // Catch: java.lang.Throwable -> L45
            r0 = 2
            com.sec.chaton.e.t r5 = com.sec.chaton.p057e.EnumC2300t.ONETOONE     // Catch: java.lang.Throwable -> L45
            int r5 = r5.m10210a()     // Catch: java.lang.Throwable -> L45
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L45
            r4[r0] = r5     // Catch: java.lang.Throwable -> L45
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L45
            if (r1 == 0) goto L4f
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L4d
            if (r0 <= 0) goto L4f
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r0 = "inbox_no"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L4d
        L3f:
            if (r1 == 0) goto L44
            r1.close()
        L44:
            return r0
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
            r0 = r7
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2202p.m9974a(android.content.ContentResolver, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m9983b(android.content.ContentResolver r9, java.lang.String r10) throws java.lang.Throwable {
        /*
            r8 = 1
            r7 = 0
            r6 = 0
            android.net.Uri r1 = com.sec.chaton.p057e.C2302v.f8225a     // Catch: java.lang.Throwable -> L24
            r2 = 0
            java.lang.String r3 = "inboxsms_mapping_inbox_no =? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L24
            r0 = 0
            r4[r0] = r10     // Catch: java.lang.Throwable -> L24
            r5 = 0
            r0 = r9
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L2e
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L2c
            if (r0 <= 0) goto L2e
            r0 = r7
        L1e:
            if (r1 == 0) goto L23
            r1.close()
        L23:
            return r0
        L24:
            r0 = move-exception
            r1 = r6
        L26:
            if (r1 == 0) goto L2b
            r1.close()
        L2b:
            throw r0
        L2c:
            r0 = move-exception
            goto L26
        L2e:
            r0 = r8
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2202p.m9983b(android.content.ContentResolver, java.lang.String):boolean");
    }

    /* renamed from: b */
    public static ArrayList<String> m9982b(ContentResolver contentResolver) throws Throwable {
        Cursor cursorQuery;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            cursorQuery = contentResolver.query(C2302v.f8225a, new String[]{"inboxsms_mapping_sms_no"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToFirst();
                        int columnIndex = cursorQuery.getColumnIndex("inboxsms_mapping_sms_no");
                        do {
                            arrayList.add(cursorQuery.getString(columnIndex));
                        } while (cursorQuery.moveToNext());
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: c */
    public static ArrayList<String> m9984c(ContentResolver contentResolver) throws Throwable {
        Cursor cursorQuery;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            cursorQuery = contentResolver.query(C2302v.f8225a, new String[]{"inboxsms_mapping_inbox_no"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToFirst();
                        int columnIndex = cursorQuery.getColumnIndex("inboxsms_mapping_inbox_no");
                        do {
                            arrayList.add(cursorQuery.getString(columnIndex));
                        } while (cursorQuery.moveToNext());
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m9985c(android.content.ContentResolver r9, java.lang.String r10) throws java.lang.Throwable {
        /*
            r6 = 0
            r8 = 1
            r7 = 0
            android.net.Uri r1 = com.sec.chaton.p057e.C2220ah.f7942a     // Catch: java.lang.Throwable -> L49
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L49
            r0 = 0
            java.lang.String r3 = "participants_buddy_no"
            r2[r0] = r3     // Catch: java.lang.Throwable -> L49
            java.lang.String r3 = "participants_inbox_no =? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L49
            r0 = 0
            r4[r0] = r10     // Catch: java.lang.Throwable -> L49
            r5 = 0
            r0 = r9
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L53
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L51
            if (r0 <= 0) goto L53
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L53
            java.lang.String r0 = "participants_buddy_no"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L51
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L51
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L51
            if (r2 != 0) goto L53
            boolean r0 = m9995l(r9, r0)     // Catch: java.lang.Throwable -> L51
            if (r0 == 0) goto L53
            r0 = r7
        L43:
            if (r1 == 0) goto L48
            r1.close()
        L48:
            return r0
        L49:
            r0 = move-exception
            r1 = r6
        L4b:
            if (r1 == 0) goto L50
            r1.close()
        L50:
            throw r0
        L51:
            r0 = move-exception
            goto L4b
        L53:
            r0 = r8
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2202p.m9985c(android.content.ContentResolver, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m9995l(android.content.ContentResolver r9, java.lang.String r10) throws java.lang.Throwable {
        /*
            r7 = 1
            r8 = 0
            r6 = 0
            android.net.Uri r1 = com.sec.chaton.p057e.C2289i.f8196a     // Catch: java.lang.Throwable -> L24
            r2 = 0
            java.lang.String r3 = "buddy_contact_buddy != '1' AND buddy_no =?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L24
            r0 = 0
            r4[r0] = r10     // Catch: java.lang.Throwable -> L24
            r5 = 0
            r0 = r9
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L2e
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L2c
            if (r0 <= 0) goto L2e
            r0 = r7
        L1e:
            if (r1 == 0) goto L23
            r1.close()
        L23:
            return r0
        L24:
            r0 = move-exception
            r1 = r6
        L26:
            if (r1 == 0) goto L2b
            r1.close()
        L2b:
            throw r0
        L2c:
            r0 = move-exception
            goto L26
        L2e:
            r0 = r8
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2202p.m9995l(android.content.ContentResolver, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m9987d(android.content.ContentResolver r9, java.lang.String r10) throws java.lang.Throwable {
        /*
            r6 = 0
            r8 = 0
            r7 = 1
            android.net.Uri r1 = com.sec.chaton.p057e.C2302v.f8225a     // Catch: java.lang.Throwable -> L2c
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L2c
            r0 = 0
            java.lang.String r3 = "inboxsms_mapping_inbox_no"
            r2[r0] = r3     // Catch: java.lang.Throwable -> L2c
            java.lang.String r3 = "inboxsms_mapping_inbox_no =? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L2c
            r0 = 0
            r4[r0] = r10     // Catch: java.lang.Throwable -> L2c
            r5 = 0
            r0 = r9
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L36
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L34
            if (r0 <= r7) goto L36
            r0 = r7
        L26:
            if (r1 == 0) goto L2b
            r1.close()
        L2b:
            return r0
        L2c:
            r0 = move-exception
            r1 = r6
        L2e:
            if (r1 == 0) goto L33
            r1.close()
        L33:
            throw r0
        L34:
            r0 = move-exception
            goto L2e
        L36:
            r0 = r8
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2202p.m9987d(android.content.ContentResolver, java.lang.String):boolean");
    }

    /* renamed from: e */
    public static String m9988e(ContentResolver contentResolver, String str) {
        Cursor cursorQuery;
        String string = null;
        try {
            cursorQuery = contentResolver.query(C2302v.f8225a, new String[]{"inboxsms_mapping_sms_no"}, "inboxsms_mapping_inbox_no =? ", new String[]{str}, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToFirst();
                        string = cursorQuery.getString(cursorQuery.getColumnIndex("inboxsms_mapping_sms_no"));
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return string;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: f */
    public static String m9989f(ContentResolver contentResolver, String str) throws Throwable {
        Cursor cursorQuery;
        String string = null;
        try {
            cursorQuery = contentResolver.query(C2302v.f8225a, new String[]{"inboxsms_mapping_inbox_no"}, "inboxsms_mapping_sms_no =? ", new String[]{str}, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToFirst();
                        string = cursorQuery.getString(cursorQuery.getColumnIndex("inboxsms_mapping_inbox_no"));
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return string;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* renamed from: d */
    public static HashMap<String, String> m9986d(ContentResolver contentResolver) throws Throwable {
        Cursor cursorQuery;
        HashMap<String, String> map = null;
        try {
            cursorQuery = contentResolver.query(C2302v.f8225a, new String[]{"inboxsms_mapping_inbox_no", "inboxsms_mapping_sms_no"}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        map = new HashMap<>();
                        cursorQuery.moveToFirst();
                        int columnIndex = cursorQuery.getColumnIndex("inboxsms_mapping_inbox_no");
                        int columnIndex2 = cursorQuery.getColumnIndex("inboxsms_mapping_sms_no");
                        do {
                            map.put(cursorQuery.getString(columnIndex), cursorQuery.getString(columnIndex2));
                        } while (cursorQuery.moveToNext());
                    }
                } catch (Throwable th) {
                    th = th;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return map;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m9990g(android.content.ContentResolver r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r6 = 0
            r7 = 0
            android.net.Uri r1 = com.sec.chaton.p057e.C2302v.f8225a     // Catch: java.lang.Throwable -> L38
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L38
            r0 = 0
            java.lang.String r3 = "inboxsms_mapping_unread_count"
            r2[r0] = r3     // Catch: java.lang.Throwable -> L38
            java.lang.String r3 = "inboxsms_mapping_inbox_no =? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L38
            r0 = 0
            r4[r0] = r9     // Catch: java.lang.Throwable -> L38
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L38
            if (r1 == 0) goto L42
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L40
            if (r0 <= 0) goto L42
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L40
            java.lang.String r0 = "inboxsms_mapping_unread_count"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L40
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L40
        L32:
            if (r1 == 0) goto L37
            r1.close()
        L37:
            return r0
        L38:
            r0 = move-exception
            r1 = r6
        L3a:
            if (r1 == 0) goto L3f
            r1.close()
        L3f:
            throw r0
        L40:
            r0 = move-exception
            goto L3a
        L42:
            r0 = r7
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2202p.m9990g(android.content.ContentResolver, java.lang.String):int");
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m9977a(ContentResolver contentResolver, long j) {
        if (C4904y.f17872b) {
            C4904y.m18639b("updateAfterDeleteInboxNormalSms " + j, f7864a);
        }
        ContentValues contentValuesM9981b = m9981b(contentResolver, j);
        if (contentValuesM9981b.size() == 0 && contentResolver.delete(C2299s.f8209a, "inbox_no = ?", new String[]{Long.toString(j)}) > 0 && C4904y.f17872b) {
            C4904y.m18639b("Delete obsolete inbox, inboxNo = " + j, f7864a);
        }
        String str = "inbox_no = " + j;
        Uri.Builder builderBuildUpon = C2299s.f8209a.buildUpon();
        builderBuildUpon.appendPath("sms");
        builderBuildUpon.appendQueryParameter("unread_count_decrease", "true");
        if (contentResolver.update(builderBuildUpon.build(), contentValuesM9981b, str, null) > 0 && C4904y.f17872b) {
            C4904y.m18639b("Update inbox after delete message, inboxNo = " + j, f7864a);
        }
        C0991aa.m6037a().m18962d(new C1066bf(C1828q.f6913a, -1));
    }

    /* renamed from: a */
    public static void m9978a(ContentResolver contentResolver, long j, String str) throws Throwable {
        if (C4904y.f17872b) {
            C4904y.m18639b("updateAfterdeleteInboxSmsMapping", f7864a);
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        int iM9990g = m9990g(contentResolver, str);
        if (iM9990g > 0) {
            arrayList.add(m9970a(str, iM9990g - 1));
        }
        arrayList.add(m9979b(contentResolver, j, str));
        try {
            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
            C0991aa.m6037a().m18962d(new C1066bf(C1828q.f6913a, -1));
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: b */
    public static synchronized ContentProviderOperation m9979b(ContentResolver contentResolver, long j, String str) {
        ContentProviderOperation contentProviderOperationBuild;
        synchronized (C2202p.class) {
            ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2299s.f8209a);
            ContentValues contentValuesM9981b = m9981b(contentResolver, j);
            ContentValues contentValuesM9991h = m9991h(contentResolver, str);
            if ((contentValuesM9981b.containsKey("inbox_last_time") ? contentValuesM9981b.getAsLong("inbox_last_time").longValue() : 0L) > (contentValuesM9991h.containsKey("inbox_last_time") ? contentValuesM9991h.getAsLong("inbox_last_time").longValue() : 0L)) {
                builderNewUpdate.withValues(contentValuesM9981b);
            } else {
                builderNewUpdate.withValues(contentValuesM9991h);
            }
            builderNewUpdate.withSelection("inbox_no=?", new String[]{str});
            contentProviderOperationBuild = builderNewUpdate.build();
        }
        return contentProviderOperationBuild;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00ea A[Catch: all -> 0x00f4, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00f4, blocks: (B:6:0x003d, B:8:0x0043, B:15:0x00ea), top: B:27:0x003d, outer: #0 }] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized android.content.ContentValues m9991h(android.content.ContentResolver r14, java.lang.String r15) {
        /*
            java.lang.Class<com.sec.chaton.e.a.p> r6 = com.sec.chaton.p057e.p058a.C2202p.class
            monitor-enter(r6)
            android.content.ContentValues r7 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L101
            r7.<init>()     // Catch: java.lang.Throwable -> L101
            android.net.Uri r1 = com.sec.chaton.p057e.C2306z.m10218b()     // Catch: java.lang.Throwable -> L101
            r2 = 0
            java.lang.String r3 = "message_inbox_no = ? AND ( message_type = ? OR message_type = ? ) AND message_content_type != ?"
            r0 = 4
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L101
            r0 = 0
            r4[r0] = r15     // Catch: java.lang.Throwable -> L101
            r0 = 1
            r5 = 1
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L101
            r4[r0] = r5     // Catch: java.lang.Throwable -> L101
            r0 = 2
            r5 = 2
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L101
            r4[r0] = r5     // Catch: java.lang.Throwable -> L101
            r0 = 3
            com.sec.chaton.e.ab r5 = com.sec.chaton.p057e.EnumC2214ab.SYSTEM     // Catch: java.lang.Throwable -> L101
            int r5 = r5.m10076a()     // Catch: java.lang.Throwable -> L101
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L101
            r4[r0] = r5     // Catch: java.lang.Throwable -> L101
            java.lang.String r5 = "message_is_failed , message_time , _id"
            r0 = r14
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L101
            if (r1 == 0) goto Lea
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> Lf4
            if (r0 == 0) goto Lea
            r1.moveToLast()     // Catch: java.lang.Throwable -> Lf4
            java.lang.String r0 = "message_content"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> Lf4
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> Lf4
            java.lang.String r2 = "message_type"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> Lf4
            int r2 = r1.getInt(r2)     // Catch: java.lang.Throwable -> Lf4
            java.lang.String r3 = "message_content_type"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lf4
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> Lf4
            com.sec.chaton.e.ab r3 = com.sec.chaton.p057e.EnumC2214ab.m10070a(r3)     // Catch: java.lang.Throwable -> Lf4
            java.lang.String r4 = "buddy_name"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> Lf4
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> Lf4
            java.lang.String r5 = "message_time"
            int r5 = r1.getColumnIndex(r5)     // Catch: java.lang.Throwable -> Lf4
            long r8 = r1.getLong(r5)     // Catch: java.lang.Throwable -> Lf4
            java.lang.String r5 = "message_sever_id"
            int r5 = r1.getColumnIndex(r5)     // Catch: java.lang.Throwable -> Lf4
            java.lang.String r5 = r1.getString(r5)     // Catch: java.lang.Throwable -> Lf4
            java.lang.String r10 = "message_sender"
            int r10 = r1.getColumnIndex(r10)     // Catch: java.lang.Throwable -> Lf4
            java.lang.String r10 = r1.getString(r10)     // Catch: java.lang.Throwable -> Lf4
            java.lang.String r11 = "%d;%d;%s;%s"
            r12 = 4
            java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch: java.lang.Throwable -> Lf4
            r13 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> Lf4
            r12[r13] = r2     // Catch: java.lang.Throwable -> Lf4
            r2 = 1
            int r3 = r3.m10076a()     // Catch: java.lang.Throwable -> Lf4
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> Lf4
            r12[r2] = r3     // Catch: java.lang.Throwable -> Lf4
            r2 = 2
            java.lang.String r0 = com.sec.chaton.chat.C1736gi.m8632a(r0)     // Catch: java.lang.Throwable -> Lf4
            r12[r2] = r0     // Catch: java.lang.Throwable -> Lf4
            r0 = 3
            java.lang.String r2 = com.sec.chaton.chat.C1736gi.m8632a(r4)     // Catch: java.lang.Throwable -> Lf4
            r12[r0] = r2     // Catch: java.lang.Throwable -> Lf4
            java.lang.String r0 = java.lang.String.format(r11, r12)     // Catch: java.lang.Throwable -> Lf4
            java.lang.String r2 = "inbox_last_message"
            r7.put(r2, r0)     // Catch: java.lang.Throwable -> Lf4
            java.lang.String r0 = "inbox_last_msg_no"
            r7.put(r0, r5)     // Catch: java.lang.Throwable -> Lf4
            java.lang.String r0 = "inbox_last_time"
            java.lang.Long r2 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> Lf4
            r7.put(r0, r2)     // Catch: java.lang.Throwable -> Lf4
            java.lang.String r0 = "inbox_last_msg_sender"
            r7.put(r0, r10)     // Catch: java.lang.Throwable -> Lf4
        Ldd:
            if (r1 == 0) goto Le8
            boolean r0 = r1.isClosed()     // Catch: java.lang.Throwable -> L101
            if (r0 != 0) goto Le8
            r1.close()     // Catch: java.lang.Throwable -> L101
        Le8:
            monitor-exit(r6)
            return r7
        Lea:
            java.lang.String r0 = "inbox_last_message"
            java.lang.String r2 = ""
            r7.put(r0, r2)     // Catch: java.lang.Throwable -> Lf4
            goto Ldd
        Lf4:
            r0 = move-exception
            if (r1 == 0) goto L100
            boolean r2 = r1.isClosed()     // Catch: java.lang.Throwable -> L101
            if (r2 != 0) goto L100
            r1.close()     // Catch: java.lang.Throwable -> L101
        L100:
            throw r0     // Catch: java.lang.Throwable -> L101
        L101:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2202p.m9991h(android.content.ContentResolver, java.lang.String):android.content.ContentValues");
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public static synchronized ContentValues m9981b(ContentResolver contentResolver, long j) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        Cursor cursorQuery = contentResolver.query(Uri.withAppendedPath(ContentUris.withAppendedId(C3965w.f14266a, j), "subject"), new String[]{"snippet", "date", "snippet_cs"}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0 && !cursorQuery.isClosed() && cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(0);
                    long j2 = cursorQuery.getLong(1);
                    int i = !cursorQuery.isNull(2) ? cursorQuery.getInt(2) : 0;
                    contentValues.put("inbox_last_time", Long.valueOf(j2));
                    if (TextUtils.isEmpty(string)) {
                        string = CommonApplication.m18732r().getResources().getString(R.string.no_subject);
                    }
                    contentValues.put("inbox_last_message", C3947e.m15257a(string, i));
                }
            } finally {
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
            }
        }
        return contentValues;
    }

    /* renamed from: a */
    public static String m9975a(Context context, ContentResolver contentResolver, boolean z, String str, C3789h c3789h, int i, String str2, int i2, long j, long j2) throws Throwable {
        String strM14262d = c3789h.get(0).m14262d();
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        String strM9974a = m9974a(contentResolver, str);
        arrayList.add(m9972a(strM9974a, c3789h.m14310b(", "), strM14262d));
        if (!z && TextUtils.isEmpty(str2)) {
            str2 = context.getResources().getString(R.string.no_subject);
        }
        String strM15258a = C3947e.m15258a(str2, i2, z);
        if (!z) {
            strM14262d = C4809aa.m18104a().m18121a("chaton_id", "");
        }
        arrayList.add(m9973a(strM9974a, strM15258a, String.valueOf(j), null, strM14262d, false));
        if (i == -1) {
            i = m9990g(contentResolver, strM9974a) + 1;
        }
        if (m9983b(contentResolver, strM9974a)) {
            arrayList.add(m9971a(strM9974a, Long.toString(j2), i));
        } else if (z) {
            arrayList.add(m9970a(strM9974a, i));
        }
        try {
            contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
            C0991aa.m6037a().m18962d(new C1066bf(C1828q.f6913a, -1));
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        return strM9974a;
    }

    /* renamed from: a */
    public static ContentProviderOperation m9972a(String str, String str2, String str3) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2299s.f8209a);
        builderNewUpdate.withSelection("inbox_no=? AND inbox_title IS NULL AND inbox_participants IS NULL", new String[]{str});
        builderNewUpdate.withValue("inbox_title", str2);
        builderNewUpdate.withValue("inbox_participants", 1);
        builderNewUpdate.withValue("inbox_last_msg_sender", str3);
        builderNewUpdate.withValue("inbox_last_chat_type", 11);
        return builderNewUpdate.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m9980b(String str, String str2, String str3) {
        return m9973a(str, str2, str3, null, null, false);
    }

    /* renamed from: a */
    private static ContentProviderOperation m9973a(String str, String str2, String str3, String str4, String str5, boolean z) {
        String str6;
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2299s.f8209a);
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(str);
            str6 = "inbox_no=?";
        } else {
            arrayList.add(str);
            arrayList.add(str3);
            str6 = "inbox_no=? AND (inbox_last_time IS NULL OR inbox_last_time =0 OR inbox_last_time<?)";
        }
        builderNewUpdate.withSelection(str6, (String[]) arrayList.toArray(new String[0]));
        builderNewUpdate.withValue("inbox_last_message", str2);
        builderNewUpdate.withValue("inbox_last_time", str3);
        if (!TextUtils.isEmpty(str4)) {
            builderNewUpdate.withValue("inbox_last_msg_no", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            builderNewUpdate.withValue("inbox_last_msg_sender", str5);
        }
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9970a(String str, int i) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2302v.f8225a);
        builderNewUpdate.withSelection("inboxsms_mapping_inbox_no=?", new String[]{str});
        builderNewUpdate.withValue("inboxsms_mapping_unread_count", Integer.valueOf(i));
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9971a(String str, String str2, int i) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2302v.f8225a);
        builderNewInsert.withValue("inboxsms_mapping_inbox_no", str);
        builderNewInsert.withValue("inboxsms_mapping_sms_no", str2);
        builderNewInsert.withValue("inboxsms_mapping_unread_count", Integer.valueOf(i));
        return builderNewInsert.build();
    }

    /* renamed from: i */
    public static ArrayList<ContentProviderOperation> m9992i(ContentResolver contentResolver, String str) throws Throwable {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        String strM9989f = m9989f(contentResolver, str);
        if (!TextUtils.isEmpty(strM9989f)) {
            arrayList.add(m9993j(contentResolver, strM9989f));
        }
        arrayList.add(ContentProviderOperation.newDelete(C2302v.f8225a).withSelection("inboxsms_mapping_sms_no=?", new String[]{str}).build());
        return arrayList;
    }

    /* renamed from: a */
    public static ContentProviderOperation m9969a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2302v.f8225a);
        builderNewDelete.withSelection("inboxsms_mapping_inbox_no=?", new String[]{str});
        return builderNewDelete.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0139  */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.sec.chaton.p057e.p058a.C2203q m9996m(android.content.ContentResolver r11, java.lang.String r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2202p.m9996m(android.content.ContentResolver, java.lang.String):com.sec.chaton.e.a.q");
    }

    /* renamed from: j */
    public static ContentProviderOperation m9993j(ContentResolver contentResolver, String str) throws Throwable {
        C2203q c2203qM9996m = m9996m(contentResolver, str);
        if (c2203qM9996m != null) {
            return m9973a(str, c2203qM9996m.f7865a, c2203qM9996m.f7866b, c2203qM9996m.f7867c, c2203qM9996m.f7868d, true);
        }
        ContentProviderOperation contentProviderOperationM9969a = m9969a(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        C2198l.m9932a(contentResolver, (ArrayList<String>) arrayList);
        return contentProviderOperationM9969a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:
    
        r7.f7839b = r1.getString(r1.getColumnIndex("inbox_no"));
        r7.f7846i = r1.getString(r1.getColumnIndex("inbox_session_id"));
        r7.f7852o = r1.getString(r1.getColumnIndex("inbox_server_ip"));
        r7.f7853p = r1.getInt(r1.getColumnIndex("inbox_server_port"));
     */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.sec.chaton.p057e.p058a.C2201o m9994k(android.content.ContentResolver r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r6 = 0
            com.sec.chaton.e.a.o r7 = new com.sec.chaton.e.a.o
            r7.<init>()
            android.net.Uri r1 = com.sec.chaton.p057e.C2299s.m10205r()     // Catch: java.lang.Throwable -> L66
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L66
            if (r1 == 0) goto L60
        L15:
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L6e
            if (r0 == 0) goto L60
            java.lang.String r0 = "inboxsms_mapping_sms_no"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L6e
            boolean r0 = r9.equals(r0)     // Catch: java.lang.Throwable -> L6e
            if (r0 == 0) goto L15
            java.lang.String r0 = "inbox_no"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L6e
            r7.f7839b = r0     // Catch: java.lang.Throwable -> L6e
            java.lang.String r0 = "inbox_session_id"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L6e
            r7.f7846i = r0     // Catch: java.lang.Throwable -> L6e
            java.lang.String r0 = "inbox_server_ip"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L6e
            r7.f7852o = r0     // Catch: java.lang.Throwable -> L6e
            java.lang.String r0 = "inbox_server_port"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L6e
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L6e
            r7.f7853p = r0     // Catch: java.lang.Throwable -> L6e
        L60:
            if (r1 == 0) goto L65
            r1.close()
        L65:
            return r7
        L66:
            r0 = move-exception
            r1 = r6
        L68:
            if (r1 == 0) goto L6d
            r1.close()
        L6d:
            throw r0
        L6e:
            r0 = move-exception
            goto L68
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2202p.m9994k(android.content.ContentResolver, java.lang.String):com.sec.chaton.e.a.o");
    }
}
