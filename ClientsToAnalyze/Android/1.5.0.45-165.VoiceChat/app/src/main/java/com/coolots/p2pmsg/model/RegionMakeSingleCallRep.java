package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RegionMakeSingleCallRep extends MsgBody {
    private Boolean Blocked;
    private long ReceiverUserNo;
    private List<ToDeviceID> ToDeviceIDList = new ArrayList();

    public List<ToDeviceID> getToDeviceIDList() {
        return this.ToDeviceIDList;
    }

    public void setToDeviceIDList(List<ToDeviceID> toDeviceIDList) {
        this.ToDeviceIDList = toDeviceIDList;
    }

    public long getReceiverUserNo() {
        return this.ReceiverUserNo;
    }

    public void setReceiverUserNo(long receiverUserNo) {
        this.ReceiverUserNo = receiverUserNo;
    }

    public Boolean getBlocked() {
        return this.Blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.Blocked = blocked;
    }
}
