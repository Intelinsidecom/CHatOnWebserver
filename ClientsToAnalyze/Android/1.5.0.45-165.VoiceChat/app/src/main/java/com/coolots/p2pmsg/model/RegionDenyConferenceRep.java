package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class RegionDenyConferenceRep extends MsgBody {
    private short CallerDeviceId;
    private String CallerUserId;
    private long CallerUserNo;
    private short ConnectCount;

    @NotNull
    private Date StartTime;
    private ConferenceInfo conferenceInfo;

    public ConferenceInfo getConferenceInfo() {
        return this.conferenceInfo;
    }

    public void setConferenceInfo(ConferenceInfo conferenceInfo) {
        this.conferenceInfo = conferenceInfo;
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

    public void setStartTime(String startDate) throws ParseException {
        setStartTime(DateTimeUtil.changeFormat(startDate, "yyyy-MM-dd HH:mm:ss"));
    }
}
