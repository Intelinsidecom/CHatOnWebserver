package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class ConnToPushRegisterRep extends MsgBody {
    private int ErrorCode;
    private Integer ServerNo;
    private Integer ServerOrder;
    private String ServerType;

    public int getErrorCode() {
        return this.ErrorCode;
    }

    public void setErrorCode(int errorCode) {
        this.ErrorCode = errorCode;
    }

    public String getServerType() {
        return this.ServerType;
    }

    public void setServerType(String serverType) {
        this.ServerType = serverType;
    }

    public Integer getServerNo() {
        return this.ServerNo;
    }

    public void setServerNo(Integer serverNo) {
        this.ServerNo = serverNo;
    }

    public Integer getServerOrder() {
        return this.ServerOrder;
    }

    public void setServerOrder(Integer serverOrder) {
        this.ServerOrder = serverOrder;
    }
}
