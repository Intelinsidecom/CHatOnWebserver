package com.sec.chaton.database.helper;

import android.content.ContentProviderOperation;
import android.database.Cursor;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class ContactDatabaseHelper {
    /* renamed from: a */
    public static ContentProviderOperation m2233a(int i) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(ChatONContract.ContactsTable.f1714a);
        builderNewDelete.withSelection("contacts_id=?", new String[]{String.valueOf(i)});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m2234a(int i, String str, int i2, String str2) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(ChatONContract.ContactsTable.f1714a);
        builderNewInsert.withValue("contacts_id", Integer.valueOf(i));
        builderNewInsert.withValue("conatct_number", str);
        builderNewInsert.withValue("contact_raw_id", Integer.valueOf(i2));
        builderNewInsert.withValue("contacts_name", str2);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m2235a(int i, String str, String str2) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(ChatONContract.ContactsTable.f1714a);
        builderNewUpdate.withSelection("contacts_id=?", new String[]{String.valueOf(i)});
        builderNewUpdate.withValue(str, str2);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static String m2236a(String str) {
        Cursor cursorQuery = GlobalApplication.m2387e().getContentResolver().query(ChatONContract.ContactsTable.f1714a, null, "conatct_number=?", new String[]{str}, "contacts_id DESC");
        String string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("contacts_name")) : null;
        cursorQuery.close();
        return string;
    }

    /* renamed from: b */
    public static long m2237b(String str) {
        if (str == null) {
            return 0L;
        }
        Cursor cursorQuery = GlobalApplication.m2387e().getContentResolver().query(ChatONContract.ContactsTable.f1714a, null, "conatct_number=?", new String[]{str}, "contacts_id DESC");
        long j = cursorQuery.moveToFirst() ? cursorQuery.getLong(cursorQuery.getColumnIndex("contact_raw_id")) : 0L;
        cursorQuery.close();
        return j;
    }
}
