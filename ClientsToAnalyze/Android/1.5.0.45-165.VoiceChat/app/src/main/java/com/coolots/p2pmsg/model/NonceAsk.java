package com.coolots.p2pmsg.model;

import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class NonceAsk extends MsgBody {

    @Size(max = 16)
    private String AppVersion;

    @Deprecated
    @Size(max = 64, min = 1)
    private String ApplicationID;

    public String getAppVersion() {
        return this.AppVersion;
    }

    public void setAppVersion(String appVersion) {
        this.AppVersion = appVersion;
    }

    @Deprecated
    public String getApplicationID() {
        return this.ApplicationID;
    }

    @Deprecated
    public void setApplicationID(String applicationID) {
        this.ApplicationID = applicationID;
    }
}
