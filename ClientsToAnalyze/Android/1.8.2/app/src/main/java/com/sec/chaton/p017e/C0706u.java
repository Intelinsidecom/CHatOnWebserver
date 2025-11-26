package com.sec.chaton.p017e;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sec.chaton.account.C0210g;
import com.sec.chaton.multimedia.skin.C1003c;
import com.sec.chaton.multimedia.skin.entry.inner.Skin;
import com.sec.chaton.p017e.p018a.C0660d;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.util.C1786r;
import com.sec.common.p056b.p060d.C1828c;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.u */
/* loaded from: classes.dex */
public class C0706u extends SQLiteOpenHelper {

    /* renamed from: a */
    private static C0706u f2656a = null;

    /* renamed from: b */
    private Context f2657b;

    public C0706u(Context context) {
        super(context, "chaton.db", (SQLiteDatabase.CursorFactory) null, 24);
        this.f2657b = context;
    }

    /* renamed from: a */
    public static String m3173a() {
        return "chaton.db";
    }

    /* renamed from: a */
    public static synchronized C0706u m3172a(Context context) {
        if (f2656a == null) {
            f2656a = new C0706u(context);
        }
        return f2656a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(InterfaceC0709x.f2661a);
        sQLiteDatabase.execSQL("CREATE TABLE buddy_group (_id INTEGER PRIMARY KEY AUTOINCREMENT,group_name VARCHAR(80) NOT NULL,group_type INTEGER NOT NULL DEFAULT 2,UNIQUE (_id) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE grouprelation (_id INTEGER PRIMARY KEY AUTOINCREMENT,group_relation_buddy VARCHAR(25) NOT NULL REFERENCES buddy(buddy_no),group_relation_group VARCHAR(25) NOT NULL REFERENCES buddy_group(_id),UNIQUE (group_relation_group,group_relation_buddy) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE relation (_id INTEGER PRIMARY KEY AUTOINCREMENT,relation_buddy_id TEXT NOT NULL,relation_date TEXT NOT NULL,relation_send INTEGER NOT NULL DEFAULT 0,relation_received INTEGER NOT NULL DEFAULT 0,relation_point INTEGER NOT NULL DEFAULT 0,relation_icon INTEGER NOT NULL DEFAULT 0,relation_increase INTEGER NOT NULL DEFAULT 0,relation_rank INTEGER NOT NULL DEFAULT 0,UNIQUE (relation_buddy_id,relation_date) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE contacts (contacts_id NUMBER,contact_raw_id NUMBER,conatct_number TEXT NOT NULL,contacts_name TEXT,UNIQUE (contacts_id,contact_raw_id) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE inbox (_id INTEGER PRIMARY KEY AUTOINCREMENT,inbox_no TEXT,inbox_chat_type INTEGER NOT NULL,inbox_unread_count INTEGER NOT NULL DEFAULT 0,inbox_last_message TEXT,inbox_title TEXT,inbox_last_time NUMBER,inbox_lang_from TEXT,inbox_lang_to TEXT,inbox_translated TEXT NOT NULL DEFAULT 'N',inbox_server_ip TEXT,inbox_server_port NUMBER,inbox_participants TEXT,inbox_session_id TEXT,inbox_last_msg_no NUMBER,inbox_last_msg_sender TEXT,inbox_title_fixed TEXT NOT NULL DEFAULT 'N',inbox_last_chat_type NUMBER,inbox_last_temp_msg TEXT NOT NULL DEFAULT '',UNIQUE (inbox_no) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE message (_id INTEGER PRIMARY KEY,message_sever_id INTEGER,message_inbox_no TEXT,message_session_id INTEGER,message_read_status INTEGER,message_content_type INTEGER DEFAULT 0,message_time NUMBER,message_content TEXT,message_translated TEXT,message_type INTEGER,message_sender TEXT,message_download_uri TEXT,message_formatted TEXT,message_tid TEXT,message_time_text TEXT,message_stored_ext INTEGER DEFAULT 1,message_need_update TEXT NOT NULL DEFAULT 'Y',message_is_failed INTEGER DEFAULT 0,UNIQUE (_id) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE participant (participants_buddy_no TEXT NOT NULL,participants_inbox_no TEXT NOT NULL,participants_buddy_name TEXT,UNIQUE (participants_buddy_no,participants_inbox_no) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE INDEX msg_server_no_index ON message (message_sever_id,message_inbox_no,message_sender);");
        m3174a(sQLiteDatabase);
        m3175a(sQLiteDatabase, 1, true);
    }

