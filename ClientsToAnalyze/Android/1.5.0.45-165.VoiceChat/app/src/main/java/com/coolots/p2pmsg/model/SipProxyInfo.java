package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.IpOrDomain;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class SipProxyInfo {

    @IpOrDomain
    @NotNull
    private String ProxyAddr;

    @Max(65535)
    @Min(1)
    private int ProxyPort;

    public String getProxyAddr() {
        return this.ProxyAddr;
    }

    public void setProxyAddr(String proxyAddr) {
        this.ProxyAddr = proxyAddr;
    }

    public int getProxyPort() {
        return this.ProxyPort;
    }

    public void setProxyPort(int proxyPort) {
        this.ProxyPort = proxyPort;
    }
}
