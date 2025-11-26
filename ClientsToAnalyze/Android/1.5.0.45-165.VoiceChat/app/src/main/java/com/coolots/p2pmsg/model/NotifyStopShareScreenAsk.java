package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class NotifyStopShareScreenAsk extends MsgBody {
    private int CallSessionID;
    private String ConferenceNo;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public int getCallSessionID() {
        return this.CallSessionID;
    }

    public void setCallSessionID(int callSessionID) {
        this.CallSessionID = callSessionID;
    }
}
