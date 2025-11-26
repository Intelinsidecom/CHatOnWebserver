package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class SAUserInfoAsk extends MsgBody {

    @NotNull
    @Size(max = 10, min = 10)
    private String SamsungAccountID = null;

    @NotNull
    private String AppID = null;

    @NotNull
    private String AccessToken = null;

    public String getSamsungAccountID() {
        return this.SamsungAccountID;
    }

    public void setSamsungAccountID(String samsungAccountID) {
        this.SamsungAccountID = samsungAccountID;
    }

    public String getAppID() {
        return this.AppID;
    }

    public void setAppID(String appID) {
        this.AppID = appID;
    }

    public String getAccessToken() {
        return this.AccessToken;
    }

    public void setAccessToken(String accessToken) {
        this.AccessToken = accessToken;
    }
}
