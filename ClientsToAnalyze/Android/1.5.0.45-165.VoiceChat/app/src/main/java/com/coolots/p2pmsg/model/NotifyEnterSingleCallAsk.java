package com.coolots.p2pmsg.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class NotifyEnterSingleCallAsk extends MsgBody {

    @NotNull
    private P2PUserInfo DstUserInfo;

    @NotNull
    @Size(max = 100, min = 1)
    private String P2PKey;

    @Max(32767)
    @Min(1)
    private short ReceiverDeviceID;

    @NotNull
    @Size(max = 256, min = 1)
    private String ReceiverUserID;

    @Max(32767)
    @Min(1)
    private short SenderDeviceID;

    @NotNull
    @Size(max = 256, min = 1)
    private String SenderUserID;

    @Min(1)
    private long SenderUserNo;

    public long getSenderUserNo() {
        return this.SenderUserNo;
    }

    public void setSenderUserNo(long senderUserNo) {
        this.SenderUserNo = senderUserNo;
    }

    public String getSenderUserID() {
        return this.SenderUserID;
    }

    public void setSenderUserID(String senderUserID) {
        this.SenderUserID = senderUserID;
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

    public String getReceiverUserID() {
        return this.ReceiverUserID;
    }

    public void setReceiverUserID(String receiverUserID) {
        this.ReceiverUserID = receiverUserID;
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
