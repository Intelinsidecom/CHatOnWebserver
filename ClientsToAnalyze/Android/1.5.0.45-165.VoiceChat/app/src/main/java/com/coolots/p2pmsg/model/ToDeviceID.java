package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

/* loaded from: classes.dex */
public class ToDeviceID {
    private Integer StatusCode;

    @NotNull
    @Range(max = 32767, min = 1)
    private short ToDeviceID;

    public ToDeviceID() {
    }

    public ToDeviceID(short toDeviceID) {
        this.ToDeviceID = toDeviceID;
    }

    public short getToDeviceID() {
        return this.ToDeviceID;
    }

    public void setToDeviceID(short toDeviceID) {
        this.ToDeviceID = toDeviceID;
    }

    public void setToDeviceID(int toDeviceID) {
        this.ToDeviceID = (short) toDeviceID;
    }

    public Integer getStatusCode() {
        return this.StatusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.StatusCode = statusCode;
    }
}
