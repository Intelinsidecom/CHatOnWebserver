package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CancelBuddyRequestRep extends MsgBody {
    private List<ToID> ToIDList = new ArrayList();

    public List<ToID> getToIDList() {
        return this.ToIDList;
    }

    public void setToIDList(List<ToID> toIDList) {
        this.ToIDList = toIDList;
    }
}
