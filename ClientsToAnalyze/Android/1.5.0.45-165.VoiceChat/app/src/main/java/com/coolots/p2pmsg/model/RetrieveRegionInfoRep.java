package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* loaded from: classes.dex */
public class RetrieveRegionInfoRep extends MsgBody {

    @NotNull
    @Valid
    @Size(min = 0)
    private List<RegionInfo> RegionInfoList = new ArrayList();

    public List<RegionInfo> getRegionInfoList() {
        return this.RegionInfoList;
    }

    public void setRegionInfoList(List<RegionInfo> regionInfoList) {
        this.RegionInfoList = regionInfoList;
    }
}
