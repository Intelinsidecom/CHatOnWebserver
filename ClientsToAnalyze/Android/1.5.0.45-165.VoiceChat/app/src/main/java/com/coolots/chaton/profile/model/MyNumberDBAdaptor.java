package com.coolots.chaton.profile.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.coolots.chaton.common.view.ConfigActivity;
import com.coolots.p2pmsg.model.PhoneNoInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.DatabaseHelper;
import com.sds.coolots.common.util.ContentValuesUtil;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class MyNumberDBAdaptor {
    private static final String CLASSNAME = "[MyNumberDBAdaptor]";
    private SQLiteDatabase mDb = null;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public MyNumberDBAdaptor() throws SQLException {
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

    public void updatePhoneNoList(List<PhoneNoInfo> phoneNoList) {
        String internationalNo;
        ArrayList<PhoneNoInfo> oldList = selectMyNumber();
        Iterator<PhoneNoInfo> it = oldList.iterator();
        while (it.hasNext()) {
            PhoneNoInfo oldInfo = it.next();
            deleteMyNumber(oldInfo.getPhoneNo());
        }
        boolean isFound = false;
        boolean isValid = false;
        String mySMSAuthPhoneNO = ((ChatOnConfigInterface) MainApplication.mConfig).getSMSAuthNumber();
        String mySMSAuthCountryCode = ((ChatOnConfigInterface) MainApplication.mConfig).getSMSAuthCountryCode();
        if (mySMSAuthPhoneNO != null && !mySMSAuthPhoneNO.isEmpty()) {
            isValid = true;
        }
        logE("[AUTHNUMBER] mySMSAuthPhoneNO : " + mySMSAuthPhoneNO);
        logE("[AUTHNUMBER] mySMSAuthCountryCode : " + mySMSAuthCountryCode);
        if (mySMSAuthCountryCode == null || mySMSAuthCountryCode.isEmpty()) {
            internationalNo = "";
        } else {
            internationalNo = getInternationalCallNo(Integer.parseInt(mySMSAuthCountryCode), mySMSAuthPhoneNO);
        }
        for (PhoneNoInfo info : phoneNoList) {
            if (isValid) {
                logE("[AUTHNUMBER] Number From Server : " + info.getPhoneNo());
                if (info.getPhoneNo().equals(internationalNo)) {
                    logE("[AUTHNUMBER] My SMS Auth Number : " + internationalNo);
                    isFound = true;
                }
            }
            insertMyNumber(info);
        }
        if (isValid && !isFound) {
            ((ChatOnConfigInterface) MainApplication.mConfig).setSMSAuthNumber("");
            ((ChatOnConfigInterface) MainApplication.mConfig).setSMSAuthCountryCode("");
            ConfigActivity.setEnableAutoBuddy(false);
        }
    }

    private String getInternationalCallNo(int countryCode, String phoneNo) {
        return phoneNo.charAt(0) == '0' ? String.valueOf(countryCode) + phoneNo.substring(1) : String.valueOf(countryCode) + phoneNo;
    }

    public long insertMyNumber(PhoneNoInfo info) {
        ContentValues value = new ContentValues();
        value.put(DatabaseHelper.KEY_PHONENO, info.getPhoneNo());
        if ("Y".equals(info.getPrivacy())) {
            value.put(DatabaseHelper.KEY_PRIVACY, (Integer) 1);
        } else {
            value.put(DatabaseHelper.KEY_PRIVACY, (Integer) 0);
        }
        return insertMyNumber(value);
    }

    private long insertMyNumber(ContentValues value) {
        if (this.mDb == null || !this.mDb.isOpen() || value == null) {
            return -1L;
        }
        long count = this.mDb.insert(DatabaseHelper.MYNUMBER_TABLE, null, value);
        return count;
    }

    public ArrayList<PhoneNoInfo> selectMyNumber() {
        Cursor cursor = selectMyNumberAll();
        ArrayList<PhoneNoInfo> phoneNoList = new ArrayList<>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                PhoneNoInfo info = new PhoneNoInfo();
                info.setPhoneNo(cursor.getString(1));
                if (cursor.getInt(cursor.getColumnIndex(DatabaseHelper.KEY_PRIVACY)) == 1) {
                    info.setPrivacy("Y");
                } else {
                    info.setPrivacy("N");
                }
                phoneNoList.add(info);
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        return phoneNoList;
    }

    private Cursor selectMyNumberAll() {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        return this.mDb.rawQuery("SELECT * from mynumber", null);
    }

    public boolean isPrivacyNumber(String number) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return false;
        }
        String sql = "SELECT * from mynumber WHERE phoneno = " + number + " AND " + DatabaseHelper.KEY_PRIVACY + " = 1";
        Cursor rawCursor = this.mDb.rawQuery(sql, null);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            rawCursor.close();
            return true;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return false;
    }

    public boolean isPhoneNo(String number) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return false;
        }
        String sql = "SELECT * from mynumber WHERE phoneno = " + number;
        Cursor rawCursor = this.mDb.rawQuery(sql, null);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            rawCursor.close();
            return true;
        }
        if (rawCursor == null) {
            return false;
        }
        rawCursor.close();
        return false;
    }

    public long updateMyNumber(String phoneNo, boolean privacy) {
        ContentValues where = new ContentValues();
        where.put(DatabaseHelper.KEY_PHONENO, phoneNo);
        ContentValues value = new ContentValues();
        value.put(DatabaseHelper.KEY_PHONENO, phoneNo);
        if (privacy) {
            value.put(DatabaseHelper.KEY_PRIVACY, (Integer) 1);
        } else {
            value.put(DatabaseHelper.KEY_PRIVACY, (Integer) 0);
        }
        return updateMyNumber(value, where);
    }

    private long updateMyNumber(ContentValues value, ContentValues where) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return -1L;
        }
        String strWhere = ContentValuesUtil.getStringByContentValuesForWhere(where, null);
        return this.mDb.update(DatabaseHelper.MYNUMBER_TABLE, value, strWhere, null);
    }

    public long deleteMyNumber(String phoneNo) {
        ContentValues where = new ContentValues();
        where.put(DatabaseHelper.KEY_PHONENO, phoneNo);
        return deleteMyNumber(where);
    }

    private long deleteMyNumber(ContentValues where) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return -1L;
        }
        String strWhere = ContentValuesUtil.getStringByContentValuesForWhere(where, null);
        return this.mDb.delete(DatabaseHelper.MYNUMBER_TABLE, strWhere, null);
    }
}
