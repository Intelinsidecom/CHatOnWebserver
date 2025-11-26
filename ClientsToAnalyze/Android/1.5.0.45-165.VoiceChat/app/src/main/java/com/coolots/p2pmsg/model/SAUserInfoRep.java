package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class SAUserInfoRep extends MsgBody {
    private String SamsungAccountID = null;
    private String CountryCode2 = null;
    private String CountryCode3 = null;
    private String FamilyName = null;
    private String GivenName = null;
    private String Birthdate = null;
    private String LoginID = null;

    public String getSamsungAccountID() {
        return this.SamsungAccountID;
    }

    public void setSamsungAccountID(String samsungAccountID) {
        this.SamsungAccountID = samsungAccountID;
    }

    public String getCountryCode2() {
        return this.CountryCode2;
    }

    public void setCountryCode2(String countryCode2) {
        this.CountryCode2 = countryCode2;
    }

    public String getCountryCode3() {
        return this.CountryCode3;
    }

    public void setCountryCode3(String countryCode3) {
        this.CountryCode3 = countryCode3;
    }

    public String getFamilyName() {
        return this.FamilyName;
    }

    public void setFamilyName(String familyName) {
        this.FamilyName = familyName;
    }

    public String getGivenName() {
        return this.GivenName;
    }

    public void setGivenName(String givenName) {
        this.GivenName = givenName;
    }

    public String getBirthdate() {
        return this.Birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.Birthdate = birthdate;
    }

    public String getLoginID() {
        return this.LoginID;
    }

    public void setLoginID(String loginID) {
        this.LoginID = loginID;
    }
}
