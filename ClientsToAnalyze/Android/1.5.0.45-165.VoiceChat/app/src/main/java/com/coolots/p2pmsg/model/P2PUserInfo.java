package com.coolots.p2pmsg.model;

import com.coolots.common.util.StringUtil;

/* loaded from: classes.dex */
public class P2PUserInfo {
    private Integer DeviceID;
    private Integer NetworkType;
    private String PrivateIP;
    private Integer PrivatePort;
    private String PublicIP;
    private Integer PublicPort;
    private String RelayServerIP;
    private Integer RelayServerPort;
    private String UserID;
    private Long UserNo;

    public String getUserID() {
        return this.UserID;
    }

    public void setUserID(String userID) {
        this.UserID = userID;
    }

    public Long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(Long userNo) {
        this.UserNo = userNo;
    }

    public Integer getDeviceID() {
        return this.DeviceID;
    }

    public void setDeviceID(Integer deviceID) {
        this.DeviceID = deviceID;
    }

    public Integer getNetworkType() {
        return this.NetworkType;
    }

    public void setNetworkType(Integer networkType) {
        this.NetworkType = networkType;
    }

    public String getPublicIP() {
        return this.PublicIP;
    }

    public void setPublicIP(String publicIP) {
        this.PublicIP = publicIP;
    }

    public Integer getPublicPort() {
        return this.PublicPort;
    }

    public void setPublicPort(Integer publicPort) {
        this.PublicPort = publicPort;
    }

    public String getPrivateIP() {
        return this.PrivateIP;
    }

    public void setPrivateIP(String privateIP) {
        this.PrivateIP = privateIP;
    }

    public Integer getPrivatePort() {
        return this.PrivatePort;
    }

    public void setPrivatePort(Integer privatePort) {
        this.PrivatePort = privatePort;
    }

    public String getRelayServerIP() {
        return this.RelayServerIP;
    }

    public void setRelayServerIP(String relayServerIP) {
        this.RelayServerIP = relayServerIP;
    }

    public Integer getRelayServerPort() {
        return this.RelayServerPort;
    }

    public void setRelayServerPort(Integer relayServerPort) {
        this.RelayServerPort = relayServerPort;
    }

    public String toString() {
        return StringUtil.classToString(this);
    }
}
