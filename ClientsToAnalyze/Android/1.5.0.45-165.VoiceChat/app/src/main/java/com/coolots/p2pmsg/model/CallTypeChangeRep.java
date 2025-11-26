package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class CallTypeChangeRep extends MsgBody {
    private int CallSessionID;
    private String ConferenceNo;
    private int MediaType;
    private int RequestKey;
    private boolean Response;
    private String UserID;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public int getMediaType() {
        return this.MediaType;
    }

    public void setMediaType(int mediaType) {
        this.MediaType = mediaType;
    }

    public int getRequestKey() {
        return this.RequestKey;
    }

    public void setRequestKey(int requestKey) {
        this.RequestKey = requestKey;
    }

    public boolean isResponse() {
        return this.Response;
    }

    public boolean getResponse() {
        return this.Response;
    }

    public void setResponse(boolean response) {
        this.Response = response;
    }

    public String getUserID() {
        return this.UserID;
    }

    public void setUserID(String userID) {
        this.UserID = userID;
    }

    public int getCallSessionID() {
        return this.CallSessionID;
    }

    public void setCallSessionID(int callSessionID) {
        this.CallSessionID = callSessionID;
    }
}
