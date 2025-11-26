package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/* loaded from: classes.dex */
public class HoldConferenceAsk extends MsgBody {
    public static final String HOLD_N = "N";
    public static final String HOLD_Y = "Y";

    @NotNull
    @Pattern(regexp = "[0-9]{24}")
    private String ConferenceNo;

    @NotNull
    @Pattern(regexp = "[YN]{1}")
    private String HoldYn;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public String getHoldYn() {
        return this.HoldYn;
    }

    public void setHoldYn(String holdYn) {
        this.HoldYn = holdYn;
    }
}
