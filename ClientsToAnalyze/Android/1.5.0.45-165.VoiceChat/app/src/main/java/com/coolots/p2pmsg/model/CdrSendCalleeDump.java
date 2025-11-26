package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class CdrSendCalleeDump {

    @NotNull
    private short CalleeDeviceId;

    @NotNull
    private String CalleeUserId;

    @NotNull
    private long CalleeUserNo;

    @NotNull
    private String CdrId;

    @NotNull
    private short ConnectCount;
    private Integer StatusCode;

    public String getCdrId() {
        return this.CdrId;
    }

    public void setCdrId(String cdrId) {
        this.CdrId = cdrId;
    }

    public long getCalleeUserNo() {
        return this.CalleeUserNo;
    }

    public void setCalleeUserNo(long calleeUserNo) {
        this.CalleeUserNo = calleeUserNo;
    }

    public String getCalleeUserId() {
        return this.CalleeUserId;
    }

    public void setCalleeUserId(String calleeUserId) {
        this.CalleeUserId = calleeUserId;
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

    public short getCalleeDeviceId() {
        return this.CalleeDeviceId;
    }

    public void setCalleeDeviceId(short calleeDeviceId) {
        this.CalleeDeviceId = calleeDeviceId;
    }

    public void setCalleeDeviceId(int calleeDeviceId) {
        this.CalleeDeviceId = (short) calleeDeviceId;
    }

    public Integer getStatusCode() {
        return this.StatusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.StatusCode = statusCode;
    }
}
