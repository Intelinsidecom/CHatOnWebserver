package com.sec.chaton.smsplugin.spam.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/* compiled from: SpamDatabaseHelper.java */
/* renamed from: com.sec.chaton.smsplugin.spam.database.a */
/* loaded from: classes.dex */
public class C4025a extends SQLiteOpenHelper {

    /* renamed from: a */
    private static C4025a f14526a = null;

    private C4025a(Context context) {
        super(context, "spam.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    /* renamed from: a */
    static synchronized C4025a m15497a(Context context) {
        if (f14526a == null) {
            f14526a = new C4025a(context);
        }
        return f14526a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        m15498a(sQLiteDatabase);
        m15500c(sQLiteDatabase);
        m15499b(sQLiteDatabase);
        m15501d(sQLiteDatabase);
    }

    /* renamed from: a */
    private void m15498a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE spam_pdu (_id INTEGER PRIMARY KEY AUTOINCREMENT,thread_id INTEGER,date INTEGER,date_sent INTEGER DEFAULT 0,msg_box INTEGER,read INTEGER DEFAULT 0,m_id TEXT,sub TEXT,sub_cs INTEGER,ct_t TEXT,ct_l TEXT,exp INTEGER,m_cls TEXT,m_type INTEGER,v INTEGER,m_size INTEGER,pri INTEGER,rr INTEGER,rpt_a INTEGER,resp_st INTEGER,st INTEGER,tr_id TEXT,retr_st INTEGER,retr_txt TEXT,retr_txt_cs INTEGER,read_status INTEGER,ct_cls INTEGER,resp_txt TEXT,d_tm INTEGER,d_rpt INTEGER,locked INTEGER DEFAULT 0,seen INTEGER DEFAULT 0,deletable INTEGER DEFAULT 0,hidden INTEGER DEFAULT 0,app_id INTEGER DEFAULT 0,msg_id INTEGER DEFAULT 0,callback_set INTEGER DEFAULT 0);");
        sQLiteDatabase.execSQL("CREATE INDEX spam_pduIndex1 ON spam_pdu (thread_id,locked);");
        sQLiteDatabase.execSQL("CREATE TABLE spam_addr (_id INTEGER PRIMARY KEY,msg_id INTEGER,contact_id INTEGER,address TEXT,type INTEGER,charset INTEGER);");
        sQLiteDatabase.execSQL("CREATE INDEX spam_addrIndex1 ON spam_addr (msg_id);");
        sQLiteDatabase.execSQL("CREATE TABLE spam_part (_id INTEGER PRIMARY KEY,mid INTEGER,seq INTEGER DEFAULT 0,ct TEXT,name TEXT,chset INTEGER,cd TEXT,fn TEXT,cid TEXT,cl TEXT,ctt_s INTEGER,ctt_t TEXT,_data TEXT,text TEXT);");
        sQLiteDatabase.execSQL("CREATE INDEX spam_partIndex1 ON spam_part (mid);");
        sQLiteDatabase.execSQL("CREATE TABLE spam_rate (sent_time INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE spam_drm (_id INTEGER PRIMARY KEY,_data TEXT);");
    }

    /* renamed from: b */
    private void m15499b(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TRIGGER spam_part_cleanup DELETE ON spam_pdu BEGIN   DELETE FROM spam_part  WHERE mid=old._id;END;");
        sQLiteDatabase.execSQL("CREATE TRIGGER spam_addr_cleanup DELETE ON spam_pdu BEGIN   DELETE FROM spam_addr  WHERE msg_id=old._id;END;");
        sQLiteDatabase.execSQL("CREATE TRIGGER spam_cleanup_delivery_and_read_report AFTER DELETE ON spam_pdu WHEN old.m_type=128 BEGIN   DELETE FROM spam_pdu  WHERE (m_type=134    OR m_type=136)    AND m_id=old.m_id; END;");
    }

    /* renamed from: c */
    private void m15500c(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE spam_sms (_id INTEGER PRIMARY KEY AUTOINCREMENT,thread_id INTEGER,address TEXT,person INTEGER,date INTEGER,date_sent INTEGER DEFAULT 0,protocol INTEGER,read INTEGER DEFAULT 0,status INTEGER DEFAULT -1,type INTEGER,reply_path_present INTEGER,subject TEXT,body TEXT,service_center TEXT,locked INTEGER DEFAULT 0,error_code INTEGER DEFAULT 0,seen INTEGER DEFAULT 0,deletable INTEGER DEFAULT 0,hidden INTEGER DEFAULT 0,group_id INTEGER,group_type INTEGER,delivery_date INTEGER,app_id INTEGER DEFAULT 0,msg_id INTEGER DEFAULT 0,callback_number TEXT,reserved INTEGER DEFAULT 0,teleservice_id INTEGER DEFAULT 0,link_url TEXT);");
    }

    /* renamed from: d */
    private void m15501d(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE spam_filter (_id INTEGER PRIMARY KEY AUTOINCREMENT,filter_type INTEGER,enable INTEGER,filter TEXT,criteria INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Log.w("MmsSmsDatabaseHelper", "Upgrading database from version " + i + " to " + i2 + ".");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }
}
