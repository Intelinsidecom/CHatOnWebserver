package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class BuddyGroupInfo {

    @Min(0)
    private long GroupCode;
    private Date GroupImgUpdateDate;

    @NotNull
    @Size(max = 30, min = 1)
    private String GroupName;
    private Date UpdateDate;

    public long getGroupCode() {
        return this.GroupCode;
    }

    public void setGroupCode(long groupCode) {
        this.GroupCode = groupCode;
    }

    public String getGroupName() {
        return this.GroupName;
    }

    public void setGroupName(String groupName) {
        this.GroupName = groupName;
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

    public Date getGroupImgUpdateDate() {
        return this.GroupImgUpdateDate;
    }

    public void setGroupImgUpdateDate(Date groupImgUpdateDate) {
        if (groupImgUpdateDate instanceof Timestamp) {
            this.GroupImgUpdateDate = new Date(groupImgUpdateDate.getTime());
        } else {
            this.GroupImgUpdateDate = groupImgUpdateDate;
        }
    }

    public void setGroupImgUpdateDate(String groupImgUpdateDate) throws ParseException {
        setGroupImgUpdateDate(DateTimeUtil.changeFormat(groupImgUpdateDate, "yyyy-MM-dd HH:mm:ss"));
    }
}
