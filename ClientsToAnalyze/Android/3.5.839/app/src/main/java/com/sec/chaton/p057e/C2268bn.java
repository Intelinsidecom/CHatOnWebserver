package com.sec.chaton.p057e;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.sec.chaton.account.C1002i;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.msgsend.C2717y;
import com.sec.chaton.p057e.p058a.C2174a;
import com.sec.chaton.p057e.p058a.C2177ac;
import com.sec.chaton.p057e.p058a.C2183ai;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.p057e.p058a.C2188b;
import com.sec.chaton.p057e.p058a.C2190d;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p065io.entry.inner.Skin;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.settings.p096a.C3470n;
import com.sec.chaton.settings.p096a.C3474r;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4892m;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5052r;
import com.sec.spp.push.Config;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: DatabaseHelper.java */
/* renamed from: com.sec.chaton.e.bn */
/* loaded from: classes.dex */
public class C2268bn extends SQLiteOpenHelper {

    /* renamed from: a */
    private static final String f8063a = C2268bn.class.getSimpleName();

    /* renamed from: b */
    private static C2268bn f8064b = null;

    /* renamed from: c */
    private final Context f8065c;

    public C2268bn(Context context) {
        super(context, "chaton.db", (SQLiteDatabase.CursorFactory) null, 120);
        this.f8065c = context;
    }

    /* renamed from: a */
    public static String m10127a() {
        return "chaton.db";
    }

