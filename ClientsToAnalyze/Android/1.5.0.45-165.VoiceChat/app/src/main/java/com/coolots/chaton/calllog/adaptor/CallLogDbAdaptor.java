package com.coolots.chaton.calllog.adaptor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.DatabaseHelper;
import com.sds.coolots.common.util.ContentValuesUtil;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.p018a.C1265a;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CallLogDbAdaptor {
    private static final String CLASSNAME = "[CallLogDbAdaptor]";
    public static final int SEARCH_ALL_GROUP_CALLS = 4;
    public static final int SEARCH_ALL_LOGS = 0;
    public static final int SEARCH_ALL_SINGLE_CALLS = 3;
    public static final int SEARCH_ALL_VIDEO_CALLS = 2;
    public static final int SEARCH_ALL_VOICE_CALLS = 1;
    public static final int SEARCH_DIALED_CALLS = 6;
    public static final int SEARCH_MISSED_CALLS = 5;
    public static final int SEARCH_RECEIVED_CALLS = 7;
    public static final int SEARCH_REJECTED_CALLS = 8;
    public static final int SEARCH_REJECTED_MESSAGES = 9;
    public static final int SELECT_ALL_CALLLOG_FIELDS = 10;
    public static final int SELECT_THREE_TABLES_JOINED = 12;
    public static final int SELECT_TWO_TABLES_JOINED = 11;
    private SQLiteDatabase mDb = null;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public CallLogDbAdaptor(Context context) throws SQLException {
        open();
    }

    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public void open() throws SQLException {
        this.mDb = MainApplication.mPhoneManager.getDatabase();
    }

    public void close() {
    }

    public boolean checkDatabase(SQLiteDatabase database, Object obj) {
        return (database == null || !database.isOpen() || obj == null) ? false : true;
    }

    public boolean checkDatabase(SQLiteDatabase database) {
        return database != null && database.isOpen();
    }

    public synchronized long createCallLog(ContentValues value) {
        return !checkDatabase(this.mDb, value) ? -1L : this.mDb.insert(DatabaseHelper.CALLLOG_TABLE, null, value);
    }

    public synchronized int createCallLogList(ArrayList<ContentValues> values) {
        int i;
        int ret = 0;
        if (checkDatabase(this.mDb, values)) {
            try {
                try {
                    MainApplication.mPhoneManager.lockDatabaseLock();
                    this.mDb.beginTransaction();
                    for (int i2 = 0; i2 < values.size(); i2++) {
                        ContentValues value = values.get(i2);
                        this.mDb.insert(DatabaseHelper.CALLLOG_TABLE, null, value);
                    }
                    this.mDb.setTransactionSuccessful();
                } finally {
                    this.mDb.endTransaction();
                    MainApplication.mPhoneManager.releaseDatabaseLock();
                }
            } catch (Exception e) {
                e.printStackTrace();
                ret = -1;
                this.mDb.endTransaction();
                MainApplication.mPhoneManager.releaseDatabaseLock();
            }
            i = ret;
        } else {
            i = -1;
        }
        return i;
    }

    public synchronized int deleteCallLog(ContentValues where) {
        int iDelete;
        if (checkDatabase(this.mDb, where)) {
            String strWhere = ContentValuesUtil.getStringByContentValuesForWhere(where, null);
            iDelete = this.mDb.delete(DatabaseHelper.CALLLOG_TABLE, strWhere, null);
        } else {
            iDelete = -1;
        }
        return iDelete;
    }

    public synchronized int updateCallLog(ContentValues value, int targetRowId) {
        String strWhere;
        strWhere = "_id=" + targetRowId;
        return this.mDb.update(DatabaseHelper.CALLLOG_TABLE, value, strWhere, null);
    }

    public synchronized int deleteOldestCallLog(boolean isGroupCallLog) {
        String strWhere;
        int iDelete;
        if (checkDatabase(this.mDb)) {
            if (isGroupCallLog) {
                strWhere = "_id IN (SELECT _id FROM calllog WHERE groupcallkey=(SELECT MAX(groupcallkey) FROM calllog))";
            } else {
                strWhere = "_id=(SELECT MIN(_id) FROM calllog)";
            }
            iDelete = this.mDb.delete(DatabaseHelper.CALLLOG_TABLE, strWhere, null);
        } else {
            iDelete = -1;
        }
        return iDelete;
    }

    public String getSelectClause(int type, String aliasA, String aliasB, String aliasC) {
        String prefixA = "";
        String prefixB = "";
        String prefixC = "";
        if (aliasA != null) {
            prefixA = String.valueOf(aliasA) + ".";
        }
        if (aliasB != null) {
            prefixB = String.valueOf(aliasB) + ".";
        }
        if (aliasC != null) {
            prefixC = String.valueOf(aliasC) + ".";
        }
        switch (type) {
            case 10:
                String selectClause = "SELECT " + prefixA + DatabaseHelper.KEY_ROWID + " " + DatabaseHelper.KEY_ROWID + ", " + prefixA + DatabaseHelper.KEY_CALLDATE + " " + DatabaseHelper.KEY_CALLDATE + ", " + prefixA + DatabaseHelper.KEY_USERNO + " " + DatabaseHelper.KEY_USERNO + ", " + prefixA + DatabaseHelper.KEY_USERID + " " + DatabaseHelper.KEY_USERID + ", " + prefixA + DatabaseHelper.KEY_USERNAME + " " + DatabaseHelper.KEY_USERNAME + ", " + prefixA + DatabaseHelper.KEY_PHONENO + " " + DatabaseHelper.KEY_PHONENO + ", " + prefixA + DatabaseHelper.KEY_DURATION + " " + DatabaseHelper.KEY_DURATION + ", " + prefixA + DatabaseHelper.KEY_CALLLOGTYPE + " " + DatabaseHelper.KEY_CALLLOGTYPE + ", " + prefixA + DatabaseHelper.KEY_CALLMETHOD + " " + DatabaseHelper.KEY_CALLMETHOD + ", " + prefixA + "countrycode countrycode, " + prefixA + DatabaseHelper.KEY_GROUPCALLKEY + " " + DatabaseHelper.KEY_GROUPCALLKEY + ", " + prefixA + DatabaseHelper.KEY_HANGUPCODE + " " + DatabaseHelper.KEY_HANGUPCODE + ", " + prefixA + DatabaseHelper.KEY_REJECTMSG + " " + DatabaseHelper.KEY_REJECTMSG + ", " + prefixA + DatabaseHelper.KEY_GROUPID + " " + DatabaseHelper.KEY_GROUPID;
                return selectClause;
            case 11:
                if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                    String selectClause2 = "SELECT " + prefixA + DatabaseHelper.KEY_ROWID + " " + DatabaseHelper.KEY_ROWID + ", " + prefixA + DatabaseHelper.KEY_CALLDATE + " " + DatabaseHelper.KEY_CALLDATE + ", " + prefixA + DatabaseHelper.KEY_USERNO + " " + DatabaseHelper.KEY_USERNO + ", " + prefixA + DatabaseHelper.KEY_USERID + " " + DatabaseHelper.KEY_USERID + ", " + prefixA + DatabaseHelper.KEY_USERNAME + " " + DatabaseHelper.KEY_USERNAME + ", " + prefixA + DatabaseHelper.KEY_DURATION + " " + DatabaseHelper.KEY_DURATION + ", " + prefixA + DatabaseHelper.KEY_CALLLOGTYPE + " " + DatabaseHelper.KEY_CALLLOGTYPE + ", " + prefixA + DatabaseHelper.KEY_CALLMETHOD + " " + DatabaseHelper.KEY_CALLMETHOD + ", " + prefixA + DatabaseHelper.KEY_GROUPCALLKEY + " " + DatabaseHelper.KEY_GROUPCALLKEY + ", " + prefixA + DatabaseHelper.KEY_REJECTMSG + " " + DatabaseHelper.KEY_REJECTMSG + ", " + prefixA + DatabaseHelper.KEY_GROUPID + " " + DatabaseHelper.KEY_GROUPID;
                    return selectClause2;
                }
                String selectClause3 = "SELECT " + prefixA + DatabaseHelper.KEY_ROWID + " " + DatabaseHelper.KEY_ROWID + ", " + prefixA + DatabaseHelper.KEY_CALLDATE + " " + DatabaseHelper.KEY_CALLDATE + ", " + prefixA + DatabaseHelper.KEY_USERNO + " " + DatabaseHelper.KEY_USERNO + ", " + prefixA + DatabaseHelper.KEY_USERID + " " + DatabaseHelper.KEY_USERID + ", " + prefixA + DatabaseHelper.KEY_USERNAME + " " + DatabaseHelper.KEY_USERNAME + ", " + prefixB + DatabaseHelper.KEY_DISPLAYNAME + " " + DatabaseHelper.KEY_DISPLAYNAME + ", " + prefixB + "message message, " + prefixA + DatabaseHelper.KEY_DURATION + " " + DatabaseHelper.KEY_DURATION + ", " + prefixA + DatabaseHelper.KEY_CALLLOGTYPE + " " + DatabaseHelper.KEY_CALLLOGTYPE + ", " + prefixA + DatabaseHelper.KEY_CALLMETHOD + " " + DatabaseHelper.KEY_CALLMETHOD + ", " + prefixA + DatabaseHelper.KEY_GROUPCALLKEY + " " + DatabaseHelper.KEY_GROUPCALLKEY + ", " + prefixA + DatabaseHelper.KEY_REJECTMSG + " " + DatabaseHelper.KEY_REJECTMSG + ", " + prefixA + DatabaseHelper.KEY_GROUPID + " " + DatabaseHelper.KEY_GROUPID;
                return selectClause3;
            case 12:
                String selectClause4 = "SELECT DISTINCT " + prefixA + DatabaseHelper.KEY_GROUPNAME + ", " + prefixA + DatabaseHelper.KEY_GROUPID + ", " + prefixB + DatabaseHelper.KEY_USERNO + ", " + prefixC + DatabaseHelper.KEY_USERNAME;
                return selectClause4;
            default:
                return "";
        }
    }

    public Cursor selectCallLog(ContentValues where) {
        if (!checkDatabase(this.mDb)) {
            return null;
        }
        String strWhere = ContentValuesUtil.getStringByContentValuesForWhere(where, null);
        String sql = String.valueOf(getSelectClause(11, "a", "b", null)) + " FROM " + DatabaseHelper.CALLLOG_TABLE + " a left outer join buddy b  on a." + DatabaseHelper.KEY_USERID + " = b." + DatabaseHelper.KEY_USERID + " ORDER BY a." + DatabaseHelper.KEY_ROWID + " DESC";
        if (strWhere != null && !strWhere.isEmpty()) {
            sql = "SELECT * FROM ( " + sql + " ) WHERE " + strWhere;
        }
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectCallLog(ArrayList<Integer> idList) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < idList.size(); i++) {
            if (i == 0) {
                buffer.append("a._id=" + idList.get(i));
            } else {
                buffer.append(" OR a._id=" + idList.get(i));
            }
        }
        String where = buffer.toString();
        String sql = String.valueOf(getSelectClause(11, "a", "b", null)) + " FROM " + DatabaseHelper.CALLLOG_TABLE + " a left outer join buddy b  on a." + DatabaseHelper.KEY_USERID + " = b." + DatabaseHelper.KEY_USERID + C1265a.f3172e + where + " ORDER by " + DatabaseHelper.KEY_ROWID + " DESC;";
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectGroupInfo() {
        if (MainApplication.mPhoneManager.IsLinkagewithChatON() || !checkDatabase(this.mDb)) {
            return null;
        }
        String sql = String.valueOf(getSelectClause(12, "a", "b", "c")) + " FROM " + DatabaseHelper.BUDDYGROUP_TABLE + " a JOIN " + DatabaseHelper.GROUPBUDDYMAP_TABLE + " b JOIN " + DatabaseHelper.CALLLOG_TABLE + " c ON a." + DatabaseHelper.KEY_GROUPID + " = b." + DatabaseHelper.KEY_GROUPID + " AND b." + DatabaseHelper.KEY_USERNO + " = c." + DatabaseHelper.KEY_USERNO;
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectIndexOfCallLog() {
        if (checkDatabase(this.mDb)) {
            return this.mDb.rawQuery("SELECT SEQ FROM SQLITE_SEQUENCE WHERE NAME = 'calllog'", null);
        }
        return null;
    }

    public Cursor selectIndexOfCallLog(String userid, int groupcallkey) {
        if (!checkDatabase(this.mDb)) {
            return null;
        }
        String sql = "SELECT _id FROM calllog WHERE userid='" + userid + "' AND " + DatabaseHelper.KEY_GROUPCALLKEY + "=" + groupcallkey;
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectOldestGroupCallKey() {
        if (checkDatabase(this.mDb)) {
            return this.mDb.rawQuery("SELECT groupcallkey FROM calllog WHERE _id= (SELECT MIN(_id) FROM calllog)", null);
        }
        return null;
    }

    public Cursor selectCountCallLog() {
        if (checkDatabase(this.mDb)) {
            return this.mDb.rawQuery("SELECT COUNT(*) AS num FROM calllog", null);
        }
        return null;
    }

    public Cursor selectCountSingleCallLog() {
        if (checkDatabase(this.mDb)) {
            return this.mDb.rawQuery("SELECT COUNT(*) AS num FROM calllog WHERE groupcallkey=0", null);
        }
        return null;
    }

    public Cursor selectCountGroupCallLog() {
        if (checkDatabase(this.mDb)) {
            return this.mDb.rawQuery("SELECT COUNT(DISTINCT groupcallkey) AS num FROM calllog", null);
        }
        return null;
    }

    public Cursor selectViewByCallLog(int searchtype) {
        if (!checkDatabase(this.mDb)) {
            return null;
        }
        String whereClause = null;
        switch (searchtype) {
            case 0:
                whereClause = "";
                break;
            case 1:
                whereClause = " WHERE a.callmethod=6 OR a.callmethod=10";
                break;
            case 2:
                whereClause = " WHERE a.callmethod=7 OR a.callmethod=11";
                break;
            case 3:
                whereClause = " WHERE a.callmethod=6 OR a.callmethod=7";
                break;
            case 4:
                whereClause = " WHERE a.callmethod=10 OR a.callmethod=11";
                break;
            case 5:
                whereClause = " WHERE a.calllogtype=2 OR groupcallkey IN  (SELECT _id FROM calllog WHERE groupcallkey IN  (SELECT groupcallkey FROM calllog WHERE calllogtype=2))";
                break;
            case 6:
                whereClause = " WHERE a.calllogtype=1 OR groupcallkey IN  (SELECT _id FROM calllog WHERE groupcallkey IN  (SELECT groupcallkey FROM calllog WHERE calllogtype=1)) AND a.callmethod<>12";
                break;
            case 7:
                whereClause = " WHERE a.calllogtype=0 OR groupcallkey IN  (SELECT _id FROM calllog WHERE groupcallkey IN  (SELECT groupcallkey FROM calllog WHERE calllogtype=0)) AND a.callmethod<>12";
                break;
            case 8:
                whereClause = " WHERE a.calllogtype=3 OR groupcallkey IN  (SELECT _id FROM calllog WHERE groupcallkey IN  (SELECT groupcallkey FROM calllog WHERE calllogtype=3)) OR a.calllogtype=4";
                break;
            case 9:
                whereClause = " WHERE a.callmethod=12";
                break;
        }
        String sql = String.valueOf(getSelectClause(11, "a", "b", null)) + " FROM " + DatabaseHelper.CALLLOG_TABLE + " a left outer join buddy b  on a." + DatabaseHelper.KEY_USERID + " = b." + DatabaseHelper.KEY_USERID + whereClause + " ORDER BY a." + DatabaseHelper.KEY_ROWID + " DESC";
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectCallLog(long userNo) {
        if (!checkDatabase(this.mDb)) {
            return null;
        }
        String sql = String.valueOf(getSelectClause(10, "a", null, null)) + " FROM " + DatabaseHelper.CALLLOG_TABLE + " a  WHERE a." + DatabaseHelper.KEY_USERNO + "=" + userNo + " OR " + DatabaseHelper.KEY_GROUPCALLKEY + " IN  (SELECT " + DatabaseHelper.KEY_ROWID + " FROM " + DatabaseHelper.CALLLOG_TABLE + C1265a.f3172e + DatabaseHelper.KEY_GROUPCALLKEY + " IN  (SELECT " + DatabaseHelper.KEY_GROUPCALLKEY + " FROM " + DatabaseHelper.CALLLOG_TABLE + C1265a.f3172e + DatabaseHelper.KEY_USERNO + "=" + userNo + ")) ORDER BY " + DatabaseHelper.KEY_ROWID + " DESC";
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectRejectedCall() {
        return this.mDb.rawQuery("select *, max(_id) from calllog  where rejectmsg is not null and groupcallkey = 0 order by _id desc ;", null);
    }

    public Cursor selectMissedCall() {
        return this.mDb.rawQuery("SELECT * FROM calllog where (case (select groupcallkey from calllog  WHERE _id= (select max(_id) from calllog where calllogtype=2 order by _id desc))  when 0 then _id =   (select max(_id) from calllog where calllogtype=2 order by _id desc)  else groupcallkey =   (select max(groupcallkey) from calllog where calllogtype=2 order by _id desc)  end)", null);
    }

    public Cursor selectLatestCallLog(long userNo, int groupcallKey) {
        String sql = "SELECT * FROM calllog WHERE _id = (SELECT max(_id) FROM calllog WHERE userno = " + Long.toString(userNo) + " AND " + DatabaseHelper.KEY_GROUPCALLKEY + " = " + groupcallKey + " AND " + DatabaseHelper.KEY_REJECTMSG + " IS NULL)";
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectLatestCallLogByUserID(String userID, int groupcallKey) {
        String sql = "SELECT * FROM calllog WHERE _id = (SELECT max(_id) FROM calllog WHERE userid = '" + userID + "' AND " + DatabaseHelper.KEY_GROUPCALLKEY + " = " + groupcallKey + " AND " + DatabaseHelper.KEY_REJECTMSG + " IS NULL)";
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectCallLogConferenceToP2P(String userID) {
        String sql = "SELECT * FROM calllog WHERE _id = (SELECT MAX(_id) FROM calllog WHERE userid = '" + userID + "' AND (" + DatabaseHelper.KEY_CALLMETHOD + " = 10 OR " + DatabaseHelper.KEY_CALLMETHOD + " = 11))";
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectRowIDListByGroupCallKey(int groupCallKey) {
        String sql = "SELECT _id FROM calllog WHERE groupcallkey = " + groupCallKey;
        return this.mDb.rawQuery(sql, null);
    }
}
