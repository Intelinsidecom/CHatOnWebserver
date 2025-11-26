package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class HideBuddyRep extends MsgBody {
    private List<BuddyInfo> BuddyList = new ArrayList();
    private List<BuddyGroupMapInfo> RemovedMapList = new ArrayList();

    public List<BuddyInfo> getBuddyList() {
        return this.BuddyList;
    }

    public void setBuddyList(List<BuddyInfo> buddyList) {
        this.BuddyList = buddyList;
    }

    public List<BuddyGroupMapInfo> getRemovedMapList() {
        return this.RemovedMapList;
    }

    public void setRemovedMapList(List<BuddyGroupMapInfo> removedMapList) {
        this.RemovedMapList = removedMapList;
    }
}
