package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/* loaded from: classes.dex */
public class MuteConferenceAsk extends MsgBody {
    public static final String MUTE_N = "N";
    public static final String MUTE_Y = "Y";

    @NotNull
    @Pattern(regexp = "[0-9]{24}")
    private String ConferenceNo;

    @NotNull
    @Pattern(regexp = "[YN]{1}")
    private String MuteAudioYn;

    @NotNull
    @Pattern(regexp = "[YN]{1}")
    private String MuteVideoYn;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
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
