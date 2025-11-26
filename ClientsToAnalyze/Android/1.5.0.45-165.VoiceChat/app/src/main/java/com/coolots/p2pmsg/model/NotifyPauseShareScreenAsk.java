package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class NotifyPauseShareScreenAsk extends MsgBody {
    private int CallSessionID;
    private String ConferenceNo;
    private int PauseReason;

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

    public int getPauseReason() {
        return this.PauseReason;
    }

    public void setPauseReason(int reason) {
        this.PauseReason = reason;
    }
}
