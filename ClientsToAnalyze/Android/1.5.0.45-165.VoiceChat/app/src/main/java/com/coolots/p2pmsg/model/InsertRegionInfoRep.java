package com.coolots.p2pmsg.model;

import javax.validation.constraints.NotNull;

/* loaded from: classes.dex */
public class InsertRegionInfoRep extends MsgBody {

    @NotNull
    private RegionInfo RegionInfo;

    public RegionInfo getRegionInfo() {
        return this.RegionInfo;
    }

    public void setRegionInfo(RegionInfo regionInfo) {
        this.RegionInfo = regionInfo;
    }
}
