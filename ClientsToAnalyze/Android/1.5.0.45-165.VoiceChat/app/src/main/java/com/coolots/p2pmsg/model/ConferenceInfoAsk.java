package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class ConferenceInfoAsk extends MsgBody {

    @Size(max = 64, min = 1)
    private String AppId;
    private String AppVersion;

    @NotNull
    @Pattern(regexp = "[0-9]{24}")
    private String ConferenceNo;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public String getAppVersion() {
        return this.AppVersion;
    }

    public void setAppVersion(String appVersion) {
        this.AppVersion = appVersion;
    }

    public String getAppId() {
        return this.AppId;
    }

    public void setAppId(String AppId) {
        this.AppId = AppId;
    }
}
