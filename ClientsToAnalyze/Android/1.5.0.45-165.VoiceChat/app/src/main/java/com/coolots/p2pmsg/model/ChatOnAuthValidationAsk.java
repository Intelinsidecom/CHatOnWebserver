package com.coolots.p2pmsg.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class ChatOnAuthValidationAsk extends MsgBody {
    private String AccessToken;

    @NotNull
    @Size(max = 4, min = 4)
    private String AuthNumber;

    @Min(0)
    private int CountryCode;

    @NotNull
    @Size(max = 10, min = 10)
    private String GuidSamsungAccount;

    @NotNull
    @Size(max = 64, min = 0)
    private String PhoneNo;

    @NotNull
    @Size(max = 16, min = 16)
    private String UserToken;

    public String getAccessToken() {
        return this.AccessToken;
    }

    public void setAccessToken(String accessToken) {
        this.AccessToken = accessToken;
    }

    public String getGuidSamsungAccount() {
        return this.GuidSamsungAccount;
    }

    public void setGuidSamsungAccount(String guidSamsungAccount) {
        this.GuidSamsungAccount = guidSamsungAccount;
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

    public String getUserToken() {
        return this.UserToken;
    }

    public void setUserToken(String userToken) {
        this.UserToken = userToken;
    }

    public String getAuthNumber() {
        return this.AuthNumber;
    }

    public void setAuthNumber(String authNumber) {
        this.AuthNumber = authNumber;
    }
}
