package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class PhoneNoAuthSMSAsk extends MsgBody {
    private Integer CountryCode;
    private String PhoneNo;

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
