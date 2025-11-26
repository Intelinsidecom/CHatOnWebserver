package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class StunInfoRep extends MsgBody {

    /* renamed from: IP */
    private String f21IP;
    private int Port;

    public String getIP() {
        return this.f21IP;
    }

    public void setIP(String ipAddress) {
        this.f21IP = ipAddress;
    }

    public int getPort() {
        return this.Port;
    }

    public void setPort(int port) {
        this.Port = port;
    }
}
