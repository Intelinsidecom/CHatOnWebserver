package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PartyInfoRep extends MsgBody {
    private List<PartyDeviceInfo> PartyDeviceInfoList = new ArrayList();
    private String PartyUserID;
    private long PartyUserNo;

    public String getPartyUserID() {
        return this.PartyUserID;
    }

    public void setPartyUserID(String partyUserID) {
        this.PartyUserID = partyUserID;
    }

    public long getPartyUserNo() {
        return this.PartyUserNo;
    }

    public void setPartyUserNo(long partyUserNo) {
        this.PartyUserNo = partyUserNo;
    }

    public List<PartyDeviceInfo> getPartyDeviceInfoList() {
        return this.PartyDeviceInfoList;
    }

    public void setPartyDeviceInfoList(List<PartyDeviceInfo> partyDeviceInfoList) {
        this.PartyDeviceInfoList = partyDeviceInfoList;
    }
}
