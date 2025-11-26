package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.BuddyInfo;
import java.util.List;

/* loaded from: classes.dex */
public class RegionAddBuddySuggestionAskMeta extends ProtoBufMetaBase {
    public RegionAddBuddySuggestionAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("BuddyList", 1, true, List.class, BuddyInfo.class));
    }
}
