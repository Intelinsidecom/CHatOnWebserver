package com.coolots.p2pmsg.model;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

/* loaded from: classes.dex */
public class EnterRelayRegisterAsk extends MsgBody {

    @Size(max = 64, min = 1)
    private String AppId;
    private String AppVersion;

    @Size(max = 43, min = 18)
    private String CdrID;

    @Min(0)
    private Short CellularNetwork;

    @NotNull
    @Valid
    private P2PUserInfo DstUserInfo;

    @NotNull
    @Size(max = 100, min = 1)
    private String P2PKey;

    @NotNull
    @Size(max = 100, min = 1)
    private String PushKey;

    @Range(max = 32767, min = 1)
    private short ReceiverDeviceID;

    @NotNull
    @Size(max = 128, min = 1)
    private String ReceiverUserID;

    @Min(1)
    private long ReceiverUserNo;

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

    public long getReceiverUserNo() {
        return this.ReceiverUserNo;
    }

    public void setReceiverUserNo(long receiverUserNo) {
        this.ReceiverUserNo = receiverUserNo;
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

    public String getAppVersion() {
        return this.AppVersion;
    }

    public void setAppVersion(String appVersion) {
        this.AppVersion = appVersion;
    }

    public String getAppId() {
        return this.AppId;
    }

    public void setAppId(String AppId) {
        this.AppId = AppId;
    }
}
