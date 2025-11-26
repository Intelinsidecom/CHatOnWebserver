package com.coolots.chaton.calllog.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.provider.Settings;
import com.coolots.chaton.calllog.adaptor.CallLogDbAdaptor;
import com.coolots.chaton.calllog.model.CallLogData;
import com.coolots.chaton.calllog.util.CallLogStringUtil;
import com.coolots.chaton.common.controller.ChatOnResourceInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class CallLogList {
    private static final String CLASSNAME = "[CallLogList]";
    public static final String DISPLAY_DATE_AS_DDMMYYYY = "dd-MM-yyyy";
    public static final String DISPLAY_DATE_AS_MMDDYYYY = "MM-dd-yyyy";
    public static final String DISPLAY_DATE_AS_YYYYMMDD = "yyyy-MM-dd";
    public static final int GROUPING_FOR_DETAIL = 0;
    public static final int GROUPING_FOR_HISTORY = 2;
    public static final int GROUPING_FOR_MAIN = 1;
    private static final int MAX_CALL_LOG_NUMBER = 500;
    private CallLogDbAdaptor mDb;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public CallLogList() {
        this.mDb = null;
        this.mDb = new CallLogDbAdaptor(MainApplication.mContext);
    }

    public boolean createCallLogDB(CallLogDBData values) {
        if (!values.checkNecessaries()) {
            return false;
        }
        logI("createCallLogDB()");
        ContentValues contentvalueCV = values.getContentValue();
        long lRet = this.mDb.createCallLog(contentvalueCV);
        if (lRet < 0) {
            return false;
        }
        autoDeleteOldestCallLog(false, selectOldestGroupCallKey() > 0);
        return true;
    }

    public int createCallLogDB(ArrayList<CallLogDBData> values) {
        logI("createCallLogDBList()");
        ArrayList<ContentValues> contentValues = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            CallLogDBData calllogC = values.get(i);
            if (calllogC.checkNecessaries()) {
                ContentValues contentvalueCV = calllogC.getContentValue();
                contentValues.add(contentvalueCV);
            }
        }
        int lRet = this.mDb.createCallLogList(contentValues);
        autoDeleteOldestCallLog(true, values.get(0).groupcallkey > 0);
        return lRet < 0 ? -1 : 0;
    }

    public int deleteCallLog(CallLogData where) {
        logI("deleteCallLog()");
        for (List<Integer> groupIdList : where.totalIDList) {
            for (Integer id : groupIdList) {
                int lRet = this.mDb.deleteCallLog(where.getContentValueForDelete(id.intValue()));
                if (lRet < 0) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public int updateCallLogDB(ContentValues value, int targetRowId) {
        logI("updateCallLog()");
        int lRet = this.mDb.updateCallLog(value, targetRowId);
        return lRet < 0 ? -1 : 0;
    }

    public int deleteCallLog(ArrayList<CallLogData> where) {
        logI("deleteCallLog()");
        for (int i = 0; i < where.size(); i++) {
            CallLogData calllogC = where.get(i);
            if (calllogC.groupcallkey != null && !calllogC.groupcallkey.isEmpty()) {
                for (Integer id : selectRowIDListByGroupCallKey(calllogC.groupcallkey.get(0).intValue())) {
                    int lRet = this.mDb.deleteCallLog(calllogC.getContentValueForDelete(id.intValue()));
                    if (lRet < 0) {
                        return -1;
                    }
                }
            } else {
                for (List<Integer> groupIdList : calllogC.totalIDList) {
                    for (Integer id2 : groupIdList) {
                        int lRet2 = this.mDb.deleteCallLog(calllogC.getContentValueForDelete(id2.intValue()));
                        if (lRet2 < 0) {
                            return -1;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int deleteOldestCallLog(boolean isGroupCallLog) {
        logI("deleteOldestCallLog()");
        int lRet = this.mDb.deleteOldestCallLog(isGroupCallLog);
        return lRet < 0 ? -1 : 0;
    }

    public int autoDeleteOldestCallLog(boolean bList, boolean isGroupCallLog) {
        logI("autoDeleteOldestCallLog()");
        int lRet = 0;
        int currentCallLogNum = selectCountCallLog();
        int exceedCallLogNum = currentCallLogNum - 500;
        if (exceedCallLogNum > 0) {
            if (bList || exceedCallLogNum > 1) {
                for (int i = 0; i < currentCallLogNum - 500 && (lRet = this.mDb.deleteOldestCallLog(isGroupCallLog)) >= 0; i++) {
                }
            } else {
                lRet = this.mDb.deleteOldestCallLog(isGroupCallLog);
                if (lRet < 0) {
                    return -1;
                }
            }
        }
        return lRet < 0 ? -1 : 0;
    }

    public ArrayList<CallLogData> selectCallLog(CallLogDBData where, boolean isAddSeperator) {
        ArrayList<CallLogData> result = null;
        Cursor cursorC = this.mDb.selectCallLog(where.getContentValue());
        try {
            try {
                result = getDisplayCallLogList(cursorC, 1, isAddSeperator);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
                if (cursorC != null) {
                    cursorC.close();
                }
            }
            return result;
        } finally {
            if (cursorC != null) {
                cursorC.close();
            }
        }
    }

    public ArrayList<CallLogData> selectCallLog(ArrayList<Integer> idList, boolean isAddSeperator) {
        ArrayList<CallLogData> result = null;
        Cursor cursorC = this.mDb.selectCallLog(idList);
        try {
            try {
                result = getDisplayCallLogList(cursorC, 0, isAddSeperator);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
                if (cursorC != null) {
                    cursorC.close();
                }
            }
            return result;
        } finally {
            if (cursorC != null) {
                cursorC.close();
            }
        }
    }

    public HashMap<Set<Long>, String> selectGroupInfo() {
        HashMap<Set<Long>, String> result = null;
        Cursor cursorC = this.mDb.selectGroupInfo();
        try {
            try {
                result = GroupInfo.getGroupInfoMapByCursor(cursorC);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
                if (cursorC != null) {
                    cursorC.close();
                }
            }
            return result;
        } finally {
            if (cursorC != null) {
                cursorC.close();
            }
        }
    }

    public ArrayList<CallLogData> selectCallLog(long userNo, boolean isAddSeperator) {
        ArrayList<CallLogData> result = null;
        Cursor cursorC = this.mDb.selectCallLog(userNo);
        try {
            try {
                result = getDisplayCallLogList(cursorC, 2, isAddSeperator);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
                if (cursorC != null) {
                    cursorC.close();
                }
            }
            return result;
        } finally {
            if (cursorC != null) {
                cursorC.close();
            }
        }
    }

    public int selectIndexOfCallLog() {
        int result = 0;
        Cursor cursorC = this.mDb.selectIndexOfCallLog();
        try {
            try {
                if (cursorC.moveToFirst()) {
                    int index = cursorC.getInt(0);
                    result = index;
                }
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
                if (cursorC != null) {
                    cursorC.close();
                }
            }
            return result;
        } finally {
            if (cursorC != null) {
                cursorC.close();
            }
        }
    }

    public int selectIndexOfCallLog(String userid, int groupcallkey) {
        int result = 0;
        Cursor cursorC = this.mDb.selectIndexOfCallLog(userid, groupcallkey);
        try {
            try {
                if (cursorC.moveToFirst()) {
                    int index = cursorC.getInt(0);
                    result = index;
                }
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
                if (cursorC != null) {
                    cursorC.close();
                }
            }
            return result;
        } finally {
            if (cursorC != null) {
                cursorC.close();
            }
        }
    }

    public int selectOldestGroupCallKey() {
        int result = 0;
        Cursor cursorC = this.mDb.selectOldestGroupCallKey();
        try {
            try {
                if (cursorC.moveToFirst()) {
                    int groupcallkey = cursorC.getInt(0);
                    result = groupcallkey;
                }
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
                if (cursorC != null) {
                    cursorC.close();
                }
            }
            return result;
        } finally {
            if (cursorC != null) {
                cursorC.close();
            }
        }
    }

    public int selectCountCallLog() {
        return selectCountSingleCallLog() + selectCountGroupCallLog();
    }

    public int selectCountSingleCallLog() {
        int result = 0;
        Cursor cursorC = this.mDb.selectCountSingleCallLog();
        try {
            try {
                if (cursorC.moveToFirst()) {
                    int num = cursorC.getInt(0);
                    result = num;
                }
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
                if (cursorC != null) {
                    cursorC.close();
                }
            }
            return result;
        } finally {
            if (cursorC != null) {
                cursorC.close();
            }
        }
    }

    public int selectCountGroupCallLog() {
        int result = 0;
        Cursor cursorC = this.mDb.selectCountGroupCallLog();
        try {
            try {
                if (cursorC.moveToFirst()) {
                    int num = cursorC.getInt(0) - 1;
                    result = num;
                }
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
                if (cursorC != null) {
                    cursorC.close();
                }
            }
            return result;
        } finally {
            if (cursorC != null) {
                cursorC.close();
            }
        }
    }

    public ArrayList<CallLogData> selectViewByCallLog(int searchtype, boolean isAddSeperator) {
        ArrayList<CallLogData> result = null;
        Cursor cursorC = this.mDb.selectViewByCallLog(searchtype);
        try {
            try {
                result = getDisplayCallLogList(cursorC, 1, isAddSeperator);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
                if (cursorC != null) {
                    cursorC.close();
                }
            }
            return result;
        } finally {
            if (cursorC != null) {
                cursorC.close();
            }
        }
    }

    public ArrayList<CallLogData> selectRejectedCalllog(boolean isAddSeperator) {
        ArrayList<CallLogData> result = null;
        Cursor cursorC = this.mDb.selectRejectedCall();
        try {
            try {
                result = getDisplayCallLogList(cursorC, 0, isAddSeperator);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
                if (cursorC != null) {
                    cursorC.close();
                }
            }
            return result;
        } finally {
            if (cursorC != null) {
                cursorC.close();
            }
        }
    }

    public ArrayList<CallLogData> selectMissedCalllog(boolean isAddSeperator) {
        ArrayList<CallLogData> result = null;
        Cursor cursorC = this.mDb.selectMissedCall();
        try {
            try {
                result = getDisplayCallLogList(cursorC, 2, isAddSeperator);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
                if (cursorC != null) {
                    cursorC.close();
                }
            }
            return result;
        } finally {
            if (cursorC != null) {
                cursorC.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<java.lang.Integer> selectRowIDListByGroupCallKey(int r10) {
        /*
            r9 = this;
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            com.coolots.chaton.calllog.adaptor.CallLogDbAdaptor r6 = r9.mDb
            android.database.Cursor r0 = r6.selectRowIDListByGroupCallKey(r10)
            r4 = 0
            if (r0 == 0) goto L30
            r0.moveToFirst()     // Catch: android.database.SQLException -> L36 java.lang.Throwable -> L51
            boolean r6 = r0.isAfterLast()     // Catch: android.database.SQLException -> L36 java.lang.Throwable -> L51
            if (r6 != 0) goto L30
        L17:
            java.lang.String r6 = "_id"
            int r4 = r0.getColumnIndex(r6)     // Catch: android.database.SQLException -> L36 java.lang.Throwable -> L51
            if (r4 < 0) goto L2a
            int r6 = r0.getInt(r4)     // Catch: android.database.SQLException -> L36 java.lang.Throwable -> L51
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: android.database.SQLException -> L36 java.lang.Throwable -> L51
            r5.add(r6)     // Catch: android.database.SQLException -> L36 java.lang.Throwable -> L51
        L2a:
            boolean r6 = r0.moveToNext()     // Catch: android.database.SQLException -> L36 java.lang.Throwable -> L51
            if (r6 != 0) goto L17
        L30:
            if (r0 == 0) goto L35
            r0.close()
        L35:
            return r5
        L36:
            r1 = move-exception
            java.lang.StackTraceElement[] r3 = r1.getStackTrace()     // Catch: java.lang.Throwable -> L51
            int r7 = r3.length     // Catch: java.lang.Throwable -> L51
            r6 = 0
        L3d:
            if (r6 < r7) goto L45
            if (r0 == 0) goto L35
            r0.close()
            goto L35
        L45:
            r2 = r3[r6]     // Catch: java.lang.Throwable -> L51
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L51
            r9.logI(r8)     // Catch: java.lang.Throwable -> L51
            int r6 = r6 + 1
            goto L3d
        L51:
            r6 = move-exception
            if (r0 == 0) goto L57
            r0.close()
        L57:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coolots.chaton.calllog.model.CallLogList.selectRowIDListByGroupCallKey(int):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.coolots.chaton.calllog.model.CallLogData getLatestCalllogByUserID(java.lang.String r10, int r11) {
        /*
            r9 = this;
            r4 = 0
            com.coolots.chaton.calllog.adaptor.CallLogDbAdaptor r6 = r9.mDb
            android.database.Cursor r0 = r6.selectLatestCallLogByUserID(r10, r11)
            if (r0 == 0) goto L1b
            int r6 = r0.getCount()     // Catch: android.database.SQLException -> L21 java.lang.Throwable -> L3c
            if (r6 <= 0) goto L1b
            boolean r6 = r0.moveToFirst()     // Catch: android.database.SQLException -> L21 java.lang.Throwable -> L3c
            if (r6 == 0) goto L1b
            com.coolots.chaton.calllog.model.CallLogData r5 = new com.coolots.chaton.calllog.model.CallLogData     // Catch: android.database.SQLException -> L21 java.lang.Throwable -> L3c
            r5.<init>(r0)     // Catch: android.database.SQLException -> L21 java.lang.Throwable -> L3c
            r4 = r5
        L1b:
            if (r0 == 0) goto L20
            r0.close()
        L20:
            return r4
        L21:
            r1 = move-exception
            java.lang.StackTraceElement[] r3 = r1.getStackTrace()     // Catch: java.lang.Throwable -> L3c
            int r7 = r3.length     // Catch: java.lang.Throwable -> L3c
            r6 = 0
        L28:
            if (r6 < r7) goto L30
            if (r0 == 0) goto L20
            r0.close()
            goto L20
        L30:
            r2 = r3[r6]     // Catch: java.lang.Throwable -> L3c
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L3c
            r9.logI(r8)     // Catch: java.lang.Throwable -> L3c
            int r6 = r6 + 1
            goto L28
        L3c:
            r6 = move-exception
            if (r0 == 0) goto L42
            r0.close()
        L42:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coolots.chaton.calllog.model.CallLogList.getLatestCalllogByUserID(java.lang.String, int):com.coolots.chaton.calllog.model.CallLogData");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.coolots.chaton.calllog.model.CallLogData getLatestCalllogByUserNo(long r10, int r12) {
        /*
            r9 = this;
            r4 = 0
            com.coolots.chaton.calllog.adaptor.CallLogDbAdaptor r6 = r9.mDb
            android.database.Cursor r0 = r6.selectLatestCallLog(r10, r12)
            if (r0 == 0) goto L1b
            int r6 = r0.getCount()     // Catch: android.database.SQLException -> L21 java.lang.Throwable -> L3c
            if (r6 <= 0) goto L1b
            boolean r6 = r0.moveToFirst()     // Catch: android.database.SQLException -> L21 java.lang.Throwable -> L3c
            if (r6 == 0) goto L1b
            com.coolots.chaton.calllog.model.CallLogData r5 = new com.coolots.chaton.calllog.model.CallLogData     // Catch: android.database.SQLException -> L21 java.lang.Throwable -> L3c
            r5.<init>(r0)     // Catch: android.database.SQLException -> L21 java.lang.Throwable -> L3c
            r4 = r5
        L1b:
            if (r0 == 0) goto L20
            r0.close()
        L20:
            return r4
        L21:
            r1 = move-exception
            java.lang.StackTraceElement[] r3 = r1.getStackTrace()     // Catch: java.lang.Throwable -> L3c
            int r7 = r3.length     // Catch: java.lang.Throwable -> L3c
            r6 = 0
        L28:
            if (r6 < r7) goto L30
            if (r0 == 0) goto L20
            r0.close()
            goto L20
        L30:
            r2 = r3[r6]     // Catch: java.lang.Throwable -> L3c
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L3c
            r9.logI(r8)     // Catch: java.lang.Throwable -> L3c
            int r6 = r6 + 1
            goto L28
        L3c:
            r6 = move-exception
            if (r0 == 0) goto L42
            r0.close()
        L42:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coolots.chaton.calllog.model.CallLogList.getLatestCalllogByUserNo(long, int):com.coolots.chaton.calllog.model.CallLogData");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.coolots.chaton.calllog.model.CallLogData getCalllogConferenceToP2P(java.lang.String r10) {
        /*
            r9 = this;
            r4 = 0
            com.coolots.chaton.calllog.adaptor.CallLogDbAdaptor r6 = r9.mDb
            android.database.Cursor r0 = r6.selectCallLogConferenceToP2P(r10)
            if (r0 == 0) goto L1b
            int r6 = r0.getCount()     // Catch: android.database.SQLException -> L21 java.lang.Throwable -> L3c
            if (r6 <= 0) goto L1b
            boolean r6 = r0.moveToFirst()     // Catch: android.database.SQLException -> L21 java.lang.Throwable -> L3c
            if (r6 == 0) goto L1b
            com.coolots.chaton.calllog.model.CallLogData r5 = new com.coolots.chaton.calllog.model.CallLogData     // Catch: android.database.SQLException -> L21 java.lang.Throwable -> L3c
            r5.<init>(r0)     // Catch: android.database.SQLException -> L21 java.lang.Throwable -> L3c
            r4 = r5
        L1b:
            if (r0 == 0) goto L20
            r0.close()
        L20:
            return r4
        L21:
            r1 = move-exception
            java.lang.StackTraceElement[] r3 = r1.getStackTrace()     // Catch: java.lang.Throwable -> L3c
            int r7 = r3.length     // Catch: java.lang.Throwable -> L3c
            r6 = 0
        L28:
            if (r6 < r7) goto L30
            if (r0 == 0) goto L20
            r0.close()
            goto L20
        L30:
            r2 = r3[r6]     // Catch: java.lang.Throwable -> L3c
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L3c
            r9.logI(r8)     // Catch: java.lang.Throwable -> L3c
            int r6 = r6 + 1
            goto L28
        L3c:
            r6 = move-exception
            if (r0 == 0) goto L42
            r0.close()
        L42:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coolots.chaton.calllog.model.CallLogList.getCalllogConferenceToP2P(java.lang.String):com.coolots.chaton.calllog.model.CallLogData");
    }

    protected void finalize() {
        this.mDb.close();
    }

    private ArrayList<CallLogData> getDisplayCallLogList(Cursor cursor, int rule, boolean isAddSeperator) {
        ArrayList<CallLogData> list = new ArrayList<>();
        if (cursor != null) {
            cursor.moveToFirst();
            if (!cursor.isAfterLast()) {
                CallLogData data = new CallLogData(cursor);
                while (cursor.moveToNext()) {
                    switch (data.updateData(cursor, rule)) {
                        case 1:
                            addData(list, data, isAddSeperator);
                            data = new CallLogData(cursor);
                            if (rule != 1) {
                                break;
                            } else {
                                checkDupConferenceCall(list);
                                break;
                            }
                        case 2:
                            if (rule != 0) {
                                break;
                            } else {
                                addData(list, data, isAddSeperator);
                                data = new CallLogData(cursor);
                                break;
                            }
                        case 4:
                            addData(list, data, isAddSeperator);
                            data = new CallLogData(cursor);
                            if (rule != 1) {
                                break;
                            } else {
                                checkDupConferenceCall(list);
                                break;
                            }
                        case 6:
                            addData(list, data, isAddSeperator);
                            data = new CallLogData(cursor);
                            if (rule != 1) {
                                break;
                            } else {
                                checkDupConferenceCall(list);
                                break;
                            }
                    }
                }
                addData(list, data, isAddSeperator);
                if (rule == 1) {
                    checkDupConferenceCall(list);
                }
            }
            cursor.close();
        }
        return list;
    }

    private void addData(ArrayList<CallLogData> list, CallLogData data, boolean isAddSeperator) {
        if (isAddSeperator) {
            if (list.size() <= 0) {
                SeperatorCallLog seperator = getSeperator(data);
                list.add(seperator);
            } else if (list.size() > 0 && !CallLogStringUtil.getInstance().isSameDate(list.get(list.size() - 1).userInfo.get(0).calldate, data.userInfo.get(0).calldate)) {
                SeperatorCallLog seperator2 = getSeperator(data);
                list.add(seperator2);
            }
        }
        if (data.groupcallkey != null && !data.groupcallkey.isEmpty()) {
            Iterator<CallLogData.UserInfo> it = data.userInfo.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CallLogData.UserInfo info = it.next();
                if (MainApplication.mConfig.getProfileUserID().equals(info.userID)) {
                    data.myCalllogtype = info.calllogtype;
                    data.userInfo.remove(data.userInfo.indexOf(info));
                    int myRowID = selectIndexOfCallLog(info.userID, data.groupcallkey.get(0).intValue());
                    data.totalIDList.get(0).remove(data.totalIDList.get(0).indexOf(Integer.valueOf(myRowID)));
                    break;
                }
            }
        }
        list.add(data);
    }

    private SeperatorCallLog getSeperator(CallLogData data) {
        int newCallDate = (int) CallLogStringUtil.getInstance().getDaysBetweenCallDateAndToday(data.userInfo.get(0).calldate);
        SeperatorCallLog seperator = new SeperatorCallLog();
        if (newCallDate == 0 || newCallDate == -1) {
            int rscNumber = ((ChatOnResourceInterface) MainApplication.mResources).getCallLogTodaySeperator();
            String rscString = "";
            if (rscNumber > 0) {
                rscString = MainApplication.mContext.getString(rscNumber);
            }
            seperator.seperatorname = rscString;
            seperator.displaytype = 0;
        } else if (newCallDate == 1) {
            int rscNumber2 = ((ChatOnResourceInterface) MainApplication.mResources).getCallLogYesterdatSeperator();
            String rscString2 = "";
            if (rscNumber2 > 0) {
                rscString2 = MainApplication.mContext.getString(rscNumber2);
            }
            seperator.seperatorname = rscString2;
            seperator.displaytype = 1;
        } else if (newCallDate >= 2) {
            seperator.seperatorname = CallLogStringUtil.getInstance().getCallDateString(data.userInfo.get(0).calldate, getSystemDateFormatString());
        } else {
            seperator.seperatorname = CallLogStringUtil.getInstance().getCallDateString(data.userInfo.get(0).calldate, getSystemDateFormatString());
        }
        return seperator;
    }

    private boolean checkDupConferenceCall(List<CallLogData> list) {
        if (list.size() < 2 || !list.get(list.size() - 2).isDupConferenceCall(list.get(list.size() - 1))) {
            return false;
        }
        list.remove(list.size() - 1);
        return true;
    }

    public String getSystemDateFormatString() {
        String dateFormat;
        if (0 == 0 || (dateFormat = Settings.System.getString(MainApplication.mContext.getContentResolver(), "date_format")) == null) {
            return "yyyy/MM/dd";
        }
        if (dateFormat.equals("MM-dd-yyyy")) {
            return "MM/dd/yyyy";
        }
        if (dateFormat.equals("dd-MM-yyyy")) {
            return "dd/MM/yyyy";
        }
        if (dateFormat.equals("yyyy-MM-dd")) {
            return "yyyy/MM/dd";
        }
        return dateFormat;
    }
}
