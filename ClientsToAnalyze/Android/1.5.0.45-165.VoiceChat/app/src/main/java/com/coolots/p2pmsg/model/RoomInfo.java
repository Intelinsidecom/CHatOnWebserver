package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RoomInfo {
    private List<NoteInfo> NoteList = new ArrayList();
    private String RoomNo;

    public String getRoomNo() {
        return this.RoomNo;
    }

    public void setRoomNo(String roomNo) {
        this.RoomNo = roomNo;
    }

    public List<NoteInfo> getNoteList() {
        return this.NoteList;
    }

    public void setNoteList(List<NoteInfo> noteList) {
        this.NoteList = noteList;
    }
}
