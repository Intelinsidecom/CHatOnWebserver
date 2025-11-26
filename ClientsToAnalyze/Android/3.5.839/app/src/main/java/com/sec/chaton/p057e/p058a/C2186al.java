package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.sec.chaton.p057e.C2228ap;
import com.sec.chaton.p057e.C2230ar;
import com.sec.chaton.p065io.entry.inner.SpecialUser;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: SpecialBuddyDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.al */
/* loaded from: classes.dex */
public class C2186al {
    @Deprecated
    /* renamed from: a */
    public static String m9762a(Context context, String str) {
        String string = null;
        if (str != null && context != null) {
            Cursor cursorQuery = context.getContentResolver().query(C2230ar.f7958a, new String[]{"buddy_name"}, "buddy_no=?", new String[]{str}, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0 && cursorQuery.moveToFirst()) {
                        string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"));
                    }
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        return string;
    }

    @Deprecated
    /* renamed from: b */
    public static String m9769b(Context context, String str) {
        String string = null;
        if (str != null && context != null) {
            Cursor cursorQuery = context.getContentResolver().query(C2230ar.f7958a, new String[]{"weburl"}, "buddy_no=?", new String[]{str}, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0 && cursorQuery.moveToFirst()) {
                        string = cursorQuery.getString(cursorQuery.getColumnIndex("weburl"));
                    }
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    @java.lang.Deprecated
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m9761a(android.content.ContentResolver r7, java.lang.String r8) {
        /*
            r4 = 1
            r5 = 0
            if (r7 == 0) goto La
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L13
        La:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "resolver and id must be provided"
            r0.<init>(r1)
            throw r0
        L13:
            com.sec.chaton.buddy.a.f r0 = com.sec.chaton.buddy.p050a.EnumC1109f.NONE
            java.lang.String r6 = r0.m7095a()
            android.net.Uri r1 = com.sec.chaton.p057e.C2230ar.f7958a
            java.lang.String[] r2 = new java.lang.String[r4]
            java.lang.String r0 = "usertype"
            r2[r5] = r0
            java.lang.String r3 = "buddy_no=?"
            java.lang.String[] r4 = new java.lang.String[r4]
            r4[r5] = r8
            r5 = 0
            r0 = r7
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L55
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L4e
            if (r0 <= 0) goto L55
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto L55
            java.lang.String r0 = "usertype"
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r0 = r1.getString(r0)     // Catch: java.lang.Throwable -> L4e
        L48:
            if (r1 == 0) goto L4d
            r1.close()
        L4d:
            return r0
        L4e:
            r0 = move-exception
            if (r1 == 0) goto L54
            r1.close()
        L54:
            throw r0
        L55:
            r0 = r6
            goto L48
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p057e.p058a.C2186al.m9761a(android.content.ContentResolver, java.lang.String):java.lang.String");
    }

    /* renamed from: c */
    public static boolean m9775c(Context context, String str) {
        if (str == null || context == null) {
            return false;
        }
        Cursor cursorQuery = context.getContentResolver().query(C2230ar.f7958a, new String[]{"buddy_no"}, "buddy_no=?", new String[]{str}, null);
        if (cursorQuery == null) {
            return false;
        }
        if (cursorQuery.getCount() <= 0 || !cursorQuery.moveToFirst()) {
            cursorQuery.close();
            return false;
        }
        cursorQuery.close();
        return true;
    }

    /* renamed from: b */
    public static boolean m9772b(ContentResolver contentResolver, String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("[isExsistLivepartnerUser] Livepartner ID = " + str, "SpecialBuddyDatabaseHelper");
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorQuery = contentResolver.query(C2228ap.f7956a, new String[]{"buddy_no"}, "buddy_no=?", new String[]{str}, null);
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

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
    	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    /* renamed from: c */
    public static boolean m9774c(ContentResolver contentResolver, String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("[isExsistFollowingLivepartnerUser] Livepartner ID = " + str, "SpecialBuddyDatabaseHelper");
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorQuery = contentResolver.query(C2230ar.f7958a, new String[]{"buddy_no"}, "buddy_no=?", new String[]{str}, null);
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

    /* renamed from: a */
    public static ContentProviderOperation m9759a(SpecialUser specialUser) {
        if (C4904y.f17872b) {
            C4904y.m18639b("[insertLivepartnerUser] Livepartner ID = " + specialUser.specialuserid, "SpecialBuddyDatabaseHelper");
        }
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2228ap.f7956a);
        builderNewInsert.withValue("buddy_no", specialUser.specialuserid);
        builderNewInsert.withValue("buddy_name", specialUser.name);
        builderNewInsert.withValue("type", 100);
        builderNewInsert.withValue("description", specialUser.description);
        builderNewInsert.withValue("followcount", specialUser.followcount);
        builderNewInsert.withValue("photoloaded", specialUser.photoloaded);
        builderNewInsert.withValue("msgstatus", specialUser.msgstatus);
        builderNewInsert.withValue("tel", specialUser.tel);
        builderNewInsert.withValue("likecount", specialUser.likecount);
        builderNewInsert.withValue("status", specialUser.status);
        builderNewInsert.withValue("url", specialUser.url);
        builderNewInsert.withValue("weburl", specialUser.weburl);
        if (specialUser.usertype != null) {
            builderNewInsert.withValue("usertype", specialUser.usertype);
        }
        return builderNewInsert.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m9767b(SpecialUser specialUser) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2230ar.f7958a);
        if (specialUser.likecount == null && TextUtils.isEmpty(specialUser.likecount)) {
            specialUser.likecount = Spam.ACTIVITY_CANCEL;
        }
        if (specialUser.followcount == null && TextUtils.isEmpty(specialUser.followcount)) {
            specialUser.followcount = Spam.ACTIVITY_CANCEL;
        }
        builderNewInsert.withValue("buddy_no", specialUser.specialuserid);
        builderNewInsert.withValue("buddy_name", specialUser.name);
        builderNewInsert.withValue("description", specialUser.description);
        builderNewInsert.withValue("followcount", specialUser.followcount);
        builderNewInsert.withValue("photoloaded", specialUser.photoloaded);
        builderNewInsert.withValue("likecount", specialUser.likecount);
        builderNewInsert.withValue("status", specialUser.status);
        builderNewInsert.withValue("url", specialUser.url);
        builderNewInsert.withValue("weburl", specialUser.weburl);
        builderNewInsert.withValue("tel", specialUser.tel);
        builderNewInsert.withValue("msgstatus", specialUser.msgstatus);
        if (specialUser.like != null) {
            builderNewInsert.withValue("islike", specialUser.like.equals(Spam.ACTIVITY_CANCEL) ? "N" : "Y");
        }
        if (specialUser.usertype != null) {
            builderNewInsert.withValue("usertype", specialUser.usertype);
        }
        builderNewInsert.withValue("isNew", "Y");
        return builderNewInsert.build();
    }

    /* renamed from: c */
    public static ContentProviderOperation m9773c(SpecialUser specialUser) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C2230ar.f7958a);
        if (specialUser.likecount == null && TextUtils.isEmpty(specialUser.likecount)) {
            specialUser.likecount = Spam.ACTIVITY_CANCEL;
        }
        if (specialUser.followcount == null && TextUtils.isEmpty(specialUser.followcount)) {
            specialUser.followcount = Spam.ACTIVITY_CANCEL;
        }
        builderNewInsert.withValue("buddy_no", specialUser.specialuserid);
        builderNewInsert.withValue("buddy_name", specialUser.name);
        builderNewInsert.withValue("description", specialUser.description);
        builderNewInsert.withValue("followcount", specialUser.followcount);
        builderNewInsert.withValue("photoloaded", specialUser.photoloaded);
        builderNewInsert.withValue("likecount", specialUser.likecount);
        builderNewInsert.withValue("status", specialUser.status);
        builderNewInsert.withValue("url", specialUser.url);
        builderNewInsert.withValue("weburl", specialUser.weburl);
        builderNewInsert.withValue("tel", specialUser.tel);
        builderNewInsert.withValue("msgstatus", specialUser.msgstatus);
        if (specialUser.like != null) {
            builderNewInsert.withValue("islike", specialUser.like.equals(Spam.ACTIVITY_CANCEL) ? "N" : "Y");
        }
        if (specialUser.usertype != null) {
            builderNewInsert.withValue("usertype", specialUser.usertype);
        }
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static boolean m9766a(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("0999");
    }

    /* renamed from: d */
    public static ContentProviderOperation m9776d(SpecialUser specialUser) {
        if (C4904y.f17872b) {
            C4904y.m18646e("[deleteLivepatnerUserFromSPDB] Livepartner ID = " + specialUser.specialuserid, "SpecialBuddyDatabaseHelper");
        }
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C2230ar.f7958a);
        builderNewDelete.withSelection("buddy_no = ?", new String[]{specialUser.specialuserid});
        return builderNewDelete.build();
    }

    /* renamed from: d */
    public static boolean m9777d(ContentResolver contentResolver, String str) {
        return contentResolver.delete(C2230ar.f7958a, "buddy_no = ? ", new String[]{str}) > 0;
    }

    /* renamed from: a */
    public static boolean m9765a(SQLiteDatabase sQLiteDatabase) {
        if (C4904y.f17872b) {
            C4904y.m18639b("migrationLivepartner ... ", "SpecialBuddyDatabaseHelper");
        }
        C4809aa.m18104a().m18128b("get_special_buddies_timestamp", Spam.ACTIVITY_CANCEL);
        C4809aa.m18104a().m18124a("get_myfollowing_buddies_timestamp", (Long) 0L);
        sQLiteDatabase.delete("recommendee", "type = ?", new String[]{String.valueOf(100)});
        return true;
    }

    /* renamed from: a */
    public static void m9764a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.rawQuery("UPDATE specialbuddy SET islike = 'Y' WHERE buddy_no = '" + str + "';", null);
    }

    /* renamed from: b */
    public static void m9771b(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.rawQuery("UPDATE specialbuddy SET islike = 'N' WHERE buddy_no = '" + str + "';", null);
    }

    /* renamed from: a */
    public static ContentProviderOperation m9760a(String str, String str2, String str3) {
        if (C4904y.f17872b) {
            C4904y.m18646e("updateFollowingLivepartnerLikeFollowCount buddy_no = " + str, "SpecialBuddyDatabaseHelper");
        }
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2230ar.f7958a);
        if (str2 == null && TextUtils.isEmpty(str2)) {
            str2 = Spam.ACTIVITY_CANCEL;
        }
        if (str3 == null && TextUtils.isEmpty(str3)) {
            str3 = Spam.ACTIVITY_CANCEL;
        }
        builderNewUpdate.withSelection("buddy_no=?", new String[]{str});
        builderNewUpdate.withValue("likecount", str2);
        builderNewUpdate.withValue("followcount", str3);
        return builderNewUpdate.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m9768b(String str, String str2, String str3) {
        if (C4904y.f17872b) {
            C4904y.m18646e("updateFollowingLivepartnerLikeFollowCount buddy_no = " + str, "SpecialBuddyDatabaseHelper");
        }
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C2228ap.f7956a);
        if (str2 == null && TextUtils.isEmpty(str2)) {
            str2 = Spam.ACTIVITY_CANCEL;
        }
        if (str3 == null && TextUtils.isEmpty(str3)) {
            str3 = Spam.ACTIVITY_CANCEL;
        }
        builderNewUpdate.withSelection("buddy_no=?", new String[]{str});
        builderNewUpdate.withValue("likecount", str2);
        builderNewUpdate.withValue("followcount", str3);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static void m9763a() {
        C4809aa.m18104a().m18124a("get_myfollowing_buddies_timestamp", (Long) 0L);
        C4809aa.m18104a().m18128b("get_special_buddies_timestamp", Spam.ACTIVITY_CANCEL);
    }

    /* renamed from: b */
    public static void m9770b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete("recommendee", "type='100'", null);
    }
}
