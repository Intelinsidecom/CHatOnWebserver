package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class PreLoginRep extends MsgBody {
    private DeviceIDRep DeviceIDRep;
    private ServerInfoRep ServerInfoRep;

    public ServerInfoRep getServerInfoRep() {
        return this.ServerInfoRep;
    }

    public void setServerInfoRep(ServerInfoRep serverInfoRep) {
        this.ServerInfoRep = serverInfoRep;
    }

    public DeviceIDRep getDeviceIDRep() {
        return this.DeviceIDRep;
    }

    public void setDeviceIDRep(DeviceIDRep deviceIDRep) {
        this.DeviceIDRep = deviceIDRep;
    }
}
