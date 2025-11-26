package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RegionEnterSingleCallAsk extends MsgBody {
    private String CdrID;
    private Short CellularNetwork;
    private short ConnectCount;
    private P2PUserInfo DstUserInfo;
    private String P2PKey;
    private String PushKey;
    private short ReceiverDeviceID;
    private String ReceiverUserID;
    private long ReceiverUserNo;
    private short SenderDeviceID;
    private String SenderGroupCode;
    private String SenderUserID;
    private long SenderUserNo;

    public String getSenderUserID() {
        return this.SenderUserID;
    }

    public void setSenderUserID(String senderUserID) {
        this.SenderUserID = senderUserID;
    }

    public long getSenderUserNo() {
        return this.SenderUserNo;
    }

    public void setSenderUserNo(long senderUserNo) {
        this.SenderUserNo = senderUserNo;
    }

    public short getSenderDeviceID() {
        return this.SenderDeviceID;
    }

    public void setSenderDeviceID(short senderDeviceID) {
        this.SenderDeviceID = senderDeviceID;
    }

    public void setSenderDeviceID(int senderDeviceID) {
        this.SenderDeviceID = (short) senderDeviceID;
    }

    public short getConnectCount() {
        return this.ConnectCount;
    }

    public void setConnectCount(short connectCount) {
        this.ConnectCount = connectCount;
    }

    public void setConnectCount(int connectCount) {
        this.ConnectCount = (short) connectCount;
    }

    public String getSenderGroupCode() {
        return this.SenderGroupCode;
    }

    public void setSenderGroupCode(String senderGroupCode) {
        this.SenderGroupCode = senderGroupCode;
    }

    public String getReceiverUserID() {
        return this.ReceiverUserID;
    }

    public void setReceiverUserID(String receiverUserID) {
        this.ReceiverUserID = receiverUserID;
    }

    public long getReceiverUserNo() {
        return this.ReceiverUserNo;
    }

    public void setReceiverUserNo(long receiverUserNo) {
        this.ReceiverUserNo = receiverUserNo;
    }

    public short getReceiverDeviceID() {
        return this.ReceiverDeviceID;
    }

    public void setReceiverDeviceID(short receiverDeviceID) {
        this.ReceiverDeviceID = receiverDeviceID;
    }

    public void setReceiverDeviceID(int receiverDeviceID) {
        this.ReceiverDeviceID = (short) receiverDeviceID;
    }

    public String getPushKey() {
        return this.PushKey;
    }

    public void setPushKey(String pushKey) {
        this.PushKey = pushKey;
    }

    public String getP2PKey() {
        return this.P2PKey;
    }

    public void setP2PKey(String p2pKey) {
        this.P2PKey = p2pKey;
    }

    public P2PUserInfo getDstUserInfo() {
        return this.DstUserInfo;
    }

    public void setDstUserInfo(P2PUserInfo dstUserInfo) {
        this.DstUserInfo = dstUserInfo;
    }

    public String getCdrID() {
        return this.CdrID;
    }

    public void setCdrID(String cdrID) {
        this.CdrID = cdrID;
    }

    public Short getCellularNetwork() {
        return this.CellularNetwork;
    }

    public void setCellularNetwork(Short cellularNetwork) {
        this.CellularNetwork = cellularNetwork;
    }

    public void setCellularNetwork(int cellularNetwork) {
        this.CellularNetwork = Short.valueOf((short) cellularNetwork);
    }
}
