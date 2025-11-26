package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.RegionPush;
import java.util.List;

/* loaded from: classes.dex */
public class RegionPushAskMeta extends ProtoBufMetaBase {
    public RegionPushAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("RegionPushList", 1, true, List.class, RegionPush.class));
    }
}
