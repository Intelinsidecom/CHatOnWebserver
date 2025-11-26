package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class P2PConnectRep extends MsgBody {
    private String ConnectionType;
    private P2PUserInfo DstUserInfo;
    private String P2PKey;

    public String getConnectionType() {
        return this.ConnectionType;
    }

    public void setConnectionType(String connectionType) {
        this.ConnectionType = connectionType;
    }

    public P2PUserInfo getDstUserInfo() {
        return this.DstUserInfo;
    }

    public void setDstUserInfo(P2PUserInfo dstUserInfo) {
        this.DstUserInfo = dstUserInfo;
    }

    public String getP2PKey() {
        return this.P2PKey;
    }

    public void setP2PKey(String p2pKey) {
        this.P2PKey = p2pKey;
    }
}
