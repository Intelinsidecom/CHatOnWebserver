package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.BuddyInfo;
import com.coolots.p2pmsg.model.ProfileInfo;
import java.util.List;

/* loaded from: classes.dex */
public class RegionAddBuddyAskMeta extends ProtoBufMetaBase {
    public RegionAddBuddyAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ProfileInfo", 1, true, ProfileInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("BuddyList", 2, true, List.class, BuddyInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SamsungAccountID", 3, true, String.class));
    }
}
