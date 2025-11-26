package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RegionConferenceInfoAsk extends MsgBody {
    private String ConferenceNo;
    private String SenderUserID;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public String getSenderUserID() {
        return this.SenderUserID;
    }

    public void setSenderUserID(String senderUserID) {
        this.SenderUserID = senderUserID;
    }
}
