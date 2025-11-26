package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RegionAddBuddySuggestionRep extends MsgBody {
    private List<BuddyInfo> BuddyList = new ArrayList();

    public List<BuddyInfo> getBuddyList() {
        return this.BuddyList;
    }

    public void setBuddyList(List<BuddyInfo> buddyList) {
        this.BuddyList = buddyList;
    }
}
