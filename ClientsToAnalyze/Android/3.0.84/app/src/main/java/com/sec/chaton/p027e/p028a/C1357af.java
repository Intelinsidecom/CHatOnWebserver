package com.sec.chaton.p027e.p028a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.sec.chaton.p027e.C1388af;
import com.sec.chaton.p027e.C1390ah;
import com.sec.chaton.p035io.entry.inner.SpecialUser;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;

/* compiled from: SpecialBuddyDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.af */
/* loaded from: classes.dex */
public class C1357af {
    /* renamed from: a */
    public static String m5987a(Context context, String str) {
        String string = null;
        if (str != null && context != null) {
            Cursor cursorQuery = context.getContentResolver().query(C1390ah.f5188a, new String[]{"buddy_name"}, "buddy_no=?", new String[]{str}, null);
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

    /* renamed from: b */
    public static String m5993b(Context context, String str) {
        String string = null;
        if (str != null && context != null) {
            Cursor cursorQuery = context.getContentResolver().query(C1390ah.f5188a, new String[]{"weburl"}, "buddy_no=?", new String[]{str}, null);
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

    /* renamed from: a */
    public static String m5986a(ContentResolver contentResolver, String str) {
        String string = null;
        if (contentResolver == null || str == null || str.isEmpty()) {
            throw new IllegalArgumentException("resolver and id must be provided");
        }
        Cursor cursorQuery = contentResolver.query(C1388af.f5186a, new String[]{"buddy_name"}, "buddy_no=?", new String[]{str}, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0 && cursorQuery.moveToFirst()) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"));
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return string;
    }

    /* renamed from: c */
    public static boolean m5998c(Context context, String str) {
        if (str == null || context == null) {
            return false;
        }
        Cursor cursorQuery = context.getContentResolver().query(C1390ah.f5188a, new String[]{"buddy_no"}, "buddy_no=?", new String[]{str}, null);
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
    public static boolean m5995b(ContentResolver contentResolver, String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("[isExsistLivepartnerUser] Livepartner ID = " + str, "SpecialBuddyDatabaseHelper");
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorQuery = contentResolver.query(C1388af.f5186a, new String[]{"buddy_no"}, "buddy_no=?", new String[]{str}, null);
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

    /* renamed from: c */
    public static boolean m5997c(ContentResolver contentResolver, String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("[isExsistFollowingLivepartnerUser] Livepartner ID = " + str, "SpecialBuddyDatabaseHelper");
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursorQuery = contentResolver.query(C1390ah.f5188a, new String[]{"buddy_no"}, "buddy_no=?", new String[]{str}, null);
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
    public static ContentProviderOperation m5984a(SpecialUser specialUser) {
        if (C3250y.f11734b) {
            C3250y.m11450b("[insertLivepartnerUser] Livepartner ID = " + specialUser.specialuserid, "SpecialBuddyDatabaseHelper");
        }
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C1388af.f5186a);
        builderNewInsert.withValue("buddy_no", specialUser.specialuserid);
        builderNewInsert.withValue("buddy_name", specialUser.name);
        builderNewInsert.withValue(PrefFragmentChats.TYPE, 100);
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
    public static ContentProviderOperation m5992b(SpecialUser specialUser) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C1390ah.f5188a);
        if (specialUser.likecount == null && TextUtils.isEmpty(specialUser.likecount)) {
            specialUser.likecount = "0";
        }
        if (specialUser.followcount == null && TextUtils.isEmpty(specialUser.followcount)) {
            specialUser.followcount = "0";
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
            builderNewInsert.withValue("islike", specialUser.like.equals("0") ? "N" : "Y");
        }
        if (specialUser.usertype != null) {
            builderNewInsert.withValue("usertype", specialUser.usertype);
        }
        builderNewInsert.withValue("isNew", "Y");
        return builderNewInsert.build();
    }

    /* renamed from: c */
    public static ContentProviderOperation m5996c(SpecialUser specialUser) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C1390ah.f5188a);
        if (specialUser.likecount == null && TextUtils.isEmpty(specialUser.likecount)) {
            specialUser.likecount = "0";
        }
        if (specialUser.followcount == null && TextUtils.isEmpty(specialUser.followcount)) {
            specialUser.followcount = "0";
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
            builderNewInsert.withValue("islike", specialUser.like.equals("0") ? "N" : "Y");
        }
        if (specialUser.usertype != null) {
            builderNewInsert.withValue("usertype", specialUser.usertype);
        }
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static boolean m5991a(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("0999");
    }

    /* renamed from: d */
    public static ContentProviderOperation m5999d(SpecialUser specialUser) {
        if (C3250y.f11734b) {
            C3250y.m11450b("[deleteLivePatnerUser] Livepartner ID = " + specialUser.specialuserid, "SpecialBuddyDatabaseHelper");
        }
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C1388af.f5186a);
        builderNewDelete.withSelection("buddy_no = ?", new String[]{specialUser.specialuserid});
        return builderNewDelete.build();
    }

    /* renamed from: e */
    public static ContentProviderOperation m6001e(SpecialUser specialUser) {
        if (C3250y.f11734b) {
            C3250y.m11456e("[deleteLivepatnerUserFromSPDB] Livepartner ID = " + specialUser.specialuserid, "SpecialBuddyDatabaseHelper");
        }
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C1390ah.f5188a);
        builderNewDelete.withSelection("buddy_no = ?", new String[]{specialUser.specialuserid});
        return builderNewDelete.build();
    }

    /* renamed from: d */
    public static boolean m6000d(ContentResolver contentResolver, String str) {
        return contentResolver.delete(C1390ah.f5188a, "buddy_no = ? ", new String[]{str}) > 0;
    }

    /* renamed from: a */
    public static boolean m5990a(SQLiteDatabase sQLiteDatabase) {
        if (C3250y.f11734b) {
            C3250y.m11450b("migrationLivepartner ... ", "SpecialBuddyDatabaseHelper");
        }
        C3159aa.m10962a().m10986b("get_special_buddies_timestamp", "0");
        C3159aa.m10962a().m10982a("get_myfollowing_buddies_timestamp", (Long) 0L);
        sQLiteDatabase.delete("recommendee", "type = ?", new String[]{String.valueOf(100)});
        return true;
    }

    /* renamed from: a */
    public static void m5989a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.rawQuery("UPDATE specialbuddy SET islike = 'Y' WHERE buddy_no = '" + str + "';", null);
    }

    /* renamed from: b */
    public static void m5994b(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.rawQuery("UPDATE specialbuddy SET islike = 'N' WHERE buddy_no = '" + str + "';", null);
    }

    /* renamed from: a */
    public static ContentProviderOperation m5985a(String str, String str2, String str3) {
        if (C3250y.f11734b) {
            C3250y.m11456e("updateFollowingLivepartnerLikeFollowCount buddy_no = " + str, "SpecialBuddyDatabaseHelper");
        }
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C1390ah.f5188a);
        if (str2 == null && TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        if (str3 == null && TextUtils.isEmpty(str3)) {
            str3 = "0";
        }
        builderNewUpdate.withSelection("buddy_no=?", new String[]{str});
        builderNewUpdate.withValue("likecount", str2);
        builderNewUpdate.withValue("followcount", str3);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static void m5988a() {
        C3159aa.m10962a().m10982a("get_myfollowing_buddies_timestamp", (Long) 0L);
        C3159aa.m10962a().m10986b("get_special_buddies_timestamp", "0");
    }
}
