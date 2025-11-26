package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RegionCloseConferenceAsk extends MsgBody {
    private String ConferenceNo;
    private String GroupCode;
    private String RequestUserID;
    private long RequestUserNo;
    private Integer StatusCode;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public String getGroupCode() {
        return this.GroupCode;
    }

    public void setGroupCode(String groupCode) {
        this.GroupCode = groupCode;
    }

    public String getRequestUserID() {
        return this.RequestUserID;
    }

    public void setRequestUserID(String requestUserID) {
        this.RequestUserID = requestUserID;
    }

    public long getRequestUserNo() {
        return this.RequestUserNo;
    }

    public void setRequestUserNo(long requestUserNo) {
        this.RequestUserNo = requestUserNo;
    }

    public Integer getStatusCode() {
        return this.StatusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.StatusCode = statusCode;
    }
}
