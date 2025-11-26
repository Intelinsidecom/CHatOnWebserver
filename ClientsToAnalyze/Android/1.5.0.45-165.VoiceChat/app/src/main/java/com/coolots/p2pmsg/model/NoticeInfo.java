package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes.dex */
public class NoticeInfo {
    private String Content;
    private Date ExpireDate;
    private Date InsertDate;
    private int NoticeNo;
    private String Title;
    private Date UpdateDate;

    public int getNoticeNo() {
        return this.NoticeNo;
    }

    public void setNoticeNo(int noticeNo) {
        this.NoticeNo = noticeNo;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getContent() {
        return this.Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }

    public Date getInsertDate() {
        return this.InsertDate;
    }

    public void setInsertDate(Date insertDate) {
        if (insertDate instanceof Timestamp) {
            this.InsertDate = new Date(insertDate.getTime());
        } else {
            this.InsertDate = insertDate;
        }
    }

    public void setInsertDate(String insertDate) throws ParseException {
        setInsertDate(DateTimeUtil.changeFormat(insertDate, "yyyy-MM-dd HH:mm:ss"));
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

    public Date getExpireDate() {
        return this.ExpireDate;
    }

    public void setExpireDate(Date expireDate) {
        if (expireDate instanceof Timestamp) {
            this.ExpireDate = new Date(expireDate.getTime());
        } else {
            this.ExpireDate = expireDate;
        }
    }

    public void setExpireDate(String expireDate) throws ParseException {
        setExpireDate(DateTimeUtil.changeFormat(expireDate, "yyyy-MM-dd HH:mm:ss"));
    }
}
