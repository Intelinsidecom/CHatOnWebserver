package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class CallTypeChangeAsk extends MsgBody {
    private int CallSessionID;
    private String ConferenceNo;
    private int MediaType;
    private int RequestKey;
    private String RequesterID;

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

    public String getRequesterID() {
        return this.RequesterID;
    }

    public void setRequesterID(String requesterID) {
        this.RequesterID = requesterID;
    }

    public int getCallSessionID() {
        return this.CallSessionID;
    }

    public void setCallSessionID(int callSessionID) {
        this.CallSessionID = callSessionID;
    }
}
