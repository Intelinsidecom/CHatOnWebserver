package com.coolots.p2pmsg.pbmeta;

import java.util.Date;

/* loaded from: classes.dex */
public class DeleteImageRepMeta extends ProtoBufMetaBase {
    public DeleteImageRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UpdateDate", 1, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ImageType", 2, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("BuddyGroupCode", 3, true, Long.TYPE));
    }
}
