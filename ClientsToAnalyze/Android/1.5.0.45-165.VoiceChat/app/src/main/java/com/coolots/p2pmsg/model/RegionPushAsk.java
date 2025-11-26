package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RegionPushAsk extends MsgBody {
    private List<RegionPush> RegionPushList = new ArrayList();

    public List<RegionPush> getRegionPushList() {
        return this.RegionPushList;
    }

    public void setRegionPushList(List<RegionPush> regionPushList) {
        this.RegionPushList = regionPushList;
    }
}
