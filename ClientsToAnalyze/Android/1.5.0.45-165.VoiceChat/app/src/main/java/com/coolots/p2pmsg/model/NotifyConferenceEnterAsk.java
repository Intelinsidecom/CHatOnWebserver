package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class NotifyConferenceEnterAsk extends MsgBody {
    private String ConferenceNo;
    private String EventID;
    private String P2PKey;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public String getP2PKey() {
        return this.P2PKey;
    }

    public void setP2PKey(String p2pKey) {
        this.P2PKey = p2pKey;
    }

    public String getEventID() {
        return this.EventID;
    }

    public void setEventID(String eventID) {
        this.EventID = eventID;
    }
}
