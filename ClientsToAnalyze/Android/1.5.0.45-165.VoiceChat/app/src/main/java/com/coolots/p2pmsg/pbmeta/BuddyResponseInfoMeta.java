package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.BuddyInfo;

/* loaded from: classes.dex */
public class BuddyResponseInfoMeta extends ProtoBufMetaBase {
    public BuddyResponseInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("BuddyInfo", 1, true, BuddyInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ResponseCode", 2, true, Integer.TYPE));
    }
}
