package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AddBuddyGroupRep extends MsgBody {
    private BuddyGroupInfo BuddyGroupInfo;
    private List<BuddyGroupMapInfo> MapList = new ArrayList();

    public BuddyGroupInfo getBuddyGroupInfo() {
        return this.BuddyGroupInfo;
    }

    public void setBuddyGroupInfo(BuddyGroupInfo buddyGroupInfo) {
        this.BuddyGroupInfo = buddyGroupInfo;
    }

    public List<BuddyGroupMapInfo> getMapList() {
        return this.MapList;
    }

    public void setMapList(List<BuddyGroupMapInfo> mapList) {
        this.MapList = mapList;
    }
}
