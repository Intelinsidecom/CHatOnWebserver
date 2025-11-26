package com.sec.chaton.p027e;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.sec.chaton.account.C0423i;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.p027e.p028a.C1353ab;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p027e.p028a.C1358b;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.p027e.p028a.C1370n;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p035io.entry.inner.Skin;
import com.sec.chaton.settings.downloads.C2559az;
import com.sec.chaton.settings.downloads.C2591cd;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.av */
/* loaded from: classes.dex */
public class C1404av extends SQLiteOpenHelper {

    /* renamed from: a */
    private static final String f5216a = C1404av.class.getSimpleName();

    /* renamed from: b */
    private static C1404av f5217b = null;

    /* renamed from: c */
    private Context f5218c;

    public C1404av(Context context) {
        super(context, "chaton.db", (SQLiteDatabase.CursorFactory) null, 84);
        this.f5218c = context;
    }

    /* renamed from: a */
    public static String m6254a() {
        return "chaton.db";
    }

    /* renamed from: a */
    public static synchronized C1404av m6253a(Context context) {
        if (f5217b == null) {
            f5217b = new C1404av(context);
        }
        return f5217b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(InterfaceC1430bf.f5322a);
        sQLiteDatabase.execSQL(InterfaceC1430bf.f5323b);
        sQLiteDatabase.execSQL(InterfaceC1430bf.f5324c);
        sQLiteDatabase.execSQL(InterfaceC1430bf.f5325d);
        sQLiteDatabase.execSQL(InterfaceC1430bf.f5326e);
        sQLiteDatabase.execSQL(InterfaceC1430bf.f5327f);
        sQLiteDatabase.execSQL(InterfaceC1430bf.f5329h);
        sQLiteDatabase.execSQL(InterfaceC1430bf.f5330i);
        sQLiteDatabase.execSQL(InterfaceC1426bb.f5296a);
        m6255a(sQLiteDatabase);
        m6256a(sQLiteDatabase, 1, true);
    }

    /* renamed from: a */
    private void m6255a(SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_name", "Favorites");
        contentValues.put("group_type", (Integer) 1);
        sQLiteDatabase.insert("buddy_group", null, contentValues);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        f5217b = null;
        super.close();
    }

