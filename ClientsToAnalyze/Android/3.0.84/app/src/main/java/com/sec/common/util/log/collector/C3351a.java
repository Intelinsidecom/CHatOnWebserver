package com.sec.common.util.log.collector;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sec.common.C3330f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import org.json.JSONObject;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.common.util.log.collector.a */
/* loaded from: classes.dex */
class C3351a extends SQLiteOpenHelper {

    /* renamed from: b */
    private static C3351a f12092b;

    /* renamed from: a */
    private static String f12091a = "LogMessageDatabaseHelper";

    /* renamed from: c */
    private static SQLiteDatabase f12093c = m11818a().getWritableDatabase();

    /* renamed from: a */
    public static synchronized C3351a m11818a() {
        if (f12092b == null) {
            f12092b = new C3351a(CommonApplication.m11493l());
        }
        return f12092b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    private C3351a(Context context) {
        super(context, "log.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(C3364o.m11849a("CREATE TABLE ", "log_message", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "category", " TEXT NOT NULL DEFAULT '',", "date", " TEXT NOT NULL DEFAULT '',", "page_id", " TEXT NOT NULL DEFAULT '',", "action_id", " TEXT NOT NULL DEFAULT '',", "meta_info", " TEXT NOT NULL DEFAULT '',", "count", " INTEGER NOT NULL DEFAULT 1,", "UNIQUE(", "date", ",", "page_id", ",", "action_id", ",", "meta_info", ")", ")"));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        synchronized (C3351a.class) {
            synchronized (this) {
                f12092b = null;
                super.close();
            }
        }
    }

    /* renamed from: a */
    public static Cursor m11817a(int i) {
        if (i == 0) {
            return f12093c.query("log_message", null, null, null, null, null, "_id", null);
        }
        return f12093c.query("log_message", null, null, null, null, null, "_id", Integer.toString(i));
    }

    /* renamed from: a */
    public static void m11820a(String str) throws Throwable {
        String strM11849a = C3364o.m11849a("DELETE FROM ", "log_message", " WHERE _id = " + str);
        if (C3330f.f12033a.f11973c) {
            C3330f.f12033a.m11654b(f12091a, "deleteLogMessages sql : " + strM11849a);
        }
        f12093c.execSQL(strM11849a);
    }

    /* renamed from: a */
    public static void m11819a(C3352b c3352b) throws SQLException {
        Object obj;
        String string;
        String string2;
        String strM11822a = c3352b.m11822a();
        String strM11824b = c3352b.m11824b();
        String strM11826c = c3352b.m11826c();
        JSONObject jSONObjectM11828d = c3352b.m11828d();
        if (strM11824b.startsWith("0100")) {
            obj = "QOS";
        } else {
            obj = "BIZ";
        }
        if (strM11826c == null) {
            string = "";
        } else {
            string = strM11826c.toString();
        }
        if (jSONObjectM11828d == null) {
            string2 = "";
        } else {
            string2 = jSONObjectM11828d.toString();
        }
        f12093c.execSQL(C3364o.m11849a("INSERT OR REPLACE INTO ", "log_message", " (", "category", ",", "date", ",", "page_id", ",", "action_id", ",", "meta_info", ",", "count", ") VALUES('", obj, "','", strM11822a, "','", strM11824b, "','", string, "','", string2, "',", "(select ", "count", " from ", "log_message", " where ", "date", "='", strM11822a, "' and ", "page_id", "='", strM11824b, "' and ", "action_id", "='", string, "' and ", "meta_info", "='", string2, "') + 1);"));
    }

    /* renamed from: b */
    public static int m11821b() {
        return f12093c.delete("log_message", null, null);
    }
}
