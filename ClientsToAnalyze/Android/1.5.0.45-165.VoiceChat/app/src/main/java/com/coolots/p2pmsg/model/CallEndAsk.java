package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.text.ParseException;
import java.util.Date;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class CallEndAsk extends MsgBody {

    @Size(max = 43, min = 18)
    private String CdrID;
    private boolean IsCaller;
    private Date StartTime;

    public String getCdrID() {
        return this.CdrID;
    }

    public boolean getIsCaller() {
        return this.IsCaller;
    }

    public Date getStartTime() {
        return this.StartTime;
    }

    public void setCdrID(String cdrID) {
        this.CdrID = cdrID;
    }

    public void setIsCaller(boolean isCaller) {
        this.IsCaller = isCaller;
    }

    public void setStartTime(Date startTime) {
        this.StartTime = startTime;
    }

    public void setStartTime(String startDate) throws ParseException {
        setStartTime(DateTimeUtil.changeFormat(startDate, "yyyy-MM-dd HH:mm:ss"));
    }
}
