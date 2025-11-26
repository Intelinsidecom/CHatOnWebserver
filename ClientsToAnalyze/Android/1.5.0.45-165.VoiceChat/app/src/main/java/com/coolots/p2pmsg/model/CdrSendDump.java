package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class CdrSendDump {
    private Date AnswerTime;

    @NotNull
    private String CallType;

    @NotNull
    private short CallerDeviceId;

    @NotNull
    private String CallerUserId;

    @NotNull
    private long CallerUserNo;

    @NotNull
    private String CdrId;

    @NotNull
    private int Duration;
    private Date EndTime;

    @NotNull
    private String GroupCode;
    private Integer Pdd;
    private String RelayYn;
    private Date StartTime;
    private Integer StatusCode;

    public String getCdrId() {
        return this.CdrId;
    }

    public void setCdrId(String cdrId) {
        this.CdrId = cdrId;
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
        if (answerTime instanceof Timestamp) {
            this.AnswerTime = new Date(answerTime.getTime());
        } else {
            this.AnswerTime = answerTime;
        }
    }

    public void setAnswerTime(String answerTime) throws ParseException {
        this.AnswerTime = DateTimeUtil.changeFormat(answerTime, "yyyy-MM-dd HH:mm:ss");
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
        this.EndTime = DateTimeUtil.changeFormat(endTime, "yyyy-MM-dd HH:mm:ss");
    }

    public Integer getPdd() {
        return this.Pdd;
    }

    public void setPdd(Integer pdd) {
        this.Pdd = pdd;
    }

    public int getDuration() {
        return this.Duration;
    }

    public void setDuration(int duration) {
        this.Duration = duration;
    }

    public String getCallType() {
        return this.CallType;
    }

    public void setCallType(String callType) {
        this.CallType = callType;
    }

    public String getGroupCode() {
        return this.GroupCode;
    }

    public void setGroupCode(String groupCode) {
        this.GroupCode = groupCode;
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
