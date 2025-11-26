package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DeletedContactsRep extends MsgBody {
    private List<BuddyInfo> BuddyInfoList = new ArrayList();

    public List<BuddyInfo> getBuddyInfoList() {
        return this.BuddyInfoList;
    }

    public void setBuddyInfoList(List<BuddyInfo> buddyInfoList) {
        this.BuddyInfoList = buddyInfoList;
    }
}
