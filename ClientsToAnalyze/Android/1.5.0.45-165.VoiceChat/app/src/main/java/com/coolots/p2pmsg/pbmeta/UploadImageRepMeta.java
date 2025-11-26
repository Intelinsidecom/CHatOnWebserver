package com.coolots.p2pmsg.pbmeta;

import java.util.Date;

/* loaded from: classes.dex */
public class UploadImageRepMeta extends ProtoBufMetaBase {
    public UploadImageRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ImageType", 1, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("UpdateDate", 2, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("BuddyGroupCode", 3, true, Long.TYPE));
    }
}
