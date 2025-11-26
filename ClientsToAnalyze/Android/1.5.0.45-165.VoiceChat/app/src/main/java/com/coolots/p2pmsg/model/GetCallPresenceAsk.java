package com.coolots.p2pmsg.model;

import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class GetCallPresenceAsk extends MsgBody {
    private Short DeviceID;

    @Size(max = 256, min = 1)
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
}
