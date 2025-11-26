package com.coolots.chaton.buddy;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Handler;
import com.coolots.chaton.buddy.model.BuddyListChildItem;
import com.coolots.chaton.buddy.model.BuddyListGroupItem;
import com.coolots.chaton.buddy.model.BuddyTable;
import com.coolots.chaton.buddy.model.NativeContactSyncData;
import com.coolots.chaton.buddy.model.NativePhoneBookInfo;
import com.coolots.p2pmsg.model.BuddyGroupInfo;
import com.coolots.p2pmsg.model.BuddyGroupMapInfo;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.contact.ContactManagerInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public interface BuddyManagerInterface extends ContactManagerInterface {
    public static final int PREINDEX_BUDDYLIST = 4;
    public static final int PREINDEX_FAVORITE = 2;
    public static final int PREINDEX_NEW = 1;

    void addBuddy(ArrayList<String> arrayList, Handler handler);

    void addBuddyGroup(BuddyGroupInfo buddyGroupInfo, List<BuddyGroupMapInfo> list, Handler handler);

    void addBuddyGroupMember(long j, List<Long> list, Handler handler);

    void addBuddySuggestion(ArrayList<String> arrayList);

    void autoBuddy(Handler handler, NativePhoneBookInfo nativePhoneBookInfo);

    void blockBuddy(List<Long> list, boolean z, Handler handler);

    void buddySearchByPhoneNo(int i, String str, Handler handler);

    void buddySearchByUserID(String str, Handler handler);

    void changeBuddyGroupName(long j, String str, Handler handler);

    void deleteAllSuggestionBuddy();

    void deleteBuddyGroup(long j, Handler handler);

    void deleteBuddyGroupMember(long j, List<Long> list, Handler handler);

    long deleteEmptyGroup(Handler handler);

    void fillBuddyListAdaptorData();

    void fillBuddyListAdaptorDataCheckList();

    void fillBuddyListAdaptorDataForAddMember(long j);

    void fillBuddyListDataForAddConferenceMember(ArrayList<Long> arrayList);

    void fillOnlyBuddyListData();

    String getAccountIDByUserNo(long j);

    ArrayList<BuddyListChildItem> getBlockList();

    BuddyTable getBuddyInfoForCallLogDetail(String str);

    ArrayList<BuddyListChildItem> getBuddyItemListData();

    ArrayList<ArrayList<BuddyListChildItem>> getBuddyListAdaptorChildData();

    ArrayList<BuddyListGroupItem> getBuddyListAdaptorGroupData();

    ArrayList<BuddyListChildItem> getBuddyListChildItemByUserNo(long j);

    String getBuddyMessageByUserID(String str);

    String getBuddyNameByUserID(String str);

    String getBuddyNameByUserNo(long j);

    boolean getBuddyPresenceByUserID(String str);

    String getDisplayNameByPriorityPolicy(String str, String str2, String str3);

    String getDisplayNameByUserID(String str);

    String getFirstNumberBYUserNo(long j);

    Long getGroupIDBYGroupName(String str);

    long getGroupIDByUserIDList(ArrayList<String> arrayList);

    ArrayList<BuddyListChildItem> getGroupMemberListByGroupID(long j);

    String getGroupNameByGroupID(long j);

    ArrayList<String> getGroupNameList();

    ArrayList<Long> getGroupNoListBYUserNo(long j);

    ArrayList<BuddyListChildItem> getHideList();

    int getKindOfBuddy(long j);

    int getKindOfBuddy(String str);

    String getNativeNameByUserNo(long j);

    ArrayList<P2PUserInfo> getP2PUserInfoFromMSISDN(HashMap<String, String> map);

    ArrayList<P2PUserInfo> getP2PUserInfoFromMSISDN(List<String> list);

    ArrayList<NativeContactSyncData> getPBListFromNativeForContactSync();

    ArrayList<String> getPhoneNoArrayListByUserID(String str);

    ArrayList<String> getPhoneNoArrayListByUserNo(long j);

    String getRegionImageURLByRegion(long j);

    String getRegionImageURLByUserNo(long j);

    ArrayList<SimpleUserInfo> getSimpleUserInfoFromMSISDN(HashMap<String, String> map);

    ArrayList<SimpleUserInfo> getSimpleUserInfoFromMSISDN(List<String> list);

    int getSuggestionCount();

    ArrayList<BuddyListChildItem> getSuggestionList();

    String getUserMessageByUserID(String str);

    String getUserMessageByUserNO(long j);

    String getUserNameByUserIDForAddbuddyList(long j);

    String getUserNameByUserIDForCallLogDetail(String str);

    long getUserNoByAccountID(String str);

    long getUserNoByAccountIDWithNoException(String str);

    long getUserNoByUserID(String str);

    long getUserNoByUserIDWithNoException(String str);

    Bitmap getVAppBuddyInfoImageData(String str);

    List<Bitmap> getVAppBuddyInfoImageData(List<String> list);

    boolean getVAppBuddyInfoImageData(String str, Handler handler);

    boolean getVAppBuddyInfoImageData(List<String> list, Handler handler);

    Bitmap getVAppBuddyInfoImageDataByPhoneNumber(String str);

    List<Bitmap> getVAppBuddyInfoImageDataByPhoneNumber(List<String> list);

    boolean getVAppBuddyInfoImageDataByPhoneNumber(String str, Handler handler);

    boolean getVAppBuddyInfoImageDataByPhoneNumber(List<String> list, Handler handler);

    String getVAppBuddyInfoProfileName(String str);

    HashMap<String, String> getVAppBuddyInfoProfileName(List<String> list);

    BuddyTable getVAppBuddyInfoTextData(String str);

    List<BuddyTable> getVAppBuddyInfoTextData(List<String> list);

    BuddyTable getVAppBuddyInfoTextDataByPhoneNumber(String str);

    List<BuddyTable> getVAppBuddyInfoTextDataByPhoneNumber(List<String> list);

    BuddyTable getVAppBuddyInfoTextDataByUserNo(long j);

    void hideBuddy(ArrayList<Long> arrayList, boolean z, Handler handler);

    boolean isBuddyUpdated();

    boolean isBuddyUpdatedSuggestion();

    boolean isExistAddBuddyForConferenceMember(ArrayList<Long> arrayList);

    boolean isExistImageUpdateDate(boolean z, long j);

    @Override // com.sds.coolots.contact.ContactManagerInterface
    boolean isFriend(String str);

    boolean isNeedDeleteContactSync(String str);

    boolean isReachToFavoriteMaxInLocal();

    boolean isReachToGroupMaxInLocal();

    void regionCodeSync(Handler handler);

    void resetBuddyUpdatedate();

    Cursor selectRegionCode();

    void setBuddyUpdatedSuggestion(boolean z);

    void setFavoriteBuddy(long j, boolean z, Handler handler);

    void setGroupImageUpdateDate(long j, Date date);

    void updateBuddyInfo(long j, String str, Handler handler);

    void updateBuddyListDataBase(Handler handler);

    void updateBuddyMainPhoneNo(long j, String str, Handler handler);

    void updateDatabaseForBuddySync();

    void updateFreshBuddyStateInBuddyTable();
}
