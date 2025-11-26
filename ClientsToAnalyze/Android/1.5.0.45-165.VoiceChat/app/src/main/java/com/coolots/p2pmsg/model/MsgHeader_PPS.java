package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class MsgHeader_PPS {
    private String EventTimestamp;
    private String ICID;
    private String RequestNumber;
    private String RequestType;
    private String SessionId;

    public String getSessionId() {
        return this.SessionId;
    }

    public void setSessionId(String sessionId) {
        this.SessionId = sessionId;
    }

    public String getICID() {
        return this.ICID;
    }

    public void setICID(String iCID) {
        this.ICID = iCID;
    }

    public String getRequestType() {
        return this.RequestType;
    }

    public void setRequestType(String requestType) {
        this.RequestType = requestType;
    }

    public String getRequestNumber() {
        return this.RequestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.RequestNumber = requestNumber;
    }

    public String getEventTimestamp() {
        return this.EventTimestamp;
    }

    public void setEventTimestamp(String eventTimestamp) {
        this.EventTimestamp = eventTimestamp;
    }
}
