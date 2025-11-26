package com.coolots.chaton.buddy.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.coolots.chaton.buddy.util.BuddyImageUtil;
import com.coolots.chaton.buddy.util.ContentValuesUtil;
import com.coolots.chaton.buddy.util.RegionDomainUtil;
import com.coolots.chaton.buddy.util.ValueObjectConverter;
import com.coolots.chaton.common.view.ConfigActivity;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.p2pmsg.model.BuddyGroupInfo;
import com.coolots.p2pmsg.model.BuddyGroupMapInfo;
import com.coolots.p2pmsg.model.BuddyInfo;
import com.coolots.p2pmsg.model.RegionDomainInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.DatabaseHelper;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.p018a.C1265a;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class BuddyDBAdaptor {
    private static final String CLASSNAME = "[BuddyDBAdaptor]";
    private SQLiteDatabase mDb = null;
    public Date mUpdateDate = new Date();

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public BuddyDBAdaptor() throws SQLException {
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

    public boolean isBuddyUpdated() {
        return ConfigActivity.isBuddyUpdateNeeded();
    }

    public void setBuddyUpdated(boolean buddyUpdated) {
        Log.m2958e("BUDDY_TRACE setBuddyUpdated : " + buddyUpdated);
        ConfigActivity.setBuddyUpdateNeeded(buddyUpdated);
    }

    public boolean isBuddyUpdatedSuggestion() {
        return ConfigActivity.isBuddyUpdateNeededSuggestion();
    }

    public void setBuddyUpdatedSuggestion(boolean buddyUpdatedSuggestion) {
        Log.m2958e("BUDDY_TRACE setBuddyUpdatedSuggestion : " + buddyUpdatedSuggestion);
        ConfigActivity.setBuddyUpdateNeededSuggestion(buddyUpdatedSuggestion);
    }

    public void setBuddyUpdateDate(Date date) {
        ConfigActivity.setBuddyUpdateDate(date);
        this.mUpdateDate = date;
    }

    public Date getBuddyUpdateDate() {
        return ConfigActivity.getBuddyUpdateDate();
    }

    public long insertBuddyInfotoDB(BuddyInfo buddy) {
        insertIDNumber(ValueObjectConverter.makeIDNumberContentValuesFromBuddyInfo(buddy));
        insertBuddy(ValueObjectConverter.makeBuddyContentValuesFromBuddyInfo(buddy, null, true, false));
        return 1L;
    }

    public long insertBuddyInfotoDB(List<BuddyInfo> buddyList, List<NativeNameAndPhoneNumberInfo> nativeNameInfoList) {
        if (buddyList == null) {
            return 1L;
        }
        ArrayList<ContentValues> buddyInfoList = new ArrayList<>();
        for (BuddyInfo buddy : buddyList) {
            Cursor rawCursor = selectBuddyByUserNoWithNoException(buddy.getUserNo());
            if (rawCursor != null && rawCursor.getCount() > 0 && rawCursor.moveToFirst()) {
                ContentValues query = new ContentValues();
                query.put(DatabaseHelper.KEY_USERNO, Long.valueOf(buddy.getUserNo()));
                updateIDNumber(buddy);
                if (buddy.getProfileImgUpdateDate() == null) {
                    BuddyImageUtil.deleteBuddyThumbnailImage(buddy.getUserNo());
                } else if (rawCursor.getLong(20) < buddy.getProfileImgUpdateDate().getTime()) {
                    BuddyImageUtil.updateBuddyThumbnail(buddy.getUserNo());
                }
                rawCursor.close();
                String nativeName = null;
                List<com.coolots.p2pmsg.model.PhoneNoInfo> pniList = buddy.getPhoneNoList();
                for (NativeNameAndPhoneNumberInfo nameinfo : nativeNameInfoList) {
                    for (com.coolots.p2pmsg.model.PhoneNoInfo pni : pniList) {
                        if (pni.getPhoneNo().equals(nameinfo.getPhonrNumber())) {
                            nativeName = nameinfo.getNativeName();
                        }
                    }
                }
                ContentValues execute = ValueObjectConverter.makeBuddyContentValuesFromBuddyInfo(buddy, nativeName, false, false);
                updateBuddy(execute, query);
            } else {
                String nativeName2 = null;
                List<com.coolots.p2pmsg.model.PhoneNoInfo> pniList2 = buddy.getPhoneNoList();
                for (NativeNameAndPhoneNumberInfo nameinfo2 : nativeNameInfoList) {
                    for (com.coolots.p2pmsg.model.PhoneNoInfo pni2 : pniList2) {
                        if (pni2.getPhoneNo().equals(nameinfo2.getPhonrNumber())) {
                            nativeName2 = nameinfo2.getNativeName();
                        }
                    }
                }
                buddyInfoList.add(ValueObjectConverter.makeBuddyContentValuesFromBuddyInfo(buddy, nativeName2, true, false));
                insertIDNumber(ValueObjectConverter.makeIDNumberContentValuesFromBuddyInfo(buddy));
                if (rawCursor != null) {
                    rawCursor.close();
                }
            }
        }
        insertBuddy(buddyInfoList);
        return 1L;
    }

    public long insertBuddyInfotoDB(List<BuddyInfo> buddyList) {
        if (buddyList == null) {
            return 1L;
        }
        ArrayList<ContentValues> buddyInfoList = new ArrayList<>();
        for (BuddyInfo buddy : buddyList) {
            Cursor rawCursor = selectBuddyByUserNoWithNoException(buddy.getUserNo());
            if (rawCursor != null && rawCursor.getCount() > 0 && rawCursor.moveToFirst()) {
                ContentValues query = new ContentValues();
                query.put(DatabaseHelper.KEY_USERNO, Long.valueOf(buddy.getUserNo()));
                updateIDNumber(buddy);
                if (buddy.getProfileImgUpdateDate() == null) {
                    BuddyImageUtil.deleteBuddyThumbnailImage(buddy.getUserNo());
                } else if (rawCursor.getLong(20) < buddy.getProfileImgUpdateDate().getTime()) {
                    BuddyImageUtil.updateBuddyThumbnail(buddy.getUserNo());
                }
                rawCursor.close();
                if (isSuggestionUser(buddy.getUserID())) {
                    ContentValues execute = ValueObjectConverter.makeBuddyContentValuesFromBuddyInfo(buddy, null, true, false);
                    updateBuddy(execute, query);
                } else {
                    ContentValues execute2 = ValueObjectConverter.makeBuddyContentValuesFromBuddyInfo(buddy, null, false, false);
                    updateBuddy(execute2, query);
                }
            } else {
                buddyInfoList.add(ValueObjectConverter.makeBuddyContentValuesFromBuddyInfo(buddy, null, true, false));
                insertIDNumber(ValueObjectConverter.makeIDNumberContentValuesFromBuddyInfo(buddy));
                if (rawCursor != null) {
                    rawCursor.close();
                }
            }
        }
        insertBuddy(buddyInfoList);
        return 1L;
    }

    public long blockBuddy(List<BuddyInfo> buddyList) {
        if (buddyList != null) {
            for (BuddyInfo buddy : buddyList) {
                ContentValues query = new ContentValues();
                query.put(DatabaseHelper.KEY_USERNO, Long.valueOf(buddy.getUserNo()));
                ContentValues execute = new ContentValues();
                if (buddy.getBlock().equals("Y")) {
                    ContentValues contentValue = new ContentValues();
                    contentValue.put(DatabaseHelper.KEY_USERNO, Long.valueOf(buddy.getUserNo()));
                    deleteGroupBuddyMap(contentValue);
                    execute.put(DatabaseHelper.KEY_BLOCK, (Integer) 1);
                } else {
                    execute.put(DatabaseHelper.KEY_BLOCK, (Integer) 0);
                }
                updateBuddy(execute, query);
            }
        }
        return 0L;
    }

    public long blockBuddy(Long userNo, boolean isBlock) {
        ContentValues query = new ContentValues();
        query.put(DatabaseHelper.KEY_USERNO, userNo);
        ContentValues execute = new ContentValues();
        if (isBlock) {
            execute.put(DatabaseHelper.KEY_BLOCK, (Integer) 1);
        } else {
            execute.put(DatabaseHelper.KEY_BLOCK, (Integer) 0);
        }
        updateBuddy(execute, query);
        return 0L;
    }

    public long hideBuddy(Long userNo, boolean isHidden) {
        ContentValues query = new ContentValues();
        query.put(DatabaseHelper.KEY_USERNO, userNo);
        ContentValues execute = new ContentValues();
        if (isHidden) {
            execute.put(DatabaseHelper.KEY_HIDE, (Integer) 1);
        } else {
            execute.put(DatabaseHelper.KEY_HIDE, (Integer) 0);
            execute.put(DatabaseHelper.KEY_FRESHBUDDY, (Integer) 1);
        }
        return updateBuddy(execute, query);
    }

    public long favoriteBuddy(long userNo, boolean isFavorite) {
        ContentValues query = new ContentValues();
        query.put(DatabaseHelper.KEY_USERNO, Long.valueOf(userNo));
        ContentValues execute = new ContentValues();
        if (isFavorite) {
            execute.put(DatabaseHelper.KEY_FAVORITE, (Integer) 1);
        } else {
            execute.put(DatabaseHelper.KEY_FAVORITE, (Integer) 0);
        }
        return updateBuddy(execute, query);
    }

    public long changeBuddyName(long userNo, String editedUserName) {
        ContentValues query = new ContentValues();
        query.put(DatabaseHelper.KEY_USERNO, Long.valueOf(userNo));
        ContentValues execute = new ContentValues();
        if (editedUserName != null) {
            execute.put(DatabaseHelper.KEY_EDITEDNAME, editedUserName);
            execute.put(DatabaseHelper.KEY_DISPLAYNAME, editedUserName);
        }
        return updateBuddy(execute, query);
    }

    public long changeBuddyMainPhoneNo(long userNo, String mainPhoneNo) {
        ContentValues query = new ContentValues();
        query.put(DatabaseHelper.KEY_USERNO, Long.valueOf(userNo));
        ContentValues execute = new ContentValues();
        execute.put(DatabaseHelper.KEY_FIRSTNUMBER, mainPhoneNo);
        return updateBuddy(execute, query);
    }

    public long updateBuddyInDB(BuddyInfo buddy) {
        ContentValues query = new ContentValues();
        query.put(DatabaseHelper.KEY_USERNO, Long.valueOf(buddy.getUserNo()));
        Cursor rawCursor = selectBuddyByUserNoWithNoException(buddy.getUserNo());
        if (rawCursor == null || rawCursor.getCount() == 0) {
            if (rawCursor != null) {
                rawCursor.close();
            }
            return insertBuddyInfotoDB(buddy);
        }
        rawCursor.moveToFirst();
        updateIDNumber(buddy);
        if (buddy.getProfileImgUpdateDate() == null) {
            BuddyImageUtil.deleteBuddyThumbnailImage(buddy.getUserNo());
        } else if (rawCursor.getLong(20) < buddy.getProfileImgUpdateDate().getTime()) {
            BuddyImageUtil.updateBuddyThumbnail(buddy.getUserNo());
        }
        ContentValues execute = ValueObjectConverter.makeBuddyContentValuesFromBuddyInfo(buddy, null, false, false);
        rawCursor.close();
        return updateBuddy(execute, query);
    }

    public long deleteBuddyInDB(long userNo) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.KEY_USERNO, Long.valueOf(userNo));
        deleteBuddy(contentValue);
        deleteGroupBuddyMap(contentValue);
        deleteIDNumber(contentValue);
        BuddyImageUtil.deleteBuddyThumbnailImage(userNo);
        return 0L;
    }

    public long updateBuddyInfos(List<BuddyInfo> buddys, List<BuddyGroupInfo> groups, List<BuddyGroupInfo> delGroups, List<BuddyGroupMapInfo> groupMaps, List<BuddyGroupMapInfo> delGroupMaps) {
        if (buddys != null) {
            for (BuddyInfo buddy : buddys) {
                if (!ChatONSettingData.getInstance().isUseBuddySuggestion()) {
                    Log.m2958e("BUDDY_TRACE isUseBuddySuggestion false");
                    if (buddy.getBuddyCode() == null || !buddy.getBuddyCode().equals("1")) {
                    }
                }
                if (buddy.getExcludeMe() != null && buddy.getExcludeMe().equals("Y")) {
                    if (isSuggestionUser(buddy.getUserID())) {
                        Log.m2958e("BUDDY_TRACE this buddy's excludeme is true But alreay in my suggestion List - Delete!");
                        ContentValues cv = new ContentValues();
                        cv.put(DatabaseHelper.KEY_USERNO, Long.valueOf(buddy.getUserNo()));
                        Log.m2958e("BUDDY_TRACE BuddyInfo.DATA_YES deleteBuddy");
                        deleteBuddy(cv);
                    } else {
                        Log.m2958e("BUDDY_TRACE this buddy's excludeme is true Skip!");
                    }
                } else if (buddy.getDelete().equals("Y")) {
                    deleteBuddyInDB(buddy.getUserNo());
                } else {
                    updateBuddyInDB(buddy);
                }
            }
        }
        if (groups != null) {
            for (BuddyGroupInfo group : groups) {
                updateBuddyGroup(group);
            }
        }
        if (groupMaps != null) {
            for (BuddyGroupMapInfo BGMI : groupMaps) {
                updateGroupBuddyMap(BGMI);
            }
        }
        deleteGroupBuddyMap(delGroupMaps);
        if (delGroups != null) {
            for (BuddyGroupInfo delGroup : delGroups) {
                deleteBuddyGroupForUpdate(delGroup.getGroupCode());
            }
            return 1L;
        }
        return 1L;
    }

    public boolean isBlockUser(String userID) {
        boolean retVal = false;
        if (this.mDb == null || !this.mDb.isOpen()) {
            return false;
        }
        String sql = "SELECT _id from buddy WHERE block = " + Integer.toString(1) + " AND " + DatabaseHelper.KEY_USERID + " = '" + userID + "'";
        Cursor cursor = this.mDb.rawQuery(sql, null);
        if (cursor != null && cursor.moveToFirst()) {
            retVal = true;
        }
        if (cursor != null) {
            cursor.close();
        }
        return retVal;
    }

    public boolean isSuggestionUser(String userID) {
        boolean retVal = false;
        if (this.mDb == null || !this.mDb.isOpen()) {
            return false;
        }
        String sql = "SELECT _id from buddy WHERE suggestion = " + Integer.toString(1) + " AND " + DatabaseHelper.KEY_USERID + " = '" + userID + "'";
        Cursor cursor = this.mDb.rawQuery(sql, null);
        if (cursor != null && cursor.moveToFirst()) {
            retVal = true;
        }
        if (cursor != null) {
            cursor.close();
        }
        return retVal;
    }

    public boolean isBlockUser(long userNo) {
        boolean retVal = false;
        if (this.mDb == null || !this.mDb.isOpen()) {
            return false;
        }
        String sql = "SELECT _id from buddy WHERE block = " + Integer.toString(1) + " AND " + DatabaseHelper.KEY_USERNO + " = " + String.valueOf(userNo);
        Cursor cursor = this.mDb.rawQuery(sql, null);
        if (cursor != null && cursor.moveToFirst()) {
            retVal = true;
        }
        if (cursor != null) {
            cursor.close();
        }
        return retVal;
    }

    public BuddyInfo findBuddyByAccountID(String accountID) {
        Cursor cursor = selectBuddyByAccountID(accountID);
        if (cursor != null && cursor.moveToFirst()) {
            BuddyInfo bi = ValueObjectConverter.makeBuddyInfoFromBuddyCursor(cursor);
            cursor.close();
            return bi;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    public BuddyInfo findBuddyByUserID(String userID) {
        Cursor cursor = selectBuddyByUserID(userID);
        if (cursor != null && cursor.moveToFirst()) {
            BuddyInfo retBI = ValueObjectConverter.makeBuddyInfoFromBuddyCursor(cursor);
            cursor.close();
            return retBI;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    public BuddyInfo findBuddyByUserIDForCallLogDetail(String userID) {
        Cursor cursor = selectBuddyByUserIDWithNoExceptionForCallLogDetail(userID);
        if (cursor != null && cursor.moveToFirst()) {
            BuddyInfo retBI = ValueObjectConverter.makeBuddyInfoFromBuddyCursor(cursor);
            cursor.close();
            return retBI;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    public long insertBuddy(ContentValues value) {
        if (this.mDb == null || !this.mDb.isOpen() || value == null) {
            return -1L;
        }
        long count = this.mDb.insert("buddy", null, value);
        return count;
    }

    public long insertBuddy(ArrayList<ContentValues> buddyValues) {
        MainApplication.mPhoneManager.lockDatabaseLock();
        this.mDb.beginTransaction();
        try {
            Iterator<ContentValues> it = buddyValues.iterator();
            while (it.hasNext()) {
                ContentValues cv = it.next();
                insertBuddy(cv);
            }
            this.mDb.setTransactionSuccessful();
            this.mDb.endTransaction();
            MainApplication.mPhoneManager.releaseDatabaseLock();
            return 1L;
        } catch (Throwable th) {
            this.mDb.endTransaction();
            MainApplication.mPhoneManager.releaseDatabaseLock();
            throw th;
        }
    }

    public Cursor selectBuddyByUserID(String UserID) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from buddy WHERE userid = '" + UserID + "' AND " + getWhereStringforNotHideNotBlockNotRemovedNotSuggestion();
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectBuddyByAccountID(String accountID) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from buddy WHERE accountid = '" + accountID + "' AND " + getWhereStringforNotHideNotBlockNotRemovedNotSuggestion();
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectBuddyByAccountIDWithNoException(String accountID) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from buddy WHERE accountid = '" + accountID + "'";
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectBuddyByUserNo(long UserNo) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from buddy WHERE userno = " + UserNo + " AND " + getWhereStringforNotHideNotBlockNotRemovedNotSuggestion();
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectBuddyByUserNoForAutoBuddy(long UserNo) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from buddy WHERE userno = " + UserNo;
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectBuddyByUserNoWithNoException(long UserNo) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from buddy WHERE userno = " + UserNo;
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectBuddyByUserIDWithNoException(String userID) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from buddy WHERE userid = '" + userID + "'";
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectBuddyByUserIDWithNoExceptionForCallLogDetail(String userID) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from buddy WHERE userid = '" + userID + "' AND " + getWhereStringforNotHideNotBlockNotRemoved();
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectBuddyForBuddyList() {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from buddy WHERE " + getWhereStringforNotHideNotBlockNotRemovedNotSuggestion() + " ORDER BY " + DatabaseHelper.KEY_DISPLAYNAME + " ASC";
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectBuddyForAddMemberList(ArrayList<Long> userNos) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from buddy WHERE " + getWhereStringforNotHideNotBlockNotRemovedNotSuggestion() + (!userNos.isEmpty() ? getWhereStringForAddMamberList(userNos) : "") + " ORDER BY " + DatabaseHelper.KEY_DISPLAYNAME + " ASC";
        return this.mDb.rawQuery(sql, null);
    }

    public String getWhereStringForAddMamberList(ArrayList<Long> userNos) {
        StringBuilder builder = new StringBuilder();
        builder.append(" AND ");
        builder.append(DatabaseHelper.KEY_USERNO);
        builder.append(" NOT IN (");
        for (int i = 0; i < userNos.size(); i++) {
            builder.append(String.valueOf(userNos.get(i)));
            builder.append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append(")");
        return builder.toString();
    }

    public Cursor selectBuddyForNewList() {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from buddy WHERE " + getWhereStringforNotHideNotBlockNotRemovedNotSuggestion() + " AND " + DatabaseHelper.KEY_FRESHBUDDY + " = " + Integer.toString(1) + " ORDER BY " + DatabaseHelper.KEY_DISPLAYNAME + " ASC";
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectBuddyForFavoriteList() {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from buddy WHERE " + getWhereStringforNotHideNotBlockNotRemovedNotSuggestion() + " AND " + DatabaseHelper.KEY_FAVORITE + " = " + Integer.toString(1) + " ORDER BY " + DatabaseHelper.KEY_DISPLAYNAME + " ASC";
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectBuddyForFavoriteListForAddMember(ArrayList<Long> memberUserNumbers) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from buddy WHERE " + getWhereStringforNotHideNotBlockNotRemovedNotSuggestion() + (!memberUserNumbers.isEmpty() ? getWhereStringForAddMamberList(memberUserNumbers) : "") + " AND " + DatabaseHelper.KEY_FAVORITE + " = " + Integer.toString(1) + " ORDER BY " + DatabaseHelper.KEY_DISPLAYNAME + " ASC";
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectBuddyForSuggestionList() {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from buddy WHERE " + getWhereStringforNotHideNotBlockNotRemoved() + " AND " + DatabaseHelper.KEY_SUGGESTION + " = " + Integer.toString(1) + " ORDER BY " + DatabaseHelper.KEY_DISPLAYNAME + " ASC";
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectBuddyForBlockList() {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from buddy WHERE " + getWhereStringforNotHideNotRemovedNotSuggestion() + " AND " + DatabaseHelper.KEY_BLOCK + " = " + Integer.toString(1) + " ORDER BY " + DatabaseHelper.KEY_DISPLAYNAME + " ASC";
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectBuddyForHideList() {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from buddy WHERE " + getWhereStringforNotBlockNotRemovedNotSuggestion() + " AND " + DatabaseHelper.KEY_HIDE + " = " + Integer.toString(1) + " ORDER BY " + DatabaseHelper.KEY_DISPLAYNAME + " ASC";
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectBuddyAll() {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        return this.mDb.rawQuery("SELECT * from  buddy", null);
    }

    public long updateBuddy(ContentValues value, ContentValues where) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return -1L;
        }
        String strWhere = ContentValuesUtil.getStringByContentValuesForWhere(where, null);
        return this.mDb.update("buddy", value, strWhere, null);
    }

    public long updateBuddy(Set<Map.Entry<ContentValues, ContentValues>> entrySet) {
        if (this.mDb == null || !this.mDb.isOpen() || entrySet == null) {
            return -1L;
        }
        MainApplication.mPhoneManager.lockDatabaseLock();
        this.mDb.beginTransaction();
        try {
            for (Map.Entry<ContentValues, ContentValues> entry : entrySet) {
                ContentValues values = entry.getKey();
                ContentValues where = entry.getValue();
                if (values == null || where == null) {
                    return -1L;
                }
                String strWhere = ContentValuesUtil.getStringByContentValuesForWhere(where, null);
                String strValue = ContentValuesUtil.getStringByContentValuesForValue(values);
                String strSql = "UPDATE buddy SET " + strValue + C1265a.f3172e + strWhere + Config.KEYVALUE_SPLIT;
                this.mDb.execSQL(strSql);
            }
            this.mDb.setTransactionSuccessful();
            this.mDb.endTransaction();
            MainApplication.mPhoneManager.releaseDatabaseLock();
            return 1L;
        } finally {
            this.mDb.endTransaction();
            MainApplication.mPhoneManager.releaseDatabaseLock();
        }
    }

    public long deleteBuddy(ContentValues where) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return -1L;
        }
        String strWhere = ContentValuesUtil.getStringByContentValuesForWhere(where, null);
        return this.mDb.delete("buddy", strWhere, null);
    }

    public long insertBuddyGroup(BuddyGroupInfo buddyGroup) {
        ContentValues query = new ContentValues();
        query.put(DatabaseHelper.KEY_GROUPID, Long.valueOf(buddyGroup.getGroupCode()));
        Cursor rawCursor = selectBuddyGroupByGroupID(buddyGroup.getGroupCode());
        if (rawCursor != null && rawCursor.getCount() > 0 && rawCursor.moveToFirst()) {
            ContentValues execute = new ContentValues();
            execute.put(DatabaseHelper.KEY_GROUPNAME, buddyGroup.getGroupName());
            if (buddyGroup.getGroupImgUpdateDate() != null) {
                if (rawCursor.getLong(3) < buddyGroup.getGroupImgUpdateDate().getTime()) {
                    BuddyImageUtil.updateGroupThumbnail(buddyGroup.getGroupCode());
                }
                execute.put(DatabaseHelper.KEY_IMAGEUPDATEDATE, Long.valueOf(buddyGroup.getGroupImgUpdateDate().getTime()));
            } else {
                Date resetDate = new Date();
                resetDate.setTime(0L);
                BuddyImageUtil.deleteGroupThumbnailImage(buddyGroup.getGroupCode());
                execute.put(DatabaseHelper.KEY_IMAGEUPDATEDATE, Long.valueOf(resetDate.getTime()));
            }
            if (buddyGroup.getUpdateDate() != null) {
                execute.put(DatabaseHelper.KEY_UPDATEDATE, Long.valueOf(buddyGroup.getUpdateDate().getTime()));
            }
            rawCursor.close();
            return updateBuddyGroup(execute, query);
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return insertBuddyGroup(ValueObjectConverter.makeBuddyGroupContentValuesFormBuddyGroupInfo(buddyGroup));
    }

    public long updateBuddyGroup(BuddyGroupInfo buddyGroup) {
        ContentValues query = new ContentValues();
        query.put(DatabaseHelper.KEY_GROUPID, Long.valueOf(buddyGroup.getGroupCode()));
        Cursor rawCursor = selectBuddyGroupByGroupID(buddyGroup.getGroupCode());
        if (rawCursor != null && rawCursor.getCount() > 0 && rawCursor.moveToFirst()) {
            ContentValues execute = new ContentValues();
            execute.put(DatabaseHelper.KEY_GROUPNAME, buddyGroup.getGroupName());
            if (buddyGroup.getGroupImgUpdateDate() != null) {
                if (rawCursor.getLong(3) < buddyGroup.getGroupImgUpdateDate().getTime()) {
                    BuddyImageUtil.updateGroupThumbnail(buddyGroup.getGroupCode());
                }
                execute.put(DatabaseHelper.KEY_IMAGEUPDATEDATE, Long.valueOf(buddyGroup.getGroupImgUpdateDate().getTime()));
            } else {
                Date resetDate = new Date();
                resetDate.setTime(0L);
                BuddyImageUtil.deleteGroupThumbnailImage(buddyGroup.getGroupCode());
                execute.put(DatabaseHelper.KEY_IMAGEUPDATEDATE, Long.valueOf(resetDate.getTime()));
            }
            if (buddyGroup.getUpdateDate() != null) {
                execute.put(DatabaseHelper.KEY_UPDATEDATE, Long.valueOf(buddyGroup.getUpdateDate().getTime()));
            }
            rawCursor.close();
            return updateBuddyGroup(execute, query);
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return insertBuddyGroup(ValueObjectConverter.makeBuddyGroupContentValuesFormBuddyGroupInfo(buddyGroup));
    }

    public long deleteBuddyGroup(long groupCode) {
        ContentValues query = new ContentValues();
        query.put(DatabaseHelper.KEY_GROUPID, Long.valueOf(groupCode));
        BuddyImageUtil.deleteGroupThumbnailImage(groupCode);
        deleteGroupBuddyMap(query);
        return deleteBuddyGroup(query);
    }

    public long deleteBuddyGroupForUpdate(long groupCode) {
        ContentValues query = new ContentValues();
        query.put(DatabaseHelper.KEY_GROUPID, Long.valueOf(groupCode));
        BuddyImageUtil.deleteGroupThumbnailImage(groupCode);
        return deleteBuddyGroup(query);
    }

    public long insertGroupBuddyMap(List<BuddyGroupMapInfo> mapInfoList) {
        if (mapInfoList != null) {
            for (BuddyGroupMapInfo info : mapInfoList) {
                ContentValues value = new ContentValues();
                value.put(DatabaseHelper.KEY_GROUPID, Long.valueOf(info.getGroupCode()));
                if (info.getUpdateDate() != null) {
                    value.put(DatabaseHelper.KEY_UPDATEDATE, Long.valueOf(info.getUpdateDate().getTime()));
                }
                value.put(DatabaseHelper.KEY_USERNO, Long.valueOf(info.getUserNo()));
                insertGroupBuddyMap(value);
            }
            return 1L;
        }
        return 1L;
    }

    public long deleteGroupBuddyMap(List<BuddyGroupMapInfo> mapInfoList) {
        if (mapInfoList != null) {
            for (BuddyGroupMapInfo info : mapInfoList) {
                ContentValues value = new ContentValues();
                value.put(DatabaseHelper.KEY_GROUPID, Long.valueOf(info.getGroupCode()));
                value.put(DatabaseHelper.KEY_USERNO, Long.valueOf(info.getUserNo()));
                deleteGroupBuddyMap(value);
            }
            return 1L;
        }
        return 1L;
    }

    public long insertBuddyGroup(ContentValues value) {
        if (this.mDb == null || !this.mDb.isOpen() || value == null) {
            return -1L;
        }
        long count = this.mDb.insert(DatabaseHelper.BUDDYGROUP_TABLE, null, value);
        return count;
    }

    public long insertBuddyGroup(ArrayList<ContentValues> alValues) {
        if (alValues != null) {
            MainApplication.mPhoneManager.lockDatabaseLock();
            this.mDb.beginTransaction();
            try {
                StringBuilder sbKey = new StringBuilder(1000);
                StringBuilder sbValue = new StringBuilder(1000);
                for (int i = 0; i < alValues.size(); i++) {
                    ContentValues value = alValues.get(i);
                    value.valueSet();
                    if (value != null && value.size() > 0) {
                        sbKey.delete(0, sbKey.length());
                        sbValue.delete(0, sbValue.length());
                        Set<Map.Entry<String, Object>> entrySet = value.valueSet();
                        boolean bComma = false;
                        for (Map.Entry<String, Object> entry : entrySet) {
                            if (bComma) {
                                sbKey.append(", ");
                                sbValue.append(", ");
                            }
                            sbKey.append(entry.getKey());
                            Object obj = entry.getValue();
                            if (obj == null) {
                                sbValue.append("NULL");
                            } else if (obj instanceof Integer) {
                                sbValue.append(((Integer) obj).toString());
                            } else if (obj instanceof Long) {
                                sbValue.append(((Long) obj).toString());
                            } else if (obj instanceof String) {
                                sbValue.append("\"").append((String) obj).append("\"");
                            }
                            bComma = true;
                        }
                        String strInsertQry = "INSERT INTO buddygroup (" + ((Object) sbKey) + ") VALUES (" + ((Object) sbValue) + ");";
                        this.mDb.execSQL(strInsertQry);
                    }
                }
                this.mDb.setTransactionSuccessful();
            } finally {
                this.mDb.endTransaction();
                MainApplication.mPhoneManager.releaseDatabaseLock();
            }
        }
        return 1L;
    }

    public Cursor selectBuddyGroupAll() {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        return this.mDb.rawQuery("SELECT * from buddygroup ORDER BY groupname ASC", null);
    }

    public Cursor selectBuddyGroupForAddMember(long groupCode) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from buddygroup WHERE NOT groupid = " + groupCode;
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectBuddyGroupByGroupID(long groupID) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from buddygroup WHERE groupid = " + groupID;
        return this.mDb.rawQuery(sql, null);
    }

    public long getBuddyGroupIDByGroupName(String groupname) {
        Cursor rawCursor = selectBuddyGroupByGroupName(groupname);
        long retValue = -1;
        if (rawCursor != null && rawCursor.moveToFirst()) {
            retValue = rawCursor.getLong(2);
            rawCursor.close();
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return retValue;
    }

    public ArrayList<Long> getGroupNoListBYUserNo(long userNo) {
        Cursor rawCursor = selectGroupBuddyMapByUserNo(userNo);
        ArrayList<Long> retGroupNoList = new ArrayList<>();
        if (rawCursor != null && rawCursor.getCount() > 0 && rawCursor.moveToFirst()) {
            do {
                retGroupNoList.add(Long.valueOf(rawCursor.getLong(1)));
            } while (rawCursor.moveToNext());
            rawCursor.close();
            return retGroupNoList;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return null;
    }

    public String getBuddyGroupNameByGroupID(long groupID) {
        Cursor rawCursor = selectBuddyGroupByGroupID(groupID);
        String retValue = null;
        if (rawCursor != null && rawCursor.moveToFirst()) {
            retValue = rawCursor.getString(1);
            rawCursor.close();
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return retValue;
    }

    public Cursor selectBuddyGroupByGroupName(String groupName) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        return this.mDb.rawQuery("SELECT * from buddygroup WHERE groupname = ?", new String[]{groupName});
    }

    public long updateBuddyGroup(ContentValues value, ContentValues where) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return -1L;
        }
        String strWhere = ContentValuesUtil.getStringByContentValuesForWhere(where, null);
        return this.mDb.update(DatabaseHelper.BUDDYGROUP_TABLE, value, strWhere, null);
    }

    public long deleteBuddyGroup(ContentValues where) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return -1L;
        }
        String strWhere = ContentValuesUtil.getStringByContentValuesForWhere(where, null);
        return this.mDb.delete(DatabaseHelper.BUDDYGROUP_TABLE, strWhere, null);
    }

    public long insertGroupBuddyMap(ContentValues value) {
        if (this.mDb == null || !this.mDb.isOpen() || value == null) {
            return -1L;
        }
        long count = this.mDb.insert(DatabaseHelper.GROUPBUDDYMAP_TABLE, null, value);
        return count;
    }

    public Cursor selectGroupBuddyMapByGroupID(long groupID) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from groupbuddymap WHERE groupid = " + groupID;
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectGroupBuddyMapByUserNo(long userNo) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from groupbuddymap WHERE userno = " + userNo;
        return this.mDb.rawQuery(sql, null);
    }

    public long updateGroupBuddyMap(ContentValues value, ContentValues where) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return -1L;
        }
        String strWhere = ContentValuesUtil.getStringByContentValuesForWhere(where, null);
        return this.mDb.update(DatabaseHelper.GROUPBUDDYMAP_TABLE, value, strWhere, null);
    }

    public Cursor selectBuddyGroupMapForUpdate(BuddyGroupMapInfo BGMI) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from groupbuddymap WHERE groupid = " + BGMI.getGroupCode() + " AND " + DatabaseHelper.KEY_USERNO + " = " + BGMI.getUserNo();
        return this.mDb.rawQuery(sql, null);
    }

    public long updateGroupBuddyMap(BuddyGroupMapInfo BGMI) {
        ContentValues query = new ContentValues();
        query.put(DatabaseHelper.KEY_GROUPID, Long.valueOf(BGMI.getGroupCode()));
        query.put(DatabaseHelper.KEY_USERNO, Long.valueOf(BGMI.getUserNo()));
        Cursor rawCursor = selectBuddyGroupMapForUpdate(BGMI);
        if (rawCursor != null && rawCursor.getCount() > 0 && rawCursor.moveToFirst()) {
            ContentValues execute = new ContentValues();
            execute.put(DatabaseHelper.KEY_UPDATEDATE, Long.valueOf(BGMI.getUpdateDate().getTime()));
            rawCursor.close();
            return updateGroupBuddyMap(execute, query);
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return insertGroupBuddyMap(BGMI);
    }

    public long insertGroupBuddyMap(BuddyGroupMapInfo bGLI) {
        ContentValues value = new ContentValues();
        value.put(DatabaseHelper.KEY_GROUPID, Long.valueOf(bGLI.getGroupCode()));
        value.put(DatabaseHelper.KEY_USERNO, Long.valueOf(bGLI.getUserNo()));
        if (bGLI.getUpdateDate() != null) {
            value.put(DatabaseHelper.KEY_UPDATEDATE, Long.valueOf(bGLI.getUpdateDate().getTime()));
        }
        insertGroupBuddyMap(value);
        return 1L;
    }

    public long deleteGroupBuddyMap(ContentValues where) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return -1L;
        }
        String strWhere = ContentValuesUtil.getStringByContentValuesForWhere(where, null);
        return this.mDb.delete(DatabaseHelper.GROUPBUDDYMAP_TABLE, strWhere, null);
    }

    public long deleteGroupBuddyMapTable() {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return -1L;
        }
        this.mDb.delete(DatabaseHelper.GROUPBUDDYMAP_TABLE, null, null);
        return 1L;
    }

    public long insertIDNumber(ContentValues value) {
        if (this.mDb == null || !this.mDb.isOpen() || value == null) {
            return -1L;
        }
        long count = this.mDb.insert(DatabaseHelper.IDNUMBER_TABLE, null, value);
        return count;
    }

    public long insertIDNumber(ArrayList<ContentValues> alValues) {
        if (alValues == null || alValues.size() <= 0 || this.mDb == null || !this.mDb.isOpen()) {
            return -1L;
        }
        MainApplication.mPhoneManager.lockDatabaseLock();
        this.mDb.beginTransaction();
        try {
            StringBuilder sbKey = new StringBuilder(1000);
            StringBuilder sbValue = new StringBuilder(1000);
            for (int i = 0; i < alValues.size(); i++) {
                ContentValues value = alValues.get(i);
                value.valueSet();
                if (value != null && value.size() > 0) {
                    sbKey.delete(0, sbKey.length());
                    sbValue.delete(0, sbValue.length());
                    Set<Map.Entry<String, Object>> entrySet = value.valueSet();
                    boolean bComma = false;
                    for (Map.Entry<String, Object> entry : entrySet) {
                        if (bComma) {
                            sbKey.append(", ");
                            sbValue.append(", ");
                        }
                        sbKey.append(entry.getKey());
                        Object obj = entry.getValue();
                        if (obj == null) {
                            sbValue.append("NULL");
                        } else if (obj instanceof Integer) {
                            sbValue.append(((Integer) obj).toString());
                        } else if (obj instanceof Long) {
                            sbValue.append(((Long) obj).toString());
                        } else if (obj instanceof String) {
                            sbValue.append("\"").append((String) obj).append("\"");
                        }
                        bComma = true;
                    }
                    String strInsertQry = "INSERT INTO idnumber (" + ((Object) sbKey) + ") VALUES (" + ((Object) sbValue) + ");";
                    this.mDb.execSQL(strInsertQry);
                }
            }
            this.mDb.setTransactionSuccessful();
            this.mDb.endTransaction();
            MainApplication.mPhoneManager.releaseDatabaseLock();
            return 1L;
        } catch (Throwable th) {
            this.mDb.endTransaction();
            MainApplication.mPhoneManager.releaseDatabaseLock();
            throw th;
        }
    }

    public Cursor selectIDNumberByUserNo(long UserNo) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from idnumber WHERE userno = " + UserNo;
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectRegionCodeByRegion(long region) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from regioncode WHERE code = " + region;
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectRegionCode() {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        return this.mDb.rawQuery("SELECT * from regioncode", null);
    }

    public Cursor selectIDNumberByUserID(String userID) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from idnumber WHERE userid = '" + userID + "'";
        return this.mDb.rawQuery(sql, null);
    }

    public Cursor selectIDNumberByPhoneNo(String PhoneNo) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        String sql = "SELECT * from idnumber WHERE phoneno = '" + PhoneNo + "'";
        return this.mDb.rawQuery(sql, null);
    }

    private Cursor selectPhoneNoAndAccountID() {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        return this.mDb.rawQuery("SELECT DISTINCT a.accountid, a.userno, a.userid, b.phoneno from buddy a, idnumber b WHERE a.userno = b.userno and a.block = 0 and a.hide = 0 and a.suggestion = 0", null);
    }

    private Cursor selectPhoneNoAndAccountIDforAutoBuddy() {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        Log.m2958e("<<YHT23>> selectPhoneNoAndAccountIDforAutoBuddy!! query:SELECT DISTINCT a.userno, b.phoneno from buddy a, idnumber b WHERE a.userno = b.userno and a.block = 0 and a.hide = 0 and a.suggestion = 0");
        return this.mDb.rawQuery("SELECT DISTINCT a.userno, b.phoneno from buddy a, idnumber b WHERE a.userno = b.userno and a.block = 0 and a.hide = 0 and a.suggestion = 0", null);
    }

    public Cursor selectIDNumbersByPhoneNos(List<String> phoneNos) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        return this.mDb.rawQuery("SELECT * from idnumber WHERE phoneno in ('111'", null);
    }

    public long updateIDNumber(BuddyInfo buddy) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.KEY_USERID, buddy.getUserID());
        deleteIDNumber(contentValue);
        String BuddyFirstNumber = getFirstNumberBYUserNo(buddy.getUserNo());
        ArrayList<com.coolots.p2pmsg.model.PhoneNoInfo> PhonNumberList = (ArrayList) buddy.getPhoneNoList();
        boolean findNumber = false;
        if (!PhonNumberList.isEmpty() && BuddyFirstNumber != null) {
            Iterator<com.coolots.p2pmsg.model.PhoneNoInfo> it = PhonNumberList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.coolots.p2pmsg.model.PhoneNoInfo pNI = it.next();
                if (pNI != null && pNI.getPhoneNo().equals(BuddyFirstNumber)) {
                    findNumber = true;
                    break;
                }
            }
        }
        if (!findNumber) {
            ContentValues execute = new ContentValues();
            execute.put(DatabaseHelper.KEY_FIRSTNUMBER, "");
            ContentValues numberQuery = new ContentValues();
            numberQuery.put(DatabaseHelper.KEY_USERNO, Long.valueOf(buddy.getUserNo()));
            updateBuddy(execute, numberQuery);
        }
        insertIDNumber(ValueObjectConverter.makeIDNumberContentValuesFromBuddyInfo(buddy));
        return 1L;
    }

    public long deleteIDNumber(ContentValues where) {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return -1L;
        }
        String strWhere = ContentValuesUtil.getStringByContentValuesForWhere(where, null);
        return this.mDb.delete(DatabaseHelper.IDNUMBER_TABLE, strWhere, null);
    }

    public ArrayList<BuddyListChildItem> getBuddyRawData(int preIndex) {
        Cursor rawCursor = null;
        if (preIndex == 4) {
            rawCursor = selectBuddyForBuddyList();
        } else if (preIndex == 1) {
            rawCursor = selectBuddyForNewList();
        } else if (preIndex == 2) {
            rawCursor = selectBuddyForFavoriteList();
        }
        if (rawCursor != null && rawCursor.moveToFirst()) {
            new ArrayList();
            ArrayList<BuddyListChildItem> rawBuddyItemArray = ValueObjectConverter.makeBuddyListChildItemArrayFromBuddyCursor(rawCursor);
            rawCursor.close();
            return rawBuddyItemArray;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return null;
    }

    public ArrayList<BuddyListChildItem> getBuddyRawDataForAddMemberInFavorite(ArrayList<Long> memberUserNumbers) {
        Cursor rawCursor = selectBuddyForFavoriteListForAddMember(memberUserNumbers);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            new ArrayList();
            ArrayList<BuddyListChildItem> rawBuddyItemArray = ValueObjectConverter.makeBuddyListChildItemArrayFromBuddyCursor(rawCursor);
            rawCursor.close();
            return rawBuddyItemArray;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return null;
    }

    public ArrayList<BuddyListChildItem> getBuddyListChildItemByUserNo(long userNo) {
        Cursor rawCursor = selectBuddyByUserNo(userNo);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            new ArrayList();
            ArrayList<BuddyListChildItem> rawBuddyItemArray = ValueObjectConverter.makeBuddyListChildItemArrayFromBuddyCursor(rawCursor);
            rawCursor.close();
            return rawBuddyItemArray;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return null;
    }

    public ArrayList<BuddyListChildItem> getBuddyRawDataForAddMemberList(ArrayList<Long> userNos) {
        Cursor rawCursor = selectBuddyForAddMemberList(userNos);
        if (rawCursor != null && rawCursor.getCount() > 0 && rawCursor.moveToFirst()) {
            new ArrayList();
            ArrayList<BuddyListChildItem> rawBuddyItemArray = ValueObjectConverter.makeBuddyListChildItemArrayFromBuddyCursor(rawCursor);
            rawCursor.close();
            return rawBuddyItemArray;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return null;
    }

    public Cursor getGroupListDataVOCursor() {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        return this.mDb.rawQuery("SELECT a.groupid, a.userno, b.displayname from groupbuddymap a, buddy b, buddygroup c WHERE a.userno = b.userno AND a.groupid = c.groupid ORDER BY c.groupname, b.displayname ASC", null);
    }

    public ArrayList<BuddyGroupTable> getBuddyGroupRawData() {
        Cursor rawCursor = selectBuddyGroupAll();
        ArrayList<BuddyGroupTable> rawBuddyGroupArray = new ArrayList<>();
        if (rawCursor != null && rawCursor.moveToFirst()) {
            do {
                rawBuddyGroupArray.add(ValueObjectConverter.makeBuddyGroupTableFromCursor(rawCursor));
            } while (rawCursor.moveToNext());
            rawCursor.close();
            return rawBuddyGroupArray;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return null;
    }

    public ArrayList<BuddyGroupTable> getBuddyGroupRawDataForAddMember(long groupCode) {
        Cursor rawCursor = selectBuddyGroupForAddMember(groupCode);
        ArrayList<BuddyGroupTable> rawBuddyGroupArray = new ArrayList<>();
        if (rawCursor != null && rawCursor.moveToFirst()) {
            do {
                rawBuddyGroupArray.add(ValueObjectConverter.makeBuddyGroupTableFromCursor(rawCursor));
            } while (rawCursor.moveToNext());
            rawCursor.close();
            return rawBuddyGroupArray;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return null;
    }

    public ArrayList<GroupBuddyMapTable> getGroupBuddyMapRawDataByGroupID(long groupID) {
        Cursor rawCursor = selectGroupBuddyMapByGroupID(groupID);
        ArrayList<GroupBuddyMapTable> rawGroupBuddyMapArray = new ArrayList<>();
        if (rawCursor != null && rawCursor.moveToFirst()) {
            do {
                rawGroupBuddyMapArray.add(ValueObjectConverter.makeGroupBuddyMapTableFromCursor(rawCursor));
            } while (rawCursor.moveToNext());
            rawCursor.close();
            return rawGroupBuddyMapArray;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return null;
    }

    public String getDisplayNameByUserID(String userID) {
        String retValue = null;
        Cursor rawCursor = selectBuddyByUserID(userID);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            try {
                retValue = rawCursor.getString(4);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
            } finally {
                rawCursor.close();
            }
            return retValue;
        }
        if (rawCursor != null) {
        }
        return null;
    }

    public String findBuddyByUserNoForAddBuddyList(long userNo) {
        String retValue = null;
        Cursor rawCursor = selectBuddyByUserNoWithNoException(userNo);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            try {
                retValue = rawCursor.getString(4);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
            } finally {
                rawCursor.close();
            }
            return retValue;
        }
        if (rawCursor != null) {
        }
        return null;
    }

    public String getNativeNameByUserNo(long userNO) {
        String retValue = null;
        Cursor rawCursor = selectBuddyByUserNo(userNO);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            try {
                retValue = rawCursor.getString(6);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
            } finally {
                rawCursor.close();
            }
            return retValue;
        }
        if (rawCursor != null) {
        }
        return null;
    }

    public String getBuddyNameByUserNo(long userNO) {
        String retValue = null;
        Cursor rawCursor = selectBuddyByUserNoWithNoException(userNO);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            try {
                retValue = rawCursor.getString(7);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
            } finally {
                rawCursor.close();
            }
            return retValue;
        }
        if (rawCursor != null) {
        }
        return null;
    }

    public String getBuddyNameByUserID(String userID) {
        String retValue = null;
        Cursor rawCursor = selectBuddyByUserIDWithNoException(userID);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            try {
                retValue = rawCursor.getString(7);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
            } finally {
                rawCursor.close();
            }
            return retValue;
        }
        if (rawCursor != null) {
        }
        return null;
    }

    public String getDisplayNameByUserNo(long userNo) {
        String retValue = null;
        Cursor rawCursor = selectBuddyByUserNo(userNo);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            try {
                retValue = rawCursor.getString(4);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
            } finally {
                rawCursor.close();
            }
            return retValue;
        }
        if (rawCursor != null) {
        }
        return null;
    }

    public String getFirstNumberBYUserNo(long userNo) {
        String retValue = null;
        Cursor rawCursor = selectBuddyByUserNo(userNo);
        if (rawCursor == null || !rawCursor.moveToFirst()) {
            return rawCursor != null ? null : null;
        }
        try {
            retValue = rawCursor.getString(12);
        } catch (SQLException e) {
            StackTraceElement[] elems = e.getStackTrace();
            for (StackTraceElement elem : elems) {
                logI(elem.toString());
            }
        } finally {
            rawCursor.close();
        }
        if (retValue == null || retValue.isEmpty()) {
            return null;
        }
        return retValue;
    }

    public ArrayList<String> getPhoneNoArrayListByUserNo(long userNo) {
        ArrayList<String> phoneNoList = new ArrayList<>();
        Cursor rawCursor = selectIDNumberByUserNo(userNo);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            do {
                phoneNoList.add(rawCursor.getString(3));
            } while (rawCursor.moveToNext());
            rawCursor.close();
            return phoneNoList;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return null;
    }

    public ArrayList<String> getPhoneNoArrayListByUserID(String userID) {
        ArrayList<String> phoneNoList = new ArrayList<>();
        Cursor rawCursor = selectIDNumberByUserID(userID);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            do {
                phoneNoList.add(rawCursor.getString(3));
            } while (rawCursor.moveToNext());
            rawCursor.close();
            return phoneNoList;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return null;
    }

    public long getUserNoByAccountID(String accountID) {
        long retValue = -1;
        Cursor rawCursor = selectBuddyByAccountID(accountID);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            try {
                retValue = rawCursor.getLong(1);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
            } finally {
                rawCursor.close();
            }
            return retValue;
        }
        if (rawCursor != null) {
        }
        return -1L;
    }

    public long getUserNoByAccountIDWithNoException(String accountID) {
        long retValue = -1;
        Cursor rawCursor = selectBuddyByAccountIDWithNoException(accountID);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            try {
                retValue = rawCursor.getLong(1);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
            } finally {
                rawCursor.close();
            }
            return retValue;
        }
        if (rawCursor != null) {
        }
        return -1L;
    }

    public long getUserNoByUserID(String userID) {
        long retValue = -1;
        Cursor rawCursor = selectBuddyByUserID(userID);
        if (rawCursor != null && rawCursor.getCount() > 0 && rawCursor.moveToFirst()) {
            try {
                retValue = rawCursor.getLong(1);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
            } finally {
                rawCursor.close();
            }
            return retValue;
        }
        if (rawCursor != null) {
        }
        return -1L;
    }

    public ArrayList<Long> getGroupIDListByMemberCount(int memberCount) {
        ArrayList<Long> retValueList = new ArrayList<>();
        Cursor rawCursor = selectBuddyGroupMapWithMemberCount();
        if (rawCursor != null && rawCursor.moveToFirst()) {
            do {
                if (rawCursor.getInt(rawCursor.getColumnIndex("MEMBERCOUNT")) == memberCount) {
                    retValueList.add(Long.valueOf(rawCursor.getLong(rawCursor.getColumnIndex(DatabaseHelper.KEY_GROUPID))));
                }
            } while (rawCursor.moveToNext());
            rawCursor.close();
            return retValueList;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return null;
    }

    public ArrayList<Long> getMemberNoListByGroupID(long groupCode) {
        ArrayList<Long> retValueList = new ArrayList<>();
        Cursor rawCursor = selectGroupBuddyMapByGroupID(groupCode);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            do {
                retValueList.add(Long.valueOf(rawCursor.getLong(2)));
            } while (rawCursor.moveToNext());
            rawCursor.close();
            return retValueList;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return null;
    }

    public Cursor selectBuddyGroupMapWithMemberCount() {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return null;
        }
        return this.mDb.rawQuery("SELECT groupid, COUNT(userno) AS MEMBERCOUNT FROM groupbuddymap GROUP BY groupid", null);
    }

    public long getUserNoByUserIDWithNoException(String userID) {
        long retValue = -1;
        Cursor rawCursor = selectBuddyByUserIDWithNoException(userID);
        if (rawCursor != null && rawCursor.getCount() > 0 && rawCursor.moveToFirst()) {
            try {
                retValue = rawCursor.getLong(1);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
            } finally {
                rawCursor.close();
            }
            return retValue;
        }
        if (rawCursor != null) {
        }
        return -1L;
    }

    public long getUserNoByPhoneNumber(String PhoneNumber) {
        long retValue = -1;
        Cursor rawCursor = selectIDNumberByPhoneNo(PhoneNumber);
        if (rawCursor != null && rawCursor.getCount() > 0 && rawCursor.moveToFirst()) {
            try {
                retValue = rawCursor.getLong(1);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
            } finally {
                rawCursor.close();
            }
            return retValue;
        }
        if (rawCursor != null) {
        }
        return -1L;
    }

    public String getAccountIDByUserNoWithNoException(long userNo) {
        String retValue = null;
        Cursor rawCursor = selectBuddyByUserNoWithNoException(userNo);
        if (rawCursor != null && rawCursor.getCount() > 0 && rawCursor.moveToFirst()) {
            try {
                retValue = rawCursor.getString(3);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
            } finally {
                rawCursor.close();
            }
            return retValue;
        }
        if (rawCursor != null) {
        }
        return null;
    }

    public long getRegionByUserNo(long userNo) {
        long retValue = -1;
        Cursor rawCursor = selectBuddyByUserNo(userNo);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            try {
                retValue = rawCursor.getLong(9);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
            } finally {
                rawCursor.close();
            }
        } else if (rawCursor != null) {
        }
        return retValue;
    }

    public String getRegionImageURLByUserNo(long userNo) {
        long region = getRegionByUserNo(userNo);
        Cursor rawCursor = selectRegionCodeByRegion(region);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            String URL = rawCursor.getString(2);
            rawCursor.close();
            return URL;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return null;
    }

    public String getRegionImageURLByRegion(long region) {
        Cursor rawCursor = selectRegionCodeByRegion(region);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            String URL = rawCursor.getString(2);
            rawCursor.close();
            return URL;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return null;
    }

    public String getAccountIDByUserNo(long userNo) {
        String retValue = null;
        Cursor rawCursor = selectBuddyByUserNo(userNo);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            try {
                retValue = rawCursor.getString(3);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
            } finally {
                rawCursor.close();
            }
            return retValue;
        }
        if (rawCursor != null) {
        }
        return null;
    }

    public String getUserMessageByUserNO(long userNo) {
        String retValue = null;
        Cursor rawCursor = selectBuddyByUserNo(userNo);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            try {
                retValue = rawCursor.getString(8);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
            } finally {
                rawCursor.close();
            }
            return retValue;
        }
        if (rawCursor != null) {
        }
        return null;
    }

    public String getUserMessageByUserID(String userID) {
        String retValue = null;
        Cursor rawCursor = selectBuddyByUserID(userID);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            try {
                retValue = rawCursor.getString(8);
            } catch (SQLException e) {
                StackTraceElement[] elems = e.getStackTrace();
                for (StackTraceElement elem : elems) {
                    logI(elem.toString());
                }
            } finally {
                rawCursor.close();
            }
            return retValue;
        }
        if (rawCursor != null) {
        }
        return null;
    }

    public String getWhereStringforNotHideNotBlockNotRemovedNotSuggestion() {
        return "NOT block = " + Integer.toString(1) + " AND NOT " + DatabaseHelper.KEY_HIDE + " = " + Integer.toString(1) + " AND NOT " + DatabaseHelper.KEY_REMOVED + " = " + Integer.toString(1) + " AND NOT " + DatabaseHelper.KEY_SUGGESTION + " = " + Integer.toString(1);
    }

    public String getWhereStringforNotHideNotBlockNotRemoved() {
        return "NOT block = " + Integer.toString(1) + " AND NOT " + DatabaseHelper.KEY_HIDE + " = " + Integer.toString(1) + " AND NOT " + DatabaseHelper.KEY_REMOVED + " = " + Integer.toString(1);
    }

    public String getWhereStringforNotBlockNotRemovedNotSuggestion() {
        return "NOT block = " + Integer.toString(1) + " AND NOT " + DatabaseHelper.KEY_REMOVED + " = " + Integer.toString(1) + " AND NOT " + DatabaseHelper.KEY_SUGGESTION + " = " + Integer.toString(1);
    }

    public String getWhereStringforNotHideNotRemovedNotSuggestion() {
        return "NOT hide = " + Integer.toString(1) + " AND NOT " + DatabaseHelper.KEY_REMOVED + " = " + Integer.toString(1) + " AND NOT " + DatabaseHelper.KEY_SUGGESTION + " = " + Integer.toString(1);
    }

    public void updateFreshBuddyStateInBuddyTable() {
        if (this.mDb != null && this.mDb.isOpen()) {
            String queryStr = "UPDATE buddy SET freshbuddy = " + Integer.toString(0) + C1265a.f3172e + DatabaseHelper.KEY_FRESHBUDDY + " = " + Integer.toString(1) + Config.KEYVALUE_SPLIT;
            this.mDb.execSQL(queryStr);
        }
    }

    public boolean isAlreadyInMyDB(long userNo) {
        boolean retValue = false;
        Cursor rawCursor = selectBuddyByUserNo(userNo);
        if (rawCursor != null && rawCursor.getCount() > 0 && rawCursor.moveToFirst()) {
            retValue = true;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return retValue;
    }

    public List<BuddyPhoneNoInfo> getBuddyPhoneNo() {
        ArrayList<BuddyPhoneNoInfo> phoneNoList = new ArrayList<>();
        Cursor rawCursor = selectPhoneNoAndAccountID();
        if (rawCursor != null && rawCursor.moveToFirst()) {
            do {
                BuddyPhoneNoInfo phoneNoInfo = new BuddyPhoneNoInfo();
                phoneNoInfo.phoneNo = rawCursor.getString(rawCursor.getColumnIndex(DatabaseHelper.KEY_PHONENO));
                phoneNoInfo.samsungAccountID = rawCursor.getString(rawCursor.getColumnIndex(DatabaseHelper.KEY_ACCOUNTID));
                phoneNoInfo.userNo = rawCursor.getLong(rawCursor.getColumnIndex(DatabaseHelper.KEY_USERNO));
                phoneNoInfo.userID = rawCursor.getString(rawCursor.getColumnIndex(DatabaseHelper.KEY_USERID));
                phoneNoList.add(phoneNoInfo);
            } while (rawCursor.moveToNext());
            rawCursor.close();
            return phoneNoList;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return null;
    }

    public void startTransaction() {
        if (this.mDb != null) {
            MainApplication.mPhoneManager.lockDatabaseLock();
            this.mDb.beginTransaction();
        }
    }

    public void setTransactionSuccessful() {
        if (this.mDb != null) {
            this.mDb.beginTransaction();
        }
    }

    public void endTransaction() {
        if (this.mDb != null) {
            this.mDb.endTransaction();
            MainApplication.mPhoneManager.releaseDatabaseLock();
        }
    }

    public List<BuddyPhoneNoInfo> getBuddyPhoneNoForAutoBuddy() {
        ArrayList<BuddyPhoneNoInfo> phoneNoList = new ArrayList<>();
        Cursor rawCursor = selectPhoneNoAndAccountIDforAutoBuddy();
        if (rawCursor != null && rawCursor.moveToFirst()) {
            do {
                BuddyPhoneNoInfo phoneNoInfo = new BuddyPhoneNoInfo();
                phoneNoInfo.phoneNo = rawCursor.getString(rawCursor.getColumnIndex(DatabaseHelper.KEY_PHONENO));
                phoneNoInfo.userNo = rawCursor.getLong(rawCursor.getColumnIndex(DatabaseHelper.KEY_USERNO));
                phoneNoList.add(phoneNoInfo);
            } while (rawCursor.moveToNext());
            rawCursor.close();
        } else if (rawCursor != null) {
            rawCursor.close();
        }
        return phoneNoList;
    }

    public boolean isAlreadyExistForContactSync(String phoneNo) {
        boolean retValue = false;
        long userNo = -1;
        Cursor rawCursor = selectIDNumberByPhoneNo(phoneNo);
        if (rawCursor != null && rawCursor.getCount() > 0 && rawCursor.moveToFirst()) {
            userNo = rawCursor.getLong(1);
            retValue = true;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        if (retValue) {
            Cursor dbRawCursor = selectBuddyByUserNoWithNoException(userNo);
            if (dbRawCursor != null && dbRawCursor.getCount() > 0 && dbRawCursor.moveToFirst() && (dbRawCursor.getInt(18) == 1 || dbRawCursor.getInt(15) == 1 || dbRawCursor.getInt(14) == 1)) {
                retValue = false;
            }
            if (dbRawCursor != null) {
                dbRawCursor.close();
            }
        }
        MainApplication.mPhoneManager.getConfigManager().getNationalCodeListFromMemory();
        return retValue;
    }

    public boolean isAlreadyExistForAutoBuddy(String phoneNo) {
        boolean retValue = false;
        Cursor rawCursor = selectIDNumberByPhoneNo(phoneNo);
        if (rawCursor != null && rawCursor.getCount() > 0 && rawCursor.moveToFirst()) {
            retValue = true;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        MainApplication.mPhoneManager.getConfigManager().getNationalCodeListFromMemory();
        return retValue;
    }

    public boolean isExistImageUpdateDate(boolean isBuddy, long code) {
        Cursor rawCursor;
        long updateDate = 0;
        if (isBuddy) {
            rawCursor = selectBuddyByUserNo(code);
            if (rawCursor != null && rawCursor.getCount() > 0 && rawCursor.moveToFirst()) {
                updateDate = rawCursor.getLong(20);
            }
        } else {
            rawCursor = selectBuddyGroupByGroupID(code);
            if (rawCursor != null && rawCursor.getCount() > 0 && rawCursor.moveToFirst()) {
                updateDate = rawCursor.getLong(3);
            }
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return updateDate > 0;
    }

    public void setGroupImageUpdateDate(long groupCode, Date updateDate) {
        ContentValues query = new ContentValues();
        query.put(DatabaseHelper.KEY_GROUPID, Long.valueOf(groupCode));
        ContentValues excute = new ContentValues();
        excute.put(DatabaseHelper.KEY_IMAGEUPDATEDATE, Long.valueOf(updateDate.getTime()));
        updateBuddyGroup(excute, query);
    }

    public void deleteAllSuggestionBuddy() {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.KEY_SUGGESTION, (Integer) 1);
        deleteBuddy(contentValue);
    }

    public long makeRegionInfoTable(ArrayList<RegionDomainInfo> regionDomainInfo) {
        deleteAllRegionCodeField();
        if (regionDomainInfo != null) {
            Iterator<RegionDomainInfo> it = regionDomainInfo.iterator();
            while (it.hasNext()) {
                RegionDomainInfo info = it.next();
                ContentValues value = new ContentValues();
                value.put(DatabaseHelper.KEY_REGIONCODE, Integer.valueOf(info.getRegion()));
                value.put("url", info.getImgDomain());
                insertRegionDomainInfo(value);
            }
            RegionDomainUtil.makeRegionDomainInfoList();
            return 1L;
        }
        return -1L;
    }

    private long deleteAllRegionCodeField() {
        if (this.mDb == null || !this.mDb.isOpen()) {
            return -1L;
        }
        this.mDb.delete(DatabaseHelper.REGIONCODE_TABLE, null, null);
        return 1L;
    }

    private long insertRegionDomainInfo(ContentValues value) {
        if (this.mDb == null || !this.mDb.isOpen() || value == null) {
            return -1L;
        }
        long count = this.mDb.insert(DatabaseHelper.REGIONCODE_TABLE, null, value);
        return count;
    }

    public boolean getBuddyPresenceByUserID(String userID) {
        boolean retValue = false;
        Cursor rawCursor = selectBuddyByUserID(userID);
        if (rawCursor == null || !rawCursor.moveToFirst()) {
            return rawCursor != null ? false : false;
        }
        try {
            retValue = rawCursor.getInt(17) == 1;
        } catch (SQLException e) {
            StackTraceElement[] elems = e.getStackTrace();
            for (StackTraceElement elem : elems) {
                logI(elem.toString());
            }
        } finally {
            rawCursor.close();
        }
        return retValue;
    }

    public boolean getBuddyPresenceByUserNO(long userNO) {
        boolean retValue = false;
        Cursor rawCursor = selectBuddyByUserNo(userNO);
        if (rawCursor == null || !rawCursor.moveToFirst()) {
            return rawCursor != null ? false : false;
        }
        try {
            retValue = rawCursor.getInt(17) == 1;
        } catch (SQLException e) {
            StackTraceElement[] elems = e.getStackTrace();
            for (StackTraceElement elem : elems) {
                logI(elem.toString());
            }
        } finally {
            rawCursor.close();
        }
        return retValue;
    }
}
