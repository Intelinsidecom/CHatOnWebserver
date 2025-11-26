package com.coolots.p2pmsg.model;

import javax.validation.constraints.Min;

/* loaded from: classes.dex */
public class ClientToConnRegisterAsk extends MsgBody {

    @Min(1)
    private long UserNo;

    public long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(long userNo) {
        this.UserNo = userNo;
    }
}
