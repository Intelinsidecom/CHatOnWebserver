package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.Domain;
import com.coolots.p2pmsg.validator.PhoneNo;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class SIPInfo {

    @Min(1)
    private int BaseCountryCode;

    @Min(0)
    private int BasePrefix;

    @NotNull
    @Size(max = 64)
    private String DNSSRV;

    @NotNull
    @Size(max = 64)
    private String PPSIP;

    @Max(65535)
    @Min(1)
    private int PPSPort;

    @NotNull
    @PhoneNo
    private String PhoneNo;

    @Domain
    private String SIPDomain;

    @Min(1)
    private int SIPPort;

    @NotNull
    @Size(max = 128)
    private String SIPPwd;

    public String getPhoneNo() {
        return this.PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.PhoneNo = phoneNo;
    }

    public int getBaseCountryCode() {
        return this.BaseCountryCode;
    }

    public void setBaseCountryCode(int baseCountryCode) {
        this.BaseCountryCode = baseCountryCode;
    }

    public int getBasePrefix() {
        return this.BasePrefix;
    }

    public void setBasePrefix(int basePrefix) {
        this.BasePrefix = basePrefix;
    }

    public String getSIPDomain() {
        return this.SIPDomain;
    }

    public void setSIPDomain(String domain) {
        this.SIPDomain = domain;
    }

    public int getSIPPort() {
        return this.SIPPort;
    }

    public void setSIPPort(int port) {
        this.SIPPort = port;
    }

    public String getSIPPwd() {
        return this.SIPPwd;
    }

    public void setSIPPwd(String pwd) {
        this.SIPPwd = pwd;
    }

    public String getDNSSRV() {
        return this.DNSSRV;
    }

    public void setDNSSRV(String dnssrv) {
        this.DNSSRV = dnssrv;
    }

    public String getPPSIP() {
        return this.PPSIP;
    }

    public void setPPSIP(String ppsip) {
        this.PPSIP = ppsip;
    }

    public int getPPSPort() {
        return this.PPSPort;
    }

    public void setPPSPort(int port) {
        this.PPSPort = port;
    }
}
