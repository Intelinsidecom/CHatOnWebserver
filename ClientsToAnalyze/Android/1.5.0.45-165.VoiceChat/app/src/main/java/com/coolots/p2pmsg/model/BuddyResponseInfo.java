package com.coolots.p2pmsg.model;

import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class BuddyResponseInfo {
    public static final int RESPONSE_BAD_REQUEST = 400;
    public static final int RESPONSE_NOT_FOUND = 404;
    public static final int RESPONSE_OK = 200;
    public static final int RESPONSE_SERVER_INTERNAL_ERROR = 500;
    private BuddyInfo BuddyInfo;

    @Size(min = 1)
    private int ResponseCode;

    public BuddyInfo getBuddyInfo() {
        return this.BuddyInfo;
    }

    public void setBuddyInfo(BuddyInfo buddyInfo) {
        this.BuddyInfo = buddyInfo;
    }

    public int getResponseCode() {
        return this.ResponseCode;
    }

    public void setResponseCode(int responseCode) {
        this.ResponseCode = responseCode;
    }
}
