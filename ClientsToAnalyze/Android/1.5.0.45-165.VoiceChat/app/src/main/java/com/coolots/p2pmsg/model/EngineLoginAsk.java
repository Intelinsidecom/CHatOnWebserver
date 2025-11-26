package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class EngineLoginAsk extends MsgBody {
    private String NetType;
    private InetAddr PrivateAddr;

    public String getNetType() {
        return this.NetType;
    }

    public void setNetType(String netType) {
        this.NetType = netType;
    }

    public InetAddr getPrivateAddr() {
        return this.PrivateAddr;
    }

    public void setPrivateAddr(InetAddr privateAddr) {
        this.PrivateAddr = privateAddr;
    }
}
