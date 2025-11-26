package com.sec.chaton.settings.tellfriends.p046a;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: DbOpenHelper.java */
/* renamed from: com.sec.chaton.settings.tellfriends.a.b */
/* loaded from: classes.dex */
class C1344b extends SQLiteOpenHelper {

    /* renamed from: a */
    final /* synthetic */ C1343a f5149a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1344b(C1343a c1343a, Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.f5149a = c1343a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("create table snsInvitedList(_id integer primary key autoincrement, uid text not null , name text not null );");
        sQLiteDatabase.execSQL("create table userinfo(_id integer primary key autoincrement, uid text not null );");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS snsInvitedList");
        onCreate(sQLiteDatabase);
    }
}
