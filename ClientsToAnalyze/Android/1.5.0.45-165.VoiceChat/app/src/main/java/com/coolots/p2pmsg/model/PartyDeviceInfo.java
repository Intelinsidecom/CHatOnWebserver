package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class PartyDeviceInfo {
    private int DeviceID;
    private String NetworkType;
    private String PrivateIP;
    private Integer PrivatePort;
    private String PublicIP;
    private Integer PublicPort;
    private String RelayServerIP;
    private Integer RelayServerPort;
    private String RelayType;

    public int getDeviceID() {
        return this.DeviceID;
    }

    public void setDeviceID(int deviceID) {
        this.DeviceID = deviceID;
    }

    public String getNetworkType() {
        return this.NetworkType;
    }

    public void setNetworkType(String networkType) {
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

    public String getRelayType() {
        return this.RelayType;
    }

    public void setRelayType(String relayType) {
        this.RelayType = relayType;
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
}
