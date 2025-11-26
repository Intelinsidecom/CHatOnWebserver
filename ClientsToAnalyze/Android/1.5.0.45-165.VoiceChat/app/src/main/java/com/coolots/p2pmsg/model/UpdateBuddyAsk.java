package com.coolots.p2pmsg.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class UpdateBuddyAsk extends MsgBody {

    @NotNull
    @Valid
    private BuddyInfo BuddyInfo;

    public BuddyInfo getBuddyInfo() {
        return this.BuddyInfo;
    }

    public void setBuddyInfo(BuddyInfo buddyInfo) {
        this.BuddyInfo = buddyInfo;
    }
}
