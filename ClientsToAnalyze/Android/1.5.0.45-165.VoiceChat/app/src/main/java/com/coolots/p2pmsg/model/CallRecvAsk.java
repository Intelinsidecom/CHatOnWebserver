package com.coolots.p2pmsg.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class CallRecvAsk extends MsgBody {
    private String CdrID;
    private String ConnectionType;

    @NotNull
    private P2PUserInfo DstUserInfo;
    private String GroupCode;

    @NotNull
    @Size(max = 100, min = 1)
    private String P2PKey;

    @NotNull
    @Size(max = 100, min = 1)
    private String PushKey;

    @Max(32767)
    @NotNull
    @Min(1)
    private Short ReceiverDeviceID;

    @NotNull
    @Size(max = 256, min = 1)
    private String ReceiverUserID;

    @Max(32767)
    @NotNull
    @Min(1)
    private Short SenderDeviceID;

    @NotNull
    @Size(max = 256, min = 1)
    private String SenderUserID;

    @Min(1)
    private long SenderUserNo;

    public String getConnectionType() {
        return this.ConnectionType;
    }

    public Short getReceiverDeviceID() {
        return this.ReceiverDeviceID;
    }

    public void setReceiverDeviceID(Short receiverDeviceID) {
        this.ReceiverDeviceID = receiverDeviceID;
    }

    public void setReceiverDeviceID(int receiverDeviceID) {
        this.ReceiverDeviceID = Short.valueOf((short) receiverDeviceID);
    }

    public P2PUserInfo getDstUserInfo() {
        return this.DstUserInfo;
    }

    public String getP2PKey() {
        return this.P2PKey;
    }

    public void setConnectionType(String connectionType) {
        this.ConnectionType = connectionType;
    }

    public void setDstUserInfo(P2PUserInfo dstUserInfo) {
        this.DstUserInfo = dstUserInfo;
    }

    public void setP2PKey(String p2pKey) {
        this.P2PKey = p2pKey;
    }

    public long getSenderUserNo() {
        return this.SenderUserNo;
    }

    public String getSenderUserID() {
        return this.SenderUserID;
    }

    public Short getSenderDeviceID() {
        return this.SenderDeviceID;
    }

    public String getReceiverUserID() {
        return this.ReceiverUserID;
    }

    public String getPushKey() {
        return this.PushKey;
    }

    public String getCdrID() {
        return this.CdrID;
    }

    public String getGroupCode() {
        return this.GroupCode;
    }

    public void setSenderUserNo(long senderUserNo) {
        this.SenderUserNo = senderUserNo;
    }

    public void setSenderUserID(String senderUserID) {
        this.SenderUserID = senderUserID;
    }

    public void setSenderDeviceID(Short senderDeviceID) {
        this.SenderDeviceID = senderDeviceID;
    }

    public void setSenderDeviceID(int senderDeviceID) {
        this.SenderDeviceID = Short.valueOf((short) senderDeviceID);
    }

    public void setReceiverUserID(String receiverUserID) {
        this.ReceiverUserID = receiverUserID;
    }

    public void setPushKey(String pushKey) {
        this.PushKey = pushKey;
    }

    public void setCdrID(String cdrID) {
        this.CdrID = cdrID;
    }

    public void setGroupCode(String groupCode) {
        this.GroupCode = groupCode;
    }
}
