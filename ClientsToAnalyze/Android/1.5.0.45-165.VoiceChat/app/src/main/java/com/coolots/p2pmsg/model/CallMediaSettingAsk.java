package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class CallMediaSettingAsk extends MsgBody {
    private String FirmwareVersion;
    private String Model;
    private String OsVersion;

    public String getModel() {
        return this.Model;
    }

    public void setModel(String model) {
        this.Model = model;
    }

    public String getOsVersion() {
        return this.OsVersion;
    }

    public void setOsVersion(String osVersion) {
        this.OsVersion = osVersion;
    }

    public String getFirmwareVersion() {
        return this.FirmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.FirmwareVersion = firmwareVersion;
    }
}
