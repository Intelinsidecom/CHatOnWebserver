package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class RegionSubCloseConferenceAsk extends MsgBody {
    private String ConferenceNo;
    private int Duration;
    private Date EndTime;
    private List<SimpleUserInfo> WaitUserInfoList = new ArrayList();

    public String getConferenceNo() {
        return this.ConferenceNo;
    }

    public void setConferenceNo(String conferenceNo) {
        this.ConferenceNo = conferenceNo;
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

    public List<SimpleUserInfo> getWaitUserInfoList() {
        return this.WaitUserInfoList;
    }

    public void setWaitUserInfoList(List<SimpleUserInfo> waitUserInfoList) {
        this.WaitUserInfoList = waitUserInfoList;
    }
}
