package com.coolots.p2pmsg.pbmeta;

import java.util.Date;

/* loaded from: classes.dex */
public class BuddyGroupMapInfoMeta extends ProtoBufMetaBase {
    public BuddyGroupMapInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupCode", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 2, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("UpdateDate", 3, true, Date.class));
    }
}
