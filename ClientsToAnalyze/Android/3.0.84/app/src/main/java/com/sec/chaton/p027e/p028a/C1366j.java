package com.sec.chaton.p027e.p028a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;

/* compiled from: DownloadItemDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.j */
/* loaded from: classes.dex */
public class C1366j {
    /* renamed from: a */
    public static ContentProviderOperation m6093a(EnumC1399aq enumC1399aq, String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("install", Long.valueOf(j));
        contentValues.put("newly_installed", Long.valueOf(j));
        return ContentProviderOperation.newUpdate(C1398ap.m6249a(enumC1399aq).buildUpon().appendPath(str).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6092a(EnumC1399aq enumC1399aq, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("install", (Integer) 0);
        contentValues.put("newly_installed", (Integer) 0);
        return ContentProviderOperation.newUpdate(C1398ap.m6249a(enumC1399aq).buildUpon().appendPath(str).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6091a() {
        return ContentProviderOperation.newDelete(C1398ap.f5204a.buildUpon().appendEncodedPath("delete_not_installed_item").build()).build();
    }
}
