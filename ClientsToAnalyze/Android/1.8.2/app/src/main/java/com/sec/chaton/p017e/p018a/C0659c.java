package com.sec.chaton.p017e.p018a;

import android.content.ContentProviderOperation;
import android.database.Cursor;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.C0689d;

/* compiled from: ContactDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.c */
/* loaded from: classes.dex */
public class C0659c {
    /* renamed from: a */
    public static ContentProviderOperation m2999a(int i, String str, int i2, String str2) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C0689d.f2607a);
        builderNewInsert.withValue("contacts_id", Integer.valueOf(i));
        builderNewInsert.withValue("conatct_number", str);
        builderNewInsert.withValue("contact_raw_id", Integer.valueOf(i2));
        builderNewInsert.withValue("contacts_name", str2);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m2998a(int i) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C0689d.f2607a);
        builderNewDelete.withSelection("contacts_id=?", new String[]{String.valueOf(i)});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m3000a(int i, String str, String str2) {
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0689d.f2607a);
        builderNewUpdate.withSelection("contacts_id=?", new String[]{String.valueOf(i)});
        builderNewUpdate.withValue(str, str2);
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static String m3001a(String str) {
        Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(C0689d.f2607a, null, "conatct_number=?", new String[]{str}, "contacts_id DESC");
        String string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("contacts_name")) : null;
        cursorQuery.close();
        return string;
    }

    /* renamed from: b */
    public static long m3002b(String str) {
        if (str == null) {
            return 0L;
        }
        Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(C0689d.f2607a, null, "conatct_number=?", new String[]{str}, "contacts_id DESC");
        long j = cursorQuery.moveToFirst() ? cursorQuery.getLong(cursorQuery.getColumnIndex("contact_raw_id")) : 0L;
        cursorQuery.close();
        return j;
    }
}
