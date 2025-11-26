package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.Email;
import com.coolots.p2pmsg.validator.PhoneNo;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class LinkAccountAsk extends MsgBody {

    @Min(0)
    private Integer CountryCode;

    @Email
    @Size(max = 256)
    private String Email;

    @NotNull
    @Size(max = 3, min = 3)
    private String NationalCode;

    @NotNull
    @Size(max = 64, min = 32)
    private String Passwd;

    @NotNull
    @PhoneNo
    private String PhoneNo;

    @NotNull
    @Size(max = 85, min = 8)
    private String UserID;

    @NotNull
    @Size(max = 20, min = 1)
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

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }
}
