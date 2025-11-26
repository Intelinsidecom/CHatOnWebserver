package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RequestCallTypeChangeRep extends MsgBody {
    private int CallSessionID;
    private String ConferenceNo;
    private int MediaType;
    private int RequestKey;
    private boolean RequestResult;

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

    public boolean isRequestResult() {
        return this.RequestResult;
    }

    public boolean getRequestResult() {
        return this.RequestResult;
    }

    public void setRequestResult(boolean requestResult) {
        this.RequestResult = requestResult;
    }

    public int getCallSessionID() {
        return this.CallSessionID;
    }

    public void setCallSessionID(int callSessionID) {
        this.CallSessionID = callSessionID;
    }
}
