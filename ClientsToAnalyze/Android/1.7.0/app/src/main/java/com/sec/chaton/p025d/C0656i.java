package com.sec.chaton.p025d;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sec.chaton.account.C0239h;
import com.sec.chaton.p025d.p026a.C0634n;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1341p;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.d.i */
/* loaded from: classes.dex */
public class C0656i extends SQLiteOpenHelper {

    /* renamed from: a */
    private static C0656i f2282a = null;

    /* renamed from: b */
    private Context f2283b;

    public C0656i(Context context) {
        super(context, "chaton.db", (SQLiteDatabase.CursorFactory) null, 16);
        this.f2283b = context;
    }

    /* renamed from: a */
    public static String m2983a() {
        return "chaton.db";
    }

    /* renamed from: a */
    public static synchronized C0656i m2982a(Context context) {
        if (f2282a == null) {
            f2282a = new C0656i(context);
        }
        return f2282a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(InterfaceC0663p.f2290a);
        sQLiteDatabase.execSQL("CREATE TABLE buddy_group (_id INTEGER PRIMARY KEY AUTOINCREMENT,group_name VARCHAR(80) NOT NULL,group_type INTEGER NOT NULL DEFAULT 2,UNIQUE (_id) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE grouprelation (_id INTEGER PRIMARY KEY AUTOINCREMENT,group_relation_buddy VARCHAR(25) NOT NULL REFERENCES buddy(buddy_no),group_relation_group VARCHAR(25) NOT NULL REFERENCES buddy_group(_id),UNIQUE (group_relation_group,group_relation_buddy) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE relation (_id INTEGER PRIMARY KEY AUTOINCREMENT,relation_buddy_id TEXT NOT NULL,relation_date TEXT NOT NULL,relation_send INTEGER NOT NULL DEFAULT 0,relation_received INTEGER NOT NULL DEFAULT 0,relation_point INTEGER NOT NULL DEFAULT 0,relation_icon INTEGER NOT NULL DEFAULT 0,relation_increase INTEGER NOT NULL DEFAULT 0,relation_rank INTEGER NOT NULL DEFAULT 0,UNIQUE (relation_buddy_id,relation_date) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE contacts (contacts_id NUMBER,contact_raw_id NUMBER,conatct_number TEXT NOT NULL,contacts_name TEXT,UNIQUE (contacts_id,contact_raw_id) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE inbox (_id INTEGER PRIMARY KEY AUTOINCREMENT,inbox_no TEXT,inbox_chat_type INTEGER NOT NULL,inbox_unread_count INTEGER NOT NULL DEFAULT 0,inbox_last_message TEXT,inbox_title TEXT,inbox_last_time NUMBER,inbox_lang_from TEXT,inbox_lang_to TEXT,inbox_translated TEXT NOT NULL DEFAULT 'N',inbox_server_ip TEXT,inbox_server_port NUMBER,inbox_participants TEXT,inbox_session_id TEXT,inbox_last_msg_no NUMBER,inbox_last_msg_sender TEXT,inbox_title_fixed TEXT NOT NULL DEFAULT 'N',inbox_last_chat_type NUMBER,inbox_last_temp_msg TEXT NOT NULL DEFAULT '',UNIQUE (inbox_no) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE message (_id INTEGER PRIMARY KEY,message_sever_id INTEGER,message_inbox_no TEXT,message_session_id INTEGER,message_read_status INTEGER,message_content_type INTEGER DEFAULT 0,message_time NUMBER,message_content TEXT,message_translated TEXT,message_type INTEGER,message_sender TEXT,message_download_uri TEXT,message_formatted TEXT,message_tid TEXT,message_time_text TEXT,message_stored_ext INTEGER DEFAULT 1,message_need_update TEXT NOT NULL DEFAULT 'Y',message_is_failed INTEGER DEFAULT 0,UNIQUE (_id) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE participant (participants_buddy_no TEXT NOT NULL,participants_inbox_no TEXT NOT NULL,participants_buddy_name TEXT,UNIQUE (participants_buddy_no,participants_inbox_no) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE INDEX msg_server_no_index ON message (message_sever_id,message_inbox_no,message_sender);");
        m2984a(sQLiteDatabase);
        m2985a(sQLiteDatabase, 1, true);
    }

    /* renamed from: a */
    private void m2984a(SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_name", "Favorites");
        contentValues.put("group_type", (Integer) 1);
        sQLiteDatabase.insert("buddy_group", null, contentValues);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        f2282a = null;
        super.close();
    }

