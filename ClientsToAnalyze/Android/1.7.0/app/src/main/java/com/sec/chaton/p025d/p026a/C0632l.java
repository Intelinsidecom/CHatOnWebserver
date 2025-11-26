package com.sec.chaton.p025d.p026a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.net.Uri;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C0653f;
import com.sec.chaton.p033io.entry.inner.MemoListEntry;

/* compiled from: MemoSessionsDatabaseHelper.java */
/* renamed from: com.sec.chaton.d.a.l */
/* loaded from: classes.dex */
public class C0632l {

    /* renamed from: a */
    private static Uri f2196a = C0653f.f2278a;

    /* renamed from: b */
    private static ContentResolver f2197b = GlobalApplication.m3100a().getContentResolver();

    /* renamed from: a */
    public static Cursor m2876a(ContentResolver contentResolver, String str) {
        return GlobalApplication.m3100a().getContentResolver().query(f2196a, null, "buddy_no=?", new String[]{str}, null);
    }

    /* renamed from: a */
    public static Uri m2877a(String str, MemoListEntry memoListEntry) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_no", str);
        contentValues.put("buddy_name", memoListEntry.hasmore);
        contentValues.put("endtime", memoListEntry.endtime);
        contentValues.put("isblind", memoListEntry.isblind);
        try {
            return f2197b.insert(f2196a, contentValues);
        } catch (SQLiteConstraintException e) {
            e.printStackTrace();
            return null;
        }
    }
}
