package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RegionBuddySearchAsk extends MsgBody {
    private Integer CountryCode;
    private String GroupCode;
    private String PhoneNo;
    private int SearchType;
    private String UserID;

    public int getSearchType() {
        return this.SearchType;
    }

    public void setSearchType(int searchType) {
        this.SearchType = searchType;
    }

    public String getUserID() {
        return this.UserID;
    }

    public void setUserID(String userID) {
        this.UserID = userID;
    }

    public Integer getCountryCode() {
        return this.CountryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.CountryCode = countryCode;
    }

    public String getPhoneNo() {
        return this.PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.PhoneNo = phoneNo;
    }

    public String getGroupCode() {
        return this.GroupCode;
    }

    public void setGroupCode(String groupCode) {
        this.GroupCode = groupCode;
    }
}
