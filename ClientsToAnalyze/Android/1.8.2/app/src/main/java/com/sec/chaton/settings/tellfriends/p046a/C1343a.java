package com.sec.chaton.settings.tellfriends.p046a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: DbOpenHelper.java */
/* renamed from: com.sec.chaton.settings.tellfriends.a.a */
/* loaded from: classes.dex */
public class C1343a {

    /* renamed from: a */
    public static SQLiteDatabase f5146a;

    /* renamed from: b */
    private C1344b f5147b;

    /* renamed from: c */
    private Context f5148c;

    public C1343a(Context context) {
        this.f5148c = context;
    }

    /* renamed from: a */
    public C1343a m5072a() {
        this.f5147b = new C1344b(this, this.f5148c, "facebookInvitedList.db", null, 1);
        f5146a = this.f5147b.getWritableDatabase();
        return this;
    }

    /* renamed from: b */
    public void m5073b() throws SQLException {
        f5146a.execSQL("DROP TABLE IF EXISTS snsInvitedList");
        f5146a.execSQL("DROP TABLE IF EXISTS userinfo");
        f5146a.execSQL("create table snsInvitedList(_id integer primary key autoincrement, uid text not null , name text not null );");
        f5146a.execSQL("create table userinfo(_id integer primary key autoincrement, uid text not null );");
    }

    /* renamed from: c */
    public void m5074c() {
        f5146a.close();
    }

    /* renamed from: a */
    public long m5071a(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("uid", str);
        return f5146a.insert("userinfo", null, contentValues);
    }

    /* renamed from: d */
    public Cursor m5075d() {
        return f5146a.query("snsInvitedList", null, null, null, null, null, null);
    }

    /* renamed from: e */
    public Cursor m5076e() {
        return f5146a.query("userinfo", null, null, null, null, null, null);
    }
}
