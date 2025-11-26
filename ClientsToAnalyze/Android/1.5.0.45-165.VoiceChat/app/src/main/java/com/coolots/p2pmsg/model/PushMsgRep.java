package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class PushMsgRep extends MsgBody {
    private int ErrorCode;
    private Short ToDeviceID;
    private String ToID;

    public String getToID() {
        return this.ToID;
    }

    public void setToID(String toID) {
        this.ToID = toID;
    }

    public Short getToDeviceID() {
        return this.ToDeviceID;
    }

    public void setToDeviceID(Short toDeviceID) {
        this.ToDeviceID = toDeviceID;
    }

    public void setToDeviceID(int toDeviceID) {
        this.ToDeviceID = Short.valueOf((short) toDeviceID);
    }

    public int getErrorCode() {
        return this.ErrorCode;
    }

    public void setErrorCode(int errorCode) {
        this.ErrorCode = errorCode;
    }
}
