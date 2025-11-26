package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.ToID;
import java.util.List;

/* loaded from: classes.dex */
public class RetrieveRegionInfoAskMeta extends ProtoBufMetaBase {
    public RetrieveRegionInfoAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("IDList", 1, false, List.class, ToID.class));
    }
}
