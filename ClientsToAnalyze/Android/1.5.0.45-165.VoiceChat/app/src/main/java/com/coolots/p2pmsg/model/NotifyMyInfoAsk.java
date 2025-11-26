package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class NotifyMyInfoAsk extends MsgBody {
    private String SharedID;
    private UserInfo UserInfo;

    public UserInfo getUserInfo() {
        return this.UserInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.UserInfo = userInfo;
    }

    public String getSharedID() {
        return this.SharedID;
    }

    public void setSharedID(String sharedID) {
        this.SharedID = sharedID;
    }
}
