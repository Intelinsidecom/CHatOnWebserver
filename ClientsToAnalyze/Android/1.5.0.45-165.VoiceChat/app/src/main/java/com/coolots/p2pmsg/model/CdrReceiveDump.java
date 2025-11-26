package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class CdrReceiveDump {

    @NotNull
    private Date AnswerTime;

    @NotNull
    private short CalleeDeviceId;

    @NotNull
    private String CalleeUserId;

    @NotNull
    private long CalleeUserNo;

    @NotNull
    private short CallerDeviceId;

    @NotNull
    private String CallerUserId;

    @NotNull
    private long CallerUserNo;

    @NotNull
    private String CdrId;

    @NotNull
    private short ConnectCount;

    @NotNull
    private int Duration;

    @NotNull
    private Date EndTime;
    private String RelayYn;

    @NotNull
    private Date StartTime;
    private Integer StatusCode;

    public String getCdrId() {
        return this.CdrId;
    }

    public void setCdrId(String cdrId) {
        this.CdrId = cdrId;
    }

    public long getCalleeUserNo() {
        return this.CalleeUserNo;
    }

    public void setCalleeUserNo(long calleeUserNo) {
        this.CalleeUserNo = calleeUserNo;
    }

    public String getCalleeUserId() {
        return this.CalleeUserId;
    }

    public void setCalleeUserId(String calleeUserId) {
        this.CalleeUserId = calleeUserId;
    }

    public short getCalleeDeviceId() {
        return this.CalleeDeviceId;
    }

    public void setCalleeDeviceId(short calleeDeviceId) {
        this.CalleeDeviceId = calleeDeviceId;
    }

    public void setCalleeDeviceId(int calleeDeviceId) {
        this.CalleeDeviceId = (short) calleeDeviceId;
    }

    public long getCallerUserNo() {
        return this.CallerUserNo;
    }

    public void setCallerUserNo(long callerUserNo) {
        this.CallerUserNo = callerUserNo;
    }

    public String getCallerUserId() {
        return this.CallerUserId;
    }

    public void setCallerUserId(String callerUserId) {
        this.CallerUserId = callerUserId;
    }

    public short getCallerDeviceId() {
        return this.CallerDeviceId;
    }

    public void setCallerDeviceId(short callerDeviceId) {
        this.CallerDeviceId = callerDeviceId;
    }

    public void setCallerDeviceId(int callerDeviceId) {
        this.CallerDeviceId = (short) callerDeviceId;
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

    public Date getStartTime() {
        return this.StartTime;
    }

    public void setStartTime(Date startTime) {
        if (startTime instanceof Timestamp) {
            this.StartTime = new Date(startTime.getTime());
        } else {
            this.StartTime = startTime;
        }
    }

    public void setStartTime(String startTime) throws ParseException {
        setStartTime(DateTimeUtil.changeFormat(startTime, "yyyy-MM-dd HH:mm:ss"));
    }

    public Date getAnswerTime() {
        return this.AnswerTime;
    }

    public void setAnswerTime(Date answerTime) {
        if (this.AnswerTime instanceof Timestamp) {
            this.AnswerTime = new Date(answerTime.getTime());
        } else {
            this.AnswerTime = answerTime;
        }
    }

    public void setAnswerTime(String answerTime) throws ParseException {
        setAnswerTime(DateTimeUtil.changeFormat(answerTime, "yyyy-MM-dd HH:mm:ss"));
    }

    public Date getEndTime() {
        return this.EndTime;
    }

    public void setEndTime(Date endTime) {
        if (endTime instanceof Timestamp) {
            this.EndTime = new Date(endTime.getTime());
        } else {
            this.EndTime = endTime;
        }
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

    public String getRelayYn() {
        return this.RelayYn;
    }

    public void setRelayYn(String relayYn) {
        this.RelayYn = relayYn;
    }

    public Integer getStatusCode() {
        return this.StatusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.StatusCode = statusCode;
    }
}
