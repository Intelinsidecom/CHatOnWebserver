package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.database.Cursor;
import android.text.TextUtils;
import com.sec.chaton.buddy.p017a.C0363a;
import com.sec.chaton.p025d.C0667t;
import com.sec.chaton.p025d.C0668u;
import com.sec.chaton.p025d.C0671x;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p033io.entry.inner.Buddy;
import com.sec.chaton.util.C1341p;
import java.util.Map;

/* compiled from: BuddyDatabaseHelper.java */
/* renamed from: com.sec.chaton.d.a.m */
/* loaded from: classes.dex */
public class C0633m {
    /* renamed from: a */
    public static String m2883a(ContentResolver contentResolver, String str) {
        Cursor cursorM2887b = m2887b(contentResolver, str);
        if (cursorM2887b != null && cursorM2887b.getCount() != 0 && cursorM2887b.moveToFirst()) {
            str = cursorM2887b.getString(cursorM2887b.getColumnIndex("buddy_name"));
        }
        if (cursorM2887b != null) {
            cursorM2887b.close();
        }
        return str;
    }

    /* renamed from: a */
    public static boolean m2885a(ContentResolver contentResolver, String[] strArr, Map map) {
        boolean z = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append("'").append(strArr[i]).append("'");
            if (i < strArr.length - 1) {
                sb.append(", ");
            }
        }
        Cursor cursorQuery = contentResolver.query(C0667t.f2310a, new String[]{"buddy_no", "buddy_name"}, "buddy_no IN ( " + sb.toString() + " )", null, null);
        if (cursorQuery != null && cursorQuery.getCount() != 0) {
            while (cursorQuery.moveToNext()) {
                map.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            z = true;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return z;
    }

    /* renamed from: b */
    public static Cursor m2887b(ContentResolver contentResolver, String str) {
        return contentResolver.query(C0667t.m3024a(str), null, null, null, null);
    }

    /* renamed from: a */
    public static int m2878a(ContentResolver contentResolver) {
        Cursor cursorQuery = contentResolver.query(C0667t.f2310a, new String[]{"COUNT(*)"}, null, null, null);
        if (cursorQuery == null) {
            return 0;
        }
        cursorQuery.moveToFirst();
        return cursorQuery.getInt(0);
    }

    /* renamed from: a */
    public static ContentProviderOperation m2879a(Buddy buddy) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C0667t.f2310a);
        builderNewInsert.withValue("buddy_no", buddy.value);
        builderNewInsert.withValue("buddy_profile_status", Integer.valueOf(buddy.getImagestatus().getCode()));
        String strM2838a = null;
        if (!TextUtils.isEmpty(buddy.name)) {
            buddy.name = buddy.name.trim();
            builderNewInsert.withValue("buddy_name", buddy.name);
            builderNewInsert.withValue("buddy_push_name", buddy.name);
        }
        if (!TextUtils.isEmpty(buddy.orgnum)) {
            strM2838a = C0621a.m2838a(buddy.orgnum);
        }
        if (strM2838a != null) {
            builderNewInsert.withValue("buddy_name", strM2838a.trim());
        } else {
            if (!TextUtils.isEmpty(buddy.orgname)) {
                builderNewInsert.withValue("buddy_name", buddy.orgname);
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
            builderNewInsert.withValue("buddy_raw_contact_id", Long.valueOf(C0621a.m2839b(buddy.orgnum)));
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

    /* renamed from: b */
    public static ContentProviderOperation m2886b(Buddy buddy) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C0667t.f2310a);
        builderNewDelete.withSelection("buddy_no = ?", new String[]{buddy.value});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m2880a(String str, String str2) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0667t.f2310a);
        builderNewUpdate.withSelection("buddy_raw_contact_id=?", new String[]{str});
        builderNewUpdate.withValue("buddy_name", str2);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m2881a(String str, String str2, String str3) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0667t.f2310a);
        builderNewUpdate.withSelection("buddy_raw_contact_id=?", new String[]{str});
        builderNewUpdate.withSelection("buddy_orginal_number=?", new String[]{str2});
        builderNewUpdate.withValue("buddy_name", str3);
        builderNewUpdate.withValue("buddy_raw_contact_id", 0);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static void m2884a(ContentResolver contentResolver, C0363a c0363a, boolean z) {
        try {
            contentResolver.delete(C0668u.f2311a, "group_relation_buddy = ? ", new String[]{c0363a.m2308a()});
            contentResolver.delete(C0667t.f2310a, "buddy_no = ? ", new String[]{c0363a.m2308a()});
            C1341p.m4658b(c0363a.m2308a() + ":" + z, null);
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static Cursor m2882a(ContentResolver contentResolver, C0363a c0363a) {
        try {
            return contentResolver.query(C0671x.f2315a, new String[]{"inbox_no", "inbox_session_id"}, "inbox_no = ? AND inbox_chat_type = ? ", new String[]{c0363a.m2308a(), String.valueOf(EnumC0665r.ONETOONE.m3012a())}, null);
        } catch (Exception e) {
            return null;
        }
    }
}
