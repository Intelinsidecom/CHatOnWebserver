package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.BuddyInfo;
import java.util.List;

/* loaded from: classes.dex */
public class RegionAutoBuddyRepMeta extends ProtoBufMetaBase {
    public RegionAutoBuddyRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("BuddyInfoList", 1, true, List.class, BuddyInfo.class));
    }
}