    /* renamed from: a */
    public static synchronized C2268bn m10126a(Context context) {
        if (f8064b == null) {
            f8064b = new C2268bn(context);
        }
        return f8064b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8141a);
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8142b);
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8143c);
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8144d);
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8145e);
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8146f);
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8148h);
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8149i);
        sQLiteDatabase.execSQL(InterfaceC2274bt.f8107a);
        m10128a(sQLiteDatabase);
        m10129a(sQLiteDatabase, 1, true);
    }

    /* renamed from: a */
    private void m10128a(SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_name", "Favorites");
        contentValues.put("group_type", (Integer) 1);
        sQLiteDatabase.insert("buddy_group", null, contentValues);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        f8064b = null;
        super.close();
    }

    /* renamed from: a */
    private void m10129a(SQLiteDatabase sQLiteDatabase, int i, boolean z) {
        sQLiteDatabase.beginTransaction();
        if (i < 2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_is_profile_updated CHAR(1) NOT NULL DEFAULT 'N'");
                sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_is_status_updated CHAR(1) NOT NULL DEFAULT 'N'");
            } finally {
                sQLiteDatabase.endTransaction();
                C4809aa.m18107a("get_all_unread_message_timestamp", Long.valueOf(0L));
            }
        }
        if (i < 3) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_is_new CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 4) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS memo");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS memo_sessions");
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8153m);
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8154n);
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
            C2198l.m9931a(sQLiteDatabase);
        }
        if (i < 9) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy_group ADD COLUMN group_is_new CHAR(1) NOT NULL DEFAULT 'Y'");
            sQLiteDatabase.execSQL("UPDATE buddy_group SET group_is_new = 'N'");
        }
        if (i < 10) {
            C1002i.m6065b();
        }
        if (i < 11) {
            C2204r.m10032a(sQLiteDatabase);
        }
        if (i < 12) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_extra_info VARCHAR(80)");
        }
        if (i < 13) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_enable_noti CHAR(1) NOT NULL DEFAULT 'Y'");
        }
        if (i < 14) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox_buddy_relation ADD COLUMN chat_type INTEGER NOT NULL DEFAULT '" + String.valueOf(EnumC2300t.UNKNOWN.m10210a()) + "'");
            sQLiteDatabase.execSQL("UPDATE inbox_buddy_relation SET chat_type = '" + String.valueOf(EnumC2300t.ONETOONE.m10210a()) + "'");
            String strM10135e = m10135e();
            if (strM10135e != null) {
                C4809aa.m18108a("country_name", strM10135e);
            }
        }
        if (i < 15) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_last_timestamp NUMBER");
        }
        if (i < 16) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS recommendee");
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8163w);
        }
        if (i < 17) {
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8164x);
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8166z);
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8120B);
        }
        if (i < 18) {
            sQLiteDatabase.execSQL(C5052r.m19199a("ALTER TABLE ", "anicon_package", " ADD COLUMN ", "special", " INTEGER NOT NULL DEFAULT(0)"));
        }
        if (i < 19) {
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_is_file_upload INTEGER NOT NULL DEFAULT(" + String.valueOf(0) + ")");
            C2204r.m10047b(sQLiteDatabase);
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
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8123E);
        }
        if (i < 26) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_is_entered CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 27) {
            sQLiteDatabase.execSQL("ALTER TABLE specialbuddy ADD COLUMN islike CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 28) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS theme");
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8122D);
            for (Skin skin : C3474r.m13823b(this.f8065c)) {
                sQLiteDatabase.execSQL(C5052r.m19199a("INSERT INTO ", "skin", "(", "skin_id", ",", "special", ",", "thumbnail_url", ",", "bg_type", ",", "expiration_date", ",", "install", ",", "new", ") VALUES (", "'", skin.f8579id, "',", skin.special, ",", "'", skin.thumbnailurl, "',", "'", skin.bgtype, "',", skin.expirationdate, ",", "1,", Spam.ACTIVITY_CANCEL, ")"));
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
            sQLiteDatabase.execSQL(InterfaceC2274bt.f8108b);
            sQLiteDatabase.execSQL(InterfaceC2274bt.f8109c);
        }
        if (i < 34) {
        }
        if (i < 35) {
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8125G);
        }
        if (i < 36) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS memo");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS memo_sessions");
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8155o);
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8158r);
        }
        if (i < 37) {
            try {
                C2188b.m9791a(sQLiteDatabase);
                C2183ai.m9748a(sQLiteDatabase);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS anicon_package");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS skin");
            } catch (JSONException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f8063a);
                }
                throw new RuntimeException(e);
            }
        }
        if (i < 38) {
            C2190d.m9822b(sQLiteDatabase);
        }
        if (i < 39) {
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8126H);
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8127I);
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8128J);
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8129K);
            sQLiteDatabase.execSQL(InterfaceC2280bz.f8183b);
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
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8131M);
        }
        if (i < 46 && !TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", "")) && TextUtils.isEmpty(C4809aa.m18104a().m18121a("chaton_id", ""))) {
            C4809aa.m18108a("chaton_id", C4809aa.m18104a().m18121a("msisdn", ""));
            C4904y.m18641c("DB chatonid : " + C4809aa.m18104a().m18121a("chaton_id", ""), getClass().getSimpleName());
            C4809aa.m18105a("upgrade_multi_device_version", (Boolean) true);
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
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8150j);
            sQLiteDatabase.execSQL("INSERT INTO participant SELECT " + InterfaceC2278bx.f8151k + " from participant_OLD");
            sQLiteDatabase.execSQL("DROP TABLE participant_OLD");
            sQLiteDatabase.execSQL("DELETE FROM inbox WHERE inbox_title IS NULL AND inbox_last_chat_type=12");
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8152l);
        }
        if (i < 56) {
            sQLiteDatabase.execSQL(InterfaceC2274bt.f8110d);
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
            C2190d.m9813a(sQLiteDatabase);
        }
        if (i < 61) {
            m10134d();
        }
        if (i < 62 && TextUtils.isEmpty(C4822an.m18257y()) && !TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
            String strM18236g = C4822an.m18236g();
            if (!TextUtils.isEmpty(strM18236g)) {
                strM18236g = strM18236g.toUpperCase();
            }
            C4904y.m18639b("update Regi ISO2 : null -> " + strM18236g, getClass().getSimpleName());
            C4809aa.m18108a("country_ISO", strM18236g);
        }
        if (i < 63) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_sainfo TEXT");
        }
        if (i < 64) {
            sQLiteDatabase.execSQL("ALTER TABLE download_item ADD COLUMN newly_installed INTEGER DEFAULT '0'");
        }
        if (i < 65) {
            for (C3470n c3470n : C3470n.m13796a().values()) {
                c3470n.getClass();
                c3470n.getClass();
                c3470n.getClass();
                c3470n.getClass();
                c3470n.getClass();
                String strM19199a = C5052r.m19199a("INSERT INTO ", "download_item", " ( ", "reference_id", ", ", "item_id", ", ", "item_type", ", ", "name", ", ", "install", ", ", "expiration_time", ", ", "new", ", ", "special", ", ", "extras", ", ", "newly_installed", " ) values ( ", 0, ", ", "'", c3470n.f12948m, "'", ", ", "'", c3470n.f12940e, "'", ", ", "\"", c3470n.f12950o, "\"", ", ", 1, ", ", Long.MAX_VALUE, ", ", 0, ", ", c3470n.f12938c, ", ", "'", c3470n.f12952q, "'", ", ", 1, " ) ");
                C4904y.m18639b("execute. " + strM19199a, f8063a);
                sQLiteDatabase.execSQL(strM19199a);
            }
            C3470n.m13798b();
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
            C2717y.m11402e();
        }
        if (i < 72) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_using_contact_name CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 73) {
            sQLiteDatabase.execSQL("ALTER TABLE contacts ADD COLUMN conatct_normalized_number TEXT");
            C4809aa.m18104a().m18125b("buddy_delete_copied_contacts", (Boolean) true);
        }
        if (i < 74 && C4809aa.m18104a().m18129b("uid") && !C4809aa.m18104a().m18121a("update_disclaimer_status", "").equals("RUN")) {
            C4822an.m18216a("agree_disclaimer", (Object) true);
        }
        if (i < 75) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_is_hide CHAR(1) NOT NULL DEFAULT 'N'");
            sQLiteDatabase.execSQL("ALTER TABLE specialbuddy ADD COLUMN is_hide CHAR(1) NOT NULL DEFAULT 'N'");
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_hanzitopinyin VARCHAR(80) NOT NULL DEFAULT ''");
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8156p);
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8157q);
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8159s);
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8160t);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS poston");
        }
        if (i < 76) {
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8132N);
            sQLiteDatabase.execSQL("ALTER TABLE poston_comments ADD COLUMN commentid  VARCHAR(25) NOT NULL DEFAULT '0'");
        }
        if (i < 77) {
            sQLiteDatabase.execSQL("ALTER TABLE specialbuddy ADD COLUMN usertype INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN usertype INTEGER DEFAULT 0");
            C2186al.m9765a(sQLiteDatabase);
        }
        if (i < 78) {
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN rank INTEGER");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN targetiso2 VARCHAR(25)");
        }
        if (i < 79) {
            sQLiteDatabase.execSQL("ALTER TABLE appmanage ADD COLUMN messageTypeFlag TEXT");
        }
        if (i < 80) {
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8133O);
        }
        if (i < 81) {
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8162v);
        }
        if (i < 82) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_phonenumber_external_use TEXT DEFAULT ''");
            C2190d.m9831c(sQLiteDatabase);
        }
        if (i < 83) {
            try {
                C2183ai.m9750b(sQLiteDatabase);
            } catch (JSONException e2) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e2, f8063a);
                }
                throw new RuntimeException(e2);
            }
        }
        if (i < 84) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_coverstory_meta_id TEXT DEFAULT ''");
        }
        if (i < 85) {
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_is_read INTEGER DEFAULT 0");
            C2204r.m10053c(sQLiteDatabase);
        }
        if (i < 86) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_room_type INTEGER DEFAULT 0");
            C2198l.m9948c(sQLiteDatabase);
        }
        if (i < 87) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_contact_buddy TEXT DEFAULT '0'");
            sQLiteDatabase.delete("contacts", null, null);
        }
        if (i < 88) {
            C2717y.m11403f();
        }
        if (i < 89) {
            C4809aa.m18104a().m18125b("Setting push to talk", (Boolean) true);
        }
        if (i < 90) {
            sQLiteDatabase.delete("contacts", null, null);
            sQLiteDatabase.execSQL("ALTER TABLE contacts ADD COLUMN contacts_contact_id NUMBER DEFAULT '0'");
            sQLiteDatabase.delete("buddy", "buddy_contact_buddy = '1'", null);
        }
        if (i < 91) {
            sQLiteDatabase.execSQL("ALTER TABLE participant ADD COLUMN participants_sms_address TEXT");
        }
        if (i < 92) {
            C2188b.m9792b(sQLiteDatabase);
        }
        if (i < 93) {
            sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS trigger_inbox_before_delete");
            sQLiteDatabase.execSQL(InterfaceC2280bz.f8182a);
        }
        if (i < 94) {
            sQLiteDatabase.delete("contacts", null, null);
            sQLiteDatabase.delete("buddy", "buddy_contact_buddy = '1'", null);
        }
        if (i < 95) {
            sQLiteDatabase.delete("contacts", null, null);
            sQLiteDatabase.delete("buddy", "buddy_contact_buddy = '1'", null);
        }
        if (i < 96) {
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_is_ack INTEGER DEFAULT 0");
        }
        if (i < 97) {
            sQLiteDatabase.execSQL("ALTER TABLE download_item ADD COLUMN item_version INTEGER DEFAULT 0");
        }
        if (i < 98) {
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8135Q);
            C2174a.m9665a(sQLiteDatabase);
        }
        if (i < 99) {
            sQLiteDatabase.execSQL(InterfaceC2279by.f8179m);
            C2198l.m9950d(sQLiteDatabase);
        }
        if (i < 100) {
            sQLiteDatabase.execSQL("ALTER TABLE participant ADD COLUMN participants_account_info INTEGER NOT NULL DEFAULT 0");
        }
        if (i < 101) {
            sQLiteDatabase.execSQL("ALTER TABLE participant ADD COLUMN participants_user_type INTEGER NOT NULL DEFAULT 0");
            sQLiteDatabase.execSQL(InterfaceC2273bs.f8105n);
        }
        if (i < 102) {
        }
        if (i < 103) {
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8136R);
        }
        if (i < 104) {
            sQLiteDatabase.execSQL("ALTER TABLE my_poston ADD COLUMN order_msec INTEGER DEFAULT '0'");
        }
        if (i < 105) {
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8138T);
            C4809aa.m18104a().m18125b("buddy_sync_unknown_list", (Boolean) true);
        }
        if (i < 106) {
            sQLiteDatabase.execSQL("ALTER TABLE participant ADD COLUMN participants_read_time NUMBER NOT NULL DEFAULT 0");
            C2198l.m9941b(sQLiteDatabase);
        }
        if (i < 107) {
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8161u);
            C4809aa.m18107a("last_sync_time_get_mypage_information", (Long) 0L);
        }
        if (i < 108) {
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8137S);
        }
        if (i < 109) {
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8139U);
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8140V);
        }
        if (i < 110) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_cmas_thread_type INTEGER DEFAULT '0'");
        }
        if (i < 111) {
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8134P);
        }
        if (i < 112) {
            C2186al.m9770b(sQLiteDatabase);
        }
        if (i < 113) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_topic_type TEXT DEFAULT NULL");
        }
        if (i < 114) {
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_status INTEGER NOT NULL DEFAULT(" + String.valueOf(EnumC2216ad.UNDEFINED.m10083a()) + ")");
        }
        if (i < 115) {
        }
        if (i < 116) {
            Cursor cursorQuery = sQLiteDatabase.query("download_item", null, "item_type=? AND install=?", new String[]{EnumC2258bd.Font.m10123a(), Spam.ACTIVITY_REPORT}, null, null, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                C4809aa.m18106a("Downloaded_font_count", Integer.valueOf(cursorQuery.getCount()));
            } else {
                C4809aa.m18106a("Downloaded_font_count", (Integer) 0);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
        if (i < 117) {
            C4809aa.m18104a().m18125b("get_characterlist", (Boolean) false);
            sQLiteDatabase.execSQL("ALTER TABLE pluslist ADD COLUMN start_time INTEGER DEFAULT '0'");
            sQLiteDatabase.execSQL("ALTER TABLE pluslist ADD COLUMN end_time INTEGER DEFAULT '0'");
            sQLiteDatabase.execSQL("ALTER TABLE pluslist ADD COLUMN weburl TEXT DEFAULT ''");
            sQLiteDatabase.execSQL("ALTER TABLE pluslist ADD COLUMN banner_h TEXT DEFAULT ''");
            sQLiteDatabase.execSQL("ALTER TABLE pluslist ADD COLUMN banner_v TEXT DEFAULT ''");
            sQLiteDatabase.execSQL("ALTER TABLE pluslist ADD COLUMN menutype TEXT DEFAULT ''");
            sQLiteDatabase.execSQL("ALTER TABLE pluslist ADD COLUMN usertype INTEGER DEFAULT '0'");
            C2177ac.m9706a(sQLiteDatabase);
        }
        if (i < 118) {
            sQLiteDatabase.execSQL("ALTER TABLE pluslist ADD COLUMN sessionid TEXT DEFAULT ''");
        }
        if (i < 119) {
            sQLiteDatabase.execSQL("CREATE UNIQUE INDEX uniIndex ON pluslist ( id , menutype )");
        }
        if (i < 120) {
            C2198l.m9952e(sQLiteDatabase);
        }
        sQLiteDatabase.setTransactionSuccessful();
    }

    /* renamed from: b */
    private void m10132b(SQLiteDatabase sQLiteDatabase, int i, boolean z) {
        sQLiteDatabase.beginTransaction();
        if (i < 2) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_is_profile_updated CHAR(1) NOT NULL DEFAULT 'N'");
                sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_is_status_updated CHAR(1) NOT NULL DEFAULT 'N'");
            } finally {
                sQLiteDatabase.endTransaction();
                C4809aa.m18107a("get_all_unread_message_timestamp", Long.valueOf(0L));
            }
        }
        if (i < 3) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_is_new CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 4) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS memo");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS memo_sessions");
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8153m);
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8154n);
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
            C2198l.m9931a(sQLiteDatabase);
        }
        if (i < 9) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy_group ADD COLUMN group_is_new CHAR(1) NOT NULL DEFAULT 'Y'");
            sQLiteDatabase.execSQL("UPDATE buddy_group SET group_is_new = 'N'");
        }
        if (i < 10) {
            C1002i.m6065b();
        }
        if (i < 11) {
            C2204r.m10032a(sQLiteDatabase);
        }
        if (i < 12) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_extra_info VARCHAR(80)");
        }
        if (i < 13) {
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8164x);
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8166z);
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8120B);
        }
        if (i < 14) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS recommendee");
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8163w);
        }
        if (i < 15) {
            sQLiteDatabase.execSQL("ALTER TABLE anicon_package ADD COLUMN special INTEGER NOT NULL DEFAULT(0)");
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
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8123E);
        }
        if (i < 20) {
            sQLiteDatabase.execSQL("ALTER TABLE specialbuddy ADD COLUMN weburl VARCHAR(80)");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_web_url TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_last_timestamp NUMBER");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN weburl VARCHAR(80)");
            sQLiteDatabase.execSQL("ALTER TABLE specialbuddy ADD COLUMN isNew CHAR(1) DEFAULT 'Y'");
            sQLiteDatabase.execSQL("ALTER TABLE specialbuddy ADD COLUMN islike CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 22) {
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_is_truncated CHAR(1) NOT NULL DEFAULT 'N'");
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_is_file_upload INTEGER NOT NULL DEFAULT(" + String.valueOf(0) + ")");
            C2204r.m10047b(sQLiteDatabase);
            sQLiteDatabase.execSQL("DROP INDEX IF EXISTS msg_server_no_index");
            sQLiteDatabase.execSQL(InterfaceC2274bt.f8108b);
            sQLiteDatabase.execSQL(InterfaceC2274bt.f8109c);
        }
        if (i < 23) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_is_name_updated CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 24) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS theme");
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8122D);
            for (Skin skin : C3474r.m13823b(this.f8065c)) {
                sQLiteDatabase.execSQL(C5052r.m19199a("INSERT INTO ", "skin", "(", "skin_id", ",", "special", ",", "thumbnail_url", ",", "bg_type", ",", "expiration_date", ",", "install", ",", "new", ") VALUES (", "'", skin.f8579id, "',", skin.special, ",", "'", skin.thumbnailurl, "',", "'", skin.bgtype, "',", skin.expirationdate, ",", "1,", Spam.ACTIVITY_CANCEL, ")"));
            }
        }
        if (i < 25) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox_buddy_relation ADD COLUMN chat_type INTEGER NOT NULL DEFAULT '" + String.valueOf(EnumC2300t.UNKNOWN.m10210a()) + "'");
            sQLiteDatabase.execSQL("UPDATE inbox_buddy_relation SET chat_type = '" + String.valueOf(EnumC2300t.ONETOONE.m10210a()) + "'");
        }
        if (i < 26) {
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8125G);
        }
        if (i < 27) {
            try {
                C2188b.m9791a(sQLiteDatabase);
                C2183ai.m9748a(sQLiteDatabase);
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS anicon_package");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS skin");
            } catch (JSONException e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f8063a);
                }
                throw new RuntimeException(e);
            }
        }
        if (i < 28) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS memo");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS memo_sessions");
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8155o);
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8158r);
        }
        if (i < 29) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_is_entered CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 30) {
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN timestamp INTEGER NOT NULL DEFAULT(0)");
        }
        if (i < 32) {
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8131M);
        }
        if (i < 33 && !TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", "")) && TextUtils.isEmpty(C4809aa.m18104a().m18121a("chaton_id", ""))) {
            C4809aa.m18108a("chaton_id", C4809aa.m18104a().m18121a("msisdn", ""));
            C4904y.m18641c("DB chatonid : " + C4809aa.m18104a().m18121a("chaton_id", ""), getClass().getSimpleName());
            C4809aa.m18105a("upgrade_multi_device_version", (Boolean) true);
        }
        if (i < 34) {
            sQLiteDatabase.execSQL("ALTER TABLE specialbuddy ADD COLUMN tel VARCHAR(80)");
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN tel VARCHAR(80)");
        }
        if (i < 35) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN profile_url TEXT");
            sQLiteDatabase.execSQL("UPDATE inbox SET profile_url = 'NA'");
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_orginal_numbers TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_msisdns TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_multidevice CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 36) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_updated_timestamp TEXT");
            sQLiteDatabase.execSQL("UPDATE buddy SET buddy_updated_timestamp = 'NA'");
        }
        if (i < 37) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN lasst_session_merge_time NUMBER DEFAULT '0'");
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_old_session_id TEXT");
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8152l);
        }
        if (i < 38) {
            sQLiteDatabase.execSQL("ALTER TABLE recommendee ADD COLUMN chatonid TEXT");
        }
        if (i < 39) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_old_no TEXT");
            sQLiteDatabase.execSQL("CREATE TABLE inbox_session_id_mapping (inbox_session_id TEXT NOT NULL,inbox_old_session_id TEXT NOT NULL,UNIQUE (inbox_old_session_id) ON CONFLICT REPLACE);");
            sQLiteDatabase.execSQL("DELETE FROM inbox WHERE inbox_title IS NULL AND inbox_last_chat_type=12");
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_old_session_id TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN message_old_sender TEXT");
        }
        if (i < 40 && TextUtils.isEmpty(C4822an.m18257y()) && !TextUtils.isEmpty(C4809aa.m18104a().m18121a("msisdn", ""))) {
            String strM18236g = C4822an.m18236g();
            if (!TextUtils.isEmpty(strM18236g)) {
                strM18236g = strM18236g.toUpperCase();
            }
            C4809aa.m18108a("country_ISO", strM18236g);
        }
        if (i < 41) {
            m10134d();
        }
        if (i < 42) {
            C2190d.m9813a(sQLiteDatabase);
        }
        if (i < 43) {
            sQLiteDatabase.execSQL("ALTER TABLE download_item ADD COLUMN down_rank INTEGER");
            sQLiteDatabase.execSQL("ALTER TABLE download_item ADD COLUMN data1 TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE download_item ADD COLUMN data2 TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE download_item ADD COLUMN data3 TEXT");
        }
        if (i < 44) {
            sQLiteDatabase.execSQL("ALTER TABLE download_item ADD COLUMN newly_installed INTEGER DEFAULT '0'");
        }
        if (i < 45) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_original_name TEXT");
        }
        if (i < 46) {
            sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_using_contact_name CHAR(1) NOT NULL DEFAULT 'N'");
        }
        if (i < 47) {
            sQLiteDatabase.execSQL("ALTER TABLE inbox ADD COLUMN inbox_last_tid TEXT DEFAULT '0'");
        }
        if (i < 48) {
            sQLiteDatabase.execSQL("ALTER TABLE contacts ADD COLUMN conatct_normalized_number TEXT");
            C4809aa.m18104a().m18125b("buddy_delete_copied_contacts", (Boolean) true);
        }
        sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_sainfo TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_account_info INTEGER NOT NULL DEFAULT 0");
        sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_is_hide CHAR(1) NOT NULL DEFAULT 'N'");
        sQLiteDatabase.execSQL("ALTER TABLE buddy ADD COLUMN buddy_hanzitopinyin VARCHAR(80) NOT NULL DEFAULT ''");
        sQLiteDatabase.execSQL("ALTER TABLE participant ADD COLUMN participants_country_code TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE participant ADD COLUMN participants_is_auth CHAR(1)");
        sQLiteDatabase.execSQL("ALTER TABLE participant ADD COLUMN participants_status INTEGER");
        sQLiteDatabase.execSQL("ALTER TABLE poston_comments ADD COLUMN commentid  VARCHAR(25) NOT NULL DEFAULT '0'");
        sQLiteDatabase.execSQL("ALTER TABLE my_poston ADD COLUMN order_msec INTEGER DEFAULT '0'");
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
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8126H);
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8127I);
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8128J);
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8129K);
        sQLiteDatabase.execSQL(InterfaceC2280bz.f8183b);
        sQLiteDatabase.execSQL("CREATE TABLE message_notification (noti_inbox_no TEXT,noti_buddy_no TEXT,noti_message TEXT,noti_sent_time NUMBER,noti_message_id NUMBER,noti_chat_type INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE calllog (_id INTEGER PRIMARY KEY AUTOINCREMENT,calldate TEXT NOT NULL,duration INTEGER\tNOT NULL DEFAULT 0,calllogtype INTEGER\tNOT NULL DEFAULT 0,callmethod INTEGER NOT NULL DEFAULT 0,userno TEXT NOT NULL DEFAULT '',username TEXT,userid TEXT,phoneno TEXT,countrycode TEXT,groupcallkey INTEGER NOT NULL DEFAULT 0,rejectmsg TEXT,groupid INTEGER)");
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8156p);
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8157q);
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8159s);
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8160t);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS poston");
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8162v);
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8161u);
        sQLiteDatabase.execSQL(InterfaceC2278bx.f8132N);
        C2717y.m11402e();
        C2186al.m9765a(sQLiteDatabase);
        for (C3470n c3470n : C3470n.m13796a().values()) {
            c3470n.getClass();
            c3470n.getClass();
            c3470n.getClass();
            c3470n.getClass();
            c3470n.getClass();
            String strM19199a = C5052r.m19199a("INSERT INTO ", "download_item", " ( ", "reference_id", ", ", "item_id", ", ", "item_type", ", ", "name", ", ", "install", ", ", "expiration_time", ", ", "new", ", ", "special", ", ", "extras", ", ", "newly_installed", " ) values ( ", 0, ", ", "'", c3470n.f12948m, "'", ", ", "'", c3470n.f12940e, "'", ", ", "\"", c3470n.f12950o, "\"", ", ", 1, ", ", Long.MAX_VALUE, ", ", 0, ", ", c3470n.f12938c, ", ", "'", c3470n.f12952q, "'", ", ", 1, " ) ");
            C4904y.m18639b("execute. " + strM19199a, f8063a);
            sQLiteDatabase.execSQL(strM19199a);
        }
        C3470n.m13798b();
        if (i < 80) {
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8133O);
        }
        if (i < 83) {
            sQLiteDatabase.execSQL(InterfaceC2278bx.f8135Q);
            C2174a.m9665a(sQLiteDatabase);
        }
        sQLiteDatabase.setTransactionSuccessful();
        m10133c();
    }

    /* renamed from: c */
    private void m10133c() {
        SharedPreferences sharedPreferences = this.f8065c.getSharedPreferences("password_lock", 0);
        if (sharedPreferences != null && sharedPreferences.contains("app_lock_state")) {
            SharedPreferences.Editor editorEdit = this.f8065c.getSharedPreferences("PASSWORD_LOCK", 0).edit();
            editorEdit.putString("LOCK_STATE", sharedPreferences.getString("app_lock_state", C4892m.m18588h()));
            editorEdit.putString("PASSWORD", sharedPreferences.getString("app_lock_password", "0000"));
            editorEdit.putString("PASSWORD_HINT", sharedPreferences.getString("password_hint", ""));
            editorEdit.commit();
            sharedPreferences.edit().clear().commit();
        }
    }

    /* renamed from: d */
    private void m10134d() {
        AccountManager accountManager = AccountManager.get(CommonApplication.m18732r());
        String strM18121a = C4809aa.m18104a().m18121a("msisdn", "");
        String strM18121a2 = C4809aa.m18104a().m18121a("samsung_account_email", "");
        String strM18121a3 = C4809aa.m18104a().m18121a("uid", "");
        Account[] accountsByType = accountManager.getAccountsByType(Config.CHATON_PACKAGE_NAME);
        if (accountsByType.length <= 0 && C4809aa.m18104a().m18129b("uid")) {
            if (!TextUtils.isEmpty(strM18121a)) {
                m10130a(strM18121a, strM18121a3, false);
                return;
            } else {
                if (!TextUtils.isEmpty(strM18121a2)) {
                    m10130a(strM18121a2, strM18121a3, true);
                    return;
                }
                return;
            }
        }
        if (accountsByType.length > 0 && C4809aa.m18104a().m18129b("uid") && !TextUtils.isEmpty(strM18121a) && ContentResolver.getIsSyncable(accountsByType[0], "com.android.contacts") <= 0) {
            ContentResolver.setIsSyncable(accountsByType[0], "com.android.contacts", 1);
            ContentResolver.setSyncAutomatically(accountsByType[0], "com.android.contacts", true);
        }
    }

    /* renamed from: a */
    private void m10130a(String str, String str2, boolean z) {
        Account account = new Account("ChatON", Config.CHATON_PACKAGE_NAME);
        AccountManager.get(CommonApplication.m18732r()).addAccountExplicitly(account, str2, null);
        if (z) {
            ContentResolver.setIsSyncable(account, "com.android.contacts", 0);
        } else {
            ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Log.i("ChatON", "[DatabaseHelper] Upgrading from : " + i + " to : " + i2);
        if (C2349a.m10301a("tabletdb_interg_feature") && i < 49) {
            m10132b(sQLiteDatabase, i, false);
            i = 81;
        }
        m10129a(sQLiteDatabase, i, false);
    }

    /* renamed from: e */
    private String m10135e() {
        String strM18121a = C4809aa.m18104a().m18121a("country_name", (String) null);
        if (strM18121a == null) {
            return null;
        }
        if (strM18121a.equals("Aland Islands")) {
            return "Aland Islands";
        }
        if (strM18121a.equals("Argentina")) {
            return "Argentine Republic";
        }
        if (strM18121a.equals("Azerbaijan")) {
            return "Republic of Azerbaijan";
        }
        if (strM18121a.equals("Congo")) {
            return "Republic of the Congo";
        }
        if (strM18121a.equals("Cote d'Ivoire")) {
            return "Cote d'Ivoire";
        }
        if (strM18121a.equals("Gabon")) {
            return "Gabonese Republic";
        }
        if (strM18121a.equals("Guinea-bissau")) {
            return "Guinea-Bissau";
        }
        if (strM18121a.equals("Kyrgyzstan")) {
            return "Kyrgyz Republic";
        }
        if (strM18121a.equals("Macedonia")) {
            return "Republic of Macedonia";
        }
        if (strM18121a.equals("Reunion")) {
            return "Reunion";
        }
        if (strM18121a.equals("Rwanda")) {
            return "Republic of Rwanda";
        }
        if (strM18121a.equals("Sao Tome and Principe")) {
            return "Sao Tome and Principe";
        }
        if (strM18121a.equals("Svalbard and Jan Mayen Islands")) {
            return "Svalbard and Jan Mayen";
        }
        if (strM18121a.equals("Togo")) {
            return "Togolese Republic";
        }
        if (strM18121a.equals("United States")) {
            return "United States of America";
        }
        if (strM18121a.equals("US Virgin Islands")) {
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
    public static void m10131b() throws IOException {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Log.i("TEST", "copyDatabaseToSdcard start");
        try {
            fileInputStream = new FileInputStream(CommonApplication.m18732r().getDatabasePath(m10127a()));
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
