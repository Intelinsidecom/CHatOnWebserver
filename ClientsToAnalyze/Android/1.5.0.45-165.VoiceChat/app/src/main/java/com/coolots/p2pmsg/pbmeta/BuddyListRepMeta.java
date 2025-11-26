package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.BuddyGroupInfo;
import com.coolots.p2pmsg.model.BuddyGroupMapInfo;
import com.coolots.p2pmsg.model.BuddyInfo;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class BuddyListRepMeta extends ProtoBufMetaBase {
    public BuddyListRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("BuddyList", 1, true, List.class, BuddyInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupList", 2, true, List.class, BuddyGroupInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RemovedGroupList", 3, true, List.class, BuddyGroupInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MapList", 4, true, List.class, BuddyGroupMapInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RemovedMapList", 5, true, List.class, BuddyGroupMapInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UpdateDate", 6, true, Date.class));
    }
}
