package com.coolots.p2pmsg.model;

import com.coolots.p2pmsg.validator.Ip;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/* loaded from: classes.dex */
public class ClientToConnRegisterRep extends MsgBody {
    private int ErrorCode;

    @Ip
    private String PublicIP;

    @Max(65535)
    @Min(0)
    private Integer PublicPort;

    @Min(1)
    private long UserNo;

    public long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(long userNo) {
        this.UserNo = userNo;
    }

    public String getPublicIP() {
        return this.PublicIP;
    }

    public void setPublicIP(String publicIP) {
        this.PublicIP = publicIP;
    }

    public Integer getPublicPort() {
        return this.PublicPort;
    }

    public void setPublicPort(Integer publicPort) {
        this.PublicPort = publicPort;
    }

    public int getErrorCode() {
        return this.ErrorCode;
    }

    public void setErrorCode(int errorCode) {
        this.ErrorCode = errorCode;
    }
}
