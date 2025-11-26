package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class P2PConnectAsk extends MsgBody {
    private String ConnectionType;
    private String P2PKey;
    private P2PUserInfo SrcUserInfo;

    public String getConnectionType() {
        return this.ConnectionType;
    }

    public void setConnectionType(String connectionType) {
        this.ConnectionType = connectionType;
    }

    public P2PUserInfo getSrcUserInfo() {
        return this.SrcUserInfo;
    }

    public void setSrcUserInfo(P2PUserInfo srcUserInfo) {
        this.SrcUserInfo = srcUserInfo;
    }

    public String getP2PKey() {
        return this.P2PKey;
    }

    public void setP2PKey(String p2pKey) {
        this.P2PKey = p2pKey;
    }
}
