package com.sec.chaton.privateplugin.data;

/* loaded from: classes.dex */
public class RegisterReq {
    private String authnum;
    private String einfo;
    private String emailsamsung;
    private String imei;
    private String imsi;
    private String model;
    private String msisdn;
    private String name;
    private String osversion;
    private String pushtype;
    private String regid;
    private String token;

    public String getImei() {
        return this.imei;
    }

    public String getImsi() {
        return this.imsi;
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

    public void setImei(String str) {
        this.imei = str;
    }

    public void setImsi(String str) {
        this.imsi = str;
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

    public String getMsisdn() {
        return this.msisdn;
    }

    public String getToken() {
        return this.token;
    }

    public String getAuthnum() {
        return this.authnum;
    }

    public void setMsisdn(String str) {
        this.msisdn = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setAuthnum(String str) {
        this.authnum = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RegisterReq [msisdn=").append(this.msisdn).append(", imei=").append(this.imei).append(", regid=").append(this.regid).append(", pushtype=").append(this.pushtype).append(", osversion=").append(this.osversion).append(", imsi=").append(this.imsi).append(", model=").append(this.model).append(", name=").append(this.name).append(", emailsamsung=").append(this.emailsamsung).append(", token=").append(this.token).append(", authnum=").append(this.authnum).append(", einfo=").append(this.einfo).append("]");
        return sb.toString();
    }
}
