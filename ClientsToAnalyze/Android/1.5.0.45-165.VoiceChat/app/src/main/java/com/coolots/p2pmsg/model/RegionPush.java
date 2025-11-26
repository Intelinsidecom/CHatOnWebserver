package com.coolots.p2pmsg.model;

import com.google.protobuf.ByteString;

/* loaded from: classes.dex */
public class RegionPush {
    private Short DeviceID;
    private String GroupCode;
    private ByteString PushMsgBody;
    private ByteString PushMsgHeader;
    private String PushType;
    private String UserID;

    public String getGroupCode() {
        return this.GroupCode;
    }

    public void setGroupCode(String groupCode) {
        this.GroupCode = groupCode;
    }

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

    public String getPushType() {
        return this.PushType;
    }

    public void setPushType(String pushType) {
        this.PushType = pushType;
    }

    public ByteString getPushMsgHeader() {
        return this.PushMsgHeader;
    }

    public void setPushMsgHeader(ByteString pushMsgHeader) {
        this.PushMsgHeader = pushMsgHeader;
    }

    public ByteString getPushMsgBody() {
        return this.PushMsgBody;
    }

    public void setPushMsgBody(ByteString pushMsgBody) {
        this.PushMsgBody = pushMsgBody;
    }
}
