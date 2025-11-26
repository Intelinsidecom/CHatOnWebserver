package com.coolots.p2pmsg.pbmeta;

import java.util.Date;

/* loaded from: classes.dex */
public class BuddyGroupInfoMeta extends ProtoBufMetaBase {
    public BuddyGroupInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupCode", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupName", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UpdateDate", 3, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupImgUpdateDate", 4, true, Date.class));
    }
}
