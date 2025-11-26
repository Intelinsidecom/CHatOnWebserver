package com.sec.chaton.database.helper;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.DatabaseHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p000io.entry.inner.MemoEntry;

/* loaded from: classes.dex */
public class MemoDatabaseHelper {

    /* renamed from: a */
    private static Uri f1771a = ChatONContract.MemoTable.f1725a;

    /* renamed from: b */
    private static ContentResolver f1772b = GlobalApplication.m2387e().getContentResolver();

    public MemoDatabaseHelper() {
        DatabaseHelper.m2204a(GlobalApplication.m2387e()).getReadableDatabase();
    }

    /* renamed from: a */
    public static int m2266a() {
        return f1772b.delete(f1771a, null, null);
    }

    /* renamed from: a */
    public static int m2267a(String str) {
        return f1772b.delete(f1771a, "timestamp = " + str, null);
    }

    /* renamed from: a */
    public static ContentProviderOperation m2268a(MemoEntry memoEntry) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(ChatONContract.MemoTable.f1725a);
        builderNewInsert.withValue("buddy_no", memoEntry.buddyid);
        builderNewInsert.withValue("buddy_name", memoEntry.buddyname);
        builderNewInsert.withValue("timestamp", memoEntry.timestamp);
        builderNewInsert.withValue("memo", memoEntry.value);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static Cursor m2269a(ContentResolver contentResolver, String str) {
        return GlobalApplication.m2387e().getContentResolver().query(f1771a, null, null, null, "timestamp desc");
    }
}
