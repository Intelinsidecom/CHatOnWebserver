package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes.dex */
public class RecommendContactsAsk extends MsgBody {
    private Date UpdateDate;

    public Date getUpdateDate() {
        return this.UpdateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.UpdateDate = updateDate;
    }

    public void setUpdateDate(String updateDate) throws ParseException {
        setUpdateDate(DateTimeUtil.changeFormat(updateDate, "yyyy-MM-dd HH:mm:ss"));
    }
}
