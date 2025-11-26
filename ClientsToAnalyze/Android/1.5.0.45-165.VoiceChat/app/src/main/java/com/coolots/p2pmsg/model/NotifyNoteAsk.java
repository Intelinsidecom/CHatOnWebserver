package com.coolots.p2pmsg.model;

/* loaded from: classes.dex */
public class NotifyNoteAsk extends MsgBody {
    private Long NoteNo;
    private String RoomNo;

    public String getRoomNo() {
        return this.RoomNo;
    }

    public void setRoomNo(String roomNo) {
        this.RoomNo = roomNo;
    }

    public Long getNoteNo() {
        return this.NoteNo;
    }

    public void setNoteNo(Long noteNo) {
        this.NoteNo = noteNo;
    }
}
