package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class StoreNoteAsk extends MsgBody {
    public static final String TYPE_ADD_MEMBER = "C";
    public static final String TYPE_REMOVE_MEMBER = "D";
    public static final String TYPE_SEND_NOTE = "A";
    public static final String TYPE_SEND_SUCCESS = "B";
    private String Contents;
    private String NoteNo;
    private String NoteType;
    private String RoomNo;
    private List<ToID> ToIDList = new ArrayList();

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

    public List<ToID> getToIDList() {
        return this.ToIDList;
    }

    public void setToIDList(List<ToID> toIDList) {
        this.ToIDList = toIDList;
    }
}
