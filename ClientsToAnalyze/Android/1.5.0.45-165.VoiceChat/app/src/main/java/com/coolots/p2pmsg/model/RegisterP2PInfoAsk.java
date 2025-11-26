package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/* loaded from: classes.dex */
public class RegisterP2PInfoAsk extends MsgBody {

    @NotNull
    @Pattern(regexp = "[0-9]{24}")
    private String ConferenceNo;

    @NotNull
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
}
