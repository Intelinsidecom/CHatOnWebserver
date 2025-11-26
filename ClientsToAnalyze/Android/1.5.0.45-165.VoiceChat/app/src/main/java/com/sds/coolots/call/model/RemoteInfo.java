package com.sds.coolots.call.model;

/* loaded from: classes.dex */
public class RemoteInfo {
    public int index;
    public String sipID;
    public Object surface;
    public String userID;
    public String userName;

    public RemoteInfo() {
        this.index = -1;
        this.userID = "";
        this.userName = "";
        this.sipID = "";
        this.surface = null;
    }

    public RemoteInfo(int i, String str, String str2, String str3, Object obj) {
        this.index = i;
        this.userID = str;
        this.userName = str2;
        this.sipID = str3;
        this.surface = obj;
    }

    public int getIndex() {
        return this.index;
    }

    public String getSipID() {
        return this.sipID;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setSipID(String str) {
        this.sipID = str;
    }

    public void setSurface(Object obj) {
        this.surface = obj;
    }

    public void setUserID(String str) {
        this.userID = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("index:" + this.index + ",");
        sb.append("userID:" + this.userID + ",");
        sb.append("userName:" + this.userName + ",");
        sb.append("sipID:" + this.sipID);
        return sb.toString();
    }
}
