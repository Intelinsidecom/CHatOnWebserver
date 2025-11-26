package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes.dex */
public class NoteInfo {
    private String Contents;
    private String FromUserID;
    private Date InsertDate;
    private String NoteNo;
    private String NoteType;

    public String getFromUserID() {
        return this.FromUserID;
    }

    public void setFromUserID(String fromUserID) {
        this.FromUserID = fromUserID;
    }

    public String getNoteNo() {
        return this.NoteNo;
    }

    public void setNoteNo(String noteNo) {
        this.NoteNo = noteNo;
    }

    public String getNoteType() {
        return this.NoteType;
    }

    public void setNoteType(String noteType) {
        this.NoteType = noteType;
    }

    public String getContents() {
        return this.Contents;
    }

    public void setContents(String contents) {
        this.Contents = contents;
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
}
