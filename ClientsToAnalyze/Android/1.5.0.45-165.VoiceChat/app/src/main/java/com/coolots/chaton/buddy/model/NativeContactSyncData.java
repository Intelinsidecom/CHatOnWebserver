package com.coolots.chaton.buddy.model;

/* loaded from: classes.dex */
public class NativeContactSyncData {
    private String samsungAccount = null;
    private String userID = null;
    private String nativeName = null;
    private long userNo = -1;
    private long rawContactID = -1;

    public void setSamsungAccount(String account) {
        this.samsungAccount = account;
    }

    public void setUserID(String userid) {
        this.userID = userid;
    }

    public void setNativeName(String name) {
        this.nativeName = name;
    }

    public void setUserNo(long userNo) {
        this.userNo = userNo;
    }

    public void setRawContactID(long rawContactID) {
        this.rawContactID = rawContactID;
    }

    public String getSamsungAccount() {
        return this.samsungAccount;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getNativeName() {
        return this.nativeName;
    }

    public long getUserNo() {
        return this.userNo;
    }

    public long getRawContactID() {
        return this.rawContactID;
    }
}
