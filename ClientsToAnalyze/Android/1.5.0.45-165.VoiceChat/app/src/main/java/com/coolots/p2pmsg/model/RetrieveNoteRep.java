package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RetrieveNoteRep extends MsgBody {
    private List<RoomInfo> RoomList = new ArrayList();

    public List<RoomInfo> getRoomList() {
        return this.RoomList;
    }

    public void setRoomList(List<RoomInfo> roomList) {
        this.RoomList = roomList;
    }
}
