package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RegionAddBuddyRep extends MsgBody {
    private List<BuddyResponseInfo> ResponseList = new ArrayList();

    public List<BuddyResponseInfo> getResponseList() {
        return this.ResponseList;
    }

    public void setResponseList(List<BuddyResponseInfo> responseList) {
        this.ResponseList = responseList;
    }
}
