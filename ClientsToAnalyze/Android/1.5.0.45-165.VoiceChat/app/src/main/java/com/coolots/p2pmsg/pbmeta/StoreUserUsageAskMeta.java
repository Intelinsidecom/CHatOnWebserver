package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.UsageInfo;
import java.util.List;

/* loaded from: classes.dex */
public class StoreUserUsageAskMeta extends ProtoBufMetaBase {
    public StoreUserUsageAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UsageInfoList", 1, true, List.class, UsageInfo.class));
    }
}
