package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RegionMuteConferenceAsk extends MsgBody {
    public static final String MUTE_N = "N";
    public static final String MUTE_Y = "Y";
    private String ConferenceNo;
    private String GroupCode;
    private String MuteAudioYn;
    private String MuteVideoYn;
    private String RequestUserID;
    private long RequestUserNo;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public String getGroupCode() {
        return this.GroupCode;
    }

    public void setGroupCode(String groupCode) {
        this.GroupCode = groupCode;
    }

    public String getRequestUserID() {
        return this.RequestUserID;
    }

    public void setRequestUserID(String requestUserID) {
        this.RequestUserID = requestUserID;
    }

    public long getRequestUserNo() {
        return this.RequestUserNo;
    }

    public void setRequestUserNo(long requestUserNo) {
        this.RequestUserNo = requestUserNo;
    }

    public String getMuteVideoYn() {
        return this.MuteVideoYn;
    }

    public void setMuteVideoYn(String muteVideoYn) {
        this.MuteVideoYn = muteVideoYn;
    }

    public String getMuteAudioYn() {
        return this.MuteAudioYn;
    }

    public void setMuteAudioYn(String muteAudioYn) {
        this.MuteAudioYn = muteAudioYn;
    }
}