    /* renamed from: a */
    private void m2985a(SQLiteDatabase sQLiteDatabase, int i, boolean z) {
        sQLiteDatabase.beginTransaction();
        if (i < 2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_is_profile_updated CHAR(1) NOT NULL DEFAULT 'N'");
                sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_is_status_updated CHAR(1) NOT NULL DEFAULT 'N'");
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
        if (i < 3) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_is_new CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 4) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS memo");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS memo_sessions");
            sQLiteDatabase.execSQL("CREATE TABLE memo (_id INTEGER PRIMARY KEY AUTOINCREMENT,buddy_no VARCHAR(25),buddy_name VARCHAR(80),memo VARCHAR(255),timestamp VARCHAR(80), UNIQUE (timestamp))");
            sQLiteDatabase.execSQL("CREATE TABLE memo_sessions (_id INTEGER PRIMARY KEY AUTOINCREMENT,buddy_no VARCHAR(25),buddy_name VARCHAR(80),starttime VARCHAR(80),endtime VARCHAR(80),isblind VARCHAR(80), UNIQUE (buddy_no))");
        }
        if (i < 5) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_trunk_unread_count INTEGER NOT NULL DEFAULT '0'");
        }
        if (i < 6) {
            sQLiteDatabase.execSQL("ALTER TABLE relation ADD COLUMN relation_last_msg_time TEXT");
        }
        if (i < 7) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_show_phone_number INTEGER DEFAULT '0'");
        }
        if (i < 8) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_valid CHAR(1) NOT NULL DEFAULT 'Y'");
            C0634n.m2907a(sQLiteDatabase);
        }
        if (i < 9) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy_group ADD COLUMN group_is_new CHAR(1) NOT NULL DEFAULT 'Y'");
            sQLiteDatabase.execSQL("UPDATE buddy_group SET group_is_new = 'N'");
        }
        if (i < 10) {
            C0239h.m904a();
        }
        if (i < 11) {
            C0635o.m2936a(sQLiteDatabase);
        }
        if (i < 12) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_extra_info VARCHAR(80)");
        }
        if (i < 13) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_enable_noti CHAR(1) NOT NULL DEFAULT 'Y'");
        }
        if (i < 14) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox_buddy_relation ADD COLUMN chat_type INTEGER NOT NULL DEFAULT '" + String.valueOf(EnumC0665r.UNKNOWN.m3012a()) + "'");
            sQLiteDatabase.execSQL("UPDATE inbox_buddy_relation SET chat_type = '" + String.valueOf(EnumC0665r.ONETOONE.m3012a()) + "'");
            String strM2986b = m2986b();
            if (strM2986b != null) {
                C1323bs.m4579a("country_name", strM2986b);
            }
        }
        if (i < 15) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_last_timestamp NUMBER");
        }
        if (i < 16) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS recommendee");
            sQLiteDatabase.execSQL("CREATE TABLE recommendee (_id INTEGER PRIMARY KEY AUTOINCREMENT,buddy_no VARCHAR(25) NOT NULL,buddy_name VARCHAR(80) NOT NULL,type INTEGER DEFAULT 200,ignore INTEGER DEFAULT 0, UNIQUE (buddy_no))");
        }
        sQLiteDatabase.setTransactionSuccessful();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (C1341p.f4578b) {
            C1341p.m4658b("Upgrading from : " + i + " to : " + i2, getClass().getSimpleName());
        }
        m2985a(sQLiteDatabase, i, false);
    }

    /* renamed from: b */
    private String m2986b() {
        String string = C1323bs.m4575a().getString("country_name", null);
        if (string == null) {
            return null;
        }
        if (string.equals("Aland Islands")) {
            return "Åland Islands";
        }
        if (string.equals("Argentina")) {
            return "Argentine Republic";
        }
        if (string.equals("Azerbaijan")) {
            return "Republic of Azerbaijan";
        }
        if (string.equals("Congo")) {
            return "Republic of the Congo";
        }
        if (string.equals("Cote d'Ivoire")) {
            return "Côte d'Ivoire";
        }
        if (string.equals("Gabon")) {
            return "Gabonese Republic";
        }
        if (string.equals("Guinea-bissau")) {
            return "Guinea-Bissau";
        }
        if (string.equals("Kyrgyzstan")) {
            return "Kyrgyz Republic";
        }
        if (string.equals("Macedonia")) {
            return "Republic of Macedonia";
        }
        if (string.equals("Reunion")) {
            return "Réunion";
        }
        if (string.equals("Rwanda")) {
            return "Republic of Rwanda";
        }
        if (string.equals("Sao Tome and Principe")) {
            return "São Tomé and Príncipe";
        }
        if (string.equals("Svalbard and Jan Mayen Islands")) {
            return "Svalbard and Jan Mayen";
        }
        if (string.equals("Togo")) {
            return "Togolese Republic";
        }
        if (string.equals("United States")) {
            return "United States of America";
        }
        if (string.equals("US Virgin Islands")) {
            return "United States Virgin Islands";
        }
        return null;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }
}
