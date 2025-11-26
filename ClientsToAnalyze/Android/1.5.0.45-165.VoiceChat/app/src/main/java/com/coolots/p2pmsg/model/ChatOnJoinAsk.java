package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class ChatOnJoinAsk extends MsgBody {

    @Size(max = 30, min = 0)
    private String BirthDate;

    @NotNull
    private String Email;

    @NotNull
    @Size(max = 2, min = 2)
    private String NationalCode;

    @NotNull
    @Size(max = 10, min = 10)
    private String SamsungAccountID;

    @NotNull
    @Size(max = 128, min = 1)
    private String UserID;

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

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getNationalCode() {
        return this.NationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.NationalCode = nationalCode;
    }

    public String getBirthDate() {
        return this.BirthDate;
    }

    public void setBirthDate(String birthDate) {
        this.BirthDate = birthDate;
    }
}
