package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class ChatOnSMSAuthRep extends MsgBody {
    private String ErrorCode;
    private String ErrorMsg;
    private String UserToken;

    public String getUserToken() {
        return this.UserToken;
    }

    public void setUserToken(String userToken) {
        this.UserToken = userToken;
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
