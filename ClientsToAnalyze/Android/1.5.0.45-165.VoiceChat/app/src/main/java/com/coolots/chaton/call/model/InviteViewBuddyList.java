package com.coolots.chaton.call.model;

import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.buddy.model.BuddyTable;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.ConferenceMember;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class InviteViewBuddyList implements DisposeInterface {
    private static final String CLASSNAME = "[InviteViewBuddyList]";
    private static Object mSync = new Object();
    private List<InviteViewBuddyItem> mBuddies;
    private final BuddyManagerInterface mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public InviteViewBuddyList() {
        this.mBuddies = null;
        this.mBuddies = new ArrayList();
    }

    public InviteViewBuddyItem getBuddy(int index) {
        InviteViewBuddyItem inviteViewBuddyItem = null;
        synchronized (mSync) {
            if (this.mBuddies == null) {
                logE("Buddies are null");
            } else if (index < this.mBuddies.size()) {
                inviteViewBuddyItem = this.mBuddies.get(index);
            }
        }
        return inviteViewBuddyItem;
    }

    public int getBuddiesCount() {
        synchronized (mSync) {
            if (this.mBuddies == null) {
                logE("Buddies are null");
                return 0;
            }
            return this.mBuddies.size();
        }
    }

    public List<InviteViewBuddyItem> getBuddyList() {
        return this.mBuddies;
    }

    public void addBuddy(ConferenceMember member) {
        if (member != null) {
            BuddyTable buddyTable = this.mBuddyManager.getBuddyInfoForCallLogDetail(member.userID);
            if (buddyTable == null) {
                synchronized (mSync) {
                    if (this.mBuddies == null) {
                        this.mBuddies = new ArrayList();
                    }
                    Long l = 0L;
                    this.mBuddies.add(new InviteViewBuddyItem(member.userID, l.longValue(), member.userName, null, 1, "P"));
                }
                return;
            }
            String userDisplayName = buddyTable.getDisplayName();
            if (userDisplayName == null || userDisplayName.isEmpty()) {
                userDisplayName = member.userName;
            }
            synchronized (mSync) {
                if (this.mBuddies == null) {
                    this.mBuddies = new ArrayList();
                }
                this.mBuddies.add(new InviteViewBuddyItem(member.userID, buddyTable.getUserNo(), userDisplayName, buddyTable.getMessage(), 1, "P"));
            }
        }
    }

    public void addBuddy(ArrayList<ConferenceMember> memberList) {
        if (memberList != null && !memberList.isEmpty()) {
            Iterator<ConferenceMember> it = memberList.iterator();
            while (it.hasNext()) {
                ConferenceMember member = it.next();
                BuddyTable buddyTable = this.mBuddyManager.getBuddyInfoForCallLogDetail(member.userID);
                if (buddyTable == null) {
                    logE("addBuddy(not friend): " + member.userID);
                    synchronized (mSync) {
                        if (this.mBuddies == null) {
                            this.mBuddies = new ArrayList();
                        }
                        Long l = 0L;
                        this.mBuddies.add(new InviteViewBuddyItem(member.userID, l.longValue(), member.userName, null, 1, "P"));
                    }
                } else {
                    String userDisplayName = buddyTable.getDisplayName();
                    if (userDisplayName == null || userDisplayName.isEmpty()) {
                        userDisplayName = member.userName;
                    }
                    logE("addBuddy: " + member.userID);
                    synchronized (mSync) {
                        if (this.mBuddies == null) {
                            this.mBuddies = new ArrayList();
                        }
                        this.mBuddies.add(new InviteViewBuddyItem(member.userID, buddyTable.getUserNo(), userDisplayName, buddyTable.getMessage(), 1, "P"));
                    }
                }
            }
        }
    }

    public void addBuddy(Destination destination, CallUserAddedInfo userAddedInfo, CallDisplayUserInfo callUserInfo) {
        ArrayList<SimpleUserInfo> dMemberList = destination.getConferenceMember();
        if (dMemberList == null || dMemberList.isEmpty()) {
            synchronized (mSync) {
                if (this.mBuddies == null) {
                    this.mBuddies = new ArrayList();
                }
                this.mBuddies.add(new InviteViewBuddyItem(callUserInfo.userID, -1L, userAddedInfo.getUserDisplayNameByUserID(callUserInfo.userID), userAddedInfo.getUserMessageByUserID(callUserInfo.userID), 3, "P"));
            }
            return;
        }
        if (destination.getDestinationType() == 5) {
            Iterator it = destination.getP2PConferenceMember().iterator();
            while (it.hasNext()) {
                P2PUserInfo userInfo = (P2PUserInfo) it.next();
                if (1 == userInfo.userState) {
                    synchronized (mSync) {
                        if (this.mBuddies == null) {
                            this.mBuddies = new ArrayList();
                        }
                        this.mBuddies.add(new InviteViewBuddyItem(userInfo.userID, -1L, userAddedInfo.getUserDisplayNameByUserID(userInfo.userID), userAddedInfo.getUserMessageByUserID(userInfo.userID), 3, "P"));
                    }
                }
            }
            return;
        }
        Iterator<SimpleUserInfo> it2 = dMemberList.iterator();
        while (it2.hasNext()) {
            SimpleUserInfo dMember = it2.next();
            if ("1".equals(dMember.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(dMember.getStatus())) {
                synchronized (mSync) {
                    if (this.mBuddies == null) {
                        this.mBuddies = new ArrayList();
                    }
                    this.mBuddies.add(new InviteViewBuddyItem(dMember.getUserID(), -1L, userAddedInfo.getUserDisplayNameByUserID(dMember.getUserID()), userAddedInfo.getUserMessageByUserID(dMember.getUserID()), 3, dMember.getUserType()));
                }
            }
        }
    }

    public void removeBuddy(int index) {
        synchronized (mSync) {
            if (this.mBuddies != null) {
                if (index <= this.mBuddies.size() - 1) {
                    this.mBuddies.remove(index);
                    return;
                } else {
                    logE("removeBuddy: index error");
                    return;
                }
            }
            logE("removeBuddy: Buddies are null");
        }
    }

    public void removeAllBuddies() {
        synchronized (mSync) {
            if (this.mBuddies != null) {
                this.mBuddies.clear();
            } else {
                logE("removeAllBuddies: Buddies are null");
            }
        }
    }

    public void description(int index) {
        synchronized (mSync) {
            if (this.mBuddies != null) {
                this.mBuddies.get(index).description();
            }
        }
    }

    public void description() {
        logI("invite buddy list: ( count: " + this.mBuddies.size() + ")-------------------");
        for (InviteViewBuddyItem item : this.mBuddies) {
            item.description();
        }
        logI("--------------------------------------------------");
    }

    public int isContainBuddy(String userID) {
        synchronized (mSync) {
            if (this.mBuddies == null) {
                logE("isContainBuddy: Buddies are null");
                return 0;
            }
            int index = 0;
            for (InviteViewBuddyItem item : this.mBuddies) {
                index++;
                if (item.getUserID().equals(userID)) {
                    return index;
                }
            }
            return 0;
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        logI("dispose()");
        synchronized (mSync) {
            if (this.mBuddies != null) {
                this.mBuddies.clear();
                this.mBuddies = null;
            }
        }
    }
}
