package com.coolots.chaton.call.model;

import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.buddy.model.BuddyTable;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class CallUserAddedInfo implements DisposeInterface {
    private static final String CLASSNAME = "[CallUserAddedInfo]";
    private BuddyManagerInterface mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
    private Destination mDestination;
    private final String mHostDisplayName;
    private boolean mIsConference;
    private HashMap<String, String> mUserDisplayNameList;
    private HashMap<String, String> mUserMessageList;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public CallUserAddedInfo(boolean isConference, Destination destination, String hostDisplayName) {
        this.mUserDisplayNameList = null;
        this.mUserMessageList = null;
        logI("CallUserAddedInfo: new constructor");
        this.mIsConference = isConference;
        this.mDestination = destination;
        this.mHostDisplayName = hostDisplayName;
        this.mUserDisplayNameList = new HashMap<>();
        this.mUserMessageList = new HashMap<>();
        update();
    }

    public String getUserDisplayNameByUserID(String userID) {
        if (this.mUserDisplayNameList == null || this.mUserDisplayNameList.isEmpty()) {
            logI("getUserDisplayNameByUserID(): mUserDisplayNameList is null");
            update();
        }
        if (this.mUserDisplayNameList != null && this.mUserDisplayNameList.containsKey(userID)) {
            return this.mUserDisplayNameList.get(userID);
        }
        return null;
    }

    public HashMap<String, String> getUserDisplayNameList() {
        if (this.mUserDisplayNameList == null || this.mUserDisplayNameList.isEmpty()) {
            logI("getUserDisplayNameList(): mUserDisplayNameList is null");
            update();
        }
        return this.mUserDisplayNameList;
    }

    public String getUserMessageByUserID(String userID) {
        if (this.mUserMessageList == null || this.mUserMessageList.isEmpty()) {
            logI("getUserMessageByUserID(): mUserMessageList is null");
            update();
        }
        if (this.mUserMessageList != null && this.mUserMessageList.containsKey(userID)) {
            return this.mUserMessageList.get(userID);
        }
        return null;
    }

    public HashMap<String, String> getUserMessageList() {
        if (this.mUserMessageList == null || this.mUserMessageList.isEmpty()) {
            logI("getUserMessageList(): mUserMessageList is null");
            update();
        }
        return this.mUserMessageList;
    }

    public final void update(boolean isConference, Destination destination) {
        logI("update()");
        this.mDestination = destination;
        this.mIsConference = isConference;
        if (isConference) {
            if (destination.getDestinationType() == 5) {
                Iterator it = destination.getP2PConferenceMember().iterator();
                while (it.hasNext()) {
                    P2PUserInfo userInfo = (P2PUserInfo) it.next();
                    if (this.mUserDisplayNameList.get(userInfo.userID) == null) {
                        BuddyTable buddyTable = this.mBuddyManager.getBuddyInfoForCallLogDetail(userInfo.userID);
                        if (buddyTable == null) {
                            logI("buddyTable is null");
                            this.mUserDisplayNameList.put(userInfo.userID, userInfo.userName);
                            this.mUserMessageList.put(userInfo.userID, null);
                            logI(String.valueOf(userInfo.userID) + ", 0, " + userInfo.userName + ", null");
                        } else {
                            putData(buddyTable, userInfo.userID);
                        }
                    }
                }
                return;
            }
            Iterator it2 = destination.getConferenceMember().iterator();
            while (it2.hasNext()) {
                SimpleUserInfo userInfo2 = (SimpleUserInfo) it2.next();
                if (this.mUserDisplayNameList.get(userInfo2.getUserID()) == null) {
                    BuddyTable buddyTable2 = this.mBuddyManager.getBuddyInfoForCallLogDetail(userInfo2.getUserID());
                    if (buddyTable2 == null) {
                        logI("buddyTable is null");
                        this.mUserDisplayNameList.put(userInfo2.getUserID(), userInfo2.getUserName());
                        this.mUserMessageList.put(userInfo2.getUserID(), null);
                        logI(String.valueOf(userInfo2.getUserID()) + ", 0, " + userInfo2.getUserName() + ", null");
                    } else {
                        putData(buddyTable2, userInfo2.getUserID());
                    }
                }
            }
            return;
        }
        if (this.mUserDisplayNameList.get(destination.getString()) == null) {
            BuddyTable buddyTable3 = this.mBuddyManager.getBuddyInfoForCallLogDetail(destination.getString());
            if (buddyTable3 == null) {
                logI("buddyTable is null");
                this.mUserDisplayNameList.put(destination.getString(), this.mHostDisplayName);
                this.mUserMessageList.put(destination.getString(), null);
                return;
            }
            putData(buddyTable3, destination.getString());
        }
    }

    private void putData(BuddyTable buddyTable, String userID) {
        logI("buddyTable putData() buddyTable.getDisplayName() = " + buddyTable.getDisplayName());
        this.mUserDisplayNameList.put(userID, buddyTable.getDisplayName());
        this.mUserMessageList.put(userID, buddyTable.getMessage());
    }

    private final void update() {
        if (this.mDestination != null) {
            if (this.mIsConference) {
                if (this.mDestination.getDestinationType() == 4 && this.mDestination.getConferenceMember().size() <= 0) {
                    logE("conference member is 0");
                    return;
                } else if (this.mDestination.getDestinationType() == 5 && this.mDestination.getP2PConferenceMember().size() <= 0) {
                    logE("conference member is 0");
                    return;
                }
            }
            update(this.mIsConference, this.mDestination);
            return;
        }
        logE("mDestination is null");
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mUserDisplayNameList != null) {
            this.mUserDisplayNameList.clear();
            this.mUserDisplayNameList = null;
        }
        if (this.mUserMessageList != null) {
            this.mUserMessageList.clear();
            this.mUserMessageList = null;
        }
        this.mDestination = null;
        this.mBuddyManager = null;
    }
}
