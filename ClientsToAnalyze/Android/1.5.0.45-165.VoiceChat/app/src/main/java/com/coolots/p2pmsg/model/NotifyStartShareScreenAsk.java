package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class NotifyStartShareScreenAsk extends MsgBody {
    private int CallSessionID;
    private String ConferenceNo;
    private int Height;
    private String Version;
    private int Width;

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

    public int getWidth() {
        return this.Width;
    }

    public void setWidth(int width) {
        this.Width = width;
    }

    public int getHeight() {
        return this.Height;
    }

    public void setHeight(int height) {
        this.Height = height;
    }

    public String getVersion() {
        return this.Version;
    }

    public void setVersion(String version) {
        this.Version = version;
    }
}
