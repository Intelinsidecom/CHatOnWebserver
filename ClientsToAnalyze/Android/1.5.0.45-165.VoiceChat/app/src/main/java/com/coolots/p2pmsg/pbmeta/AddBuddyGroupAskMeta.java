package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.BuddyGroupInfo;
import com.coolots.p2pmsg.model.BuddyGroupMapInfo;
import java.util.List;

/* loaded from: classes.dex */
public class AddBuddyGroupAskMeta extends ProtoBufMetaBase {
    public AddBuddyGroupAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("BuddyGroupInfo", 1, true, BuddyGroupInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MapList", 2, true, List.class, BuddyGroupMapInfo.class));
    }
}
