package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RegionHoldConferenceAsk extends MsgBody {
    private String ConferenceNo;
    private String GroupCode;
    private String HoldYn;
    private String UserID;
    private long UserNo;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public String getUserID() {
        return this.UserID;
    }

    public void setUserID(String userID) {
        this.UserID = userID;
    }

    public long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(long userNo) {
        this.UserNo = userNo;
    }

    public String getGroupCode() {
        return this.GroupCode;
    }

    public void setGroupCode(String groupCode) {
        this.GroupCode = groupCode;
    }

    public String getHoldYn() {
        return this.HoldYn;
    }

    public void setHoldYn(String holdYn) {
        this.HoldYn = holdYn;
    }
}
