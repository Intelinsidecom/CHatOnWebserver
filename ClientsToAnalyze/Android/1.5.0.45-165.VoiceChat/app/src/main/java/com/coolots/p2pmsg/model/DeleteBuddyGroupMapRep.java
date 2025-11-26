package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DeleteBuddyGroupMapRep extends MsgBody {
    private List<BuddyGroupMapInfo> MapList = new ArrayList();

    public List<BuddyGroupMapInfo> getMapList() {
        return this.MapList;
    }

    public void setMapList(List<BuddyGroupMapInfo> mapList) {
        this.MapList = mapList;
    }
}
