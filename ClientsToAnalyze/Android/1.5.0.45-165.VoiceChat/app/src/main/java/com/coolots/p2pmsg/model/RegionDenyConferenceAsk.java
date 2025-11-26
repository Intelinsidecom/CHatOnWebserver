package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class RegionDenyConferenceAsk extends MsgBody {
    private Short CellularNetwork;
    private String ConferenceNo;
    private short DeviceId;
    private String GroupCode;
    private String PrivateIp;
    private String RejectedMessage;
    private String UserName;
    private long UserNo;

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
    }

    public String getGroupCode() {
        return this.GroupCode;
    }

    public void setGroupCode(String groupCode) {
        this.GroupCode = groupCode;
    }

    public long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(long userNo) {
        this.UserNo = userNo;
    }

    public short getDeviceId() {
        return this.DeviceId;
    }

    public void setDeviceId(short deviceId) {
        this.DeviceId = deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.DeviceId = (short) deviceId;
    }

    public String getPrivateIp() {
        return this.PrivateIp;
    }

    public void setPrivateIp(String privateIp) {
        this.PrivateIp = privateIp;
    }

    public String getUserName() {
        return this.UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getRejectedMessage() {
        return this.RejectedMessage;
    }

    public void setRejectedMessage(String rejectedMessage) {
        this.RejectedMessage = rejectedMessage;
    }

    public Short getCellularNetwork() {
        return this.CellularNetwork;
    }

    public void setCellularNetwork(Short cellularNetwork) {
        this.CellularNetwork = cellularNetwork;
    }

    public void setCellularNetwork(int cellularNetwork) {
        this.CellularNetwork = Short.valueOf((short) cellularNetwork);
    }
}
