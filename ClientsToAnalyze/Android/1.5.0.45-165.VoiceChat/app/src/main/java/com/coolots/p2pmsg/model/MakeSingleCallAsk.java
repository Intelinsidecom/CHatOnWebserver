package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.StringCase;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class MakeSingleCallAsk extends MsgBody {
    public static final String CALL_TYPE_SINGLE_AUDIO = "SA";
    public static final String CALL_TYPE_SINGLE_VIDEO = "SV";

    @Size(max = 64, min = 1)
    private String AppId;
    private String AppVersion;

    @Min(0)
    private Short CellularNetwork;

    @StringCase(caseArray = {CALL_TYPE_SINGLE_AUDIO, CALL_TYPE_SINGLE_VIDEO})
    @NotNull
    private String ConnectionType;

    @NotNull
    @Size(max = 100, min = 1)
    private String P2PKey;

    @NotNull
    @Size(max = 100, min = 1)
    private String PushKey;

    @NotNull
    @Size(max = 128, min = 1)
    private String ReceiverUserID;
    private P2PUserInfo SrcUserInfo;

    public String getReceiverUserID() {
        return this.ReceiverUserID;
    }

    public void setReceiverUserID(String receiverUserID) {
        this.ReceiverUserID = receiverUserID;
    }

    public String getConnectionType() {
        return this.ConnectionType;
    }

    public void setConnectionType(String connectionType) {
        this.ConnectionType = connectionType;
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

    public P2PUserInfo getSrcUserInfo() {
        return this.SrcUserInfo;
    }

    public void setSrcUserInfo(P2PUserInfo srcUserInfo) {
        this.SrcUserInfo = srcUserInfo;
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
