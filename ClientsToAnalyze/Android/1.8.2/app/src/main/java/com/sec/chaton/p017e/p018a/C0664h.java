package com.sec.chaton.p017e.p018a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.net.Uri;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.C0696k;
import com.sec.chaton.p028io.entry.inner.MemoListEntry;

/* compiled from: MemoSessionsDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.h */
/* loaded from: classes.dex */
public class C0664h {

    /* renamed from: a */
    private static Uri f2553a = C0696k.f2624a;

    /* renamed from: b */
    private static ContentResolver f2554b = GlobalApplication.m3260b().getContentResolver();

    /* renamed from: a */
    public static Cursor m3038a(ContentResolver contentResolver, String str) {
        return GlobalApplication.m3260b().getContentResolver().query(f2553a, null, "buddy_no=?", new String[]{str}, null);
    }

    /* renamed from: a */
    public static Uri m3039a(String str, MemoListEntry memoListEntry) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("buddy_no", str);
        contentValues.put("buddy_name", memoListEntry.hasmore);
        contentValues.put("endtime", memoListEntry.endtime);
        contentValues.put("isblind", memoListEntry.isblind);
        try {
            return f2554b.insert(f2553a, contentValues);
        } catch (SQLiteConstraintException e) {
            e.printStackTrace();
            return null;
        }
    }
}
