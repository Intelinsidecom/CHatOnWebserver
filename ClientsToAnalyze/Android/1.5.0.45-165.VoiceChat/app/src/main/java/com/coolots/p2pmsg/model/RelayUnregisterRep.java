package com.coolots.p2pmsg.model;

import javax.validation.constraints.Min;

/* loaded from: classes.dex */
public class RelayUnregisterRep extends MsgBody {
    private int ErrorCode;

    @Min(1)
    private long UserNo;

    public long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(long userNo) {
        this.UserNo = userNo;
    }

    public int getErrorCode() {
        return this.ErrorCode;
    }

    public void setErrorCode(int errorCode) {
        this.ErrorCode = errorCode;
    }
}
