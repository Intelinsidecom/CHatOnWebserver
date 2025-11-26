package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class ClientToConnUnregisterRep extends MsgBody {
    private int ErrorCode;
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
