package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.BuddyGroupMapInfo;
import com.coolots.p2pmsg.model.BuddyInfo;
import java.util.List;

/* loaded from: classes.dex */
public class HideBuddyRepMeta extends ProtoBufMetaBase {
    public HideBuddyRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("BuddyList", 1, true, List.class, BuddyInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RemovedMapList", 2, true, List.class, BuddyGroupMapInfo.class));
    }
}
