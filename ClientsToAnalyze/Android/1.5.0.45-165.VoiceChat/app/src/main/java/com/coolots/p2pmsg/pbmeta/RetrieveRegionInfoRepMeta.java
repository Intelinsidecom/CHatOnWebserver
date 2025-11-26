package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.RegionInfo;
import java.util.List;

/* loaded from: classes.dex */
public class RetrieveRegionInfoRepMeta extends ProtoBufMetaBase {
    public RetrieveRegionInfoRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("RegionInfoList", 1, false, List.class, RegionInfo.class));
    }
}
