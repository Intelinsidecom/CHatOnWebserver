package com.coolots.p2pmsg.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class RegionDomainInfoRep extends MsgBody {
    private List<RegionDomainInfo> RegionDomainInfoList = new ArrayList();

    public List<RegionDomainInfo> getRegionDomainInfoList() {
        return this.RegionDomainInfoList;
    }

    public void setRegionDomainInfoList(List<RegionDomainInfo> regionDomainInfoList) {
        this.RegionDomainInfoList = regionDomainInfoList;
    }
}
