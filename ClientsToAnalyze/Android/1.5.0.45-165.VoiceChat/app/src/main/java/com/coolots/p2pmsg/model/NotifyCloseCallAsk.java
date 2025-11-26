package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class NotifyCloseCallAsk extends MsgBody {
    private String ConferenceNo;
    private String SenderID;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public String getSenderID() {
        return this.SenderID;
    }

    public void setSenderID(String senderID) {
        this.SenderID = senderID;
    }
}
