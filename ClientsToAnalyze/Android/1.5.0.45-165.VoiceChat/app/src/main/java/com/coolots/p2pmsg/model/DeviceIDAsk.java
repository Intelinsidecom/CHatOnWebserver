package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.StringCase;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class DeviceIDAsk extends MsgBody {

    @Size(max = 16, min = 0)
    private String AppVersion;

    @Deprecated
    @Size(max = 64, min = 1)
    private String ApplicationID;

    @Size(max = 16, min = 16)
    private String AuthID;
    private String ChatOnUID;

    @Size(max = 32, min = 0)
    private String DeviceModel;

    @StringCase(caseArray = {"S", "M", "T"})
    private String DeviceType;

    @Size(max = 3, min = 3)
    private String MCC;

    @Size(max = 3, min = 0)
    private String MNC;

    @Size(max = 32, min = 0)
    private String OsName;

    @Size(max = 50, min = 0)
    private String OsVersion;

    @Size(max = 128, min = 0)
    private String PassWord;

    @Size(max = 128)
    private String SerialNo;

    public String getDeviceType() {
        return this.DeviceType;
    }

    public void setDeviceType(String deviceType) {
        this.DeviceType = deviceType;
    }

    public String getSerialNo() {
        return this.SerialNo;
    }

    public void setSerialNo(String serialNo) {
        this.SerialNo = serialNo;
    }

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

    @Deprecated
    public String getApplicationID() {
        return this.ApplicationID;
    }

    @Deprecated
    public void setApplicationID(String applicationID) {
        this.ApplicationID = applicationID;
    }

    public String getMCC() {
        return this.MCC;
    }

    public void setMCC(String mcc) {
        this.MCC = mcc;
    }

    public String getMNC() {
        return this.MNC;
    }

    public void setMNC(String mnc) {
        this.MNC = mnc;
    }

    public String getPassWord() {
        return this.PassWord;
    }

    public void setPassWord(String passWord) {
        this.PassWord = passWord;
    }

    public String getAuthID() {
        return this.AuthID;
    }

    public void setAuthID(String authID) {
        this.AuthID = authID;
    }

    public String getChatOnUID() {
        return this.ChatOnUID;
    }

    public void setChatOnUID(String chatOnUID) {
        this.ChatOnUID = chatOnUID;
    }
}