    /* renamed from: a */
    private void m6256a(SQLiteDatabase sQLiteDatabase, int i, boolean z) {
        sQLiteDatabase.beginTransaction();
        if (i < 2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_is_profile_updated CHAR(1) NOT NULL DEFAULT 'N'");
                sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_is_status_updated CHAR(1) NOT NULL DEFAULT 'N'");
            } finally {
                sQLiteDatabase.endTransaction();
                C3159aa.m10965a("get_all_unread_message_timestamp", Long.valueOf(0L));
            }
        }
        if (i < 3) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_is_new CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 4) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS memo");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS memo_sessions");
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5334m);
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5335n);
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
            C1370n.m6128a(sQLiteDatabase);
        }
        if (i < 9) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy_group ADD COLUMN group_is_new CHAR(1) NOT NULL DEFAULT 'Y'");
            sQLiteDatabase.execSQL("UPDATE buddy_group SET group_is_new = 'N'");
        }
        if (i < 10) {
            C0423i.m3034a();
        }
        if (i < 11) {
            C1373q.m6180a(sQLiteDatabase);
        }
        if (i < 12) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_extra_info VARCHAR(80)");
        }
        if (i < 13) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_enable_noti CHAR(1) NOT NULL DEFAULT 'Y'");
        }
        if (i < 14) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox_buddy_relation ADD COLUMN chat_type INTEGER NOT NULL DEFAULT '" + String.valueOf(EnumC1450r.UNKNOWN.m6342a()) + "'");
            sQLiteDatabase.execSQL("UPDATE inbox_buddy_relation SET chat_type = '" + String.valueOf(EnumC1450r.ONETOONE.m6342a()) + "'");
            String strM6261d = m6261d();
            if (strM6261d != null) {
                C3159aa.m10966a("country_name", strM6261d);
            }
        }
        if (i < 15) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_last_timestamp NUMBER");
        }
        if (i < 16) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS recommendee");
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5343v);
        }
        if (i < 17) {
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5344w);
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5346y);
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5308A);
        }
        if (i < 18) {
            sQLiteDatabase.execSQL(C3364o.m11849a("ALTER TABLE ", "anicon_package", " ADD COLUMN ", "special", " INTEGER NOT NULL DEFAULT(0)"));
        }
        if (i < 19) {
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_is_file_upload INTEGER NOT NULL DEFAULT(" + String.valueOf(0) + ")");
            C1373q.m6191b(sQLiteDatabase);
        }
        if (i < 20) {
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_is_truncated CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 21) {
        }
        if (i < 22) {
        }
        if (i < 23) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_is_change_skin CHAR(1) NOT NULL DEFAULT 'N'");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_background_style VARCHAR(80)");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_send_bubble_style VARCHAR(80)");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_receive_bubble_style VARCHAR(80)");
        }
        if (i < 24) {
        }
        if (i < 25) {
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN description TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN followcount VARCHAR(80)");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN likecount VARCHAR(80)");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN msgstatus VARCHAR(256)");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN photoloaded VARCHAR(25)");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN status TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN url VARCHAR(80)");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS specialbuddy");
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5311D);
        }
        if (i < 26) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_is_entered CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 27) {
            sQLiteDatabase.execSQL("ALTER TABLE specialbuddy ADD COLUMN islike CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 28) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS theme");
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5310C);
            for (Skin skin : C2591cd.m9573b(this.f5218c)) {
                sQLiteDatabase.execSQL(C3364o.m11849a("INSERT INTO ", "skin", "(", "skin_id", ",", "special", ",", "thumbnail_url", ",", "bg_type", ",", "expiration_date", ",", "install", ",", "new", ") VALUES (", "'", skin.f5654id, "',", skin.special, ",", "'", skin.thumbnailurl, "',", "'", skin.bgtype, "',", skin.expirationdate, ",", "1,", "0", ")"));
            }
        }
        if (i < 29) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_is_name_updated CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 30) {
            sQLiteDatabase.execSQL("ALTER TABLE specialbuddy ADD COLUMN weburl VARCHAR(80)");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN weburl VARCHAR(80)");
        }
        if (i < 31) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_web_url TEXT");
        }
        if (i < 32) {
            sQLiteDatabase.execSQL("ALTER TABLE specialbuddy ADD COLUMN isNew CHAR(1) DEFAULT 'Y'");
        }
        if (i < 33) {
            sQLiteDatabase.execSQL("DROP INDEX IF EXISTS msg_server_no_index");
            sQLiteDatabase.execSQL("DROP INDEX IF EXISTS msg_inbox_no_index_1");
            sQLiteDatabase.execSQL("DROP INDEX IF EXISTS msg_inbox_no_index_2");
            sQLiteDatabase.execSQL(InterfaceC1426bb.f5297b);
            sQLiteDatabase.execSQL(InterfaceC1426bb.f5298c);
        }
        if (i < 34) {
        }
        if (i < 35) {
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5313F);
        }
        if (i < 36) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS memo");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS memo_sessions");
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5336o);
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5339r);
        }
        if (i < 37) {
            try {
                C1358b.m6005a(sQLiteDatabase);
                C1353ab.m5965a(sQLiteDatabase);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS anicon_package");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS skin");
            } catch (JSONException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f5216a);
                }
                throw new RuntimeException(e);
            }
        }
        if (i < 38) {
            C1360d.m6039b(sQLiteDatabase);
        }
        if (i < 39) {
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5314G);
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5315H);
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5316I);
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5317J);
            sQLiteDatabase.execSQL(InterfaceC1432bh.f5356b);
        }
        if (i < 40) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_updated_timestamp VARCHAR(80) NOT NULL DEFAULT ''");
        }
        if (i < 41) {
            sQLiteDatabase.execSQL("ALTER TABLE download_item ADD COLUMN down_rank INTEGER");
            sQLiteDatabase.execSQL("ALTER TABLE download_item ADD COLUMN data1 TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE download_item ADD COLUMN data2 TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE download_item ADD COLUMN data3 TEXT");
        }
        if (i < 42) {
            sQLiteDatabase.execSQL("ALTER TABLE specialbuddy ADD COLUMN tel VARCHAR(80)");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN tel VARCHAR(80)");
        }
        if (i < 43) {
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN timestamp INTEGER DEFAULT(0)");
        }
        if (i < 44) {
            sQLiteDatabase.execSQL("ALTER TABLE poll ADD COLUMN poll_remain_time INTEGER DEFAULT(0)");
        }
        if (i < 45) {
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5319L);
        }
        if (i < 46 && !TextUtils.isEmpty(C3159aa.m10962a().m10979a("msisdn", "")) && TextUtils.isEmpty(C3159aa.m10962a().m10979a("chaton_id", ""))) {
            C3159aa.m10966a("chaton_id", C3159aa.m10962a().m10979a("msisdn", ""));
            C3250y.m11453c("DB chatonid : " + C3159aa.m10962a().m10979a("chaton_id", ""), getClass().getSimpleName());
            C3159aa.m10963a("upgrade_multi_device_version", (Boolean) true);
        }
        if (i < 47) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_orginal_numbers TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_msisdns TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_multidevice CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 48) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN profile_url TEXT");
            sQLiteDatabase.execSQL("UPDATE inbox SET profile_url = 'NA'");
        }
        if (i < 49) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN lasst_session_merge_time NUMBER DEFAULT '0'");
        }
        if (i < 50) {
            sQLiteDatabase.execSQL("CREATE TABLE message_notification (noti_inbox_no TEXT,noti_buddy_no TEXT,noti_message TEXT,noti_sent_time NUMBER,noti_message_id NUMBER,noti_chat_type INTEGER);");
        }
        if (i < 51) {
            sQLiteDatabase.execSQL("ALTER TABLE message_notification ADD COLUMN noti_msg_type INTEGER DEFAULT '0'");
        }
        if (i < 52) {
            sQLiteDatabase.execSQL("ALTER TABLE participant ADD COLUMN participants_country_code TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE participant ADD COLUMN participants_is_auth CHAR(1)");
            sQLiteDatabase.execSQL("ALTER TABLE participant ADD COLUMN participants_status INTEGER");
        }
        if (i < 53) {
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN chatonid TEXT");
        }
        if (i < 54) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_old_session_id TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE participant ADD COLUMN participants_old_buddy_no TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_old_session_id TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_old_sender TEXT");
        }
        if (i < 55) {
            sQLiteDatabase.execSQL("ALTER TABLE participant RENAME TO participant_OLD");
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5331j);
            sQLiteDatabase.execSQL("INSERT INTO participant SELECT " + InterfaceC1430bf.f5332k + " from participant_OLD");
            sQLiteDatabase.execSQL("DROP TABLE participant_OLD");
            sQLiteDatabase.execSQL("DELETE FROM inbox WHERE inbox_title IS NULL AND inbox_last_chat_type=12");
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5333l);
        }
        if (i < 56) {
            sQLiteDatabase.execSQL(InterfaceC1426bb.f5299d);
        }
        if (i < 57) {
            sQLiteDatabase.execSQL("CREATE TABLE inbox_session_id_mapping (inbox_session_id TEXT NOT NULL,inbox_old_session_id TEXT NOT NULL,UNIQUE (inbox_old_session_id) ON CONFLICT REPLACE);");
        }
        if (i < 58) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_old_no TEXT");
        }
        if (i < 59) {
        }
        if (i < 60) {
            C1360d.m6029a(sQLiteDatabase);
        }
        if (i < 61) {
            m6260c();
        }
        if (i < 62 && TextUtils.isEmpty(C3171am.m11082t()) && !TextUtils.isEmpty(C3159aa.m10962a().m10979a("msisdn", ""))) {
            String strM11060d = C3171am.m11060d();
            if (!TextUtils.isEmpty(strM11060d)) {
                strM11060d = strM11060d.toUpperCase();
            }
            C3250y.m11450b("update Regi ISO2 : null -> " + strM11060d, getClass().getSimpleName());
            C3159aa.m10966a("country_ISO", strM11060d);
        }
        if (i < 63) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_sainfo TEXT");
        }
        if (i < 64) {
            sQLiteDatabase.execSQL("ALTER TABLE download_item ADD COLUMN newly_installed INTEGER DEFAULT '0'");
        }
        if (i < 65) {
            for (C2559az c2559az : C2559az.m9506a().values()) {
                c2559az.getClass();
                c2559az.getClass();
                c2559az.getClass();
                c2559az.getClass();
                c2559az.getClass();
                String strM11849a = C3364o.m11849a("INSERT INTO ", "download_item", " ( ", "reference_id", ", ", "item_id", ", ", "item_type", ", ", "name", ", ", "install", ", ", "expiration_time", ", ", "new", ", ", "special", ", ", "extras", ", ", "newly_installed", " ) values ( ", 0, ", ", "'", c2559az.f9732m, "'", ", ", "'", c2559az.f9724e, "'", ", ", "\"", c2559az.f9734o, "\"", ", ", 1, ", ", Long.MAX_VALUE, ", ", 0, ", ", c2559az.f9722c, ", ", "'", c2559az.f9736q, "'", ", ", 1, " ) ");
                C3250y.m11450b("execute. " + strM11849a, f5216a);
                sQLiteDatabase.execSQL(strM11849a);
            }
            C2559az.m9508b();
        }
        if (i < 66) {
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_content_translated TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_from_lang TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_to_lang TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_is_spoken CHAR(1) NOT NULL DEFAULT 'N'");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_translate_my_language TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_translate_buddy_language TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_enable_translate TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN translate_outgoing_message TEXT");
        }
        if (i < 67) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS calllog");
            sQLiteDatabase.execSQL("CREATE TABLE calllog (_id INTEGER PRIMARY KEY AUTOINCREMENT,calldate TEXT NOT NULL,duration INTEGER\tNOT NULL DEFAULT 0,calllogtype INTEGER\tNOT NULL DEFAULT 0,callmethod INTEGER NOT NULL DEFAULT 0,userno TEXT NOT NULL DEFAULT '',username TEXT,userid TEXT,phoneno TEXT,countrycode TEXT,groupcallkey INTEGER NOT NULL DEFAULT 0,rejectmsg TEXT,groupid INTEGER)");
        }
        if (i < 68) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_account_info INTEGER NOT NULL DEFAULT 0");
        }
        if (i < 69) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_last_tid TEXT DEFAULT '0'");
        }
        if (i < 70) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_original_name TEXT");
        }
        if (i < 71) {
            C1757q.m7255e();
        }
        if (i < 72) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_using_contact_name CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 73) {
            sQLiteDatabase.execSQL("ALTER TABLE contacts ADD COLUMN conatct_normalized_number TEXT");
            C3159aa.m10962a().m10983b("buddy_delete_copied_contacts", (Boolean) true);
        }
        if (i < 74 && C3159aa.m10962a().m10987b("uid") && !C3159aa.m10962a().m10979a("update_disclaimer_status", "").equals("RUN")) {
            C3171am.m11050a("agree_disclaimer", (Object) true);
        }
        if (i < 75) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_is_hide CHAR(1) NOT NULL DEFAULT 'N'");
            sQLiteDatabase.execSQL("ALTER TABLE specialbuddy ADD COLUMN is_hide CHAR(1) NOT NULL DEFAULT 'N'");
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_hanzitopinyin VARCHAR(80) NOT NULL DEFAULT ''");
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5337p);
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5338q);
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5340s);
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5341t);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS poston");
        }
        if (i < 76) {
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5320M);
            sQLiteDatabase.execSQL("ALTER TABLE poston_comments ADD COLUMN commentid  VARCHAR(25) NOT NULL DEFAULT '0'");
        }
        if (i < 77) {
            sQLiteDatabase.execSQL("ALTER TABLE specialbuddy ADD COLUMN usertype INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN usertype INTEGER DEFAULT 0");
            C1357af.m5990a(sQLiteDatabase);
        }
        if (i < 78) {
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN rank INTEGER");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN targetiso2 VARCHAR(25)");
        }
        if (i < 79) {
            sQLiteDatabase.execSQL("ALTER TABLE appmanage ADD COLUMN messageTypeFlag TEXT");
        }
        if (i < 80) {
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5321N);
        }
        if (i < 81) {
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5342u);
        }
        if (i < 82) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_phonenumber_external_use TEXT DEFAULT ''");
            C1360d.m6045c(sQLiteDatabase);
        }
        if (i < 83) {
            try {
                C1353ab.m5967b(sQLiteDatabase);
            } catch (JSONException e2) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e2, f5216a);
                }
                throw new RuntimeException(e2);
            }
        }
        if (i < 84) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_coverstory_meta_id TEXT DEFAULT ''");
        }
        sQLiteDatabase.setTransactionSuccessful();
    }

    /* renamed from: b */
    private void m6259b(SQLiteDatabase sQLiteDatabase, int i, boolean z) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_sainfo TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_account_info INTEGER NOT NULL DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_is_hide CHAR(1) NOT NULL DEFAULT 'N'");
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_hanzitopinyin VARCHAR(80) NOT NULL DEFAULT ''");
            sQLiteDatabase.execSQL("ALTER TABLE participant ADD COLUMN participants_country_code TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE participant ADD COLUMN participants_is_auth CHAR(1)");
            sQLiteDatabase.execSQL("ALTER TABLE participant ADD COLUMN participants_status INTEGER");
            sQLiteDatabase.execSQL("ALTER TABLE poston_comments ADD COLUMN commentid  VARCHAR(25) NOT NULL DEFAULT '0'");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN usertype INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN rank INTEGER");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN targetiso2 VARCHAR(25)");
            sQLiteDatabase.execSQL("ALTER TABLE specialbuddy ADD COLUMN is_hide CHAR(1) NOT NULL DEFAULT 'N'");
            sQLiteDatabase.execSQL("ALTER TABLE specialbuddy ADD COLUMN usertype INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_is_change_skin CHAR(1) NOT NULL DEFAULT 'N'");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_background_style VARCHAR(80)");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_send_bubble_style VARCHAR(80)");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_receive_bubble_style VARCHAR(80)");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_translate_my_language TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_translate_buddy_language TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_enable_translate TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN translate_outgoing_message TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_content_translated TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_from_lang TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_to_lang TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_is_spoken CHAR(1) NOT NULL DEFAULT 'N'");
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5314G);
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5315H);
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5316I);
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5317J);
            sQLiteDatabase.execSQL(InterfaceC1432bh.f5356b);
            sQLiteDatabase.execSQL("CREATE TABLE message_notification (noti_inbox_no TEXT,noti_buddy_no TEXT,noti_message TEXT,noti_sent_time NUMBER,noti_message_id NUMBER,noti_chat_type INTEGER);");
            sQLiteDatabase.execSQL("CREATE TABLE calllog (_id INTEGER PRIMARY KEY AUTOINCREMENT,calldate TEXT NOT NULL,duration INTEGER\tNOT NULL DEFAULT 0,calllogtype INTEGER\tNOT NULL DEFAULT 0,callmethod INTEGER NOT NULL DEFAULT 0,userno TEXT NOT NULL DEFAULT '',username TEXT,userid TEXT,phoneno TEXT,countrycode TEXT,groupcallkey INTEGER NOT NULL DEFAULT 0,rejectmsg TEXT,groupid INTEGER)");
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5337p);
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5338q);
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5340s);
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5341t);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS poston");
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5342u);
            sQLiteDatabase.execSQL(InterfaceC1430bf.f5320M);
            C1757q.m7255e();
            C1357af.m5990a(sQLiteDatabase);
            for (C2559az c2559az : C2559az.m9506a().values()) {
                c2559az.getClass();
                c2559az.getClass();
                c2559az.getClass();
                c2559az.getClass();
                c2559az.getClass();
                String strM11849a = C3364o.m11849a("INSERT INTO ", "download_item", " ( ", "reference_id", ", ", "item_id", ", ", "item_type", ", ", "name", ", ", "install", ", ", "expiration_time", ", ", "new", ", ", "special", ", ", "extras", ", ", "newly_installed", " ) values ( ", 0, ", ", "'", c2559az.f9732m, "'", ", ", "'", c2559az.f9724e, "'", ", ", "\"", c2559az.f9734o, "\"", ", ", 1, ", ", Long.MAX_VALUE, ", ", 0, ", ", c2559az.f9722c, ", ", "'", c2559az.f9736q, "'", ", ", 1, " ) ");
                C3250y.m11450b("execute. " + strM11849a, f5216a);
                sQLiteDatabase.execSQL(strM11849a);
            }
            C2559az.m9508b();
            if (i < 80) {
                sQLiteDatabase.execSQL(InterfaceC1430bf.f5321N);
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
            C3159aa.m10965a("get_all_unread_message_timestamp", (Long) 0L);
        }
    }

    /* renamed from: c */
    private void m6260c() {
        AccountManager accountManager = AccountManager.get(CommonApplication.m11493l());
        String strM10979a = C3159aa.m10962a().m10979a("msisdn", "");
        String strM10979a2 = C3159aa.m10962a().m10979a("samsung_account_email", "");
        String strM10979a3 = C3159aa.m10962a().m10979a("uid", "");
        Account[] accountsByType = accountManager.getAccountsByType("com.sec.chaton");
        if (accountsByType.length <= 0 && C3159aa.m10962a().m10987b("uid")) {
            if (!TextUtils.isEmpty(strM10979a)) {
                m6257a(strM10979a, strM10979a3, false);
                return;
            } else {
                if (!TextUtils.isEmpty(strM10979a2)) {
                    m6257a(strM10979a2, strM10979a3, true);
                    return;
                }
                return;
            }
        }
        if (accountsByType.length > 0 && C3159aa.m10962a().m10987b("uid") && !TextUtils.isEmpty(strM10979a) && ContentResolver.getIsSyncable(accountsByType[0], "com.android.contacts") <= 0) {
            ContentResolver.setIsSyncable(accountsByType[0], "com.android.contacts", 1);
            ContentResolver.setSyncAutomatically(accountsByType[0], "com.android.contacts", true);
        }
    }

    /* renamed from: a */
    private void m6257a(String str, String str2, boolean z) {
        Account account = new Account(str, "com.sec.chaton");
        AccountManager.get(CommonApplication.m11493l()).addAccountExplicitly(account, str2, null);
        if (z) {
            ContentResolver.setIsSyncable(account, "com.android.contacts", 0);
        } else {
            ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Log.i("ChatON", "[DatabaseHelper] Upgrading from : " + i + " to : " + i2);
        if (C1493a.m6463a("tabletdb_interg_feature") && i < 49) {
            m6259b(sQLiteDatabase, i, false);
        } else {
            m6256a(sQLiteDatabase, i, false);
        }
    }

    /* renamed from: d */
    private String m6261d() {
        String strM10979a = C3159aa.m10962a().m10979a("country_name", (String) null);
        if (strM10979a == null) {
            return null;
        }
        if (strM10979a.equals("Aland Islands")) {
            return "Aland Islands";
        }
        if (strM10979a.equals("Argentina")) {
            return "Argentine Republic";
        }
        if (strM10979a.equals("Azerbaijan")) {
            return "Republic of Azerbaijan";
        }
        if (strM10979a.equals("Congo")) {
            return "Republic of the Congo";
        }
        if (strM10979a.equals("Cote d'Ivoire")) {
            return "Cote d'Ivoire";
        }
        if (strM10979a.equals("Gabon")) {
            return "Gabonese Republic";
        }
        if (strM10979a.equals("Guinea-bissau")) {
            return "Guinea-Bissau";
        }
        if (strM10979a.equals("Kyrgyzstan")) {
            return "Kyrgyz Republic";
        }
        if (strM10979a.equals("Macedonia")) {
            return "Republic of Macedonia";
        }
        if (strM10979a.equals("Reunion")) {
            return "Reunion";
        }
        if (strM10979a.equals("Rwanda")) {
            return "Republic of Rwanda";
        }
        if (strM10979a.equals("Sao Tome and Principe")) {
            return "Sao Tome and Principe";
        }
        if (strM10979a.equals("Svalbard and Jan Mayen Islands")) {
            return "Svalbard and Jan Mayen";
        }
        if (strM10979a.equals("Togo")) {
            return "Togolese Republic";
        }
        if (strM10979a.equals("United States")) {
            return "United States of America";
        }
        if (strM10979a.equals("US Virgin Islands")) {
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

    /* renamed from: b */
    public static void m6258b() throws IOException {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Log.i("TEST", "copyDatabaseToSdcard start");
        try {
            fileInputStream = new FileInputStream(CommonApplication.m11493l().getDatabasePath(m6254a()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileInputStream = null;
        }
        try {
            fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory().getAbsolutePath() + "/chatondb.db");
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            fileOutputStream = null;
        }
        if (fileInputStream != null && fileOutputStream != null) {
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int i = fileInputStream.read(bArr);
                    if (i > 0) {
                        fileOutputStream.write(bArr, 0, i);
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                try {
                    break;
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            fileOutputStream.flush();
            try {
                fileOutputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (IOException e6) {
                e6.printStackTrace();
            }
            Log.i("TEST", "copyDatabaseToSdcard end");
        }
    }
}
