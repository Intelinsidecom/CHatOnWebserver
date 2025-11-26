package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.BuddyResponseInfo;
import java.util.List;

/* loaded from: classes.dex */
public class AddBuddyRepMeta extends ProtoBufMetaBase {
    public AddBuddyRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ResponseList", 1, true, List.class, BuddyResponseInfo.class));
    }
}
