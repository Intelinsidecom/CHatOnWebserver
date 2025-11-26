package com.sec.chaton.localbackup.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.common.CommonApplication;

/* compiled from: BackupDBHelper.java */
/* renamed from: com.sec.chaton.localbackup.database.b */
/* loaded from: classes.dex */
public class C2544b extends SQLiteOpenHelper {

    /* renamed from: a */
    private static C2544b f9149a;

    /* renamed from: a */
    public static synchronized C2544b m10951a() {
        if (f9149a == null) {
            f9149a = new C2544b();
        }
        return f9149a;
    }

    private C2544b() {
        super(CommonApplication.m18732r(), "chaton_local_backup.db", (SQLiteDatabase.CursorFactory) null, 120);
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
    public static void m10952b() {
        ContentValues contentValues = new ContentValues();
        contentValues.putNull("message_download_uri");
        m10951a().getWritableDatabase().update(VKApiConst.MESSAGE, contentValues, null, null);
    }
}
