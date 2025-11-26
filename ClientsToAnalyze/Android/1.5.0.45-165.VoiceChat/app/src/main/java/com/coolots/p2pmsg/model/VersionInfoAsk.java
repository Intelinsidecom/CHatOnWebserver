package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class VersionInfoAsk extends MsgBody {

    @Size(max = 64, min = 1)
    private String AppId;

    @NotNull
    private String AppVersion;
    private String DeviceModel;
    private String OsName;
    private String OsVersion;

    public String getOsName() {
        return this.OsName;
    }

    public void setOsName(String osName) {
        this.OsName = osName;
    }

    public String getOsVersion() {
        return this.OsVersion;
    }

    public void setOsVersion(String osVersion) {
        this.OsVersion = osVersion;
    }

    public String getDeviceModel() {
        return this.DeviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.DeviceModel = deviceModel;
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
