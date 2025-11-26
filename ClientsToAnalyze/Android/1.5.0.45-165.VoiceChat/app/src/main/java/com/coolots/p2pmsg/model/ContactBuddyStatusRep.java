package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ContactBuddyStatusRep extends MsgBody {
    private List<BuddyStatusInfo> BuddyStatusInfoList = new ArrayList();

    public List<BuddyStatusInfo> getBuddyStatusInfoList() {
        return this.BuddyStatusInfoList;
    }

    public void setBuddyStatusInfoList(List<BuddyStatusInfo> buddyStatusInfoList) {
        this.BuddyStatusInfoList = buddyStatusInfoList;
    }
}
