package com.coolots.chaton.buddy.util;

import android.content.ContentValues;
import android.database.Cursor;
import com.coolots.chaton.buddy.model.BuddyGroupTable;
import com.coolots.chaton.buddy.model.BuddyListChildItem;
import com.coolots.chaton.buddy.model.BuddyTable;
import com.coolots.chaton.buddy.model.GroupBuddyMapTable;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.p2pmsg.model.BuddyGroupInfo;
import com.coolots.p2pmsg.model.BuddyInfo;
import com.coolots.p2pmsg.model.PhoneNoInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.DatabaseHelper;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ValueObjectConverter {
    private static final Comparator<BuddyListChildItem> myComparator = new Comparator<BuddyListChildItem>() { // from class: com.coolots.chaton.buddy.util.ValueObjectConverter.1
        private final Collator collator = Collator.getInstance();

        @Override // java.util.Comparator
        public int compare(BuddyListChildItem lhs, BuddyListChildItem rhs) {
            return this.collator.compare(lhs.getBuddyName(), rhs.getBuddyName());
        }
    };

    public static BuddyInfo makeBuddyInfoFromBuddyCursor(Cursor sourceC) {
        BuddyInfo buddy = new BuddyInfo();
        if (sourceC == null) {
            return null;
        }
        buddy.setUserNo(sourceC.getLong(1));
        buddy.setUserID(sourceC.getString(2));
        buddy.setUserName(sourceC.getString(7));
        buddy.setEditedUserName(sourceC.getString(5));
        buddy.setComment(sourceC.getString(8));
        buddy.setRegion(sourceC.getString(9));
        buddy.setMainPhoneNo(sourceC.getString(12));
        List<PhoneNoInfo> phoneNoList = new ArrayList<>();
        ArrayList<String> phoneNumberArray = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getPhoneNoArrayListByUserNo(sourceC.getLong(1));
        if (phoneNumberArray != null && !phoneNumberArray.isEmpty()) {
            Iterator<String> it = phoneNumberArray.iterator();
            while (it.hasNext()) {
                String phoneNo = it.next();
                PhoneNoInfo phoneNoInfo = new PhoneNoInfo();
                phoneNoInfo.setPhoneNo(phoneNo);
                phoneNoList.add(phoneNoInfo);
            }
            buddy.setPhoneNoList(phoneNoList);
        }
        if (sourceC.getInt(18) == 1) {
            buddy.setBuddyCode("1");
        } else {
            buddy.setBuddyCode("2");
        }
        if (sourceC.getInt(13) == 1) {
            buddy.setFavorite("Y");
        } else {
            buddy.setFavorite("N");
        }
        if (sourceC.getInt(14) == 1) {
            buddy.setBlock("Y");
        } else {
            buddy.setBlock("N");
        }
        if (sourceC.getInt(15) == 1) {
            buddy.setHide("Y");
        } else {
            buddy.setHide("N");
        }
        if (sourceC.getInt(19) == 1) {
            buddy.setDelete("Y");
        } else {
            buddy.setDelete("N");
        }
        if (sourceC.getInt(17) == 1) {
            buddy.setStatus("Y");
        } else {
            buddy.setStatus("N");
        }
        Date date = new Date();
        date.setTime(sourceC.getLong(21));
        buddy.setUpdateDate(date);
        Date imagedate = new Date();
        imagedate.setTime(sourceC.getLong(20));
        buddy.setProfileImgUpdateDate(imagedate);
        return buddy;
    }

    public static ContentValues makeBuddyContentValuesFromBuddyInfo(BuddyInfo sourceBI, String nativeName, boolean bForInsert, boolean forcedDeleteNativeName) {
        ContentValues value = new ContentValues();
        int favorite = 1;
        if (sourceBI.getFavorite() != null && sourceBI.getFavorite().equals("N")) {
            favorite = 0;
        }
        int block = 1;
        if (sourceBI.getBlock() != null && sourceBI.getBlock().equals("N")) {
            block = 0;
        }
        int hide = 1;
        if (sourceBI.getHide() != null && sourceBI.getHide().equals("N")) {
            hide = 0;
        }
        int remove = 1;
        if (sourceBI.getDelete() != null && sourceBI.getDelete().equals("N")) {
            remove = 0;
        }
        int presence = 0;
        if (sourceBI.getStatus() != null && sourceBI.getStatus().equals("Y")) {
            presence = 1;
        }
        int suggestion = 0;
        if (sourceBI.getBuddyCode() != null && sourceBI.getBuddyCode().equals("1")) {
            suggestion = 1;
        }
        value.put(DatabaseHelper.KEY_USERNO, Long.valueOf(sourceBI.getUserNo()));
        value.put(DatabaseHelper.KEY_USERID, sourceBI.getUserID());
        if (sourceBI.getEmail() != null && !sourceBI.getEmail().isEmpty()) {
            value.put(DatabaseHelper.KEY_ACCOUNTID, sourceBI.getEmail());
        }
        String buddyNativeName = null;
        if (forcedDeleteNativeName) {
            value.put(DatabaseHelper.KEY_DISPLAYNAME, ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getDisplayNameByPriorityPolicy(sourceBI.getEditedUserName(), null, sourceBI.getUserName()));
        } else {
            buddyNativeName = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getNativeNameByUserNo(sourceBI.getUserNo());
            if (nativeName != null && !nativeName.isEmpty()) {
                value.put(DatabaseHelper.KEY_DISPLAYNAME, ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getDisplayNameByPriorityPolicy(sourceBI.getEditedUserName(), nativeName, sourceBI.getUserName()));
            } else if (buddyNativeName != null && !buddyNativeName.isEmpty()) {
                value.put(DatabaseHelper.KEY_DISPLAYNAME, ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getDisplayNameByPriorityPolicy(sourceBI.getEditedUserName(), buddyNativeName, sourceBI.getUserName()));
            } else {
                value.put(DatabaseHelper.KEY_DISPLAYNAME, ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getDisplayNameByPriorityPolicy(sourceBI.getEditedUserName(), null, sourceBI.getUserName()));
            }
        }
        value.put(DatabaseHelper.KEY_EDITEDNAME, sourceBI.getEditedUserName());
        if (forcedDeleteNativeName) {
            value.put(DatabaseHelper.KEY_NATIVENAME, "");
        } else if (nativeName != null && !nativeName.isEmpty()) {
            value.put(DatabaseHelper.KEY_NATIVENAME, nativeName);
        } else if (buddyNativeName != null && !buddyNativeName.isEmpty()) {
            value.put(DatabaseHelper.KEY_NATIVENAME, buddyNativeName);
        } else {
            value.put(DatabaseHelper.KEY_NATIVENAME, "");
        }
        value.put(DatabaseHelper.KEY_BUDDYNAME, sourceBI.getUserName());
        value.put("message", sourceBI.getComment());
        value.put(DatabaseHelper.KEY_REGION, sourceBI.getRegion());
        value.put("countrycode", "");
        value.put("nationalcode", "");
        value.put(DatabaseHelper.KEY_FIRSTNUMBER, sourceBI.getMainPhoneNo());
        value.put(DatabaseHelper.KEY_FAVORITE, Integer.valueOf(favorite));
        value.put(DatabaseHelper.KEY_BLOCK, Integer.valueOf(block));
        value.put(DatabaseHelper.KEY_HIDE, Integer.valueOf(hide));
        if (bForInsert) {
            value.put(DatabaseHelper.KEY_FRESHBUDDY, (Integer) 1);
        }
        value.put(DatabaseHelper.KEY_PRESENCE, Integer.valueOf(presence));
        value.put(DatabaseHelper.KEY_SUGGESTION, Integer.valueOf(suggestion));
        value.put(DatabaseHelper.KEY_REMOVED, Integer.valueOf(remove));
        if (sourceBI.getProfileImgUpdateDate() != null) {
            value.put(DatabaseHelper.KEY_IMAGEUPDATEDATE, Long.valueOf(sourceBI.getProfileImgUpdateDate().getTime()));
        } else {
            Date resetDate = new Date();
            resetDate.setTime(0L);
            value.put(DatabaseHelper.KEY_IMAGEUPDATEDATE, Long.valueOf(resetDate.getTime()));
        }
        if (sourceBI.getUpdateDate() != null) {
            value.put(DatabaseHelper.KEY_UPDATEDATE, Long.valueOf(sourceBI.getUpdateDate().getTime()));
        }
        return value;
    }

    public static ArrayList<ContentValues> makeIDNumberContentValuesFromBuddyInfo(BuddyInfo sourceBI) {
        ArrayList<ContentValues> cvList = new ArrayList<>();
        List<PhoneNoInfo> pnInfoList = sourceBI.getPhoneNoList();
        if (pnInfoList != null && !pnInfoList.isEmpty()) {
            for (PhoneNoInfo pnInfo : pnInfoList) {
                ContentValues value = new ContentValues();
                value.put(DatabaseHelper.KEY_USERNO, Long.valueOf(sourceBI.getUserNo()));
                value.put(DatabaseHelper.KEY_USERID, sourceBI.getUserID());
                value.put(DatabaseHelper.KEY_PHONENO, pnInfo.getPhoneNo());
                cvList.add(value);
            }
            return cvList;
        }
        return null;
    }

    public static BuddyTable makeBuddyTableFromBuddyCursor(Cursor sourceCursor) {
        BuddyTable buddyTable = new BuddyTable();
        if (sourceCursor == null) {
            return null;
        }
        buddyTable.setUserNo(sourceCursor.getLong(1));
        buddyTable.setUserID(sourceCursor.getString(2));
        buddyTable.setAccountID(sourceCursor.getString(3));
        buddyTable.setDisplayName(sourceCursor.getString(4));
        buddyTable.setEditedName(sourceCursor.getString(5));
        buddyTable.setNativeName(sourceCursor.getString(6));
        buddyTable.setBuddyName(sourceCursor.getString(7));
        buddyTable.setMessage(sourceCursor.getString(8));
        buddyTable.setRegion(sourceCursor.getString(9));
        buddyTable.setCountryCode(sourceCursor.getString(10));
        buddyTable.setNationalCode(sourceCursor.getString(11));
        buddyTable.setFirstNumber(sourceCursor.getString(12));
        buddyTable.setFavorite(sourceCursor.getInt(13));
        buddyTable.setBlock(sourceCursor.getInt(14));
        buddyTable.setHide(sourceCursor.getInt(15));
        buddyTable.setFreshBuddy(sourceCursor.getInt(16));
        buddyTable.setPrecense(sourceCursor.getInt(17));
        buddyTable.setSuggestion(sourceCursor.getInt(18));
        buddyTable.setRemoved(sourceCursor.getInt(19));
        buddyTable.setUpdateDate(sourceCursor.getLong(21));
        return buddyTable;
    }

    public static ArrayList<BuddyListChildItem> makeBuddyListChildItemArrayFromBuddyCursor(Cursor sourceCursor) {
        ArrayList<BuddyListChildItem> retBuddyListChildItem = new ArrayList<>();
        if (sourceCursor == null) {
            return null;
        }
        do {
            retBuddyListChildItem.add(makeBuddyListChildItemFromBuddyCursor(sourceCursor));
        } while (sourceCursor.moveToNext());
        return retBuddyListChildItem;
    }

    public static ArrayList<BuddyListChildItem> makeBuddyListChildItemArrayFromGroupBuddyMapCursor(Cursor sourceCursor) {
        ArrayList<BuddyListChildItem> retBuddyListChildItem = new ArrayList<>();
        new BuddyTable();
        if (sourceCursor == null) {
            return null;
        }
        do {
            BuddyTable bt = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getVAppBuddyInfoTextDataByUserNo(sourceCursor.getLong(2));
            if (bt != null) {
                retBuddyListChildItem.add(makeBuddyListChildItemFromBuddyTable(bt));
            }
        } while (sourceCursor.moveToNext());
        Collections.sort(retBuddyListChildItem, myComparator);
        return retBuddyListChildItem;
    }

    private static BuddyListChildItem makeBuddyListChildItemFromBuddyTable(BuddyTable bt) {
        BuddyListChildItem listChildItem = new BuddyListChildItem(null, null, 0L, null, false, false, false);
        listChildItem.setBuddyId(bt.getUserID());
        listChildItem.setBuddyMsg(bt.getMessage());
        listChildItem.setBuddyName(bt.getDisplayName());
        listChildItem.setBuddyNo(bt.getUserNo());
        listChildItem.setFavorite(bt.getFavorite() == 1);
        listChildItem.setmAccountID(bt.getAccountID());
        listChildItem.setPresence(bt.getPrecense() == 1);
        return listChildItem;
    }

    public static BuddyListChildItem makeBuddyListChildItemFromBuddyCursor(Cursor sourceCursor) {
        if (sourceCursor == null) {
            return null;
        }
        BuddyListChildItem retBuddyListChildItem = new BuddyListChildItem(null, null, 0L, null, false, false, false);
        retBuddyListChildItem.setBuddyId(sourceCursor.getString(2));
        retBuddyListChildItem.setmAccountID(sourceCursor.getString(3));
        retBuddyListChildItem.setBuddyNo(sourceCursor.getLong(1));
        retBuddyListChildItem.setBuddyName(sourceCursor.getString(4));
        retBuddyListChildItem.setBuddyMsg(sourceCursor.getString(8));
        retBuddyListChildItem.setFavorite(sourceCursor.getInt(13) == 1);
        retBuddyListChildItem.setPresence(sourceCursor.getInt(17) == 1);
        return retBuddyListChildItem;
    }

    public static BuddyGroupTable makeBuddyGroupTableFromCursor(Cursor sourceCursor) {
        if (sourceCursor == null) {
            return null;
        }
        BuddyGroupTable rawBuddyGroup = new BuddyGroupTable();
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.KEY_GROUPNAME, sourceCursor.getString(1));
        contentValue.put(DatabaseHelper.KEY_GROUPID, Long.valueOf(sourceCursor.getLong(2)));
        contentValue.put(DatabaseHelper.KEY_UPDATEDATE, Long.valueOf(sourceCursor.getLong(4)));
        rawBuddyGroup.setContentValue(contentValue);
        return rawBuddyGroup;
    }

    public static GroupBuddyMapTable makeGroupBuddyMapTableFromCursor(Cursor sourceCursor) {
        if (sourceCursor == null) {
            return null;
        }
        GroupBuddyMapTable rawGroupBuddyMap = new GroupBuddyMapTable();
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.KEY_GROUPID, Long.valueOf(sourceCursor.getLong(1)));
        contentValue.put(DatabaseHelper.KEY_USERNO, Long.valueOf(sourceCursor.getLong(2)));
        contentValue.put(DatabaseHelper.KEY_UPDATEDATE, Long.valueOf(sourceCursor.getLong(3)));
        rawGroupBuddyMap.setContentValue(contentValue);
        return rawGroupBuddyMap;
    }

    public static ContentValues makeBuddyGroupContentValuesFormBuddyGroupInfo(BuddyGroupInfo buddyGroup) {
        ContentValues value = new ContentValues();
        value.put(DatabaseHelper.KEY_GROUPNAME, buddyGroup.getGroupName());
        value.put(DatabaseHelper.KEY_GROUPID, Long.valueOf(buddyGroup.getGroupCode()));
        if (buddyGroup.getGroupImgUpdateDate() != null) {
            value.put(DatabaseHelper.KEY_IMAGEUPDATEDATE, Long.valueOf(buddyGroup.getGroupImgUpdateDate().getTime()));
        } else {
            Date resetDate = new Date();
            resetDate.setTime(0L);
            value.put(DatabaseHelper.KEY_IMAGEUPDATEDATE, Long.valueOf(resetDate.getTime()));
        }
        if (buddyGroup.getUpdateDate() != null) {
            value.put(DatabaseHelper.KEY_UPDATEDATE, Long.valueOf(buddyGroup.getUpdateDate().getTime()));
        }
        return value;
    }
}
