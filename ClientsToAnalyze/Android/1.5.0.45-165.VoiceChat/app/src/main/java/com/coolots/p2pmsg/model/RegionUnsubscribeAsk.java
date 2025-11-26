package com.coolots.p2pmsg.model;

import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class RegionUnsubscribeAsk extends MsgBody implements Serializable {
    private static final long serialVersionUID = 1;

    @NotNull
    @Size(max = 128, min = 1)
    private String UserID;

    @Min(0)
    private long UserNo;

    public long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(long userNo) {
        this.UserNo = userNo;
    }

    public String getUserID() {
        return this.UserID;
    }

    public void setUserID(String userID) {
        this.UserID = userID;
    }
}