    /* renamed from: a */
    private void m3174a(SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_name", "Favorites");
        contentValues.put("group_type", (Integer) 1);
        sQLiteDatabase.insert("buddy_group", null, contentValues);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        f2656a = null;
        super.close();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (C1786r.f6452b) {
            C1786r.m6061b("Upgrading from : " + i + " to : " + i2, getClass().getSimpleName());
        }
        m3175a(sQLiteDatabase, i, false);
    }

    /* renamed from: a */
    private void m3175a(SQLiteDatabase sQLiteDatabase, int i, boolean z) {
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
            C0660d.m3022a(sQLiteDatabase);
        }
        if (i < 9) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy_group ADD COLUMN group_is_new CHAR(1) NOT NULL DEFAULT 'Y'");
            sQLiteDatabase.execSQL("UPDATE buddy_group SET group_is_new = 'N'");
        }
        if (i < 10) {
            C0210g.m1813b();
        }
        if (i < 11) {
            C0665i.m3069b(sQLiteDatabase);
        }
        if (i < 12) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_extra_info VARCHAR(80)");
        }
        if (i < 13) {
            sQLiteDatabase.execSQL("CREATE TABLE anicon_category (_id INTEGER PRIMARY KEY AUTOINCREMENT,category_id VARCHAR(255) NOT NULL,name VARCHAR(255) NOT NULL,thumbnail_url TEXT NOT NULL, UNIQUE (category_id))");
            sQLiteDatabase.execSQL("CREATE TABLE anicon_package (_id INTEGER PRIMARY KEY AUTOINCREMENT,package_id VARCHAR(255) NOT NULL,category_id VARCHAR(255) NOT NULL,name VARCHAR(255) NOT NULL,preview_url TEXT NOT NULL,thumbnail_url TEXT NOT NULL,package_zip_url TEXT,anicon_count INTEGER NOT NULL DEFAULT(0),volume INTEGER NOT NULL DEFAULT(0),install INTEGER NOT NULL DEFAULT(0),expiration_time INTEGER NOT NULL DEFAULT(0), UNIQUE (package_id))");
            sQLiteDatabase.execSQL("CREATE TABLE anicon_item (_id INTEGER PRIMARY KEY AUTOINCREMENT,anicon_id VARCHAR(255) NOT NULL,package_id VARCHAR(255),delegate_url TEXT,cd_proxy_url TEXT,zip_url TEXT,sent_time TEXT, UNIQUE (anicon_id))");
        }
        if (i < 14) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS recommendee");
            sQLiteDatabase.execSQL("CREATE TABLE recommendee (_id INTEGER PRIMARY KEY AUTOINCREMENT,buddy_no VARCHAR(25) NOT NULL,buddy_name VARCHAR(80) NOT NULL,type INTEGER DEFAULT 200,ignore INTEGER DEFAULT 0, UNIQUE (buddy_no))");
        }
        if (i < 15) {
            sQLiteDatabase.execSQL(C1828c.m6207a("ALTER TABLE ", "anicon_package", " ADD COLUMN ", "special", " INTEGER NOT NULL DEFAULT(0)"));
        }
        if (i < 16) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_enable_noti CHAR(1) NOT NULL DEFAULT 'Y'");
        }
        if (i < 17) {
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN description TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN followcount VARCHAR(80)");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN likecount VARCHAR(80)");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN msgstatus VARCHAR(256)");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN photoloaded VARCHAR(25)");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN status TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN url VARCHAR(80)");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS specialbuddy");
            sQLiteDatabase.execSQL("CREATE TABLE specialbuddy (_id INTEGER PRIMARY KEY AUTOINCREMENT,buddy_no VARCHAR(25) NOT NULL,buddy_name VARCHAR(80) NOT NULL,description TEXT,followcount VARCHAR(80),likecount VARCHAR(80),msgstatus VARCHAR(256),photoloaded VARCHAR(25),status VARCHAR(25),url VARCHAR(80), UNIQUE (buddy_no))");
        }
        if (i < 18) {
            sQLiteDatabase.execSQL("ALTER TABLE anicon_category RENAME TO anicon_category_temp");
            sQLiteDatabase.execSQL("CREATE TABLE anicon_category (_id INTEGER PRIMARY KEY AUTOINCREMENT,category_id INTEGER NOT NULL,name VARCHAR(255) NOT NULL,thumbnail_url TEXT NOT NULL, UNIQUE (category_id))");
            sQLiteDatabase.execSQL("INSERT INTO anicon_category SELECT * FROM anicon_category_temp");
            sQLiteDatabase.execSQL("DROP TABLE anicon_category_temp");
            sQLiteDatabase.execSQL("ALTER TABLE anicon_package RENAME TO anicon_package_temp");
            sQLiteDatabase.execSQL("CREATE TABLE anicon_package (_id INTEGER PRIMARY KEY AUTOINCREMENT,package_id INTEGER NOT NULL,category_id INTEGER NOT NULL,name VARCHAR(255) NOT NULL,preview_url TEXT NOT NULL,thumbnail_url TEXT NOT NULL,package_zip_url TEXT,anicon_count INTEGER NOT NULL DEFAULT(0),volume INTEGER NOT NULL DEFAULT(0),install INTEGER NOT NULL DEFAULT(0),expiration_time INTEGER NOT NULL DEFAULT(0),special INTEGER NOT NULL DEFAULT(0), UNIQUE (package_id))");
            sQLiteDatabase.execSQL("INSERT INTO anicon_package SELECT * FROM anicon_package_temp");
            sQLiteDatabase.execSQL("DROP TABLE anicon_package_temp");
            sQLiteDatabase.execSQL("ALTER TABLE anicon_item RENAME TO anicon_item_temp");
            sQLiteDatabase.execSQL("CREATE TABLE anicon_item (_id INTEGER PRIMARY KEY AUTOINCREMENT,anicon_id INTEGER NOT NULL,package_id INTEGER,delegate_url TEXT,cd_proxy_url TEXT,zip_url TEXT,sent_time TEXT, UNIQUE (anicon_id))");
            sQLiteDatabase.execSQL("INSERT INTO anicon_item SELECT * FROM anicon_item_temp");
            sQLiteDatabase.execSQL("DROP TABLE anicon_item_temp");
        }
        if (i < 19) {
            sQLiteDatabase.execSQL(C1828c.m6207a("ALTER TABLE ", "anicon_package", " ADD COLUMN ", "new", " INTEGER NOT NULL DEFAULT(0)"));
        }
        if (i < 20) {
            sQLiteDatabase.execSQL("ALTER TABLE specialbuddy ADD COLUMN weburl VARCHAR(80)");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_web_url TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_last_timestamp NUMBER");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN weburl VARCHAR(80)");
            sQLiteDatabase.execSQL("ALTER TABLE specialbuddy ADD COLUMN isNew CHAR(1) DEFAULT 'Y'");
            try {
                sQLiteDatabase.execSQL("ALTER TABLE specialbuddy ADD COLUMN islike CHAR(1) NOT NULL DEFAULT 'N'");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (i < 22) {
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_is_truncated CHAR(1) NOT NULL DEFAULT 'N'");
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_is_file_upload INTEGER NOT NULL DEFAULT(" + String.valueOf(0) + ")");
            C0665i.m3059a(sQLiteDatabase);
            sQLiteDatabase.execSQL("DROP INDEX IF EXISTS msg_server_no_index");
            sQLiteDatabase.execSQL("CREATE INDEX msg_inbox_no_index_1 ON message (message_inbox_no,message_is_truncated);");
            sQLiteDatabase.execSQL("CREATE INDEX msg_inbox_no_index_2 ON message (message_inbox_no,message_content_type);");
        }
        if (i < 23) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_is_name_updated CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 24) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS theme");
            sQLiteDatabase.execSQL("CREATE TABLE skin (_id INTEGER PRIMARY KEY AUTOINCREMENT,skin_id INTEGER NOT NULL,special INTEGER NOT NULL DEFAULT(0),thumbnail_url TEXT,bg_type VARCHAR(255) NOT NULL,expiration_date INTEGER NOT NULL,install INTEGER NOT NULL DEFAULT(0),new INTEGER NOT NULL DEFAULT(0), UNIQUE (skin_id))");
            for (Skin skin : C1003c.m3943b(this.f2657b)) {
                sQLiteDatabase.execSQL(C1828c.m6207a("INSERT INTO ", "skin", "(", "skin_id", ",", "special", ",", "thumbnail_url", ",", "bg_type", ",", "expiration_date", ",", "install", ",", "new", ") VALUES (", "'", skin.f3707id, "',", Integer.valueOf(skin.special), ",", "'", skin.thumbnailurl, "',", "'", skin.bgtype, "',", Long.valueOf(skin.expirationdate), ",", "1,", "0", ")"));
            }
        }
        sQLiteDatabase.setTransactionSuccessful();
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
