package com.sec.chaton.localbackup.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sec.common.CommonApplication;

/* compiled from: BackupDBHelper.java */
/* renamed from: com.sec.chaton.localbackup.database.b */
/* loaded from: classes.dex */
public class C1642b extends SQLiteOpenHelper {

    /* renamed from: a */
    private static C1642b f6104a;

    /* renamed from: a */
    public static synchronized C1642b m6919a() {
        if (f6104a == null) {
            f6104a = new C1642b();
        }
        return f6104a;
    }

    private C1642b() {
        super(CommonApplication.m11493l(), "chaton_local_backup.db", (SQLiteDatabase.CursorFactory) null, 84);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    /* renamed from: b */
    public static void m6920b() {
        ContentValues contentValues = new ContentValues();
        contentValues.putNull("message_download_uri");
        m6919a().getWritableDatabase().update("message", contentValues, null, null);
    }
}
