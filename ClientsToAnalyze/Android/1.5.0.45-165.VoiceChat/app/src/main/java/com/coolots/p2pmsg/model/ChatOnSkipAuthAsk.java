package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class ChatOnSkipAuthAsk extends MsgBody {

    @NotNull
    private String AccessToken;

    @NotNull
    private int CountryCode;

    @NotNull
    private String PhoneNo;

    @NotNull
    @Size(max = 10, min = 10)
    private String SamsungAccountID;

    public String getSamsungAccountID() {
        return this.SamsungAccountID;
    }

    public void setSamsungAccountID(String samsungAccountID) {
        this.SamsungAccountID = samsungAccountID;
    }

    public String getAccessToken() {
        return this.AccessToken;
    }

    public void setAccessToken(String accessToken) {
        this.AccessToken = accessToken;
    }

    public int getCountryCode() {
        return this.CountryCode;
    }

    public void setCountryCode(int countryCode) {
        this.CountryCode = countryCode;
    }

    public String getPhoneNo() {
        return this.PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.PhoneNo = phoneNo;
    }
}
