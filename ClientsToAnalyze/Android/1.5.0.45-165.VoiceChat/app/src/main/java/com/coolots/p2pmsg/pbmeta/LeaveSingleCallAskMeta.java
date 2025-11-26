package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class LeaveSingleCallAskMeta extends ProtoBufMetaBase {
    public LeaveSingleCallAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("CdrID", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Caller", 2, true, Boolean.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("RelayYn", 3, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("StatusCode", 4, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PDD", 5, true, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CalleeDeviceID", 6, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConnectionType", 7, false, String.class));
    }
}
