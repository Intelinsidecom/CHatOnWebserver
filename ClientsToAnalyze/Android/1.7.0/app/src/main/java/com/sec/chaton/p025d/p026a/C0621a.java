package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.database.Cursor;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C0657j;

/* compiled from: ContactDatabaseHelper.java */
/* renamed from: com.sec.chaton.d.a.a */
/* loaded from: classes.dex */
public class C0621a {
    /* renamed from: a */
    public static ContentProviderOperation m2836a(int i, String str, int i2, String str2) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C0657j.f2284a);
        builderNewInsert.withValue("contacts_id", Integer.valueOf(i));
        builderNewInsert.withValue("conatct_number", str);
        builderNewInsert.withValue("contact_raw_id", Integer.valueOf(i2));
        builderNewInsert.withValue("contacts_name", str2);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m2835a(int i) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C0657j.f2284a);
        builderNewDelete.withSelection("contacts_id=?", new String[]{String.valueOf(i)});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m2837a(int i, String str, String str2) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0657j.f2284a);
        builderNewUpdate.withSelection("contacts_id=?", new String[]{String.valueOf(i)});
        builderNewUpdate.withValue(str, str2);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static String m2838a(String str) {
        Cursor cursorQuery = GlobalApplication.m3100a().getContentResolver().query(C0657j.f2284a, null, "conatct_number=?", new String[]{str}, "contacts_id DESC");
        String string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("contacts_name")) : null;
        cursorQuery.close();
        return string;
    }

    /* renamed from: b */
    public static long m2839b(String str) {
        if (str == null) {
            return 0L;
        }
        Cursor cursorQuery = GlobalApplication.m3100a().getContentResolver().query(C0657j.f2284a, null, "conatct_number=?", new String[]{str}, "contacts_id DESC");
        long j = cursorQuery.moveToFirst() ? cursorQuery.getLong(cursorQuery.getColumnIndex("contact_raw_id")) : 0L;
        cursorQuery.close();
        return j;
    }
}
