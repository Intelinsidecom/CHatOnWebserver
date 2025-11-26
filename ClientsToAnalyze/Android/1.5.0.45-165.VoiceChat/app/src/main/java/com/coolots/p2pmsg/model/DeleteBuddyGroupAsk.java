package com.coolots.p2pmsg.model;

import javax.validation.constraints.Min;

/* loaded from: classes.dex */
public class DeleteBuddyGroupAsk extends MsgBody {

    @Min(0)
    private long GroupCode;

    public long getGroupCode() {
        return this.GroupCode;
    }

    public void setGroupCode(long groupCode) {
        this.GroupCode = groupCode;
    }
}
