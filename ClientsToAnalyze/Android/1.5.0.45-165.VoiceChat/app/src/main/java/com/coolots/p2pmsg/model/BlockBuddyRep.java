package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BlockBuddyRep extends MsgBody {
    private List<BuddyInfo> BuddyInfoList = new ArrayList();
    private List<BuddyGroupMapInfo> RemovedMapList = new ArrayList();

    public List<BuddyInfo> getBuddyInfoList() {
        return this.BuddyInfoList;
    }

    public void setBuddyInfoList(List<BuddyInfo> buddyInfoList) {
        this.BuddyInfoList = buddyInfoList;
    }

    public List<BuddyGroupMapInfo> getRemovedMapList() {
        return this.RemovedMapList;
    }

    public void setRemovedMapList(List<BuddyGroupMapInfo> removedMapList) {
        this.RemovedMapList = removedMapList;
    }
}
