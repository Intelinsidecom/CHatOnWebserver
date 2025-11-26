package com.coolots.chaton.call.util;

import com.coolots.chaton.call.model.CallUserAddedInfo;
import com.coolots.chaton.call.model.ConferenceCallDisplayUserInfo;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.ConferenceMember;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class DestinationUtil {
    private static final String CLASSNAME = "[DestinationUtil]";
    private int mWaitCount = 0;
    private int mConnectCount = 0;
    private boolean mIsCheckHost = false;
    private boolean mIsHost = false;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public ArrayList<String> getConnectWaitUserIDList(Destination destination) {
        String myUserID = MainApplication.mConfig.getProfileUserID();
        ArrayList<String> userIDList = new ArrayList<>();
        if (destination.getDestinationType() == 5) {
            ArrayList<P2PUserInfo> conferenceMember = destination.getP2PConferenceMember();
            Iterator<P2PUserInfo> it = conferenceMember.iterator();
            while (it.hasNext()) {
                P2PUserInfo userInfo = it.next();
                if (!myUserID.equals(userInfo.userID) && (userInfo.userState == 0 || 1 == userInfo.userState)) {
                    userIDList.add(userInfo.userID);
                    logI("getConnectWaitUserIDList() userID: " + userInfo.userID + " status: " + userInfo.userState);
                }
            }
        } else {
            ArrayList<SimpleUserInfo> conferenceMember2 = destination.getConferenceMember();
            Iterator<SimpleUserInfo> it2 = conferenceMember2.iterator();
            while (it2.hasNext()) {
                SimpleUserInfo userInfo2 = it2.next();
                if (!myUserID.equals(userInfo2.getUserID()) && ("0".equals(userInfo2.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(userInfo2.getStatus()) || "1".equals(userInfo2.getStatus()))) {
                    userIDList.add(userInfo2.getUserID());
                    logI("getConnectWaitUserIDList() userID: " + userInfo2.getUserID() + " status: " + userInfo2.getStatus());
                }
            }
        }
        return userIDList;
    }

    public ArrayList<String> getConnectUserIDList(Destination destination) {
        String myUserID = MainApplication.mConfig.getProfileUserID();
        ArrayList<String> userIDList = new ArrayList<>();
        if (destination.getDestinationType() == 5) {
            ArrayList<P2PUserInfo> conferenceMember = destination.getP2PConferenceMember();
            Iterator<P2PUserInfo> it = conferenceMember.iterator();
            while (it.hasNext()) {
                P2PUserInfo userInfo = it.next();
                if (!myUserID.equals(userInfo.userID) && 1 == userInfo.userState) {
                    userIDList.add(userInfo.userID);
                    logI("getConnectUserIDList() userID: " + userInfo.userID + " status: " + userInfo.userState);
                }
            }
        } else {
            ArrayList<SimpleUserInfo> conferenceMember2 = destination.getConferenceMember();
            Iterator<SimpleUserInfo> it2 = conferenceMember2.iterator();
            while (it2.hasNext()) {
                SimpleUserInfo userInfo2 = it2.next();
                if (!myUserID.equals(userInfo2.getUserID()) && (SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(userInfo2.getStatus()) || "1".equals(userInfo2.getStatus()))) {
                    userIDList.add(userInfo2.getUserID());
                    logI("getConnectUserIDList() userID: " + userInfo2.getUserID() + " status: " + userInfo2.getStatus());
                }
            }
        }
        return userIDList;
    }

    public ArrayList<String> getAllConferenceMemberIDList(Destination destination) {
        String myUserID = MainApplication.mConfig.getProfileUserID();
        ArrayList<String> userIDList = new ArrayList<>();
        if (destination.getDestinationType() == 5) {
            ArrayList<P2PUserInfo> conferenceMember = destination.getP2PConferenceMember();
            Iterator<P2PUserInfo> it = conferenceMember.iterator();
            while (it.hasNext()) {
                P2PUserInfo userInfo = it.next();
                if (!myUserID.equals(userInfo.userID)) {
                    userIDList.add(userInfo.userID);
                    logI("getConnectWaitUserIDList() userID: " + userInfo.userID + " status: " + userInfo.userState);
                }
            }
        } else {
            ArrayList<SimpleUserInfo> conferenceMember2 = destination.getConferenceMember();
            Iterator<SimpleUserInfo> it2 = conferenceMember2.iterator();
            while (it2.hasNext()) {
                SimpleUserInfo userInfo2 = it2.next();
                if (!myUserID.equals(userInfo2.getUserID())) {
                    userIDList.add(userInfo2.getUserID());
                    logI("getConnectWaitUserIDList() userID: " + userInfo2.getUserID() + " status: " + userInfo2.getStatus());
                }
            }
        }
        return userIDList;
    }

    public ConferenceCallDisplayUserInfo getConferenceAllMemberNameCount(Destination destination, CallUserAddedInfo userAddedInfo) {
        String myUserID = MainApplication.mConfig.getProfileUserID();
        ConferenceCallDisplayUserInfo userInfo = new ConferenceCallDisplayUserInfo();
        String memberName = null;
        int count = 1;
        if (destination.getDestinationType() == 5) {
            ArrayList<P2PUserInfo> userInfoList = destination.getP2PConferenceMember();
            for (int i = 0; i < userInfoList.size(); i++) {
                if (!myUserID.equals(userInfoList.get(i).userID)) {
                    logI("<<YHT5>> USERID:" + userInfoList.get(i).userID + ", USERNAME:" + userInfoList.get(i).userName);
                    String name = userAddedInfo.getUserDisplayNameByUserID(userInfoList.get(i).userID);
                    if (name == null) {
                        name = userInfoList.get(i).userName;
                    }
                    memberName = memberName == null ? name : memberName.concat(", " + name);
                    count++;
                }
            }
        } else {
            ArrayList<SimpleUserInfo> userInfoList2 = destination.getConferenceMember();
            for (int i2 = 0; i2 < userInfoList2.size(); i2++) {
                if (!myUserID.equals(userInfoList2.get(i2).getUserID())) {
                    logI("<<YHT5>> USERID:" + userInfoList2.get(i2).getUserID() + ", USERNAME:" + userInfoList2.get(i2).getUserName());
                    String name2 = userAddedInfo.getUserDisplayNameByUserID(userInfoList2.get(i2).getUserID());
                    if (name2 == null) {
                        name2 = userInfoList2.get(i2).getUserName();
                    }
                    memberName = memberName == null ? name2 : memberName.concat(", " + name2);
                    count++;
                }
            }
        }
        userInfo.userName = memberName;
        userInfo.userCount = count;
        return userInfo;
    }

    public ConferenceCallDisplayUserInfo getConferenceConnectWaitMemberNameCount(Destination destination, CallUserAddedInfo userAddedInfo) {
        String myUserID = MainApplication.mConfig.getProfileUserID();
        ConferenceCallDisplayUserInfo userInfo = new ConferenceCallDisplayUserInfo();
        String memberName = null;
        int count = 1;
        if (destination.getDestinationType() == 5) {
            ArrayList<P2PUserInfo> userInfoList = destination.getP2PConferenceMember();
            for (int i = 0; i < userInfoList.size(); i++) {
                if (!myUserID.equals(userInfoList.get(i).userID) && (1 == userInfoList.get(i).userState || userInfoList.get(i).userState == 0)) {
                    String name = userAddedInfo.getUserDisplayNameByUserID(userInfoList.get(i).userID);
                    if (name == null) {
                        name = userInfoList.get(i).userName;
                    }
                    memberName = memberName == null ? name : memberName.concat(", " + name);
                    count++;
                }
            }
        } else {
            ArrayList<SimpleUserInfo> userInfoList2 = destination.getConferenceMember();
            for (int i2 = 0; i2 < userInfoList2.size(); i2++) {
                if (!myUserID.equals(userInfoList2.get(i2).getUserID()) && ("1".equals(userInfoList2.get(i2).getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(userInfoList2.get(i2).getStatus()) || "0".equals(userInfoList2.get(i2).getStatus()))) {
                    String name2 = userAddedInfo.getUserDisplayNameByUserID(userInfoList2.get(i2).getUserID());
                    if (name2 == null) {
                        name2 = userInfoList2.get(i2).getUserName();
                    }
                    memberName = memberName == null ? name2 : memberName.concat(", " + name2);
                    count++;
                }
            }
        }
        userInfo.userName = memberName;
        userInfo.userCount = count;
        return userInfo;
    }

    public ArrayList<ConferenceMember> getMemberForAddConference(Destination destination, ArrayList<String> inviteList, ArrayList<ConferenceMember> memberList) {
        logI("getMemberForAddConference()");
        String myUserID = MainApplication.mConfig.getProfileUserID();
        ArrayList<ConferenceMember> addMemberList = new ArrayList<>();
        Iterator<ConferenceMember> it = memberList.iterator();
        while (it.hasNext()) {
            ConferenceMember member = it.next();
            if (!myUserID.equals(member.userID)) {
                logI("<<YHT2>> getMemberForAddConference USERID:" + member.userID);
                if (!isWaitingMember(destination, member.userID) && !isIncludedInviteList(inviteList, member.userID)) {
                    logI("getMemberForAddConference() added member: " + member.userID);
                    addMemberList.add(member);
                }
            }
        }
        return addMemberList;
    }

    private boolean isIncludedInviteList(ArrayList<String> inviteList, String userID) {
        Iterator<String> it = inviteList.iterator();
        while (it.hasNext()) {
            String item = it.next();
            if (userID.equals(item)) {
                logE("<<YHT2>> isIncludedInviteList!! true");
                return true;
            }
        }
        logE("<<YHT2>> isIncludedInviteList!! false");
        return false;
    }

    public boolean isWaitingMember(Destination destination, String userID) {
        if (destination.getDestinationType() == 5) {
            Iterator it = destination.getP2PConferenceMember().iterator();
            while (it.hasNext()) {
                P2PUserInfo userInfo = (P2PUserInfo) it.next();
                if (userID.equals(userInfo.userID) && userInfo.userState == 0) {
                    logE("<<YHT2>> isWaitingMember!!");
                    return true;
                }
            }
        } else {
            Iterator it2 = destination.getConferenceMember().iterator();
            while (it2.hasNext()) {
                SimpleUserInfo userInfo2 = (SimpleUserInfo) it2.next();
                if (userID.equals(userInfo2.getUserID()) && "0".equals(userInfo2.getStatus())) {
                    logE("<<YHT2>> isWaitingMember!!");
                    return true;
                }
            }
        }
        logE("<<YHT2>> isWaitingMember!! false");
        return false;
    }

    public ArrayList<ConferenceMember> getMemberForRemoveConference(Destination destination, ArrayList<String> inviteList, ArrayList<ConferenceMember> memberList) {
        logI("getMemberForRemoveConference()");
        ArrayList<ConferenceMember> removeMemberList = new ArrayList<>();
        return removeMemberList;
    }

    public ArrayList<Long> getConferenceConnectWaitUserNoList(Destination destination, CallUserAddedInfo userAddedInfo) {
        String myUserID = MainApplication.mConfig.getProfileUserID();
        ArrayList<Long> userNoList = new ArrayList<>();
        if (destination.getDestinationType() == 5) {
            Iterator it = destination.getP2PConferenceMember().iterator();
            while (it.hasNext()) {
                P2PUserInfo member = (P2PUserInfo) it.next();
                if (!myUserID.equals(member.userID) && (1 == member.userState || member.userState == 0)) {
                    logI("getConferenceConnectWaitUserNoList() userID:" + member.userID);
                    logE("Error Not Used Method : getConferenceConnectWaitUserNoList()");
                }
            }
        } else {
            Iterator it2 = destination.getConferenceMember().iterator();
            while (it2.hasNext()) {
                SimpleUserInfo member2 = (SimpleUserInfo) it2.next();
                if (!myUserID.equals(member2.getUserID()) && ("1".equals(member2.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(member2.getStatus()) || "0".equals(member2.getStatus()))) {
                    logI("getConferenceConnectWaitUserNoList() userID:" + member2.getUserID());
                    logI("Error Not Used Method : getConferenceConnectWaitUserNoList()");
                }
            }
        }
        return userNoList;
    }

    public ArrayList<Long> getConferenceConnectUserNoList(Destination destination, CallUserAddedInfo userAddedInfo) {
        String myUserID = MainApplication.mConfig.getProfileUserID();
        ArrayList<Long> userNoList = new ArrayList<>();
        if (destination.getDestinationType() == 5) {
            Iterator it = destination.getP2PConferenceMember().iterator();
            while (it.hasNext()) {
                P2PUserInfo member = (P2PUserInfo) it.next();
                if (!myUserID.equals(member.userID) && 1 == member.userState) {
                    logI("getConferenceConnectUserNoList() userID:" + member.userID);
                    logE("Error Not Used Method : getConferenceConnectUserNoList()");
                }
            }
        } else {
            Iterator it2 = destination.getConferenceMember().iterator();
            while (it2.hasNext()) {
                SimpleUserInfo member2 = (SimpleUserInfo) it2.next();
                if (!myUserID.equals(member2.getUserID()) && ("1".equals(member2.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(member2.getStatus()))) {
                    logI("getConferenceConnectUserNoList() userID:" + member2.getUserID());
                    logE("Error Not Used Method : getConferenceConnectUserNoList()");
                }
            }
        }
        return userNoList;
    }

    public ArrayList<String> getConferenceConnectUserIDList(Destination destination, CallUserAddedInfo userAddedInfo) {
        String myUserID = MainApplication.mConfig.getProfileUserID();
        ArrayList<String> userIDList = null;
        if (destination.getDestinationType() == 4) {
            userIDList = new ArrayList<>();
            Iterator it = destination.getConferenceMember().iterator();
            while (it.hasNext()) {
                SimpleUserInfo member = (SimpleUserInfo) it.next();
                if (!myUserID.equals(member.getUserID()) && ("1".equals(member.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(member.getStatus()))) {
                    logI("getConferenceConnectUserNoList() userID:" + member.getUserID());
                    userIDList.add(member.getUserID());
                }
            }
        }
        return userIDList;
    }

    public ArrayList<String> getConferenceConnectWaitUserIDList(Destination destination, CallUserAddedInfo userAddedInfo) {
        String myUserID = MainApplication.mConfig.getProfileUserID();
        ArrayList<String> userIDList = null;
        if (destination.getDestinationType() == 4) {
            userIDList = new ArrayList<>();
            Iterator it = destination.getConferenceMember().iterator();
            while (it.hasNext()) {
                SimpleUserInfo member = (SimpleUserInfo) it.next();
                if (!myUserID.equals(member.getUserID()) && ("1".equals(member.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(member.getStatus()) || "0".equals(member.getStatus()))) {
                    logI("getConferenceConnectUserNoList() userID:" + member.getUserID());
                    userIDList.add(member.getUserID());
                }
            }
        }
        return userIDList;
    }

    public ArrayList<Long> getConferenceWaitUserNoList(Destination destination, CallUserAddedInfo userAddedInfo) {
        String myUserID = MainApplication.mConfig.getProfileUserID();
        ArrayList<Long> userNoList = new ArrayList<>();
        if (destination.getDestinationType() == 5) {
            Iterator it = destination.getP2PConferenceMember().iterator();
            while (it.hasNext()) {
                P2PUserInfo member = (P2PUserInfo) it.next();
                if (!myUserID.equals(member.userID) && member.userState == 0) {
                    logI("getConferenceWaitUserNoList() userID:" + member.userID);
                    logE("Error Not Used Method : getConferenceWaitUserNoList()");
                }
            }
        } else {
            Iterator it2 = destination.getConferenceMember().iterator();
            while (it2.hasNext()) {
                SimpleUserInfo member2 = (SimpleUserInfo) it2.next();
                if (!myUserID.equals(member2.getUserID()) && "0".equals(member2.getStatus())) {
                    logI("getConferenceWaitUserNoList() userID:" + member2.getUserID());
                    logE("Error Not Used Method : getConferenceWaitUserNoList()");
                }
            }
        }
        return userNoList;
    }

    public ArrayList<ConferenceMember> getConferenceWaitMemberList(Destination destination) {
        String myUserID = MainApplication.mConfig.getProfileUserID();
        ArrayList<ConferenceMember> memberList = new ArrayList<>();
        if (destination.getDestinationType() == 5) {
            Iterator it = destination.getP2PConferenceMember().iterator();
            while (it.hasNext()) {
                P2PUserInfo member = (P2PUserInfo) it.next();
                if (!myUserID.equals(member.userID) && member.userState == 0) {
                    logI("getConferenceWaitMemberList() userID:" + member.userID);
                    memberList.add(new ConferenceMember(member.userID, member.userName, ""));
                }
            }
        } else {
            Iterator it2 = destination.getConferenceMember().iterator();
            while (it2.hasNext()) {
                SimpleUserInfo member2 = (SimpleUserInfo) it2.next();
                if (!myUserID.equals(member2.getUserID()) && "0".equals(member2.getStatus())) {
                    logI("getConferenceWaitMemberList() userID:" + member2.getUserID());
                    memberList.add(new ConferenceMember(member2.getUserID(), member2.getUserName(), ""));
                }
            }
        }
        return memberList;
    }

    public int getWaitCount() {
        if (!this.mIsCheckHost) {
            return -1;
        }
        this.mIsCheckHost = false;
        return this.mWaitCount;
    }

    public int getConnectCount() {
        if (!this.mIsCheckHost) {
            return -1;
        }
        this.mIsCheckHost = false;
        return this.mWaitCount;
    }

    public boolean getHost() {
        return this.mIsHost;
    }

    public int getConferenceWaitCount(Destination destination) {
        String myUserID = MainApplication.mConfig.getProfileUserID();
        int count = 0;
        if (destination.getDestinationType() == 5) {
            Iterator it = destination.getP2PConferenceMember().iterator();
            while (it.hasNext()) {
                P2PUserInfo member = (P2PUserInfo) it.next();
                if (!myUserID.equals(member.userID) && member.userState == 0) {
                    count++;
                }
            }
        } else {
            Iterator it2 = destination.getConferenceMember().iterator();
            while (it2.hasNext()) {
                SimpleUserInfo member2 = (SimpleUserInfo) it2.next();
                if (!myUserID.equals(member2.getUserID()) && "0".equals(member2.getStatus())) {
                    count++;
                }
            }
        }
        logI("getConferenceWaitCount(): " + count);
        return count;
    }

    public int getConferenceConnectCount(Destination destination) {
        String myUserID = MainApplication.mConfig.getProfileUserID();
        int count = 0;
        if (destination.getDestinationType() == 5) {
            Iterator it = destination.getP2PConferenceMember().iterator();
            while (it.hasNext()) {
                P2PUserInfo member = (P2PUserInfo) it.next();
                if (!myUserID.equals(member.userID) && 1 == member.userState) {
                    count++;
                }
            }
        } else {
            Iterator it2 = destination.getConferenceMember().iterator();
            while (it2.hasNext()) {
                SimpleUserInfo member2 = (SimpleUserInfo) it2.next();
                if (!myUserID.equals(member2.getUserID()) && ("1".equals(member2.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(member2.getStatus()))) {
                    count++;
                }
            }
        }
        logI("getConferenceConnectCount(): " + count);
        return count;
    }

    public ConferenceCallDisplayUserInfo getConferenceConnectedMember(Destination destination, CallUserAddedInfo userAddedInfo, boolean isConnected) {
        String myUserID = MainApplication.mConfig.getProfileUserID();
        ConferenceCallDisplayUserInfo userInfo = new ConferenceCallDisplayUserInfo();
        String memberName = null;
        int count = 1;
        if (destination.getDestinationType() == 5) {
            ArrayList<P2PUserInfo> userInfoList = destination.getP2PConferenceMember();
            logI("<CIH> : userInfoList");
            Iterator<P2PUserInfo> it = userInfoList.iterator();
            while (it.hasNext()) {
                P2PUserInfo sui = it.next();
                logI("<CIH> " + sui.userName);
                logI("<CIH> " + sui.userState);
            }
            for (int i = 0; i < userInfoList.size(); i++) {
                if (!myUserID.equals(userInfoList.get(i).userID) && (1 == userInfoList.get(i).userState || (userInfoList.get(i).userState == 0 && !isConnected))) {
                    String name = userAddedInfo.getUserDisplayNameByUserID(userInfoList.get(i).userID);
                    if (name == null || name.equals("")) {
                        name = userInfoList.get(i).userName;
                    }
                    memberName = memberName == null ? name : memberName.concat(", " + name);
                    count++;
                }
            }
        } else {
            ArrayList<SimpleUserInfo> userInfoList2 = destination.getConferenceMember();
            logI("<CIH> : userInfoList");
            Iterator<SimpleUserInfo> it2 = userInfoList2.iterator();
            while (it2.hasNext()) {
                SimpleUserInfo sui2 = it2.next();
                logI("<CIH> " + sui2.getUserName());
                logI("<CIH> " + sui2.getStatus());
            }
            for (int i2 = 0; i2 < userInfoList2.size(); i2++) {
                if (!myUserID.equals(userInfoList2.get(i2).getUserID()) && ("1".equals(userInfoList2.get(i2).getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(userInfoList2.get(i2).getStatus()) || ("0".equals(userInfoList2.get(i2).getStatus()) && !isConnected))) {
                    String name2 = userAddedInfo.getUserDisplayNameByUserID(userInfoList2.get(i2).getUserID());
                    if (name2 == null || name2.equals("")) {
                        name2 = userInfoList2.get(i2).getUserName();
                    }
                    memberName = memberName == null ? name2 : memberName.concat(", " + name2);
                    count++;
                }
            }
        }
        userInfo.userName = memberName;
        userInfo.userCount = count;
        return userInfo;
    }
}
