package com.sec.chaton.database.helper;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.database.Cursor;
import android.text.TextUtils;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.p000io.entry.inner.Buddy;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class BuddyDatabaseHelper {
    /* renamed from: a */
    public static ContentProviderOperation m2217a(Buddy buddy) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(ChatONContract.BuddyTable.f1713a);
        builderNewInsert.withValue("buddy_no", buddy.value);
        builderNewInsert.withValue("buddy_profile_status", Integer.valueOf(buddy.getImagestatus().getCode()));
        if (!TextUtils.isEmpty(buddy.name)) {
            buddy.name = buddy.name.trim();
            builderNewInsert.withValue("buddy_name", buddy.name);
            builderNewInsert.withValue("buddy_push_name", buddy.name);
        }
        String strM2236a = !TextUtils.isEmpty(buddy.orgnum) ? ContactDatabaseHelper.m2236a(buddy.orgnum) : null;
        if (strM2236a != null) {
            builderNewInsert.withValue("buddy_name", strM2236a.trim());
            ChatONLogWriter.m3511e("ignore showphonenumber " + buddy.showphonenumber + " for " + buddy.orgnum, "BuddyPrivacy");
            buddy.showphonenumber = null;
            builderNewInsert.withValue("buddy_show_phone_number", 0);
        } else {
            if (!TextUtils.isEmpty(buddy.orgname)) {
                builderNewInsert.withValue("buddy_name", buddy.orgname);
            }
            if (!TextUtils.isEmpty(buddy.name)) {
                builderNewInsert.withValue("buddy_is_profile_updated", "Y");
            }
            if (buddy.showphonenumber == null) {
                ChatONLogWriter.m3511e("keep showphonenumber " + buddy.showphonenumber + " for " + buddy.orgnum, "BuddyPrivacy");
                buddy.showphonenumber = false;
            } else {
                ChatONLogWriter.m3511e("set showphonenumber " + buddy.showphonenumber + " for " + buddy.orgnum, "BuddyPrivacy");
                builderNewInsert.withValue("buddy_show_phone_number", Integer.valueOf(buddy.showphonenumber.booleanValue() ? 2 : 1));
            }
        }
        if (buddy.status != null) {
            builderNewInsert.withValue("buddy_status_message", buddy.status);
            builderNewInsert.withValue("buddy_is_status_updated", "Y");
        }
        if (!TextUtils.isEmpty(buddy.orgnum)) {
            builderNewInsert.withValue("buddy_raw_contact_id", Long.valueOf(ContactDatabaseHelper.m2237b(buddy.orgnum)));
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

    /* renamed from: a */
    public static ContentProviderOperation m2218a(String str, String str2) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(ChatONContract.BuddyTable.f1713a);
        builderNewUpdate.withSelection("buddy_raw_contact_id=?", new String[]{str});
        builderNewUpdate.withValue("buddy_name", str2);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static Cursor m2219a(ContentResolver contentResolver, BuddyItem buddyItem) {
        try {
            return contentResolver.query(ChatONContract.InBoxTable.f1717a, new String[]{"inbox_no", "inbox_session_id"}, "inbox_no = ? AND inbox_chat_type = ? ", new String[]{buddyItem.m668a(), String.valueOf(ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a())}, null);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m2220a(ContentResolver contentResolver, String str) {
        Cursor cursorM2224b = m2224b(contentResolver, str);
        if (cursorM2224b == null || cursorM2224b.getCount() == 0 || !cursorM2224b.moveToFirst()) {
            return str;
        }
        String string = cursorM2224b.getString(cursorM2224b.getColumnIndex("buddy_name"));
        cursorM2224b.close();
        return string;
    }

    /* renamed from: a */
    public static void m2221a(ContentResolver contentResolver, BuddyItem buddyItem, boolean z) {
        try {
            contentResolver.delete(ChatONContract.GroupRelationTable.f1715a, "group_relation_buddy = ? ", new String[]{buddyItem.m668a()});
            contentResolver.delete(ChatONContract.BuddyTable.f1713a, "buddy_no = ? ", new String[]{buddyItem.m668a()});
            ChatONLogWriter.m3506b(buddyItem.m668a() + ":" + z, null);
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public static ContentProviderOperation m2222b(Buddy buddy) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(ChatONContract.BuddyTable.f1713a);
        builderNewDelete.withSelection("buddy_no = ?", new String[]{buddy.value});
        return builderNewDelete.build();
    }

    /* renamed from: b */
    public static ContentProviderOperation m2223b(String str, String str2) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(ChatONContract.BuddyTable.f1713a);
        builderNewUpdate.withSelection("buddy_raw_contact_id=?", new String[]{str});
        builderNewUpdate.withValue("buddy_name", str2);
        builderNewUpdate.withValue("buddy_raw_contact_id", 0);
        return builderNewUpdate.build();
    }

    /* renamed from: b */
    public static Cursor m2224b(ContentResolver contentResolver, String str) {
        return contentResolver.query(ChatONContract.BuddyTable.m2169a(str), null, null, null, null);
    }
}
