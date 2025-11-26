package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class WantedAsk extends MsgBody {
    private String SamsungAccountID;

    @NotNull
    @Size(min = 1)
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
}
