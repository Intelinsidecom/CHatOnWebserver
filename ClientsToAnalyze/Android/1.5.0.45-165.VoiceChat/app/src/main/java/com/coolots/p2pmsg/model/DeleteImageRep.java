package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes.dex */
public class DeleteImageRep extends MsgBody {
    private long BuddyGroupCode;
    private int ImageType;
    private Date UpdateDate;

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

    public int getImageType() {
        return this.ImageType;
    }

    public void setImageType(int imageType) {
        this.ImageType = imageType;
    }

    public long getBuddyGroupCode() {
        return this.BuddyGroupCode;
    }

    public void setBuddyGroupCode(long buddyGroupCode) {
        this.BuddyGroupCode = buddyGroupCode;
    }
}
