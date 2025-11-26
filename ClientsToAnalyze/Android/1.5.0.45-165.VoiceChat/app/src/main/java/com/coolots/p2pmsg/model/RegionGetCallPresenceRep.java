package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RegionGetCallPresenceRep extends MsgBody {
    public static final String PRESENCE_NO = "N";
    public static final String PRESENCE_YES = "Y";
    private Short DeviceID;
    private String Presence;
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

    public String getPresence() {
        return this.Presence;
    }

    public void setPresence(String presence) {
        this.Presence = presence;
    }
}
