package com.sds.coolots.call.model;

/* loaded from: classes.dex */
public class P2PUserInfo {
    public static final int STATE_CONNECTED = 1;
    public static final int STATE_DELETED = 3;
    public static final int STATE_DENY = 4;
    public static final int STATE_DISCONNECTED = 2;
    public static final int STATE_WAIT = 0;
    public static final int TYPE_HOST = 0;
    public static final int TYPE_PARTICIPANT = 1;
    public int callID;
    public int surfaceID;
    public String userID;
    public String userName;
    public int userState;
    public int userType;

    public P2PUserInfo() {
        this.userID = "";
        this.userName = "";
        this.userType = 1;
        this.userState = 0;
        this.callID = 0;
    }

    public P2PUserInfo(String str, String str2, int i, int i2, int i3) {
        this.userID = str;
        this.userName = str2;
        this.userType = i;
        this.userState = i2;
        this.callID = i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("userID:" + this.userID + ",");
        sb.append("userName:" + this.userName + ",");
        sb.append("userType:" + this.userType + ",");
        sb.append("userState:" + this.userState + ",");
        sb.append("callID:" + this.callID);
        return sb.toString();
    }
}
