package com.sds.coolots.common.controller;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import java.io.File;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class DatabaseHelper extends AbstractC1241a {
    public static final String BUDDYGROUP_TABLE = "buddygroup";
    public static final String BUDDY_TABLE = "buddy";
    public static final String CALLLOG_TABLE = "calllog";
    public static final int DATABASE_VER = 24;
    public static final String DATAUSAGE_TABLE = "datausage";
    public static final String GROUPBUDDYMAP_TABLE = "groupbuddymap";
    public static final String IDNUMBER_TABLE = "idnumber";
    public static final int INDEX_BUDDYGROUP_GROUPID = 2;
    public static final int INDEX_BUDDYGROUP_GROUPNAME = 1;
    public static final int INDEX_BUDDYGROUP_IMAGEUPDATEDATE = 3;
    public static final int INDEX_BUDDYGROUP_ROWID = 0;
    public static final int INDEX_BUDDYGROUP_UPDATETDATE = 4;
    public static final int INDEX_BUDDY_ACCOUNTID = 3;
    public static final int INDEX_BUDDY_BLOCK = 14;
    public static final int INDEX_BUDDY_BUDDYNAME = 7;
    public static final int INDEX_BUDDY_COUNTRYCODE = 10;
    public static final int INDEX_BUDDY_DISPLAYNAME = 4;
    public static final int INDEX_BUDDY_EDITEDNAME = 5;
    public static final int INDEX_BUDDY_FAVORITE = 13;
    public static final int INDEX_BUDDY_FIRSTNUMBER = 12;
    public static final int INDEX_BUDDY_FRESHBUDDY = 16;
    public static final int INDEX_BUDDY_HIDE = 15;
    public static final int INDEX_BUDDY_IMAGEUPDATEDATE = 20;
    public static final int INDEX_BUDDY_MESSAGE = 8;
    public static final int INDEX_BUDDY_NATIONALCODE = 11;
    public static final int INDEX_BUDDY_NATIVENAME = 6;
    public static final int INDEX_BUDDY_PRESENCE = 17;
    public static final int INDEX_BUDDY_REGION = 9;
    public static final int INDEX_BUDDY_REMOVED = 19;
    public static final int INDEX_BUDDY_ROWID = 0;
    public static final int INDEX_BUDDY_SUGGESTION = 18;
    public static final int INDEX_BUDDY_UPDATEDATE = 21;
    public static final int INDEX_BUDDY_USERID = 2;
    public static final int INDEX_BUDDY_USERNO = 1;
    public static final int INDEX_GROUPBUDDYMAP_GROUPID = 1;
    public static final int INDEX_GROUPBUDDYMAP_ROWID = 0;
    public static final int INDEX_GROUPBUDDYMAP_UPDATETDATE = 3;
    public static final int INDEX_GROUPBUDDYMAP_USERNO = 2;
    public static final int INDEX_IDNUMBER_PHONENO = 3;
    public static final int INDEX_IDNUMBER_ROWID = 0;
    public static final int INDEX_IDNUMBER_USERID = 2;
    public static final int INDEX_IDNUMBER_USERNO = 1;
    public static final int INDEX_MYNUMBER_PHONENO = 1;
    public static final int INDEX_MYNUMBER_PRIVACY = 2;
    public static final int INDEX_MYNUMBER_ROWID = 0;
    public static final int INDEX_NATIONALCODE_AREACODE = 6;
    public static final int INDEX_NATIONALCODE_COUNTRYCODE = 5;
    public static final int INDEX_NATIONALCODE_ISO2 = 1;
    public static final int INDEX_NATIONALCODE_MCC = 2;
    public static final int INDEX_NATIONALCODE_NAMEENG = 4;
    public static final int INDEX_NATIONALCODE_NAMEKOR = 3;
    public static final int INDEX_NATIONALCODE_ROWID = 0;
    public static final int INDEX_NATIONALCODE_ZEROSPACE = 7;
    public static final int INDEX_REGIONCODE_CODE = 1;
    public static final int INDEX_REGIONCODE_ROWID = 0;
    public static final int INDEX_REGIONCODE_URL = 2;
    public static final String KEY_3G_TOTAL = "data_total";
    public static final String KEY_ACCOUNTID = "accountid";
    public static final String KEY_AREACODE = "areacode";
    public static final String KEY_BLOCK = "block";
    public static final String KEY_BUDDYNAME = "buddyname";
    public static final String KEY_CALLCOUNT = "callcount";
    public static final String KEY_CALLDATE = "calldate";
    public static final String KEY_CALLLOGTYPE = "calllogtype";
    public static final String KEY_CALLMETHOD = "callmethod";
    public static final String KEY_COUNTRYCODE = "countrycode";
    public static final String KEY_DIALLED_VIDEO = "dialled_video";
    public static final String KEY_DIALLED_VOICE = "dialled_voice";
    public static final String KEY_DISPLAYNAME = "displayname";
    public static final String KEY_DURATION = "duration";
    public static final String KEY_EDITEDNAME = "editedname";
    public static final String KEY_FAVORITE = "favorite";
    public static final String KEY_FIRSTNUMBER = "firstnumber";
    public static final String KEY_FRESHBUDDY = "freshbuddy";
    public static final String KEY_GROUPCALLKEY = "groupcallkey";
    public static final String KEY_GROUPID = "groupid";
    public static final String KEY_GROUPNAME = "groupname";
    public static final String KEY_HANGUPCODE = "hangupcode";
    public static final String KEY_HIDE = "hide";
    public static final String KEY_IMAGEUPDATEDATE = "imageupdatedate";
    public static final String KEY_ISO2 = "iso2";
    public static final String KEY_LAST_VIDEO = "last_video";
    public static final String KEY_LAST_VOICE = "last_voice";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_NAMEENG = "nameeng";
    public static final String KEY_NAMEKOR = "namekor";
    public static final String KEY_NATIONALCODE = "nationalcode";
    public static final String KEY_NATIVENAME = "nativename";
    public static final String KEY_PHONENO = "phoneno";
    public static final String KEY_PRESENCE = "presence";
    public static final String KEY_PRIVACY = "privacy";
    public static final String KEY_RECV_VIDEO = "recv_video";
    public static final String KEY_RECV_VOICE = "recv_voice";
    public static final String KEY_REGION = "region";
    public static final String KEY_REGIONCODE = "code";
    public static final String KEY_REGIONURL = "url";
    public static final String KEY_REJECTMSG = "rejectmsg";
    public static final String KEY_REMOVED = "removed";
    public static final String KEY_ROWID = "_id";
    public static final String KEY_STARTDATE = "startdate";
    public static final String KEY_SUGGESTION = "suggestion";
    public static final String KEY_UPDATEDATE = "updatedate";
    public static final String KEY_USERID = "userid";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_USERNO = "userno";
    public static final String KEY_WIFI_TOTAL = "wifi_total";
    public static final String KEY_W_DIALLED_VIDEO = "wifi_dialled_video";
    public static final String KEY_W_DIALLED_VOICE = "wifi_dialled_voice";
    public static final String KEY_W_LAST_VIDEO = "wifi_last_video";
    public static final String KEY_W_LAST_VOICE = "wifi_last_voice";
    public static final String KEY_W_RECV_VIDEO = "wifi_recv_video";
    public static final String KEY_W_RECV_VOICE = "wifi_recv_voice";
    public static final String MYNUMBER_TABLE = "mynumber";
    public static final String NATIONALCODE_TABLE = "nationalcode";
    public static final String REGIONCODE_TABLE = "regioncode";

    /* renamed from: a */
    private static final String f2907a = "[DatabaseHelper]";

    /* renamed from: b */
    private static final String f2908b = "CREATE TABLE IF NOT EXISTS buddy( _id\t\t\tINTEGER PRIMARY KEY AUTOINCREMENT,userno\t\t\tINTEGER\t, userid\t\t\tTEXT\t, accountid\t\tTEXT\t, displayname\tTEXT\t, editedname\t\tTEXT\t, nativename\t\tTEXT\t, buddyname\t\tTEXT\t, message\t\tTEXT\t, region\t\t\tTEXT\t, countrycode\tTEXT\t, nationalcode\tTEXT\t, firstnumber\tTEXT\t, favorite\t\tINTEGER , block \t\t\tINTEGER , hide \t\t\tINTEGER , freshbuddy\t\tINTEGER DEFAULT 1 not null\t, presence \t\tINTEGER , suggestion \tINTEGER , removed\t\tINTEGER , imageupdatedate\tINTEGER , updatedate\t\t\tINTEGER ) ";

    /* renamed from: c */
    private static final String f2909c = "CREATE TABLE IF NOT EXISTS idnumber( _id\t\t\tINTEGER PRIMARY KEY AUTOINCREMENT, userno\t\t\tINTEGER , userid\t\t\tTEXT , phoneno\t\tTEXT  ) ";

    /* renamed from: d */
    private static final String f2910d = "CREATE TABLE IF NOT EXISTS nationalcode( _id \t\t\tINTEGER PRIMARY KEY AUTOINCREMENT, iso2\t\t\tTEXT\tnot null, mcc\t\t\tTEXT\tnot null, namekor\t\tTEXT\tnot null, nameeng\t\tTEXT\tnot null, countrycode\tTEXT\tnot null, areacode\t\tTEXT\t\t\t, zero_space     INTEGER ) ";

    /* renamed from: e */
    private static final String f2911e = "CREATE TABLE IF NOT EXISTS buddygroup( _id\t\t\tINTEGER PRIMARY KEY AUTOINCREMENT, groupname\t\tTEXT , groupid\t\tINTEGER , imageupdatedate\t\tINTEGER , updatedate\t\tINTEGER ) ";

    /* renamed from: f */
    private static final String f2912f = "CREATE TABLE IF NOT EXISTS groupbuddymap( _id\t\t\tINTEGER PRIMARY KEY AUTOINCREMENT, groupid\t\tINTEGER , userno\t\t\tINTEGER , updatedate\t\tINTEGER ) ";

    /* renamed from: g */
    private static final String f2913g = "CREATE TABLE IF NOT EXISTS calllog( _id \t\t\tINTEGER PRIMARY KEY AUTOINCREMENT, calldate\t\tTEXT \tnot null, duration\t\tINTEGER\tDEFAULT 0 not null, calllogtype\tINTEGER\tDEFAULT 0 not null, callmethod\t\tINTEGER\tDEFAULT 0 not null, userno\t\t\tINTEGER\tDEFAULT 0 not null, username\t\tTEXT\t\t\t, userid\t\t\tTEXT\t\t\t, phoneno\t\tTEXT\t        , countrycode\tTEXT\t        , groupcallkey\tINTEGER\tDEFAULT 0 not null, hangupcode\t\tINTEGER\t        , rejectmsg\t\tTEXT\t\t\t, groupid\t\tINTEGER\t\t\t) ";

    /* renamed from: h */
    private static final String f2914h = "CREATE TABLE IF NOT EXISTS mynumber( _id\t\t\tINTEGER PRIMARY KEY AUTOINCREMENT, phoneno\t\tINTEGER\tnot null, privacy\t\tINTEGER ) \t\t  ";

    /* renamed from: i */
    private static final String f2915i = "CREATE TABLE IF NOT EXISTS regioncode( _id\t\t\tINTEGER PRIMARY KEY AUTOINCREMENT, code\t\t\tINTEGER , url\t\t\tTEXT  ) ";

    /* renamed from: j */
    private static final String f2916j = "CREATE TABLE IF NOT EXISTS datausage( _id\t\t\tINTEGER PRIMARY KEY AUTOINCREMENT, startdate\tINTEGER , dialled_voice\tINTEGER , dialled_video   INTEGER , recv_voice   INTEGER , recv_video   INTEGER , last_voice   INTEGER , last_video   INTEGER , data_total   INTEGER\tDEFAULT 0 not null, wifi_dialled_voice\t  INTEGER , wifi_dialled_video   INTEGER , wifi_recv_voice   INTEGER , wifi_recv_video   INTEGER , wifi_last_voice   INTEGER , wifi_last_video   INTEGER , wifi_total   INTEGER\tDEFAULT 0 not null ) ";

    /* renamed from: k */
    private static final String f2917k = "vappbuddy.db";
    public static boolean isNeededBuddyUpdateDate = false;
    public static boolean isNeedDBUpgrade = false;

    public DatabaseHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
        super(context, str, cursorFactory, 24);
        Log.m2958e("[DatabaseHelper] create finish!!! isNeedDBUpgrade = " + isNeedDBUpgrade);
        try {
            if (isNeedDBUpgrade) {
                m2845c(SQLiteDatabase.openDatabase(MainApplication.mContext.getDatabasePath(f2917k).toString(), null, 0));
                isNeedDBUpgrade = false;
            }
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                m2841b(stackTraceElement.toString());
            }
        }
    }

    /* renamed from: a */
    private void m2839a() {
        m2842c(MainApplication.mFilePathInfo.getGroupImagePath());
        m2842c(MainApplication.mFilePathInfo.getBuddyImagePath());
        m2842c(MainApplication.mFilePathInfo.getMyProfileImagePath());
        m2842c(MainApplication.mFilePathInfo.getImageFolderPath());
    }

    /* renamed from: a */
    private void m2840a(String str) {
        Log.m2958e(f2907a + str);
    }

    /* renamed from: b */
    private void m2841b(String str) {
        Log.m2963i(f2907a + str);
    }

    /* renamed from: c */
    private void m2842c(String str) {
        File file = new File(str);
        String[] list = file.list();
        if (list != null) {
            for (String str2 : list) {
                File file2 = new File(String.valueOf(str) + str2);
                if (file2.isDirectory()) {
                    m2842c(String.valueOf(str) + str2 + "/");
                } else {
                    file2.delete();
                }
            }
        }
        file.delete();
    }

    public static void onCreateTable(SQLiteDatabase sQLiteDatabase, ReentrantLock reentrantLock) {
        reentrantLock.lock();
        sQLiteDatabase.beginTransaction();
        try {
            Log.m2958e("<<YHT2>> DatabaseHelper!!! onCreate is executed!!");
            if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                sQLiteDatabase.execSQL(f2916j);
                sQLiteDatabase.execSQL("CREATE UNIQUE INDEX DATAUSAGE_IDX1 ON datausage(startdate)");
            } else {
                sQLiteDatabase.execSQL(f2908b);
                sQLiteDatabase.execSQL(f2909c);
                sQLiteDatabase.execSQL(f2910d);
                sQLiteDatabase.execSQL(f2911e);
                sQLiteDatabase.execSQL(f2912f);
                sQLiteDatabase.execSQL(f2913g);
                sQLiteDatabase.execSQL(f2914h);
                sQLiteDatabase.execSQL(f2915i);
                sQLiteDatabase.execSQL(f2916j);
                sQLiteDatabase.execSQL("CREATE INDEX BUDDY_IDX1 ON buddy(displayname)");
                sQLiteDatabase.execSQL("CREATE UNIQUE INDEX BUDDY_IDX2 ON buddy(userno)");
                sQLiteDatabase.execSQL("CREATE INDEX GROUP_IDX1 ON buddygroup(groupname)");
                sQLiteDatabase.execSQL("CREATE UNIQUE INDEX GROUP_IDX2 ON buddygroup(groupid)");
                sQLiteDatabase.execSQL("CREATE UNIQUE INDEX DATAUSAGE_IDX1 ON datausage(startdate)");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                Log.m2963i(f2907a + stackTraceElement.toString());
            }
        } finally {
            sQLiteDatabase.endTransaction();
            reentrantLock.unlock();
        }
    }

    @Override // com.sds.coolots.common.controller.AbstractC1241a
    /* renamed from: a */
    public void mo2843a(SQLiteDatabase sQLiteDatabase) {
        MainApplication.mPhoneManager.lockDatabaseLock();
        sQLiteDatabase.beginTransaction();
        try {
            if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS datausage");
            } else {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS buddy");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS idnumber");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS buddygroup");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS groupbuddymap");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS calllog");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS mynumber");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS regioncode");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS datausage");
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
            MainApplication.mPhoneManager.releaseDatabaseLock();
        }
    }

    @Override // com.sds.coolots.common.controller.AbstractC1241a
    /* renamed from: b */
    public void mo2844b(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS datausage");
            } else {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS buddy");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS idnumber");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS nationalcode");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS buddygroup");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS groupbuddymap");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS calllog");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS mynumber");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS regioncode");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS datausage");
            }
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                m2841b(stackTraceElement.toString());
            }
        }
        MainApplication.mConfig.setNationalCodeVersion("");
        onCreate(sQLiteDatabase);
    }

    /* renamed from: c */
    public void m2845c(SQLiteDatabase sQLiteDatabase) throws SQLException {
        Log.m2958e("<<YHT2>> DatabaseHelper!!! onUpgrade is executed!!");
        mo2844b(sQLiteDatabase);
        m2839a();
        isNeededBuddyUpdateDate = true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        onCreateTable(sQLiteDatabase, MainApplication.mPhoneManager.getDataBaseLock());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        m2845c(sQLiteDatabase);
    }
}
