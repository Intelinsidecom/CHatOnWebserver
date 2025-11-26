package com.coolots.chaton.buddy;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Handler;
import com.coolots.chaton.buddy.model.BuddyListChildItem;
import com.coolots.chaton.buddy.model.BuddyListGroupItem;
import com.coolots.chaton.buddy.model.BuddyTable;
import com.coolots.chaton.buddy.model.NativeContactSyncData;
import com.coolots.chaton.buddy.model.NativePhoneBookInfo;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.chaton.common.util.ChatOnService;
import com.coolots.p2pmsg.model.BuddyGroupInfo;
import com.coolots.p2pmsg.model.BuddyGroupMapInfo;
import com.coolots.p2pmsg.model.ConferenceInfo;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.coolots.sso.EntitlementUIController;
import com.coolots.sso.IEntitlementUIController;
import com.coolots.sso.SSOManager;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.BlockCallHandler;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class ChatONBuddyManager implements BuddyManagerInterface, IEntitlementUIController {
    private static final String CLASSNAME = "[ChatONBuddyManager]";
    private CallDataBuffer mCallDataBuffer;
    private EntitlementUIController mEntitlementUIController;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // com.sds.coolots.contact.ContactManagerInterface
    public String getUserNameByUserID(String userID) {
        if (userID == null || userID.equals("")) {
            return null;
        }
        ChatOnService chatonservice = ChatOnService.createService(MainApplication.mContext);
        String userName = chatonservice.getChatOnBuddyName(userID);
        if (userName != null && userName.length() > 30) {
            logE("<<RDJ>> original username=" + userName + "(" + userName.length() + ")");
            String tempUserName = userName.substring(0, 27);
            String userName2 = String.valueOf(tempUserName) + "...";
            logE("<<RDJ>> 30digits username=" + userName2 + "(" + userName2.length() + ")");
            return userName2;
        }
        return userName;
    }

    @Override // com.sds.coolots.contact.ContactManagerInterface
    public boolean isBlockUser(String userID, Handler handler) {
        return false;
    }

    @Override // com.sds.coolots.contact.ContactManagerInterface
    public boolean isBlockPhoneNo(String phoneNo, Handler handler) {
        return false;
    }

    private class CallDataBuffer {
        boolean UseVideo;
        int callID;
        ConferenceInfo confInfo;
        Date date;
        Destination destination;
        short deviceID;
        String displayName;
        BlockCallHandler handler;
        String inviteUserID;
        boolean isConference;
        boolean isLiveShare;
        boolean isP2P;
        boolean isSecureCommunication;
        String p2pKey;
        Date startTime;

        private CallDataBuffer() {
        }

        /* synthetic */ CallDataBuffer(ChatONBuddyManager chatONBuddyManager, CallDataBuffer callDataBuffer) {
            this();
        }
    }

    @Override // com.sds.coolots.contact.ContactManagerInterface
    public boolean isBlockUserForCall(String userID, short deviceID, Destination destination, int callID, boolean UseVideo, boolean isP2P, boolean isSecureCommunication, boolean isLiveShare, String displayName, Date date, BlockCallHandler handler) {
        if (userID == null || userID.isEmpty() || handler == null) {
            return false;
        }
        if (!SSOManager.checkChatONAccountValidity()) {
            logE("isBlockUserForCall(): ChatON account does not exist");
            return false;
        }
        this.mCallDataBuffer = new CallDataBuffer(this, null);
        this.mCallDataBuffer.isConference = false;
        this.mCallDataBuffer.deviceID = deviceID;
        this.mCallDataBuffer.destination = destination;
        this.mCallDataBuffer.callID = callID;
        this.mCallDataBuffer.UseVideo = UseVideo;
        this.mCallDataBuffer.isP2P = isP2P;
        this.mCallDataBuffer.isSecureCommunication = isSecureCommunication;
        this.mCallDataBuffer.isLiveShare = isLiveShare;
        this.mCallDataBuffer.displayName = displayName;
        this.mCallDataBuffer.date = date;
        this.mCallDataBuffer.handler = handler;
        this.mEntitlementUIController = new EntitlementUIController();
        this.mEntitlementUIController.start(this, false, UseVideo, false);
        return true;
    }

    @Override // com.sds.coolots.contact.ContactManagerInterface
    public boolean isBlockUserForConf(String userID, Destination destination, ConferenceInfo confInfo, Date startTime, String p2pKey, BlockCallHandler handler, String inviteUserID) {
        if ((userID == null || userID.isEmpty() || handler == null) && (MainApplication.mConfig.getCallHangupType() == 1 || handler == null)) {
            return false;
        }
        if (!SSOManager.checkChatONAccountValidity()) {
            logE("isBlockUserForConf(): ChatON account does not exist");
            return false;
        }
        this.mCallDataBuffer = new CallDataBuffer(this, null);
        this.mCallDataBuffer.isConference = true;
        this.mCallDataBuffer.destination = destination;
        this.mCallDataBuffer.confInfo = confInfo;
        this.mCallDataBuffer.startTime = startTime;
        this.mCallDataBuffer.p2pKey = p2pKey;
        this.mCallDataBuffer.inviteUserID = inviteUserID;
        this.mCallDataBuffer.handler = handler;
        boolean isVideo = !"A".equals(confInfo.getConferenceType());
        this.mEntitlementUIController = new EntitlementUIController();
        this.mEntitlementUIController.start(this, false, isVideo, false);
        return true;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean isBuddyUpdated() {
        return false;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean isBuddyUpdatedSuggestion() {
        return false;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void addBuddy(ArrayList<String> userID, Handler handler) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void addBuddySuggestion(ArrayList<String> userIDList) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void autoBuddy(Handler handler, NativePhoneBookInfo nativePhoneBookInfo) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void blockBuddy(List<Long> userNos, boolean isBlock, Handler handler) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void buddySearchByUserID(String userID, Handler handler) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void buddySearchByPhoneNo(int countryNo, String phoneNo, Handler handler) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void updateBuddyListDataBase(Handler handler) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void hideBuddy(ArrayList<Long> noList, boolean isDelete, Handler handler) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void setFavoriteBuddy(long userNo, boolean isFavorite, Handler handler) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void addBuddyGroup(BuddyGroupInfo buddyGroupInfo, List<BuddyGroupMapInfo> mapList, Handler handler) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void changeBuddyGroupName(long groupID, String newGroupName, Handler handler) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void deleteBuddyGroup(long groupID, Handler handler) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void deleteBuddyGroupMember(long groupID, List<Long> buddys, Handler handler) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void addBuddyGroupMember(long groupID, List<Long> buddys, Handler handler) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void updateBuddyInfo(long userNo, String editedUserName, Handler handler) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void updateBuddyMainPhoneNo(long userNo, String editedPhoneNo, Handler handler) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void regionCodeSync(Handler handler) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public long getUserNoByUserIDWithNoException(String userID) {
        return 1L;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public int getKindOfBuddy(String userID) {
        return 0;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public int getKindOfBuddy(long userNo) {
        return 0;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public BuddyTable getBuddyInfoForCallLogDetail(String userID) {
        logI("getBuddyInfoForCallLogDetail() ChatOnService");
        BuddyTable buddyTable = null;
        ChatOnService chatonservice = ChatOnService.createService(MainApplication.mContext);
        chatonservice.setChatOnBuddyInfo(userID);
        if ((chatonservice.getChatOnBuddyName() != null && !chatonservice.getChatOnBuddyName().equals("")) || ((chatonservice.getChatOnBuddyName() != null && !chatonservice.getChatOnBuddyName().equals("")) || (chatonservice.getChatOnBuddyName() != null && !chatonservice.getChatOnBuddyName().equals("")))) {
            buddyTable = new BuddyTable();
            buddyTable.setUserNo(1L);
            buddyTable.setUserID(userID);
            buddyTable.setAccountID("AccountID");
            buddyTable.setDisplayName(chatonservice.getChatOnBuddyName());
            buddyTable.setEditedName("EditedName");
            buddyTable.setNativeName("NativeName");
            buddyTable.setBuddyName("BuddyName");
            buddyTable.setMessage(chatonservice.getChatOnBuddyStateMsg());
            buddyTable.setRegion("");
            buddyTable.setCountryCode("");
            buddyTable.setNationalCode("");
            buddyTable.setFirstNumber("");
        }
        logE("getBuddyInfoForCallLogDetail() buddyTable = " + buddyTable);
        return buddyTable;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public long getUserNoByUserID(String userID) {
        return 1L;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getDisplayNameByUserID(String userID) {
        if (userID == null || userID.equals("")) {
            return null;
        }
        ChatOnService chatonservice = ChatOnService.createService(MainApplication.mContext);
        String userName = chatonservice.getChatOnBuddyName(userID);
        return userName;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public long deleteEmptyGroup(Handler handler) {
        return 0L;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<BuddyListChildItem> getBlockList() {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean isReachToFavoriteMaxInLocal() {
        return false;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void updateDatabaseForBuddySync() {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<BuddyListChildItem> getBuddyListChildItemByUserNo(long userNo) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<BuddyListGroupItem> getBuddyListAdaptorGroupData() {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getAccountIDByUserNo(long userNo) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<String> getPhoneNoArrayListByUserNo(long userNo) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getFirstNumberBYUserNo(long userNo) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void fillOnlyBuddyListData() {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<BuddyListChildItem> getBuddyItemListData() {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean isReachToGroupMaxInLocal() {
        return false;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<Long> getGroupNoListBYUserNo(long userNo) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<String> getGroupNameList() {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<BuddyListChildItem> getGroupMemberListByGroupID(long groupid) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void fillBuddyListAdaptorData() {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<ArrayList<BuddyListChildItem>> getBuddyListAdaptorChildData() {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public int getSuggestionCount() {
        return 0;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void updateFreshBuddyStateInBuddyTable() {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<BuddyListChildItem> getSuggestionList() {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getBuddyNameByUserNo(long userNO) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void fillBuddyListAdaptorDataCheckList() {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void fillBuddyListAdaptorDataForAddMember(long groupNo) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void fillBuddyListDataForAddConferenceMember(ArrayList<Long> memberUserNumbers) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getBuddyMessageByUserID(String userID) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public Long getGroupIDBYGroupName(String groupName) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean getBuddyPresenceByUserID(String userID) {
        return false;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getBuddyNameByUserID(String userID) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getUserMessageByUserID(String userID) {
        logI("getUserMessageByUserID(userID) ChatOnService");
        ChatOnService chatonservice = ChatOnService.createService(MainApplication.mContext);
        chatonservice.setChatOnBuddyInfo(userID);
        return chatonservice.getChatOnBuddyStateMsg();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getUserMessageByUserNO(long userNo) {
        logI("getUserMessageByUserID(userNo) ChatOnService");
        return "wrong message";
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getGroupNameByGroupID(long groupId) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public long getGroupIDByUserIDList(ArrayList<String> userIDList) {
        return 0L;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void resetBuddyUpdatedate() {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public long getUserNoByAccountIDWithNoException(String accountID) {
        return 0L;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public long getUserNoByAccountID(String accountID) {
        return 0L;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<String> getPhoneNoArrayListByUserID(String userID) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean isExistImageUpdateDate(boolean isBuddy, long code) {
        return false;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<BuddyListChildItem> getHideList() {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void setBuddyUpdatedSuggestion(boolean updated) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void deleteAllSuggestionBuddy() {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public Cursor selectRegionCode() {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void setGroupImageUpdateDate(long groupCode, Date updateDate) {
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getDisplayNameByPriorityPolicy(String editedName, String nativeName, String userName) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getNativeNameByUserNo(long userNO) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean isExistAddBuddyForConferenceMember(ArrayList<Long> memberUserNumbers) {
        return false;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getRegionImageURLByUserNo(long userNo) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getRegionImageURLByRegion(long region) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean isNeedDeleteContactSync(String userSA) {
        return false;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<NativeContactSyncData> getPBListFromNativeForContactSync() {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public BuddyTable getVAppBuddyInfoTextDataByUserNo(long userNo) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public BuddyTable getVAppBuddyInfoTextData(String userID) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public List<BuddyTable> getVAppBuddyInfoTextData(List<String> userID) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public BuddyTable getVAppBuddyInfoTextDataByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public List<BuddyTable> getVAppBuddyInfoTextDataByPhoneNumber(List<String> phoneNumber) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean getVAppBuddyInfoImageData(String userID, Handler handler) {
        return false;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean getVAppBuddyInfoImageData(List<String> userID, Handler handler) {
        return false;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean getVAppBuddyInfoImageDataByPhoneNumber(String phoneNumber, Handler handler) {
        return false;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean getVAppBuddyInfoImageDataByPhoneNumber(List<String> phoneNumber, Handler handler) {
        return false;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public Bitmap getVAppBuddyInfoImageData(String userID) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public List<Bitmap> getVAppBuddyInfoImageData(List<String> userID) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public Bitmap getVAppBuddyInfoImageDataByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public List<Bitmap> getVAppBuddyInfoImageDataByPhoneNumber(List<String> phoneNumber) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getVAppBuddyInfoProfileName(String userID) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public HashMap<String, String> getVAppBuddyInfoProfileName(List<String> userID) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<SimpleUserInfo> getSimpleUserInfoFromMSISDN(List<String> MSISDNs) {
        logI("getSimpleUserInfoFromMSISDN() user cnt = " + MSISDNs.size());
        if (MSISDNs.size() <= 0) {
            return null;
        }
        ArrayList<SimpleUserInfo> memberList = new ArrayList<>();
        for (String userID : MSISDNs) {
            SimpleUserInfo userInfo = new SimpleUserInfo(ChatONStringConvert.getInstance().toUserID(userID), getUserNameByUserID(userID));
            memberList.add(userInfo);
        }
        logI("getSimpleUserInfoFromMSISDN() userInfo cnt = " + memberList.size());
        return memberList;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<SimpleUserInfo> getSimpleUserInfoFromMSISDN(HashMap<String, String> userInfo) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<P2PUserInfo> getP2PUserInfoFromMSISDN(List<String> MSISDNs) {
        logI("getP2PUserInfoFromMSISDN() user cnt = " + MSISDNs.size());
        if (MSISDNs.size() <= 0) {
            return null;
        }
        ArrayList<P2PUserInfo> memberList = new ArrayList<>();
        for (String userID : MSISDNs) {
            P2PUserInfo userInfo = new P2PUserInfo();
            userInfo.userID = ChatONStringConvert.getInstance().toUserID(userID);
            userInfo.userName = getUserNameByUserID(userID);
            memberList.add(userInfo);
        }
        logI("getP2PUserInfoFromMSISDN() userInfo cnt = " + memberList.size());
        return memberList;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<P2PUserInfo> getP2PUserInfoFromMSISDN(HashMap<String, String> userInfo) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface, com.sds.coolots.contact.ContactManagerInterface
    public boolean isFriend(String userID) {
        ChatOnService chatonservice = ChatOnService.createService(MainApplication.mContext);
        return chatonservice.isChatOnBuddy(userID) != 3;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getUserNameByUserIDForCallLogDetail(String userID) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getUserNameByUserIDForAddbuddyList(long userNo) {
        return null;
    }

    @Override // com.coolots.sso.IEntitlementUIController
    public void onStartCall() {
        logI("Call Success!!!!!");
        if (this.mCallDataBuffer == null) {
            logE("data removed!!!");
        } else if (this.mCallDataBuffer.isConference) {
            this.mCallDataBuffer.handler.startIncomingConference(this.mCallDataBuffer.destination, this.mCallDataBuffer.confInfo, this.mCallDataBuffer.startTime, this.mCallDataBuffer.p2pKey, this.mCallDataBuffer.inviteUserID);
        } else {
            this.mCallDataBuffer.handler.startIncomingCall(this.mCallDataBuffer.destination, this.mCallDataBuffer.deviceID, this.mCallDataBuffer.callID, this.mCallDataBuffer.UseVideo, this.mCallDataBuffer.isP2P, this.mCallDataBuffer.isSecureCommunication, this.mCallDataBuffer.isLiveShare, this.mCallDataBuffer.displayName, this.mCallDataBuffer.date);
        }
    }

    @Override // com.coolots.sso.IEntitlementUIController
    public void onEndProcess() {
        logI("onEndEntitlementProcess()");
        if (this.mEntitlementUIController != null) {
            this.mEntitlementUIController.dispose();
            this.mEntitlementUIController = null;
        }
    }

    @Override // com.coolots.sso.IEntitlementUIController
    public void onFailToStartCall() {
        logI("Call Fail!!!!!");
    }
}
