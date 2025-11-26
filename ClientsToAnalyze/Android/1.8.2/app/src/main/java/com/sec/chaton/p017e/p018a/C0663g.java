package com.sec.chaton.p017e.p018a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.C0697l;
import com.sec.chaton.p028io.entry.inner.MemoEntry;

/* compiled from: MemoDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.g */
/* loaded from: classes.dex */
public class C0663g {

    /* renamed from: a */
    private static Uri f2551a = C0697l.f2625a;

    /* renamed from: b */
    private static ContentResolver f2552b = GlobalApplication.m3260b().getContentResolver();

    /* renamed from: a */
    public static Cursor m3037a(ContentResolver contentResolver, String str) {
        return GlobalApplication.m3260b().getContentResolver().query(f2551a, null, null, null, "timestamp desc");
    }

    /* renamed from: a */
    public static int m3035a(String str) {
        return f2552b.delete(f2551a, "timestamp = " + str, null);
    }

    /* renamed from: a */
    public static int m3034a() {
        return f2552b.delete(f2551a, null, null);
    }

    /* renamed from: a */
    public static ContentProviderOperation m3036a(MemoEntry memoEntry) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C0697l.f2625a);
        builderNewInsert.withValue("buddy_no", memoEntry.buddyid);
        builderNewInsert.withValue("buddy_name", memoEntry.buddyname);
        builderNewInsert.withValue("timestamp", memoEntry.timestamp);
        builderNewInsert.withValue("memo", memoEntry.value);
        return builderNewInsert.build();
    }
}
