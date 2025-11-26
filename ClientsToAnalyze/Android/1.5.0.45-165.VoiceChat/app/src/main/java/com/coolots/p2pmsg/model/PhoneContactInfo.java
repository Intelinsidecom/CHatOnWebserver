package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class PhoneContactInfo {
    private String EmailAddress;
    private String Name;
    private String NumberLabel;
    private int NumberType;
    private String PhoneNo;

    public void dispose() {
        this.Name = null;
        this.PhoneNo = null;
        this.EmailAddress = null;
        this.NumberType = 0;
        this.NumberLabel = null;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getPhoneNo() {
        return this.PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.PhoneNo = phoneNo;
    }

    public int getNumberType() {
        return this.NumberType;
    }

    public void setNumberType(int numberType) {
        this.NumberType = numberType;
    }

    public String getNumberLabel() {
        return this.NumberLabel;
    }

    public void setNumberLabel(String numberLabel) {
        this.NumberLabel = numberLabel;
    }

    public void setEmailAddress(String email) {
        this.EmailAddress = email;
    }

    public String getEmailAddress() {
        return this.EmailAddress;
    }
}
