package com.sec.chaton.trunk.database.p046a;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1341p;

/* compiled from: TrunkDatabaseOpenHelper.java */
/* renamed from: com.sec.chaton.trunk.database.a.a */
/* loaded from: classes.dex */
public class C1172a extends SQLiteOpenHelper {

    /* renamed from: a */
    private static final String f4025a = C1172a.class.getSimpleName();

    /* renamed from: b */
    private static C1172a f4026b;

    /* renamed from: c */
    private final String f4027c;

    /* renamed from: d */
    private final String f4028d;

    /* renamed from: e */
    private final String f4029e;

    /* renamed from: f */
    private final String f4030f;

    /* renamed from: g */
    private final String f4031g;

    /* renamed from: h */
    private final String f4032h;

    /* renamed from: i */
    private final String f4033i;

    /* renamed from: a */
    public static synchronized C1172a m4229a() {
        if (f4026b == null) {
            f4026b = new C1172a(GlobalApplication.m3100a());
        }
        return f4026b;
    }

    private C1172a(Context context) {
        super(context, "trunk.db", (SQLiteDatabase.CursorFactory) null, 4);
        this.f4027c = String.format("CREATE TABLE %s(\t%s INTEGER PRIMARY KEY AUTOINCREMENT, \t%s VARCHAR(200) NOT NULL UNIQUE, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0)", "trunk", "_id", "session_id", "last_update_time", "last_comment_time", "total_item_count", "unread_item_count", "unread_comment_count");
        StringBuilder sb = new StringBuilder("");
        sb.append("CREATE TRIGGER %s AFTER UPDATE ON %s");
        sb.append(" WHEN new.%s < 0");
        sb.append(" BEGIN");
        sb.append("  UPDATE %s SET %s=0;");
        sb.append(" END;");
        this.f4030f = String.format(sb.toString(), "trigger_update_trunk", "trunk", "total_item_count", "trunk", "total_item_count");
        this.f4028d = String.format("CREATE TABLE %s(\t%s INTEGER PRIMARY KEY AUTOINCREMENT, \t%s VARCHAR(200) NOT NULL, \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s INTEGER DEFAULT 0)", "trunk_item", "_id", "item_id", "session_id", "sender_uid", "sender_name", "sender_number", "registration_time", "last_comment_time", "total_comment_count", "unread_comment_count", "thumbnail", "down_url", "content_type", "item_type");
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
        this.f4029e = String.format(sb2.toString(), "trunk_comment", "_id", "item_id", "comment_id", "registration_time", "writer_uid", "writer_name", "writer_number", "content");
        this.f4031g = String.format("CREATE TRIGGER %s DELETE ON %s BEGIN  DELETE FROM %s WHERE %s=OLD.%s; END;", "trigger_trunk_item", "trunk", "trunk_item", "session_id", "session_id");
        this.f4032h = String.format("CREATE TRIGGER %s AFTER UPDATE ON %s WHEN new.%s < 0 BEGIN  UPDATE %s SET %s=0; END;", "trigger_update_trunk_item", "trunk_item", "total_comment_count", "trunk_item", "total_comment_count");
        StringBuilder sb3 = new StringBuilder("");
        sb3.append("CREATE TRIGGER %s DELETE ON %s");
        sb3.append(" BEGIN ");
        sb3.append("  DELETE FROM %s WHERE %s=OLD.%s; ");
        sb3.append(" END;");
        this.f4033i = String.format(sb3.toString(), "trigger_trunk_comment", "trunk_item", "trunk_comment", "item_id", "item_id");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(this.f4027c);
        sQLiteDatabase.execSQL(this.f4028d);
        sQLiteDatabase.execSQL(this.f4029e);
        sQLiteDatabase.execSQL(this.f4031g);
        sQLiteDatabase.execSQL(this.f4033i);
        sQLiteDatabase.execSQL(this.f4030f);
        sQLiteDatabase.execSQL(this.f4032h);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        int i3;
        C1341p.m4660c("Upgrade database from : " + i + " to : " + i2, f4025a);
        if (i == 1) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS trunk_comment");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS trunk_item");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS trunk");
            sQLiteDatabase.execSQL(this.f4027c);
            sQLiteDatabase.execSQL(this.f4028d);
            sQLiteDatabase.execSQL(this.f4029e);
            i3 = i + 1;
        } else {
            i3 = i;
        }
        if (i3 == 2) {
            sQLiteDatabase.execSQL(this.f4031g);
            sQLiteDatabase.execSQL(this.f4033i);
            i3++;
        }
        if (i3 == 3) {
            sQLiteDatabase.execSQL(this.f4030f);
            sQLiteDatabase.execSQL(this.f4032h);
            int i4 = i3 + 1;
        }
    }
}
