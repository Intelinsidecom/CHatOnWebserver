package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.RegionDomainInfo;
import java.util.List;

/* loaded from: classes.dex */
public class RegionDomainInfoRepMeta extends ProtoBufMetaBase {
    public RegionDomainInfoRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("RegionDomainInfoList", 1, true, List.class, RegionDomainInfo.class));
    }
}
