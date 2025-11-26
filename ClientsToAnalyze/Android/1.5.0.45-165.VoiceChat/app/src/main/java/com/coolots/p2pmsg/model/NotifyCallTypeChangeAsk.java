package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class NotifyCallTypeChangeAsk extends MsgBody {
    private int CallSessionID;
    private String ConferenceNo;
    private int MediaType;
    private int RequestKey;
    private boolean Result;

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

    public boolean isResult() {
        return this.Result;
    }

    public boolean getResult() {
        return this.Result;
    }

    public void setResult(boolean result) {
        this.Result = result;
    }

    public int getCallSessionID() {
        return this.CallSessionID;
    }

    public void setCallSessionID(int callSessionID) {
        this.CallSessionID = callSessionID;
    }
}
