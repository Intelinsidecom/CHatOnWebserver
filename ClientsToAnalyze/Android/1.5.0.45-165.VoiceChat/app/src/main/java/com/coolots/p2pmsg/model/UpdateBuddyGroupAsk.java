package com.coolots.p2pmsg.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class UpdateBuddyGroupAsk extends MsgBody {

    @NotNull
    @Valid
    private BuddyGroupInfo BuddyGroupInfo;

    public BuddyGroupInfo getBuddyGroupInfo() {
        return this.BuddyGroupInfo;
    }

    public void setBuddyGroupInfo(BuddyGroupInfo buddyGroupInfo) {
        this.BuddyGroupInfo = buddyGroupInfo;
    }
}
