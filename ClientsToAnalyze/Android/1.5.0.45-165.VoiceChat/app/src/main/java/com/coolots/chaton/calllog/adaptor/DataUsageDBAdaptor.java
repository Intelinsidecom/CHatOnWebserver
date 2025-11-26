package com.coolots.chaton.calllog.adaptor;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.coolots.chaton.buddy.util.ContentValuesUtil;
import com.sds.coolots.MainApplication;
import com.sds.coolots.calllog.model.CallDataUsage;
import com.sds.coolots.calllog.model.TotalDataUsage;
import com.sds.coolots.common.controller.DatabaseHelper;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class DataUsageDBAdaptor {
    private static final String CLASSNAME = "[DataUsageDBAdaptor]";
    private static final String T_DIALLED_VIDEO = "t_dialled_video";
    private static final String T_DIALLED_VOICE = "t_dialled_voice";
    private static final String T_RECV_VIDEO = "t_recv_video";
    private static final String T_RECV_VOICE = "t_recv_voice";
    private static final String W_T_DIALLED_VIDEO = "wifi_t_dialled_video";
    private static final String W_T_DIALLED_VOICE = "wifi_t_dialled_voice";
    private static final String W_T_RECV_VIDEO = "wifi_t_recv_video";
    private static final String W_T_RECV_VOICE = "wifi_t_recv_voice";
    private boolean processingDataReset = false;
    private SQLiteDatabase mDb = null;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public DataUsageDBAdaptor() throws SQLException {
        open();
    }

    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }

    private void open() throws SQLException {
        this.mDb = MainApplication.mPhoneManager.getDatabase();
    }

    public void close() {
        MainApplication.mPhoneManager.closeDatabase();
    }

    public void saveCallDataUsage(long date, long dialledVoice, long dialledVideo, long recvVoice, long recvVideo, long lastVoice, long lastVideo, boolean isWifi) {
        Cursor rawCursor = selectDataUsageByDate(date);
        if (rawCursor != null) {
            int count = rawCursor.getCount();
            if (count == 0) {
                if (isWifi) {
                    long ret = createCallDataUsageRow(date, 0L, 0L, 0L, 0L, 0L, 0L, dialledVoice, dialledVideo, recvVoice, recvVideo, lastVoice, lastVideo);
                    if (ret < 0) {
                        logE("saveDataUsage createDataUsageRow fail ret : " + ret);
                    }
                } else {
                    long ret2 = createCallDataUsageRow(date, dialledVoice, dialledVideo, recvVoice, recvVideo, lastVoice, lastVideo, 0L, 0L, 0L, 0L, 0L, 0L);
                    if (ret2 < 0) {
                        logE("saveDataUsage createDataUsageRow fail ret : " + ret2);
                    }
                }
            } else if (count == 1) {
                long ret3 = changeDataUsageRow(date, dialledVoice, dialledVideo, recvVoice, recvVideo, lastVoice, lastVideo, isWifi);
                if (ret3 < 1) {
                    logE("saveDataUsage changeDataUsageRow fail ret : " + ret3);
                }
            } else {
                logE("saveDataUsage selectDataUsageByDate Invalid Row Count : " + count);
            }
            rawCursor.close();
        }
    }

    public CallDataUsage getCallDataUsageByPeriod(long startDate, long endDate, boolean isWifi) {
        Cursor cursorLastDU = selectLastDataUsageByPeriod(startDate, endDate);
        if (cursorLastDU == null) {
            return null;
        }
        int count = cursorLastDU.getCount();
        if (count > 1) {
            logE("getCallDataUsageByPeriod selectDataUsageByDate Invalid Row Count : " + count);
            if (cursorLastDU != null) {
                cursorLastDU.close();
            }
            return null;
        }
        if (count == 0) {
            CallDataUsage datausage = new CallDataUsage();
            datausage.setDataUsage(0L, 0L, 0L, 0L, 0L, 0L);
            if (cursorLastDU != null) {
                cursorLastDU.close();
                return datausage;
            }
            return datausage;
        }
        if (!cursorLastDU.moveToFirst()) {
            logE("getCallDataUsageByPeriod cursorLastDU Invalid");
            if (cursorLastDU != null) {
                cursorLastDU.close();
            }
            return null;
        }
        Cursor cursorAccumulatedDU = selectAccumulatedDataUsgaeByPeriod(startDate, endDate);
        if (cursorAccumulatedDU == null) {
            if (cursorLastDU != null) {
                cursorLastDU.close();
            }
            return null;
        }
        int count2 = cursorAccumulatedDU.getCount();
        if (count2 != 1) {
            logE("getCallDataUsageByPeriod selectAccumulatedDataUsgaeByPeriod Invalid Row Count : " + count2);
            if (cursorLastDU != null) {
                cursorLastDU.close();
            }
            if (cursorAccumulatedDU != null) {
                cursorAccumulatedDU.close();
            }
            return null;
        }
        if (!cursorAccumulatedDU.moveToFirst()) {
            logE("getCallDataUsageByPeriod cursorAccumulatedDU Invalid");
            if (cursorLastDU != null) {
                cursorLastDU.close();
            }
            if (cursorAccumulatedDU != null) {
                cursorAccumulatedDU.close();
            }
            return null;
        }
        CallDataUsage datausage2 = new CallDataUsage();
        if (isWifi) {
            try {
                datausage2.setDataUsage(cursorAccumulatedDU.getLong(cursorAccumulatedDU.getColumnIndex(W_T_DIALLED_VOICE)), cursorAccumulatedDU.getLong(cursorAccumulatedDU.getColumnIndex(W_T_DIALLED_VIDEO)), cursorAccumulatedDU.getLong(cursorAccumulatedDU.getColumnIndex(W_T_RECV_VOICE)), cursorAccumulatedDU.getLong(cursorAccumulatedDU.getColumnIndex(W_T_RECV_VIDEO)), cursorLastDU.getLong(cursorLastDU.getColumnIndex(DatabaseHelper.KEY_W_LAST_VOICE)), cursorLastDU.getLong(cursorLastDU.getColumnIndex(DatabaseHelper.KEY_W_LAST_VIDEO)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                datausage2.setDataUsage(cursorAccumulatedDU.getLong(cursorAccumulatedDU.getColumnIndex(T_DIALLED_VOICE)), cursorAccumulatedDU.getLong(cursorAccumulatedDU.getColumnIndex(T_DIALLED_VIDEO)), cursorAccumulatedDU.getLong(cursorAccumulatedDU.getColumnIndex(T_RECV_VOICE)), cursorAccumulatedDU.getLong(cursorAccumulatedDU.getColumnIndex(T_RECV_VIDEO)), cursorLastDU.getLong(cursorLastDU.getColumnIndex(DatabaseHelper.KEY_LAST_VOICE)), cursorLastDU.getLong(cursorLastDU.getColumnIndex(DatabaseHelper.KEY_LAST_VIDEO)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (cursorLastDU != null) {
            cursorLastDU.close();
        }
        if (cursorAccumulatedDU != null) {
            cursorAccumulatedDU.close();
            return datausage2;
        }
        return datausage2;
    }

    public void resetDataUsage() {
        deleteDataUsageAll();
    }

    public long createCallDataUsageRow(long date, long dialledVoice, long dialledVideo, long recvVoice, long recvVideo, long lastVoice, long lastVideo, long w_dialledVoice, long w_dialledVideo, long w_recvVoice, long w_recvVideo, long w_lastVoice, long w_lastVideo) {
        logI("createDataUsageRow started.., date : " + date + "lastVoice : " + lastVoice + "lastVideo : " + lastVideo);
        ContentValues excute = new ContentValues();
        excute.put(DatabaseHelper.KEY_STARTDATE, Long.valueOf(date));
        excute.put(DatabaseHelper.KEY_DIALLED_VOICE, Long.valueOf(dialledVoice));
        excute.put(DatabaseHelper.KEY_DIALLED_VIDEO, Long.valueOf(dialledVideo));
        excute.put(DatabaseHelper.KEY_RECV_VOICE, Long.valueOf(recvVoice));
        excute.put(DatabaseHelper.KEY_RECV_VIDEO, Long.valueOf(recvVideo));
        excute.put(DatabaseHelper.KEY_LAST_VOICE, Long.valueOf(lastVoice));
        excute.put(DatabaseHelper.KEY_LAST_VIDEO, Long.valueOf(lastVideo));
        excute.put(DatabaseHelper.KEY_W_DIALLED_VOICE, Long.valueOf(w_dialledVoice));
        excute.put(DatabaseHelper.KEY_W_DIALLED_VIDEO, Long.valueOf(w_dialledVideo));
        excute.put(DatabaseHelper.KEY_W_RECV_VOICE, Long.valueOf(w_recvVoice));
        excute.put(DatabaseHelper.KEY_W_RECV_VIDEO, Long.valueOf(w_recvVideo));
        excute.put(DatabaseHelper.KEY_W_LAST_VOICE, Long.valueOf(w_lastVoice));
        excute.put(DatabaseHelper.KEY_W_LAST_VIDEO, Long.valueOf(w_lastVideo));
        return insertDB(excute);
    }

    public int changeDataUsageRow(long date, long dialledVoice, long dialledVideo, long recvVoice, long recvVideo, long lastVoice, long lastVideo, boolean isWifi) {
        logI("changeDataUsageRow started.., date : " + date + "lastVoice : " + lastVoice + "lastVideo : " + lastVideo + "isWifi : " + isWifi);
        ContentValues excute = new ContentValues();
        if (isWifi) {
            excute.put(DatabaseHelper.KEY_W_DIALLED_VOICE, Long.valueOf(dialledVoice));
            excute.put(DatabaseHelper.KEY_W_DIALLED_VIDEO, Long.valueOf(dialledVideo));
            excute.put(DatabaseHelper.KEY_W_RECV_VOICE, Long.valueOf(recvVoice));
            excute.put(DatabaseHelper.KEY_W_RECV_VIDEO, Long.valueOf(recvVideo));
            excute.put(DatabaseHelper.KEY_W_LAST_VOICE, Long.valueOf(lastVoice));
            excute.put(DatabaseHelper.KEY_W_LAST_VIDEO, Long.valueOf(lastVideo));
        } else {
            excute.put(DatabaseHelper.KEY_DIALLED_VOICE, Long.valueOf(dialledVoice));
            excute.put(DatabaseHelper.KEY_DIALLED_VIDEO, Long.valueOf(dialledVideo));
            excute.put(DatabaseHelper.KEY_RECV_VOICE, Long.valueOf(recvVoice));
            excute.put(DatabaseHelper.KEY_RECV_VIDEO, Long.valueOf(recvVideo));
            excute.put(DatabaseHelper.KEY_LAST_VOICE, Long.valueOf(lastVoice));
            excute.put(DatabaseHelper.KEY_LAST_VIDEO, Long.valueOf(lastVideo));
        }
        ContentValues where = new ContentValues();
        where.put(DatabaseHelper.KEY_STARTDATE, Long.valueOf(date));
        return updateDB(excute, where);
    }

    public int deleteDataUsageAll() {
        return deleteDB(null);
    }

    public CallDataUsage getCallDataUsageByDate(long date, boolean isWifi) {
        Cursor cursor = selectDataUsageByDate(date);
        if (cursor == null) {
            return null;
        }
        if (!cursor.moveToFirst()) {
            CallDataUsage dataUsage = new CallDataUsage();
            dataUsage.setDataUsage(0L, 0L, 0L, 0L, 0L, 0L);
            if (cursor != null) {
                cursor.close();
                return dataUsage;
            }
            return dataUsage;
        }
        CallDataUsage dataUsage2 = new CallDataUsage();
        if (isWifi) {
            try {
                dataUsage2.setDataUsage(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.KEY_W_DIALLED_VOICE)), cursor.getLong(cursor.getColumnIndex(DatabaseHelper.KEY_W_DIALLED_VIDEO)), cursor.getLong(cursor.getColumnIndex(DatabaseHelper.KEY_W_RECV_VOICE)), cursor.getLong(cursor.getColumnIndex(DatabaseHelper.KEY_W_RECV_VIDEO)), cursor.getLong(cursor.getColumnIndex(DatabaseHelper.KEY_W_LAST_VOICE)), cursor.getLong(cursor.getColumnIndex(DatabaseHelper.KEY_W_LAST_VIDEO)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                dataUsage2.setDataUsage(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.KEY_DIALLED_VOICE)), cursor.getLong(cursor.getColumnIndex(DatabaseHelper.KEY_DIALLED_VIDEO)), cursor.getLong(cursor.getColumnIndex(DatabaseHelper.KEY_RECV_VOICE)), cursor.getLong(cursor.getColumnIndex(DatabaseHelper.KEY_RECV_VIDEO)), cursor.getLong(cursor.getColumnIndex(DatabaseHelper.KEY_LAST_VOICE)), cursor.getLong(cursor.getColumnIndex(DatabaseHelper.KEY_LAST_VIDEO)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (cursor != null) {
            cursor.close();
            return dataUsage2;
        }
        return dataUsage2;
    }

    public Cursor selectDataUsageByDate(long date) {
        String sql = "SELECT *  from datausage where startdate = " + date;
        return this.mDb.rawQuery(sql, null);
    }

    public int updateDB(ContentValues excute, ContentValues where) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return -1;
        }
        String strWhere = ContentValuesUtil.getStringByContentValuesForWhere(where, null);
        return this.mDb.update(DatabaseHelper.DATAUSAGE_TABLE, excute, strWhere, null);
    }

    public int deleteDB(ContentValues where) {
        String strWhere;
        if (this.mDb == null || !this.mDb.isOpen()) {
            return -1;
        }
        if (where != null) {
            strWhere = ContentValuesUtil.getStringByContentValuesForWhere(where, null);
        } else {
            strWhere = null;
        }
        return this.mDb.delete(DatabaseHelper.DATAUSAGE_TABLE, strWhere, null);
    }

    public long insertDB(ContentValues excute) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return -1L;
        }
        return this.mDb.insert(DatabaseHelper.DATAUSAGE_TABLE, null, excute);
    }

    public Cursor selectLastDataUsageByPeriod(long startDate, long endDate) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT last_voice, last_video, wifi_last_voice, wifi_last_video from datausage WHERE startdate >= " + startDate + " AND " + DatabaseHelper.KEY_STARTDATE + " <= " + endDate + " ORDER BY " + DatabaseHelper.KEY_STARTDATE + " DESC LIMIT 1";
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectAccumulatedDataUsgaeByPeriod(long startDate, long endDate) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT SUM(dialled_voice) as t_dialled_voice, SUM (dialled_video) as t_dialled_video, SUM (recv_voice) as t_recv_voice, SUM (recv_video) as t_recv_video, SUM (wifi_dialled_voice) as wifi_t_dialled_voice, SUM (wifi_dialled_video) as wifi_t_dialled_video, SUM (wifi_recv_voice) as wifi_t_recv_voice, SUM (wifi_recv_video) as wifi_t_recv_video from datausage WHERE startdate >= " + startDate + " AND " + DatabaseHelper.KEY_STARTDATE + " <= " + endDate;
        return this.mDb.rawQuery(sql, null);
    }

    public TotalDataUsage getTotalDataUsageByDate(long date) {
        Cursor cursor;
        TotalDataUsage dataUsage = null;
        if (this.mDb != null && this.mDb.isOpen() && (cursor = selectDataUsageByDate(date)) != null) {
            if (!cursor.moveToFirst()) {
                dataUsage = new TotalDataUsage();
                dataUsage.setTotalDataUsage(0L, 0L);
                if (cursor != null) {
                    cursor.close();
                }
            } else {
                dataUsage = new TotalDataUsage();
                try {
                    dataUsage.setTotalDataUsage(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.KEY_3G_TOTAL)), cursor.getLong(cursor.getColumnIndex(DatabaseHelper.KEY_WIFI_TOTAL)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return dataUsage;
    }

    public long createTotalDataUsageRow(long date, long DataTotalAount, long wifiTotalAmount) {
        ContentValues excute = new ContentValues();
        excute.put(DatabaseHelper.KEY_STARTDATE, Long.valueOf(date));
        excute.put(DatabaseHelper.KEY_3G_TOTAL, Long.valueOf(DataTotalAount));
        excute.put(DatabaseHelper.KEY_WIFI_TOTAL, Long.valueOf(wifiTotalAmount));
        return insertDB(excute);
    }

    public int changeTotalUsageRow(long date, long DataTotalAount, long wifiTotalAmount) {
        ContentValues excute = new ContentValues();
        excute.put(DatabaseHelper.KEY_3G_TOTAL, Long.valueOf(DataTotalAount));
        excute.put(DatabaseHelper.KEY_WIFI_TOTAL, Long.valueOf(wifiTotalAmount));
        ContentValues where = new ContentValues();
        where.put(DatabaseHelper.KEY_STARTDATE, Long.valueOf(date));
        return updateDB(excute, where);
    }

    public void saveTotalDataUsage(long date, long DataTotalAount, long wifiTotalAmount) {
        Cursor rawCursor = selectDataUsageByDate(date);
        if (rawCursor != null) {
            int count = rawCursor.getCount();
            if (count == 0) {
                createTotalDataUsageRow(date, DataTotalAount, wifiTotalAmount);
            } else if (count == 1) {
                long ret = changeTotalUsageRow(date, DataTotalAount, wifiTotalAmount);
                if (ret < 1) {
                    logE("saveTotalDataUsage changeTotalUsageRow fail ret : " + ret);
                }
            } else {
                logE("saveTotalDataUsage selectDataUsageByDate Invalid Row Count : " + count);
            }
            rawCursor.close();
        }
    }

    public boolean isEnableSaveTotalUsage() {
        return (this.mDb == null || !this.mDb.isOpen() || isProcessingDataReset()) ? false : true;
    }

    public long getWifiTotalDU() {
        long usage = -1;
        Cursor rawCusor = null;
        try {
            if (this.mDb != null && this.mDb.isOpen()) {
                rawCusor = this.mDb.rawQuery("SELECT SUM(wifi_total) FROM datausage", null);
                return usage;
            }
            if (rawCusor != null && rawCusor.moveToFirst()) {
                rawCusor.getLong(0);
                rawCusor.close();
            }
            return -1L;
        } finally {
            if (rawCusor != null && rawCusor.moveToFirst()) {
                rawCusor.getLong(0);
                rawCusor.close();
            }
        }
    }

    public long get3GTotalDU() {
        long usage = -1;
        if (this.mDb == null || !this.mDb.isOpen()) {
            return -1L;
        }
        Cursor rawCusor = this.mDb.rawQuery("SELECT SUM(data_total) FROM datausage", null);
        if (rawCusor != null) {
            try {
                if (rawCusor.moveToFirst() && rawCusor.moveToFirst()) {
                    usage = rawCusor.getLong(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                rawCusor.close();
            }
        }
        return usage;
    }

    public long getTotalDU() {
        long usage = -1;
        Cursor rawCusor = null;
        try {
            if (this.mDb != null && this.mDb.isOpen()) {
                rawCusor = this.mDb.rawQuery("SELECT SUM(wifi_total), SUM(data_total) FROM datausage", null);
                return usage;
            }
            if (rawCusor != null && rawCusor.moveToFirst()) {
                long usage2 = rawCusor.getLong(0) + rawCusor.getLong(1);
                rawCusor.close();
            }
            return -1L;
        } finally {
            if (rawCusor != null && rawCusor.moveToFirst()) {
                long usage3 = rawCusor.getLong(0) + rawCusor.getLong(1);
                rawCusor.close();
            }
        }
    }

    public boolean isProcessingDataReset() {
        return this.processingDataReset;
    }

    public void setProcessingDataReset(boolean dataReset) {
        this.processingDataReset = dataReset;
    }
}
