package com.sec.chaton.p017e.p018a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.buddy.p010a.C0258d;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.C0688c;
import com.sec.chaton.p017e.C0691f;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.C0704s;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p028io.entry.inner.Buddy;
import com.sec.chaton.util.C1786r;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: BuddyDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.a */
/* loaded from: classes.dex */
public class C0657a {
    /* renamed from: a */
    public static boolean m2979a(ContentResolver contentResolver, String str) {
        boolean z;
        Cursor cursorQuery = contentResolver.query(C0688c.f2606a, null, "buddy_no='" + str + "'", null, null);
        if (cursorQuery == null || cursorQuery.getCount() == 0 || !cursorQuery.moveToFirst() || !cursorQuery.getString(cursorQuery.getColumnIndex("buddy_is_name_updated")).equals("Y")) {
            z = false;
        } else {
            z = true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return z;
    }

    /* renamed from: b */
    public static boolean m2981b(ContentResolver contentResolver, String str) {
        boolean z;
        Cursor cursorQuery = contentResolver.query(C0688c.f2606a, null, "buddy_raw_contact_id='" + str + "'", null, null);
        if (cursorQuery == null || cursorQuery.getCount() == 0 || !cursorQuery.moveToFirst() || !cursorQuery.getString(cursorQuery.getColumnIndex("buddy_is_name_updated")).equals("Y")) {
            z = false;
        } else {
            z = true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return z;
    }

    /* renamed from: a */
    public static int m2972a(ContentResolver contentResolver, String str, String str2) {
        int iUpdate = -1;
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_name", str2);
        contentValues.put("buddy_is_name_updated", "Y");
        try {
            iUpdate = contentResolver.update(C0688c.f2606a, contentValues, "buddy_no = ? ", new String[]{str});
            System.out.println("Manju BuddyDatabaseHelper.renameBuddy() result=" + iUpdate);
            return iUpdate;
        } catch (Exception e) {
            return iUpdate;
        }
    }

    /* renamed from: c */
    public static String m2983c(ContentResolver contentResolver, String str) {
        Cursor cursorM2985d = m2985d(contentResolver, str);
        if (cursorM2985d != null && cursorM2985d.getCount() != 0 && cursorM2985d.moveToFirst()) {
            str = cursorM2985d.getString(cursorM2985d.getColumnIndex("buddy_name"));
        }
        if (cursorM2985d != null) {
            cursorM2985d.close();
        }
        return str;
    }

    /* renamed from: d */
    public static Cursor m2985d(ContentResolver contentResolver, String str) {
        return contentResolver.query(C0688c.m3121a(str), null, null, null, null);
    }

    /* renamed from: a */
    public static int m2971a(ContentResolver contentResolver) {
        Cursor cursorQuery = contentResolver.query(C0688c.f2606a, new String[]{"COUNT(*)"}, null, null, null);
        if (cursorQuery == null) {
            return 0;
        }
        cursorQuery.moveToFirst();
        return cursorQuery.getInt(0);
    }

    /* renamed from: a */
    public static ContentProviderOperation m2974a(Buddy buddy) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C0704s.f2647a);
        builderNewInsert.withValue("buddy_no", buddy.value);
        builderNewInsert.withValue("buddy_name", buddy.name);
        builderNewInsert.withValue("msgstatus", buddy.status);
        builderNewInsert.withValue("isNew", "Y");
        builderNewInsert.withValue("photoloaded", buddy.getImagestatus().equals(Buddy.BuddyImageStatus.NONE_PROFILE) ? "N" : "Y");
        return builderNewInsert.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m2980b(Buddy buddy) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0704s.f2647a);
        builderNewUpdate.withSelection("buddy_no='" + buddy.value + "'", null);
        builderNewUpdate.withValue("msgstatus", buddy.status);
        builderNewUpdate.withValue("photoloaded", buddy.getImagestatus().equals(Buddy.BuddyImageStatus.NONE_PROFILE) ? "N" : "Y");
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m2973a(ContentResolver contentResolver, C0258d c0258d) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0704s.f2647a);
        builderNewUpdate.withSelection("buddy_no='" + c0258d.m2354a() + "'", null);
        builderNewUpdate.withValue("msgstatus", c0258d.m2359f());
        builderNewUpdate.withValue("description", c0258d.m2356c());
        builderNewUpdate.withValue("followcount", c0258d.m2357d());
        builderNewUpdate.withValue("likecount", c0258d.m2358e());
        builderNewUpdate.withValue("status", c0258d.m2361h());
        builderNewUpdate.withValue(RtspHeaders.Values.URL, c0258d.m2362i());
        builderNewUpdate.withValue("weburl", c0258d.m2363j());
        builderNewUpdate.withValue("photoloaded", c0258d.m2360g().equals(Buddy.BuddyImageStatus.NONE_PROFILE) ? "N" : "Y");
        return builderNewUpdate.build();
    }

    /* renamed from: c */
    public static ContentProviderOperation m2982c(Buddy buddy) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C0688c.f2606a);
        builderNewInsert.withValue("buddy_no", buddy.value);
        builderNewInsert.withValue("buddy_profile_status", Integer.valueOf(buddy.getImagestatus().getCode()));
        String strM3001a = null;
        boolean zM2979a = m2979a(GlobalApplication.m3256a().getContentResolver(), buddy.value);
        if (!TextUtils.isEmpty(buddy.name)) {
            buddy.name = buddy.name.trim();
            if (zM2979a) {
                if (!TextUtils.isEmpty(buddy.orgname)) {
                    builderNewInsert.withValue("buddy_push_name", buddy.orgname);
                }
            } else {
                builderNewInsert.withValue("buddy_name", buddy.name);
                builderNewInsert.withValue("buddy_push_name", buddy.name);
            }
        }
        if (!TextUtils.isEmpty(buddy.orgnum)) {
            strM3001a = C0659c.m3001a(buddy.orgnum);
        }
        if (strM3001a != null) {
            String strTrim = strM3001a.trim();
            if (zM2979a) {
                builderNewInsert.withValue("buddy_push_name", strTrim);
            } else {
                builderNewInsert.withValue("buddy_name", strTrim);
            }
        } else {
            if (!TextUtils.isEmpty(buddy.orgname)) {
                if (zM2979a) {
                    builderNewInsert.withValue("buddy_push_name", buddy.orgname);
                } else {
                    builderNewInsert.withValue("buddy_name", buddy.orgname);
                }
            }
            if (!TextUtils.isEmpty(buddy.name)) {
                builderNewInsert.withValue("buddy_is_profile_updated", "Y");
            }
        }
        if (buddy.showphonenumber != null) {
            builderNewInsert.withValue("buddy_show_phone_number", Integer.valueOf(buddy.showphonenumber.booleanValue() ? 2 : 1));
        }
        if (buddy.einfo != null) {
            builderNewInsert.withValue("buddy_extra_info", buddy.einfo);
        }
        if (buddy.status != null) {
            builderNewInsert.withValue("buddy_status_message", buddy.status);
            builderNewInsert.withValue("buddy_is_status_updated", "Y");
        }
        if (!TextUtils.isEmpty(buddy.orgnum)) {
            builderNewInsert.withValue("buddy_raw_contact_id", Long.valueOf(C0659c.m3002b(buddy.orgnum)));
        }
        if (!TextUtils.isEmpty(buddy.orgnum)) {
            builderNewInsert.withValue("buddy_orginal_number", buddy.orgnum);
        }
        if (!TextUtils.isEmpty(buddy.birthday)) {
            builderNewInsert.withValue("buddy_birthday", buddy.birthday);
        }
        if (!TextUtils.isEmpty(buddy.samsungemail)) {
            builderNewInsert.withValue("buddy_samsung_email", buddy.samsungemail);
        }
        if (!TextUtils.isEmpty(buddy.email)) {
            builderNewInsert.withValue("buddy_email", buddy.email);
        }
        return builderNewInsert.build();
    }

    /* renamed from: d */
    public static ContentProviderOperation m2984d(Buddy buddy) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C0688c.f2606a);
        builderNewDelete.withSelection("buddy_no = ?", new String[]{buddy.value});
        return builderNewDelete.build();
    }

    /* renamed from: e */
    public static ContentProviderOperation m2986e(Buddy buddy) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C0704s.f2647a);
        builderNewDelete.withSelection("buddy_no = ?", new String[]{buddy.value});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m2975a(String str, String str2) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0688c.f2606a);
        boolean zM2981b = m2981b(GlobalApplication.m3256a().getContentResolver(), str);
        builderNewUpdate.withSelection("buddy_raw_contact_id=?", new String[]{str});
        if (zM2981b) {
            builderNewUpdate.withValue("buddy_push_name", str2);
        } else {
            builderNewUpdate.withValue("buddy_name", str2);
        }
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m2976a(String str, String str2, String str3) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0688c.f2606a);
        boolean zM2981b = m2981b(GlobalApplication.m3256a().getContentResolver(), str);
        builderNewUpdate.withSelection("buddy_raw_contact_id=?", new String[]{str});
        builderNewUpdate.withSelection("buddy_orginal_number=?", new String[]{str2});
        if (zM2981b) {
            builderNewUpdate.withValue("buddy_push_name", str3);
        } else {
            builderNewUpdate.withValue("buddy_name", str3);
        }
        builderNewUpdate.withValue("buddy_raw_contact_id", 0);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static void m2978a(ContentResolver contentResolver, C0257c c0257c, boolean z) {
        try {
            contentResolver.delete(C0691f.f2613a, "group_relation_buddy = ? ", new String[]{c0257c.m2318a()});
            contentResolver.delete(C0688c.f2606a, "buddy_no = ? ", new String[]{c0257c.m2318a()});
            contentResolver.delete(C0704s.f2647a, "buddy_no = ? ", new String[]{c0257c.m2318a()});
            C1786r.m6061b(c0257c.m2318a() + ":" + z, null);
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static Cursor m2977a(ContentResolver contentResolver, C0257c c0257c) {
        try {
            return contentResolver.query(C0694i.f2616a, new String[]{"inbox_no", "inbox_session_id"}, "inbox_no = ? AND inbox_chat_type = ? ", new String[]{c0257c.m2318a(), String.valueOf(EnumC0695j.ONETOONE.m3146a())}, null);
        } catch (Exception e) {
            return null;
        }
    }
}
