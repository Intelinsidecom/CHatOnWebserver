package com.coolots.p2pmsg.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class RegionInfo {
    public static final int RESPONSE_BAD_REQUEST = 400;
    public static final int RESPONSE_NOT_FOUND = 404;
    public static final int RESPONSE_OK = 200;
    public static final int RESPONSE_SERVER_INTERNAL_ERROR = 500;
    private String Email;

    @Min(0)
    private byte RegionCode;
    private int ResponseCode;
    private String SamsungAccountID;

    @NotNull
    @Size(max = 128, min = 1)
    private String UserID;

    @Min(1)
    private long UserNo;

    public long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(long userNo) {
        this.UserNo = userNo;
    }

    public String getUserID() {
        return this.UserID;
    }

    public void setUserID(String userID) {
        this.UserID = userID;
    }

    public String getSamsungAccountID() {
        return this.SamsungAccountID;
    }

    public void setSamsungAccountID(String samsungAccountID) {
        this.SamsungAccountID = samsungAccountID;
    }

    public byte getRegionCode() {
        return this.RegionCode;
    }

    public void setRegionCode(byte regionCode) {
        this.RegionCode = regionCode;
    }

    public void setRegionCode(int regionCode) {
        this.RegionCode = (byte) regionCode;
    }

    public int getResponseCode() {
        return this.ResponseCode;
    }

    public void setResponseCode(int responseCode) {
        this.ResponseCode = responseCode;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }
}
