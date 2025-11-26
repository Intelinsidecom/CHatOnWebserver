package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RefreshConnRegisterAsk extends MsgBody {
    private String CdrID;
    private String ConferenceNo;

    public String getCdrID() {
        return this.CdrID;
    }

    public void setCdrID(String cdrID) {
        this.CdrID = cdrID;
    }

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }
}
