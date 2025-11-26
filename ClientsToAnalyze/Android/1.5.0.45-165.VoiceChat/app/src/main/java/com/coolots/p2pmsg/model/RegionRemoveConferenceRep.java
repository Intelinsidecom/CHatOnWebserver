package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes.dex */
public class RegionRemoveConferenceRep extends MsgBody {
    public static final String RESULT_FAIL = "0";
    public static final String RESULT_SUCCESS = "1";
    private short ConnectCount;
    private Date EndTime;
    private String Result;

    public short getConnectCount() {
        return this.ConnectCount;
    }

    public void setConnectCount(short connectCount) {
        this.ConnectCount = connectCount;
    }

    public void setConnectCount(int connectCount) {
        this.ConnectCount = (short) connectCount;
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

    public void setEndTime(String endDate) throws ParseException {
        setEndTime(DateTimeUtil.changeFormat(endDate, "yyyy-MM-dd HH:mm:ss"));
    }

    public String getResult() {
        return this.Result;
    }

    public void setResult(String result) {
        this.Result = result;
    }
}
