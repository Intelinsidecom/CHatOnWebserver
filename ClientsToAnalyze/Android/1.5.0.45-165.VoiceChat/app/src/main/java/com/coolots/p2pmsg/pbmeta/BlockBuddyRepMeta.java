package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.BuddyGroupMapInfo;
import com.coolots.p2pmsg.model.BuddyInfo;
import java.util.List;

/* loaded from: classes.dex */
public class BlockBuddyRepMeta extends ProtoBufMetaBase {
    public BlockBuddyRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("BuddyInfoList", 1, true, List.class, BuddyInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RemovedMapList", 2, true, List.class, BuddyGroupMapInfo.class));
    }
}
