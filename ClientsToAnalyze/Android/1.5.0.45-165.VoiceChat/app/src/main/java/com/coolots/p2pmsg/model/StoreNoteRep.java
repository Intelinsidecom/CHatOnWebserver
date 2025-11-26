package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

/* loaded from: classes.dex */
public class StoreNoteRep extends MsgBody {
    private Date InsertDate;
    private String NoteNo;
    private String RoomNo;

    public String getRoomNo() {
        return this.RoomNo;
    }

    public void setRoomNo(String roomNo) {
        this.RoomNo = roomNo;
    }

    public String getNoteNo() {
        return this.NoteNo;
    }

    public void setNoteNo(String noteNo) {
        this.NoteNo = noteNo;
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
