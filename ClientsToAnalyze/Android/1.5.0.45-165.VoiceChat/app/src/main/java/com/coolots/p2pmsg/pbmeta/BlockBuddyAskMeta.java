package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.BuddyInfo;
import java.util.List;

/* loaded from: classes.dex */
public class BlockBuddyAskMeta extends ProtoBufMetaBase {
    public BlockBuddyAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("BuddyInfoList", 1, true, List.class, BuddyInfo.class));
    }
}
