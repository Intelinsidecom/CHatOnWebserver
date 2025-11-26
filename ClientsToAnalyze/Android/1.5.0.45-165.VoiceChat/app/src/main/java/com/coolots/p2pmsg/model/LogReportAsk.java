package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class LogReportAsk extends MsgBody {
    private String AppVersion;
    private String LogData;

    public String getAppVersion() {
        return this.AppVersion;
    }

    public void setAppVersion(String appVersion) {
        this.AppVersion = appVersion;
    }

    public String getLogData() {
        return this.LogData;
    }

    public void setLogData(String logData) {
        this.LogData = logData;
    }
}
