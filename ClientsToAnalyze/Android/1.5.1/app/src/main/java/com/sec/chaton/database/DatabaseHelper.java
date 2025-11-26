package com.sec.chaton.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.p000io.entry.inner.Buddy;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class DatabaseHelper extends SQLiteOpenHelper {

    /* renamed from: a */
    private static DatabaseHelper f1743a = null;

    /* renamed from: b */
    private Context f1744b;

    public interface Buddy_Query {

        /* renamed from: a */
        public static final String f1745a = "(SELECT a.*,CASE WHEN b.relation_send IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_send END AS relation_send,CASE WHEN b.relation_received IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_received END AS relation_received,CASE WHEN b.relation_point IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_point END AS relation_point,CASE WHEN b.relation_icon IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_icon END AS relation_icon,CASE WHEN b.relation_increase IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_increase END AS relation_increase,CASE WHEN b.relation_rank IS NULL THEN 9999999 WHEN a.buddy_relation_hide = 'Y' THEN 9999999 ELSE b.relation_rank END AS relation_rank FROM (SELECT d.group_relation_group,d.group_name,i.cnt,i.group_type,d.buddy_no,d.buddy_name,d.buddy_status_message,d.buddy_email,d.buddy_samsung_email,d.buddy_orginal_number,d.buddy_msg_send,d.buddy_msg_received,d.buddy_relation_hide,d.buddy_birthday,d.buddy_raw_contact_id,d.buddy_push_name,d.buddy_is_new,d.buddy_profile_status,d.buddy_is_profile_updated,d.buddy_is_status_updated FROM (SELECT ifnull(b.group_relation_group,9999) AS group_relation_group,ifnull(c.group_name,'Not assigned') AS group_name,a.buddy_no,a.buddy_name,a.buddy_status_message,a.buddy_email,a.buddy_samsung_email,a.buddy_orginal_number,a.buddy_msg_send,a.buddy_msg_received,a.buddy_relation_hide,a.buddy_birthday,a.buddy_raw_contact_id,a.buddy_push_name,a.buddy_is_new,a.buddy_profile_status,a.buddy_is_profile_updated,a.buddy_is_status_updated FROM buddy a LEFT OUTER JOIN grouprelation b ON a.buddy_no = b.group_relation_buddy LEFT OUTER JOIN buddy_group c ON b.group_relation_group = c._id UNION ALL SELECT 9999 AS group_relation_group,'Not assigned' AS group_name,buddy_no,buddy_name,buddy_status_message,buddy_email,buddy_samsung_email,buddy_orginal_number,buddy_msg_send,buddy_msg_received,buddy_relation_hide,buddy_birthday,buddy_raw_contact_id,buddy_push_name,buddy_is_new,buddy_profile_status,buddy_is_profile_updated,buddy_is_status_updated FROM buddy WHERE buddy_no IN (SELECT group_relation_buddy FROM grouprelation WHERE group_relation_group = 1) AND buddy_no NOT IN (SELECT group_relation_buddy FROM grouprelation WHERE group_relation_group != 1) UNION ALL SELECT _id,group_name,'' AS buddy_no,'' AS buddy_name,'' AS buddy_status_message,'' AS buddy_email,'' AS buddy_samsung_email,'' AS buddy_orginal_number,0 AS buddy_msg_send,0 AS buddy_msg_received,'N' AS buddy_relation_hide,'' AS buddy_birthday,0 AS buddy_raw_contact_id,'' AS buddy_push_name,'Y' AS buddy_is_new," + Buddy.BuddyImageStatus.NOT_CHANGE.getCode() + " AS buddy_profile_status,'N' AS buddy_is_profile_updated,'N' AS buddy_is_status_updated FROM buddy_group WHERE _id NOT IN (SELECT DISTINCT group_relation_group FROM grouprelation)) d LEFT OUTER JOIN (SELECT h.group_relation_group,h.group_type,count(h.group_relation_group) AS cnt FROM (SELECT ifnull(f.group_relation_group,9999) AS group_relation_group,ifnull(g.group_type,3) AS group_type FROM buddy e LEFT OUTER JOIN grouprelation f ON e.buddy_no = f.group_relation_buddy LEFT OUTER JOIN buddy_group g ON f.group_relation_group = g._id UNION ALL SELECT 9999 AS group_relation_group,3 AS group_type FROM buddy WHERE buddy_no IN (SELECT group_relation_buddy FROM grouprelation WHERE group_relation_group = 1) AND buddy_no NOT IN (SELECT group_relation_buddy FROM grouprelation WHERE group_relation_group != 1)) h GROUP BY h.group_relation_group UNION ALL SELECT _id AS group_relation_group,group_type,0 AS cnt FROM buddy_group WHERE _id NOT IN (SELECT DISTINCT group_relation_group FROM grouprelation)) i ON d.group_relation_group = i.group_relation_group) a LEFT OUTER JOIN (SELECT * FROM relation WHERE relation_date=DATE('now','localtime','0 day')) b ON a.buddy_no=b.relation_buddy_id)";

        /* renamed from: b */
        public static final String f1746b = "(SELECT a.*,CASE WHEN b.relation_send IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_send END AS relation_send,CASE WHEN b.relation_received IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_received END AS relation_received,CASE WHEN b.relation_point IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_point END AS relation_point,CASE WHEN b.relation_icon IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_icon END AS relation_icon,CASE WHEN b.relation_increase IS NULL THEN 0 WHEN a.buddy_relation_hide = 'Y' THEN 0 ELSE b.relation_increase END AS relation_increase,CASE WHEN b.relation_rank IS NULL THEN 9999999 WHEN a.buddy_relation_hide = 'Y' THEN 9999999 ELSE b.relation_rank END AS relation_rank FROM (SELECT 1 AS group_relation_group,'Favorites' AS group_name,1 AS group_type,b.buddy_no,b.buddy_name,b.buddy_status_message,b.buddy_email,b.buddy_samsung_email,b.buddy_orginal_number,b.buddy_relation_hide,b.buddy_birthday,b.buddy_raw_contact_id,b.buddy_push_name,b.buddy_is_new,b.buddy_profile_status,b.buddy_is_profile_updated,b.buddy_is_status_updated FROM ( SELECT group_relation_buddy FROM grouprelation WHERE group_relation_group = 1 ) a JOIN buddy b ON a.group_relation_buddy = b.buddy_no UNION ALL SELECT null AS group_relation_group,null AS group_name,2 AS group_type,buddy_no,buddy_name,buddy_status_message,buddy_email,buddy_samsung_email,buddy_orginal_number,buddy_relation_hide,buddy_birthday,buddy_raw_contact_id,buddy_push_name,buddy_is_new,buddy_profile_status,buddy_is_profile_updated,buddy_is_status_updated FROM buddy a UNION ALL  SELECT null AS group_relation_group,null AS group_name,2 AS group_type,participants_buddy_no AS buddy_no,ifnull(participants_buddy_name,participants_buddy_no) AS buddy_name,'' AS buddy_status_message,'' AS buddy_email,'' AS buddy_samsung_email,participants_buddy_no AS buddy_orginal_number,'N' AS buddy_relation_hide,'' AS buddy_birthday,0 AS buddy_raw_contact_id,ifnull(participants_buddy_name,participants_buddy_no) AS buddy_push_name,'N' AS buddy_is_new," + Buddy.BuddyImageStatus.NOT_CHANGE.getCode() + " AS buddy_profile_status,'N' AS buddy_is_profile_updated,'N' AS buddy_is_status_updated FROM participant WHERE participants_buddy_no NOT IN (SELECT buddy_no FROM buddy) GROUP BY participants_buddy_no) a LEFT OUTER JOIN (SELECT * FROM relation WHERE relation_date = date('now','localtime','0 day')) b ON a.buddy_no = b.relation_buddy_id)";
    }

    public interface Group_Query {
    }

    public interface Group_Relation_Query {
    }

    public interface Inbox_Query {

        /* renamed from: a */
        public static final String f1747a = "(SELECT c.participants_buddy_name AS inbox_title,a.inbox_no FROM inbox a,(SELECT participants_inbox_no,group_concat(participants_buddy_name) AS participants_buddy_name FROM (SELECT ifnull(b.buddy_name,MAX(participants_buddy_name)) AS participants_buddy_name,participants_buddy_no,participants_inbox_no FROM participant LEFT OUTER JOIN buddy b ON participants_buddy_no=b.buddy_no GROUP BY participants_buddy_no,participants_inbox_no ORDER BY participants_buddy_name ASC)  GROUP BY participants_inbox_no) c WHERE a.inbox_no=c.participants_inbox_no AND (a.inbox_chat_type=" + ChatONContract.InBoxTable.ChatType.GROUPCHAT.m2189a() + " OR a.inbox_chat_type=" + ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a() + ") AND a.inbox_title_fixed='N')";
    }

    public interface Index {
    }

    public interface RELATION_INSERT {

        /* renamed from: a */
        public static final String f1748a = "INSERT INTO relation (relation_buddy_id,relation_date,relation_last_msg_time,relation_send,relation_received,relation_point) SELECT buddy_no,date('NOW', 'localtime', '0 DAY'),last_msg_time,ifnull(send,0),ifnull(recevied,0),CASE WHEN (send+recevied) IS NULL THEN 0 ELSE (send + recevied) END FROM (SELECT buddy_no,message_date,last_msg_time,IFNULL(MAX(send),0) AS send,IFNULL(MAX(recevied),0) AS recevied FROM (SELECT buddy_no,message_date,last_msg_time,message_type,(CASE WHEN message_type = 1 THEN MAX(cnt) END) AS send,(CASE WHEN message_type IN (2,5,4,3) THEN MAX(cnt) END) AS recevied FROM (SELECT b.message_inbox_no AS buddy_no,b.message_type,SUBSTR(b.message_time_text,1,10) AS message_date,MAX(b.message_time_text) AS last_msg_time,COUNT(b.message_inbox_no) AS cnt FROM inbox a,message b WHERE a.inbox_no = b.message_inbox_no AND a.inbox_chat_type = " + ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a() + " AND b.message_type IN (1,2,5,4,3) AND b.message_time_text BETWEEN date('NOW', 'localtime', '-7 DAY') || '00:00:00' AND date('NOW', 'localtime', '0 DAY') || '99:99:99' GROUP BY message_inbox_no,message_type) a WHERE buddy_no IN (SELECT buddy_no FROM buddy) GROUP BY buddy_no,message_type) GROUP BY buddy_no)";
    }

    public interface Relation_Query {
    }

    public interface Tables {

        /* renamed from: a */
        public static final String f1749a = "CREATE TABLE buddy (_id INTEGER PRIMARY KEY AUTOINCREMENT,buddy_no VARCHAR(25) NOT NULL,buddy_name VARCHAR(80) NOT NULL,buddy_status_message VARCHAR(255),buddy_email VARCHAR(80),buddy_samsung_email VARCHAR(80),buddy_orginal_number VARCHAR(25),buddy_birthday VARCHAR(10) NOT NULL DEFAULT '',buddy_msg_send INTEGER DEFAULT 0,buddy_msg_received INTEGER DEFAULT 0,buddy_relation_hide CHAR(1) NOT NULL DEFAULT 'N',buddy_raw_contact_id NUMBER DEFAULT 0, buddy_push_name VARCHAR(25),buddy_is_new CHAR(1) NOT NULL DEFAULT 'Y',buddy_profile_status INTEGER NOT NULL DEFAULT " + Buddy.BuddyImageStatus.NONE_PROFILE.getCode() + ",buddy_is_profile_updated CHAR(1) NOT NULL DEFAULT 'N',buddy_is_status_updated CHAR(1) NOT NULL DEFAULT 'N',buddy_show_phone_number INTEGER DEFAULT '0',UNIQUE (buddy_no))";
    }

    public interface Tables_Join {

        /* renamed from: a */
        public static final String f1750a = "(SELECT *FROM(SELECT ifnull(b.buddy_name,a.message_sender) AS buddy_name,ifnull(b.buddy_no,a.message_sender) AS buddy_no,ifnull(b.buddy_status_message,'') AS buddy_status_message,ifnull(b.buddy_show_phone_number," + String.valueOf(1) + ") AS buddy_show_phone_number,ifnull(b.buddy_profile_status,'') AS buddy_profile_status,a.message_content,a.message_content_type,a.message_download_uri,a.message_formatted,a._id,a.message_inbox_no,a.message_read_status,a.message_sender,a.message_sever_id,a.message_session_id,a.message_time,a.message_translated,a.message_stored_ext,a.message_is_failed,a.message_type FROM message a LEFT OUTER JOIN (SELECT buddy_no,buddy_name,buddy_status_message,buddy_show_phone_number,buddy_profile_status FROM buddy UNION ALL SELECT participants_buddy_no AS buddy_no,MAX(participants_buddy_name) AS buddy_name,'' AS buddy_status_message,'' AS buddy_show_phone_number,'' AS buddy_profile_status FROM participant WHERE participants_buddy_no NOT IN (SELECT buddy_no FROM buddy) GROUP BY participants_buddy_no) b ON a.message_sender = b.buddy_no) c LEFT OUTER JOIN (SELECT ifnull(a.buddy_show_phone_number," + String.valueOf(1) + ") AS opponent_show_phone_number,b.participants_inbox_no AS inbox_no FROM (SELECT participants_buddy_no,participants_inbox_no FROM participant WHERE participants_inbox_no IN (SELECT inbox_no FROM inbox WHERE inbox_chat_type = " + String.valueOf(ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a()) + ")) b LEFT OUTER JOIN buddy a ON b.participants_buddy_no = a.buddy_no) d ON c.message_inbox_no = d.inbox_no)";
    }

    public interface Update_Read_Ack {
    }

    public DatabaseHelper(Context context) {
        super(context, "chaton.db", (SQLiteDatabase.CursorFactory) null, 7);
        this.f1744b = context;
    }

    /* renamed from: a */
    public static DatabaseHelper m2204a(Context context) {
        if (f1743a == null) {
            f1743a = new DatabaseHelper(context);
        }
        return f1743a;
    }

    /* renamed from: a */
    public static String m2205a() {
        return "chaton.db";
    }

    /* renamed from: a */
    private void m2206a(SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_name", "Favorites");
        contentValues.put("group_type", (Integer) 1);
        sQLiteDatabase.insert("buddy_group", null, contentValues);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        f1743a = null;
        super.close();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(Tables.f1749a);
        sQLiteDatabase.execSQL("CREATE TABLE buddy_group (_id INTEGER PRIMARY KEY AUTOINCREMENT,group_name VARCHAR(80) NOT NULL,group_type INTEGER NOT NULL DEFAULT 2,UNIQUE (_id) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE grouprelation (_id INTEGER PRIMARY KEY AUTOINCREMENT,group_relation_buddy VARCHAR(25) NOT NULL REFERENCES buddy(buddy_no),group_relation_group VARCHAR(25) NOT NULL REFERENCES buddy_group(_id),UNIQUE (group_relation_group,group_relation_buddy) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE relation (_id INTEGER PRIMARY KEY AUTOINCREMENT,relation_buddy_id TEXT NOT NULL,relation_date TEXT NOT NULL,relation_send INTEGER NOT NULL DEFAULT 0,relation_received INTEGER NOT NULL DEFAULT 0,relation_point INTEGER NOT NULL DEFAULT 0,relation_icon INTEGER NOT NULL DEFAULT 0,relation_increase INTEGER NOT NULL DEFAULT 0,relation_rank INTEGER NOT NULL DEFAULT 0,relation_last_msg_time TEXT,UNIQUE (relation_buddy_id,relation_date) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE contacts (contacts_id NUMBER,contact_raw_id NUMBER,conatct_number TEXT NOT NULL,contacts_name TEXT,UNIQUE (contacts_id,contact_raw_id) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE inbox (_id INTEGER PRIMARY KEY AUTOINCREMENT,inbox_no TEXT,inbox_chat_type INTEGER NOT NULL,inbox_unread_count INTEGER NOT NULL DEFAULT 0,inbox_last_message TEXT,inbox_title TEXT,inbox_last_time NUMBER,inbox_lang_from TEXT,inbox_lang_to TEXT,inbox_translated TEXT NOT NULL DEFAULT 'N',inbox_server_ip TEXT,inbox_server_port NUMBER,inbox_participants TEXT,inbox_session_id TEXT,inbox_last_msg_no NUMBER,inbox_last_msg_sender TEXT,inbox_title_fixed TEXT NOT NULL DEFAULT 'N',inbox_last_chat_type NUMBER,inbox_last_temp_msg TEXT NOT NULL DEFAULT '',inbox_is_new CHAR(1) NOT NULL DEFAULT 'Y',inbox_trunk_unread_count INTEGER NOT NULL DEFAULT 0,UNIQUE (inbox_no) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE message (_id INTEGER PRIMARY KEY,message_sever_id INTEGER,message_inbox_no TEXT,message_session_id INTEGER,message_read_status INTEGER,message_content_type INTEGER DEFAULT 0,message_time NUMBER,message_content TEXT,message_translated TEXT,message_type INTEGER,message_sender TEXT,message_download_uri TEXT,message_formatted TEXT,message_tid TEXT,message_time_text TEXT,message_stored_ext INTEGER DEFAULT 1,message_need_update TEXT NOT NULL DEFAULT 'Y',message_is_failed INTEGER DEFAULT 0,UNIQUE (_id) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE participant (participants_buddy_no TEXT NOT NULL,participants_inbox_no TEXT NOT NULL,participants_buddy_name TEXT,UNIQUE (participants_buddy_no,participants_inbox_no) ON CONFLICT REPLACE);");
        sQLiteDatabase.execSQL("CREATE TABLE memo (_id INTEGER PRIMARY KEY AUTOINCREMENT,buddy_no VARCHAR(25),buddy_name VARCHAR(80),memo VARCHAR(255),timestamp VARCHAR(80), UNIQUE (timestamp))");
        sQLiteDatabase.execSQL("CREATE TABLE memo_sessions (_id INTEGER PRIMARY KEY AUTOINCREMENT,buddy_no VARCHAR(25),buddy_name VARCHAR(80),starttime VARCHAR(80),endtime VARCHAR(80),isblind VARCHAR(80), UNIQUE (buddy_no))");
        sQLiteDatabase.execSQL("CREATE INDEX msg_server_no_index ON message (message_sever_id,message_inbox_no,message_sender);");
        m2206a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        int i3;
        if (i == 1) {
            ChatONLogWriter.m3508c("Upgrading from : " + i + " to : " + i2, getClass().getSimpleName());
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_is_profile_updated CHAR(1) NOT NULL DEFAULT 'N'");
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_is_status_updated CHAR(1) NOT NULL DEFAULT 'N'");
            i3 = i + 1;
        } else {
            i3 = i;
        }
        if (i3 == 2) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_is_new CHAR(1) NOT NULL DEFAULT 'N'");
            i3++;
        }
        if (i3 == 3) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS memo");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS memo_sessions");
            sQLiteDatabase.execSQL("CREATE TABLE memo (_id INTEGER PRIMARY KEY AUTOINCREMENT,buddy_no VARCHAR(25),buddy_name VARCHAR(80),memo VARCHAR(255),timestamp VARCHAR(80), UNIQUE (timestamp))");
            sQLiteDatabase.execSQL("CREATE TABLE memo_sessions (_id INTEGER PRIMARY KEY AUTOINCREMENT,buddy_no VARCHAR(25),buddy_name VARCHAR(80),starttime VARCHAR(80),endtime VARCHAR(80),isblind VARCHAR(80), UNIQUE (buddy_no))");
            i3++;
        }
        if (i3 == 4) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_trunk_unread_count INTEGER NOT NULL DEFAULT '0'");
            i3++;
        }
        if (i3 == 5) {
            sQLiteDatabase.execSQL("ALTER TABLE relation ADD COLUMN relation_last_msg_time TEXT");
            i3++;
        }
        if (i3 == 6) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_show_phone_number INTEGER DEFAULT '0'");
            int i4 = i3 + 1;
        }
    }
}
