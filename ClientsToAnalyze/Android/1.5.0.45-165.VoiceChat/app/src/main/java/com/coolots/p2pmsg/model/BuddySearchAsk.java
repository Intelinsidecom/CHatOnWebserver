package com.coolots.p2pmsg.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class BuddySearchAsk extends MsgBody {
    public static final int SEARCH_PHONENO = 2;
    public static final int SEARCH_USERID = 1;

    @Min(0)
    private Integer CountryCode;

    @Size(max = 64, min = 1)
    private String PhoneNo;

    @Max(2)
    @Min(1)
    private int SearchType;

    @Size(max = 128, min = 1)
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
}
