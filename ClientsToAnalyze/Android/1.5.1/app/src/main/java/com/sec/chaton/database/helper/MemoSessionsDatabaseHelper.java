package com.sec.chaton.database.helper;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.net.Uri;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p000io.entry.inner.MemoListEntry;

/* loaded from: classes.dex */
public class MemoSessionsDatabaseHelper {

    /* renamed from: a */
    private static Uri f1773a = ChatONContract.MemoSessionsTable.f1724a;

    /* renamed from: b */
    private static ContentResolver f1774b = GlobalApplication.m2387e().getContentResolver();

    /* renamed from: a */
    public static Cursor m2270a(ContentResolver contentResolver, String str) {
        return GlobalApplication.m2387e().getContentResolver().query(f1773a, null, "buddy_no=?", new String[]{str}, null);
    }

    /* renamed from: a */
    public static Uri m2271a(String str, MemoListEntry memoListEntry) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_no", str);
        contentValues.put("buddy_name", memoListEntry.hasmore);
        contentValues.put("endtime", memoListEntry.endtime);
        contentValues.put("isblind", memoListEntry.isblind);
        try {
            return f1774b.insert(f1773a, contentValues);
        } catch (SQLiteConstraintException e) {
            e.printStackTrace();
            return null;
        }
    }
}
