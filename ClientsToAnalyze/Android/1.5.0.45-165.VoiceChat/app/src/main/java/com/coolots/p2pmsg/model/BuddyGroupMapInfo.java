package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import javax.validation.constraints.Min;

/* loaded from: classes.dex */
public class BuddyGroupMapInfo {

    @Min(0)
    private long GroupCode;
    private Date UpdateDate;

    @Min(1)
    private long UserNo;

    public long getGroupCode() {
        return this.GroupCode;
    }

    public void setGroupCode(long groupCode) {
        this.GroupCode = groupCode;
    }

    public long getUserNo() {
        return this.UserNo;
    }

    public void setUserNo(long userNo) {
        this.UserNo = userNo;
    }

    public Date getUpdateDate() {
        return this.UpdateDate;
    }

    public void setUpdateDate(Date updateDate) {
        if (updateDate instanceof Timestamp) {
            this.UpdateDate = new Date(updateDate.getTime());
        } else {
            this.UpdateDate = updateDate;
        }
    }

    public void setUpdateDate(String updateDate) throws ParseException {
        setUpdateDate(DateTimeUtil.changeFormat(updateDate, "yyyy-MM-dd HH:mm:ss"));
    }
}
