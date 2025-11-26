package com.coolots.p2pmsg.pbmeta;

import java.util.Date;

/* loaded from: classes.dex */
public class CallEndAskMeta extends ProtoBufMetaBase {
    public CallEndAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("IsCaller", 2, true, Boolean.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("StartTime", 3, true, Date.class));
    }
}
