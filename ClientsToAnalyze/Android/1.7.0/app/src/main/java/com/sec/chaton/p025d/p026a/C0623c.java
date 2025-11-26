package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C0656i;
import com.sec.chaton.p025d.C0659l;
import com.sec.chaton.p033io.entry.inner.MemoEntry;

/* compiled from: MemoDatabaseHelper.java */
/* renamed from: com.sec.chaton.d.a.c */
/* loaded from: classes.dex */
public class C0623c {

    /* renamed from: a */
    private static Uri f2172a = C0659l.f2286a;

    /* renamed from: b */
    private static ContentResolver f2173b = GlobalApplication.m3100a().getContentResolver();

    public C0623c() {
        C0656i.m2982a(GlobalApplication.m3100a()).getReadableDatabase();
    }

    /* renamed from: a */
    public static Cursor m2853a(ContentResolver contentResolver, String str) {
        return GlobalApplication.m3100a().getContentResolver().query(f2172a, null, null, null, "timestamp desc");
    }

    /* renamed from: a */
    public static int m2851a(String str) {
        return f2173b.delete(f2172a, "timestamp = " + str, null);
    }

    /* renamed from: a */
    public static int m2850a() {
        return f2173b.delete(f2172a, null, null);
    }

    /* renamed from: a */
    public static ContentProviderOperation m2852a(MemoEntry memoEntry) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C0659l.f2286a);
        builderNewInsert.withValue("buddy_no", memoEntry.buddyid);
        builderNewInsert.withValue("buddy_name", memoEntry.buddyname);
        builderNewInsert.withValue("timestamp", memoEntry.timestamp);
        builderNewInsert.withValue("memo", memoEntry.value);
        return builderNewInsert.build();
    }
}
