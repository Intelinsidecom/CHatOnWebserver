package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class ChangeMemberStatusAsk extends MsgBody {
    private String CloseReason;
    private String ReasonCode;
    private long UserNo;

    public long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(long userNo) {
        this.UserNo = userNo;
    }

    public String getReasonCode() {
        return this.ReasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.ReasonCode = reasonCode;
    }

    public String getCloseReason() {
        return this.CloseReason;
    }

    public void setCloseReason(String closeReason) {
        this.CloseReason = closeReason;
    }
}
