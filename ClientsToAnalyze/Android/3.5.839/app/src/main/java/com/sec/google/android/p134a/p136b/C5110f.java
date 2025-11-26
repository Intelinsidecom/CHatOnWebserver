package com.sec.google.android.p134a.p136b;

import android.R;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

/* compiled from: SqliteWrapper.java */
/* renamed from: com.sec.google.android.a.b.f */
/* loaded from: classes.dex */
public final class C5110f {
    /* renamed from: a */
    private static boolean m19500a(SQLiteException sQLiteException) {
        return sQLiteException.getMessage().equals("unable to open database file");
    }

    /* renamed from: a */
    public static void m19499a(Context context, SQLiteException sQLiteException) {
        if (m19500a(sQLiteException)) {
            Toast.makeText(context, R.string.battery_saver_description, 0).show();
            return;
        }
        throw sQLiteException;
    }

    /* renamed from: a */
    public static Cursor m19497a(Context context, ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        } catch (SQLiteException e) {
            Log.e("SqliteWrapper", "Catch a SQLiteException when query: ", e);
            m19499a(context, e);
            return null;
        }
    }

    /* renamed from: a */
    public static int m19495a(Context context, ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            return contentResolver.update(uri, contentValues, str, strArr);
        } catch (SQLiteException e) {
            Log.e("SqliteWrapper", "Catch a SQLiteException when update: ", e);
            m19499a(context, e);
            return -1;
        }
    }

    /* renamed from: a */
    public static int m19496a(Context context, ContentResolver contentResolver, Uri uri, String str, String[] strArr) {
        try {
            return contentResolver.delete(uri, str, strArr);
        } catch (SQLiteException e) {
            Log.e("SqliteWrapper", "Catch a SQLiteException when delete: ", e);
            m19499a(context, e);
            return -1;
        }
    }

    /* renamed from: a */
    public static Uri m19498a(Context context, ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        try {
            return contentResolver.insert(uri, contentValues);
        } catch (SQLiteException e) {
            Log.e("SqliteWrapper", "Catch a SQLiteException when insert: ", e);
            m19499a(context, e);
            return null;
        }
    }
}
