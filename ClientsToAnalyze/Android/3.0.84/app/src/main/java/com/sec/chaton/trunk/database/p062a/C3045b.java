package com.sec.chaton.trunk.database.p062a;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;

/* compiled from: TrunkDatabaseOpenHelper.java */
/* renamed from: com.sec.chaton.trunk.database.a.b */
/* loaded from: classes.dex */
public class C3045b extends SQLiteOpenHelper {

    /* renamed from: a */
    private static final String f10942a = C3045b.class.getSimpleName();

    /* renamed from: b */
    private static C3045b f10943b;

    /* renamed from: c */
    private final String f10944c;

    /* renamed from: d */
    private final String f10945d;

    /* renamed from: e */
    private final String f10946e;

    /* renamed from: f */
    private final String f10947f;

    /* renamed from: g */
    private final String f10948g;

    /* renamed from: h */
    private final String f10949h;

    /* renamed from: i */
    private final String f10950i;

    /* renamed from: a */
    public static synchronized C3045b m10571a() {
        if (f10943b == null) {
            f10943b = new C3045b(CommonApplication.m11493l());
        }
        return f10943b;
    }

    private C3045b(Context context) {
        super(context, "trunk.db", (SQLiteDatabase.CursorFactory) null, 6);
        this.f10944c = String.format("CREATE TABLE %s(\t%s INTEGER PRIMARY KEY AUTOINCREMENT, \t%s VARCHAR(200) NOT NULL UNIQUE, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0)", "trunk", "_id", "session_id", "last_update_time", "last_comment_time", "total_item_count", "unread_item_count", "unread_comment_count");
        StringBuilder sb = new StringBuilder("");
        sb.append("CREATE TRIGGER %s AFTER UPDATE ON %s");
        sb.append(" WHEN new.%s < 0");
        sb.append(" BEGIN");
        sb.append("  UPDATE %s SET %s=0;");
        sb.append(" END;");
        this.f10947f = String.format(sb.toString(), "trigger_update_trunk", "trunk", "total_item_count", "trunk", "total_item_count");
        this.f10945d = String.format("CREATE TABLE %s(\t%s INTEGER PRIMARY KEY AUTOINCREMENT, \t%s VARCHAR(200) NOT NULL, \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s INTEGER DEFAULT 0, \t%s TEXT, \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s VARCHAR(200), \t%s TEXT, \t%s INTEGER DEFAULT 0)", "trunk_item", "_id", "item_id", "session_id", "sender_uid", "sender_name", "sender_number", "registration_time", "last_comment_time", "total_comment_count", "unread_comment_count", "item_description", "thumbnail", "down_url", "content_type", "isams", "item_type");
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
        this.f10946e = String.format(sb2.toString(), "trunk_comment", "_id", "item_id", "comment_id", "registration_time", "writer_uid", "writer_name", "writer_number", "content");
        StringBuilder sb3 = new StringBuilder("");
        sb3.append("CREATE TRIGGER %s DELETE ON %s");
        sb3.append(" BEGIN");
        sb3.append("  DELETE FROM %s WHERE %s=OLD.%s;");
        sb3.append(" END;");
        this.f10948g = String.format(sb3.toString(), "trigger_trunk_item", "trunk", "trunk_item", "session_id", "session_id");
        this.f10949h = String.format("CREATE TRIGGER %s AFTER UPDATE ON %s WHEN new.%s < 0 BEGIN  UPDATE %s SET %s=0; END;", "trigger_update_trunk_item", "trunk_item", "total_comment_count", "trunk_item", "total_comment_count");
        StringBuilder sb4 = new StringBuilder("");
        sb4.append("CREATE TRIGGER %s DELETE ON %s");
        sb4.append(" BEGIN ");
        sb4.append("  DELETE FROM %s WHERE %s=OLD.%s; ");
        sb4.append(" END;");
        this.f10950i = String.format(sb4.toString(), "trigger_trunk_comment", "trunk_item", "trunk_comment", "item_id", "item_id");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(this.f10944c);
        sQLiteDatabase.execSQL(this.f10945d);
        sQLiteDatabase.execSQL(this.f10946e);
        sQLiteDatabase.execSQL(this.f10948g);
        sQLiteDatabase.execSQL(this.f10950i);
        sQLiteDatabase.execSQL(this.f10947f);
        sQLiteDatabase.execSQL(this.f10949h);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        int i3;
        C3250y.m11453c("Upgrade database from : " + i + " to : " + i2, f10942a);
        if (i == 1) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS trunk_comment");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS trunk_item");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS trunk");
            sQLiteDatabase.execSQL(this.f10944c);
            sQLiteDatabase.execSQL(this.f10945d);
            sQLiteDatabase.execSQL(this.f10946e);
            i3 = i + 1;
        } else {
            i3 = i;
        }
        if (i3 == 2) {
            sQLiteDatabase.execSQL(this.f10948g);
            sQLiteDatabase.execSQL(this.f10950i);
            i3++;
        }
        if (i3 == 3) {
            sQLiteDatabase.execSQL(this.f10947f);
            sQLiteDatabase.execSQL(this.f10949h);
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
