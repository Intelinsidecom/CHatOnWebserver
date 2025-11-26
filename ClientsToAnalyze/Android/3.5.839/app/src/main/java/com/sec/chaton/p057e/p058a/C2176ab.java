package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.EnumC1109f;
import com.sec.chaton.chat.notification.C1828q;
import com.sec.chaton.chat.notification.C1832u;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p046a.C0927f;
import com.sec.chaton.p055d.C2134o;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.C2219ag;
import com.sec.chaton.p057e.C2220ah;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p065io.entry.inner.SpecialUser;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ParticipantDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.ab */
/* loaded from: classes.dex */
public class C2176ab {
    /* renamed from: a */
    public static ArrayList<ContentProviderOperation> m9677a(ArrayList<String> arrayList) {
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2220ah.m10092c(next));
                ContentValues contentValues = new ContentValues();
                contentValues.put("participants_buddy_no", "");
                builderNewUpdate.withValues(contentValues);
                arrayList2.add(builderNewUpdate.build());
            }
        }
        return arrayList2;
    }

    /* renamed from: a */
    public static boolean m9681a(ContentResolver contentResolver, String str, String str2) {
        Cursor cursorQuery = contentResolver.query(C2220ah.f7942a, null, "participants_inbox_no=? AND participants_buddy_no=?", new String[]{str2, str}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() != 0) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return true;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public static String m9685b(ContentResolver contentResolver, String str, String str2) {
        return m9696f(contentResolver, str, str2);
    }

    /* renamed from: a */
    public static ContentProviderOperation m9670a(String str, String str2) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2220ah.f7942a);
        builderNewInsert.withValue("participants_buddy_no", str2);
        builderNewInsert.withValue("participants_inbox_no", str);
        builderNewInsert.withValue("participants_buddy_name", m9685b(GlobalApplication.m18732r().getContentResolver(), str2, (String) null));
        return builderNewInsert.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m9683b(String str, String str2) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2220ah.f7942a);
        builderNewDelete.withSelection("participants_inbox_no=? AND participants_buddy_no=?", new String[]{str, str2});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9668a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2220ah.f7942a);
        builderNewDelete.withSelection("participants_inbox_no=?", new String[]{str});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9672a(String str, String str2, String str3) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2220ah.f7942a);
        builderNewInsert.withValue("participants_buddy_no", str2);
        builderNewInsert.withValue("participants_inbox_no", str);
        builderNewInsert.withValue("participants_buddy_name", str3);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9673a(String str, String str2, String str3, String str4, boolean z, int i, int i2) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2220ah.f7942a);
        builderNewInsert.withValue("participants_buddy_no", str2);
        builderNewInsert.withValue("participants_inbox_no", str);
        builderNewInsert.withValue("participants_buddy_name", str3);
        builderNewInsert.withValue("participants_country_code", str4);
        builderNewInsert.withValue("participants_is_auth", z ? "Y" : "N");
        builderNewInsert.withValue("participants_status", Integer.valueOf(i));
        builderNewInsert.withValue("participants_account_info", Integer.valueOf(i2));
        return builderNewInsert.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m9684b(String str, String str2, String str3) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2220ah.f7942a);
        builderNewUpdate.withSelection("participants_inbox_no=? AND participants_buddy_no=?", new String[]{str, str2});
        builderNewUpdate.withValue("participants_buddy_no", str3);
        return builderNewUpdate.build();
    }

    /* renamed from: c */
    public static ContentProviderOperation m9687c(String str, String str2, String str3) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2220ah.f7942a);
        builderNewUpdate.withSelection("participants_inbox_no=? AND participants_buddy_no=?", new String[]{str, str2});
        builderNewUpdate.withValue("participants_buddy_name", str3);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9674a(String str, String str2, String str3, boolean z, int i, int i2) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2220ah.f7942a);
        builderNewUpdate.withSelection("participants_buddy_no=?", new String[]{str});
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_buddy_name", str2);
        contentValues.put("participants_country_code", str3);
        contentValues.put("participants_is_auth", z ? "Y" : "N");
        contentValues.put("participants_status", Integer.valueOf(i));
        contentValues.put("participants_account_info", Integer.valueOf(i2));
        builderNewUpdate.withValues(contentValues);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static int m9666a(ContentResolver contentResolver, String str, String str2, EnumC1109f enumC1109f) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_buddy_no", str);
        contentValues.put("participants_user_type", enumC1109f.m7095a());
        return contentResolver.update(C2220ah.f7942a, contentValues, "participants_inbox_no=? AND participants_buddy_no=?", new String[]{str2, str});
    }

    /* renamed from: a */
    public static ContentProviderOperation m9669a(String str, int i) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2220ah.f7942a);
        builderNewUpdate.withSelection("participants_buddy_no = ? ", new String[]{str});
        ContentValues contentValues = new ContentValues();
        if (i == 0) {
            contentValues.put("participants_country_code", "");
            contentValues.put("participants_is_auth", "");
        }
        contentValues.put("participants_status", Integer.valueOf(i));
        builderNewUpdate.withValues(contentValues);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static Cursor m9675a(ContentResolver contentResolver, String str) {
        return contentResolver.query(C2220ah.m10086a(str), null, null, null, null);
    }

    /* renamed from: c */
    public static Uri m9688c(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_buddy_no", str2);
        contentValues.put("participants_inbox_no", str);
        contentValues.put("participants_buddy_name", m9685b(contentResolver, str2, (String) null));
        return contentResolver.insert(C2220ah.f7942a, contentValues);
    }

    /* renamed from: a */
    public static Uri m9676a(ContentResolver contentResolver, String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        if (str2.startsWith("0999")) {
            contentValues.put("participants_user_type", C2186al.m9761a(contentResolver, str2));
        }
        contentValues.put("participants_inbox_no", str);
        contentValues.put("participants_buddy_no", str2);
        contentValues.put("participants_buddy_name", str3);
        return contentResolver.insert(C2220ah.f7942a, contentValues);
    }

    /* renamed from: d */
    public static void m9692d(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("participants_inbox_no", "");
        contentResolver.update(C2220ah.f7942a, contentValues, "participants_inbox_no=? AND participants_buddy_no=?", new String[]{str, str2});
    }

    /* renamed from: e */
    public static String m9693e(ContentResolver contentResolver, String str, String str2) {
        return m9695f(contentResolver, str2);
    }

    /* renamed from: b */
    public static int m9682b(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C2220ah.f7942a, new String[]{"COUNT (*) AS cnt"}, "participants_inbox_no=?", new String[]{str}, null);
        if (cursorQuery == null) {
            return 0;
        }
        int columnIndex = cursorQuery.getColumnIndex("cnt");
        int i = 0;
        while (cursorQuery.moveToNext()) {
            if (!cursorQuery.isNull(columnIndex)) {
                i = cursorQuery.getInt(columnIndex);
            }
        }
        cursorQuery.close();
        return i;
    }

    /* renamed from: c */
    public static String[] m9689c(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C2220ah.f7942a, null, "participants_inbox_no=?", new String[]{str}, "buddy_name");
        if (cursorQuery == null || cursorQuery.getCount() == 0) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(cursorQuery.getCount());
        int columnIndex = cursorQuery.getColumnIndex("participants_buddy_no");
        while (cursorQuery.moveToNext()) {
            if (!cursorQuery.isNull(columnIndex)) {
                arrayList.add(cursorQuery.getString(columnIndex));
            }
        }
        cursorQuery.close();
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d A[DONT_GENERATE, PHI: r0
  0x002d: PHI (r0v6 java.util.ArrayList<java.lang.String>) = (r0v3 java.util.ArrayList<java.lang.String>), (r0v7 java.util.ArrayList<java.lang.String>) binds: [B:23:0x0053, B:9:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0021  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<java.lang.String> m9691d(android.content.ContentResolver r6, java.lang.String r7) {
        /*
            android.net.Uri r1 = com.sec.chaton.p057e.C2220ah.f7942a
            r2 = 0
            java.lang.String r3 = "participants_inbox_no=?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]
            r0 = 0
            r4[r0] = r7
            java.lang.String r5 = "buddy_name"
            r0 = r6
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r1 == 0) goto L21
            int r2 = r1.getCount()     // Catch: java.lang.Throwable -> L4c
            if (r2 != 0) goto L31
        L21:
            if (r1 == 0) goto L26
            r1.close()     // Catch: java.lang.Throwable -> L4c
        L26:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L4c
            r0.<init>()     // Catch: java.lang.Throwable -> L4c
            if (r1 == 0) goto L30
        L2d:
            r1.close()
        L30:
            return r0
        L31:
            java.lang.String r2 = "participants_buddy_no"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L4c
        L38:
            boolean r3 = r1.moveToNext()     // Catch: java.lang.Throwable -> L4c
            if (r3 == 0) goto L53
            boolean r3 = r1.isNull(r2)     // Catch: java.lang.Throwable -> L4c
            if (r3 != 0) goto L38
            java.lang.String r3 = r1.getString(r2)     // Catch: java.lang.Throwable -> L4c
            r0.add(r3)     // Catch: java.lang.Throwable -> L4c
            goto L38
        L4c:
            r0 = move-exception
            if (r1 == 0) goto L52
            r1.close()
        L52:
            throw r0
        L53:
            if (r1 == 0) goto L30
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2176ab.m9691d(android.content.ContentResolver, java.lang.String):java.util.ArrayList");
    }

    /* renamed from: f */
    public static String m9696f(ContentResolver contentResolver, String str, String str2) throws Resources.NotFoundException {
        String string;
        String string2 = GlobalApplication.m10283b().getString(R.string.unknown);
        Cursor cursorQuery = contentResolver.query(C2220ah.m10085a(), null, "buddy_no=?", new String[]{str}, null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            string = string2;
        } else {
            string = string2;
            while (cursorQuery.moveToNext()) {
                string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"));
                if (TextUtils.isEmpty(string)) {
                    string = string2;
                }
                if (!string2.equals(string)) {
                    break;
                }
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return (!string.equals(string2) || TextUtils.isEmpty(str2)) ? string : str2;
    }

    /* renamed from: g */
    public static String m9698g(ContentResolver contentResolver, String str, String str2) {
        boolean z;
        String string;
        Cursor cursorQuery = contentResolver.query(C2220ah.m10085a(), null, "buddy_no=?", new String[]{str2}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            string = "";
            while (true) {
                if (!cursorQuery.moveToNext()) {
                    z = false;
                    break;
                }
                string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"));
                if (str.equals(cursorQuery.getString(cursorQuery.getColumnIndex("participants_inbox_no")))) {
                    z = true;
                    break;
                }
            }
        } else {
            C4904y.m18639b("can't find participant name", "[ParticipantDatabaseHelper-getUnknownBuddyName]");
            z = false;
            string = "";
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return z ? string : "";
    }

    /* renamed from: e */
    public static ArrayList<String> m9694e(ContentResolver contentResolver, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor cursorQuery = contentResolver.query(C2220ah.f7942a, new String[]{"participants_buddy_no"}, "participants_inbox_no= ? and participants_buddy_no not in ( select buddy_no from buddy )", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
                C4904y.m18639b("unknownParticipants : " + cursorQuery.getString(0), "[ParticipantDatabaseHelper]");
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    /* renamed from: f */
    public static String m9695f(ContentResolver contentResolver, String str) {
        return m9696f(contentResolver, str, null);
    }

    /* renamed from: h */
    public static ContentProviderOperation m9699h(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        Uri uri = C2219ag.f7941a;
        contentValues.put("participants_buddy_no", str2);
        contentValues.put("participants_old_buddy_no", str);
        return ContentProviderOperation.newInsert(uri).withValues(contentValues).build();
    }

    /* renamed from: g */
    public static String m9697g(ContentResolver contentResolver, String str) {
        Cursor cursorQuery = contentResolver.query(C2219ag.f7941a, new String[]{"participants_buddy_no"}, "participants_old_buddy_no=?", new String[]{str}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    String string = cursorQuery.getString(0);
                    if (C4904y.f17873c) {
                        C4904y.m18641c("old :" + str + ",current:" + string, "[ParticipantDatabaseHelper-getCurrentParticipantNo]");
                    }
                    str = string;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return str;
    }

    /* renamed from: h */
    public static ArrayList<String> m9700h(ContentResolver contentResolver, String str) throws Throwable {
        Cursor cursorQuery;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            cursorQuery = contentResolver.query(C2220ah.f7942a, new String[]{"participants_buddy_no"}, "participants_inbox_no=?", new String[]{str}, null);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    try {
                        arrayList.add(cursorQuery.getString(0));
                    } catch (Throwable th) {
                        th = th;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
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

    /* renamed from: a */
    public static void m9679a(C0927f c0927f, String str, String str2) throws Throwable {
        List<String> listM5086g = c0927f.m5086g();
        if (listM5086g == null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("insertOrderedChatMemberListForTopicChat - memberList is null", "ParticipantDatabaseHelper");
                return;
            }
            return;
        }
        if (listM5086g.size() == 0) {
            if (C4904y.f17873c) {
                C4904y.m18641c("insertOrderedChatMemberListForTopicChat - memberList size is 0", "ParticipantDatabaseHelper");
                return;
            }
            return;
        }
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        boolean z = false;
        for (String str3 : listM5086g) {
            if (C4904y.f17873c) {
                C4904y.m18641c("insertOrderedChatMemberListForTopicChat - member : " + str3, "ParticipantDatabaseHelper");
            }
            String strM9697g = m9697g(contentResolver, str3);
            if (strM9697g.equals(C4809aa.m18104a().m18121a("chaton_id", "")) || strM9697g.equals(C4809aa.m18104a().m18121a("old_chaton_id", ""))) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("insertOrderedChatMemberListForTopicChat - me : " + strM9697g, "ParticipantDatabaseHelper");
                }
            } else {
                m9680a(arrayList, str, str2, str3, strM9697g);
                z = true;
            }
        }
        ArrayList<String> arrayListM9700h = m9700h(contentResolver, str);
        if (C2198l.m9955h(contentResolver, str)) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = arrayListM9700h.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!listM5086g.contains(next)) {
                    arrayList2.add(next);
                }
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                String strM9697g2 = m9697g(contentResolver, (String) it2.next());
                if (strM9697g2.equals(C4809aa.m18104a().m18121a("chaton_id", "")) || strM9697g2.equals(C4809aa.m18104a().m18121a("old_chaton_id", ""))) {
                    if (C4904y.f17873c) {
                        C4904y.m18641c("insertOrderedChatMemberListForTopicChat - me : " + strM9697g2, "ParticipantDatabaseHelper");
                    }
                } else {
                    arrayList.add(m9683b(str, strM9697g2));
                    z = true;
                }
            }
        }
        try {
            if (arrayList.size() > 0) {
                contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
            }
        } catch (Exception e) {
            C4904y.m18634a(e.getMessage(), "ParticipantDatabaseHelper");
        }
        C2198l.m9943c(contentResolver, str, 11);
        if (z) {
            C2134o.m9570a((Handler) null, str, str2, 0L);
        }
    }

    /* renamed from: b */
    public static void m9686b(C0927f c0927f, String str, String str2) throws RemoteException, OperationApplicationException {
        List<String> listM5086g = c0927f.m5086g();
        if (listM5086g == null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("insertOrderedChatMemberList - memberList is null", "ParticipantDatabaseHelper");
                return;
            }
            return;
        }
        if (listM5086g.size() == 0) {
            if (C4904y.f17873c) {
                C4904y.m18641c("insertOrderedChatMemberList - memberList size is 0", "ParticipantDatabaseHelper");
                return;
            }
            return;
        }
        ContentResolver contentResolver = GlobalApplication.m18732r().getContentResolver();
        if (C2198l.m9955h(contentResolver, str)) {
            if (C4904y.f17873c) {
                C4904y.m18641c("insertOrderedChatMemberList - participant is already inserted", "ParticipantDatabaseHelper");
                return;
            }
            return;
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        boolean z = false;
        for (String str3 : listM5086g) {
            if (C4904y.f17873c) {
                C4904y.m18641c("insertOrderedChatMemberList - member : " + str3, "ParticipantDatabaseHelper");
            }
            String strM9697g = m9697g(contentResolver, str3);
            if (strM9697g.equals(C4809aa.m18104a().m18121a("chaton_id", "")) || strM9697g.equals(C4809aa.m18104a().m18121a("old_chaton_id", ""))) {
                if (C4904y.f17873c) {
                    C4904y.m18641c("insertOrderedChatMemberList - me : " + strM9697g, "ParticipantDatabaseHelper");
                }
            } else {
                m9680a(arrayList, str, str2, str3, strM9697g);
                z = true;
            }
        }
        try {
            if (arrayList.size() > 0) {
                contentResolver.applyBatch("com.sec.chaton.provider", arrayList);
            }
        } catch (Exception e) {
            C4904y.m18634a(e.getMessage(), "ParticipantDatabaseHelper");
        }
        C2198l.m9943c(contentResolver, str, 11);
        if (z) {
            C2134o.m9570a((Handler) null, str, str2, 0L);
        }
    }

    /* renamed from: a */
    public static void m9680a(ArrayList<ContentProviderOperation> arrayList, String str, String str2, String str3, String str4) {
        C4904y.m18646e("insertParticipant() inboxNo : " + str + ", oldBuddyNo : " + str3 + ", newBuddyNo : " + str4, "ParticipantDatabaseHelper");
        if (str4 != null && !str4.equals(str3) && TextUtils.isEmpty(str2) && m9681a(GlobalApplication.m18732r().getContentResolver(), str3, str)) {
            C4904y.m18646e("insertParticipant() - old buddyNo is exist : " + str3 + ", skip insert", "ParticipantDatabaseHelper");
            ContentValues contentValues = new ContentValues();
            contentValues.put("message_sender", str3);
            arrayList.add(C2204r.m10011a("message_sender=? AND message_inbox_no =?", new String[]{str4, str}, contentValues));
            return;
        }
        C4904y.m18646e("insertParticipant() - Insert Participants : " + str4, "ParticipantDatabaseHelper");
        arrayList.add(m9670a(str, str4));
    }

    /* renamed from: a */
    public static ContentProviderOperation m9667a(SpecialUser specialUser) {
        if (TextUtils.isEmpty(specialUser.usertype)) {
            return null;
        }
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2220ah.f7942a);
        builderNewUpdate.withValue("participants_user_type", specialUser.usertype);
        builderNewUpdate.withSelection("participants_buddy_no =? ", new String[]{specialUser.specialuserid});
        return builderNewUpdate.build();
    }

    /* renamed from: d */
    public static ContentProviderOperation m9690d(String str, String str2, String str3) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2220ah.f7942a);
        builderNewUpdate.withSelection("participants_inbox_no =? AND participants_buddy_no =? ", new String[]{str2, str});
        builderNewUpdate.withValue("participants_user_type", str3);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9671a(String str, String str2, Long l) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2220ah.f7942a);
        builderNewUpdate.withSelection("participants_inbox_no=? AND participants_buddy_no=?", new String[]{str, str2});
        builderNewUpdate.withValue("participants_read_time", l);
        return builderNewUpdate.build();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m9701i(android.content.ContentResolver r8, java.lang.String r9, java.lang.String r10) {
        /*
            r7 = 1
            r5 = 0
            com.sec.chaton.buddy.a.f r0 = com.sec.chaton.buddy.p050a.EnumC1109f.NONE
            java.lang.String r6 = r0.m7095a()
            android.net.Uri r1 = com.sec.chaton.p057e.C2220ah.f7942a
            java.lang.String[] r2 = new java.lang.String[r7]
            java.lang.String r0 = "participants_user_type"
            r2[r5] = r0
            java.lang.String r3 = "participants_inbox_no =? AND participants_buddy_no =?"
            r0 = 2
            java.lang.String[] r4 = new java.lang.String[r0]
            r4[r5] = r10
            r4[r7] = r9
            r5 = 0
            r0 = r8
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L4a
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L43
            if (r0 <= 0) goto L4a
            java.lang.String r0 = "participants_user_type"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L43
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L43
            boolean r2 = r1.isNull(r0)     // Catch: java.lang.Throwable -> L43
            if (r2 != 0) goto L4a
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L43
        L3d:
            if (r1 == 0) goto L42
            r1.close()
        L42:
            return r0
        L43:
            r0 = move-exception
            if (r1 == 0) goto L49
            r1.close()
        L49:
            throw r0
        L4a:
            r0 = r6
            goto L3d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2176ab.m9701i(android.content.ContentResolver, java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static void m9678a() {
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        Cursor cursorQuery = contentResolver.query(C2220ah.f7942a, new String[]{"participants_inbox_no", "participants_buddy_no"}, "participants_user_type = " + EnumC1109f.INVITING.m7095a(), null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    int columnIndex = cursorQuery.getColumnIndex("participants_inbox_no");
                    int columnIndex2 = cursorQuery.getColumnIndex("participants_buddy_no");
                    do {
                        String string = cursorQuery.getString(columnIndex);
                        String string2 = cursorQuery.getString(columnIndex2);
                        String strM9966s = C2198l.m9966s(contentResolver, string);
                        C2142w c2142wM9593a = C2142w.m9593a(string, EnumC2300t.GROUPCHAT);
                        if (c2142wM9593a != null) {
                            c2142wM9593a.mo9244a(strM9966s);
                            c2142wM9593a.mo9252a(string, C4844bi.m18323a().m18328c().m18329a(), C4844bi.m18323a().m18328c().m18332b());
                            C1832u c1832uM8968b = C1828q.m8956a().m8968b(string);
                            if (c1832uM8968b != null) {
                                c2142wM9593a.mo9266b(c1832uM8968b.f6951d);
                                C4904y.m18639b("last session merge time[" + c1832uM8968b.f6951d + "]", "checkInvitedBuddies");
                            }
                            c2142wM9593a.mo9226a(EnumC2214ab.TEXT, strM9966s, new String[]{C4809aa.m18104a().m18121a("chaton_id", "")}, new String[]{string2});
                            if (C4904y.f17872b) {
                                C4904y.m18639b("inviteBuddy[" + string2 + "] to the room [" + string + "]", "checkInvitedBuddies");
                            }
                        } else if (C4904y.f17875e) {
                            C4904y.m18634a("control is null", "checkInvitedBuddies");
                        }
                    } while (cursorQuery.moveToNext());
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
    }
}
