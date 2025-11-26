package com.sec.chaton.trunk.database.p122a;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;

/* compiled from: TrunkDatabaseOpenHelper.java */
/* renamed from: com.sec.chaton.trunk.database.a.b */
/* loaded from: classes.dex */
public class C4665b extends SQLiteOpenHelper {

    /* renamed from: a */
    private static final String f16891a = C4665b.class.getSimpleName();

    /* renamed from: b */
    private static C4665b f16892b;

    /* renamed from: c */
    private final String f16893c;

    /* renamed from: d */
    private final String f16894d;

    /* renamed from: e */
    private final String f16895e;

    /* renamed from: f */
    private final String f16896f;

    /* renamed from: g */
    private final String f16897g;

    /* renamed from: h */
    private final String f16898h;

    /* renamed from: i */
    private final String f16899i;

    /* renamed from: a */
    public static synchronized C4665b m17665a() {
        if (f16892b == null) {
            f16892b = new C4665b(CommonApplication.m18732r());
        }
        return f16892b;
    }

    private C4665b(Context context) {
        super(context, "trunk.db", (SQLiteDatabase.CursorFactory) null, 6);
        this.f16893c = String.format("CREATE TABLE %s(\t%s INTEGER PRIMARY KEY AUTOINCREMENT, \t%s VARCHAR(200) NOT NULL UNIQUE, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0)", "trunk", "_id", "session_id", "last_update_time", "last_comment_time", "total_item_count", "unread_item_count", "unread_comment_count");
        StringBuilder sb = new StringBuilder("");
        sb.append("CREATE TRIGGER %s AFTER UPDATE ON %s");
        sb.append(" WHEN new.%s < 0");
        sb.append(" BEGIN");
        sb.append("  UPDATE %s SET %s=0;");
        sb.append(" END;");
        this.f16896f = String.format(sb.toString(), "trigger_update_trunk", "trunk", "total_item_count", "trunk", "total_item_count");
        this.f16894d = String.format("CREATE TABLE %s(\t%s INTEGER PRIMARY KEY AUTOINCREMENT, \t%s VARCHAR(200) NOT NULL, \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s TEXT, \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s TEXT, \t%s INTEGER DEFAULT 0)", "trunk_item", "_id", "item_id", "session_id", "sender_uid", "sender_name", "sender_number", "registration_time", "last_comment_time", "total_comment_count", "unread_comment_count", "item_description", "thumbnail", "down_url", "content_type", "isams", "item_type");
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
        this.f16895e = String.format(sb2.toString(), "trunk_comment", "_id", "item_id", "comment_id", "registration_time", "writer_uid", "writer_name", "writer_number", "content");
        StringBuilder sb3 = new StringBuilder("");
        sb3.append("CREATE TRIGGER %s DELETE ON %s");
        sb3.append(" BEGIN");
        sb3.append("  DELETE FROM %s WHERE %s=OLD.%s;");
        sb3.append(" END;");
        this.f16897g = String.format(sb3.toString(), "trigger_trunk_item", "trunk", "trunk_item", "session_id", "session_id");
        this.f16898h = String.format("CREATE TRIGGER %s AFTER UPDATE ON %s WHEN new.%s < 0 BEGIN  UPDATE %s SET %s=0; END;", "trigger_update_trunk_item", "trunk_item", "total_comment_count", "trunk_item", "total_comment_count");
        StringBuilder sb4 = new StringBuilder("");
        sb4.append("CREATE TRIGGER %s DELETE ON %s");
        sb4.append(" BEGIN ");
        sb4.append("  DELETE FROM %s WHERE %s=OLD.%s; ");
        sb4.append(" END;");
        this.f16899i = String.format(sb4.toString(), "trigger_trunk_comment", "trunk_item", "trunk_comment", "item_id", "item_id");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(this.f16893c);
        sQLiteDatabase.execSQL(this.f16894d);
        sQLiteDatabase.execSQL(this.f16895e);
        sQLiteDatabase.execSQL(this.f16897g);
        sQLiteDatabase.execSQL(this.f16899i);
        sQLiteDatabase.execSQL(this.f16896f);
        sQLiteDatabase.execSQL(this.f16898h);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        int i3;
        C4904y.m18641c("Upgrade database from : " + i + " to : " + i2, f16891a);
        if (i == 1) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS trunk_comment");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS trunk_item");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS trunk");
            sQLiteDatabase.execSQL(this.f16893c);
            sQLiteDatabase.execSQL(this.f16894d);
            sQLiteDatabase.execSQL(this.f16895e);
            i3 = i + 1;
        } else {
            i3 = i;
        }
        if (i3 == 2) {
            sQLiteDatabase.execSQL(this.f16897g);
            sQLiteDatabase.execSQL(this.f16899i);
            i3++;
        }
        if (i3 == 3) {
            sQLiteDatabase.execSQL(this.f16896f);
            sQLiteDatabase.execSQL(this.f16898h);
            i3++;
        }
        if (i3 == 4) {
            sQLiteDatabase.execSQL("ALTER TABLE trunk_item ADD COLUMN item_description TEXT");
            i3++;
        }
        if (i3 == 5) {
            sQLiteDatabase.execSQL("ALTER TABLE trunk_item ADD COLUMN isams TEXT");
            int i4 = i3 + 1;
        }
    }
}
