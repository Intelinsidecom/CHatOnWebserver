package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class PhoneNoAuthAsk extends MsgBody {
    private String AuthID;
    private String AuthNo;

    public String getAuthID() {
        return this.AuthID;
    }

    public void setAuthID(String authID) {
        this.AuthID = authID;
    }

    public String getAuthNo() {
        return this.AuthNo;
    }

    public void setAuthNo(String authNo) {
        this.AuthNo = authNo;
    }
}
