package com.coolots.p2pmsg.pbmeta;

import java.util.Date;

/* loaded from: classes.dex */
public class RegionRemoveConferenceRepMeta extends ProtoBufMetaBase {
    public RegionRemoveConferenceRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConnectCount", 1, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("EndTime", 2, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Result", 3, true, String.class));
    }
}
