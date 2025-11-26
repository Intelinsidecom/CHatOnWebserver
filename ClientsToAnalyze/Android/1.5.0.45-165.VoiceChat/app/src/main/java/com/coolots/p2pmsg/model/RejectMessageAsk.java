package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RejectMessageAsk extends MsgBody {
    private Short DeviceID;
    private String RejectMessage;
    private String UserID;

    public String getUserID() {
        return this.UserID;
    }

    public void setUserID(String userID) {
        this.UserID = userID;
    }

    public Short getDeviceID() {
        return this.DeviceID;
    }

    public void setDeviceID(Short deviceID) {
        this.DeviceID = deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.DeviceID = Short.valueOf((short) deviceID);
    }

    public String getRejectMessage() {
        return this.RejectMessage;
    }

    public void setRejectMessage(String rejectMessage) {
        this.RejectMessage = rejectMessage;
    }
}
