package com.sec.chaton.privateplugin.data;

/* loaded from: classes.dex */
public class RegisterFromSaReq {
    private String api_server;
    private String authcode;
    private String einfo;
    private String emailsamsung;
    private String imei;
    private String imsi;
    private String model;
    private String name;
    private String osversion;
    private String pushtype;
    private String regid;

    public String getImei() {
        return this.imei;
    }

    public String getImsi() {
        return this.imsi;
    }

    public String getAuthcode() {
        return this.authcode;
    }

    public String getEmailsamsung() {
        return this.emailsamsung;
    }

    public String getName() {
        return this.name;
    }

    public String getRegid() {
        return this.regid;
    }

    public String getPushtype() {
        return this.pushtype;
    }

    public String getOsversion() {
        return this.osversion;
    }

    public String getModel() {
        return this.model;
    }

    public String getEinfo() {
        return this.einfo;
    }

    public String getApiServer() {
        return this.api_server;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setImsi(String str) {
        this.imsi = str;
    }

    public void setAuthcode(String str) {
        this.authcode = str;
    }

    public void setEmailsamsung(String str) {
        this.emailsamsung = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRegid(String str) {
        this.regid = str;
    }

    public void setPushtype(String str) {
        this.pushtype = str;
    }

    public void setOsversion(String str) {
        this.osversion = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setEinfo(String str) {
        this.einfo = str;
    }

    public void setApiServer(String str) {
        this.api_server = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RegisterFromSaInfo [imei=").append(this.imei).append(", imsi=").append(this.imsi).append(", authcode=").append(this.authcode).append(", emailsamsung=").append(this.emailsamsung).append(", name=").append(this.name).append(", regid=").append(this.regid).append(", pushtype=").append(this.pushtype).append(", osversion=").append(this.osversion).append(", model=").append(this.model).append(", einfo=").append(this.einfo).append(", api_server=").append(this.api_server).append("]");
        return sb.toString();
    }
}
