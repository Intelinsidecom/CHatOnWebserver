package com.sec.vip.amschaton.p071a;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sec.chaton.util.C3250y;

/* compiled from: AMSDatabase.java */
/* renamed from: com.sec.vip.amschaton.a.b */
/* loaded from: classes.dex */
public class C3394b extends SQLiteOpenHelper {

    /* renamed from: a */
    private String f12433a;

    /* renamed from: b */
    private String f12434b;

    public C3394b(Context context, String str) {
        super(context, "ams_database.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.f12434b = " (_id integer primary key autoincrement, ams_path text not null, ams_index text not null, ams_type text not null, ams_date text not null);";
        this.f12433a = str;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C3250y.m11453c("[onCreate] table name : " + this.f12433a, getClass().getSimpleName());
        sQLiteDatabase.execSQL("create table " + this.f12433a + this.f12434b);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        C3250y.m11455d("Upgrading database from version " + i + " to " + i2 + ", which will destroy all old data", getClass().getSimpleName());
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + this.f12433a);
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) throws SQLException {
        C3250y.m11453c("[onOpen]", getClass().getSimpleName());
        sQLiteDatabase.execSQL("create table if not exists " + this.f12433a + this.f12434b);
        super.onOpen(sQLiteDatabase);
    }
}
