package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class ConnToPushRegisterAsk extends MsgBody {
    private Integer ServerNo;
    private Integer ServerOrder;
    private String ServerType;

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
