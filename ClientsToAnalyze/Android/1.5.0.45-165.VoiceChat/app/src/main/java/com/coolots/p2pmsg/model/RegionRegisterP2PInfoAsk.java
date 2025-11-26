package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RegionRegisterP2PInfoAsk extends MsgBody {
    private String ConferenceNo;
    private String GroupCode;
    private P2PUserInfo P2PUserInfo;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public P2PUserInfo getP2PUserInfo() {
        return this.P2PUserInfo;
    }

    public void setP2PUserInfo(P2PUserInfo p2pUserInfo) {
        this.P2PUserInfo = p2pUserInfo;
    }

    public String getGroupCode() {
        return this.GroupCode;
    }

    public void setGroupCode(String groupCode) {
        this.GroupCode = groupCode;
    }
}
