package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class UpdateBuddyRep extends MsgBody {
    private BuddyInfo BuddyInfo;

    public BuddyInfo getBuddyInfo() {
        return this.BuddyInfo;
    }

    public void setBuddyInfo(BuddyInfo buddyInfo) {
        this.BuddyInfo = buddyInfo;
    }
}
