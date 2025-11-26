package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class JoinAsk extends MsgBody {
    private String AuthID;
    private Integer CountryCode;
    private String Email;
    private String NationalCode;
    private String Passwd;
    private String PhoneNo;
    private String USimPhoneNo;
    private String UserID;
    private String UserName;

    public String getUserID() {
        return this.UserID;
    }

    public void setUserID(String userId) {
        this.UserID = userId;
    }

    public String getPasswd() {
        return this.Passwd;
    }

    public void setPasswd(String passwd) {
        this.Passwd = passwd;
    }

    public String getUserName() {
        return this.UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getNationalCode() {
        return this.NationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.NationalCode = nationalCode;
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

    public String getUSimPhoneNo() {
        return this.USimPhoneNo;
    }

    public void setUSimPhoneNo(String simPhoneNo) {
        this.USimPhoneNo = simPhoneNo;
    }

    public String getAuthID() {
        return this.AuthID;
    }

    public void setAuthID(String authID) {
        this.AuthID = authID;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }
}
