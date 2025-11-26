package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class ChatOnAuthValidationRep extends MsgBody {
    private String ErrorCode;
    private String ErrorMsg;
    private String JoinStatus;
    private String ValidationTime;

    public String getValidationTime() {
        return this.ValidationTime;
    }

    public void setValidationTime(String validationTime) {
        this.ValidationTime = validationTime;
    }

    public String getJoinStatus() {
        return this.JoinStatus;
    }

    public void setJoinStatus(String joinStatus) {
        this.JoinStatus = joinStatus;
    }

    public String getErrorCode() {
        return this.ErrorCode;
    }

    public void setErrorCode(String errorCode) {
        this.ErrorCode = errorCode;
    }

    public String getErrorMsg() {
        return this.ErrorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.ErrorMsg = errorMsg;
    }
}
