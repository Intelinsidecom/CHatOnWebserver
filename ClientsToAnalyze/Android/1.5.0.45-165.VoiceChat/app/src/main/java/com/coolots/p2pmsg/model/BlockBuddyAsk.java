package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class BlockBuddyAsk extends MsgBody {

    @NotNull
    @Valid
    private List<BuddyInfo> BuddyInfoList = new ArrayList();

    public List<BuddyInfo> getBuddyInfoList() {
        return this.BuddyInfoList;
    }

    public void setBuddyInfoList(List<BuddyInfo> buddyInfoList) {
        this.BuddyInfoList = buddyInfoList;
    }
}
