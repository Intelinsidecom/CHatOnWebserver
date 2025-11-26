package com.sec.chaton.trunk.database.p052a;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;

/* compiled from: TrunkDatabaseOpenHelper.java */
/* renamed from: com.sec.chaton.trunk.database.a.b */
/* loaded from: classes.dex */
public class C1585b extends SQLiteOpenHelper {

    /* renamed from: a */
    private static final String f5688a = C1585b.class.getSimpleName();

    /* renamed from: b */
    private static C1585b f5689b;

    /* renamed from: c */
    private final String f5690c;

    /* renamed from: d */
    private final String f5691d;

    /* renamed from: e */
    private final String f5692e;

    /* renamed from: f */
    private final String f5693f;

    /* renamed from: g */
    private final String f5694g;

    /* renamed from: h */
    private final String f5695h;

    /* renamed from: i */
    private final String f5696i;

    /* renamed from: a */
    public static synchronized C1585b m5479a() {
        if (f5689b == null) {
            f5689b = new C1585b(GlobalApplication.m3260b());
        }
        return f5689b;
    }

    private C1585b(Context context) {
        super(context, "trunk.db", (SQLiteDatabase.CursorFactory) null, 4);
        this.f5690c = String.format("CREATE TABLE %s(\t%s INTEGER PRIMARY KEY AUTOINCREMENT, \t%s VARCHAR(200) NOT NULL UNIQUE, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0)", "trunk", "_id", "session_id", "last_update_time", "last_comment_time", "total_item_count", "unread_item_count", "unread_comment_count");
        StringBuilder sb = new StringBuilder("");
        sb.append("CREATE TRIGGER %s AFTER UPDATE ON %s");
        sb.append(" WHEN new.%s < 0");
        sb.append(" BEGIN");
        sb.append("  UPDATE %s SET %s=0;");
        sb.append(" END;");
        this.f5693f = String.format(sb.toString(), "trigger_update_trunk", "trunk", "total_item_count", "trunk", "total_item_count");
        this.f5691d = String.format("CREATE TABLE %s(\t%s INTEGER PRIMARY KEY AUTOINCREMENT, \t%s VARCHAR(200) NOT NULL, \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s INTEGER DEFAULT 0)", "trunk_item", "_id", "item_id", "session_id", "sender_uid", "sender_name", "sender_number", "registration_time", "last_comment_time", "total_comment_count", "unread_comment_count", "thumbnail", "down_url", "content_type", "item_type");
        StringBuilder sb2 = new StringBuilder("");
        sb2.append("CREATE TABLE %s(");
        sb2.append("\t%s INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb2.append("\t%s VARCHAR(200), ");
        sb2.append("\t%s VARCHAR(200) NOT NULL UNIQUE, ");
        sb2.append("\t%s INTENGER, ");
        sb2.append("\t%s VARCHAR(200), ");
        sb2.append("\t%s VARCHAR(200), ");
        sb2.append("\t%s VARCHAR(200), ");
        sb2.append("\t%s VARCHAR(1000)");
        sb2.append(")");
        this.f5692e = String.format(sb2.toString(), "trunk_comment", "_id", "item_id", "comment_id", "registration_time", "writer_uid", "writer_name", "writer_number", "content");
        this.f5694g = String.format("CREATE TRIGGER %s DELETE ON %s BEGIN  DELETE FROM %s WHERE %s=OLD.%s; END;", "trigger_trunk_item", "trunk", "trunk_item", "session_id", "session_id");
        this.f5695h = String.format("CREATE TRIGGER %s AFTER UPDATE ON %s WHEN new.%s < 0 BEGIN  UPDATE %s SET %s=0; END;", "trigger_update_trunk_item", "trunk_item", "total_comment_count", "trunk_item", "total_comment_count");
        StringBuilder sb3 = new StringBuilder("");
        sb3.append("CREATE TRIGGER %s DELETE ON %s");
        sb3.append(" BEGIN ");
        sb3.append("  DELETE FROM %s WHERE %s=OLD.%s; ");
        sb3.append(" END;");
        this.f5696i = String.format(sb3.toString(), "trigger_trunk_comment", "trunk_item", "trunk_comment", "item_id", "item_id");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(this.f5690c);
        sQLiteDatabase.execSQL(this.f5691d);
        sQLiteDatabase.execSQL(this.f5692e);
        sQLiteDatabase.execSQL(this.f5694g);
        sQLiteDatabase.execSQL(this.f5696i);
        sQLiteDatabase.execSQL(this.f5693f);
        sQLiteDatabase.execSQL(this.f5695h);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        int i3;
        C1786r.m6063c("Upgrade database from : " + i + " to : " + i2, f5688a);
        if (i == 1) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS trunk_comment");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS trunk_item");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS trunk");
            sQLiteDatabase.execSQL(this.f5690c);
            sQLiteDatabase.execSQL(this.f5691d);
            sQLiteDatabase.execSQL(this.f5692e);
            i3 = i + 1;
        } else {
            i3 = i;
        }
        if (i3 == 2) {
            sQLiteDatabase.execSQL(this.f5694g);
            sQLiteDatabase.execSQL(this.f5696i);
            i3++;
        }
        if (i3 == 3) {
            sQLiteDatabase.execSQL(this.f5693f);
            sQLiteDatabase.execSQL(this.f5695h);
            int i4 = i3 + 1;
        }
    }
}
