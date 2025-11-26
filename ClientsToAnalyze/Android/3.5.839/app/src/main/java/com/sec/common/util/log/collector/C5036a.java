package com.sec.common.util.log.collector;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.common.C4996f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5052r;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.common.util.log.collector.a */
/* loaded from: classes.dex */
class C5036a extends SQLiteOpenHelper {

    /* renamed from: b */
    private static C5036a f18354b;

    /* renamed from: a */
    private static String f18353a = "LogMessageDatabaseHelper";

    /* renamed from: c */
    private static SQLiteDatabase f18355c = m19120a().getWritableDatabase();

    /* renamed from: d */
    private static boolean f18356d = false;

    /* renamed from: a */
    public static synchronized C5036a m19120a() {
        if (f18354b == null) {
            f18354b = new C5036a(CommonApplication.m18732r());
        }
        return f18354b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    private C5036a(Context context) {
        super(context, "logData.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws Throwable {
        String strM19199a = C5052r.m19199a("CREATE TABLE ", "logMessage", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "category", " TEXT NOT NULL DEFAULT '',", "date", " TEXT NOT NULL DEFAULT '',", "pageId", " TEXT NOT NULL DEFAULT '',", "eventId", " TEXT NOT NULL DEFAULT '',", "metaInfo", " TEXT NOT NULL DEFAULT '',", VKApiConst.COUNT, " INTEGER NOT NULL DEFAULT 1,", " UNIQUE(", "pageId", ",", "eventId", ")", ")");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS logMessage");
        sQLiteDatabase.execSQL(strM19199a);
        String strM19199a2 = C5052r.m19199a("CREATE TABLE ", "logMessage_instant", " (", "_id", " INTEGER PRIMARY KEY AUTOINCREMENT,", "category", " TEXT NOT NULL DEFAULT '',", "date", " TEXT NOT NULL DEFAULT '',", "pageId", " TEXT NOT NULL DEFAULT '',", "eventId", " TEXT NOT NULL DEFAULT '',", "metaInfo", " TEXT NOT NULL DEFAULT '')");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS logMessage_instant");
        sQLiteDatabase.execSQL(strM19199a2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.beginTransaction();
        sQLiteDatabase.endTransaction();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        synchronized (C5036a.class) {
            synchronized (this) {
                f18354b = null;
                super.close();
            }
        }
    }

    /* renamed from: a */
    public static Cursor m19119a(int i) {
        if (f18355c == null || !f18355c.isOpen()) {
            return null;
        }
        if (i == 0) {
            return f18355c.query("logMessage", null, null, null, null, null, "_id", null);
        }
        return f18355c.query("logMessage", null, null, null, null, null, "_id", Integer.toString(i));
    }

    /* renamed from: b */
    public static Cursor m19124b(int i) {
        if (f18355c == null || !f18355c.isOpen()) {
            return null;
        }
        if (i == 0) {
            return f18355c.query("logMessage_instant", null, null, null, null, null, "_id", null);
        }
        return f18355c.query("logMessage_instant", null, null, null, null, null, "_id", Integer.toString(i));
    }

    /* renamed from: a */
    public static void m19123a(String str) throws Throwable {
        String strM19199a = C5052r.m19199a("DELETE FROM ", "logMessage_instant", " WHERE _id = " + str);
        if (C4996f.f18229a.f18172d) {
            C4996f.f18229a.m18893g(f18353a, "deleteInstantLogMessage sql : " + strM19199a);
        }
        f18355c.execSQL(strM19199a);
    }

    /* renamed from: b */
    public static void m19127b(String str) throws Throwable {
        String strM19199a = C5052r.m19199a("DELETE FROM ", "logMessage", " WHERE _id = " + str);
        if (C4996f.f18229a.f18172d) {
            C4996f.f18229a.m18893g(f18353a, "deleteLogMessages sql : " + strM19199a);
        }
        f18355c.execSQL(strM19199a);
    }

    /* renamed from: a */
    public static void m19121a(C5037b c5037b) throws SQLException {
        long jM19133a = c5037b.m19133a();
        String strM19136b = c5037b.m19136b();
        String strM19138c = c5037b.m19138c();
        String strM19140d = c5037b.m19140d();
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(strM19140d)) {
            sb.append("").append("¶").append(C5038c.m19162k()).append("¶").append(C5038c.m19160i());
        }
        new ArrayList();
        JSONObject jSONObjectM19142e = c5037b.m19142e();
        if (C4996f.f18229a.f18172d) {
            C4996f.f18229a.m18893g("saveInstantLogMessage start LogCollectorSender", f18353a);
        }
        try {
            if ("0101".equals(strM19138c) || "0103".equals(strM19138c)) {
                sb.append("¶").append("").append("¶").append("").append("¶").append(jSONObjectM19142e.get("networkType").toString());
            } else if ("0102".equals(strM19138c) || "0104".equals(strM19138c)) {
                sb.append("¶").append("").append("¶").append("").append("¶").append(C5038c.m19163l());
            } else {
                sb.append("¶").append(C5038c.m19163l()).append("¶").append("");
            }
        } catch (JSONException e) {
            if (C4996f.f18229a.f18172d) {
                C4996f.f18229a.m18893g("saveInstantLogMessage start LogCollectorSender JSONObject " + e.toString(), f18353a);
            }
        }
        f18355c.execSQL(C5052r.m19199a("INSERT INTO ", "logMessage_instant", " (", "category", ",", "date", ",", "pageId", ",", "eventId", ",", "metaInfo", ") VALUES('", "QOS", "','", Long.valueOf(jM19133a), "','", strM19136b, "','", strM19138c, "','", sb.toString(), "');"));
    }

    /* renamed from: b */
    public static void m19126b(C5037b c5037b) throws Throwable {
        String string;
        boolean z;
        String strM19199a;
        long jM19133a = c5037b.m19133a();
        String strM19136b = c5037b.m19136b();
        String strM19138c = c5037b.m19138c();
        String strM19140d = c5037b.m19140d();
        if (TextUtils.isEmpty(strM19140d)) {
            StringBuilder sb = new StringBuilder();
            sb.append("").append("¶").append(C5038c.m19162k()).append("¶").append(C5038c.m19160i()).append("¶").append(C5038c.m19163l()).append("¶").append("");
            string = sb.toString();
        } else {
            string = strM19140d;
        }
        Cursor cursorQuery = f18355c.query("logMessage_instant", null, new String("pageId=? "), new String[]{strM19136b}, null, null, "_id", null);
        if (cursorQuery == null || cursorQuery.getCount() <= 0) {
            z = false;
        } else {
            z = true;
        }
        new ArrayList();
        c5037b.m19142e();
        if (C4996f.f18229a.f18172d) {
            C4996f.f18229a.m18893g("saveSettingValueLog start LogCollectorSender", f18353a);
        }
        if (z) {
            strM19199a = C5052r.m19199a("UPDATE ", "logMessage_instant", " SET ", "date", "='", Long.valueOf(jM19133a), "',", "eventId", "='", strM19138c, "' WHERE ", "pageId", "='", strM19136b, "'");
        } else {
            strM19199a = C5052r.m19199a("INSERT INTO ", "logMessage_instant", " (", "category", ",", "date", ",", "pageId", ",", "eventId", ",", "metaInfo", ") VALUES('", "QOS", "','", Long.valueOf(jM19133a), "','", strM19136b, "','", strM19138c, "','", string, "');");
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        f18355c.execSQL(strM19199a);
    }

    /* renamed from: c */
    public static void m19129c(C5037b c5037b) {
        String strM19140d = c5037b.m19140d();
        if (!TextUtils.isEmpty(strM19140d)) {
            Context contextM18732r = CommonApplication.m18732r();
            CommonApplication.m18732r();
            SharedPreferences sharedPreferences = contextM18732r.getSharedPreferences("common_library_prefs", 0);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (strM19140d.equals("1sectorcount")) {
                editorEdit.putInt("1sectorcount", sharedPreferences.getInt("1sectorcount", 0) + 1);
            } else if (strM19140d.equals("2sectorcount")) {
                editorEdit.putInt("2sectorcount", sharedPreferences.getInt("2sectorcount", 0) + 1);
            } else if (strM19140d.equals("3sectorcount")) {
                editorEdit.putInt("3sectorcount", sharedPreferences.getInt("3sectorcount", 0) + 1);
            } else if (strM19140d.equals("4sectorcount")) {
                editorEdit.putInt("4sectorcount", sharedPreferences.getInt("4sectorcount", 0) + 1);
            } else if (strM19140d.equals("5sectorcount")) {
                editorEdit.putInt("5sectorcount", sharedPreferences.getInt("5sectorcount", 0) + 1);
            } else if (strM19140d.equals("6sectorcount")) {
                editorEdit.putInt("6sectorcount", sharedPreferences.getInt("6sectorcount", 0) + 1);
            } else if (strM19140d.equals("transferfail")) {
                editorEdit.putInt("transferfail", sharedPreferences.getInt("transferfail", 0) + 1);
            }
            editorEdit.commit();
        }
    }

    /* renamed from: d */
    public static void m19131d(C5037b c5037b) throws SQLException {
        String string;
        long jM19133a = c5037b.m19133a();
        String strM19136b = c5037b.m19136b();
        String strM19138c = c5037b.m19138c();
        c5037b.m19140d();
        if (strM19138c == null) {
            string = "";
        } else {
            string = strM19138c.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("¶").append("").append("¶").append(C5038c.m19162k()).append("¶").append(C5038c.m19160i()).append("¶").append(C5038c.m19163l());
        f18355c.execSQL(C5052r.m19199a("INSERT OR REPLACE INTO ", "logMessage", " (", "category", ",", "date", ",", "pageId", ",", "eventId", ",", "metaInfo", ",", VKApiConst.COUNT, ") VALUES('", "QOS", "','", Long.valueOf(jM19133a), "','", strM19136b, "','", string, "','", sb.toString(), "',", "(select ", VKApiConst.COUNT, " from ", "logMessage", " where ", "pageId", "='", strM19136b, "' and ", "eventId", "='", string, "') + 1);"));
    }

    /* renamed from: a */
    public static void m19122a(C5037b c5037b, int i) throws SQLException {
        String string;
        long jM19133a = c5037b.m19133a();
        String strM19136b = c5037b.m19136b();
        String strM19138c = c5037b.m19138c();
        c5037b.m19140d();
        if (strM19138c == null) {
            string = "";
        } else {
            string = strM19138c.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("¶").append("").append("¶").append(C5038c.m19162k()).append("¶").append(C5038c.m19160i()).append("¶").append(C5038c.m19163l());
        f18355c.execSQL(C5052r.m19199a("INSERT OR REPLACE INTO ", "logMessage", " (", "category", ",", "date", ",", "pageId", ",", "eventId", ",", "metaInfo", ",", VKApiConst.COUNT, ") VALUES('", "QOS", "','", Long.valueOf(jM19133a), "','", strM19136b, "','", string, "','", sb.toString(), "',", "ifnull((select ", VKApiConst.COUNT, " from ", "logMessage", " where ", "pageId", "='", strM19136b, "' and ", "eventId", "='", string, "'), 0) + " + i + ");"));
    }

    /* renamed from: b */
    public static void m19125b() {
        m19128c();
        if (f18355c.isOpen()) {
            f18355c.delete("logMessage", null, null);
            f18355c.delete("logMessage_instant", null, null);
        }
    }

    /* renamed from: c */
    public static void m19128c() {
        Context contextM18732r = CommonApplication.m18732r();
        CommonApplication.m18732r();
        SharedPreferences.Editor editorEdit = contextM18732r.getSharedPreferences("common_library_prefs", 0).edit();
        editorEdit.putInt("1sectorcount", 0);
        editorEdit.putInt("2sectorcount", 0);
        editorEdit.putInt("3sectorcount", 0);
        editorEdit.putInt("4sectorcount", 0);
        editorEdit.putInt("5sectorcount", 0);
        editorEdit.putInt("6sectorcount", 0);
        editorEdit.putInt("transferfail", 0);
        editorEdit.commit();
    }

    /* renamed from: d */
    public static String m19130d() {
        Context contextM18732r = CommonApplication.m18732r();
        CommonApplication.m18732r();
        SharedPreferences sharedPreferences = contextM18732r.getSharedPreferences("common_library_prefs", 0);
        return C5052r.m19199a(Integer.valueOf(sharedPreferences.getInt("1sectorcount", 0)), "¶", Integer.valueOf(sharedPreferences.getInt("2sectorcount", 0)), "¶", Integer.valueOf(sharedPreferences.getInt("3sectorcount", 0)), "¶", Integer.valueOf(sharedPreferences.getInt("4sectorcount", 0)), "¶", Integer.valueOf(sharedPreferences.getInt("5sectorcount", 0)), "¶", Integer.valueOf(sharedPreferences.getInt("6sectorcount", 0)), "¶", Integer.valueOf(sharedPreferences.getInt("transferfail", 0)));
    }

    /* renamed from: e */
    public static boolean m19132e() {
        return CommonApplication.m18732r().getDatabasePath("logData.db").exists();
    }
}
