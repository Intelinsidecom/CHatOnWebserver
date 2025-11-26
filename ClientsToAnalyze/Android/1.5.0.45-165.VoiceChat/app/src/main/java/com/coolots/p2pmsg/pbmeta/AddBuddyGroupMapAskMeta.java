package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.BuddyGroupMapInfo;
import java.util.List;

/* loaded from: classes.dex */
public class AddBuddyGroupMapAskMeta extends ProtoBufMetaBase {
    public AddBuddyGroupMapAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("MapList", 1, true, List.class, BuddyGroupMapInfo.class));
    }
}
