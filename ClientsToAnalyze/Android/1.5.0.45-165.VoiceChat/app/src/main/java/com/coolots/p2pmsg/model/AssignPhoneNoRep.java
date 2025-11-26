package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class AssignPhoneNoRep extends MsgBody {
    private String BSIP;
    private String BSPort;
    private String ProxyConnType;
    private String ProxyDomainName;
    private String ProxyIP;
    private String ProxyPort;
    private String SipID;
    private String SipPw;

    public String getSipID() {
        return this.SipID;
    }

    public void setSipID(String sipID) {
        this.SipID = sipID;
    }

    public String getSipPw() {
        return this.SipPw;
    }

    public void setSipPw(String sipPw) {
        this.SipPw = sipPw;
    }

    public String getProxyIP() {
        return this.ProxyIP;
    }

    public void setProxyIP(String proxyIP) {
        this.ProxyIP = proxyIP;
    }

    public String getProxyPort() {
        return this.ProxyPort;
    }

    public void setProxyPort(String proxyPort) {
        this.ProxyPort = proxyPort;
    }

    public String getProxyDomainName() {
        return this.ProxyDomainName;
    }

    public void setProxyDomainName(String proxyDomainName) {
        this.ProxyDomainName = proxyDomainName;
    }

    public String getProxyConnType() {
        return this.ProxyConnType;
    }

    public void setProxyConnType(String proxyConnType) {
        this.ProxyConnType = proxyConnType;
    }

    public String getBSIP() {
        return this.BSIP;
    }

    public void setBSIP(String bSIP) {
        this.BSIP = bSIP;
    }

    public String getBSPort() {
        return this.BSPort;
    }

    public void setBSPort(String bSPort) {
        this.BSPort = bSPort;
    }
}
