package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes.dex */
public class ParticipantInfo {
    private Short CellularNetwork;
    private String ConfName;
    private short ConnectCount;
    private Short DeviceId;
    private int Duration;
    private Date EndTime;
    private String HoldYn;
    private String InviteUserId;
    private String MuteAudioYn;
    private String MuteVideoYn;
    private byte RegionCode;
    private String RejectedMessage;
    private String SipId;
    private Date StartTime;
    private int StatusCode;
    private String UserId;
    private String UserName;
    private long UserNo;
    private String UserType;

    public String getConfName() {
        return this.ConfName;
    }

    public void setConfName(String confName) {
        this.ConfName = confName;
    }

    public long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(long userNo) {
        this.UserNo = userNo;
    }

    public short getConnectCount() {
        return this.ConnectCount;
    }

    public void setConnectCount(short connectCount) {
        this.ConnectCount = connectCount;
    }

    public void setConnectCount(int connectCount) {
        this.ConnectCount = (short) connectCount;
    }

    public String getUserType() {
        return this.UserType;
    }

    public void setUserType(String userType) {
        this.UserType = userType;
    }

    public Short getDeviceId() {
        return this.DeviceId;
    }

    public void setDeviceId(Short deviceId) {
        this.DeviceId = deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.DeviceId = Short.valueOf(deviceId.shortValue());
    }

    public String getSipId() {
        return this.SipId;
    }

    public void setSipId(String sipId) {
        this.SipId = sipId;
    }

    public int getStatusCode() {
        return this.StatusCode;
    }

    public void setStatusCode(int statusCode) {
        this.StatusCode = statusCode;
    }

    public String getHoldYn() {
        return this.HoldYn;
    }

    public void setHoldYn(String holdYn) {
        this.HoldYn = holdYn;
    }

    public String getMuteVideoYn() {
        return this.MuteVideoYn;
    }

    public void setMuteVideoYn(String muteVideoYn) {
        this.MuteVideoYn = muteVideoYn;
    }

    public String getMuteAudioYn() {
        return this.MuteAudioYn;
    }

    public void setMuteAudioYn(String muteAudioYn) {
        this.MuteAudioYn = muteAudioYn;
    }

    public String getUserName() {
        return this.UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getUserId() {
        return this.UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
    }

    public byte getRegionCode() {
        return this.RegionCode;
    }

    public void setRegionCode(byte regionCode) {
        this.RegionCode = regionCode;
    }

    public void setRegionCode(int regionCode) {
        this.RegionCode = (byte) regionCode;
    }

    public Date getStartTime() {
        return this.StartTime;
    }

    public void setStartTime(Date startTime) {
        this.StartTime = startTime;
    }

    public void setStartTime(String startTime) throws ParseException {
        setStartTime(DateTimeUtil.changeFormat(startTime, "yyyy-MM-dd HH:mm:ss"));
    }

    public Date getEndTime() {
        return this.EndTime;
    }

    public void setEndTime(Date endTime) {
        this.EndTime = endTime;
    }

    public void setEndTime(String endTime) throws ParseException {
        setEndTime(DateTimeUtil.changeFormat(endTime, "yyyy-MM-dd HH:mm:ss"));
    }

    public int getDuration() {
        return this.Duration;
    }

    public void setDuration(int duration) {
        this.Duration = duration;
    }

    public Short getCellularNetwork() {
        return this.CellularNetwork;
    }

    public void setCellularNetwork(Short cellularNetwork) {
        this.CellularNetwork = cellularNetwork;
    }

    public void setCellularNetwork(Integer cellularNetwork) {
        this.CellularNetwork = Short.valueOf(cellularNetwork.shortValue());
    }

    public String getRejectedMessage() {
        return this.RejectedMessage;
    }

    public void setRejectedMessage(String rejectedMessage) {
        this.RejectedMessage = rejectedMessage;
    }

    public String getInviteUserId() {
        return this.InviteUserId;
    }

    public void setInviteUserId(String inviteUserId) {
        this.InviteUserId = inviteUserId;
    }
}
