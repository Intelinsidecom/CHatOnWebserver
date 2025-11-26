package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/* loaded from: classes.dex */
public class SwitchToSingleCallAsk extends MsgBody {

    @NotNull
    @Pattern(regexp = "[0-9]{24}")
    private String ConferenceNo;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }
}
