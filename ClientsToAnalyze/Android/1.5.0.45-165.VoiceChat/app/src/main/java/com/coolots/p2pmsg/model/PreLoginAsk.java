package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class PreLoginAsk extends MsgBody {
    private DeviceIDAsk DeviceIDAsk;
    private ServerInfoAsk ServerInfoAsk;

    public ServerInfoAsk getServerInfoAsk() {
        return this.ServerInfoAsk;
    }

    public void setServerInfoAsk(ServerInfoAsk serverInfoAsk) {
        this.ServerInfoAsk = serverInfoAsk;
    }

    public DeviceIDAsk getDeviceIDAsk() {
        return this.DeviceIDAsk;
    }

    public void setDeviceIDAsk(DeviceIDAsk deviceIDAsk) {
        this.DeviceIDAsk = deviceIDAsk;
    }
}
